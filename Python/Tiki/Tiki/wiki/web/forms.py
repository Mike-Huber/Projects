"""
    Forms
    ~~~~~
"""
from flask_wtf import Form, RecaptchaField
from wtforms import BooleanField
from wtforms import TextField
from wtforms import TextAreaField
from wtforms import PasswordField
from wtforms.validators import InputRequired
from wtforms.validators import ValidationError


from wiki.core import clean_url
from wiki.web import current_wiki
from wiki.web import current_users

from django import forms


class URLForm(Form):
    url = TextField('', [InputRequired()])

    def validate_url(form, field):
        if current_wiki.exists(field.data):
            raise ValidationError('The URL "%s" exists already.' % field.data)

    def clean_url(self, url):
        return clean_url(url)


class SearchForm(Form):
    term = TextField('', [InputRequired()])
    ignore_case = BooleanField(
        description='Ignore Case',
        # FIXME: default is not correctly populated
        default=True)


class EditorForm(Form):
    title = TextField('', [InputRequired()])
    body = TextAreaField('', [InputRequired()])
    tags = TextField('')
    recaptcha = RecaptchaField()


class LoginForm(Form):

    #name = TextField('', validators = [InputRequired()])
    #password = PasswordField('', validators = [InputRequired()])
    name = TextField('', [InputRequired()], render_kw={"placeholder": "Password"})
    password = PasswordField('', [InputRequired()], render_kw={"placeholder": "Username"})
    recaptcha = RecaptchaField()

    def validate_name(form, field):
        user = current_users.get_user(field.data)
        if not user:
            raise ValidationError('This username does not exist.')

    def validate_password(form, field):
        user = current_users.get_user(form.name.data)
        if not user:
            return
        if not user.check_password(field.data):
            raise ValidationError('Username and password do not match.')


class AddUserForm(forms.Form):
    username = forms.CharField(max_length=256)
    password = forms.CharField(max_length=128)
