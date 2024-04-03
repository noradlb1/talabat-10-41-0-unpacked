package androidx.constraintlayout.core.motion.utils;

public class VelocityMatrix {
    private static String TAG = "VelocityMatrix";

    /* renamed from: a  reason: collision with root package name */
    public float f10653a;

    /* renamed from: b  reason: collision with root package name */
    public float f10654b;

    /* renamed from: c  reason: collision with root package name */
    public float f10655c;

    /* renamed from: d  reason: collision with root package name */
    public float f10656d;

    /* renamed from: e  reason: collision with root package name */
    public float f10657e;

    /* renamed from: f  reason: collision with root package name */
    public float f10658f;

    public void applyTransform(float f11, float f12, int i11, int i12, float[] fArr) {
        int i13 = i11;
        float f13 = fArr[0];
        float f14 = fArr[1];
        float f15 = (f11 - 0.5f) * 2.0f;
        float f16 = (f12 - 0.5f) * 2.0f;
        float f17 = f13 + this.f10655c;
        float f18 = f14 + this.f10656d;
        float f19 = f17 + (this.f10653a * f15);
        float f21 = f18 + (this.f10654b * f16);
        float radians = (float) Math.toRadians((double) this.f10657e);
        double radians2 = (double) ((float) Math.toRadians((double) this.f10658f));
        double d11 = (double) (((float) i12) * f16);
        fArr[0] = f19 + (((float) ((((double) (((float) (-i13)) * f15)) * Math.sin(radians2)) - (Math.cos(radians2) * d11))) * radians);
        fArr[1] = f21 + (radians * ((float) ((((double) (((float) i13) * f15)) * Math.cos(radians2)) - (d11 * Math.sin(radians2)))));
    }

    public void clear() {
        this.f10657e = 0.0f;
        this.f10656d = 0.0f;
        this.f10655c = 0.0f;
        this.f10654b = 0.0f;
        this.f10653a = 0.0f;
    }

    public void setRotationVelocity(SplineSet splineSet, float f11) {
        if (splineSet != null) {
            this.f10657e = splineSet.getSlope(f11);
            this.f10658f = splineSet.get(f11);
        }
    }

    public void setScaleVelocity(SplineSet splineSet, SplineSet splineSet2, float f11) {
        if (splineSet != null) {
            this.f10653a = splineSet.getSlope(f11);
        }
        if (splineSet2 != null) {
            this.f10654b = splineSet2.getSlope(f11);
        }
    }

    public void setTranslationVelocity(SplineSet splineSet, SplineSet splineSet2, float f11) {
        if (splineSet != null) {
            this.f10655c = splineSet.getSlope(f11);
        }
        if (splineSet2 != null) {
            this.f10656d = splineSet2.getSlope(f11);
        }
    }

    public void setRotationVelocity(KeyCycleOscillator keyCycleOscillator, float f11) {
        if (keyCycleOscillator != null) {
            this.f10657e = keyCycleOscillator.getSlope(f11);
        }
    }

    public void setScaleVelocity(KeyCycleOscillator keyCycleOscillator, KeyCycleOscillator keyCycleOscillator2, float f11) {
        if (keyCycleOscillator != null) {
            this.f10653a = keyCycleOscillator.getSlope(f11);
        }
        if (keyCycleOscillator2 != null) {
            this.f10654b = keyCycleOscillator2.getSlope(f11);
        }
    }

    public void setTranslationVelocity(KeyCycleOscillator keyCycleOscillator, KeyCycleOscillator keyCycleOscillator2, float f11) {
        if (keyCycleOscillator != null) {
            this.f10655c = keyCycleOscillator.getSlope(f11);
        }
        if (keyCycleOscillator2 != null) {
            this.f10656d = keyCycleOscillator2.getSlope(f11);
        }
    }
}
