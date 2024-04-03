package com.airbnb.lottie.model.animatable;

import androidx.annotation.Nullable;

public class AnimatableTextProperties {
    @Nullable
    public final AnimatableColorValue color;
    @Nullable
    public final AnimatableColorValue stroke;
    @Nullable
    public final AnimatableFloatValue strokeWidth;
    @Nullable

    /* renamed from: tracking  reason: collision with root package name */
    public final AnimatableFloatValue f40647tracking;

    public AnimatableTextProperties(@Nullable AnimatableColorValue animatableColorValue, @Nullable AnimatableColorValue animatableColorValue2, @Nullable AnimatableFloatValue animatableFloatValue, @Nullable AnimatableFloatValue animatableFloatValue2) {
        this.color = animatableColorValue;
        this.stroke = animatableColorValue2;
        this.strokeWidth = animatableFloatValue;
        this.f40647tracking = animatableFloatValue2;
    }
}
