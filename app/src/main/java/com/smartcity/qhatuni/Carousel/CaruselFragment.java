package com.smartcity.qhatuni.Carousel;

import android.opengl.GLSurfaceView;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smartcity.qhatuni.NewFragment;
import com.smartcity.qhatuni.Sensor.Beacons;

public class CaruselFragment extends NewFragment {
    private GLSurfaceView glView;  // Use subclass of GLSurfaceView (NEW)
    Beacons beacons;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //((AppCompatActivity)getActivity()).getSupportActionBar().hide();
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);

        beacons = new Beacons(getContext(),getActivity());

        // Allocate a custom subclass of GLSurfaceView (NEW)
        glView = new MyGLSurfaceView(getActivity(),displaymetrics.heightPixels,displaymetrics.widthPixels,beacons);
        // Render the view only when there is a change in the drawing data


        return glView;
    }
    @Override
    public void onStop() {
        super.onStop();
        beacons.onStop();
    }

    @Override
    public void onPause() {
        super.onPause();
        glView.onPause();
        beacons.onStop();
        // ((AppCompatActivity)getActivity()).getSupportActionBar().show();
    }

    @Override
    public void onResume() {
        super.onResume();
        glView.onResume();
        beacons.onStart();
    }

}
