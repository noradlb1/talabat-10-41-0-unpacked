package androidx.core.content.res;

import android.graphics.Color;
import androidx.annotation.NonNull;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewCompat;

final class CamUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final float[][] f11267a = {new float[]{0.401288f, 0.650173f, -0.051461f}, new float[]{-0.250268f, 1.204414f, 0.045854f}, new float[]{-0.002079f, 0.048952f, 0.953127f}};

    /* renamed from: b  reason: collision with root package name */
    public static final float[][] f11268b = {new float[]{1.8620678f, -1.0112547f, 0.14918678f}, new float[]{0.38752654f, 0.62144744f, -0.00897398f}, new float[]{-0.0158415f, -0.03412294f, 1.0499644f}};

    /* renamed from: c  reason: collision with root package name */
    public static final float[] f11269c = {95.047f, 100.0f, 108.883f};

    /* renamed from: d  reason: collision with root package name */
    public static final float[][] f11270d = {new float[]{0.41233894f, 0.35762063f, 0.18051042f}, new float[]{0.2126f, 0.7152f, 0.0722f}, new float[]{0.01932141f, 0.11916382f, 0.9503448f}};

    private CamUtils() {
    }

    public static int a(float f11) {
        if (f11 < 1.0f) {
            return ViewCompat.MEASURED_STATE_MASK;
        }
        if (f11 > 99.0f) {
            return -1;
        }
        float f12 = (f11 + 16.0f) / 116.0f;
        float f13 = (f11 > 8.0f ? 1 : (f11 == 8.0f ? 0 : -1)) > 0 ? f12 * f12 * f12 : f11 / 903.2963f;
        float f14 = f12 * f12 * f12;
        boolean z11 = f14 > 0.008856452f;
        float f15 = z11 ? f14 : ((f12 * 116.0f) - 16.0f) / 903.2963f;
        if (!z11) {
            f14 = ((f12 * 116.0f) - 16.0f) / 903.2963f;
        }
        float[] fArr = f11269c;
        return ColorUtils.XYZToColor((double) (f15 * fArr[0]), (double) (f13 * fArr[1]), (double) (f14 * fArr[2]));
    }

    public static float b(int i11) {
        return c(g(i11));
    }

    public static float c(float f11) {
        float f12 = f11 / 100.0f;
        return f12 <= 0.008856452f ? f12 * 903.2963f : (((float) Math.cbrt((double) f12)) * 116.0f) - 16.0f;
    }

    public static float d(float f11, float f12, float f13) {
        return f11 + ((f12 - f11) * f13);
    }

    public static float e(int i11) {
        float f11 = ((float) i11) / 255.0f;
        return (f11 <= 0.04045f ? f11 / 12.92f : (float) Math.pow((double) ((f11 + 0.055f) / 1.055f), 2.4000000953674316d)) * 100.0f;
    }

    @NonNull
    public static float[] f(int i11) {
        float e11 = e(Color.red(i11));
        float e12 = e(Color.green(i11));
        float e13 = e(Color.blue(i11));
        float[][] fArr = f11270d;
        float[] fArr2 = fArr[0];
        float f11 = (fArr2[0] * e11) + (fArr2[1] * e12) + (fArr2[2] * e13);
        float[] fArr3 = fArr[1];
        float f12 = (fArr3[0] * e11) + (fArr3[1] * e12) + (fArr3[2] * e13);
        float[] fArr4 = fArr[2];
        return new float[]{f11, f12, (e11 * fArr4[0]) + (e12 * fArr4[1]) + (e13 * fArr4[2])};
    }

    public static float g(int i11) {
        float e11 = e(Color.red(i11));
        float e12 = e(Color.green(i11));
        float e13 = e(Color.blue(i11));
        float[] fArr = f11270d[1];
        return (e11 * fArr[0]) + (e12 * fArr[1]) + (e13 * fArr[2]);
    }

    public static float h(float f11) {
        return (f11 > 8.0f ? (float) Math.pow((((double) f11) + 16.0d) / 116.0d, 3.0d) : f11 / 903.2963f) * 100.0f;
    }
}
