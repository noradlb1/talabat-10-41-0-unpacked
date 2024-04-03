package com.google.android.material.shape;

import androidx.annotation.NonNull;

public class TriangleEdgeTreatment extends EdgeTreatment {
    private final boolean inside;
    private final float size;

    public TriangleEdgeTreatment(float f11, boolean z11) {
        this.size = f11;
        this.inside = z11;
    }

    public void getEdgePath(float f11, float f12, float f13, @NonNull ShapePath shapePath) {
        float f14;
        shapePath.lineTo(f12 - (this.size * f13), 0.0f);
        if (this.inside) {
            f14 = this.size;
        } else {
            f14 = -this.size;
        }
        shapePath.lineTo(f12, f14 * f13);
        shapePath.lineTo(f12 + (this.size * f13), 0.0f);
        shapePath.lineTo(f11, 0.0f);
    }
}
