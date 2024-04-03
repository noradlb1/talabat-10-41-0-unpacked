package com.nineoldandroids.animation;

import android.view.animation.Interpolator;
import java.util.ArrayList;

public abstract class Animator implements Cloneable {

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<AnimatorListener> f52792b = null;

    public interface AnimatorListener {
        void onAnimationCancel(Animator animator);

        void onAnimationEnd(Animator animator);

        void onAnimationRepeat(Animator animator);

        void onAnimationStart(Animator animator);
    }

    public void addListener(AnimatorListener animatorListener) {
        if (this.f52792b == null) {
            this.f52792b = new ArrayList<>();
        }
        this.f52792b.add(animatorListener);
    }

    public void cancel() {
    }

    public void end() {
    }

    public abstract long getDuration();

    public ArrayList<AnimatorListener> getListeners() {
        return this.f52792b;
    }

    public abstract long getStartDelay();

    public abstract boolean isRunning();

    public boolean isStarted() {
        return isRunning();
    }

    public void removeAllListeners() {
        ArrayList<AnimatorListener> arrayList = this.f52792b;
        if (arrayList != null) {
            arrayList.clear();
            this.f52792b = null;
        }
    }

    public void removeListener(AnimatorListener animatorListener) {
        ArrayList<AnimatorListener> arrayList = this.f52792b;
        if (arrayList != null) {
            arrayList.remove(animatorListener);
            if (this.f52792b.size() == 0) {
                this.f52792b = null;
            }
        }
    }

    public abstract Animator setDuration(long j11);

    public abstract void setInterpolator(Interpolator interpolator);

    public abstract void setStartDelay(long j11);

    public void setTarget(Object obj) {
    }

    public void setupEndValues() {
    }

    public void setupStartValues() {
    }

    public void start() {
    }

    public Animator clone() {
        try {
            Animator animator = (Animator) super.clone();
            ArrayList<AnimatorListener> arrayList = this.f52792b;
            if (arrayList != null) {
                animator.f52792b = new ArrayList<>();
                int size = arrayList.size();
                for (int i11 = 0; i11 < size; i11++) {
                    animator.f52792b.add(arrayList.get(i11));
                }
            }
            return animator;
        } catch (CloneNotSupportedException unused) {
            throw new AssertionError();
        }
    }
}
