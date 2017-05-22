package com.smartcity.qhatuni;

import com.google.android.gms.maps.model.LatLng;
import com.smartcity.qhatuni.EditorialesBecas.Editorial;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Hashtable;

import com.smartcity.qhatuni.Model.Actividad;
import com.smartcity.qhatuni.Model.Local;
import com.smartcity.qhatuni.Model.Stand;

/**
 * Created by root on 30/04/16.
 */
public class Informacion {
    public final static String KEY_AUDITORIO_CTIC = "CTIC_AUDITORIO";
    public final static String KEY_LAB1_CTIC = "CTIC_LAB1";
    public final static String KEY_CER= "CER";
    public final static String KEY_CRAI_401 = "CRAI_401";
    public final static String KEY_CRAI_501 = "CRAI_501";
    public final static String KEY_CULTURAL = "CULTURAL";
    public final static String KEY_MUSEO = "MUSEO";
    public final static String KEY_CISMID = "CISMID";

    public final static int ZONA_LIBROS=1;
    public final static int ZONA_INSTITUCIONAL=2;
    public final static int ZONA_BECAS=3;

    public static Local getLocal(String idLocal){
        Hashtable<String, Local> localesQhatuni = new Hashtable<>();
        localesQhatuni.put("CTIC_AUDITORIO", new Local("Centro de Tecnologias de la Información y Comunicaciones", "Auditorio CTIC", new LatLng(12.3, 123.4), R.drawable.beca18));
        localesQhatuni.put("CTIC_LAB1", new Local("Centro de Tecnologias de la Información y Comunicaciones", "Laboratorio de Impresiones 3D", new LatLng(12.3, 123.4), R.drawable.beca18));
        localesQhatuni.put("CER", new Local("Centro de Energías Renovables y Uso Racional de la Energía", "", new LatLng(12.3, 123.4), R.drawable.beca18));
        localesQhatuni.put("CRAI_401", new Local("Biblioteca Central UNI-CRAI", "Salón 401", new LatLng(12.3, 123.4), R.drawable.beca18));
        localesQhatuni.put("CRAI_501", new Local("Biblioteca Central UNI-CRAI", "Salón 501", new LatLng(12.3, 123.4), R.drawable.beca18));
        localesQhatuni.put("CULTURAL", new Local("Zona Cultural", "", new LatLng(12.3, 123.4), R.drawable.beca18));
        localesQhatuni.put("MUSEO", new Local("Museo de Artes y Ciencias", "", new LatLng(12.3, 123.4), R.drawable.beca18));
        localesQhatuni.put("CISMID", new Local("Centro de Sensibilización y Aprendizaje sobre Terremotos y Tsunamis", "", new LatLng(12.3, 123.4), R.drawable.beca18));
        return localesQhatuni.get(idLocal);
    }

