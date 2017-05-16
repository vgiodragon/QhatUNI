package com.smartcity.qhatuni.Carousel;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ArrayAdapter;

import com.smartcity.qhatuni.EditorialesBecas.DetailStand;
import com.smartcity.qhatuni.R;
import com.smartcity.qhatuni.Sensor.Beacons;
import com.smartcity.qhatuni.Sensor.Modelo.Beacon;
import com.smartcity.qhatuni.Sensor.ZonaBeacon;

import java.util.ArrayList;

/**
 * Created by giovanny on 10/04/16.
 *
 *
 *
 */
public class MyGLSurfaceView extends GLSurfaceView {

    MyGLRenderer renderer;    // Custom GL Renderer

    // For touch event
    private final float TOUCH_SCALE_FACTOR = 45.0f / 320.0f;
    private float previousX;
    private float previousY;
    int height ;
    int width ;
    private ArrayList<Byte> xi,yi;

    Beacons beacons;
    ArrayList<Beacon> detectados;
    ArrayList<ZonaBeacon> zonasBeacon;
    ArrayAdapter adaptador;

    public MyGLSurfaceView(Context context,int h, int w,Beacons beacons) {
        super(context);
        float r=10f;

        /*
            Be01 F6:91:19:70:6A:4E
            F9:47:58:EB:AC:A0",//Be02
            CC:1E:66:4C:E6:93",//Be03
            "E2:BE:2C:EC:C0:E2",//Be04
            EA:C6:29:5F:32:4C",//Be05
            C8:1E:15:D5:68:FC",//Be06
            DC:DD:8D:43:9F:8B",//Bea01
            E2:FF:F0:DA:B1:8B",//Bea02
            CF:74:81:B1:FE:70",//Bea03
            C3:B7:4E:8D:D1:E8",//Blanco
         */


        zonasBeacon = new ArrayList<>();
        zonasBeacon.add(new ZonaBeacon("C3:B7:4E:8D:D1:E8",//Blanco
                new CEditorial[]{new CEditorial(R.drawable.tsancristobal, R.drawable.dsancristobal, "sc", r / 3),
                        new CEditorial(R.drawable.tvyt, R.drawable.dcorporativo, "cvt", r / 3),
                        new CEditorial(R.drawable.tonpe, R.drawable.donpe, "onpe", r / 3)}));

        zonasBeacon.add(new ZonaBeacon("CF:74:81:B1:FE:70",//Bea03
                new CEditorial[]{new CEditorial(R.drawable.tsociedadbiblica,R.drawable.dlafamilia, "eduni", r / 3),
                        new CEditorial(R.drawable.talianza,R.drawable.deduni, "af", r / 3),///desalianza
                        new CEditorial(R.drawable.tmunibecas, R.drawable.dmunibecas, "muni", r / 3)}));

        zonasBeacon.add(new ZonaBeacon("E2:FF:F0:DA:B1:8B",//Bea02
                new CEditorial[]{
                        new CEditorial(R.drawable.pronabec,R.drawable.dpronabec, "pronabec", r / 3),//falta pronabec
                        new CEditorial(R.drawable.tfulbright,R.drawable.dfulbright, "fulbright", r / 3),
                        new CEditorial(R.drawable.santander, R.drawable.dsantander, "sa", r / 3)  ///FALTA becas!!
                }));

        zonasBeacon.add(new ZonaBeacon("DC:DD:8D:43:9F:8B",//Bea01
                new CEditorial[]{
                        new CEditorial(R.drawable.posgrado,R.drawable.dposgrado, "posgrado", r / 3),
                        new CEditorial(R.drawable.tbeca,R.drawable.dbeca, "beca18", r / 3),
                        new CEditorial(R.drawable.cepre, R.drawable.dcepre, "cepre", r / 3)}));

        zonasBeacon.add(new ZonaBeacon("C8:1E:15:D5:68:FC",//Be06
                new CEditorial[]{
                        new CEditorial(R.drawable.tullpi,R.drawable.dtullpi, "tullpi", r / 3),
                        new CEditorial(R.drawable.admision,R.drawable.dadmision, "ocad", r / 3),
                        new CEditorial(R.drawable.toficinacentral, R.drawable.dcooperacion, "occic", r / 3)}));///falta cooperacion

        zonasBeacon.add(new ZonaBeacon("F6:91:19:70:6A:4E",//Be01
                new CEditorial[]{
                        new CEditorial(R.drawable.teduni,R.drawable.deduni, "eduni", r / 3),
                        new CEditorial(R.drawable.tlibun,R.drawable.dlibun, "ll", r / 3),
                        new CEditorial(R.drawable.tarcadia,R.drawable.darcadia, "la", r / 3)}));

        zonasBeacon.add(new ZonaBeacon("F9:47:58:EB:AC:A0",//Be02
                new CEditorial[]{
                        new CEditorial(R.drawable.theraldosnegros, R.drawable.dheraldosnegros, "dhn", r / 3),
                        new CEditorial(R.drawable.tpucp,R.drawable.dpucp, "pucp", r / 3),
                        new CEditorial(R.drawable.tminibooks,R.drawable.dminibooks, "mb", r / 3)}));

        zonasBeacon.add(new ZonaBeacon("CC:1E:66:4C:E6:93",//Be03
                new CEditorial[]{
                        new CEditorial(R.drawable.tmancomunidad, R.drawable.dmancomunidad, "mcln", r / 3),
                        new CEditorial(R.drawable.ingenieros,R.drawable.dingenieros, "cip", r / 3),
                        new CEditorial(R.drawable.tfondocultura, R.drawable.dfondodecultura, "fce", r / 3)}));

        zonasBeacon.add(new ZonaBeacon("E2:BE:2C:EC:C0:E2",//Be04
                new CEditorial[]{
                        new CEditorial(R.drawable.tlafamilia,R.drawable.dlafamilia, "llf", r / 3),////ACA DESCRIP!!!!
                        new CEditorial(R.drawable.tmacro, R.drawable.dmacro, "eirl", r / 3),
                        new CEditorial(R.drawable.tlumbreras, R.drawable.dlumbreras, "lumbre", r / 3)////ACA DESCRIP!!!!
                }));

        zonasBeacon.add(new ZonaBeacon("EA:C6:29:5F:32:4C",//Be05
                new CEditorial[]{
                        new CEditorial(R.drawable.cydma, R.drawable.dcydma, "cydma", r / 3),
                        new CEditorial(R.drawable.treverte, R.drawable.dreverte, "ersa", r / 3),
                        new CEditorial(R.drawable.torem, R.drawable.dorem, "eo", r / 3)}));


        renderer = new MyGLRenderer(context,r,zonasBeacon);
        height = h;
        width = w;
        xi = yi = new ArrayList<>();
        this.beacons=beacons;
        this.setRenderer(renderer);

        // Request focus, otherwise key/button won't react
        this.requestFocus();
        this.setFocusableInTouchMode(true);
        HiloBeacon();
        //adaptador = new StandArrayAdapter(getContext(), DataEdBe.STANDS);
    }

