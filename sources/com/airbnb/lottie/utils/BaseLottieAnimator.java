package com.airbnb.lottie.utils;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.os.Build;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public abstract class BaseLottieAnimator extends ValueAnimator {
    private final Set<Animator.AnimatorListener> listeners = new CopyOnWriteArraySet();
    private final Set<ValueAnimator.AnimatorUpdateListener> updateListeners = new CopyOnWriteArraySet();

    public void a() {
        for (Animator.AnimatorListener onAnimationCancel : this.listeners) {
            onAnimationCancel.onAnimationCancel(this);
        }
    }

    public void addListener(Animator.AnimatorListener animatorListener) {
        this.listeners.add(animatorListener);
    }

    public void addUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.updateListeners.add(animatorUpdateListener);
    }

    public void b(boolean z11) {
        for (Animator.AnimatorListener next : this.listeners) {
            if (Build.VERSION.SDK_INT >= 26) {
                next.onAnimationEnd(this, z11);
            } else {
                next.onAnimationEnd(this);
            }
        }
    }

    public void c() {
        for (Animator.AnimatorListener onAnimationRepeat : this.listeners) {
            onAnimationRepeat.onAnimationRepeat(this);
        }
    }

    public void d(boolean z11) {
        for (Animator.AnimatorListener next : this.listeners) {
            if (Build.VERSION.SDK_INT >= 26) {
                next.onAnimationStart(this, z11);
            } else {
                next.onAnimationStart(this);
            }
        }
    }

    public void e() {
        for (ValueAnimator.AnimatorUpdateListener onAnimationUpdate : this.updateListeners) {
            onAnimationUpdate.onAnimationUpdate(this);
        }
    }

    public long getStartDelay() {
        throw new UnsupportedOperationException("LottieAnimator does not support getStartDelay.");
    }

    public void removeAllListeners() {
        this.listeners.clear();
    }

    public void removeAllUpdateListeners() {
        this.updateListeners.clear();
    }

    public void removeListener(Animator.AnimatorListener animatorListener) {
        this.listeners.remove(animatorListener);
    }

    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.updateListeners.remove(animatorUpdateListener);
    }

    public void setInterpolator(TimeInterpolator timeInterpolator) {
        throw new UnsupportedOperationException("LottieAnimator does not support setInterpolator.");
    }

    public void setStartDelay(long j11) {
        throw new UnsupportedOperationException("LottieAnimator does not support setStartDelay.");
    }

    public ValueAnimator setDuration(long j11) {
        throw new UnsupportedOperationException("LottieAnimator does not support setDuration.");
    }
}
