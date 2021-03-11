package com.example.evaluaciondemoviles;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.evaluaciondemoviles.Adapter.AdapterRevistas;
import com.example.evaluaciondemoviles.WebServices.Asynchtask;
import com.example.evaluaciondemoviles.WebServices.WebService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity  implements Asynchtask {

    ArrayList<Revistas> revistasList = new ArrayList<>();
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.idListRevistas);
        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("https://revistas.uteq.edu.ec/ws/journals.php", datos, this, this);
        ws.execute("");
    }

    @Override
    public void processFinish(String result) throws JSONException {

        JSONArray revistasJS=  new JSONArray(result);
        for (int i = 0; i<revistasJS.length();i++)
        {
            Revistas revistas = new Revistas();
            revistas.setName(revistasJS.getJSONObject(i).getString("name"));
            revistas.setJournal_id(revistasJS.getJSONObject(i).getString("journal_id"));
            revistas.setDescripccion(revistasJS.getJSONObject(i).getString("description"));
            revistas.setAbbreviation(revistasJS.getJSONObject(i).getString("abbreviation"));
            revistas.setJournalThumbnail(revistasJS.getJSONObject(i).getString("journalThumbnail"));
            revistas.setPortada(revistasJS.getJSONObject(i).getString("portada"));
            revistasList.add(revistas);
        }
        AdapterRevistas adapterBusiness = new AdapterRevistas(MainActivity.this, (ArrayList<Revistas>) revistasList);
        listView.setAdapter(adapterBusiness);


    }
}