    public static ArrayList<Actividad> getActividadesDia(String dia){
        ArrayList<Actividad> listaActividadesDia = new ArrayList<>();

        if(dia.equalsIgnoreCase("martes")) {
            listaActividadesDia.add(new Actividad("martes", "Oportunidades para estudiar en Reino Unido",
                    "British Council Perú/ Natalia Toledo",
                    new GregorianCalendar(2017, 05, 23, 10, 0, 0), new GregorianCalendar(2017, 05, 23, 11, 0, 0),
                    getLocal(KEY_AUDITORIO_CTIC), "idevento001"));
            listaActividadesDia.add(new Actividad("martes", "Visita al Laboratorio de Impresiones 3D",
                    "Centro de Tecnologías de la Información y Comunicaciones",
                    new GregorianCalendar(2017, 05, 23, 10, 0, 0), new GregorianCalendar(2017, 05, 23, 11, 0, 0),
                    getLocal(KEY_LAB1_CTIC), "idevento002"));

            listaActividadesDia.add(new Actividad("martes", "Becas e Intercambios",
                    "MSc. Óscar Silva Campos, jefe de la Oficina Central de Cooperación Internacional y Convenios de la UNI",
                    new GregorianCalendar(2017, 05, 23, 11, 0, 0), new GregorianCalendar(2017, 05, 23, 12, 0, 0),
                    getLocal(KEY_AUDITORIO_CTIC), "idevento003"));
            listaActividadesDia.add(new Actividad("martes", "Visita al Laboratorio de Energías Renovables",
                    "Centro de Energías Renovables y Uso Racional de la Energía",
                    new GregorianCalendar(2017, 05, 23, 11, 0, 0), new GregorianCalendar(2017, 05, 23, 12, 0, 0),
                    getLocal(KEY_CER), "idevento004"));

            listaActividadesDia.add(new Actividad("martes", "Oportunidades de estudio y becas en Alemania",
                    "DAAD/Patricia Acevedo",
                    new GregorianCalendar(2017, 05, 23, 12, 0, 0), new GregorianCalendar(2017, 05, 23, 13, 0, 0),
                    getLocal(KEY_AUDITORIO_CTIC), "idevento005"));
            listaActividadesDia.add(new Actividad("martes", "El aporte de Samamé Boggio a la UNI y al Perú",
                    "Ing. Edilberto Huamaní",
                    new GregorianCalendar(2017, 05, 23, 12, 0, 0), new GregorianCalendar(2017, 05, 23, 13, 0, 0),
                    getLocal(KEY_CRAI_401), "idevento006"));
            listaActividadesDia.add(new Actividad("martes", "Presentación de grupos culturales",
                    "",
                    new GregorianCalendar(2017, 05, 23, 12, 0, 0), new GregorianCalendar(2017, 05, 23, 13, 0, 0),
                    getLocal(KEY_CULTURAL), "idevento007"));

            listaActividadesDia.add(new Actividad("martes", "Estudiar en Francia",
                    "Campus France - Alianza Francesa/Gabriela Seijas",
                    new GregorianCalendar(2017, 05, 23, 13, 0, 0), new GregorianCalendar(2017, 05, 23, 14, 0, 0),
                    getLocal(KEY_AUDITORIO_CTIC), "idevento008"));

            listaActividadesDia.add(new Actividad("martes", "Visita al Laboratorio de Impresiones 3D",
                    "Centro de Tecnologías de la Información y Comunicaciones",
                    new GregorianCalendar(2017, 05, 23, 14, 0, 0), new GregorianCalendar(2017, 05, 23, 15, 0, 0),
                    getLocal(KEY_LAB1_CTIC), "idevento009"));
            listaActividadesDia.add(new Actividad("martes", "Recorrido cultural + Clase abierta de Danza Contemporánea",
                    "",
                    new GregorianCalendar(2017, 05, 23, 14, 0, 0), new GregorianCalendar(2017, 05, 23, 15, 0, 0),
                    getLocal(KEY_CULTURAL), "idevento010"));

            listaActividadesDia.add(new Actividad("martes", "Misión Posible, estudia en los Estados Unidos de América",
                    "Centro de Educación USA/Alejandro Beotis y Kelly Villanueva",
                    new GregorianCalendar(2017, 05, 23, 15, 0, 0), new GregorianCalendar(2017, 05, 23, 16, 0, 0),
                    getLocal(KEY_AUDITORIO_CTIC), "idevento011"));
            listaActividadesDia.add(new Actividad("martes", "Ventajas de estudiar en CEPRE-UNI",
                    "Ing. Teófilo Salinas Aquije",
                    new GregorianCalendar(2017, 05, 23, 15, 0, 0), new GregorianCalendar(2017, 05, 23, 16, 0, 0),
                    getLocal(KEY_CRAI_401), "idevento012"));

            listaActividadesDia.add(new Actividad("martes", "Charla: Huacas de la Universidad Nacional de Ingeniería y la verdadera Huaca Aliaga",
                    "Arq. Carlos Enrique Guzmán",
                    new GregorianCalendar(2017, 05, 23, 16, 0, 0), new GregorianCalendar(2017, 05, 23, 17, 0, 0),
                    getLocal(KEY_CRAI_401), "idevento013"));
            listaActividadesDia.add(new Actividad("martes", "Charla: El arte como parte escencial del conocimiento humano",
                    "Escuela Central de Posgrado/Ing. Victor Rojas Yupanqui",
                    new GregorianCalendar(2017, 05, 23, 16, 0, 0), new GregorianCalendar(2017, 05, 23, 17, 0, 0),
                    getLocal(KEY_CRAI_501), "idevento014"));
            listaActividadesDia.add(new Actividad("martes", "Oferta de becas de excelencia para estudiar en México",
                    "Embajada de México/Mauricio Vizcaino Crespo",
                    new GregorianCalendar(2017, 05, 23, 16, 0, 0), new GregorianCalendar(2017, 05, 23, 17, 0, 0),
                    getLocal(KEY_AUDITORIO_CTIC), "idevento015"));
            listaActividadesDia.add(new Actividad("martes", "Clase Magistral de Historia del Arte",
                    "Patricia Ciriani(Museo de Artes y Ciencias)",
                    new GregorianCalendar(2017, 05, 23, 16, 0, 0), new GregorianCalendar(2017, 05, 23, 17, 0, 0),
                    getLocal(KEY_MUSEO), "idevento016"));

            listaActividadesDia.add(new Actividad("martes", "Charla: Robótica orientada a la rehabilitación física",
                    "INICTEL/Mg. Victor Christian Paredes Cauna)",
                    new GregorianCalendar(2017, 05, 23, 17, 0, 0), new GregorianCalendar(2017, 05, 23, 18, 0, 0),
                    getLocal(KEY_CRAI_401), "idevento016"));
            listaActividadesDia.add(new Actividad("martes", "Inducción matemática",
                    "Ing. Carlos Arámbulo Ostos, docente FIIS",
                    new GregorianCalendar(2017, 05, 23, 17, 0, 0), new GregorianCalendar(2017, 05, 23, 18, 0, 0),
                    getLocal(KEY_CRAI_501), "idevento016"));
        }
        else if(dia.equalsIgnoreCase("miercoles")){
            /* ======================================   MIERCOLES   ====================================================*/
            listaActividadesDia.add(new Actividad("miercoles", "Oportunidades de estudiar en Canadá",
                    "Embajada de Canadá/Diego Urbina",
                    new GregorianCalendar(2017, 05, 24, 10, 0, 0), new GregorianCalendar(2017, 05, 24, 11, 0, 0),
                    getLocal(KEY_AUDITORIO_CTIC), "idevento017"));
            listaActividadesDia.add(new Actividad("miercoles", "Tratamiento de aguas residuales domésticas y tratamiento de residuos - FIA",
                    "Warner Ugarte Guerrero",
                    new GregorianCalendar(2017, 05, 24, 10, 0, 0), new GregorianCalendar(2017, 05, 24, 11, 0, 0),
                    getLocal(KEY_CRAI_401), "idevento018"));
            listaActividadesDia.add(new Actividad("miercoles", "Visita al laboratorio de impresiones 3D",
                    "Centro de Tecnologías de la Información y Comunicaciones",
                    new GregorianCalendar(2017, 05, 24, 10, 0, 0), new GregorianCalendar(2017, 05, 24, 11, 0, 0),
                    getLocal(KEY_LAB1_CTIC), "idevento019"));

            listaActividadesDia.add(new Actividad("miercoles", "Programa Iberoamericano de Estudiantes de Pregrado 2017",
                    "Beca Santander/Sally Duymovich",
                    new GregorianCalendar(2017, 05, 24, 11, 0, 0), new GregorianCalendar(2017, 05, 24, 12, 0, 0),
                    getLocal(KEY_AUDITORIO_CTIC), "idevento020"));
            listaActividadesDia.add(new Actividad("miercoles", "Visita al Laboratorio de Energías Renovables",
                    "Centro de Energías Renovables y Uso Racional de la Energía",
                    new GregorianCalendar(2017, 05, 24, 11, 0, 0), new GregorianCalendar(2017, 05, 24, 12, 0, 0),
                    getLocal(KEY_CER), "idevento021"));

            listaActividadesDia.add(new Actividad("miercoles", "Japan International Cooperation Agency - JICA",
                    "",
                    new GregorianCalendar(2017, 05, 24, 12, 0, 0), new GregorianCalendar(2017, 05, 24, 13, 0, 0),
                    getLocal(KEY_AUDITORIO_CTIC), "idevento022"));
            listaActividadesDia.add(new Actividad("miercoles", "Charla: Biomédica orientada a personas con discapacidad motora",
                    "INICTEL/Mg. Victor Christian Paredes Cauna",
                    new GregorianCalendar(2017, 05, 24, 12, 0, 0), new GregorianCalendar(2017, 05, 24, 13, 0, 0),
                    getLocal(KEY_CRAI_401), "idevento023"));
            listaActividadesDia.add(new Actividad("miercoles", "Presentación grupos culturales",
                    "Conjunto de Zampoñas y Danzas de la UNI CZDUNI",
                    new GregorianCalendar(2017, 05, 24, 12, 0, 0), new GregorianCalendar(2017, 05, 24, 13, 0, 0),
                    getLocal(KEY_CULTURAL), "idevento024"));

            listaActividadesDia.add(new Actividad("miercoles", "Becas al Japón",
                    "Embajada de Japón/Departamento de Cultura",
                    new GregorianCalendar(2017, 05, 24, 13, 0, 0), new GregorianCalendar(2017, 05, 24, 14, 0, 0),
                    getLocal(KEY_AUDITORIO_CTIC), "idevento025"));

            listaActividadesDia.add(new Actividad("miercoles", "Visita al Laboratorio de Impresiones 3D",
                    "Centro de Tecnologías de la Información y Comunicaciones",
                    new GregorianCalendar(2017, 05, 24, 14, 0, 0), new GregorianCalendar(2017, 05, 24, 15, 0, 0),
                    getLocal(KEY_LAB1_CTIC), "idevento026"));
            listaActividadesDia.add(new Actividad("miercoles", "Recorrido Cultural + Clase abierta de clown",
                    "",
                    new GregorianCalendar(2017, 05, 24, 14, 0, 0), new GregorianCalendar(2017, 05, 24, 15, 0, 0),
                    getLocal(KEY_CULTURAL), "idevento027"));

            listaActividadesDia.add(new Actividad("miercoles", "Programa Erasmus+ de la Union Europea, delegación de la Unión",
                    "Unión Europea en Perú / Stefaan Pauwels",
                    new GregorianCalendar(2017, 05, 24, 15, 0, 0), new GregorianCalendar(2017, 05, 24, 16, 0, 0),
                    getLocal(KEY_AUDITORIO_CTIC), "idevento028"));

            listaActividadesDia.add(new Actividad("miercoles", "Presentación del libro: Entiende y aprende a gestionar tu vida",
                    "Lic. Carlos Bazán Cabanillas",
                    new GregorianCalendar(2017, 05, 24, 16, 0, 0), new GregorianCalendar(2017, 05, 24, 17, 0, 0),
                    getLocal(KEY_CRAI_401), "idevento029"));
            listaActividadesDia.add(new Actividad("miercoles", "Taller de Origami",
                    "",
                    new GregorianCalendar(2017, 05, 24, 16, 0, 0), new GregorianCalendar(2017, 05, 24, 17, 0, 0),
                    getLocal(KEY_CULTURAL), "idevento030"));
            listaActividadesDia.add(new Actividad("miercoles", "Taller de Mashakara",
                    "",
                    new GregorianCalendar(2017, 05, 24, 16, 0, 0), new GregorianCalendar(2017, 05, 24, 17, 0, 0),
                    getLocal(KEY_CULTURAL), "idevento031"));
            listaActividadesDia.add(new Actividad("miercoles", "Australia un futuro sin límites",
                    "",
                    new GregorianCalendar(2017, 05, 24, 16, 0, 0), new GregorianCalendar(2017, 05, 24, 17, 0, 0),
                    getLocal(KEY_CULTURAL), "idevento032"));

            listaActividadesDia.add(new Actividad("miercoles", "Charla: Robótica",
                    "INICTEL/Camila Oliden",
                    new GregorianCalendar(2017, 05, 24, 17, 0, 0), new GregorianCalendar(2017, 05, 24, 18, 0, 0),
                    getLocal(KEY_CRAI_501), "idevento033"));
            listaActividadesDia.add(new Actividad("miercoles", "Conferencia vocacional",
                    "Oficina Central de Admisión de la UNI",
                    new GregorianCalendar(2017, 05, 24, 17, 0, 0), new GregorianCalendar(2017, 05, 24, 18, 0, 0),
                    getLocal(KEY_CRAI_401), "idevento034"));

            /* ======================================   MIERCOLES   ====================================================*/
        }
        else if(dia.equalsIgnoreCase("jueves")){
            /* ======================================    JUEVES     ====================================================*/

            listaActividadesDia.add(new Actividad("jueves", "Charla del Consejo Nacional de Ciencia, Tecnología e Innovación Tecnológica",
                    "Concytec",
                    new GregorianCalendar(2017, 05, 25, 10, 0, 0), new GregorianCalendar(2017, 05, 25, 11, 0, 0),
                    getLocal(KEY_AUDITORIO_CTIC), "idevento035"));
            listaActividadesDia.add(new Actividad("jueves", "Visita al Centro de Sensibilización y Aprendizaje sobre Terremotos y Tsunamis",
                    "CISMID",
                    new GregorianCalendar(2017, 05, 25, 10, 0, 0), new GregorianCalendar(2017, 05, 25, 11, 0, 0),
                    getLocal(KEY_CISMID), "idevento036"));
            listaActividadesDia.add(new Actividad("jueves", "Visita al Laboratorio de Impresiones 3D",
                    "Centro de Tecnologías de la Información y Comunicaciones",
                    new GregorianCalendar(2017, 05, 25, 10, 0, 0), new GregorianCalendar(2017, 05, 25, 11, 0, 0),
                    getLocal(KEY_LAB1_CTIC), "idevento037"));

            listaActividadesDia.add(new Actividad("jueves", "Programa Doble Triángulo (DTP)",
                    "Universidad de Yamagata / Marisa Koitabashi ",
                    new GregorianCalendar(2017, 05, 25, 11, 0, 0), new GregorianCalendar(2017, 05, 25, 12, 0, 0),
                    getLocal(KEY_AUDITORIO_CTIC), "idevento038"));
            listaActividadesDia.add(new Actividad("jueves", "Visita al Laboratorio de Energías Renovables",
                    "Centro de Energías Renovables y Uso Racional de la Energía",
                    new GregorianCalendar(2017, 05, 25, 11, 0, 0), new GregorianCalendar(2017, 05, 25, 12, 0, 0),
                    getLocal(KEY_CER), "idevento039"));
            listaActividadesDia.add(new Actividad("jueves", "Tratamiento de aguas residuales domésticas y tratamiento de residuos",
                    "Facultad de Ingeniería Ambiental/Ing. César Masgo Soto",
                    new GregorianCalendar(2017, 05, 25, 11, 0, 0), new GregorianCalendar(2017, 05, 25, 12, 0, 0),
                    getLocal(KEY_CRAI_401), "idevento040"));

            listaActividadesDia.add(new Actividad("jueves", "Experiencia de becarios",
                    "Enoc Basilio Mesa, ganador de investigación por la Universidad Alberta de Canadá",
                    new GregorianCalendar(2017, 05, 25, 12, 0, 0), new GregorianCalendar(2017, 05, 25, 13, 0, 0),
                    getLocal(KEY_CRAI_401), "idevento041"));
            listaActividadesDia.add(new Actividad("jueves", "Presentación de grupos culturales",
                    "Teatro de la UNI",
                    new GregorianCalendar(2017, 05, 25, 12, 0, 0), new GregorianCalendar(2017, 05, 25, 13, 0, 0),
                    getLocal(KEY_CULTURAL), "idevento042"));

            listaActividadesDia.add(new Actividad("jueves", "Experiencia de intercambio",
                    "Instituto Tecnológico de Xalapa/Uriel Contreras e Isaac Ambrisio",
                    new GregorianCalendar(2017, 05, 25, 13, 0, 0), new GregorianCalendar(2017, 05, 25, 14, 0, 0),
                    getLocal(KEY_CRAI_401), "idevento043"));

            listaActividadesDia.add(new Actividad("jueves", "Experiencia de becario",
                    "Jerson Sánchez Sánchez ganador de la beca a la Universidad de Oklahoma",
                    new GregorianCalendar(2017, 05, 25, 14, 0, 0), new GregorianCalendar(2017, 05, 25, 15, 0, 0),
                    getLocal(KEY_CRAI_501), "idevento044"));
            listaActividadesDia.add(new Actividad("jueves", "Visita al Laboratorio de Impresión 3D",
                    "Centro de Tecnologías de la Información y Comunicaciones",
                    new GregorianCalendar(2017, 05, 25, 14, 0, 0), new GregorianCalendar(2017, 05, 25, 15, 0, 0),
                    getLocal(KEY_LAB1_CTIC), "idevento045"));
            listaActividadesDia.add(new Actividad("jueves", "Encuentro: El futuro del Qhechua",
                    "Dr. Rodrigo Montoya/Lic. Clodomiro Landeo(Noticiero Ñuqanchik)/Mg. Roxana Quispe",
                    new GregorianCalendar(2017, 05, 25, 14, 0, 0), new GregorianCalendar(2017, 05, 25, 15, 0, 0),
                    getLocal(KEY_AUDITORIO_CTIC), "idevento046"));
            listaActividadesDia.add(new Actividad("jueves", "Recorrido Cultural + Clase abierta de Teatro",
                    "",
                    new GregorianCalendar(2017, 05, 25, 14, 0, 0), new GregorianCalendar(2017, 05, 25, 15, 0, 0),
                    getLocal(KEY_CULTURAL), "idevento047"));

            listaActividadesDia.add(new Actividad("jueves", "Experiencia de becario",
                    "Félix Córdoba García, ganador de Beca Santander",
                    new GregorianCalendar(2017, 05, 25, 15, 0, 0), new GregorianCalendar(2017, 05, 25, 16, 0, 0),
                    getLocal(KEY_CRAI_501), "idevento048"));
            listaActividadesDia.add(new Actividad("jueves", "Charla: Reforma electoral avances y retos pendientes",
                    "Mg. Juan de La Cruz Bonilla Investigador de la Subgerencia de Información e Investigación Electoral de la ONPE",
                    new GregorianCalendar(2017, 05, 25, 15, 0, 0), new GregorianCalendar(2017, 05, 25, 16, 0, 0),
                    getLocal(KEY_CRAI_401), "idevento049"));

            listaActividadesDia.add(new Actividad("jueves", "Charla sobre la enseñanza de las matemáticas mediante libros de uso autodidacta para enseñanza superior",
                    "Gabriel Loa",
                    new GregorianCalendar(2017, 05, 25, 16, 0, 0), new GregorianCalendar(2017, 05, 25, 17, 0, 0),
                    getLocal(KEY_CRAI_401), "idevento050"));
            listaActividadesDia.add(new Actividad("jueves", "Taller de redacción",
                    "Club de lectura de la UNI",
                    new GregorianCalendar(2017, 05, 25, 16, 0, 0), new GregorianCalendar(2017, 05, 25, 17, 0, 0),
                    getLocal(KEY_CULTURAL), "idevento051"));
            listaActividadesDia.add(new Actividad("jueves", "Truequetón de Libros",
                    "",
                    new GregorianCalendar(2017, 05, 25, 16, 0, 0), new GregorianCalendar(2017, 05, 25, 17, 0, 0),
                    getLocal(KEY_CULTURAL), "idevento052"));
            listaActividadesDia.add(new Actividad("jueves", "Experiencia de Becario",
                    "Ganador de la Beca Alianza del Pacífico/César Fernando Sarrín Cépeda",
                    new GregorianCalendar(2017, 05, 25, 16, 0, 0), new GregorianCalendar(2017, 05, 25, 17, 0, 0),
                    getLocal(KEY_CRAI_501), "idevento053"));

            listaActividadesDia.add(new Actividad("jueves", "Charla Internet de las Cosas",
                    "INICTEL/Ing. José Oliden Martinez",
                    new GregorianCalendar(2017, 05, 25, 17, 0, 0), new GregorianCalendar(2017, 05, 25, 18, 0, 0),
                    getLocal(KEY_CRAI_401), "idevento054"));

            /* ======================================    JUEVES     ====================================================*/
        }

        else if(dia.equalsIgnoreCase("viernes")){
            /* ======================================   VIERNES     ====================================================*/
            listaActividadesDia.add(new Actividad("viernes", "Becas de posgrado para Estados Unidos",
                    "Fullbright / Jason Sherrill",
                    new GregorianCalendar(2017, 05, 26, 10, 0, 0), new GregorianCalendar(2017, 05, 26, 11, 0, 0),
                    getLocal(KEY_AUDITORIO_CTIC), "idevento055"));
            listaActividadesDia.add(new Actividad("viernes", "Conferencia: La escuela de ingenieros de Habich y la UNI del siglo XXI",
                    "Prof. Alvaro Montaño, jefe editorial Universitario UNI",
                    new GregorianCalendar(2017, 05, 26, 10, 0, 0), new GregorianCalendar(2017, 05, 26, 11, 0, 0),
                    getLocal(KEY_MUSEO), "idevento056"));
            listaActividadesDia.add(new Actividad("viernes", "Visita al Laboratorio de Impresión 3D",
                    "Centro de Tecnologías de la Información y Comunicaciones",
                    new GregorianCalendar(2017, 05, 26, 10, 0, 0), new GregorianCalendar(2017, 05, 26, 11, 0, 0),
                    getLocal(KEY_LAB1_CTIC), "idevento057"));

            listaActividadesDia.add(new Actividad("viernes", "Charla de Consejo Nacional de Ciencia Tecnología e Innovación Tecnológica",
                    "Concytec",
                    new GregorianCalendar(2017, 05, 26, 11, 0, 0), new GregorianCalendar(2017, 05, 26, 12, 0, 0),
                    getLocal(KEY_AUDITORIO_CTIC), "idevento058"));
            listaActividadesDia.add(new Actividad("viernes", "Visita al Laboratorio de Energías Renovables",
                    "Centro de Energías Renovables y Uso Racional de la Energía",
                    new GregorianCalendar(2017, 05, 26, 11, 0, 0), new GregorianCalendar(2017, 05, 26, 12, 0, 0),
                    getLocal(KEY_AUDITORIO_CTIC), "idevento059"));

            listaActividadesDia.add(new Actividad("viernes", "Experiencia de Becario",
                    "Alianza del Pacífico(México)/Carlos Vasques Mesa, Universidad Autónoma de Tamauilpas y Maité García Ballina, Universidad Tecnológica de Tabasco",
                    new GregorianCalendar(2017, 05, 26, 12, 0, 0), new GregorianCalendar(2017, 05, 26, 13, 0, 0),
                    getLocal(KEY_CRAI_401), "idevento060"));
            listaActividadesDia.add(new Actividad("viernes", "Presentación de grupos culturales",
                    "Tuna de la UNI",
                    new GregorianCalendar(2017, 05, 26, 12, 0, 0), new GregorianCalendar(2017, 05, 26, 13, 0, 0),
                    getLocal(KEY_CULTURAL), "idevento061"));

            listaActividadesDia.add(new Actividad("viernes", "Presentación de grupos culturales",
                    "Tuna de la UNI",
                    new GregorianCalendar(2017, 05, 26, 12, 0, 0), new GregorianCalendar(2017, 05, 26, 13, 0, 0),
                    getLocal(KEY_CULTURAL), "idevento062"));

            listaActividadesDia.add(new Actividad("viernes", "Experiencia de Becario",
                    "Renato Bisso Pérez, Ganador de la Beca a la Universidad de Oklahoma",
                    new GregorianCalendar(2017, 05, 26, 14, 0, 0), new GregorianCalendar(2017, 05, 26, 15, 0, 0),
                    getLocal(KEY_CRAI_401), "idevento063"));
            listaActividadesDia.add(new Actividad("viernes", "Visita al Laboratorio de Impresiones 3D",
                    "Centro de Tecnologías de la Información y Comunicaciones",
                    new GregorianCalendar(2017, 05, 26, 14, 0, 0), new GregorianCalendar(2017, 05, 26, 15, 0, 0),
                    getLocal(KEY_LAB1_CTIC), "idevento064"));
            listaActividadesDia.add(new Actividad("viernes", "Recorrido Cultural + Clase abierta de Tuntuna",
                    "",
                    new GregorianCalendar(2017, 05, 26, 14, 0, 0), new GregorianCalendar(2017, 05, 26, 15, 0, 0),
                    getLocal(KEY_CULTURAL), "idevento065"));

            listaActividadesDia.add(new Actividad("viernes", "Conferencia Vocacional",
                    "Oficina Central de Admisión de la UNI",
                    new GregorianCalendar(2017, 05, 26, 15, 0, 0), new GregorianCalendar(2017, 05, 26, 16, 0, 0),
                    getLocal(KEY_CRAI_401), "idevento066"));

            listaActividadesDia.add(new Actividad("viernes", "Conversatorio Diálogo sobre el diálogo. A propósito de los 50 años del diálogo entre Vargas Llosa y García Márquez",
                    "Dr. José Ignacio López Sora/ Dr. Abelardo Oquendo",
                    new GregorianCalendar(2017, 05, 26, 16, 0, 0), new GregorianCalendar(2017, 05, 26, 17, 0, 0),
                    getLocal(KEY_AUDITORIO_CTIC), "idevento067"));

            listaActividadesDia.add(new Actividad("viernes", "Taller de redacción",
                    "Club de Lectura de la UNI",
                    new GregorianCalendar(2017, 05, 26, 17, 0, 0), new GregorianCalendar(2017, 05, 26, 18, 0, 0),
                    getLocal(KEY_CULTURAL), "idevento068"));
            listaActividadesDia.add(new Actividad("viernes", "Cuenta cuentos",
                    "",
                    new GregorianCalendar(2017, 05, 26, 17, 0, 0), new GregorianCalendar(2017, 05, 26, 18, 0, 0),
                    getLocal(KEY_CULTURAL), "idevento069"));
            listaActividadesDia.add(new Actividad("viernes", "Prácticas Internacionales",
                    "",
                    new GregorianCalendar(2017, 05, 26, 17, 0, 0), new GregorianCalendar(2017, 05, 26, 18, 0, 0),
                    getLocal(KEY_CRAI_401), "idevento070"));

            listaActividadesDia.add(new Actividad("viernes", "Presentación de grupos culturales",
                    "Tuna de la UNI",
                    new GregorianCalendar(2017, 05, 26, 18, 0, 0), new GregorianCalendar(2017, 05, 26, 18, 0, 0),
                    getLocal(KEY_CULTURAL), "idevento059"));

                /* ======================================   VIERNES     ====================================================*/
        }

        return listaActividadesDia;
    }

