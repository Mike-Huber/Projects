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

public class EquipmentActivity extends Activity{
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.equipment_listview);

        listView = (ListView) findViewById(R.id.equipment_listview);
        Gson gson = new Gson();

        List<Equipment> equipment = gson.fromJson(loadJsonFromAsset(),
                new TypeToken<List<Equipment>>(){}.getType());
        ArrayAdapter<Equipment> equipmentArrayAdapter = new ArrayAdapter<Equipment>(this,
                android.R.layout.simple_list_item_1, equipment);
        listView.setAdapter(equipmentArrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(EquipmentActivity.this, EquipmentFragmentActivity.class)
                .putExtra("Position", position));
            }
        });
    }

    String loadJsonFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("equipment.json");
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