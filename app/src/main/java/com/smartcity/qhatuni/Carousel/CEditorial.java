package com.smartcity.qhatuni.Carousel;

import android.content.Context;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by giovanny on 30/04/16.
 */
public class CEditorial {
    Cuadrado clogo;
    Cuadrado cdescripcion;
    String cnombre;

    public CEditorial(int logo, int descripcion, String name, float r) {
        clogo= new Cuadrado(logo,r);
        cdescripcion = new Cuadrado(descripcion,3*r/2);
        cnombre = name;
    }

    public String getCnombre(){
        return cnombre;
    }

    public void loadTexture(GL10 gl, Context context){
        clogo.loadTexture(gl,context);
        cdescripcion.loadTexture(gl,context);
    }

    public void drawL(GL10 gl){
        clogo.draw(gl);
    }

    public void drawD(GL10 gl){
        cdescripcion.draw(gl);
    }


}
