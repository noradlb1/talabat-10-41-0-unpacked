package com.airbnb.lottie.model.content;

import android.graphics.Path;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.FillContent;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.layer.BaseLayer;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class ShapeFill implements ContentModel {
    @Nullable
    private final AnimatableColorValue color;
    private final boolean fillEnabled;
    private final Path.FillType fillType;
    private final boolean hidden;

    /* renamed from: name  reason: collision with root package name */
    private final String f40658name;
    @Nullable
    private final AnimatableIntegerValue opacity;

    public ShapeFill(String str, boolean z11, Path.FillType fillType2, @Nullable AnimatableColorValue animatableColorValue, @Nullable AnimatableIntegerValue animatableIntegerValue, boolean z12) {
        this.f40658name = str;
        this.fillEnabled = z11;
        this.fillType = fillType2;
        this.color = animatableColorValue;
        this.opacity = animatableIntegerValue;
        this.hidden = z12;
    }

    @Nullable
    public AnimatableColorValue getColor() {
        return this.color;
    }

    public Path.FillType getFillType() {
        return this.fillType;
    }

    public String getName() {
        return this.f40658name;
    }

    @Nullable
    public AnimatableIntegerValue getOpacity() {
        return this.opacity;
    }

    public boolean isHidden() {
        return this.hidden;
    }

    public Content toContent(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new FillContent(lottieDrawable, baseLayer, this);
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.fillEnabled + AbstractJsonLexerKt.END_OBJ;
    }
}
