package com.smartcity.qhatuni.EditorialesBecas;

/**
 * Created by root on 15/05/16.
 */
public class Editorial {
    String nombre;
    String telefono;
    String direccion;
    int imagen;

    public Editorial(String nombre, int imagen) {
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public Editorial(String nombre, String telefono, String direccion, int imagen){
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.imagen = imagen;
    }
}
