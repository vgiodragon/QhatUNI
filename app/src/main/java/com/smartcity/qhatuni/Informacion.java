package com.smartcity.qhatuni;

import com.smartcity.qhatuni.EditorialesBecas.Editorial;

import java.util.ArrayList;
import com.smartcity.qhatuni.R;
/**
 * Created by root on 30/04/16.
 */
public class Informacion {

    public static ArrayList<Actividad> getActividadesDia(String dia){
        ArrayList<Actividad> listaActividadesDia = new ArrayList<>();
        if(dia.equalsIgnoreCase("lunes")){
            listaActividadesDia.add(new Actividad("16","Conferencia Literaria 'Escribirlo todo'","Jeremías Gamboa","Sala 401", "15","00","1234"));
        }
        else if(dia.equalsIgnoreCase("martes")){
            listaActividadesDia.add(new Actividad("17","Becas ICPNA","Kelly Villanueva","Sala 401", "11","00","1235"));
            listaActividadesDia.add(new Actividad("17","Test Vocacionales","Psicología UNI","Sala 409", "11","00","1236"));
            listaActividadesDia.add(new Actividad("17","Becas DAAD(Alemania)","Stehpan Paulini","Sala 401", "12","00","1237"));
            listaActividadesDia.add(new Actividad("17","Presentación del libro 'Mantenimiento de Centrales Hidroeléctricas'","Mg. Reynaldo Villanueva","Sala 401", "14","00","1238"));
            listaActividadesDia.add(new Actividad("17","Tullpi, Matemática Lúdica para niños","Mg. Adolfo Valdivieso","Sala 401", "15","00","1239"));
            listaActividadesDia.add(new Actividad("17","Los Objetivos del Desarrollo Sostenible y el Voluntariado","Feria QHATUNI 2016","Sala 501", "15","00","1240"));
            listaActividadesDia.add(new Actividad("17","Taller de Escritura 'Machucabotones'","César Bedón","Sala 401", "17","00","1241"));

        }
        else if(dia.equalsIgnoreCase("miercoles")){

            listaActividadesDia.add(new Actividad("18","Becas Fullbright(EEUU)","Jason Sherril","Sala 401", "11","00","1242"));
            listaActividadesDia.add(new Actividad("18","Test Vocacionales","Psicologia UNI","Sala 409", "11","30","1243"));
            listaActividadesDia.add(new Actividad("18","Becas Campus France","Gabriela Seijas","Sala 401", "12","00","1244"));
            listaActividadesDia.add(new Actividad("18","Conferencia 'Huaca el Paraiso' en Lima Norte","Arq. Bernardo Ojeda","Sala 401", "14","00","1245"));
            listaActividadesDia.add(new Actividad("18","Becas México","Embajada de México","Sala 401", "15","00","1246"));
            listaActividadesDia.add(new Actividad("18","Presentacion del Libro 'Neurociencia'","Dra. Ela Cassiano","Sala 401", "17","00","1247"));
            listaActividadesDia.add(new Actividad("18","Homenaje al literato y sociologo Carlos Calderon Fajardo","Dr. José Ignacio López Soria/Dr. Guillermo Rochabrum/Mg.Edith Aranda","Sala 401", "18","00","1248"));
        }
        else if(dia.equalsIgnoreCase("jueves")){
            listaActividadesDia.add(new Actividad("19","Becas Alianza-Estrategica","Dr. Victor Urrunaga","Sala 401", "10","00","1249"));
            listaActividadesDia.add(new Actividad("19","Test Vocacionales","Psicología UNI","Sala 409", "10","00","1250"));
            listaActividadesDia.add(new Actividad("19","Beca Santander","Sally Duymovich","Sala 401", "11","00","1251"));
            listaActividadesDia.add(new Actividad("19","Experiencias de la alumna ingresante en primer puesto","Franccesca Rojas","Sala 401", "15","00","1252"));
            listaActividadesDia.add(new Actividad("19","Los objetivos del Desarrollo Sostenible y el Voluntariado","Feria QHATUNI 2016","Sala 501", "15","00","1253"));
            listaActividadesDia.add(new Actividad("19","Presentación del libro 'El Heliogabalo'","Esteban Vega/Harold Alva/Ronald Arquiñigo","Sala 401", "16","00","1254"));
            listaActividadesDia.add(new Actividad("19","Presentación del libro 'Calculo Diferencial en una variable'","Ing. Edwin Mejí/Lic. César Saal/Ing. Miguel Meza","Sala 401", "17","00","1255"));
        }
        else if(dia.equalsIgnoreCase("viernes")){

            listaActividadesDia.add(new Actividad("20","Test Vocacionales","Psicología UNI","Sala 409", "10","00","1256"));
            listaActividadesDia.add(new Actividad("20","Conferencia: 'Gestion Innovadora'","Sr. Derliz Guzman - Municipalidad de Lima","Sala 401", "12","00","1257"));
            listaActividadesDia.add(new Actividad("20","Presentacion del libro 'Perú: Ciencia, Tecnología e Innovación Social'","Dr. Victor Carranza","Sala 401", "16","00","1258"));
            listaActividadesDia.add(new Actividad("20","Conferencia: 'Relatos de la historia de Lima Norte'","Lic. Santiago Tacunan","Sala 401", "17","00","1259"));
        }
        return listaActividadesDia;
    }

