package com.smartcity.qhatuni.Model;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by root on 19/05/17.
 */

public class Local {
    String nombreLocal;
    String descripcion;
    LatLng positionLocal;
    int imageResource;

    public Local(String nombreLocal, String descripcion, LatLng positionLocal, int imageResource) {
        this.nombreLocal = nombreLocal;
        this.descripcion = descripcion;
        this.positionLocal = positionLocal;
        this.imageResource = imageResource;
    }

    public String getNombreLocal() {
        return nombreLocal;
    }

    public void setNombreLocal(String nombreLocal) {
        this.nombreLocal = nombreLocal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LatLng getPositionLocal() {
        return positionLocal;
    }

    public void setPositionLocal(LatLng positionLocal) {
        this.positionLocal = positionLocal;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }
}
