package androidx.core.content.res;

import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.ColorUtils;

class CamColor {
    private static final float CHROMA_SEARCH_ENDPOINT = 0.4f;
    private static final float DE_MAX = 1.0f;
    private static final float DL_MAX = 0.2f;
    private static final float LIGHTNESS_SEARCH_ENDPOINT = 0.01f;
    private final float mAstar;
    private final float mBstar;
    private final float mChroma;
    private final float mHue;
    private final float mJ;
    private final float mJstar;
    private final float mM;
    private final float mQ;
    private final float mS;

    public CamColor(float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19) {
        this.mHue = f11;
        this.mChroma = f12;
        this.mJ = f13;
        this.mQ = f14;
        this.mM = f15;
        this.mS = f16;
        this.mJstar = f17;
        this.mAstar = f18;
        this.mBstar = f19;
    }

    @NonNull
    public static CamColor b(@ColorInt int i11) {
        return c(i11, ViewingConditions.f11278a);
    }

    @NonNull
    public static CamColor c(@ColorInt int i11, @NonNull ViewingConditions viewingConditions) {
        float f11;
        float[] f12 = CamUtils.f(i11);
        float[][] fArr = CamUtils.f11267a;
        float f13 = f12[0];
        float[] fArr2 = fArr[0];
        float f14 = f12[1];
        float f15 = f12[2];
        float f16 = (fArr2[0] * f13) + (fArr2[1] * f14) + (fArr2[2] * f15);
        float[] fArr3 = fArr[1];
        float f17 = (fArr3[0] * f13) + (fArr3[1] * f14) + (fArr3[2] * f15);
        float[] fArr4 = fArr[2];
        float f18 = (f13 * fArr4[0]) + (f14 * fArr4[1]) + (f15 * fArr4[2]);
        float f19 = viewingConditions.i()[0] * f16;
        float f21 = viewingConditions.i()[1] * f17;
        float f22 = viewingConditions.i()[2] * f18;
        float pow = (float) Math.pow(((double) (viewingConditions.c() * Math.abs(f19))) / 100.0d, 0.42d);
        float pow2 = (float) Math.pow(((double) (viewingConditions.c() * Math.abs(f21))) / 100.0d, 0.42d);
        float pow3 = (float) Math.pow(((double) (viewingConditions.c() * Math.abs(f22))) / 100.0d, 0.42d);
        float signum = ((Math.signum(f19) * 400.0f) * pow) / (pow + 27.13f);
        float signum2 = ((Math.signum(f21) * 400.0f) * pow2) / (pow2 + 27.13f);
        float signum3 = ((Math.signum(f22) * 400.0f) * pow3) / (pow3 + 27.13f);
        double d11 = (double) signum3;
        float f23 = ((float) (((((double) signum) * 11.0d) + (((double) signum2) * -12.0d)) + d11)) / 11.0f;
        float f24 = ((float) (((double) (signum + signum2)) - (d11 * 2.0d))) / 9.0f;
        float f25 = signum2 * 20.0f;
        float f26 = (((signum * 20.0f) + f25) + (21.0f * signum3)) / 20.0f;
        float f27 = (((signum * 40.0f) + f25) + signum3) / 20.0f;
        float atan2 = (((float) Math.atan2((double) f24, (double) f23)) * 180.0f) / 3.1415927f;
        if (atan2 < 0.0f) {
            atan2 += 360.0f;
        } else if (atan2 >= 360.0f) {
            atan2 -= 360.0f;
        }
        float f28 = atan2;
        float f29 = (3.1415927f * f28) / 180.0f;
        float pow4 = ((float) Math.pow((double) ((f27 * viewingConditions.f()) / viewingConditions.a()), (double) (viewingConditions.b() * viewingConditions.j()))) * 100.0f;
        float d12 = viewingConditions.d() * (4.0f / viewingConditions.b()) * ((float) Math.sqrt((double) (pow4 / 100.0f))) * (viewingConditions.a() + 4.0f);
        if (((double) f28) < 20.14d) {
            f11 = 360.0f + f28;
        } else {
            f11 = f28;
        }
        float pow5 = ((float) Math.pow(1.64d - Math.pow(0.29d, (double) viewingConditions.e()), 0.73d)) * ((float) Math.pow((double) ((((((((float) (Math.cos(((((double) f11) * 3.141592653589793d) / 180.0d) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * viewingConditions.g()) * viewingConditions.h()) * ((float) Math.sqrt((double) ((f23 * f23) + (f24 * f24))))) / (f26 + 0.305f)), 0.9d));
        float sqrt = pow5 * ((float) Math.sqrt(((double) pow4) / 100.0d));
        float d13 = sqrt * viewingConditions.d();
        float sqrt2 = ((float) Math.sqrt((double) ((pow5 * viewingConditions.b()) / (viewingConditions.a() + 4.0f)))) * 50.0f;
        float f31 = (1.7f * pow4) / ((0.007f * pow4) + 1.0f);
        float log = ((float) Math.log((double) ((0.0228f * d13) + 1.0f))) * 43.85965f;
        double d14 = (double) f29;
        return new CamColor(f28, sqrt, pow4, d12, d13, sqrt2, f31, log * ((float) Math.cos(d14)), log * ((float) Math.sin(d14)));
    }

    @Nullable
    private static CamColor findCamByJ(@FloatRange(from = 0.0d, to = 360.0d) float f11, @FloatRange(from = 0.0d, to = Double.POSITIVE_INFINITY, toInclusive = false) float f12, @FloatRange(from = 0.0d, to = 100.0d) float f13) {
        float f14 = 100.0f;
        float f15 = 1000.0f;
        float f16 = 0.0f;
        CamColor camColor = null;
        float f17 = 1000.0f;
        while (Math.abs(f16 - f14) > 0.01f) {
            float f18 = ((f14 - f16) / 2.0f) + f16;
            int m11 = fromJch(f18, f12, f11).m();
            float b11 = CamUtils.b(m11);
            float abs = Math.abs(f13 - b11);
            if (abs < 0.2f) {
                CamColor b12 = b(m11);
                float a11 = b12.a(fromJch(b12.h(), b12.f(), f11));
                if (a11 <= 1.0f) {
                    camColor = b12;
                    f15 = abs;
                    f17 = a11;
                }
            }
            if (f15 == 0.0f && f17 == 0.0f) {
                break;
            } else if (b11 < f13) {
                f16 = f18;
            } else {
                f14 = f18;
            }
        }
        return camColor;
    }

    @NonNull
    private static CamColor fromJch(@FloatRange(from = 0.0d, to = 100.0d) float f11, @FloatRange(from = 0.0d, to = Double.POSITIVE_INFINITY, toInclusive = false) float f12, @FloatRange(from = 0.0d, to = 360.0d) float f13) {
        return fromJchInFrame(f11, f12, f13, ViewingConditions.f11278a);
    }

    @NonNull
    private static CamColor fromJchInFrame(@FloatRange(from = 0.0d, to = 100.0d) float f11, @FloatRange(from = 0.0d, to = Double.POSITIVE_INFINITY, toInclusive = false) float f12, @FloatRange(from = 0.0d, to = 360.0d) float f13, ViewingConditions viewingConditions) {
        float f14 = f11;
        double d11 = ((double) f14) / 100.0d;
        float b11 = (4.0f / viewingConditions.b()) * ((float) Math.sqrt(d11)) * (viewingConditions.a() + 4.0f) * viewingConditions.d();
        float d12 = f12 * viewingConditions.d();
        float sqrt = ((float) Math.sqrt((double) (((f12 / ((float) Math.sqrt(d11))) * viewingConditions.b()) / (viewingConditions.a() + 4.0f)))) * 50.0f;
        float f15 = (1.7f * f14) / ((0.007f * f14) + 1.0f);
        float log = ((float) Math.log((((double) d12) * 0.0228d) + 1.0d)) * 43.85965f;
        double d13 = (double) ((3.1415927f * f13) / 180.0f);
        return new CamColor(f13, f12, f14, b11, d12, sqrt, f15, log * ((float) Math.cos(d13)), log * ((float) Math.sin(d13)));
    }

    public static int j(@FloatRange(from = 0.0d, to = 360.0d) float f11, @FloatRange(from = 0.0d, to = Double.POSITIVE_INFINITY, toInclusive = false) float f12, @FloatRange(from = 0.0d, to = 100.0d) float f13) {
        return k(f11, f12, f13, ViewingConditions.f11278a);
    }

    @ColorInt
    public static int k(@FloatRange(from = 0.0d, to = 360.0d) float f11, @FloatRange(from = 0.0d, to = Double.POSITIVE_INFINITY, toInclusive = false) float f12, @FloatRange(from = 0.0d, to = 100.0d) float f13, @NonNull ViewingConditions viewingConditions) {
        float f14;
        if (((double) f12) < 1.0d || ((double) Math.round(f13)) <= 0.0d || ((double) Math.round(f13)) >= 100.0d) {
            return CamUtils.a(f13);
        }
        if (f11 < 0.0f) {
            f14 = 0.0f;
        } else {
            f14 = Math.min(360.0f, f11);
        }
        CamColor camColor = null;
        boolean z11 = true;
        float f15 = 0.0f;
        float f16 = f12;
        while (Math.abs(f15 - f12) >= 0.4f) {
            CamColor findCamByJ = findCamByJ(f14, f16, f13);
            if (!z11) {
                if (findCamByJ == null) {
                    f12 = f16;
                } else {
                    f15 = f16;
                    camColor = findCamByJ;
                }
                f16 = ((f12 - f15) / 2.0f) + f15;
            } else if (findCamByJ != null) {
                return findCamByJ.l(viewingConditions);
            } else {
                f16 = ((f12 - f15) / 2.0f) + f15;
                z11 = false;
            }
        }
        if (camColor == null) {
            return CamUtils.a(f13);
        }
        return camColor.l(viewingConditions);
    }

    public float a(@NonNull CamColor camColor) {
        float i11 = i() - camColor.i();
        float d11 = d() - camColor.d();
        float e11 = e() - camColor.e();
        return (float) (Math.pow(Math.sqrt((double) ((i11 * i11) + (d11 * d11) + (e11 * e11))), 0.63d) * 1.41d);
    }

    @FloatRange(from = Double.NEGATIVE_INFINITY, fromInclusive = false, to = Double.POSITIVE_INFINITY, toInclusive = false)
    public float d() {
        return this.mAstar;
    }

    @FloatRange(from = Double.NEGATIVE_INFINITY, fromInclusive = false, to = Double.POSITIVE_INFINITY, toInclusive = false)
    public float e() {
        return this.mBstar;
    }

    @FloatRange(from = 0.0d, to = Double.POSITIVE_INFINITY, toInclusive = false)
    public float f() {
        return this.mChroma;
    }

    @FloatRange(from = 0.0d, to = 360.0d, toInclusive = false)
    public float g() {
        return this.mHue;
    }

    @FloatRange(from = 0.0d, to = 100.0d)
    public float h() {
        return this.mJ;
    }

    @FloatRange(from = 0.0d, to = 100.0d)
    public float i() {
        return this.mJstar;
    }

    @ColorInt
    public int l(@NonNull ViewingConditions viewingConditions) {
        float f11;
        if (((double) f()) == 0.0d || ((double) h()) == 0.0d) {
            f11 = 0.0f;
        } else {
            f11 = f() / ((float) Math.sqrt(((double) h()) / 100.0d));
        }
        float pow = (float) Math.pow(((double) f11) / Math.pow(1.64d - Math.pow(0.29d, (double) viewingConditions.e()), 0.73d), 1.1111111111111112d);
        double g11 = (double) ((g() * 3.1415927f) / 180.0f);
        float a11 = viewingConditions.a() * ((float) Math.pow(((double) h()) / 100.0d, (1.0d / ((double) viewingConditions.b())) / ((double) viewingConditions.j())));
        float cos = ((float) (Math.cos(2.0d + g11) + 3.8d)) * 0.25f * 3846.1538f * viewingConditions.g() * viewingConditions.h();
        float f12 = a11 / viewingConditions.f();
        float sin = (float) Math.sin(g11);
        float cos2 = (float) Math.cos(g11);
        float f13 = (((0.305f + f12) * 23.0f) * pow) / (((cos * 23.0f) + ((11.0f * pow) * cos2)) + ((pow * 108.0f) * sin));
        float f14 = cos2 * f13;
        float f15 = f13 * sin;
        float f16 = f12 * 460.0f;
        float f17 = (((451.0f * f14) + f16) + (288.0f * f15)) / 1403.0f;
        float f18 = ((f16 - (891.0f * f14)) - (261.0f * f15)) / 1403.0f;
        float f19 = ((f16 - (f14 * 220.0f)) - (f15 * 6300.0f)) / 1403.0f;
        float signum = Math.signum(f17) * (100.0f / viewingConditions.c()) * ((float) Math.pow((double) ((float) Math.max(0.0d, (((double) Math.abs(f17)) * 27.13d) / (400.0d - ((double) Math.abs(f17))))), 2.380952380952381d));
        float signum2 = Math.signum(f18) * (100.0f / viewingConditions.c()) * ((float) Math.pow((double) ((float) Math.max(0.0d, (((double) Math.abs(f18)) * 27.13d) / (400.0d - ((double) Math.abs(f18))))), 2.380952380952381d));
        float signum3 = Math.signum(f19) * (100.0f / viewingConditions.c()) * ((float) Math.pow((double) ((float) Math.max(0.0d, (((double) Math.abs(f19)) * 27.13d) / (400.0d - ((double) Math.abs(f19))))), 2.380952380952381d));
        float f21 = signum / viewingConditions.i()[0];
        float f22 = signum2 / viewingConditions.i()[1];
        float f23 = signum3 / viewingConditions.i()[2];
        float[][] fArr = CamUtils.f11268b;
        float[] fArr2 = fArr[0];
        float f24 = (fArr2[0] * f21) + (fArr2[1] * f22) + (fArr2[2] * f23);
        float[] fArr3 = fArr[1];
        float[] fArr4 = fArr[2];
        return ColorUtils.XYZToColor((double) f24, (double) ((fArr3[0] * f21) + (fArr3[1] * f22) + (fArr3[2] * f23)), (double) ((f21 * fArr4[0]) + (f22 * fArr4[1]) + (f23 * fArr4[2])));
    }

    @ColorInt
    public int m() {
        return l(ViewingConditions.f11278a);
    }
}
