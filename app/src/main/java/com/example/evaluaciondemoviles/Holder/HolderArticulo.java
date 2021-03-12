package com.example.evaluaciondemoviles.Holder;
import android.content.Context;
import android.content.Intent;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.evaluaciondemoviles.Articulos;
import com.example.evaluaciondemoviles.MainActivity;
import com.example.evaluaciondemoviles.Model.VolumenesModel;
import com.example.evaluaciondemoviles.R;
import com.example.evaluaciondemoviles.Volumenes;
import com.mindorks.placeholderview.PlaceHolderView;
import com.mindorks.placeholderview.annotations.Animate;
import com.mindorks.placeholderview.annotations.Click;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.NonReusable;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


@Animate(Animate.CARD_TOP_IN_DESC)
@NonReusable
@Layout(R.layout.layout_articulo)
public class HolderArticulo {
    @View(R.id.idTituloArt)
    TextView TextTitulo;
    @View(R.id.idAutores)
    TextView TextAutores;
    Context mcontext;
    JSONObject jsonObject;


    @Click(R.id.iddescargar)
    public void clicItemVolumen(){
       // mcontext.startActivity(new Intent(mcontext, Articulos.class).putExtra("id",volumeneslist.getIssue_id()));

    }

    public HolderArticulo(Context mcontext, JSONObject jsonObject) {
        this.mcontext = mcontext;
        this.jsonObject = jsonObject;
    }
    @Resolve
    public void onResolved() {

        try {
            this.TextTitulo.setText(jsonObject.getString("title"));
            this.TextAutores.setText(autoresResult(jsonObject));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    private String autoresResult(JSONObject object)
    {
        String Autores = "";
        try {
            JSONArray jsonArray = jsonObject.getJSONArray("authors");
            for(int i=0;i<jsonArray.length();i++)
            {
                Autores +="Nombre"+jsonArray.getJSONObject(i).getString("name")+
                "Filiacion"+jsonArray.getJSONObject(i).getString("filiacion");

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return Autores;
    }
}
