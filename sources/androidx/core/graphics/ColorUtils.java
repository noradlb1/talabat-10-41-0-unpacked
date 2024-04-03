package androidx.core.graphics;

import android.graphics.Color;
import androidx.annotation.ColorInt;
import androidx.annotation.DoNotInline;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import java.util.Objects;

public final class ColorUtils {
    private static final int MIN_ALPHA_SEARCH_MAX_ITERATIONS = 10;
    private static final int MIN_ALPHA_SEARCH_PRECISION = 1;
    private static final ThreadLocal<double[]> TEMP_ARRAY = new ThreadLocal<>();
    private static final double XYZ_EPSILON = 0.008856d;
    private static final double XYZ_KAPPA = 903.3d;
    private static final double XYZ_WHITE_REFERENCE_X = 95.047d;
    private static final double XYZ_WHITE_REFERENCE_Y = 100.0d;
    private static final double XYZ_WHITE_REFERENCE_Z = 108.883d;

    @RequiresApi(26)
    public static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        public static Color a(Color color, Color color2) {
            if (Objects.equals(color.getModel(), color2.getModel())) {
                if (!Objects.equals(color2.getColorSpace(), color.getColorSpace())) {
                    color = color.convert(color2.getColorSpace());
                }
                float[] a11 = color.getComponents();
                float[] a12 = color2.getComponents();
                float a13 = color.alpha();
                float a14 = color2.alpha() * (1.0f - a13);
                int a15 = color2.getComponentCount() - 1;
                float f11 = a13 + a14;
                a12[a15] = f11;
                if (f11 > 0.0f) {
                    a13 /= f11;
                    a14 /= f11;
                }
                for (int i11 = 0; i11 < a15; i11++) {
                    a12[i11] = (a11[i11] * a13) + (a12[i11] * a14);
                }
                return Color.valueOf(a12, color2.getColorSpace());
            }
            throw new IllegalArgumentException("Color models must match (" + color.getModel() + " vs. " + color2.getModel() + ")");
        }
    }

    private ColorUtils() {
    }

    @ColorInt
    public static int HSLToColor(@NonNull float[] fArr) {
        int i11;
        int i12;
        int i13;
        float f11 = fArr[0];
        float f12 = fArr[1];
        float f13 = fArr[2];
        float abs = (1.0f - Math.abs((f13 * 2.0f) - 1.0f)) * f12;
        float f14 = f13 - (0.5f * abs);
        float abs2 = (1.0f - Math.abs(((f11 / 60.0f) % 2.0f) - 1.0f)) * abs;
        switch (((int) f11) / 60) {
            case 0:
                i13 = Math.round((abs + f14) * 255.0f);
                i12 = Math.round((abs2 + f14) * 255.0f);
                i11 = Math.round(f14 * 255.0f);
                break;
            case 1:
                i13 = Math.round((abs2 + f14) * 255.0f);
                i12 = Math.round((abs + f14) * 255.0f);
                i11 = Math.round(f14 * 255.0f);
                break;
            case 2:
                i13 = Math.round(f14 * 255.0f);
                i12 = Math.round((abs + f14) * 255.0f);
                i11 = Math.round((abs2 + f14) * 255.0f);
                break;
            case 3:
                i13 = Math.round(f14 * 255.0f);
                i12 = Math.round((abs2 + f14) * 255.0f);
                i11 = Math.round((abs + f14) * 255.0f);
                break;
            case 4:
                i13 = Math.round((abs2 + f14) * 255.0f);
                i12 = Math.round(f14 * 255.0f);
                i11 = Math.round((abs + f14) * 255.0f);
                break;
            case 5:
            case 6:
                i13 = Math.round((abs + f14) * 255.0f);
                i12 = Math.round(f14 * 255.0f);
                i11 = Math.round((abs2 + f14) * 255.0f);
                break;
            default:
                i11 = 0;
                i13 = 0;
                i12 = 0;
                break;
        }
        return Color.rgb(constrain(i13, 0, 255), constrain(i12, 0, 255), constrain(i11, 0, 255));
    }

    @ColorInt
    public static int LABToColor(@FloatRange(from = 0.0d, to = 100.0d) double d11, @FloatRange(from = -128.0d, to = 127.0d) double d12, @FloatRange(from = -128.0d, to = 127.0d) double d13) {
        double[] tempDouble3Array = getTempDouble3Array();
        LABToXYZ(d11, d12, d13, tempDouble3Array);
        return XYZToColor(tempDouble3Array[0], tempDouble3Array[1], tempDouble3Array[2]);
    }

    public static void LABToXYZ(@FloatRange(from = 0.0d, to = 100.0d) double d11, @FloatRange(from = -128.0d, to = 127.0d) double d12, @FloatRange(from = -128.0d, to = 127.0d) double d13, @NonNull double[] dArr) {
        double d14;
        double d15 = (d11 + 16.0d) / 116.0d;
        double d16 = (d12 / 500.0d) + d15;
        double d17 = d15 - (d13 / 200.0d);
        double pow = Math.pow(d16, 3.0d);
        if (pow <= XYZ_EPSILON) {
            pow = ((d16 * 116.0d) - 16.0d) / XYZ_KAPPA;
        }
        if (d11 > 7.9996247999999985d) {
            d14 = Math.pow(d15, 3.0d);
        } else {
            d14 = d11 / XYZ_KAPPA;
        }
        double pow2 = Math.pow(d17, 3.0d);
        if (pow2 <= XYZ_EPSILON) {
            pow2 = ((d17 * 116.0d) - 16.0d) / XYZ_KAPPA;
        }
        dArr[0] = pow * XYZ_WHITE_REFERENCE_X;
        dArr[1] = d14 * 100.0d;
        dArr[2] = pow2 * XYZ_WHITE_REFERENCE_Z;
    }

    public static void RGBToHSL(@IntRange(from = 0, to = 255) int i11, @IntRange(from = 0, to = 255) int i12, @IntRange(from = 0, to = 255) int i13, @NonNull float[] fArr) {
        float f11;
        float f12;
        float f13 = ((float) i11) / 255.0f;
        float f14 = ((float) i12) / 255.0f;
        float f15 = ((float) i13) / 255.0f;
        float max = Math.max(f13, Math.max(f14, f15));
        float min = Math.min(f13, Math.min(f14, f15));
        float f16 = max - min;
        float f17 = (max + min) / 2.0f;
        if (max == min) {
            f11 = 0.0f;
            f12 = 0.0f;
        } else {
            if (max == f13) {
                f11 = ((f14 - f15) / f16) % 6.0f;
            } else if (max == f14) {
                f11 = ((f15 - f13) / f16) + 2.0f;
            } else {
                f11 = 4.0f + ((f13 - f14) / f16);
            }
            f12 = f16 / (1.0f - Math.abs((2.0f * f17) - 1.0f));
        }
        float f18 = (f11 * 60.0f) % 360.0f;
        if (f18 < 0.0f) {
            f18 += 360.0f;
        }
        fArr[0] = constrain(f18, 0.0f, 360.0f);
        fArr[1] = constrain(f12, 0.0f, 1.0f);
        fArr[2] = constrain(f17, 0.0f, 1.0f);
    }

    public static void RGBToLAB(@IntRange(from = 0, to = 255) int i11, @IntRange(from = 0, to = 255) int i12, @IntRange(from = 0, to = 255) int i13, @NonNull double[] dArr) {
        RGBToXYZ(i11, i12, i13, dArr);
        XYZToLAB(dArr[0], dArr[1], dArr[2], dArr);
    }

    public static void RGBToXYZ(@IntRange(from = 0, to = 255) int i11, @IntRange(from = 0, to = 255) int i12, @IntRange(from = 0, to = 255) int i13, @NonNull double[] dArr) {
        double d11;
        double d12;
        double d13;
        double[] dArr2 = dArr;
        if (dArr2.length == 3) {
            double d14 = ((double) i11) / 255.0d;
            if (d14 < 0.04045d) {
                d11 = d14 / 12.92d;
            } else {
                d11 = Math.pow((d14 + 0.055d) / 1.055d, 2.4d);
            }
            double d15 = ((double) i12) / 255.0d;
            if (d15 < 0.04045d) {
                d12 = d15 / 12.92d;
            } else {
                d12 = Math.pow((d15 + 0.055d) / 1.055d, 2.4d);
            }
            double d16 = ((double) i13) / 255.0d;
            if (d16 < 0.04045d) {
                d13 = d16 / 12.92d;
            } else {
                d13 = Math.pow((d16 + 0.055d) / 1.055d, 2.4d);
            }
            dArr2[0] = ((0.4124d * d11) + (0.3576d * d12) + (0.1805d * d13)) * 100.0d;
            dArr2[1] = ((0.2126d * d11) + (0.7152d * d12) + (0.0722d * d13)) * 100.0d;
            dArr2[2] = ((d11 * 0.0193d) + (d12 * 0.1192d) + (d13 * 0.9505d)) * 100.0d;
            return;
        }
        throw new IllegalArgumentException("outXyz must have a length of 3.");
    }

    @ColorInt
    public static int XYZToColor(@FloatRange(from = 0.0d, to = 95.047d) double d11, @FloatRange(from = 0.0d, to = 100.0d) double d12, @FloatRange(from = 0.0d, to = 108.883d) double d13) {
        double d14;
        double d15;
        double d16;
        double d17 = (((3.2406d * d11) + (-1.5372d * d12)) + (-0.4986d * d13)) / 100.0d;
        double d18 = (((-0.9689d * d11) + (1.8758d * d12)) + (0.0415d * d13)) / 100.0d;
        double d19 = (((0.0557d * d11) + (-0.204d * d12)) + (1.057d * d13)) / 100.0d;
        if (d17 > 0.0031308d) {
            d14 = (Math.pow(d17, 0.4166666666666667d) * 1.055d) - 0.055d;
        } else {
            d14 = d17 * 12.92d;
        }
        if (d18 > 0.0031308d) {
            d15 = (Math.pow(d18, 0.4166666666666667d) * 1.055d) - 0.055d;
        } else {
            d15 = d18 * 12.92d;
        }
        if (d19 > 0.0031308d) {
            d16 = (Math.pow(d19, 0.4166666666666667d) * 1.055d) - 0.055d;
        } else {
            d16 = d19 * 12.92d;
        }
        return Color.rgb(constrain((int) Math.round(d14 * 255.0d), 0, 255), constrain((int) Math.round(d15 * 255.0d), 0, 255), constrain((int) Math.round(d16 * 255.0d), 0, 255));
    }

    public static void XYZToLAB(@FloatRange(from = 0.0d, to = 95.047d) double d11, @FloatRange(from = 0.0d, to = 100.0d) double d12, @FloatRange(from = 0.0d, to = 108.883d) double d13, @NonNull double[] dArr) {
        if (dArr.length == 3) {
            double pivotXyzComponent = pivotXyzComponent(d11 / XYZ_WHITE_REFERENCE_X);
            double pivotXyzComponent2 = pivotXyzComponent(d12 / 100.0d);
            double pivotXyzComponent3 = pivotXyzComponent(d13 / XYZ_WHITE_REFERENCE_Z);
            dArr[0] = Math.max(0.0d, (116.0d * pivotXyzComponent2) - 16.0d);
            dArr[1] = (pivotXyzComponent - pivotXyzComponent2) * 500.0d;
            dArr[2] = (pivotXyzComponent2 - pivotXyzComponent3) * 200.0d;
            return;
        }
        throw new IllegalArgumentException("outLab must have a length of 3.");
    }

    @VisibleForTesting
    public static float a(float f11, float f12, float f13) {
        if (Math.abs(f12 - f11) > 180.0f) {
            if (f12 > f11) {
                f11 += 360.0f;
            } else {
                f12 += 360.0f;
            }
        }
        return (f11 + ((f12 - f11) * f13)) % 360.0f;
    }

    @ColorInt
    public static int blendARGB(@ColorInt int i11, @ColorInt int i12, @FloatRange(from = 0.0d, to = 1.0d) float f11) {
        float f12 = 1.0f - f11;
        return Color.argb((int) ((((float) Color.alpha(i11)) * f12) + (((float) Color.alpha(i12)) * f11)), (int) ((((float) Color.red(i11)) * f12) + (((float) Color.red(i12)) * f11)), (int) ((((float) Color.green(i11)) * f12) + (((float) Color.green(i12)) * f11)), (int) ((((float) Color.blue(i11)) * f12) + (((float) Color.blue(i12)) * f11)));
    }

    public static void blendHSL(@NonNull float[] fArr, @NonNull float[] fArr2, @FloatRange(from = 0.0d, to = 1.0d) float f11, @NonNull float[] fArr3) {
        if (fArr3.length == 3) {
            float f12 = 1.0f - f11;
            fArr3[0] = a(fArr[0], fArr2[0], f11);
            fArr3[1] = (fArr[1] * f12) + (fArr2[1] * f11);
            fArr3[2] = (fArr[2] * f12) + (fArr2[2] * f11);
            return;
        }
        throw new IllegalArgumentException("result must have a length of 3.");
    }

    public static void blendLAB(@NonNull double[] dArr, @NonNull double[] dArr2, @FloatRange(from = 0.0d, to = 1.0d) double d11, @NonNull double[] dArr3) {
        if (dArr3.length == 3) {
            double d12 = 1.0d - d11;
            dArr3[0] = (dArr[0] * d12) + (dArr2[0] * d11);
            dArr3[1] = (dArr[1] * d12) + (dArr2[1] * d11);
            dArr3[2] = (dArr[2] * d12) + (dArr2[2] * d11);
            return;
        }
        throw new IllegalArgumentException("outResult must have a length of 3.");
    }

    public static double calculateContrast(@ColorInt int i11, @ColorInt int i12) {
        if (Color.alpha(i12) == 255) {
            if (Color.alpha(i11) < 255) {
                i11 = compositeColors(i11, i12);
            }
            double calculateLuminance = calculateLuminance(i11) + 0.05d;
            double calculateLuminance2 = calculateLuminance(i12) + 0.05d;
            return Math.max(calculateLuminance, calculateLuminance2) / Math.min(calculateLuminance, calculateLuminance2);
        }
        throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(i12));
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public static double calculateLuminance(@ColorInt int i11) {
        double[] tempDouble3Array = getTempDouble3Array();
        colorToXYZ(i11, tempDouble3Array);
        return tempDouble3Array[1] / 100.0d;
    }

    public static int calculateMinimumAlpha(@ColorInt int i11, @ColorInt int i12, float f11) {
        int i13 = 255;
        if (Color.alpha(i12) == 255) {
            double d11 = (double) f11;
            if (calculateContrast(setAlphaComponent(i11, 255), i12) < d11) {
                return -1;
            }
            int i14 = 0;
            for (int i15 = 0; i15 <= 10 && i13 - i14 > 1; i15++) {
                int i16 = (i14 + i13) / 2;
                if (calculateContrast(setAlphaComponent(i11, i16), i12) < d11) {
                    i14 = i16;
                } else {
                    i13 = i16;
                }
            }
            return i13;
        }
        throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(i12));
    }

    public static void colorToHSL(@ColorInt int i11, @NonNull float[] fArr) {
        RGBToHSL(Color.red(i11), Color.green(i11), Color.blue(i11), fArr);
    }

    public static void colorToLAB(@ColorInt int i11, @NonNull double[] dArr) {
        RGBToLAB(Color.red(i11), Color.green(i11), Color.blue(i11), dArr);
    }

    public static void colorToXYZ(@ColorInt int i11, @NonNull double[] dArr) {
        RGBToXYZ(Color.red(i11), Color.green(i11), Color.blue(i11), dArr);
    }

    private static int compositeAlpha(int i11, int i12) {
        return 255 - (((255 - i12) * (255 - i11)) / 255);
    }

    public static int compositeColors(@ColorInt int i11, @ColorInt int i12) {
        int alpha = Color.alpha(i12);
        int alpha2 = Color.alpha(i11);
        int compositeAlpha = compositeAlpha(alpha2, alpha);
        return Color.argb(compositeAlpha, compositeComponent(Color.red(i11), alpha2, Color.red(i12), alpha, compositeAlpha), compositeComponent(Color.green(i11), alpha2, Color.green(i12), alpha, compositeAlpha), compositeComponent(Color.blue(i11), alpha2, Color.blue(i12), alpha, compositeAlpha));
    }

    private static int compositeComponent(int i11, int i12, int i13, int i14, int i15) {
        if (i15 == 0) {
            return 0;
        }
        return (((i11 * 255) * i12) + ((i13 * i14) * (255 - i12))) / (i15 * 255);
    }

    private static float constrain(float f11, float f12, float f13) {
        return f11 < f12 ? f12 : Math.min(f11, f13);
    }

    public static double distanceEuclidean(@NonNull double[] dArr, @NonNull double[] dArr2) {
        return Math.sqrt(Math.pow(dArr[0] - dArr2[0], 2.0d) + Math.pow(dArr[1] - dArr2[1], 2.0d) + Math.pow(dArr[2] - dArr2[2], 2.0d));
    }

    private static double[] getTempDouble3Array() {
        ThreadLocal<double[]> threadLocal = TEMP_ARRAY;
        double[] dArr = threadLocal.get();
        if (dArr != null) {
            return dArr;
        }
        double[] dArr2 = new double[3];
        threadLocal.set(dArr2);
        return dArr2;
    }

    private static double pivotXyzComponent(double d11) {
        return d11 > XYZ_EPSILON ? Math.pow(d11, 0.3333333333333333d) : ((d11 * XYZ_KAPPA) + 16.0d) / 116.0d;
    }

    @ColorInt
    public static int setAlphaComponent(@ColorInt int i11, @IntRange(from = 0, to = 255) int i12) {
        if (i12 >= 0 && i12 <= 255) {
            return (i11 & 16777215) | (i12 << 24);
        }
        throw new IllegalArgumentException("alpha must be between 0 and 255.");
    }

    private static int constrain(int i11, int i12, int i13) {
        return i11 < i12 ? i12 : Math.min(i11, i13);
    }

    @RequiresApi(26)
    @NonNull
    public static Color compositeColors(@NonNull Color color, @NonNull Color color2) {
        return Api26Impl.a(color, color2);
    }
}
