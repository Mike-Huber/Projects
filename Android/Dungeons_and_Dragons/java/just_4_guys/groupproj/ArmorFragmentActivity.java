package just_4_guys.groupproj;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class ArmorFragmentActivity extends Activity {

    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.armor_relativelayout);

        Intent intent = getIntent();
        position = intent.getIntExtra("Position", 0);

        showFragment(position);
    }

    protected void showFragment(int position) {
        Bundle args = new Bundle();
        args.putInt("Position", position);
        ArmorFragment newFragment = new ArmorFragment();
        newFragment.setArguments(args);

        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, newFragment)
                .commit();
    }
}