    public static ArrayList<Editorial> getEditoriales(String tipo){
        ArrayList<Editorial> listaEditoriales = new ArrayList<>();
        if(tipo.equalsIgnoreCase("editorial")){
            listaEditoriales.add(new Editorial("MiniBooks","(511) 459-8363","Jr. Los Pelitres 1784 Urb. San Hilarión, Lima", R.drawable.tminibooks));
            listaEditoriales.add(new Editorial("Librería Libun","(051) 446-5048","Av. Petit Thouars Nro 4799, Miraflores, Lima", R.drawable.libun));
            listaEditoriales.add(new Editorial("Librería Arcadia","(511) 241-7347","Av. Alcanfores 295 - Tda. 17, Miraflores, Lima", R.drawable.arcadia));
            listaEditoriales.add(new Editorial("Distribuidora Heraldos Negros","247-2866","Av. Centenario 170, Barranco, Lima", R.drawable.theraldosnegros));
            listaEditoriales.add(new Editorial("Fondo Editorial Pontificia Universidad Católica del Perú","(511) 626-2650","A. Universitaria 1801, Sa Miguel, Lima", R.drawable.tpucp));
            listaEditoriales.add(new Editorial("Fondo de Cultura Económica","(51) 447-2848","Calle Berlin 238, Miraflores, Lima", R.drawable.tfondocultura));
            listaEditoriales.add(new Editorial("Libreria La Familia","242-3900","A. Oscar R. Benavides (Ex diagonal) 372-374, Lima", R.drawable.tlafamilia));
            listaEditoriales.add(new Editorial("Editorial Macro EIRL","748-0560","Av. Paseo de la Republica Nro 5613, Miraflores, Lima", R.drawable.macro));
            listaEditoriales.add(new Editorial("Lumbreras Editores","01-332-3786","Av. Alfonso ugarte 1426, Breña, Lima (1 cuadra de Plaza Bolognesi)", R.drawable.lumbreras));
            listaEditoriales.add(new Editorial("Corporativo VyT","434-5508","Av. Canadá 3820, Lima 15021", R.drawable.vyt));
            listaEditoriales.add(new Editorial("CYDMA TECH SAC","423-1461","Jr. Enrique Barrón N°993 Of. 204, Urb. Santa Beatriz-Lima Cercado. Perú", R.drawable.cydma));
            listaEditoriales.add(new Editorial("Editorial Reverte - Distribuidor Special Books Service","(511) 206-4900","Av. Angamos Oeste Nº 301, Lima", R.drawable.treverte));
            listaEditoriales.add(new Editorial("Ediciones Orem","(51) 949 186 210","", R.drawable.torem));
            listaEditoriales.add(new Editorial("Sociedad San Pablo","(01) 446-0017","A. Armendáriz 527, Miraflores, Lima 18", R.drawable.sanpablo));
            listaEditoriales.add(new Editorial("Fondo Editorial Universidad Inca Garcilazo de la Vega","(511) 461-2745","Jr. Luis N. Saenz 557, Jesús María, Lima", R.drawable.tincagarcilazo));
            listaEditoriales.add(new Editorial("Oficina Nacional de Procesos Electorales","417-0630 ","Jr. Washington 1894, Cercado de Lima", R.drawable.tonpe));
            listaEditoriales.add(new Editorial("Librería San Cristobal","(511) 423-6111"," Jr. Camaná 1039, Lima 15001, Perú", R.drawable.tsancristobal));
            listaEditoriales.add(new Editorial("Editorial EDUNI","481-4196","Av Túpac Amaru # 210 Pabellón Central de la Universidad Nacional de Ingeniería - Rímac - Lima, Perú ", R.drawable.teduni));
        }
        else if(tipo.equalsIgnoreCase("becas")){
            listaEditoriales.add(new Editorial("Beca 18","(511) 6128230","Av. Arequipa 1935, Lince, Perú", R.drawable.tbeca));
            listaEditoriales.add(new Editorial("Oficina Central de Cooperación Internacional y Convenios","482-4770","Av. Túpac Amarú # 210 Pabellón Central - tercer piso de la Universidad Nacional de Ingeniería - Rímac - Lima, Perú", R.drawable.occic));//
            listaEditoriales.add(new Editorial("Programa Nacional de Becas","(01) 612-8230","Av. Arequipa 1935,", R.drawable.pronabec));
            listaEditoriales.add(new Editorial("Colegio de Ingenieros del Perú","(511) 445-6540","Av. Arequipa 4947", R.drawable.cip));
            listaEditoriales.add(new Editorial("Museo Andrés del Castillo","(511) 433-2831","Jr. de la Unión 1030, Lima 15001, Perú", R.drawable.mac));//TODO falta un loco decente, descargado de su pag already
            listaEditoriales.add(new Editorial("Tullpi","+51 973 950 936","", R.drawable.tullpi));
            listaEditoriales.add(new Editorial("Concytec","0051-1-399-0030","Calle Grimaldo de l Solar N 346, Miraflores, Lima", R.drawable.tconcytec));
            listaEditoriales.add(new Editorial("Fullbright","(511) 475-3083","Juan Romero Hidalgo 444, San Borja, Lima", R.drawable.tfulbright));
            listaEditoriales.add(new Editorial("Mancomunidad de Lima Norte","","", R.drawable.mcln));
            listaEditoriales.add(new Editorial("MuniBecas","(01) 632-1735","Jr. Cailloma 137, Cercado de Lima, Lima", R.drawable.tmunibecas));
            listaEditoriales.add(new Editorial("Alianza Francesa","(01) 610-8000","Av. Arequipa 4595, Miraflores, Lima", R.drawable.af));
            listaEditoriales.add(new Editorial("DAAD","(511) 626-20000","Av. Universitaria 1801, San Miguel, Lima", R.drawable.daad));
            listaEditoriales.add(new Editorial("Beca Santander","","", R.drawable.santander));
        }
        else if(tipo.equalsIgnoreCase("uni")){
            listaEditoriales.add(new Editorial("CTIC-UNI","(511) 481-2559","Av. Túpac Amaru - Puerta Nº 5 Pabellón R4, Lima, Perú", R.drawable.ctic));
            listaEditoriales.add(new Editorial("Escuela de Posgrado UNI","381-3826","Av. Túpac Amaru 210 Rimac Pabellon Central 3er Piso (Escuela Central de Posgrado)", R.drawable.posgrado));
            listaEditoriales.add(new Editorial("Oficina Central de Admisión","481-1070","Av. Tupac Amaru 210 - Rimac Rímac", R.drawable.ocad));
            listaEditoriales.add(new Editorial("CEPS-UNI","382-6786","Av. Tupac amaru cruce con Av. Eduardo de Habich, Lima", R.drawable.ceps));
            listaEditoriales.add(new Editorial("CEPRE-UNI","(511) 460-2407","Av Javier Prado Oeste 730, Magdalena del Mar 15076, Perú", R.drawable.tcepreuni));
        }

        return listaEditoriales;
    }
}
