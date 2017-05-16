package com.smartcity.qhatuni.Sensor;

import android.content.Context;

import com.smartcity.qhatuni.Carousel.CEditorial;

import javax.microedition.khronos.opengles.GL10;

/**
 * zzzCreated by giovanny on 21/04/16.
 */
public class ZonaBeacon {
    String Mac;
    CEditorial[] CEditorial;
    public float getAngulos(int i) {
        return angulos[i];
    }

    public float getAng() {
        return ang;
    }

    public int getActual() {
        return actual;
    }

    int elements;
    float[] angulos;
    float ang;

    public void setActual(int actual) {
        this.actual = actual;
    }

    public void restarActual(){
        this.actual=elements;
    }

    int actual;

    public ZonaBeacon(String mac, CEditorial nodeList []) {
        Mac = mac;
        CEditorial = nodeList;
    }

    public void setElements(int elements, float[] angulos, float ang,int actual) {
        this.elements = elements;
        this.angulos = angulos;
        this.ang = ang;
        this.actual=actual;
    }

    public int getidescripcion(){
        return (elements-actual%elements)%elements;
    }

    public String getMAC(){
        return Mac;
    }

    public void loadTexture(GL10 gl, Context context){
        for (CEditorial element : CEditorial) {
            element.loadTexture(gl,context);
        }
    }

    public String getInfoEditorial(int i){
        return CEditorial[i].getCnombre();
    }

    public void drawL(GL10 gl,int i){
        CEditorial[i].drawL(gl);
    }

    public void drawD(GL10 gl,int i){
        CEditorial[i].drawD(gl);
    }

    public int ArrayLength(){
        return CEditorial.length;
    }
}
