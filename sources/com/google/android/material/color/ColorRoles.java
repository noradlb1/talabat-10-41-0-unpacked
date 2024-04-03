package com.google.android.material.color;

import androidx.annotation.ColorInt;

public final class ColorRoles {
    private final int accent;
    private final int accentContainer;
    private final int onAccent;
    private final int onAccentContainer;

    public ColorRoles(@ColorInt int i11, @ColorInt int i12, @ColorInt int i13, @ColorInt int i14) {
        this.accent = i11;
        this.onAccent = i12;
        this.accentContainer = i13;
        this.onAccentContainer = i14;
    }

    @ColorInt
    public int getAccent() {
        return this.accent;
    }

    @ColorInt
    public int getAccentContainer() {
        return this.accentContainer;
    }

    @ColorInt
    public int getOnAccent() {
        return this.onAccent;
    }

    @ColorInt
    public int getOnAccentContainer() {
        return this.onAccentContainer;
    }
}
