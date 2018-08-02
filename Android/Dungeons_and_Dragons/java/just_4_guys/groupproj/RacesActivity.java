package just_4_guys.groupproj;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class RacesActivity extends Activity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.races_listview);

        listView = (ListView) findViewById(R.id.races_listview);
        Gson gson = new Gson();

        List<Race> races = gson.fromJson(loadJsonFromAsset(), new TypeToken<List<Race>>(){}.getType());
        ArrayAdapter<Race> racesArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, races);
        listView.setAdapter(racesArrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0) {
                    startActivity(new Intent(RacesActivity.this, RacesFragmentActivity.class)
                    .putExtra("Position", 0));
                }
                else if(position == 1) {
                    startActivity(new Intent(RacesActivity.this, RacesFragmentActivity.class)
                    .putExtra("Position", 1));
                }
                else if(position == 2) {
                    startActivity(new Intent(RacesActivity.this, RacesFragmentActivity.class)
                            .putExtra("Position", 2));
                }
                else if(position == 3) {
                    startActivity(new Intent(RacesActivity.this, RacesFragmentActivity.class)
                            .putExtra("Position", 3));
                }
                else if(position == 4) {
                    startActivity(new Intent(RacesActivity.this, RacesFragmentActivity.class)
                            .putExtra("Position", 4));
                }
            }
        });
    }

    String loadJsonFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("races.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException io) {
            System.out.println("Error: File not found");
        }

        return json;
    }
}