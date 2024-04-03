package com.google.android.material.color;

import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import java.util.Arrays;

final class ColorUtils {
    private static final float[] WHITE_POINT_D65 = {95.047f, 100.0f, 108.883f};

    private ColorUtils() {
    }

    public static int blueFromInt(int i11) {
        return i11 & 255;
    }

    public static float delinearized(float f11) {
        return f11 <= 0.0031308f ? f11 * 12.92f : (((float) Math.pow((double) f11, 0.4166666567325592d)) * 1.055f) - 0.055f;
    }

    public static int greenFromInt(int i11) {
        return (i11 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
    }

    public static String hexFromInt(int i11) {
        int redFromInt = redFromInt(i11);
        int blueFromInt = blueFromInt(i11);
        return String.format("#%02x%02x%02x", new Object[]{Integer.valueOf(redFromInt), Integer.valueOf(greenFromInt(i11)), Integer.valueOf(blueFromInt)});
    }

    public static int intFromLab(double d11, double d12, double d13) {
        double d14;
        double d15 = (d11 + 16.0d) / 116.0d;
        double d16 = (d12 / 500.0d) + d15;
        double d17 = d15 - (d13 / 200.0d);
        double d18 = d16 * d16 * d16;
        if (d18 <= 0.008856451679035631d) {
            d18 = ((d16 * 116.0d) - 16.0d) / 903.2962962962963d;
        }
        if (d11 > 8.0d) {
            d14 = d15 * d15 * d15;
        } else {
            d14 = d11 / 903.2962962962963d;
        }
        double d19 = d17 * d17 * d17;
        if (d19 <= 0.008856451679035631d) {
            d19 = ((d17 * 116.0d) - 16.0d) / 903.2962962962963d;
        }
        float[] fArr = WHITE_POINT_D65;
        return intFromXyzComponents((float) (d18 * ((double) fArr[0])), (float) (d14 * ((double) fArr[1])), (float) (d19 * ((double) fArr[2])));
    }

    public static int intFromLstar(float f11) {
        boolean z11;
        boolean z12;
        float f12;
        float f13;
        float f14 = (f11 + 16.0f) / 116.0f;
        float f15 = f14 * f14 * f14;
        if (f15 > 0.008856452f) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (f11 > 8.0f) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z12) {
            f12 = f15;
        } else {
            f12 = f11 / 903.2963f;
        }
        if (z11) {
            f13 = f15;
        } else {
            f13 = ((f14 * 116.0f) - 16.0f) / 903.2963f;
        }
        if (!z11) {
            f15 = ((f14 * 116.0f) - 16.0f) / 903.2963f;
        }
        float[] fArr = WHITE_POINT_D65;
        return intFromXyz(new float[]{f13 * fArr[0], f12 * fArr[1], f15 * fArr[2]});
    }

    public static int intFromRgb(int i11, int i12, int i13) {
        return (((((i11 & 255) << 16) | ViewCompat.MEASURED_STATE_MASK) | ((i12 & 255) << 8)) | (i13 & 255)) >>> 0;
    }

    public static int intFromXyz(float[] fArr) {
        return intFromXyzComponents(fArr[0], fArr[1], fArr[2]);
    }

    public static int intFromXyzComponents(float f11, float f12, float f13) {
        float f14 = f11 / 100.0f;
        float f15 = f12 / 100.0f;
        float f16 = f13 / 100.0f;
        float f17 = (3.2406f * f14) + (-1.5372f * f15) + (-0.4986f * f16);
        float f18 = (f14 * 0.0557f) + (f15 * -0.204f) + (f16 * 1.057f);
        return intFromRgb(Math.max(Math.min(255, Math.round(delinearized(f17) * 255.0f)), 0), Math.max(Math.min(255, Math.round(delinearized((-0.9689f * f14) + (1.8758f * f15) + (0.0415f * f16)) * 255.0f)), 0), Math.max(Math.min(255, Math.round(delinearized(f18) * 255.0f)), 0));
    }

    public static double[] labFromInt(int i11) {
        double d11;
        double d12;
        double d13;
        float[] xyzFromInt = xyzFromInt(i11);
        float f11 = xyzFromInt[1];
        float[] fArr = WHITE_POINT_D65;
        double d14 = (double) (f11 / fArr[1]);
        if (d14 > 0.008856451679035631d) {
            d11 = Math.cbrt(d14);
        } else {
            d11 = ((d14 * 903.2962962962963d) + 16.0d) / 116.0d;
        }
        double d15 = (double) (xyzFromInt[0] / fArr[0]);
        if (d15 > 0.008856451679035631d) {
            d12 = Math.cbrt(d15);
        } else {
            d12 = ((d15 * 903.2962962962963d) + 16.0d) / 116.0d;
        }
        double d16 = (double) (xyzFromInt[2] / fArr[2]);
        if (d16 > 0.008856451679035631d) {
            d13 = Math.cbrt(d16);
        } else {
            d13 = ((d16 * 903.2962962962963d) + 16.0d) / 116.0d;
        }
        return new double[]{(116.0d * d11) - 16.0d, (d12 - d11) * 500.0d, (d11 - d13) * 200.0d};
    }

    public static float linearized(float f11) {
        return f11 <= 0.04045f ? f11 / 12.92f : (float) Math.pow((double) ((f11 + 0.055f) / 1.055f), 2.4000000953674316d);
    }

    public static float lstarFromInt(int i11) {
        return (float) labFromInt(i11)[0];
    }

    public static int redFromInt(int i11) {
        return (i11 & 16711680) >> 16;
    }

    public static final float[] whitePointD65() {
        return Arrays.copyOf(WHITE_POINT_D65, 3);
    }

    public static float[] xyzFromInt(int i11) {
        float linearized = linearized(((float) redFromInt(i11)) / 255.0f) * 100.0f;
        float linearized2 = linearized(((float) greenFromInt(i11)) / 255.0f) * 100.0f;
        float linearized3 = linearized(((float) blueFromInt(i11)) / 255.0f) * 100.0f;
        return new float[]{(0.41233894f * linearized) + (0.35762063f * linearized2) + (0.18051042f * linearized3), (0.2126f * linearized) + (0.7152f * linearized2) + (0.0722f * linearized3), (linearized * 0.01932141f) + (linearized2 * 0.11916382f) + (linearized3 * 0.9503448f)};
    }

    public static float yFromLstar(float f11) {
        return (f11 > 8.0f ? (float) Math.pow((((double) f11) + 16.0d) / 116.0d, 3.0d) : f11 / 903.2963f) * 100.0f;
    }
}
