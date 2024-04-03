package com.airbnb.lottie.utils;

import android.view.Choreographer;
import androidx.annotation.FloatRange;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieComposition;

public class LottieValueAnimator extends BaseLottieAnimator implements Choreographer.FrameCallback {
    @VisibleForTesting

    /* renamed from: b  reason: collision with root package name */
    public boolean f40725b = false;
    @Nullable
    private LottieComposition composition;
    private float frame = 0.0f;
    private long lastFrameTimeNs = 0;
    private float maxFrame = 2.14748365E9f;
    private float minFrame = -2.14748365E9f;
    private int repeatCount = 0;
    private float speed = 1.0f;
    private boolean speedReversedForRepeatMode = false;

    private float getFrameDurationNs() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / lottieComposition.getFrameRate()) / Math.abs(this.speed);
    }

    private boolean isReversed() {
        return getSpeed() < 0.0f;
    }

    private void verifyFrame() {
        if (this.composition != null) {
            float f11 = this.frame;
            if (f11 < this.minFrame || f11 > this.maxFrame) {
                throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", new Object[]{Float.valueOf(this.minFrame), Float.valueOf(this.maxFrame), Float.valueOf(this.frame)}));
            }
        }
    }

    public void a() {
        super.a();
        b(isReversed());
    }

    @MainThread
    public void cancel() {
        a();
        g();
    }

    public void clearComposition() {
        this.composition = null;
        this.minFrame = -2.14748365E9f;
        this.maxFrame = 2.14748365E9f;
    }

    public void doFrame(long j11) {
        float f11;
        float f12;
        f();
        if (this.composition != null && isRunning()) {
            L.beginSection("LottieValueAnimator#doFrame");
            long j12 = this.lastFrameTimeNs;
            long j13 = 0;
            if (j12 != 0) {
                j13 = j11 - j12;
            }
            float frameDurationNs = ((float) j13) / getFrameDurationNs();
            float f13 = this.frame;
            if (isReversed()) {
                frameDurationNs = -frameDurationNs;
            }
            float f14 = f13 + frameDurationNs;
            this.frame = f14;
            boolean z11 = !MiscUtils.contains(f14, getMinFrame(), getMaxFrame());
            this.frame = MiscUtils.clamp(this.frame, getMinFrame(), getMaxFrame());
            this.lastFrameTimeNs = j11;
            e();
            if (z11) {
                if (getRepeatCount() == -1 || this.repeatCount < getRepeatCount()) {
                    c();
                    this.repeatCount++;
                    if (getRepeatMode() == 2) {
                        this.speedReversedForRepeatMode = !this.speedReversedForRepeatMode;
                        reverseAnimationSpeed();
                    } else {
                        if (isReversed()) {
                            f11 = getMaxFrame();
                        } else {
                            f11 = getMinFrame();
                        }
                        this.frame = f11;
                    }
                    this.lastFrameTimeNs = j11;
                } else {
                    if (this.speed < 0.0f) {
                        f12 = getMinFrame();
                    } else {
                        f12 = getMaxFrame();
                    }
                    this.frame = f12;
                    g();
                    b(isReversed());
                }
            }
            verifyFrame();
            L.endSection("LottieValueAnimator#doFrame");
        }
    }

    @MainThread
    public void endAnimation() {
        g();
        b(isReversed());
    }

    public void f() {
        if (isRunning()) {
            h(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    @MainThread
    public void g() {
        h(true);
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getAnimatedFraction() {
        float minFrame2;
        float maxFrame2;
        float minFrame3;
        if (this.composition == null) {
            return 0.0f;
        }
        if (isReversed()) {
            minFrame2 = getMaxFrame() - this.frame;
            maxFrame2 = getMaxFrame();
            minFrame3 = getMinFrame();
        } else {
            minFrame2 = this.frame - getMinFrame();
            maxFrame2 = getMaxFrame();
            minFrame3 = getMinFrame();
        }
        return minFrame2 / (maxFrame2 - minFrame3);
    }

    public Object getAnimatedValue() {
        return Float.valueOf(getAnimatedValueAbsolute());
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getAnimatedValueAbsolute() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            return 0.0f;
        }
        return (this.frame - lottieComposition.getStartFrame()) / (this.composition.getEndFrame() - this.composition.getStartFrame());
    }

    public long getDuration() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            return 0;
        }
        return (long) lottieComposition.getDuration();
    }

    public float getFrame() {
        return this.frame;
    }

    public float getMaxFrame() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            return 0.0f;
        }
        float f11 = this.maxFrame;
        if (f11 == 2.14748365E9f) {
            return lottieComposition.getEndFrame();
        }
        return f11;
    }

    public float getMinFrame() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            return 0.0f;
        }
        float f11 = this.minFrame;
        if (f11 == -2.14748365E9f) {
            return lottieComposition.getStartFrame();
        }
        return f11;
    }

    public float getSpeed() {
        return this.speed;
    }

    @MainThread
    public void h(boolean z11) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z11) {
            this.f40725b = false;
        }
    }

    public boolean isRunning() {
        return this.f40725b;
    }

    @MainThread
    public void pauseAnimation() {
        g();
    }

    @MainThread
    public void playAnimation() {
        float f11;
        this.f40725b = true;
        d(isReversed());
        if (isReversed()) {
            f11 = getMaxFrame();
        } else {
            f11 = getMinFrame();
        }
        setFrame((float) ((int) f11));
        this.lastFrameTimeNs = 0;
        this.repeatCount = 0;
        f();
    }

    @MainThread
    public void resumeAnimation() {
        this.f40725b = true;
        f();
        this.lastFrameTimeNs = 0;
        if (isReversed() && getFrame() == getMinFrame()) {
            this.frame = getMaxFrame();
        } else if (!isReversed() && getFrame() == getMaxFrame()) {
            this.frame = getMinFrame();
        }
    }

    public void reverseAnimationSpeed() {
        setSpeed(-getSpeed());
    }

    public void setComposition(LottieComposition lottieComposition) {
        boolean z11;
        if (this.composition == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        this.composition = lottieComposition;
        if (z11) {
            setMinAndMaxFrames(Math.max(this.minFrame, lottieComposition.getStartFrame()), Math.min(this.maxFrame, lottieComposition.getEndFrame()));
        } else {
            setMinAndMaxFrames((float) ((int) lottieComposition.getStartFrame()), (float) ((int) lottieComposition.getEndFrame()));
        }
        float f11 = this.frame;
        this.frame = 0.0f;
        setFrame((float) ((int) f11));
        e();
    }

    public void setFrame(float f11) {
        if (this.frame != f11) {
            this.frame = MiscUtils.clamp(f11, getMinFrame(), getMaxFrame());
            this.lastFrameTimeNs = 0;
            e();
        }
    }

    public void setMaxFrame(float f11) {
        setMinAndMaxFrames(this.minFrame, f11);
    }

    public void setMinAndMaxFrames(float f11, float f12) {
        float f13;
        float f14;
        if (f11 <= f12) {
            LottieComposition lottieComposition = this.composition;
            if (lottieComposition == null) {
                f13 = -3.4028235E38f;
            } else {
                f13 = lottieComposition.getStartFrame();
            }
            LottieComposition lottieComposition2 = this.composition;
            if (lottieComposition2 == null) {
                f14 = Float.MAX_VALUE;
            } else {
                f14 = lottieComposition2.getEndFrame();
            }
            float clamp = MiscUtils.clamp(f11, f13, f14);
            float clamp2 = MiscUtils.clamp(f12, f13, f14);
            if (clamp != this.minFrame || clamp2 != this.maxFrame) {
                this.minFrame = clamp;
                this.maxFrame = clamp2;
                setFrame((float) ((int) MiscUtils.clamp(this.frame, clamp, clamp2)));
                return;
            }
            return;
        }
        throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", new Object[]{Float.valueOf(f11), Float.valueOf(f12)}));
    }

    public void setMinFrame(int i11) {
        setMinAndMaxFrames((float) i11, (float) ((int) this.maxFrame));
    }

    public void setRepeatMode(int i11) {
        super.setRepeatMode(i11);
        if (i11 != 2 && this.speedReversedForRepeatMode) {
            this.speedReversedForRepeatMode = false;
            reverseAnimationSpeed();
        }
    }

    public void setSpeed(float f11) {
        this.speed = f11;
    }
}
