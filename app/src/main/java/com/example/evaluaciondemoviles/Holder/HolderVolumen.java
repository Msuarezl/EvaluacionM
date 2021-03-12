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

import java.util.ArrayList;
import java.util.List;
@Animate(Animate.CARD_TOP_IN_DESC)
@NonReusable
@Layout(R.layout.layout_listvolumenes)
public class HolderVolumen {

    @View(R.id.idListVolumenes)
    PlaceHolderView mPlaceHolderView;
    @View(R.id.imaPortadaVolumen)
    ImageView Importada;
    @View(R.id.idVolumen)
    TextView TextVolumen;
    @View(R.id.idNumber)
    TextView TxtNumber;
    @View(R.id.idyear)
    TextView TxtYear;
    @View(R.id.iddatapublisher)
    TextView Txtdtpublisher;
    @View(R.id.iddoi)
    TextView TxtDoi;

    @Click(R.id.liVolumen)
    public void clicItemVolumen(){
        mcontext.startActivity(new Intent(mcontext, Articulos.class).putExtra("id",volumeneslist.getIssue_id()));

    }

    VolumenesModel volumeneslist;
    Context mcontext;

    public HolderVolumen(Context context,VolumenesModel volumenes) {
        this.mcontext = context;
        this.volumeneslist = volumenes;

    }
    @Resolve
    public void onResolved() {

        this.TextVolumen.setText(volumeneslist.getVolume());
        this.TxtNumber.setText(volumeneslist.getNumber());
        this.TxtYear.setText(volumeneslist.getYear());
        this.Txtdtpublisher.setText(volumeneslist.getDate_published());
        this.TxtDoi.setText(volumeneslist.getDoi());
        Glide.with(mcontext).load(volumeneslist.getCover()).into(Importada);



    }
}
