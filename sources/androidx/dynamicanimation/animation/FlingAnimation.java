package androidx.dynamicanimation.animation;

import androidx.annotation.FloatRange;
import androidx.dynamicanimation.animation.DynamicAnimation;

public final class FlingAnimation extends DynamicAnimation<FlingAnimation> {
    private final DragForce mFlingForce;

    public static final class DragForce implements Force {
        private static final float DEFAULT_FRICTION = -4.2f;
        private static final float VELOCITY_THRESHOLD_MULTIPLIER = 62.5f;
        private float mFriction = DEFAULT_FRICTION;
        private final DynamicAnimation.MassState mMassState = new DynamicAnimation.MassState();
        private float mVelocityThreshold;

        public float a() {
            return this.mFriction / DEFAULT_FRICTION;
        }

        public void b(float f11) {
            this.mFriction = f11 * DEFAULT_FRICTION;
        }

        public void c(float f11) {
            this.mVelocityThreshold = f11 * VELOCITY_THRESHOLD_MULTIPLIER;
        }

        public DynamicAnimation.MassState d(float f11, float f12, long j11) {
            float f13 = (float) j11;
            this.mMassState.f35882b = (float) (((double) f12) * Math.exp((double) ((f13 / 1000.0f) * this.mFriction)));
            DynamicAnimation.MassState massState = this.mMassState;
            float f14 = this.mFriction;
            massState.f35881a = (float) (((double) (f11 - (f12 / f14))) + (((double) (f12 / f14)) * Math.exp((double) ((f14 * f13) / 1000.0f))));
            DynamicAnimation.MassState massState2 = this.mMassState;
            if (isAtEquilibrium(massState2.f35881a, massState2.f35882b)) {
                this.mMassState.f35882b = 0.0f;
            }
            return this.mMassState;
        }

        public float getAcceleration(float f11, float f12) {
            return f12 * this.mFriction;
        }

        public boolean isAtEquilibrium(float f11, float f12) {
            return Math.abs(f12) < this.mVelocityThreshold;
        }
    }

    public FlingAnimation(FloatValueHolder floatValueHolder) {
        super(floatValueHolder);
        DragForce dragForce = new DragForce();
        this.mFlingForce = dragForce;
        dragForce.c(a());
    }

    public void c(float f11) {
        this.mFlingForce.c(f11);
    }

    public boolean d(long j11) {
        DynamicAnimation.MassState d11 = this.mFlingForce.d(this.f35872b, this.f35871a, j11);
        float f11 = d11.f35881a;
        this.f35872b = f11;
        float f12 = d11.f35882b;
        this.f35871a = f12;
        float f13 = this.f35878h;
        if (f11 < f13) {
            this.f35872b = f13;
            return true;
        }
        float f14 = this.f35877g;
        if (f11 > f14) {
            this.f35872b = f14;
            return true;
        } else if (e(f11, f12)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean e(float f11, float f12) {
        if (f11 >= this.f35877g || f11 <= this.f35878h || this.mFlingForce.isAtEquilibrium(f11, f12)) {
            return true;
        }
        return false;
    }

    public float getFriction() {
        return this.mFlingForce.a();
    }

    public FlingAnimation setFriction(@FloatRange(from = 0.0d, fromInclusive = false) float f11) {
        if (f11 > 0.0f) {
            this.mFlingForce.b(f11);
            return this;
        }
        throw new IllegalArgumentException("Friction must be positive");
    }

    public FlingAnimation setMaxValue(float f11) {
        super.setMaxValue(f11);
        return this;
    }

    public FlingAnimation setMinValue(float f11) {
        super.setMinValue(f11);
        return this;
    }

    public FlingAnimation setStartVelocity(float f11) {
        super.setStartVelocity(f11);
        return this;
    }

    public <K> FlingAnimation(K k11, FloatPropertyCompat<K> floatPropertyCompat) {
        super(k11, floatPropertyCompat);
        DragForce dragForce = new DragForce();
        this.mFlingForce = dragForce;
        dragForce.c(a());
    }
}
