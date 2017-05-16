package com.smartcity.qhatuni;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by root on 15/04/16.
 */
public class Evento {
    String titulo;
    String descripcion;
    int dia, mes, anio;
    int hora, min;
    long time;

    public Evento(String titulo, String descripcion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public Evento(String titulo, String descripcion, int dia, int mes, int anio, int hora, int min) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
        this.hora = hora;
        this.min = min;
        GregorianCalendar fecha = new GregorianCalendar(anio, mes, dia, hora, min, 0);
        time = fecha.getTimeInMillis();
    }
}
