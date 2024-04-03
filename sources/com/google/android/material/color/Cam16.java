package com.google.android.material.color;

final class Cam16 {
    static final float[][] CAM16RGB_TO_XYZ = {new float[]{1.8620678f, -1.0112547f, 0.14918678f}, new float[]{0.38752654f, 0.62144744f, -0.00897398f}, new float[]{-0.0158415f, -0.03412294f, 1.0499644f}};
    static final float[][] XYZ_TO_CAM16RGB = {new float[]{0.401288f, 0.650173f, -0.051461f}, new float[]{-0.250268f, 1.204414f, 0.045854f}, new float[]{-0.002079f, 0.048952f, 0.953127f}};
    private final float astar;
    private final float bstar;
    private final float chroma;
    private final float hue;

    /* renamed from: j  reason: collision with root package name */
    private final float f44522j;
    private final float jstar;

    /* renamed from: m  reason: collision with root package name */
    private final float f44523m;

    /* renamed from: q  reason: collision with root package name */
    private final float f44524q;

    /* renamed from: s  reason: collision with root package name */
    private final float f44525s;

    private Cam16(float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19) {
        this.hue = f11;
        this.chroma = f12;
        this.f44522j = f13;
        this.f44524q = f14;
        this.f44523m = f15;
        this.f44525s = f16;
        this.jstar = f17;
        this.astar = f18;
        this.bstar = f19;
    }

    public static Cam16 fromInt(int i11) {
        return fromIntInViewingConditions(i11, ViewingConditions.DEFAULT);
    }

