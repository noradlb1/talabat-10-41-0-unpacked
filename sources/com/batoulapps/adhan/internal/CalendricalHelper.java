package com.batoulapps.adhan.internal;

class CalendricalHelper {
    public static double a(double d11) {
        return (d11 - 2451545.0d) / 36525.0d;
    }

    public static double b(int i11, int i12, int i13) {
        return c(i11, i12, i13, 0.0d);
    }

    public static double c(int i11, int i12, int i13, double d11) {
        if (i12 <= 2) {
            i11--;
        }
        if (i12 <= 2) {
            i12 += 12;
        }
        double d12 = ((double) i13) + (d11 / 24.0d);
        int i14 = i11 / 100;
        return ((((double) (((int) (((double) (i11 + 4716)) * 365.25d)) + ((int) (((double) (i12 + 1)) * 30.6001d)))) + d12) + ((double) ((2 - i14) + (i14 / 4)))) - 1524.5d;
    }
}
