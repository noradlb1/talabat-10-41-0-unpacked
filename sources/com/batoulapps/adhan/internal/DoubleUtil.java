package com.batoulapps.adhan.internal;

class DoubleUtil {
    public static double a(double d11) {
        return (d11 < -180.0d || d11 > 180.0d) ? d11 - ((double) (Math.round(d11 / 360.0d) * 360)) : d11;
    }

    public static double b(double d11, double d12) {
        return d11 - (d12 * Math.floor(d11 / d12));
    }

    public static double c(double d11) {
        return b(d11, 360.0d);
    }
}
