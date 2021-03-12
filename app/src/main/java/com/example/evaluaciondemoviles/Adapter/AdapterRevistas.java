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
import com.example.evaluaciondemoviles.R;

import java.util.ArrayList;

public class AdapterRevistas extends ArrayAdapter<Revistas> {

    public AdapterRevistas(Context context, ArrayList<Revistas> datos) {
        super(context, R.layout.layout_listart, datos);

    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.layout_listart, null);
        TextView Name, description;
        ImageView img;
        Name = item.findViewById(R.id.idTitulo);
        description= item.findViewById(R.id.idcontenido);
        img = item.findViewById(R.id.imaPortada);
        Name.setText(getItem(position).getName());
        description.setText(Html.fromHtml(getItem(position).getDescripccion()));
        Glide.with(getContext()).load(getItem(position).getPortada()).into(img);
        return(item);
    }
}