    public static Cam16 fromIntInViewingConditions(int i11, ViewingConditions viewingConditions) {
        float f11;
        int i12 = i11;
        float linearized = ColorUtils.linearized(((float) ((16711680 & i12) >> 16)) / 255.0f) * 100.0f;
        float linearized2 = ColorUtils.linearized(((float) ((65280 & i12) >> 8)) / 255.0f) * 100.0f;
        float linearized3 = ColorUtils.linearized(((float) (i12 & 255)) / 255.0f) * 100.0f;
        float f12 = (0.41233894f * linearized) + (0.35762063f * linearized2) + (0.18051042f * linearized3);
        float f13 = (0.2126f * linearized) + (0.7152f * linearized2) + (0.0722f * linearized3);
        float f14 = (linearized * 0.01932141f) + (linearized2 * 0.11916382f) + (linearized3 * 0.9503448f);
        float[][] fArr = XYZ_TO_CAM16RGB;
        float[] fArr2 = fArr[0];
        float f15 = (fArr2[0] * f12) + (fArr2[1] * f13) + (fArr2[2] * f14);
        float[] fArr3 = fArr[1];
        float f16 = (fArr3[0] * f12) + (fArr3[1] * f13) + (fArr3[2] * f14);
        float[] fArr4 = fArr[2];
        float f17 = (f12 * fArr4[0]) + (f13 * fArr4[1]) + (f14 * fArr4[2]);
        float f18 = viewingConditions.getRgbD()[0] * f15;
        float f19 = viewingConditions.getRgbD()[1] * f16;
        float f21 = viewingConditions.getRgbD()[2] * f17;
        float pow = (float) Math.pow(((double) (viewingConditions.getFl() * Math.abs(f18))) / 100.0d, 0.42d);
        float pow2 = (float) Math.pow(((double) (viewingConditions.getFl() * Math.abs(f19))) / 100.0d, 0.42d);
        float pow3 = (float) Math.pow(((double) (viewingConditions.getFl() * Math.abs(f21))) / 100.0d, 0.42d);
        float signum = ((Math.signum(f18) * 400.0f) * pow) / (pow + 27.13f);
        float signum2 = ((Math.signum(f19) * 400.0f) * pow2) / (pow2 + 27.13f);
        float signum3 = ((Math.signum(f21) * 400.0f) * pow3) / (pow3 + 27.13f);
        double d11 = (double) signum3;
        float f22 = signum2 * 20.0f;
        float f23 = (((signum * 20.0f) + f22) + (21.0f * signum3)) / 20.0f;
        float f24 = (((signum * 40.0f) + f22) + signum3) / 20.0f;
        double d12 = (double) (((float) (((double) (signum + signum2)) - (d11 * 2.0d))) / 9.0f);
        double d13 = (double) (((float) (((((double) signum) * 11.0d) + (((double) signum2) * -12.0d)) + d11)) / 11.0f);
        float atan2 = (((float) Math.atan2(d12, d13)) * 180.0f) / 3.1415927f;
        if (atan2 < 0.0f) {
            atan2 += 360.0f;
        } else if (atan2 >= 360.0f) {
            atan2 -= 360.0f;
        }
        float f25 = (3.1415927f * atan2) / 180.0f;
        float pow4 = ((float) Math.pow((double) ((f24 * viewingConditions.getNbb()) / viewingConditions.getAw()), (double) (viewingConditions.getC() * viewingConditions.getZ()))) * 100.0f;
        float c11 = (4.0f / viewingConditions.getC()) * ((float) Math.sqrt((double) (pow4 / 100.0f))) * (viewingConditions.getAw() + 4.0f) * viewingConditions.getFlRoot();
        if (((double) atan2) < 20.14d) {
            f11 = 360.0f + atan2;
        } else {
            f11 = atan2;
        }
        float pow5 = ((float) Math.pow(1.64d - Math.pow(0.29d, (double) viewingConditions.getN()), 0.73d)) * ((float) Math.pow((double) ((((((((float) (Math.cos(Math.toRadians((double) f11) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * viewingConditions.getNc()) * viewingConditions.getNcb()) * ((float) Math.hypot(d13, d12))) / (f23 + 0.305f)), 0.9d));
        float sqrt = pow5 * ((float) Math.sqrt(((double) pow4) / 100.0d));
        float flRoot = sqrt * viewingConditions.getFlRoot();
        float sqrt2 = ((float) Math.sqrt((double) ((pow5 * viewingConditions.getC()) / (viewingConditions.getAw() + 4.0f)))) * 50.0f;
        float f26 = (1.7f * pow4) / ((0.007f * pow4) + 1.0f);
        float log1p = ((float) Math.log1p((double) (0.0228f * flRoot))) * 43.85965f;
        double d14 = (double) f25;
        return new Cam16(atan2, sqrt, pow4, c11, flRoot, sqrt2, f26, log1p * ((float) Math.cos(d14)), log1p * ((float) Math.sin(d14)));
    }

    public static Cam16 fromJch(float f11, float f12, float f13) {
        return fromJchInViewingConditions(f11, f12, f13, ViewingConditions.DEFAULT);
    }

    private static Cam16 fromJchInViewingConditions(float f11, float f12, float f13, ViewingConditions viewingConditions) {
        float f14 = f11;
        double d11 = ((double) f14) / 100.0d;
        float c11 = (4.0f / viewingConditions.getC()) * ((float) Math.sqrt(d11)) * (viewingConditions.getAw() + 4.0f) * viewingConditions.getFlRoot();
        float flRoot = f12 * viewingConditions.getFlRoot();
        float sqrt = ((float) Math.sqrt((double) (((f12 / ((float) Math.sqrt(d11))) * viewingConditions.getC()) / (viewingConditions.getAw() + 4.0f)))) * 50.0f;
        float f15 = (1.7f * f14) / ((0.007f * f14) + 1.0f);
        float log1p = ((float) Math.log1p(((double) flRoot) * 0.0228d)) * 43.85965f;
        double d12 = (double) ((3.1415927f * f13) / 180.0f);
        return new Cam16(f13, f12, f14, c11, flRoot, sqrt, f15, log1p * ((float) Math.cos(d12)), log1p * ((float) Math.sin(d12)));
    }

    public static Cam16 fromUcs(float f11, float f12, float f13) {
        return fromUcsInViewingConditions(f11, f12, f13, ViewingConditions.DEFAULT);
    }

    public static Cam16 fromUcsInViewingConditions(float f11, float f12, float f13, ViewingConditions viewingConditions) {
        double d11 = (double) f12;
        double d12 = (double) f13;
        double expm1 = (Math.expm1(Math.hypot(d11, d12) * 0.02280000038444996d) / 0.02280000038444996d) / ((double) viewingConditions.getFlRoot());
        double atan2 = Math.atan2(d12, d11) * 57.29577951308232d;
        if (atan2 < 0.0d) {
            atan2 += 360.0d;
        }
        return fromJchInViewingConditions(f11 / (1.0f - ((f11 - 100.0f) * 0.007f)), (float) expm1, (float) atan2, viewingConditions);
    }

    public float distance(Cam16 cam16) {
        float jStar = getJStar() - cam16.getJStar();
        float aStar = getAStar() - cam16.getAStar();
        float bStar = getBStar() - cam16.getBStar();
        return (float) (Math.pow(Math.sqrt((double) ((jStar * jStar) + (aStar * aStar) + (bStar * bStar))), 0.63d) * 1.41d);
    }

    public float getAStar() {
        return this.astar;
    }

    public float getBStar() {
        return this.bstar;
    }

    public float getChroma() {
        return this.chroma;
    }

    public float getHue() {
        return this.hue;
    }

    public int getInt() {
        return viewed(ViewingConditions.DEFAULT);
    }

    public float getJ() {
        return this.f44522j;
    }

    public float getJStar() {
        return this.jstar;
    }

    public float getM() {
        return this.f44523m;
    }

    public float getQ() {
        return this.f44524q;
    }

    public float getS() {
        return this.f44525s;
    }

    public int viewed(ViewingConditions viewingConditions) {
        float f11;
        if (((double) getChroma()) == 0.0d || ((double) getJ()) == 0.0d) {
            f11 = 0.0f;
        } else {
            f11 = getChroma() / ((float) Math.sqrt(((double) getJ()) / 100.0d));
        }
        float pow = (float) Math.pow(((double) f11) / Math.pow(1.64d - Math.pow(0.29d, (double) viewingConditions.getN()), 0.73d), 1.1111111111111112d);
        double hue2 = (double) ((getHue() * 3.1415927f) / 180.0f);
        float aw2 = viewingConditions.getAw() * ((float) Math.pow(((double) getJ()) / 100.0d, (1.0d / ((double) viewingConditions.getC())) / ((double) viewingConditions.getZ())));
        float cos = ((float) (Math.cos(2.0d + hue2) + 3.8d)) * 0.25f * 3846.1538f * viewingConditions.getNc() * viewingConditions.getNcb();
        float nbb = aw2 / viewingConditions.getNbb();
        float sin = (float) Math.sin(hue2);
        float cos2 = (float) Math.cos(hue2);
        float f12 = (((0.305f + nbb) * 23.0f) * pow) / (((cos * 23.0f) + ((11.0f * pow) * cos2)) + ((pow * 108.0f) * sin));
        float f13 = cos2 * f12;
        float f14 = f12 * sin;
        float f15 = nbb * 460.0f;
        float f16 = (((451.0f * f13) + f15) + (288.0f * f14)) / 1403.0f;
        float f17 = ((f15 - (891.0f * f13)) - (261.0f * f14)) / 1403.0f;
        float f18 = ((f15 - (f13 * 220.0f)) - (f14 * 6300.0f)) / 1403.0f;
        float signum = Math.signum(f16) * (100.0f / viewingConditions.getFl()) * ((float) Math.pow((double) ((float) Math.max(0.0d, (((double) Math.abs(f16)) * 27.13d) / (400.0d - ((double) Math.abs(f16))))), 2.380952380952381d));
        float signum2 = Math.signum(f17) * (100.0f / viewingConditions.getFl()) * ((float) Math.pow((double) ((float) Math.max(0.0d, (((double) Math.abs(f17)) * 27.13d) / (400.0d - ((double) Math.abs(f17))))), 2.380952380952381d));
        float signum3 = Math.signum(f18) * (100.0f / viewingConditions.getFl()) * ((float) Math.pow((double) ((float) Math.max(0.0d, (((double) Math.abs(f18)) * 27.13d) / (400.0d - ((double) Math.abs(f18))))), 2.380952380952381d));
        float f19 = signum / viewingConditions.getRgbD()[0];
        float f21 = signum2 / viewingConditions.getRgbD()[1];
        float f22 = signum3 / viewingConditions.getRgbD()[2];
        float[][] fArr = CAM16RGB_TO_XYZ;
        float[] fArr2 = fArr[0];
        float f23 = (fArr2[0] * f19) + (fArr2[1] * f21) + (fArr2[2] * f22);
        float[] fArr3 = fArr[1];
        float[] fArr4 = fArr[2];
        return ColorUtils.intFromXyzComponents(f23, (fArr3[0] * f19) + (fArr3[1] * f21) + (fArr3[2] * f22), (f19 * fArr4[0]) + (f21 * fArr4[1]) + (f22 * fArr4[2]));
    }
}
