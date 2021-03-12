package com.example.evaluaciondemoviles.Holder;
import android.content.Context;
import android.content.Intent;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;



import com.bumptech.glide.Glide;
import com.example.evaluaciondemoviles.Model.Revistas;
import com.example.evaluaciondemoviles.R;
import com.example.evaluaciondemoviles.Volumenes;
import com.mindorks.placeholderview.PlaceHolderView;
import com.mindorks.placeholderview.annotations.Animate;
import com.mindorks.placeholderview.annotations.Click;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.NonReusable;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

import java.util.ArrayList;
import java.util.List;
@Animate(Animate.CARD_TOP_IN_DESC)
@NonReusable
@Layout(R.layout.layout_listart)
public class RevistasHolder {


    @View(R.id.idListRevistas)
    PlaceHolderView mPlaceHolderView;

    @View(R.id.imaPortada)
    ImageView Importada;
    @View(R.id.idcontenido)
    TextView Textdescripccion;
    @View(R.id.idTitulo)
    TextView TxtName;

    @Click(R.id.liPrincipal)
    public void clicItem(){
        mContext.startActivity(new Intent(mContext, Volumenes.class).putExtra("id",revistasList.getJournal_id()));

    }

    Revistas revistasList = new Revistas();

    private Context mContext;

    public RevistasHolder(Context context, Revistas revistas) {
        this.revistasList = revistas;
        this.mContext = context;
    }

    @Resolve
    public void onResolved() {

          this.TxtName.setText(revistasList.getName());
          this.Textdescripccion.setText(Html.fromHtml(revistasList.getDescripccion()));
          Glide.with(mContext).load(revistasList.getPortada()).into(Importada);



    }

    }

