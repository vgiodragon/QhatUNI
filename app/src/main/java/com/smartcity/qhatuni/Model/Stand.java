package com.smartcity.qhatuni.Model;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by root on 20/05/17.
 */

public class Stand {
    int zona;
    String nombre;
    String url;
    int iconId;
    String direccion;
    LatLng positionMaps;

    public Stand(int zona, String nombre, String url, int iconId, String direccion, LatLng positionMaps) {
        this.zona = zona;
        this.nombre = nombre;
        this.url = url;
        this.iconId = iconId;
        this.direccion = direccion;
        this.positionMaps = positionMaps;
    }

    public int getZona() {
        return zona;
    }

    public void setZona(int zona) {
        this.zona = zona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LatLng getPositionMaps() {
        return positionMaps;
    }

    public void setPositionMaps(LatLng positionMaps) {
        this.positionMaps = positionMaps;
    }
}
