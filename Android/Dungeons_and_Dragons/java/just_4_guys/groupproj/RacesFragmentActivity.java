package just_4_guys.groupproj;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class RacesFragmentActivity extends Activity {
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
                    .replace(android.R.id.content, new DwarfFragment())
                    .commit();
        }
        else if(position == 1) {
            getFragmentManager().beginTransaction()
                    .replace(android.R.id.content, new ElfFragment())
                    .commit();
        }
        else if(position == 2) {
            getFragmentManager().beginTransaction()
                    .replace(android.R.id.content, new HalflingFragment())
                    .commit();
        }
        else if(position == 3) {
            getFragmentManager().beginTransaction()
                    .replace(android.R.id.content, new HumanFragment())
                    .commit();
        }
        else if(position == 4) {
            getFragmentManager().beginTransaction()
                    .replace(android.R.id.content, new DragonbornFragment())
                    .commit();
        }
    }
}
