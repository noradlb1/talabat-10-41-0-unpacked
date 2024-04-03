package com.talabat.maputils;

import com.google.android.gms.maps.model.LatLng;

public class SphericalUtil {
    private SphericalUtil() {
    }

    public static double a(LatLng latLng, LatLng latLng2) {
        return distanceRadians(Math.toRadians(latLng.latitude), Math.toRadians(latLng.longitude), Math.toRadians(latLng2.latitude), Math.toRadians(latLng2.longitude));
    }

    public static double computeDistanceBetween(LatLng latLng, LatLng latLng2) {
        return a(latLng, latLng2) * 6371009.0d;
    }

    private static double distanceRadians(double d11, double d12, double d13, double d14) {
        return MathUtil.a(MathUtil.c(d11, d13, d12 - d14));
    }
}
