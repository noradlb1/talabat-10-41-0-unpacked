package com.huawei.hms.maps.model;

public final class Dash extends PatternItem {
    public static final float MIN_LENGTH = 0.0f;

    public Dash(float f11) {
        super(0, Math.max(f11, 0.0f));
    }

    public String toString() {
        return "Type is Dash and the paramLength is" + String.valueOf(this.length);
    }
}
