package just_4_guys.groupproj;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class ClassFragmentActivity extends Activity {
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        showFragment();
    }

    protected void showFragment() {
        Intent intent = getIntent();
        position = intent.getIntExtra("Position", 0);

        if(position == 0) {
            getFragmentManager().beginTransaction()
                    .replace(android.R.id.content, new BarbarianFragment())
                    .commit();
        }
        else if(position == 1) {
            getFragmentManager().beginTransaction()
                    .replace(android.R.id.content, new BardFragment())
                    .commit();
        }
        else if(position == 2) {
            getFragmentManager().beginTransaction()
                    .replace(android.R.id.content, new ClericFragment())
                    .commit();
        }
        else if(position == 3) {
            getFragmentManager().beginTransaction()
                    .replace(android.R.id.content, new DruidFragment())
                    .commit();
        }
        else if(position == 4) {
            getFragmentManager().beginTransaction()
                    .replace(android.R.id.content, new FighterFragment())
                    .commit();
        }else if(position == 5) {
            getFragmentManager().beginTransaction()
                    .replace(android.R.id.content, new MonkFragment())
                    .commit();
        }else if(position == 6) {
            getFragmentManager().beginTransaction()
                    .replace(android.R.id.content, new PaladinFragment())
                    .commit();
        }else if(position == 7) {
            getFragmentManager().beginTransaction()
                    .replace(android.R.id.content, new RangerFragment())
                    .commit();
        }else if(position == 8) {
            getFragmentManager().beginTransaction()
                    .replace(android.R.id.content, new RogueFragment())
                    .commit();
        }else if(position == 9) {
            getFragmentManager().beginTransaction()
                    .replace(android.R.id.content, new SorcererFragment())
                    .commit();
        }else if(position == 10) {
            getFragmentManager().beginTransaction()
                    .replace(android.R.id.content, new WarlockFragment())
                    .commit();
        }else if(position == 11) {
            getFragmentManager().beginTransaction()
                    .replace(android.R.id.content, new WizardFragment())
                    .commit();
        }
    }
}
