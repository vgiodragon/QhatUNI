package com.smartcity.qhatuni;

/**
 * Created by root on 30/04/16.
 */
public class Actividad {
    String dia;
    String titulo;
    String ponente;
    String descripcion;
    String hora;
    String minuto;
    String idalerta;

    public Actividad(String dia,String titulo, String ponente, String descripcion, String hora, String minuto, String idalerta) {
        this.dia = dia;
        this.titulo = titulo;
        this.ponente = ponente;
        this.descripcion = descripcion;
        this.hora = hora;
        this.minuto = minuto;
        this.idalerta = idalerta;
    }

    @Override
    public String toString() {
        return "Actividad{" +
                "dia='" + dia + '\'' +
                ", titulo='" + titulo + '\'' +
                ", ponente='" + ponente + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", hora='" + hora + '\'' +
                '}';
    }
}
