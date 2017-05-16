package com.smartcity.qhatuni.Carousel;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.GLU;
import android.util.Log;


import com.smartcity.qhatuni.Sensor.ZonaBeacon;

import java.util.ArrayList;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by giovanny on 10/04/16.
 */
public class MyGLRenderer implements GLSurfaceView.Renderer {

    boolean contP=false;
    boolean contN=false;

    private Context context;                           // Context (from Activity)

    // For controlling cube's z-position, x and y angles and speeds (NEW)
    float angleX = 0;   // (NEW)
    float angleY = 0;   // (NEW)

    float r ;

    float xcamera ;
    float ycamera ;
    float zcamera ;

    ArrayList<ZonaBeacon> zonasBeacon;
    int zonaActual;
    int auxZA;
    ZonaBeacon znBAc;
    float giroX;

    public MyGLRenderer(Context context,float radio,ArrayList<ZonaBeacon> zonasBeacon) {
        this.context =context;

        setCamera(new float[]{0f, 40f, 80f});
        //setRadio(10f);
        setRadio(radio);
        this.zonasBeacon=zonasBeacon;

        auxZA=0;
        for(ZonaBeacon zn:zonasBeacon){//iniciar los elementos de cada zona
            giroX = 0;
            int elements=zn.ArrayLength();
            float ang = (float) (2*Math.PI/elements);

            float []angulos=new float[2*elements+1];
            for(int i=0;i<2*elements+1;i++){
                angulos[i] = ang * (-(elements - 1) + i);
                Log.d("ang","_"+i+"_"+angulos[i]);
            }

            int actual = elements;
            zn.setElements(elements, angulos, ang, actual);
        }
        zonaActual=0;

    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        //gl.glClearColor(1.f, 1.f, 1.f, 1.0f);
        gl.glClearColor(1.f,0.894f, 0.711f,1.0f);
        gl.glClearDepthf(1.0f);            // Set depth's clear-value to farthest
        gl.glEnable(GL10.GL_DEPTH_TEST);   // Enables depth-buffer for hidden surface removal
        gl.glDepthFunc(GL10.GL_LEQUAL);    // The type of depth testing to do
        gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST);  // nice perspective view
        gl.glShadeModel(GL10.GL_SMOOTH);   // Enable smooth shading of color
        gl.glDisable(GL10.GL_DITHER);      // Disable dithering for better performance

        gl.glEnable(GL10.GL_TEXTURE_2D);  // Enable texture (NEW)

        gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);  // Set Alpha Blend Function

        for (ZonaBeacon element : zonasBeacon) {
            element.loadTexture(gl, context);
        }
        setZonaActual(0);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        if (height == 0) height = 1;   // To prevent divide by zero
        float aspect = (float)width / height;

        // Set the viewport (display area) to cover the entire window
        GLES20.glViewport(0, 0, width, height);

        // Setup perspective projection, with aspect ratio matches viewport
        gl.glMatrixMode(GL10.GL_PROJECTION); // Select projection matrix
        gl.glLoadIdentity();                 // Reset projection matrix
        // Use perspective projection
        GLU.gluPerspective(gl, 30, aspect, 0.1f, 150.f);
        GLU.gluLookAt(gl, xcamera, ycamera, zcamera,
                0, 0, 0, /* look at the origin */
                0, 1, 0); /* positive Y up vector */

        gl.glMatrixMode(GL10.GL_MODELVIEW);  // Select model-view matrix
        gl.glLoadIdentity();                 // Reset

    }

    public void setCamera(float []v){
        xcamera=v[0];
        ycamera=v[1];
        zcamera=v[2];
    }

    public void setRadio(float radio){
        r=radio;
    }

    public synchronized int getZonaActual() {
        return zonaActual;
    }

    public synchronized void setZonaActual(int zonaActual) {
        giroX=0f;
        ZonaBeacon znBAc2=zonasBeacon.get(this.zonaActual);
        znBAc2.restarActual();
        this.zonaActual = zonaActual;
    }

    public String getNameinfo(){
        auxZA=getZonaActual();
        znBAc=zonasBeacon.get(auxZA);

        /*ahora auxZA me servira para saber la editorial actual*/
        auxZA = znBAc.getidescripcion();
        return znBAc.getInfoEditorial(auxZA);
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        // Clear color and depth buffers
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
        gl.glEnable(GL10.GL_BLEND);                   // Enable Alpha Blend

        gl.glLoadIdentity();                  // Reset the current model-view matrix

        auxZA=getZonaActual();
        znBAc=zonasBeacon.get(auxZA);
        //int actualDes = (elements-actual%elements)%elements
        //Log.d("actualM", "znBAc.getActual():"+znBAc.getActual()+"__znBAc:");

        //ahora auxZA me servira para saber la editorial actual

        auxZA = znBAc.getidescripcion();
        for(int i=0;i<znBAc.ArrayLength();i++) {
            gl.glPushMatrix();
            gl.glTranslatef((float) (r * Math.sin(i * znBAc.getAng() + giroX)), r, (float) (r * Math.cos(i * znBAc.getAng() + giroX)));   // Translate into the screen (NEW)
            znBAc.drawL(gl, i);
            if(i==auxZA && !contP && !contN){
                gl.glTranslatef(0f, -r, 0f);
                gl.glRotatef(-26.5f,1f,0f,0f);
                znBAc.drawD(gl, i);
            }
            gl.glPopMatrix();
        }

        if(contP == true && (znBAc.getAng()+giroX+Math.PI/90) < znBAc.getAngulos(znBAc.getActual()+1)){
            //znBAc.ChangeGiroX(Math.PI / 90);
            giroX+= Math.PI/90;
        }
        else if (contP == true){
            contP=false;
            znBAc.setActual(znBAc.getActual()+1);
            if(znBAc.getActual()>2*znBAc.ArrayLength()-1) {
                znBAc.setActual(znBAc.ArrayLength());
                giroX = 0;
            }
        }

        if(contN == true && (znBAc.getAng()+giroX-Math.PI/90) > znBAc.getAngulos(znBAc.getActual()-1)){
            giroX-= Math.PI/90;
        }

        else if (contN == true){
            contN=false;
            znBAc.setActual(znBAc.getActual()-1);
            if(znBAc.getActual()<1) {
                znBAc.setActual(znBAc.ArrayLength());
                giroX = 0;
            }
        }
    }
}
