package com.huawei.hms.maps.common.util;

import com.huawei.hms.maps.model.LatLng;

public class DistanceCalculator {
    public static double computeDistanceBetween(LatLng latLng, LatLng latLng2) {
        return mab.a(latLng, latLng2);
    }
}
