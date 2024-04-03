package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.ShapeContent;
import com.airbnb.lottie.model.animatable.AnimatableShapeValue;
import com.airbnb.lottie.model.layer.BaseLayer;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class ShapePath implements ContentModel {
    private final boolean hidden;
    private final int index;

    /* renamed from: name  reason: collision with root package name */
    private final String f40660name;
    private final AnimatableShapeValue shapePath;

    public ShapePath(String str, int i11, AnimatableShapeValue animatableShapeValue, boolean z11) {
        this.f40660name = str;
        this.index = i11;
        this.shapePath = animatableShapeValue;
        this.hidden = z11;
    }

    public String getName() {
        return this.f40660name;
    }

    public AnimatableShapeValue getShapePath() {
        return this.shapePath;
    }

    public boolean isHidden() {
        return this.hidden;
    }

    public Content toContent(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new ShapeContent(lottieDrawable, baseLayer, this);
    }

    public String toString() {
        return "ShapePath{name=" + this.f40660name + ", index=" + this.index + AbstractJsonLexerKt.END_OBJ;
    }
}
