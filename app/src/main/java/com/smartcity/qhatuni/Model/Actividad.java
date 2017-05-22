package com.smartcity.qhatuni.Model;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by root on 30/04/16.
 */
public class Actividad {
    String dia;
    String titulo;
    String ponente;
    GregorianCalendar horaInicio;
    GregorianCalendar horaFin;
    Local lugar;
    String idalerta;

    public Actividad(String dia, String titulo, String ponente, GregorianCalendar horaInicio, GregorianCalendar horaFin, Local lugar, String idalerta) {
        this.dia = dia;
        this.titulo = titulo;
        this.ponente = ponente;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.lugar = lugar;
        this.idalerta = idalerta;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPonente() {
        return ponente;
    }

    public void setPonente(String ponente) {
        this.ponente = ponente;
    }

    public GregorianCalendar getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(GregorianCalendar horaInicio) {
        this.horaInicio = horaInicio;
    }

    public GregorianCalendar getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(GregorianCalendar horaFin) {
        this.horaFin = horaFin;
    }

    public Local getLugar() {
        return lugar;
    }

    public void setLugar(Local lugar) {
        this.lugar = lugar;
    }

    public String getIdalerta() {
        return idalerta;
    }

    public void setIdalerta(String idalerta) {
        this.idalerta = idalerta;
    }
}
