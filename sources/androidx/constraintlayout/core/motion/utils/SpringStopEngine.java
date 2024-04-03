package androidx.constraintlayout.core.motion.utils;

public class SpringStopEngine implements StopEngine {
    private static final double UNSET = Double.MAX_VALUE;

    /* renamed from: a  reason: collision with root package name */
    public double f10617a = 0.5d;
    private int mBoundaryMode = 0;
    private boolean mInitialized = false;
    private float mLastTime;
    private double mLastVelocity;
    private float mMass;
    private float mPos;
    private double mStiffness;
    private float mStopThreshold;
    private double mTargetPos;
    private float mV;

    private void compute(double d11) {
        double d12 = this.mStiffness;
        double d13 = this.f10617a;
        int sqrt = (int) ((9.0d / ((Math.sqrt(d12 / ((double) this.mMass)) * d11) * 4.0d)) + 1.0d);
        double d14 = d11 / ((double) sqrt);
        int i11 = 0;
        while (i11 < sqrt) {
            float f11 = this.mPos;
            double d15 = this.mTargetPos;
            float f12 = this.mV;
            double d16 = d12;
            float f13 = this.mMass;
            double d17 = d13;
            double d18 = ((double) f12) + ((((((-d12) * (((double) f11) - d15)) - (((double) f12) * d13)) / ((double) f13)) * d14) / 2.0d);
            double d19 = ((((-((((double) f11) + ((d14 * d18) / 2.0d)) - d15)) * d16) - (d18 * d17)) / ((double) f13)) * d14;
            float f14 = (float) (((double) f12) + d19);
            this.mV = f14;
            float f15 = (float) (((double) f11) + ((((double) f12) + (d19 / 2.0d)) * d14));
            this.mPos = f15;
            int i12 = this.mBoundaryMode;
            if (i12 > 0) {
                if (f15 < 0.0f && (i12 & 1) == 1) {
                    this.mPos = -f15;
                    this.mV = -f14;
                }
                float f16 = this.mPos;
                if (f16 > 1.0f && (i12 & 2) == 2) {
                    this.mPos = 2.0f - f16;
                    this.mV = -this.mV;
                }
            }
            i11++;
            d12 = d16;
            d13 = d17;
        }
    }

    public String debug(String str, float f11) {
        return null;
    }

    public float getAcceleration() {
        double d11 = this.mStiffness;
        return ((float) (((-d11) * (((double) this.mPos) - this.mTargetPos)) - (this.f10617a * ((double) this.mV)))) / this.mMass;
    }

    public float getInterpolation(float f11) {
        compute((double) (f11 - this.mLastTime));
        this.mLastTime = f11;
        return this.mPos;
    }

    public float getVelocity() {
        return 0.0f;
    }

    public float getVelocity(float f11) {
        return this.mV;
    }

    public boolean isStopped() {
        double d11 = ((double) this.mPos) - this.mTargetPos;
        double d12 = this.mStiffness;
        double d13 = (double) this.mV;
        if (Math.sqrt((((d13 * d13) * ((double) this.mMass)) + ((d12 * d11) * d11)) / d12) <= ((double) this.mStopThreshold)) {
            return true;
        }
        return false;
    }

    public void springConfig(float f11, float f12, float f13, float f14, float f15, float f16, float f17, int i11) {
        this.mTargetPos = (double) f12;
        this.f10617a = (double) f16;
        this.mInitialized = false;
        this.mPos = f11;
        this.mLastVelocity = (double) f13;
        this.mStiffness = (double) f15;
        this.mMass = f14;
        this.mStopThreshold = f17;
        this.mBoundaryMode = i11;
        this.mLastTime = 0.0f;
    }
}
