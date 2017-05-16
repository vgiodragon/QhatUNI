package com.smartcity.qhatuni;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.qozix.tileview.TileView;


public class MapFragment extends NewFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.mapa,container,false);
        TileView tileView = (TileView)v.findViewById(R.id.tileview);
        tileView.setSize( 1536,5632);
        tileView.addDetailLevel( 1f, "tile/a-%d-%d.png");
        v.findViewById(R.id.fab).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });
        return v;
    }

}