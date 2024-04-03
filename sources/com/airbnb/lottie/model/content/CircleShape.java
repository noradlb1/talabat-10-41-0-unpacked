package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.EllipseContent;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.layer.BaseLayer;

public class CircleShape implements ContentModel {
    private final boolean hidden;
    private final boolean isReversed;

    /* renamed from: name  reason: collision with root package name */
    private final String f40650name;
    private final AnimatableValue<PointF, PointF> position;
    private final AnimatablePointValue size;

    public CircleShape(String str, AnimatableValue<PointF, PointF> animatableValue, AnimatablePointValue animatablePointValue, boolean z11, boolean z12) {
        this.f40650name = str;
        this.position = animatableValue;
        this.size = animatablePointValue;
        this.isReversed = z11;
        this.hidden = z12;
    }

    public String getName() {
        return this.f40650name;
    }

    public AnimatableValue<PointF, PointF> getPosition() {
        return this.position;
    }

    public AnimatablePointValue getSize() {
        return this.size;
    }

    public boolean isHidden() {
        return this.hidden;
    }

    public boolean isReversed() {
        return this.isReversed;
    }

    public Content toContent(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new EllipseContent(lottieDrawable, baseLayer, this);
    }
}
