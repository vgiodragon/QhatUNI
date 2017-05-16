package com.smartcity.qhatuni;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

/**
 * Created by root on 30/04/16.
 */
public class ListaActividades extends Fragment {
    ListView listaActividades;
    ArrayAdapter adaptador;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.lista_actividades, container, false);

        /*listaActividades = (ListView) v.findViewById(R.id.lista_actividades);
        TextView dia = (TextView) v.findViewById(R.id.dia_actividades);
        dia.setText(getArguments().getString("dia"));
        //adaptador = new StandArrayAdapter(v.getContext(), Arrays.asList(getResources().getStringArray(R.array.becas)), this);
        adaptador = new StandArrayAdapter(v.getContext(), Informacion.getActividadesDia("martes"), this);
        listaActividades.setAdapter(adaptador);*/

        final RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.lista_card_actividades);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(llm);

        ActividadAdapter actividadAdapter = new ActividadAdapter(Informacion.getActividadesDia(getArguments().getString("dia")));
        recyclerView.setAdapter(actividadAdapter);

        return v;
    }
}
