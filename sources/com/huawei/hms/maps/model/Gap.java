package com.huawei.hms.maps.model;

public final class Gap extends PatternItem {
    public static final float MIN_LENGTH = 0.0f;
    public final float length;

    public Gap(float f11) {
        super(2, Math.max(f11, 0.0f));
        this.length = Math.max(f11, 0.0f);
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return "Type is Gap and the length is" + String.valueOf(this.length);
    }
}
