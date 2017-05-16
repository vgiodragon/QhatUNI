package com.smartcity.qhatuni;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class StandArrayAdapter<T> extends ArrayAdapter<T> {
    Fragment fragmento;
    public StandArrayAdapter(Context context, List<T> objects, Fragment fragmento){
        super(context, 0, objects);
        //this.fragmento = fragmento;
    }
    @Override
    public View getView(final int position, final View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View listItemView = convertView;
        if (null == convertView) {
            listItemView = inflater.inflate(
                    R.layout.vista,
                    parent,
                    false);
        }
        TextView titulo = (TextView)listItemView.findViewById(R.id.nombre);
        ImageView icono = (ImageView)listItemView.findViewById(R.id.icono);


        String item = (String) getItem(position);
        //titulo.setText(getString(getResources().getIdentifier("nombre_"+item,"string",getActivity().getPackageName())));
        //icono.setImageResource(getResources().getIdentifier(item,"drawable",getActivity().getPackageName()));
        //BuildingStand item = (BuildingStand) getItem(position);
        //titulo.setText(item.nombres);
        //icono.setImageResource(item.iconos);
        return listItemView;
    }
}
