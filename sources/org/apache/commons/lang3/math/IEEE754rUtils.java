package org.apache.commons.lang3.math;

public class IEEE754rUtils {
    public static double max(double[] dArr) {
        if (dArr == null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (dArr.length != 0) {
            double d11 = dArr[0];
            for (int i11 = 1; i11 < dArr.length; i11++) {
                d11 = max(dArr[i11], d11);
            }
            return d11;
        } else {
            throw new IllegalArgumentException("Array cannot be empty.");
        }
    }

    public static double min(double[] dArr) {
        if (dArr == null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (dArr.length != 0) {
            double d11 = dArr[0];
            for (int i11 = 1; i11 < dArr.length; i11++) {
                d11 = min(dArr[i11], d11);
            }
            return d11;
        } else {
            throw new IllegalArgumentException("Array cannot be empty.");
        }
    }

    public static float max(float[] fArr) {
        if (fArr == null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (fArr.length != 0) {
            float f11 = fArr[0];
            for (int i11 = 1; i11 < fArr.length; i11++) {
                f11 = max(fArr[i11], f11);
            }
            return f11;
        } else {
            throw new IllegalArgumentException("Array cannot be empty.");
        }
    }

    public static float min(float[] fArr) {
        if (fArr == null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (fArr.length != 0) {
            float f11 = fArr[0];
            for (int i11 = 1; i11 < fArr.length; i11++) {
                f11 = min(fArr[i11], f11);
            }
            return f11;
        } else {
            throw new IllegalArgumentException("Array cannot be empty.");
        }
    }

    public static double max(double d11, double d12, double d13) {
        return max(max(d11, d12), d13);
    }

    public static double min(double d11, double d12, double d13) {
        return min(min(d11, d12), d13);
    }

    public static double max(double d11, double d12) {
        if (Double.isNaN(d11)) {
            return d12;
        }
        if (Double.isNaN(d12)) {
            return d11;
        }
        return Math.max(d11, d12);
    }

    public static double min(double d11, double d12) {
        if (Double.isNaN(d11)) {
            return d12;
        }
        if (Double.isNaN(d12)) {
            return d11;
        }
        return Math.min(d11, d12);
    }

    public static float max(float f11, float f12, float f13) {
        return max(max(f11, f12), f13);
    }

    public static float min(float f11, float f12, float f13) {
        return min(min(f11, f12), f13);
    }

    public static float max(float f11, float f12) {
        if (Float.isNaN(f11)) {
            return f12;
        }
        if (Float.isNaN(f12)) {
            return f11;
        }
        return Math.max(f11, f12);
    }

    public static float min(float f11, float f12) {
        if (Float.isNaN(f11)) {
            return f12;
        }
        if (Float.isNaN(f12)) {
            return f11;
        }
        return Math.min(f11, f12);
    }
}
