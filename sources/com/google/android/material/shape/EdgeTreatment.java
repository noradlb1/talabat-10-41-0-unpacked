package com.google.android.material.shape;

import androidx.annotation.NonNull;

public class EdgeTreatment {
    public boolean forceIntersection() {
        return false;
    }

    @Deprecated
    public void getEdgePath(float f11, float f12, @NonNull ShapePath shapePath) {
        getEdgePath(f11, f11 / 2.0f, f12, shapePath);
    }

    public void getEdgePath(float f11, float f12, float f13, @NonNull ShapePath shapePath) {
        shapePath.lineTo(f11, 0.0f);
    }
}
