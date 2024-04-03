package com.talabat.maputils;

class MathUtil {
    public static double a(double d11) {
        return Math.asin(Math.sqrt(d11)) * 2.0d;
    }

    public static double b(double d11) {
        double sin = Math.sin(d11 * 0.5d);
        return sin * sin;
    }

    public static double c(double d11, double d12, double d13) {
        return b(d11 - d12) + (b(d13) * Math.cos(d11) * Math.cos(d12));
    }

    public static double d(double d11, double d12) {
        return ((d11 % d12) + d12) % d12;
    }

    public static double e(double d11, double d12, double d13) {
        return (d11 < d12 || d11 >= d13) ? d(d11 - d12, d13 - d12) + d12 : d11;
    }
}
