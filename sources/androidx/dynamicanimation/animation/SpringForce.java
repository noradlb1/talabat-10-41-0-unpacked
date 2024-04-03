package androidx.dynamicanimation.animation;

import androidx.annotation.FloatRange;
import androidx.annotation.RestrictTo;
import androidx.dynamicanimation.animation.DynamicAnimation;

public final class SpringForce implements Force {
    public static final float DAMPING_RATIO_HIGH_BOUNCY = 0.2f;
    public static final float DAMPING_RATIO_LOW_BOUNCY = 0.75f;
    public static final float DAMPING_RATIO_MEDIUM_BOUNCY = 0.5f;
    public static final float DAMPING_RATIO_NO_BOUNCY = 1.0f;
    public static final float STIFFNESS_HIGH = 10000.0f;
    public static final float STIFFNESS_LOW = 200.0f;
    public static final float STIFFNESS_MEDIUM = 1500.0f;
    public static final float STIFFNESS_VERY_LOW = 50.0f;
    private static final double UNSET = Double.MAX_VALUE;
    private static final double VELOCITY_THRESHOLD_MULTIPLIER = 62.5d;

    /* renamed from: a  reason: collision with root package name */
    public double f35884a = Math.sqrt(1500.0d);

    /* renamed from: b  reason: collision with root package name */
    public double f35885b = 0.5d;
    private double mDampedFreq;
    private double mFinalPosition = Double.MAX_VALUE;
    private double mGammaMinus;
    private double mGammaPlus;
    private boolean mInitialized = false;
    private final DynamicAnimation.MassState mMassState = new DynamicAnimation.MassState();
    private double mValueThreshold;
    private double mVelocityThreshold;

    public SpringForce() {
    }

    private void init() {
        if (!this.mInitialized) {
            if (this.mFinalPosition != Double.MAX_VALUE) {
                double d11 = this.f35885b;
                if (d11 > 1.0d) {
                    double d12 = this.f35884a;
                    this.mGammaPlus = ((-d11) * d12) + (d12 * Math.sqrt((d11 * d11) - 1.0d));
                    double d13 = this.f35885b;
                    double d14 = this.f35884a;
                    this.mGammaMinus = ((-d13) * d14) - (d14 * Math.sqrt((d13 * d13) - 1.0d));
                } else if (d11 >= 0.0d && d11 < 1.0d) {
                    this.mDampedFreq = this.f35884a * Math.sqrt(1.0d - (d11 * d11));
                }
                this.mInitialized = true;
                return;
            }
            throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
        }
    }

    public void a(double d11) {
        double abs = Math.abs(d11);
        this.mValueThreshold = abs;
        this.mVelocityThreshold = abs * VELOCITY_THRESHOLD_MULTIPLIER;
    }

    public DynamicAnimation.MassState b(double d11, double d12, long j11) {
        double d13;
        double d14;
        init();
        double d15 = ((double) j11) / 1000.0d;
        double d16 = d11 - this.mFinalPosition;
        double d17 = this.f35885b;
        if (d17 > 1.0d) {
            double d18 = this.mGammaMinus;
            double d19 = this.mGammaPlus;
            double d21 = d16 - (((d18 * d16) - d12) / (d18 - d19));
            double d22 = ((d16 * d18) - d12) / (d18 - d19);
            d14 = (Math.pow(2.718281828459045d, d18 * d15) * d21) + (Math.pow(2.718281828459045d, this.mGammaPlus * d15) * d22);
            double d23 = this.mGammaMinus;
            double pow = d21 * d23 * Math.pow(2.718281828459045d, d23 * d15);
            double d24 = this.mGammaPlus;
            d13 = pow + (d22 * d24 * Math.pow(2.718281828459045d, d24 * d15));
        } else if (d17 == 1.0d) {
            double d25 = this.f35884a;
            double d26 = d12 + (d25 * d16);
            double d27 = d16 + (d26 * d15);
            d14 = Math.pow(2.718281828459045d, (-d25) * d15) * d27;
            double pow2 = d27 * Math.pow(2.718281828459045d, (-this.f35884a) * d15);
            double d28 = this.f35884a;
            d13 = (d26 * Math.pow(2.718281828459045d, (-d28) * d15)) + (pow2 * (-d28));
        } else {
            double d29 = 1.0d / this.mDampedFreq;
            double d31 = this.f35884a;
            double d32 = d29 * ((d17 * d31 * d16) + d12);
            double pow3 = Math.pow(2.718281828459045d, (-d17) * d31 * d15) * ((Math.cos(this.mDampedFreq * d15) * d16) + (Math.sin(this.mDampedFreq * d15) * d32));
            double d33 = this.f35884a;
            double d34 = this.f35885b;
            double pow4 = Math.pow(2.718281828459045d, (-d34) * d33 * d15);
            double d35 = this.mDampedFreq;
            double d36 = pow3;
            double sin = (-d35) * d16 * Math.sin(d35 * d15);
            double d37 = this.mDampedFreq;
            d13 = ((-d33) * pow3 * d34) + (pow4 * (sin + (d32 * d37 * Math.cos(d37 * d15))));
            d14 = d36;
        }
        DynamicAnimation.MassState massState = this.mMassState;
        massState.f35881a = (float) (d14 + this.mFinalPosition);
        massState.f35882b = (float) d13;
        return massState;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public float getAcceleration(float f11, float f12) {
        float finalPosition = f11 - getFinalPosition();
        double d11 = this.f35884a;
        return (float) (((-(d11 * d11)) * ((double) finalPosition)) - (((d11 * 2.0d) * this.f35885b) * ((double) f12)));
    }

    public float getDampingRatio() {
        return (float) this.f35885b;
    }

    public float getFinalPosition() {
        return (float) this.mFinalPosition;
    }

    public float getStiffness() {
        double d11 = this.f35884a;
        return (float) (d11 * d11);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean isAtEquilibrium(float f11, float f12) {
        if (((double) Math.abs(f12)) >= this.mVelocityThreshold || ((double) Math.abs(f11 - getFinalPosition())) >= this.mValueThreshold) {
            return false;
        }
        return true;
    }

    public SpringForce setDampingRatio(@FloatRange(from = 0.0d) float f11) {
        if (f11 >= 0.0f) {
            this.f35885b = (double) f11;
            this.mInitialized = false;
            return this;
        }
        throw new IllegalArgumentException("Damping ratio must be non-negative");
    }

    public SpringForce setFinalPosition(float f11) {
        this.mFinalPosition = (double) f11;
        return this;
    }

    public SpringForce setStiffness(@FloatRange(from = 0.0d, fromInclusive = false) float f11) {
        if (f11 > 0.0f) {
            this.f35884a = Math.sqrt((double) f11);
            this.mInitialized = false;
            return this;
        }
        throw new IllegalArgumentException("Spring stiffness constant must be positive.");
    }

    public SpringForce(float f11) {
        this.mFinalPosition = (double) f11;
    }
}
