package com.google.android.material.color;

final class Blend {
    private static final float HARMONIZE_MAX_DEGREES = 15.0f;
    private static final float HARMONIZE_PERCENTAGE = 0.5f;

    private Blend() {
    }

    public static int blendCam16Ucs(int i11, int i12, float f11) {
        Cam16 fromInt = Cam16.fromInt(i11);
        Cam16 fromInt2 = Cam16.fromInt(i12);
        float jStar = fromInt.getJStar();
        float aStar = fromInt.getAStar();
        float bStar = fromInt.getBStar();
        return Cam16.fromUcs(jStar + ((fromInt2.getJStar() - jStar) * f11), aStar + ((fromInt2.getAStar() - aStar) * f11), bStar + ((fromInt2.getBStar() - bStar) * f11)).getInt();
    }

    public static int blendHctHue(int i11, int i12, float f11) {
        return Hct.from(Cam16.fromInt(blendCam16Ucs(i11, i12, f11)).getHue(), Cam16.fromInt(i11).getChroma(), ColorUtils.lstarFromInt(i11)).toInt();
    }

    public static int harmonize(int i11, int i12) {
        Hct fromInt = Hct.fromInt(i11);
        Hct fromInt2 = Hct.fromInt(i12);
        return Hct.from(MathUtils.sanitizeDegrees(fromInt.getHue() + (Math.min(MathUtils.differenceDegrees(fromInt.getHue(), fromInt2.getHue()) * 0.5f, HARMONIZE_MAX_DEGREES) * rotationDirection(fromInt.getHue(), fromInt2.getHue()))), fromInt.getChroma(), fromInt.getTone()).toInt();
    }

    private static float rotationDirection(float f11, float f12) {
        float f13 = f12 - f11;
        float f14 = f13 + 360.0f;
        float f15 = f13 - 360.0f;
        float abs = Math.abs(f13);
        float abs2 = Math.abs(f14);
        float abs3 = Math.abs(f15);
        if (abs > abs2 || abs > abs3) {
            if (abs2 > abs || abs2 > abs3) {
                if (((double) f15) >= 0.0d) {
                    return 1.0f;
                }
                return -1.0f;
            } else if (((double) f14) >= 0.0d) {
                return 1.0f;
            } else {
                return -1.0f;
            }
        } else if (((double) f13) >= 0.0d) {
            return 1.0f;
        } else {
            return -1.0f;
        }
    }
}
