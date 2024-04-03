package com.airbnb.lottie.model.content;

import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.RoundedCornersContent;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.layer.BaseLayer;

public class RoundedCorners implements ContentModel {
    private final AnimatableValue<Float, Float> cornerRadius;

    /* renamed from: name  reason: collision with root package name */
    private final String f40657name;

    public RoundedCorners(String str, AnimatableValue<Float, Float> animatableValue) {
        this.f40657name = str;
        this.cornerRadius = animatableValue;
    }

    public AnimatableValue<Float, Float> getCornerRadius() {
        return this.cornerRadius;
    }

    public String getName() {
        return this.f40657name;
    }

    @Nullable
    public Content toContent(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new RoundedCornersContent(lottieDrawable, baseLayer, this);
    }
}
