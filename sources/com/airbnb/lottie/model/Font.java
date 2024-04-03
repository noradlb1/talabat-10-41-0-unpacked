package com.airbnb.lottie.model;

import android.graphics.Typeface;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public class Font {
    private final float ascent;
    private final String family;

    /* renamed from: name  reason: collision with root package name */
    private final String f40643name;
    private final String style;
    @Nullable
    private Typeface typeface;

    public Font(String str, String str2, String str3, float f11) {
        this.family = str;
        this.f40643name = str2;
        this.style = str3;
        this.ascent = f11;
    }

    public String getFamily() {
        return this.family;
    }

    public String getName() {
        return this.f40643name;
    }

    public String getStyle() {
        return this.style;
    }

    @Nullable
    public Typeface getTypeface() {
        return this.typeface;
    }

    public void setTypeface(@Nullable Typeface typeface2) {
        this.typeface = typeface2;
    }
}
