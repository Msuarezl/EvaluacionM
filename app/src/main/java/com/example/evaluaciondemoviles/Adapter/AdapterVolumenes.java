package com.example.evaluaciondemoviles.Adapter;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.evaluaciondemoviles.Model.Revistas;
import com.example.evaluaciondemoviles.Model.VolumenesModel;
import com.example.evaluaciondemoviles.R;

import java.util.ArrayList;

public class AdapterVolumenes extends ArrayAdapter<VolumenesModel> {

    public AdapterVolumenes(Context context, ArrayList<VolumenesModel> datos) {
        super(context, R.layout.layout_listvolumenes, datos);

    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.layout_listvolumenes, null);
        TextView volumen,number,year,datapublisher, doi;
        ImageView img;
        volumen = item.findViewById(R.id.idVolumen);
        number= item.findViewById(R.id.idNumber);
        year = item.findViewById(R.id.idyear);
        datapublisher= item.findViewById(R.id.iddatapublisher);
        doi = item.findViewById(R.id.iddoi);
        img = item.findViewById(R.id.imaPortadaVolumen);

        volumen.setText(getItem(position).getVolume());
        number.setText(getItem(position).getNumber());
        year.setText(getItem(position).getYear());
        datapublisher.setText(getItem(position).getDate_published());
        doi.setText(getItem(position).getDoi());
        Glide.with(getContext()).load(getItem(position).getCover()).into(img);
        return(item);
    }
}
