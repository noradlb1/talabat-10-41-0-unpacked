package androidx.core.content.res;

import androidx.annotation.NonNull;

final class ViewingConditions {

    /* renamed from: a  reason: collision with root package name */
    public static final ViewingConditions f11278a = k(CamUtils.f11269c, (float) ((((double) CamUtils.h(50.0f)) * 63.66197723675813d) / 100.0d), 50.0f, 2.0f, false);
    private final float mAw;
    private final float mC;
    private final float mFl;
    private final float mFlRoot;
    private final float mN;
    private final float mNbb;
    private final float mNc;
    private final float mNcb;
    private final float[] mRgbD;
    private final float mZ;

    private ViewingConditions(float f11, float f12, float f13, float f14, float f15, float f16, float[] fArr, float f17, float f18, float f19) {
        this.mN = f11;
        this.mAw = f12;
        this.mNbb = f13;
        this.mNcb = f14;
        this.mC = f15;
        this.mNc = f16;
        this.mRgbD = fArr;
        this.mFl = f17;
        this.mFlRoot = f18;
        this.mZ = f19;
    }

    @NonNull
    public static ViewingConditions k(@NonNull float[] fArr, float f11, float f12, float f13, boolean z11) {
        float f14;
        float f15;
        float f16 = f11;
        float[][] fArr2 = CamUtils.f11267a;
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
            f14 = CamUtils.d(0.59f, 0.69f, (f24 - 0.9f) * 10.0f);
        } else {
            f14 = CamUtils.d(0.525f, 0.59f, (f24 - 0.8f) * 10.0f);
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
        float h11 = CamUtils.h(f12) / fArr[1];
        double d12 = (double) h11;
        float sqrt = ((float) Math.sqrt(d12)) + 1.48f;
        float pow = 0.725f / ((float) Math.pow(d12, 0.2d));
        float pow2 = (float) Math.pow(((double) ((fArr6[2] * cbrt) * f23)) / 100.0d, 0.42d);
        float[] fArr7 = {(float) Math.pow(((double) ((fArr6[0] * cbrt) * f21)) / 100.0d, 0.42d), (float) Math.pow(((double) ((fArr6[1] * cbrt) * f22)) / 100.0d, 0.42d), pow2};
        float f29 = fArr7[0];
        float f31 = fArr7[1];
        return new ViewingConditions(h11, ((((f29 * 400.0f) / (f29 + 27.13f)) * 2.0f) + ((f31 * 400.0f) / (f31 + 27.13f)) + (((400.0f * pow2) / (pow2 + 27.13f)) * 0.05f)) * pow, pow, pow, f25, f24, fArr6, cbrt, (float) Math.pow((double) cbrt, 0.25d), sqrt);
    }

    public float a() {
        return this.mAw;
    }

    public float b() {
        return this.mC;
    }

    public float c() {
        return this.mFl;
    }

    public float d() {
        return this.mFlRoot;
    }

    public float e() {
        return this.mN;
    }

    public float f() {
        return this.mNbb;
    }

    public float g() {
        return this.mNc;
    }

    public float h() {
        return this.mNcb;
    }

    @NonNull
    public float[] i() {
        return this.mRgbD;
    }

    public float j() {
        return this.mZ;
    }
}