    public static ArrayList<Stand> getStands(int zona){
        ArrayList<Stand> standsQhatuni = new ArrayList<>();
        switch (zona){
            case ZONA_BECAS:
                standsQhatuni.add(new Stand(ZONA_BECAS,"Oficina Centro de Cooperación y Convenios UNI",
                        "http://cooperacion.uni.edu.pe/site/",
                        R.drawable.oficina_central_de_cooperacion,
                        "Av. Túpac Amarú 210 Rímac, Pabellón Central – Tercer piso", new LatLng(-12.025549,-77.04963)));
                standsQhatuni.add(new Stand(ZONA_BECAS,"Oficina de Becas y Tutoria",
                        "http://www.uni.edu.pe/qhatuni/#info",
                        R.drawable.munibecas,
                        "Av. Túpac Amarú 210 Rímac, Pabellón Central", new LatLng(-12.025549,-77.04963)));
                standsQhatuni.add(new Stand(ZONA_BECAS,"Oficina Internacional para las migraciones",
                        "http://www.uni.edu.pe/qhatuni/#info",
                        R.drawable.logo_qhatuni_20172,
                        "Av. Túpac Amarú 210 Rímac, Pabellón Central", new LatLng(-12.025549,-77.04963)));
                standsQhatuni.add(new Stand(ZONA_BECAS,"Fulbright",
                        "http://www.fulbright.pe/",
                        R.drawable.fulbright,
                        "Juan Romero Hidalgo 444 San Borja, Lima, Perú", new LatLng(-12.1075763,-76.9976929)));
                standsQhatuni.add(new Stand(ZONA_BECAS,"DAAD",
                        "https://www.daad.pe/es/",
                        R.drawable.daad,
                        "Av. Universitaria 1801 San Miguel Lima", new LatLng(-12.0703005,-77.0817116)));
                standsQhatuni.add(new Stand(ZONA_BECAS,"Concytec",
                        "https://portal.concytec.gob.pe/",
                        R.drawable.concytec,
                        "Calle Grimaldo del Solar N° 346 - Miraflores", new LatLng(-12.1253604,-77.0282463)));
                standsQhatuni.add(new Stand(ZONA_BECAS,"Campus France",
                        "http://www.perou.campusfrance.org/",
                        R.drawable.logo_afl,
                        "Alianza francesa de Lima Av. Arequipa 4595", new LatLng(-12.1112503,-77.031918)));
                standsQhatuni.add(new Stand(ZONA_BECAS,"Beca Santander",
                        "http://www.becas-santander.com/?lang=es",
                        R.drawable.santander,
                        "", new LatLng(-12.025549,-77.04963)));
                standsQhatuni.add(new Stand(ZONA_BECAS,"IAESTE",
                        "http://iaeste.udep.pe/iaesteperu/",
                        0,
                        "Universidad de Piura Av. Ramón Mugica 131, Urb. San Eduardo - Perú", new LatLng(-5.1812001,-80.6313255)));
                standsQhatuni.add(new Stand(ZONA_BECAS,"Alianza Francesa",
                        "http://alianzafrancesa.org.pe/",
                        R.drawable.logo_afl,
                        "Av. Arequipa 4595", new LatLng(-12.1113134,-77.0322967)));
                standsQhatuni.add(new Stand(ZONA_BECAS,"Munibecas",
                        "http://munibecas.org/",
                        R.drawable.munibecas,
                        "", new LatLng(-12.1113134,-77.0322967)));
                standsQhatuni.add(new Stand(ZONA_BECAS,"Centro Education USA",
                        "http://www.educationusa-peru.info/",
                        0,
                        "Av. Arequipa 4748, Miraflores Lima", new LatLng(-12.1134672,-77.0652304)));
                standsQhatuni.add(new Stand(ZONA_BECAS,"Embajada de Japón",
                        "pe.emb-japan.go.jp",
                        0,
                        "Av. San Felipe 356, Jesús María", new LatLng(-12.0827712,-77.0585451)));
                standsQhatuni.add(new Stand(ZONA_BECAS,"ONPE",
                        "https://www.web.onpe.gob.pe/",
                        0,
                        "Jr. Washington 1894, Cercado de Lima", new LatLng(-12.063312,-77.039131)));
                standsQhatuni.add(new Stand(ZONA_BECAS,"PRONABEC",
                        "http://www.pronabec.gob.pe/",
                        R.drawable.pronabec,
                        "Av. Arequipa 1935, Lince", new LatLng(-12.0839282,-77.0364159)));
                standsQhatuni.add(new Stand(ZONA_BECAS,"Escuela Central de Posgrado",
                        "http://posgrado.uni.edu.pe/",
                        R.drawable.escuela_posgrado,
                        "Av. Tupac Amaru 210 Pabellón Central 3er Piso", new LatLng(-12.024022,-77.048144)));
                break;
            case ZONA_INSTITUCIONAL:
                standsQhatuni.add(new Stand(ZONA_INSTITUCIONAL, "Oficina de Relaciones Públicas",
                        "http://www.rrpp.uni.edu.pe/",
                        0,
                        "Av. Túpac Amaru N° 210 - Rímac. Apartado 1301", new LatLng(-12.024022,-77.048144)));
                standsQhatuni.add(new Stand(ZONA_INSTITUCIONAL, "Oficina Central de Admisión",
                        "www.admision.uni.edu.pe/",
                        R.drawable.ocad,
                        "Av. Tupac Amaru 210 Rimac Perú", new LatLng(-12.024022,-77.0503328)));
                standsQhatuni.add(new Stand(ZONA_INSTITUCIONAL, "CEPRE-UNI",
                        "http://cepre.uni.edu.pe/home.htm",
                        R.drawable.cepre_uni,
                        "Av Javier Prado Oeste 730, Magdalena del Mar", new LatLng(-12.0932529,-77.0637516)));
                standsQhatuni.add(new Stand(ZONA_INSTITUCIONAL, "Centro de Energías Renovables CER",
                        "https://www.facebook.com/CERUNI.PERU/",
                        0,
                        "Tupac Amaru 210", new LatLng(-12.024022,-77.048144)));
                standsQhatuni.add(new Stand(ZONA_INSTITUCIONAL, "Mancomunidad de Lima Norte",
                        "http://www.mancomunidadlimanorte.gob.pe/",
                        R.drawable.mancomunidad,
                        "", new LatLng(-11.9916478,-77.0728485)));
                standsQhatuni.add(new Stand(ZONA_INSTITUCIONAL, "Tratamiento de aguas residuales - Facultad de Ingenieria Ambiental",
                        "http://fiauni.pe/sitio/",
                        0,
                        "Tupac Amaru 280", new LatLng(-12.0226211,-77.0509551)));
                standsQhatuni.add(new Stand(ZONA_INSTITUCIONAL, "Proyecta UNI",
                        "http://www.premioproyecta.uni.edu.pe/",
                        R.drawable.proyecta,
                        "Tupac Amaru 210", new LatLng(-12.02241,-77.04903)));
                standsQhatuni.add(new Stand(ZONA_INSTITUCIONAL, "Colegio de Ingenieros del Perú",
                        "http://www.cip.org.pe/",
                        R.drawable.colegio_de_ingenieros,
                        "Av. Arequipa Nº 4947 ", new LatLng(-12.1151039,-77.0314785)));
                standsQhatuni.add(new Stand(ZONA_INSTITUCIONAL, "Instituto General de Investigación",
                        "http://igi.uni.edu.pe/portal/es/",
                        R.drawable.oficina_central_de_cooperacion,
                        " Av. Tupac Amaru 210, Rimac, Lima | 511 481 1070 - anexo 7852", new LatLng(-12.024022,-77.0503328)));
                standsQhatuni.add(new Stand(ZONA_INSTITUCIONAL, "Inictel UNI",
                        "http://www.inictel-uni.edu.pe/",
                        R.drawable.logo_inictel,
                        "AV. SAN LUIS 1771 - SAN BORJA - LIMA 41 - PERU", new LatLng(-12.084151,-76.9988058)));
                break;
            case ZONA_LIBROS:
                standsQhatuni.add(new Stand(ZONA_LIBROS, "Museo Andrés del Castillo",
                        "http://www.madc.com.pe/",
                        R.drawable.museo_andres_del_castillo,
                        "Jr. De La Unión 1030. Lima 1. Perú ", new LatLng(-12.052173,-77.0378666)));
                standsQhatuni.add(new Stand(ZONA_LIBROS, "EDUNI",
                        "http://www.eduni.uni.edu.pe/",
                        R.drawable.eduni,
                        "Pabellón Central de la Universidad Nacional de Ingeniería", new LatLng(-12.024022,-77.048144)));
                standsQhatuni.add(new Stand(ZONA_LIBROS, "Editorial Universidad Nacional Mayor de San Marcos",
                        "http://www.unmsm.edu.pe/fondoeditorial/",
                        0,
                        "Calle German Amézaga N° 375 | 4to piso de la Biblioteca Central | Ciudad Universitaria,Lima-Perú", new LatLng(-12.0560204,-77.0866113)));
                standsQhatuni.add(new Stand(ZONA_LIBROS, "Jallalla - Patrimonio Cultural UNI",
                        "https://www.facebook.com/jallallaUNI/",
                        R.drawable.jallalla,
                        "Universidad Nacional de Ingeniería", new LatLng(-12.024022,-77.048144)));
                standsQhatuni.add(new Stand(ZONA_LIBROS, "Librerías LIBUN",
                        "http://www.libun.edu.pe/",
                        R.drawable.libun,
                        "Petit Thouars Nº 4799 , Miraflores", new LatLng(-12.1105826,-77.0314138)));
                standsQhatuni.add(new Stand(ZONA_LIBROS, "UPC Editorial",
                        "https://tienda.upc.edu.pe/231-editorial-upc",
                        0,
                        "Prolongación Primavera 2390, Distrito de Lima 15023, Perú", new LatLng(-12.1040552,-76.9650905)));
                standsQhatuni.add(new Stand(ZONA_LIBROS, "Editorial Planeta",
                        "http://www.planetadelibros.com.pe/",
                        R.drawable.logo_grupo_planeta,
                        "Av. Santa Cruz 244, San Isidro", new LatLng(-12.1051609,-77.0352357)));
                standsQhatuni.add(new Stand(ZONA_LIBROS, "Librería Arcadia Mediática",
                        "http://www.arcadiamediatica.com/",
                        R.drawable.arcadia,
                        "Av. Alcanfores 295 – Tda. 17", new LatLng(-12.122274,-77.027703)));
                standsQhatuni.add(new Stand(ZONA_LIBROS, "Librería MACRO",
                        "http://www.editorialmacro.com/default/",
                        R.drawable.macro,
                        "Av. Paseo de la República 5613", new LatLng(-12.1206337,-77.0278728)));
                standsQhatuni.add(new Stand(ZONA_LIBROS, "Lumbreras Editores",
                        "http://www.elumbreras.com.pe/",
                        R.drawable.lumbre,
                        "Av. Alfonso Ugarte 1426 Breña", new LatLng(-12.1206337,-77.0278728)));
                standsQhatuni.add(new Stand(ZONA_LIBROS, "Editorial Reverté",
                        "https://www.reverte.com/distribuidores/distribuidores?zona=2&region=25",
                        R.drawable.reverte,
                        "Av. Petit Thouars Nº 4799", new LatLng(-12.1105826,-77.0314138)));
                standsQhatuni.add(new Stand(ZONA_LIBROS, "Los libros más pequeños del mundo",
                        "http://www.minibooks.com.pe/home.php?lang=es&pais=pe",
                        0,
                        "Jr. Los Pelitres 1784 Urb. San Hilarión Lima 36 - Perú ", new LatLng(-12.1105826,-77.0314138)));
                standsQhatuni.add(new Stand(ZONA_LIBROS, "Libros MIR",
                        "http://www.librosmir.com/",
                        0,
                        "Jr. Ica 441. Int. 103. Cercado de Lima", new LatLng(-12.0324621,-77.0806001)));
                standsQhatuni.add(new Stand(ZONA_LIBROS, "Fondo de Cultura Económica",
                        "http://www.fceperu.com.pe/index.php",
                        R.drawable.fondodecultura,
                        "Calle Berlín 238 Miraflores, Lima, Perú", new LatLng(-12.121562,-77.0344537)));
                standsQhatuni.add(new Stand(ZONA_LIBROS, "CYDMA Libros Internacionales",
                        "http://www.cydma.com/",
                        R.drawable.cydma,
                        "Jr. Enrique Barrón N°993 Of. 204 Santa Beatriz", new LatLng(-12.0739655,-77.0353522)));
                standsQhatuni.add(new Stand(ZONA_LIBROS, "Libreria SBS Internacional",
                        "https://www.sbs.com.pe/",
                        R.drawable.logo_sbs,
                        "Av. Angamos Oeste 301, Miraflores", new LatLng(-12.113961,-77.0336607)));
                standsQhatuni.add(new Stand(ZONA_LIBROS, "IBERO Librerias",
                        "http://www.iberolibrerias.com/",
                        0,
                        "Av. Larco 199 Miraflores, Av. Comandante Espinar 840 Miraflores", new LatLng(-12.1115321,-77.0391619)));
                standsQhatuni.add(new Stand(ZONA_LIBROS, "Pontificia Universidad Católica del Perú",
                        "http://www.fondoeditorial.pucp.edu.pe/",
                        R.drawable.pucp,
                        "Av. Universitaria 1801, San Miguel Lima-32 PERU", new LatLng(-12.068878, -77.079029)));
                standsQhatuni.add(new Stand(ZONA_LIBROS, "Universidad Peruana Cayetano Heredia",
                        "http://ceditorial.cayetano.edu.pe/",
                        R.drawable.logo_upch,
                        "Av. Honorio Delgado 430, Urb. Ingeniería, S.M.P.Lima-Perú.", new LatLng(-12.0245541,-77.0584477)));
                standsQhatuni.add(new Stand(ZONA_LIBROS, "Universidad Nacional Agraria La Molina",
                        "http://www.lamolina.edu.pe/Rectorado/web/boletin_molinero.pdf",
                        R.drawable.logo_unalm,
                        "Av. La Molina s/n La Molina", new LatLng(-12.0828701,-76.9477702)));
                break;

        }

        return standsQhatuni;
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
            listaEditoriales.add(new Editorial("Lumbreras Editores","01-332-3786","Av. Alfonso ugarte 1426, Breña, Lima (1 cuadra de Plaza Bolognesi)", R.drawable.tlumbreras));
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
