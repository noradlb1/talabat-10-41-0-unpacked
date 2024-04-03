package com.google.android.material.color;

final class ViewingConditions {
    public static final ViewingConditions DEFAULT = make(ColorUtils.whitePointD65(), (float) ((((double) ColorUtils.yFromLstar(50.0f)) * 63.66197723675813d) / 100.0d), 50.0f, 2.0f, false);

    /* renamed from: aw  reason: collision with root package name */
    private final float f44526aw;

    /* renamed from: c  reason: collision with root package name */
    private final float f44527c;

    /* renamed from: fl  reason: collision with root package name */
    private final float f44528fl;
    private final float flRoot;

    /* renamed from: n  reason: collision with root package name */
    private final float f44529n;
    private final float nbb;

    /* renamed from: nc  reason: collision with root package name */
    private final float f44530nc;
    private final float ncb;
    private final float[] rgbD;

    /* renamed from: z  reason: collision with root package name */
    private final float f44531z;

    private ViewingConditions(float f11, float f12, float f13, float f14, float f15, float f16, float[] fArr, float f17, float f18, float f19) {
        this.f44529n = f11;
        this.f44526aw = f12;
        this.nbb = f13;
        this.ncb = f14;
        this.f44527c = f15;
        this.f44530nc = f16;
        this.rgbD = fArr;
        this.f44528fl = f17;
        this.flRoot = f18;
        this.f44531z = f19;
    }

    public static ViewingConditions make(float[] fArr, float f11, float f12, float f13, boolean z11) {
        float f14;
        float f15;
        float f16 = f11;
        float[][] fArr2 = Cam16.XYZ_TO_CAM16RGB;
        float f17 = fArr[0];
        float[] fArr3 = fArr2[0];
        float f18 = fArr[1];
        float f19 = fArr[2];
        float f21 = (fArr3[0] * f17) + (fArr3[1] * f18) + (fArr3[2] * f19);
        float[] fArr4 = fArr2[1];
        float f22 = (fArr4[0] * f17) + (fArr4[1] * f18) + (fArr4[2] * f19);
        float[] fArr5 = fArr2[2];
        float f23 = (f17 * fArr5[0]) + (f18 * fArr5[1]) + (f19 * fArr5[2]);
        float f24 = (f13 / 10.0f) + 0.8f;
        if (((double) f24) >= 0.9d) {
            f14 = MathUtils.lerp(0.59f, 0.69f, (f24 - 0.9f) * 10.0f);
        } else {
            f14 = MathUtils.lerp(0.525f, 0.59f, (f24 - 0.8f) * 10.0f);
        }
        float f25 = f14;
        if (z11) {
            f15 = 1.0f;
        } else {
            f15 = (1.0f - (((float) Math.exp((double) (((-f16) - 42.0f) / 92.0f))) * 0.2777778f)) * f24;
        }
        double d11 = (double) f15;
        if (d11 > 1.0d) {
            f15 = 1.0f;
        } else if (d11 < 0.0d) {
            f15 = 0.0f;
        }
        float[] fArr6 = {(((100.0f / f21) * f15) + 1.0f) - f15, (((100.0f / f22) * f15) + 1.0f) - f15, (((100.0f / f23) * f15) + 1.0f) - f15};
        float f26 = 1.0f / ((5.0f * f16) + 1.0f);
        float f27 = f26 * f26 * f26 * f26;
        float f28 = 1.0f - f27;
        float cbrt = (f27 * f16) + (0.1f * f28 * f28 * ((float) Math.cbrt(((double) f16) * 5.0d)));
        float yFromLstar = ColorUtils.yFromLstar(f12) / fArr[1];
        double d12 = (double) yFromLstar;
        float sqrt = ((float) Math.sqrt(d12)) + 1.48f;
        float pow = 0.725f / ((float) Math.pow(d12, 0.2d));
        float pow2 = (float) Math.pow(((double) ((fArr6[2] * cbrt) * f23)) / 100.0d, 0.42d);
        float[] fArr7 = {(float) Math.pow(((double) ((fArr6[0] * cbrt) * f21)) / 100.0d, 0.42d), (float) Math.pow(((double) ((fArr6[1] * cbrt) * f22)) / 100.0d, 0.42d), pow2};
        float f29 = fArr7[0];
        float f31 = fArr7[1];
        return new ViewingConditions(yFromLstar, ((((f29 * 400.0f) / (f29 + 27.13f)) * 2.0f) + ((f31 * 400.0f) / (f31 + 27.13f)) + (((400.0f * pow2) / (pow2 + 27.13f)) * 0.05f)) * pow, pow, pow, f25, f24, fArr6, cbrt, (float) Math.pow((double) cbrt, 0.25d), sqrt);
    }

    public float getAw() {
        return this.f44526aw;
    }

    public float getC() {
        return this.f44527c;
    }

    public float getFl() {
        return this.f44528fl;
    }

    public float getFlRoot() {
        return this.flRoot;
    }

    public float getN() {
        return this.f44529n;
    }

    public float getNbb() {
        return this.nbb;
    }

    public float getNc() {
        return this.f44530nc;
    }

    public float getNcb() {
        return this.ncb;
    }

    public float[] getRgbD() {
        return this.rgbD;
    }

    public float getZ() {
        return this.f44531z;
    }
}
