package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class FadeProvider implements VisibilityAnimatorProvider {
    private float incomingEndThreshold = 1.0f;

    private static Animator createFadeAnimator(final View view, float f11, float f12, @FloatRange(from = 0.0d, to = 1.0d) float f13, @FloatRange(from = 0.0d, to = 1.0d) float f14, final float f15) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        final View view2 = view;
        final float f16 = f11;
        final float f17 = f12;
        final float f18 = f13;
        final float f19 = f14;
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                view2.setAlpha(TransitionUtils.lerp(f16, f17, f18, f19, ((Float) valueAnimator.getAnimatedValue()).floatValue()));
            }
        });
        ofFloat.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                view.setAlpha(f15);
            }
        });
        return ofFloat;
    }

    @Nullable
    public Animator createAppear(@NonNull ViewGroup viewGroup, @NonNull View view) {
        float f11;
        if (view.getAlpha() == 0.0f) {
            f11 = 1.0f;
        } else {
            f11 = view.getAlpha();
        }
        float f12 = f11;
        return createFadeAnimator(view, 0.0f, f12, 0.0f, this.incomingEndThreshold, f12);
    }

    @Nullable
    public Animator createDisappear(@NonNull ViewGroup viewGroup, @NonNull View view) {
        float f11;
        if (view.getAlpha() == 0.0f) {
            f11 = 1.0f;
        } else {
            f11 = view.getAlpha();
        }
        float f12 = f11;
        return createFadeAnimator(view, f12, 0.0f, 0.0f, 1.0f, f12);
    }

    public float getIncomingEndThreshold() {
        return this.incomingEndThreshold;
    }

    public void setIncomingEndThreshold(float f11) {
        this.incomingEndThreshold = f11;
    }
}
