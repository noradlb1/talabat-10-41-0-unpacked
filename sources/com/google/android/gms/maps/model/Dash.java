package com.google.android.gms.maps.model;

import androidx.annotation.NonNull;

public final class Dash extends PatternItem {
    public final float length;

    public Dash(float f11) {
        super(0, Float.valueOf(Math.max(f11, 0.0f)));
        this.length = Math.max(f11, 0.0f);
    }

    @NonNull
    public String toString() {
        return "[Dash: length=" + this.length + "]";
    }
}
