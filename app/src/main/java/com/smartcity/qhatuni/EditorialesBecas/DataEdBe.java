package com.smartcity.qhatuni.EditorialesBecas;

import com.smartcity.qhatuni.R;

import java.util.ArrayList;
import java.util.List;

public class DataEdBe {
    static List STANDS = new ArrayList<BuildingStand>();
    static List BECAS = new ArrayList<BuildingStand>();
    static List UNI = new ArrayList<BuildingStand>();
    static {

        STANDS.add(new BuildingStand("MINIBOOKS", R.drawable.mb,"mb"));
        STANDS.add(new BuildingStand("Librería Libun",R.drawable.ll,"ll"));
        STANDS.add(new BuildingStand("Librería Arcadia",R.drawable.la,"la"));
        STANDS.add(new BuildingStand("Distribuidora Heraldos Negros",R.drawable.heraldos,"dhn"));
        STANDS.add(new BuildingStand("Fondo Editorial Pontificia Universidad Católica del Perú",R.drawable.pucp,"pucp"));
        STANDS.add(new BuildingStand("Fondo de Cultura Económica",R.drawable.fce,"fce"));
        STANDS.add(new BuildingStand("Librería La Familia",R.drawable.familia,"llf"));
        STANDS.add(new BuildingStand("Editorial Macro EIRL",R.drawable.eirl,"eirl"));
        STANDS.add(new BuildingStand("Lumbreras Editores",R.drawable.lumbre,"lumbre"));
        STANDS.add(new BuildingStand("Corporativo V y T",R.drawable.cvt,"cvt"));
        STANDS.add(new BuildingStand("CYDMA TECH SAC",R.drawable.cydma,"cydma"));
        STANDS.add(new BuildingStand("Editorial Reverte S.A.",R.drawable.ersa,"ersa"));
        STANDS.add(new BuildingStand("Ediciones Orem",R.drawable.eo,"eo"));
        STANDS.add(new BuildingStand("Sociedad San Pablo",R.drawable.ssp,"ssp"));
        STANDS.add(new BuildingStand("Fondo Editorial Universidad Inca Garcilazo de la Vega",R.drawable.uigv,"uigv"));
        STANDS.add(new BuildingStand("Oficina Nacional de Procesos Electorales",R.drawable.onpe,"onpe"));
        STANDS.add(new BuildingStand("Librería San Cristobal",R.drawable.sc,"sc"));
        STANDS.add(new BuildingStand("Editorial EDUNI",R.drawable.eduni,"eduni"));
    }

    static {
        BECAS.add(new BuildingStand("Beca 18",R.drawable.beca18,"beca18"));
        BECAS.add(new BuildingStand("Oficina Central de Cooperación Internacional y Convenios",R.drawable.occic,"occic"));
        BECAS.add(new BuildingStand("Programa Nacional de Becas",R.drawable.pronabec,"pronabec"));
        BECAS.add(new BuildingStand("Colegio de Ingenieros del Perú",R.drawable.cip,"cip"));
        BECAS.add(new BuildingStand("Museo Andrés del Castillo",R.drawable.mac,"mac"));
        BECAS.add(new BuildingStand("Tullpi",R.drawable.tullpi,"tullpi"));
        BECAS.add(new BuildingStand("CONCYTEC",R.drawable.concytec,"concytec"));
        BECAS.add(new BuildingStand("Fulbright",R.drawable.fulbright,"fulbright"));
        BECAS.add(new BuildingStand("Mancomunidad de Lima Norte",R.drawable.mcln,"mcln"));
        BECAS.add(new BuildingStand("Muni Becas",R.drawable.muni,"muni"));
        BECAS.add(new BuildingStand("Alianza Francesa",R.drawable.af,"af"));
        BECAS.add(new BuildingStand("DAAD",R.drawable.daad,"daad"));
        BECAS.add(new BuildingStand("Beca Santander",R.drawable.bs,"bs"));
    }

    static {
        UNI.add(new BuildingStand("Escuela de Posgrado",R.drawable.posgrado,"posgrado"));
        UNI.add(new BuildingStand("Oficina Central de Admisión UNI",R.drawable.ocad,"ocad"));
        UNI.add(new BuildingStand("CEPRE-UNI",R.drawable.cepre,"cepre"));
        UNI.add(new BuildingStand("CEPS-UNI",R.drawable.ceps,"ceps"));
    }
}
