"""
    Routes
    ~~~~~~
"""
from flask import Blueprint
from flask import flash
from flask import redirect
from flask import render_template
from flask import request
from flask import url_for
from flask_login import current_user
from flask_login import login_required
from flask_login import login_user
from flask_login import logout_user

from wiki.core import Processor
from wiki.web.forms import EditorForm
from wiki.web.forms import LoginForm
from wiki.web.forms import SearchForm
from wiki.web.forms import URLForm
from wiki.web import current_wiki
from wiki.web import current_users
from wiki.web.user import protect

from wiki.web.user import UserManager


bp = Blueprint('wiki', __name__)


@bp.route('/')
@protect
def home():
    page = current_wiki.get('home')
    if page:
        return display('home')
    return render_template('home.html')


@bp.route('/index/')
@protect
def index():
    pages = current_wiki.index()
    return render_template('index.html', pages=pages)


@bp.route('/<path:url>/')
@protect
def display(url):
    page = current_wiki.get_or_404(url)
    return render_template('page.html', page=page)


@bp.route('/create/', methods=['GET', 'POST'])
@protect
def create():
    form = URLForm()
    if form.validate_on_submit():
        return redirect(url_for(
            'wiki.edit', url=form.clean_url(form.url.data)))
    return render_template('create.html', form=form)


@bp.route('/edit/<path:url>/', methods=['GET', 'POST'])
@protect
def edit(url):
    page = current_wiki.get(url)
    form = EditorForm(obj=page)
    if form.validate_on_submit():
        if not page:
            page = current_wiki.get_bare(url)
        form.populate_obj(page)
        page.save()
        flash('"%s" was saved.' % page.title, 'success')
        return redirect(url_for('wiki.display', url=url))
    return render_template('editor.html', form=form, page=page)


@bp.route('/preview/', methods=['POST'])
@protect
def preview():
    data = {}
    processor = Processor(request.form['body'])
    data['html'], data['body'], data['meta'] = processor.process()
    return data['html']


@bp.route('/move/<path:url>/', methods=['GET', 'POST'])
@protect
def move(url):
    page = current_wiki.get_or_404(url)
    form = URLForm(obj=page)
    if form.validate_on_submit():
        newurl = form.url.data
        current_wiki.move(url, newurl)
        return redirect(url_for('wiki.display', url=newurl))
    return render_template('move.html', form=form, page=page)


@bp.route('/delete/<path:url>/')
@protect
def delete(url):
    page = current_wiki.get_or_404(url)
    current_wiki.delete(url)
    flash('Page "%s" was deleted.' % page.title, 'success')
    return redirect(url_for('wiki.home'))


@bp.route('/tags/')
@protect
def tags():
    tags = current_wiki.get_tags()
    return render_template('tags.html', tags=tags)


@bp.route('/tag/<string:name>/')
@protect
def tag(name):
    tagged = current_wiki.index_by_tag(name)
    return render_template('tag.html', pages=tagged, tag=name)


@bp.route('/search/', methods=['GET', 'POST'])
@protect
def search():
    form = SearchForm()
    if form.validate_on_submit():
        results = current_wiki.search(form.term.data, form.ignore_case.data)
        return render_template('search.html', form=form,
                               results=results, search=form.term.data)
    return render_template('search.html', form=form, search=None)


@bp.route('/user/login/', methods=['GET', 'POST'])
def user_login():
    form = LoginForm()
    if form.validate_on_submit():
        user = current_users.get_user(form.name.data)
        login_user(user)
        user.set('authenticated', True)
        flash('Login successful.', 'success')
        if request.args.get('next') == '/user/logout/':
            return redirect(url_for('wiki.home'))
        else:
            return redirect(request.args.get("next") or url_for('wiki.home'))
    return render_template('login.html', form=form)


@bp.route('/user/logout/')
@login_required
def user_logout():
    if not current_user:
        return
    else:
        current_user.set('authenticated', False)
        logout_user()
        flash('Logout successful.', 'success')
        return redirect(url_for('wiki.index'))


"""
    Error Handlers
    ~~~~~~~~~~~~~~
"""


@bp.errorhandler(404)
def page_not_found(error):
    return render_template('404.html'), 404


"""
    Implementations
"""


@bp.route('/calendar/', methods=['GET', 'POST'])
@protect
def calendar():
    return render_template('calendar.html')


@bp.route('/settings/')
@protect
def settings():
    return render_template('settings.html')


@bp.route('/user_add/', methods=['GET', 'POST'])
def user_create():
    user = UserManager('')
    if request.method == 'GET':
        return render_template('user_add.html')
    elif request.method == 'POST':
        username = request.form['username']
        password = request.form['password']
        if not username:
            flash('Username cannot be blank!', 'failure')
        elif not password:
            flash('Password cannot be blank!', 'failure')
        else:
            user.add_user(username, password)
            if user.get_user(username):
                print user.get_user(username).name
                flash('Created user successfully', 'success')
            else:
                flash('Error creating user, try again', 'failure')
        return render_template('settings.html')
    else:
        flash('Something went horribly wrong, redirected to home page.', 'failure')
        return render_template('home.html')


@bp.route('/user_delete/', methods=['GET', 'POST'])
def delete_user():
    user = UserManager('')
    if request.method == 'GET':
        return render_template('user_delete.html')
    elif request.method == 'POST':
        username = request.form['username']
        if not user.get_user(username):
            flash('Deleted user successfully', 'success')
            user.delete_user(username)
        else:
            flash('Error deleting user', 'failure')
        return render_template('settings.html')
    else:
        flash('Something went horribly wrong, redirected to home page.', 'failure')
        return render_template('home.html')
