package com.batoulapps.adhan.internal;

import com.batoulapps.adhan.Coordinates;

class Astronomical {
    public static double a(double d11, double d12, double d13) {
        return Math.toDegrees(Math.asin((Math.sin(Math.toRadians(d11)) * Math.sin(Math.toRadians(d12))) + (Math.cos(Math.toRadians(d11)) * Math.cos(Math.toRadians(d12)) * Math.cos(Math.toRadians(d13)))));
    }

    public static double b(double d11, double d12) {
        return d12 + (Math.cos(Math.toRadians(125.04d - (d11 * 1934.136d))) * 0.00256d);
    }

    public static double c(double d11, double d12) {
        return DoubleUtil.c(((d12 + q(d11, m(d11))) - 0.00569d) - (Math.sin(Math.toRadians(125.04d - (d11 * 1934.136d))) * 0.00478d));
    }

    public static double d(double d11, double d12, double d13) {
        return DoubleUtil.b(((d13 + (d11 * -1.0d)) - d12) / 360.0d, 1.0d);
    }

    public static double e(double d11) {
        return DoubleUtil.c((125.04452d - (1934.136261d * d11)) + (Math.pow(d11, 2.0d) * 0.0020708d) + (Math.pow(d11, 3.0d) / 450000.0d));
    }

    public static double f(double d11, double d12, Coordinates coordinates, boolean z11, double d13, double d14, double d15, double d16, double d17, double d18, double d19) {
        double d21;
        Coordinates coordinates2 = coordinates;
        double d22 = coordinates2.longitude * -1.0d;
        double degrees = Math.toDegrees(Math.acos((Math.sin(Math.toRadians(d12)) - (Math.sin(Math.toRadians(coordinates2.latitude)) * Math.sin(Math.toRadians(d17)))) / (Math.cos(Math.toRadians(coordinates2.latitude)) * Math.cos(Math.toRadians(d17))))) / 360.0d;
        if (z11) {
            d21 = d11 + degrees;
        } else {
            d21 = d11 - degrees;
        }
        double c11 = DoubleUtil.c(d13 + (360.985647d * d21));
        double c12 = DoubleUtil.c(i(d14, d15, d16, d21));
        double h11 = h(d17, d18, d19, d21);
        double d23 = (c11 - d22) - c12;
        return (d21 + ((a(coordinates2.latitude, h11, d23) - d12) / (((Math.cos(Math.toRadians(h11)) * 360.0d) * Math.cos(Math.toRadians(coordinates2.latitude))) * Math.sin(Math.toRadians(d23))))) * 24.0d;
    }

    public static double g(double d11, double d12, double d13, double d14, double d15, double d16) {
        return ((DoubleUtil.a((DoubleUtil.c(d13 + (360.985647d * d11)) - (d12 * -1.0d)) - DoubleUtil.c(i(d14, d15, d16, d11))) / -360.0d) + d11) * 24.0d;
    }

    public static double h(double d11, double d12, double d13, double d14) {
        double d15 = d11 - d12;
        double d16 = d13 - d11;
        return d11 + ((d14 / 2.0d) * (d15 + d16 + (d14 * (d16 - d15))));
    }

    public static double i(double d11, double d12, double d13, double d14) {
        double c11 = DoubleUtil.c(d11 - d12);
        double c12 = DoubleUtil.c(d13 - d11);
        return d11 + ((d14 / 2.0d) * (c11 + c12 + (d14 * (c12 - c11))));
    }

    public static double j(double d11) {
        return DoubleUtil.c((d11 * 481267.8813d) + 218.3165d);
    }

    public static double k(double d11) {
        return ((23.439291d - (0.013004167d * d11)) - (Math.pow(d11, 2.0d) * 1.639E-7d)) + (Math.pow(d11, 3.0d) * 5.036E-7d);
    }

    public static double l(double d11) {
        return DoubleUtil.c(((((((36525.0d * d11) + 2451545.0d) - 2451545.0d) * 360.98564736629d) + 280.46061837d) + (Math.pow(d11, 2.0d) * 3.87933E-4d)) - (Math.pow(d11, 3.0d) / 3.871E7d));
    }

    public static double m(double d11) {
        return DoubleUtil.c(((35999.05029d * d11) + 357.52911d) - (Math.pow(d11, 2.0d) * 1.537E-4d));
    }

    public static double n(double d11) {
        return DoubleUtil.c((36000.76983d * d11) + 280.4664567d + (Math.pow(d11, 2.0d) * 3.032E-4d));
    }

    public static double o(double d11, double d12, double d13, double d14) {
        return (((Math.sin(Math.toRadians(d14)) * -0.0047777777777777775d) - (Math.sin(Math.toRadians(d12) * 2.0d) * 3.6666666666666667E-4d)) - (Math.sin(Math.toRadians(d13) * 2.0d) * 6.38888888888889E-5d)) + (Math.sin(Math.toRadians(d14) * 2.0d) * 5.833333333333333E-5d);
    }

    public static double p(double d11, double d12, double d13, double d14) {
        return (((Math.cos(Math.toRadians(d14)) * 0.0025555555555555553d) + (Math.cos(Math.toRadians(d12) * 2.0d) * 1.5833333333333332E-4d)) + (Math.cos(Math.toRadians(d13) * 2.0d) * 2.777777777777778E-5d)) - (Math.cos(Math.toRadians(d14) * 2.0d) * 2.4999999999999998E-5d);
    }

    public static double q(double d11, double d12) {
        double radians = Math.toRadians(d12);
        return (((1.914602d - (0.004817d * d11)) - (Math.pow(d11, 2.0d) * 1.4E-5d)) * Math.sin(radians)) + ((0.019993d - (d11 * 1.01E-4d)) * Math.sin(2.0d * radians)) + (Math.sin(radians * 3.0d) * 2.89E-4d);
    }
}
