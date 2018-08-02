package just_4_guys.groupproj;

import android.app.Activity;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class rollerActivity extends Activity implements OnItemSelectedListener{
    Spinner diceType;
    String chosenDie;
    EditText DiceNumber;
    EditText ModNumber;
    Button Roller;
    TextView rolledField;
    TextView rolledField2;
    int numDice;
    int diceSides;
    int rolledNumber;
    int modNum = 0;
    boolean attackRollFlag = false;
    boolean percentileFlag = false;
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roller);

        diceType = (Spinner) findViewById(R.id.typeSpinner);
        DiceNumber = (EditText) findViewById(R.id.numberOfDice);
        Roller = (Button) findViewById(R.id.rollButton);
        rolledField = (TextView) findViewById(R.id.rolledNumber);
        rolledField2 = (TextView) findViewById(R.id.rolledNumber2);
        ModNumber = (EditText) findViewById(R.id.modifierField);
        final Random r = new Random();

        ArrayAdapter<CharSequence> typeAdapter = ArrayAdapter.createFromResource(this, R.array.Dice_Types, android.R.layout.simple_spinner_item);
        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        diceType.setAdapter(typeAdapter);
        diceType.setOnItemSelectedListener(this);
        mp = MediaPlayer.create(this, R.raw.disc1);

        Roller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(DiceNumber.getText().length() != 0) {
                    mp.start();
                    if(diceSides == 20 && Integer.parseInt(DiceNumber.getText().toString()) == 1){
                        attackRollFlag = true;
                    }

                    if(ModNumber.getText().length() != 0){
                        modNum = Integer.parseInt(ModNumber.getText().toString());
                    }
                    else {modNum=0;}


                    rolledNumber = 0;
                    numDice = Integer.parseInt(DiceNumber.getText().toString());
                    for(int i = 0; i<numDice; i++) {
                        rolledNumber += r.nextInt(diceSides) + 1;
                    }

                    if(attackRollFlag && rolledNumber == 20){
                        rolledField.setTextColor(Color.GREEN);
                        rolledField2.setText("");
                        Toast.makeText(getApplicationContext(), "Critical!", Toast.LENGTH_SHORT).show();
                    }

                    else if(attackRollFlag && rolledNumber == 1){
                        rolledField.setTextColor(Color.RED);
                        rolledField2.setText("");
                        Toast.makeText(getApplicationContext(), "Critical Fail!", Toast.LENGTH_SHORT).show();
                    }

                    else{
                        rolledField2.setText(Integer.toString(rolledNumber));
                        rolledNumber += modNum;
                        rolledField.setTextColor(Color.BLACK);

                    }
                    rolledField.setText(Integer.toString(rolledNumber));
                }
                else{
                    Toast.makeText(getApplicationContext(), "Enter Number of Dice", Toast.LENGTH_SHORT).show();
                }
            }
        });




    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        chosenDie = (diceType.getSelectedItem().toString());

        switch (position){
            case 0: diceSides = 2; break;
            case 1: diceSides = 4; break;
            case 2: diceSides = 6; break;
            case 3: diceSides = 8; break;
            case 4: diceSides = 10; break;
            case 5: diceSides = 12; break;
            case 6: diceSides = 20; break;
            case 7: diceSides = 100; break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }



}
