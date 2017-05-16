package com.smartcity.qhatuni;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 15/04/16.
 */
public class DataEvento {
    static List EVENTOS = new ArrayList<Evento>();
    static {
        EVENTOS.add(new Evento("INAUGURACIÓN DE LA FERIA ","RECTOR DT. JORGE ALVA",15,5,2016,13,39));
        EVENTOS.add(new Evento("JEREMIAS GAMBOA","JEREMIAS GAMBOA",16,5,2016,15,0));
        EVENTOS.add(new Evento("CÉSAR BEDON MACHUCABOTONES","CÉSAR BEDON",17,5,2016,16,0));
        EVENTOS.add(new Evento("CENTRALES HIDROELECTRICAS" ,"VILLANUEVA URE",17,5,2016,17,0));
        EVENTOS.add(new Evento("WAYQUI (NARRADOR DE CUENTOS)","",18,5,2016,16,0));
        EVENTOS.add(new Evento("CÁLCULO DIFERENCIAL","SAAL/MEJIA",18,5,2016,17,0));
        EVENTOS.add(new Evento("HOMENAJE A CARLOS CALDERON FAJARDO INCLUYE EXPOSICIONES DE LIBROS E IMÁGENES MEDALLA DE RECONOCIMIENTO A LA FAMILIA","JOSÉ IGNACIO LOPEZ SORIA GUILLERMO ROCHABRUN RICARDO VERGARA EDITH ARANDA",18,5,2016,18,0));
        EVENTOS.add(new Evento("PRESENTACIÓN HELIOGABOLO","",19,5,2016,16,0));
        EVENTOS.add(new Evento("PRESENTACION REVISTA AMARU","",19,5,2016,17,0));
    }
}
