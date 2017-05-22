package com.smartcity.qhatuni.ProgramaQhatuni;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smartcity.qhatuni.Informacion;
import com.smartcity.qhatuni.Model.Actividad;
import com.smartcity.qhatuni.R;

import java.util.ArrayList;

public class ProgramaQhatuniFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "dia";

    // TODO: Rename and change types of parameters
    private String dia;


    public ProgramaQhatuniFragment() {
        // Required empty public constructor
    }

    public static ProgramaQhatuniFragment newInstance(String diaPrograma) {
        ProgramaQhatuniFragment fragment = new ProgramaQhatuniFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, diaPrograma);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            dia = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view  = inflater.inflate(R.layout.fragment_programa_qhatuni, container, false);
        ArrayList<Actividad> actividadesDia = Informacion.getActividadesDia(dia);
        RecyclerView recyclerViewActividades = (RecyclerView) view.findViewById(R.id.recycler_actividades);
        recyclerViewActividades.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerActividadesAdapter adapter = new RecyclerActividadesAdapter(getContext(), actividadesDia);
        recyclerViewActividades.setAdapter(adapter);
        return view;
    }

}
