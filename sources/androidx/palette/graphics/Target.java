package androidx.palette.graphics;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;

public final class Target {
    public static final Target DARK_MUTED;
    public static final Target DARK_VIBRANT;
    public static final Target LIGHT_MUTED;
    public static final Target LIGHT_VIBRANT;
    private static final float MAX_DARK_LUMA = 0.45f;
    private static final float MAX_MUTED_SATURATION = 0.4f;
    private static final float MAX_NORMAL_LUMA = 0.7f;
    private static final float MIN_LIGHT_LUMA = 0.55f;
    private static final float MIN_NORMAL_LUMA = 0.3f;
    private static final float MIN_VIBRANT_SATURATION = 0.35f;
    public static final Target MUTED;
    private static final float TARGET_DARK_LUMA = 0.26f;
    private static final float TARGET_LIGHT_LUMA = 0.74f;
    private static final float TARGET_MUTED_SATURATION = 0.3f;
    private static final float TARGET_NORMAL_LUMA = 0.5f;
    private static final float TARGET_VIBRANT_SATURATION = 1.0f;
    public static final Target VIBRANT;
    private static final float WEIGHT_LUMA = 0.52f;
    private static final float WEIGHT_POPULATION = 0.24f;
    private static final float WEIGHT_SATURATION = 0.24f;

    /* renamed from: a  reason: collision with root package name */
    public final float[] f37278a;

    /* renamed from: b  reason: collision with root package name */
    public final float[] f37279b;

    /* renamed from: c  reason: collision with root package name */
    public final float[] f37280c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f37281d;

    static {
        Target target = new Target();
        LIGHT_VIBRANT = target;
        setDefaultLightLightnessValues(target);
        setDefaultVibrantSaturationValues(target);
        Target target2 = new Target();
        VIBRANT = target2;
        setDefaultNormalLightnessValues(target2);
        setDefaultVibrantSaturationValues(target2);
        Target target3 = new Target();
        DARK_VIBRANT = target3;
        setDefaultDarkLightnessValues(target3);
        setDefaultVibrantSaturationValues(target3);
        Target target4 = new Target();
        LIGHT_MUTED = target4;
        setDefaultLightLightnessValues(target4);
        setDefaultMutedSaturationValues(target4);
        Target target5 = new Target();
        MUTED = target5;
        setDefaultNormalLightnessValues(target5);
        setDefaultMutedSaturationValues(target5);
        Target target6 = new Target();
        DARK_MUTED = target6;
        setDefaultDarkLightnessValues(target6);
        setDefaultMutedSaturationValues(target6);
    }

    public Target() {
        float[] fArr = new float[3];
        this.f37278a = fArr;
        float[] fArr2 = new float[3];
        this.f37279b = fArr2;
        this.f37280c = new float[3];
        this.f37281d = true;
        setTargetDefaultValues(fArr);
        setTargetDefaultValues(fArr2);
        setDefaultWeights();
    }

    private static void setDefaultDarkLightnessValues(Target target) {
        float[] fArr = target.f37279b;
        fArr[1] = 0.26f;
        fArr[2] = 0.45f;
    }

    private static void setDefaultLightLightnessValues(Target target) {
        float[] fArr = target.f37279b;
        fArr[0] = 0.55f;
        fArr[1] = 0.74f;
    }

    private static void setDefaultMutedSaturationValues(Target target) {
        float[] fArr = target.f37278a;
        fArr[1] = 0.3f;
        fArr[2] = 0.4f;
    }

    private static void setDefaultNormalLightnessValues(Target target) {
        float[] fArr = target.f37279b;
        fArr[0] = 0.3f;
        fArr[1] = 0.5f;
        fArr[2] = 0.7f;
    }

    private static void setDefaultVibrantSaturationValues(Target target) {
        float[] fArr = target.f37278a;
        fArr[0] = 0.35f;
        fArr[1] = 1.0f;
    }

    private void setDefaultWeights() {
        float[] fArr = this.f37280c;
        fArr[0] = 0.24f;
        fArr[1] = 0.52f;
        fArr[2] = 0.24f;
    }

