package com.google.android.material.progressindicator;

import android.animation.Animator;
import androidx.annotation.NonNull;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;

abstract class IndeterminateAnimatorDelegate<T extends Animator> {
    protected IndeterminateDrawable drawable;
    protected final int[] segmentColors;
    protected final float[] segmentPositions;

    public IndeterminateAnimatorDelegate(int i11) {
        this.segmentPositions = new float[(i11 * 2)];
        this.segmentColors = new int[i11];
    }

    public abstract void cancelAnimatorImmediately();

    public float getFractionInRange(int i11, int i12, int i13) {
        return ((float) (i11 - i12)) / ((float) i13);
    }

    public abstract void invalidateSpecValues();

    public abstract void registerAnimatorsCompleteCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback);

    public void registerDrawable(@NonNull IndeterminateDrawable indeterminateDrawable) {
        this.drawable = indeterminateDrawable;
    }

    public abstract void requestCancelAnimatorAfterCurrentCycle();

    public abstract void startAnimator();

    public abstract void unregisterAnimatorsCompleteCallback();
}
