package com.smartcity.qhatuni.GMapa;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by gio-pc on 5/19/17.
 */

public class mMarker {
    private int imagen;
    private String titulo;
    private LatLng mlLatLng;

    public mMarker(int imagen, String titulo, LatLng mlLatLng) {
        this.imagen = imagen;
        this.titulo = titulo;
        this.mlLatLng = mlLatLng;
    }

    public int getImagen() {
        return imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public LatLng getMlLatLng() {
        return mlLatLng;
    }
}