    // Handler for touch event
    @Override
    public boolean onTouchEvent(final MotionEvent evt) {
        float currentX = evt.getX();
        float currentY = evt.getY();
        float deltaX, deltaY;

        xi.add((byte) 1);
        yi.add((byte) 1);


        switch (evt.getAction()) {
            case MotionEvent.ACTION_UP:
                //String aux = String.format("xi.size():%d_yi.size():%d_currentX:%.2f_currentY:%.2f",xi.size(),yi.size(),currentX,currentY);
                //adaptador = new StandArrayAdapter(v.getContext(), DataEdBe.STANDS, this);
                if(xi.size()+yi.size()<36 &&figuraDentro(currentX,currentY)){
                    //int position=0;
                    //final BuildingStand item = (BuildingStand)adaptador.getItem(position);
                    Bundle arguments = new Bundle();
                    //String name;
                    //final BuildingStand item = name;
                    String salta=renderer.getNameinfo();
                    arguments.putString("layout", salta);
                    android.support.v4.app.Fragment fragment = new DetailStand();
                    fragment.setArguments(arguments);
                    ((AppCompatActivity)getContext()).getSupportFragmentManager().beginTransaction()
                            .setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.pop_enter,R.anim.pop_exit)
                            .replace(R.id.principal,fragment).addToBackStack(null).commit();

                    break;
                }
                xi.clear();
                yi.clear();
                break;

            case MotionEvent.ACTION_MOVE:
                // Modify rotational angles according to movement
                if(xi.size()+yi.size()>24) {
                    deltaX = currentX - previousX;
                    deltaY = currentY - previousY;
                    renderer.angleX += deltaY * TOUCH_SCALE_FACTOR;
                    renderer.angleY += deltaX * TOUCH_SCALE_FACTOR;
                    if (deltaX > 0) {
                        renderer.contP = true;
                        renderer.giroX += Math.PI / 180;
                        renderer.contN = false;
                    } else if (deltaX < 0) {
                        renderer.contP = false;
                        renderer.giroX -= Math.PI / 180;
                        renderer.contN = true;
                    }
                }
                break;
        }
        // Save current x, y
        previousX = currentX;
        previousY = currentY;
        requestRender();
        return true;  // Event handled
    }


    private boolean figuraDentro(float x,float y){
        if(width/3<x && x<2*width/3) {
            if ( height / 4 < y && y < 2 * height / 3)
                return true;
        }
        return false;
    }


    public void esperoTiempo(int Time){
        try {
            Thread.sleep(Time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private void HiloBeacon() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {

                    if (beacons.numDetec() > 0) {
                        detectados = beacons.getDetectados();
                        int zonaAct=renderer.getZonaActual();
                        showBeacon();
                        for(int i=0;i<zonasBeacon.size();i++){
                            if(detectados.get(0).getMAC().equals(zonasBeacon.get(i).getMAC()) && (int)((zonaAct+1.f)/(i+1.f))!=1){
                                renderer.setZonaActual(i);
                                //requestRender();
                                break;
                            }
                        }
                    }
                    beacons.detectadosReset();

                    esperoTiempo(1000);
                }
            }
        }).start();
    }

    public void showBeacon(){
        String res;
        for(int i=0;i<detectados.size();i++){
            res=detectados.get(i).getMAC()+"_"+detectados.get(i).getRSSI();
            Log.d("beacons",i+": "+res);
        }
    }
}