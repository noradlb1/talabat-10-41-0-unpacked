package com.google.android.gms.maps.model;

import androidx.annotation.NonNull;

public final class Gap extends PatternItem {
    public final float length;

    public Gap(float f11) {
        super(2, Float.valueOf(Math.max(f11, 0.0f)));
        this.length = Math.max(f11, 0.0f);
    }

    @NonNull
    public String toString() {
        return "[Gap: length=" + this.length + "]";
    }
}
