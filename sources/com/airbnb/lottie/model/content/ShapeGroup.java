package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.ContentGroup;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.Arrays;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class ShapeGroup implements ContentModel {
    private final boolean hidden;
    private final List<ContentModel> items;

    /* renamed from: name  reason: collision with root package name */
    private final String f40659name;

    public ShapeGroup(String str, List<ContentModel> list, boolean z11) {
        this.f40659name = str;
        this.items = list;
        this.hidden = z11;
    }

    public List<ContentModel> getItems() {
        return this.items;
    }

    public String getName() {
        return this.f40659name;
    }

    public boolean isHidden() {
        return this.hidden;
    }

    public Content toContent(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new ContentGroup(lottieDrawable, baseLayer, this);
    }

    public String toString() {
        return "ShapeGroup{name='" + this.f40659name + "' Shapes: " + Arrays.toString(this.items.toArray()) + AbstractJsonLexerKt.END_OBJ;
    }
}
