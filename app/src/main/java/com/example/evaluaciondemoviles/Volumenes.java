package com.example.evaluaciondemoviles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.evaluaciondemoviles.Holder.HolderVolumen;
import com.example.evaluaciondemoviles.Model.VolumenesModel;
import com.example.evaluaciondemoviles.WebServices.Asynchtask;
import com.example.evaluaciondemoviles.WebServices.WebService;
import com.mindorks.placeholderview.PlaceHolderView;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

public class Volumenes extends AppCompatActivity implements Asynchtask {
    String id = "";
    PlaceHolderView listViewVolumenes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volumenes);
        id = (String) getIntent().getExtras().get("id");
        listViewVolumenes = findViewById(R.id.idListVolumenes);
        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("https://revistas.uteq.edu.ec/ws/issues.php?j_id="+id, datos, this, this);
        ws.execute("");
    }

    @Override
    public void processFinish(String result) throws JSONException {
        JSONArray VolumenesJS=  new JSONArray(result);
        for (int i = 0; i<VolumenesJS.length();i++)
        {
            VolumenesModel volumenesModel = new VolumenesModel();
            volumenesModel.setVolume(VolumenesJS.getJSONObject(i).getString("volume"));
            volumenesModel.setNumber(VolumenesJS.getJSONObject(i).getString("number"));
            volumenesModel.setDate_published(VolumenesJS.getJSONObject(i).getString("date_published"));
            volumenesModel.setDoi(VolumenesJS.getJSONObject(i).getString("doi"));
            volumenesModel.setIssue_id(VolumenesJS.getJSONObject(i).getString("issue_id"));
            volumenesModel.setTitle(VolumenesJS.getJSONObject(i).getString("title"));
            volumenesModel.setYear(VolumenesJS.getJSONObject(i).getString("year"));
            volumenesModel.setCover(VolumenesJS.getJSONObject(i).getString("cover"));
            listViewVolumenes.addView(new HolderVolumen(getApplicationContext(),volumenesModel));

        }
     //  AdapterVolumenes adapterBusiness = new AdapterVolumenes(Volumenes.this, (ArrayList<VolumenesModel>) volumenesModelsList);
       // listViewVolumenes.setAdapter(adapterBusiness);
    }
}