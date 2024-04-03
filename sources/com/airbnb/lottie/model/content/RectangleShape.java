package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.RectangleContent;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.layer.BaseLayer;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class RectangleShape implements ContentModel {
    private final AnimatableFloatValue cornerRadius;
    private final boolean hidden;

    /* renamed from: name  reason: collision with root package name */
    private final String f40655name;
    private final AnimatableValue<PointF, PointF> position;
    private final AnimatableValue<PointF, PointF> size;

    public RectangleShape(String str, AnimatableValue<PointF, PointF> animatableValue, AnimatableValue<PointF, PointF> animatableValue2, AnimatableFloatValue animatableFloatValue, boolean z11) {
        this.f40655name = str;
        this.position = animatableValue;
        this.size = animatableValue2;
        this.cornerRadius = animatableFloatValue;
        this.hidden = z11;
    }

    public AnimatableFloatValue getCornerRadius() {
        return this.cornerRadius;
    }

    public String getName() {
        return this.f40655name;
    }

    public AnimatableValue<PointF, PointF> getPosition() {
        return this.position;
    }

    public AnimatableValue<PointF, PointF> getSize() {
        return this.size;
    }

    public boolean isHidden() {
        return this.hidden;
    }

    public Content toContent(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new RectangleContent(lottieDrawable, baseLayer, this);
    }

    public String toString() {
        return "RectangleShape{position=" + this.position + ", size=" + this.size + AbstractJsonLexerKt.END_OBJ;
    }
}
