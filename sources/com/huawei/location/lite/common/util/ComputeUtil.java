package com.huawei.location.lite.common.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class ComputeUtil {
    public static final int COMPUTE_ACCURACY = 13;
    private static final DecimalFormat DECIMAL_FORMAT;

    static {
        DecimalFormat decimalFormat = new DecimalFormat("#");
        DECIMAL_FORMAT = decimalFormat;
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
    }

    public static double add(double d11, double d12) {
        return new BigDecimal(String.valueOf(d11)).add(new BigDecimal(String.valueOf(d12))).setScale(13, 4).doubleValue();
    }

    public static double divide(double d11, double d12) {
        return new BigDecimal(String.valueOf(d11)).divide(new BigDecimal(String.valueOf(d12)), 13, 4).doubleValue();
    }

    public static long double2Long(double d11) {
        return Long.parseLong(DECIMAL_FORMAT.format(new BigDecimal(String.valueOf(d11))));
    }

    public static double multiply(double d11, double d12) {
        return new BigDecimal(String.valueOf(d11)).multiply(new BigDecimal(String.valueOf(d12))).setScale(13, 4).doubleValue();
    }

    public static double multiply(double[] dArr) {
        if (dArr == null) {
            return 0.0d;
        }
        double d11 = 1.0d;
        for (double multiply : dArr) {
            d11 = multiply(d11, multiply);
        }
        return d11;
    }

    public static double subtract(double d11, double d12) {
        return new BigDecimal(String.valueOf(d11)).subtract(new BigDecimal(String.valueOf(d12))).setScale(13, 4).doubleValue();
    }
}
