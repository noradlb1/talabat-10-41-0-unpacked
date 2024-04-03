package com.google.android.material.shape;

import androidx.annotation.NonNull;

public final class OffsetEdgeTreatment extends EdgeTreatment {
    private final float offset;
    private final EdgeTreatment other;

    public OffsetEdgeTreatment(@NonNull EdgeTreatment edgeTreatment, float f11) {
        this.other = edgeTreatment;
        this.offset = f11;
    }

    public boolean forceIntersection() {
        return this.other.forceIntersection();
    }

    public void getEdgePath(float f11, float f12, float f13, @NonNull ShapePath shapePath) {
        this.other.getEdgePath(f11, f12 - this.offset, f13, shapePath);
    }
}
