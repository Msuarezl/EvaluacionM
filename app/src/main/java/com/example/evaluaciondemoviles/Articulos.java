package com.example.evaluaciondemoviles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.evaluaciondemoviles.Holder.HolderArticulo;
import com.example.evaluaciondemoviles.Holder.HolderVolumen;
import com.example.evaluaciondemoviles.WebServices.Asynchtask;
import com.example.evaluaciondemoviles.WebServices.WebService;
import com.mindorks.placeholderview.PlaceHolderView;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

public class Articulos extends AppCompatActivity implements Asynchtask {
String id ;
PlaceHolderView listArticulos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articulos);
        id = getIntent().getExtras().getString("id");
        listArticulos = findViewById(R.id.listArticulos);
        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("https://revistas.uteq.edu.ec/ws/pubs.php?i_id="+id, datos, this, this);
        ws.execute("");
    }

    @Override
    public void processFinish(String result) throws JSONException {
        JSONArray VolumenesJS=  new JSONArray(result);
        for(int i=0;i<VolumenesJS.length();i++)
        {
            listArticulos.addView(new HolderArticulo(getApplicationContext(),VolumenesJS.getJSONObject(i)));

        }

    }
}