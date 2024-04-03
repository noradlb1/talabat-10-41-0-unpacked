package androidx.compose.animation.core;

import kotlin.Metadata;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0003J\b\u0010\u0019\u001a\u00020\u001aH\u0002J0\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001eH\u0000ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u001f\u0010 R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R$\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\n\"\u0004\b\r\u0010\u0004R\u000e\u0010\u000e\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R$\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00038F@FX\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\u0004\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006!"}, d2 = {"Landroidx/compose/animation/core/SpringSimulation;", "", "finalPosition", "", "(F)V", "dampedFreq", "", "value", "dampingRatio", "getDampingRatio", "()F", "setDampingRatio", "getFinalPosition", "setFinalPosition", "gammaMinus", "gammaPlus", "initialized", "", "naturalFreq", "stiffness", "getStiffness", "setStiffness", "getAcceleration", "lastDisplacement", "lastVelocity", "init", "", "updateValues", "Landroidx/compose/animation/core/Motion;", "timeElapsed", "", "updateValues-IJZedt4$animation_core_release", "(FFJ)J", "animation-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SpringSimulation {
    private double dampedFreq;
    private float dampingRatio = 1.0f;
    private float finalPosition;
    private double gammaMinus;
    private double gammaPlus;
    private boolean initialized;
    private double naturalFreq = Math.sqrt(50.0d);

    public SpringSimulation(float f11) {
        this.finalPosition = f11;
    }

    private final void init() {
        boolean z11;
        if (!this.initialized) {
            if (this.finalPosition == SpringSimulationKt.getUNSET()) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                float f11 = this.dampingRatio;
                double d11 = ((double) f11) * ((double) f11);
                if (f11 > 1.0f) {
                    double d12 = this.naturalFreq;
                    double d13 = d11 - ((double) 1);
                    this.gammaPlus = (((double) (-f11)) * d12) + (d12 * Math.sqrt(d13));
                    double d14 = this.naturalFreq;
                    this.gammaMinus = (((double) (-this.dampingRatio)) * d14) - (d14 * Math.sqrt(d13));
                } else if (f11 >= 0.0f && f11 < 1.0f) {
                    this.dampedFreq = this.naturalFreq * Math.sqrt(((double) 1) - d11);
                }
                this.initialized = true;
                return;
            }
            throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
        }
    }

    public final float getAcceleration(float f11, float f12) {
        float f13 = f11 - this.finalPosition;
        double d11 = this.naturalFreq;
        return (float) (((-(d11 * d11)) * ((double) f13)) - (((d11 * 2.0d) * ((double) this.dampingRatio)) * ((double) f12)));
    }

    public final float getDampingRatio() {
        return this.dampingRatio;
    }

    public final float getFinalPosition() {
        return this.finalPosition;
    }

    public final float getStiffness() {
        double d11 = this.naturalFreq;
        return (float) (d11 * d11);
    }

    public final void setDampingRatio(float f11) {
        if (f11 >= 0.0f) {
            this.dampingRatio = f11;
            this.initialized = false;
            return;
        }
        throw new IllegalArgumentException("Damping ratio must be non-negative");
    }

    public final void setFinalPosition(float f11) {
        this.finalPosition = f11;
    }

    public final void setStiffness(float f11) {
        if (getStiffness() > 0.0f) {
            this.naturalFreq = Math.sqrt((double) f11);
            this.initialized = false;
            return;
        }
        throw new IllegalArgumentException("Spring stiffness constant must be positive.");
    }

    /* renamed from: updateValues-IJZedt4$animation_core_release  reason: not valid java name */
    public final long m127updateValuesIJZedt4$animation_core_release(float f11, float f12, long j11) {
        double d11;
        double d12;
        boolean z11;
        float f13 = f12;
        init();
        float f14 = f11 - this.finalPosition;
        double d13 = ((double) j11) / 1000.0d;
        float f15 = this.dampingRatio;
        if (f15 > 1.0f) {
            double d14 = (double) f14;
            double d15 = this.gammaMinus;
            double d16 = (double) f13;
            double d17 = this.gammaPlus;
            double d18 = d14 - (((d15 * d14) - d16) / (d15 - d17));
            double d19 = ((d14 * d15) - d16) / (d15 - d17);
            d12 = (Math.exp(d15 * d13) * d18) + (Math.exp(this.gammaPlus * d13) * d19);
            double d21 = this.gammaMinus;
            double exp = d18 * d21 * Math.exp(d21 * d13);
            double d22 = this.gammaPlus;
            d11 = exp + (d19 * d22 * Math.exp(d22 * d13));
        } else {
            if (f15 == 1.0f) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                double d23 = (double) f13;
                double d24 = this.naturalFreq;
                double d25 = (double) f14;
                double d26 = d23 + (d24 * d25);
                double d27 = d25 + (d26 * d13);
                double exp2 = Math.exp((-d24) * d13) * d27;
                double exp3 = d27 * Math.exp((-this.naturalFreq) * d13);
                double d28 = this.naturalFreq;
                d11 = (exp3 * (-d28)) + (d26 * Math.exp((-d28) * d13));
                d12 = exp2;
            } else {
                double d29 = this.naturalFreq;
                double d31 = (double) f14;
                double d32 = (((double) 1) / this.dampedFreq) * ((((double) f15) * d29 * d31) + ((double) f13));
                double exp4 = Math.exp(((double) (-f15)) * d29 * d13) * ((Math.cos(this.dampedFreq * d13) * d31) + (Math.sin(this.dampedFreq * d13) * d32));
                double d33 = this.naturalFreq;
                float f16 = this.dampingRatio;
                double d34 = (-d33) * exp4 * ((double) f16);
                double exp5 = Math.exp(((double) (-f16)) * d33 * d13);
                double d35 = this.dampedFreq;
                double d36 = exp4;
                double sin = (-d35) * d31 * Math.sin(d35 * d13);
                double d37 = this.dampedFreq;
                d11 = d34 + (exp5 * (sin + (d32 * d37 * Math.cos(d37 * d13))));
                d12 = d36;
            }
        }
        return SpringSimulationKt.Motion((float) (d12 + ((double) this.finalPosition)), (float) d11);
    }
}
