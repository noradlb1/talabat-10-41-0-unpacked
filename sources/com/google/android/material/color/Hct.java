package com.google.android.material.color;

final class Hct {
    private static final float CHROMA_SEARCH_ENDPOINT = 0.4f;
    private static final float DE_MAX = 1.0f;
    private static final float DE_MAX_ERROR = 1.0E-9f;
    private static final float DL_MAX = 0.2f;
    private static final float LIGHTNESS_SEARCH_ENDPOINT = 0.01f;
    private float chroma;
    private float hue;
    private float tone;

    private Hct(float f11, float f12, float f13) {
        setInternalState(gamutMap(f11, f12, f13));
    }

    private static Cam16 findCamByJ(float f11, float f12, float f13) {
        float f14 = 100.0f;
        float f15 = 1000.0f;
        float f16 = 0.0f;
        Cam16 cam16 = null;
        float f17 = 1000.0f;
        while (Math.abs(f16 - f14) > 0.01f) {
            float f18 = ((f14 - f16) / 2.0f) + f16;
            int i11 = Cam16.fromJch(f18, f12, f11).getInt();
            float lstarFromInt = ColorUtils.lstarFromInt(i11);
            float abs = Math.abs(f13 - lstarFromInt);
            if (abs < 0.2f) {
                Cam16 fromInt = Cam16.fromInt(i11);
                float distance = fromInt.distance(Cam16.fromJch(fromInt.getJ(), fromInt.getChroma(), f11));
                if (distance <= 1.0f && distance <= f15) {
                    cam16 = fromInt;
                    f17 = abs;
                    f15 = distance;
                }
            }
            if (f17 == 0.0f && f15 < DE_MAX_ERROR) {
                break;
            } else if (lstarFromInt < f13) {
                f16 = f18;
            } else {
                f14 = f18;
            }
        }
        return cam16;
    }

    public static Hct from(float f11, float f12, float f13) {
        return new Hct(f11, f12, f13);
    }

    public static Hct fromInt(int i11) {
        Cam16 fromInt = Cam16.fromInt(i11);
        return new Hct(fromInt.getHue(), fromInt.getChroma(), ColorUtils.lstarFromInt(i11));
    }

    private static int gamutMap(float f11, float f12, float f13) {
        return gamutMapInViewingConditions(f11, f12, f13, ViewingConditions.DEFAULT);
    }

    public static int gamutMapInViewingConditions(float f11, float f12, float f13, ViewingConditions viewingConditions) {
        if (((double) f12) < 1.0d || ((double) Math.round(f13)) <= 0.0d || ((double) Math.round(f13)) >= 100.0d) {
            return ColorUtils.intFromLstar(f13);
        }
        float sanitizeDegrees = MathUtils.sanitizeDegrees(f11);
        Cam16 cam16 = null;
        boolean z11 = true;
        float f14 = 0.0f;
        float f15 = f12;
        while (Math.abs(f14 - f12) >= 0.4f) {
            Cam16 findCamByJ = findCamByJ(sanitizeDegrees, f15, f13);
            if (!z11) {
                if (findCamByJ == null) {
                    f12 = f15;
                } else {
                    f14 = f15;
                    cam16 = findCamByJ;
                }
                f15 = ((f12 - f14) / 2.0f) + f14;
            } else if (findCamByJ != null) {
                return findCamByJ.viewed(viewingConditions);
            } else {
                f15 = ((f12 - f14) / 2.0f) + f14;
                z11 = false;
            }
        }
        if (cam16 == null) {
            return ColorUtils.intFromLstar(f13);
        }
        return cam16.viewed(viewingConditions);
    }

    private void setInternalState(int i11) {
        Cam16 fromInt = Cam16.fromInt(i11);
        float lstarFromInt = ColorUtils.lstarFromInt(i11);
        this.hue = fromInt.getHue();
        this.chroma = fromInt.getChroma();
        this.tone = lstarFromInt;
    }

    public float getChroma() {
        return this.chroma;
    }

    public float getHue() {
        return this.hue;
    }

    public float getTone() {
        return this.tone;
    }

    public void setChroma(float f11) {
        setInternalState(gamutMap(this.hue, f11, this.tone));
    }

    public void setHue(float f11) {
        setInternalState(gamutMap(MathUtils.sanitizeDegrees(f11), this.chroma, this.tone));
    }

    public void setTone(float f11) {
        setInternalState(gamutMap(this.hue, this.chroma, f11));
    }

    public int toInt() {
        return gamutMap(this.hue, this.chroma, this.tone);
    }
}
