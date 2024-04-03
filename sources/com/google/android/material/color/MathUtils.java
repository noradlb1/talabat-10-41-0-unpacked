package com.google.android.material.color;

final class MathUtils {
    private MathUtils() {
    }

    public static float clamp(float f11, float f12, float f13) {
        return Math.min(Math.max(f13, f11), f12);
    }

    public static float differenceDegrees(float f11, float f12) {
        return 180.0f - Math.abs(Math.abs(f11 - f12) - 180.0f);
    }

    public static float lerp(float f11, float f12, float f13) {
        return ((1.0f - f13) * f11) + (f13 * f12);
    }

    public static float sanitizeDegrees(float f11) {
        return f11 < 0.0f ? (f11 % 360.0f) + 360.0f : f11 >= 360.0f ? f11 % 360.0f : f11;
    }

    public static int sanitizeDegrees(int i11) {
        if (i11 < 0) {
            return (i11 % 360) + 360;
        }
        if (i11 >= 360) {
            return i11 % 360;
        }
        return i11;
    }

    public static float toDegrees(float f11) {
        return (f11 * 180.0f) / 3.1415927f;
    }

    public static float toRadians(float f11) {
        return (f11 / 180.0f) * 3.1415927f;
    }
}
