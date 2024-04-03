package com.airbnb.lottie.value;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;

public class LottieValueCallback<T> {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public T f40727a;
    @Nullable
    private BaseKeyframeAnimation<?, ?> animation;
    private final LottieFrameInfo<T> frameInfo;

    public LottieValueCallback() {
        this.frameInfo = new LottieFrameInfo<>();
        this.f40727a = null;
    }

    @Nullable
    public T getValue(LottieFrameInfo<T> lottieFrameInfo) {
        return this.f40727a;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final T getValueInternal(float f11, float f12, T t11, T t12, float f13, float f14, float f15) {
        return getValue(this.frameInfo.set(f11, f12, t11, t12, f13, f14, f15));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final void setAnimation(@Nullable BaseKeyframeAnimation<?, ?> baseKeyframeAnimation) {
        this.animation = baseKeyframeAnimation;
    }

    public final void setValue(@Nullable T t11) {
        this.f40727a = t11;
        BaseKeyframeAnimation<?, ?> baseKeyframeAnimation = this.animation;
        if (baseKeyframeAnimation != null) {
            baseKeyframeAnimation.notifyListeners();
        }
    }

    public LottieValueCallback(@Nullable T t11) {
        this.frameInfo = new LottieFrameInfo<>();
        this.f40727a = t11;
    }
}
