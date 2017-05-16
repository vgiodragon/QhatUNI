package com.smartcity.qhatuni.EditorialesBecas;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.smartcity.qhatuni.R;

import java.util.List;

public class ListUni extends Fragment {

    ListView listaStand;
    ArrayAdapter adaptador;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_lista, container, false);

        listaStand = (ListView) v.findViewById(R.id.lista_stands);
        //adaptador = new StandArrayAdapter(v.getContext(), Arrays.asList(getResources().getStringArray(getArguments().getInt("tipo"))), this);
        adaptador = new StandArrayAdapter(v.getContext(), DataEdBe.UNI, this);
        listaStand.setAdapter(adaptador);

        listaStand.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final BuildingStand item = (BuildingStand)adaptador.getItem(position);
                Bundle arguments = new Bundle();
                arguments.putString("layout", item.stand);
                android.support.v4.app.Fragment fragment = new DetailUni();
                fragment.setArguments(arguments);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.pop_enter,R.anim.pop_exit)
                        .replace(R.id.principal, fragment).addToBackStack(null).commit();
            }
        });
        return v;
    }

    public class StandArrayAdapter<T> extends ArrayAdapter<T> {
        Fragment fragmento;

        public StandArrayAdapter(Context context, List<T> objects, Fragment fragmento) {
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
            TextView titulo = (TextView) listItemView.findViewById(R.id.nombre);
            ImageView icono = (ImageView) listItemView.findViewById(R.id.icono);

            BuildingStand item = (BuildingStand) getItem(position);
            titulo.setText(item.nombres);
            icono.setImageResource(item.iconos);
            return listItemView;
        }
    }
}
