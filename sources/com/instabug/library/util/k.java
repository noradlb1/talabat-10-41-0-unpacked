package com.instabug.library.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public abstract class k {
    public static float a(float f11, int i11) {
        return (f11 * ((float) i11)) / 100.0f;
    }

    public static long a(long j11, int i11) {
        return (j11 * ((long) i11)) / 100;
    }

    public static double a(double d11) {
        return a(new Random().nextDouble() * d11, 2);
    }

    public static double a(double d11, int i11) {
        if (i11 >= 0) {
            return BigDecimal.valueOf(d11).setScale(i11, RoundingMode.HALF_UP).doubleValue();
        }
        throw new IllegalArgumentException();
    }
}
