package com.smartcity.qhatuni.Sensor.Modelo;

/**
 * Created by giovanny on 21/04/16.
 */
public class Beacon {

    public Beacon(String MAC, int RSSI) {
        this.MAC = MAC;
        this.RSSI = RSSI;
        cantRSSI=1;
    }

    public String getMAC() {
        return MAC;
    }

    public float getRSSI() {
        return RSSI/cantRSSI;
    }

    public void setRSSI(int RSSI) {
        this.RSSI = RSSI;
        cantRSSI++;
    }

    private String MAC;
    private int RSSI;
    private int cantRSSI;

}