    private static void setTargetDefaultValues(float[] fArr) {
        fArr[0] = 0.0f;
        fArr[1] = 0.5f;
        fArr[2] = 1.0f;
    }

    public void a() {
        float f11 = 0.0f;
        for (float f12 : this.f37280c) {
            if (f12 > 0.0f) {
                f11 += f12;
            }
        }
        if (f11 != 0.0f) {
            int length = this.f37280c.length;
            for (int i11 = 0; i11 < length; i11++) {
                float[] fArr = this.f37280c;
                float f13 = fArr[i11];
                if (f13 > 0.0f) {
                    fArr[i11] = f13 / f11;
                }
            }
        }
    }

    public float getLightnessWeight() {
        return this.f37280c[1];
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getMaximumLightness() {
        return this.f37279b[2];
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getMaximumSaturation() {
        return this.f37278a[2];
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getMinimumLightness() {
        return this.f37279b[0];
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getMinimumSaturation() {
        return this.f37278a[0];
    }

    public float getPopulationWeight() {
        return this.f37280c[2];
    }

    public float getSaturationWeight() {
        return this.f37280c[0];
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getTargetLightness() {
        return this.f37279b[1];
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getTargetSaturation() {
        return this.f37278a[1];
    }

    public boolean isExclusive() {
        return this.f37281d;
    }

    public static final class Builder {
        private final Target mTarget;

        public Builder() {
            this.mTarget = new Target();
        }

        @NonNull
        public Target build() {
            return this.mTarget;
        }

        @NonNull
        public Builder setExclusive(boolean z11) {
            this.mTarget.f37281d = z11;
            return this;
        }

        @NonNull
        public Builder setLightnessWeight(@FloatRange(from = 0.0d) float f11) {
            this.mTarget.f37280c[1] = f11;
            return this;
        }

        @NonNull
        public Builder setMaximumLightness(@FloatRange(from = 0.0d, to = 1.0d) float f11) {
            this.mTarget.f37279b[2] = f11;
            return this;
        }

        @NonNull
        public Builder setMaximumSaturation(@FloatRange(from = 0.0d, to = 1.0d) float f11) {
            this.mTarget.f37278a[2] = f11;
            return this;
        }

        @NonNull
        public Builder setMinimumLightness(@FloatRange(from = 0.0d, to = 1.0d) float f11) {
            this.mTarget.f37279b[0] = f11;
            return this;
        }

        @NonNull
        public Builder setMinimumSaturation(@FloatRange(from = 0.0d, to = 1.0d) float f11) {
            this.mTarget.f37278a[0] = f11;
            return this;
        }

        @NonNull
        public Builder setPopulationWeight(@FloatRange(from = 0.0d) float f11) {
            this.mTarget.f37280c[2] = f11;
            return this;
        }

        @NonNull
        public Builder setSaturationWeight(@FloatRange(from = 0.0d) float f11) {
            this.mTarget.f37280c[0] = f11;
            return this;
        }

        @NonNull
        public Builder setTargetLightness(@FloatRange(from = 0.0d, to = 1.0d) float f11) {
            this.mTarget.f37279b[1] = f11;
            return this;
        }

        @NonNull
        public Builder setTargetSaturation(@FloatRange(from = 0.0d, to = 1.0d) float f11) {
            this.mTarget.f37278a[1] = f11;
            return this;
        }

        public Builder(@NonNull Target target) {
            this.mTarget = new Target(target);
        }
    }

    public Target(@NonNull Target target) {
        float[] fArr = new float[3];
        this.f37278a = fArr;
        float[] fArr2 = new float[3];
        this.f37279b = fArr2;
        float[] fArr3 = new float[3];
        this.f37280c = fArr3;
        this.f37281d = true;
        System.arraycopy(target.f37278a, 0, fArr, 0, fArr.length);
        System.arraycopy(target.f37279b, 0, fArr2, 0, fArr2.length);
        System.arraycopy(target.f37280c, 0, fArr3, 0, fArr3.length);
    }
}
