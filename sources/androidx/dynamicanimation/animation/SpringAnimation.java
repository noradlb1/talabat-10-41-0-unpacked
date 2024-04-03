package androidx.dynamicanimation.animation;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import androidx.dynamicanimation.animation.DynamicAnimation;

public final class SpringAnimation extends DynamicAnimation<SpringAnimation> {
    private static final float UNSET = Float.MAX_VALUE;
    private boolean mEndRequested = false;
    private float mPendingPosition = Float.MAX_VALUE;
    private SpringForce mSpring = null;

    public SpringAnimation(FloatValueHolder floatValueHolder) {
        super(floatValueHolder);
    }

    private void sanityCheck() {
        SpringForce springForce = this.mSpring;
        if (springForce != null) {
            double finalPosition = (double) springForce.getFinalPosition();
            if (finalPosition > ((double) this.f35877g)) {
                throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
            } else if (finalPosition < ((double) this.f35878h)) {
                throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
            }
        } else {
            throw new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
        }
    }

    public void animateToFinalPosition(float f11) {
        if (isRunning()) {
            this.mPendingPosition = f11;
            return;
        }
        if (this.mSpring == null) {
            this.mSpring = new SpringForce(f11);
        }
        this.mSpring.setFinalPosition(f11);
        start();
    }

    public void c(float f11) {
    }

    public boolean canSkipToEnd() {
        return this.mSpring.f35885b > 0.0d;
    }

    public boolean d(long j11) {
        if (this.mEndRequested) {
            float f11 = this.mPendingPosition;
            if (f11 != Float.MAX_VALUE) {
                this.mSpring.setFinalPosition(f11);
                this.mPendingPosition = Float.MAX_VALUE;
            }
            this.f35872b = this.mSpring.getFinalPosition();
            this.f35871a = 0.0f;
            this.mEndRequested = false;
            return true;
        }
        if (this.mPendingPosition != Float.MAX_VALUE) {
            this.mSpring.getFinalPosition();
            long j12 = j11 / 2;
            DynamicAnimation.MassState b11 = this.mSpring.b((double) this.f35872b, (double) this.f35871a, j12);
            this.mSpring.setFinalPosition(this.mPendingPosition);
            this.mPendingPosition = Float.MAX_VALUE;
            DynamicAnimation.MassState b12 = this.mSpring.b((double) b11.f35881a, (double) b11.f35882b, j12);
            this.f35872b = b12.f35881a;
            this.f35871a = b12.f35882b;
        } else {
            DynamicAnimation.MassState b13 = this.mSpring.b((double) this.f35872b, (double) this.f35871a, j11);
            this.f35872b = b13.f35881a;
            this.f35871a = b13.f35882b;
        }
        float max = Math.max(this.f35872b, this.f35878h);
        this.f35872b = max;
        float min = Math.min(max, this.f35877g);
        this.f35872b = min;
        if (!e(min, this.f35871a)) {
            return false;
        }
        this.f35872b = this.mSpring.getFinalPosition();
        this.f35871a = 0.0f;
        return true;
    }

    public boolean e(float f11, float f12) {
        return this.mSpring.isAtEquilibrium(f11, f12);
    }

    public SpringForce getSpring() {
        return this.mSpring;
    }

    public SpringAnimation setSpring(SpringForce springForce) {
        this.mSpring = springForce;
        return this;
    }

    public void skipToEnd() {
        if (!canSkipToEnd()) {
            throw new UnsupportedOperationException("Spring animations can only come to an end when there is damping");
        } else if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        } else if (this.f35876f) {
            this.mEndRequested = true;
        }
    }

    public void start() {
        sanityCheck();
        this.mSpring.a((double) a());
        super.start();
    }

    public <K> SpringAnimation(K k11, FloatPropertyCompat<K> floatPropertyCompat) {
        super(k11, floatPropertyCompat);
    }

    public <K> SpringAnimation(K k11, FloatPropertyCompat<K> floatPropertyCompat, float f11) {
        super(k11, floatPropertyCompat);
        this.mSpring = new SpringForce(f11);
    }
}
