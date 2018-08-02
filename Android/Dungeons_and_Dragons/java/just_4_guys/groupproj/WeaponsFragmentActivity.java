package just_4_guys.groupproj;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class WeaponsFragmentActivity extends Activity {
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        position = intent.getIntExtra("Position", 0);
        showFragment(position);
    }

    protected void showFragment(int position) {
        Bundle args = new Bundle();
        args.putInt("Position", position);
        WeaponFragment newFragment = new WeaponFragment();
        newFragment.setArguments(args);

        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, newFragment)
                .commit();
        /////getFragmentManager().beginTransaction().replace(R.id.content_frame, new WeaponFragment()).commit();
//        if(position == 0) {
//            getFragmentManager().beginTransaction()
//                    .replace(android.R.id.content, new DwarfFragment())
//                    .commit();
//        }
//        else if(position == 1) {
//            getFragmentManager().beginTransaction()
//                    .replace(android.R.id.content, new ElfFragment())
//                    .commit();
//        }
    }
}
