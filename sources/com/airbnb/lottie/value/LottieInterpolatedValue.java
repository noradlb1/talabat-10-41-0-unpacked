package com.airbnb.lottie.value;

import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

abstract class LottieInterpolatedValue<T> extends LottieValueCallback<T> {
    private final T endValue;
    private final Interpolator interpolator;
    private final T startValue;

    public LottieInterpolatedValue(T t11, T t12) {
        this(t11, t12, new LinearInterpolator());
    }

    public abstract T a(T t11, T t12, float f11);

    public T getValue(LottieFrameInfo<T> lottieFrameInfo) {
        return a(this.startValue, this.endValue, this.interpolator.getInterpolation(lottieFrameInfo.getOverallProgress()));
    }

    public LottieInterpolatedValue(T t11, T t12, Interpolator interpolator2) {
        this.startValue = t11;
        this.endValue = t12;
        this.interpolator = interpolator2;
    }
}
