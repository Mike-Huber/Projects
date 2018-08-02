package just_4_guys.groupproj;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//Updated 4/26/2017 4:54PM
public class MainActivity extends Activity
        implements Button.OnClickListener {

    private Button racesButton, classesButton, equipmentButton, weaponsButton, armorButton,
            diceButton, characterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        racesButton = (Button) findViewById(R.id.button_races);
        classesButton = (Button) findViewById(R.id.button_classes);
        equipmentButton = (Button) findViewById(R.id.button_equipment);
        weaponsButton = (Button) findViewById(R.id.button_weapons);
        armorButton = (Button) findViewById(R.id.button_armor);
        diceButton = (Button) findViewById(R.id.button_dice);
        characterButton = (Button) findViewById(R.id.button_character_sheet);

        racesButton.setOnClickListener(this);
        classesButton.setOnClickListener(this);
        equipmentButton.setOnClickListener(this);
        weaponsButton.setOnClickListener(this);
        armorButton.setOnClickListener(this);
        diceButton.setOnClickListener(this);
        characterButton.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button_races) {
            startActivity(new Intent(this, RacesActivity.class));
        }
        else if(v.getId() == R.id.button_classes) {
            startActivity(new Intent(this, ClassActivity.class));
            System.out.println("Classes button clicked");
        }
        else if(v.getId() == R.id.button_equipment) {
            startActivity(new Intent(this, EquipmentActivity.class));
        }
        else if(v.getId() == R.id.button_weapons) {
            startActivity(new Intent(this, WeaponsActivity.class));
            System.out.println("Weapons button clicked");
        }
        else if(v.getId() == R.id.button_armor) {
            startActivity(new Intent(this, ArmorActivity.class));
            System.out.println("Armor button clicked");
        }
        else if(v.getId() == R.id.button_dice) {
            startActivity(new Intent(MainActivity.this, rollerActivity.class));

        }
        else if(v.getId() == R.id.button_character_sheet) {
            startActivity(new Intent(this, CharacterSheetActivity.class));
        }
    }
}
