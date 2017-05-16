package com.smartcity.qhatuni.Sensor.Modelo;

import java.util.Comparator;

/**
 * Created by giovanny on 21/04/16.
 */
public class BeaconComparador implements Comparator<Beacon> {
    @Override
    public int compare(Beacon lhs, Beacon rhs) {
        return (int)(rhs.getRSSI()*10 - lhs.getRSSI()*10);
    }
}
