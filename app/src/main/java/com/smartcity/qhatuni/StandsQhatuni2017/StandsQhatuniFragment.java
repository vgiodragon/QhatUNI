package com.smartcity.qhatuni.StandsQhatuni2017;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smartcity.qhatuni.Informacion;
import com.smartcity.qhatuni.Model.Stand;
import com.smartcity.qhatuni.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StandsQhatuniFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StandsQhatuniFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "tipoStand";

    private int tipoStand;


    public StandsQhatuniFragment() {
        // Required empty public constructor
    }

    public static StandsQhatuniFragment newInstance(int param1) {
        StandsQhatuniFragment fragment = new StandsQhatuniFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            tipoStand = getArguments().getInt(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_stands_qhatuni, container, false);
        ArrayList<Stand> standsQhatuni = Informacion.getStands(tipoStand);
        RecyclerView recyclerViewStands = (RecyclerView) view.findViewById(R.id.recycler_stands);
        recyclerViewStands.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerStandsAdapter standsAdapter = new RecyclerStandsAdapter(getContext(), standsQhatuni);
        recyclerViewStands.setAdapter(standsAdapter);
        return view;
    }

}
