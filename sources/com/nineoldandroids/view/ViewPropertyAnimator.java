package com.nineoldandroids.view;

import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import com.nineoldandroids.animation.Animator;
import java.util.WeakHashMap;

public abstract class ViewPropertyAnimator {
    private static final WeakHashMap<View, ViewPropertyAnimator> ANIMATORS = new WeakHashMap<>(0);

    public static ViewPropertyAnimator animate(View view) {
        WeakHashMap<View, ViewPropertyAnimator> weakHashMap = ANIMATORS;
        ViewPropertyAnimator viewPropertyAnimator = weakHashMap.get(view);
        if (viewPropertyAnimator == null) {
            int intValue = Integer.valueOf(Build.VERSION.SDK).intValue();
            if (intValue >= 14) {
                viewPropertyAnimator = new ViewPropertyAnimatorICS(view);
            } else if (intValue >= 11) {
                viewPropertyAnimator = new ViewPropertyAnimatorHC(view);
            } else {
                viewPropertyAnimator = new ViewPropertyAnimatorPreHC(view);
            }
            weakHashMap.put(view, viewPropertyAnimator);
        }
        return viewPropertyAnimator;
    }

    public abstract ViewPropertyAnimator alpha(float f11);

    public abstract ViewPropertyAnimator alphaBy(float f11);

    public abstract void cancel();

    public abstract long getDuration();

    public abstract long getStartDelay();

    public abstract ViewPropertyAnimator rotation(float f11);

    public abstract ViewPropertyAnimator rotationBy(float f11);

    public abstract ViewPropertyAnimator rotationX(float f11);

    public abstract ViewPropertyAnimator rotationXBy(float f11);

    public abstract ViewPropertyAnimator rotationY(float f11);

    public abstract ViewPropertyAnimator rotationYBy(float f11);

    public abstract ViewPropertyAnimator scaleX(float f11);

    public abstract ViewPropertyAnimator scaleXBy(float f11);

    public abstract ViewPropertyAnimator scaleY(float f11);

    public abstract ViewPropertyAnimator scaleYBy(float f11);

    public abstract ViewPropertyAnimator setDuration(long j11);

    public abstract ViewPropertyAnimator setInterpolator(Interpolator interpolator);

    public abstract ViewPropertyAnimator setListener(Animator.AnimatorListener animatorListener);

    public abstract ViewPropertyAnimator setStartDelay(long j11);

    public abstract void start();

    public abstract ViewPropertyAnimator translationX(float f11);

    public abstract ViewPropertyAnimator translationXBy(float f11);

    public abstract ViewPropertyAnimator translationY(float f11);

    public abstract ViewPropertyAnimator translationYBy(float f11);

    public abstract ViewPropertyAnimator x(float f11);

    public abstract ViewPropertyAnimator xBy(float f11);

    public abstract ViewPropertyAnimator y(float f11);

    public abstract ViewPropertyAnimator yBy(float f11);
}
