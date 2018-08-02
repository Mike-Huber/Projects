package just_4_guys.groupproj;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import com.google.gson.Gson;

public class CharacterSheetActivity extends Activity implements View.OnClickListener {
    private SharedPreferences savedValues;
    Spinner classSpinner, raceSpinner;
    EditText name, level, str, str_mod, dex, dex_mod, con, con_mod, intel, intel_mod, wis, wis_mod;
    ArrayAdapter<CharSequence> classAdapter, raceAdapter;
    Button newChar, saveChar, loadChar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.character_sheet);

        savedValues = getSharedPreferences("SavedValues", MODE_PRIVATE);

        classSpinner = (Spinner) findViewById(R.id.character_sheet_class_spinner);
        raceSpinner = (Spinner) findViewById(R.id.character_sheet_race_spinner);
        classAdapter = ArrayAdapter.createFromResource(this, R.array.classes, android.R.layout.simple_spinner_item);
        raceAdapter = ArrayAdapter.createFromResource(this, R.array.races, android.R.layout.simple_spinner_item);
        classAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        raceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        classSpinner.setAdapter(classAdapter);
        raceSpinner.setAdapter(raceAdapter);

        name = (EditText) findViewById(R.id.character_sheet_name_edittext);
        level = (EditText) findViewById(R.id.character_sheet_level_edittext);
        str = (EditText) findViewById(R.id.character_sheet_stats_str_edittext);
        str_mod = (EditText) findViewById(R.id.character_sheet_stats_str_mod_edittext);
        dex = (EditText) findViewById(R.id.character_sheet_stats_dex_edittext);
        dex_mod = (EditText) findViewById(R.id.character_sheet_stats_dex_mod_edittext);
        con = (EditText) findViewById(R.id.character_sheet_stats_con_edittext);
        con_mod = (EditText) findViewById(R.id.character_sheet_stats_con_mod_edittext);
        intel = (EditText) findViewById(R.id.character_sheet_stats_int_edittext);
        intel_mod = (EditText) findViewById(R.id.character_sheet_stats_int_mod_edittext);
        wis = (EditText) findViewById(R.id.character_sheet_stats_wis_edittext);
        wis_mod = (EditText) findViewById(R.id.character_sheet_stats_wis_mod_edittext);

        newChar = (Button) findViewById(R.id.character_sheet_button_newButton);
        saveChar = (Button) findViewById(R.id.character_sheet_button_saveButton);
        loadChar = (Button) findViewById(R.id.character_sheet_button_loadButton);
        newChar.setOnClickListener(this);
        saveChar.setOnClickListener(this);
        loadChar.setOnClickListener(this);

        if (savedValues.getString("char_json", null) != null)
            loadCharacter();
    }

    @Override
    public void onClick(View v) {
        if (v == newChar) {
            name.setText("");
            level.setText("");
            classSpinner.setSelection(0);
            raceSpinner.setSelection(0);
            str.setText("");
            str_mod.setText("");
            dex.setText("");
            dex_mod.setText("");
            con.setText("");
            con_mod.setText("");
            intel.setText("");
            intel_mod.setText("");
            wis.setText("");
            wis_mod.setText("");
        }
        else if (v == saveChar) {
            saveCharacter();
        }
        else if (v == loadChar) {
            loadCharacter();
        }
    }

    public void saveCharacter() {
        String nm = name.getText().toString();
        int lvl = Integer.parseInt(level.getText().toString());
        String chrClass = classSpinner.getSelectedItem().toString();
        String rc = raceSpinner.getSelectedItem().toString();
        int s = Integer.parseInt(str.getText().toString());
        int sm = Integer.parseInt(str_mod.getText().toString());
        int d = Integer.parseInt(dex.getText().toString());
        int dm = Integer.parseInt(dex_mod.getText().toString());
        int c = Integer.parseInt(con.getText().toString());
        int cm = Integer.parseInt(con_mod.getText().toString());
        int i = Integer.parseInt(intel.getText().toString());
        int im = Integer.parseInt(intel_mod.getText().toString());
        int w = Integer.parseInt(wis.getText().toString());
        int wm = Integer.parseInt(wis_mod.getText().toString());

        Character character = new Character(nm, lvl, chrClass, rc, s, sm, d, dm, c, cm, i, im, w, wm);

        Gson gson = new Gson();
        String charString = gson.toJson(character);

        SharedPreferences.Editor spe = savedValues.edit();
        spe.putString("char_json", charString);
        spe.commit();
    }

    public void loadCharacter() {
        String charString = savedValues.getString("char_json", null);

        if (charString != null) {
            Gson gson = new Gson();
            Character character = gson.fromJson(charString, Character.class);

            name.setText(character.getName());
            level.setText(String.valueOf(character.getLevel()));
            switch (character.getChar_class()) {
                case "Barbarian":
                    classSpinner.setSelection(0);
                    break;
                case "Bard":
                    classSpinner.setSelection(1);
                    break;
                case "Cleric":
                    classSpinner.setSelection(2);
                    break;
                case "Druid":
                    classSpinner.setSelection(3);
                    break;
                case "Fighter":
                    classSpinner.setSelection(4);
                    break;
                case "Monk":
                    classSpinner.setSelection(5);
                    break;
                case "Paladin":
                    classSpinner.setSelection(6);
                    break;
                case "Ranger":
                    classSpinner.setSelection(7);
                    break;
                case "Rogue":
                    classSpinner.setSelection(8);
                    break;
                case "Sorcerer":
                    classSpinner.setSelection(9);
                    break;
                case "Warlock":
                    classSpinner.setSelection(10);
                    break;
                case "Wizard":
                    classSpinner.setSelection(11);
                    break;
                default:
                    classSpinner.setSelection(0);
                    break;
            }
            switch (character.getRace()) {
                case "Dwarf":
                    raceSpinner.setSelection(0);
                    break;
                case "Elf":
                    raceSpinner.setSelection(1);
                    break;
                case "Halfling":
                    raceSpinner.setSelection(2);
                    break;
                case "Human":
                    raceSpinner.setSelection(3);
                    break;
                case "Dragonborn":
                    raceSpinner.setSelection(4);
                    break;
                default:
                    raceSpinner.setSelection(0);
                    break;
            }
            str.setText(String.valueOf(character.getStr()));
            str_mod.setText(String.valueOf(character.getStr_mod()));
            dex.setText(String.valueOf(character.getDex()));
            dex_mod.setText(String.valueOf(character.getDex_mod()));
            con.setText(String.valueOf(character.getCon()));
            con_mod.setText(String.valueOf(character.getCon_mod()));
            intel.setText(String.valueOf(character.getIntel()));
            intel_mod.setText(String.valueOf(character.getIntel_mod()));
            wis.setText(String.valueOf(character.getWis()));
            wis_mod.setText(String.valueOf(character.getWis_mod()));
        }
    }
}