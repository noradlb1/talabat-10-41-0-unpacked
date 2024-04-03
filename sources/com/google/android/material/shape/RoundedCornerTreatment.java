package com.google.android.material.shape;

import androidx.annotation.NonNull;

public class RoundedCornerTreatment extends CornerTreatment {
    float radius;

    public RoundedCornerTreatment() {
        this.radius = -1.0f;
    }

    public void getCornerPath(@NonNull ShapePath shapePath, float f11, float f12, float f13) {
        shapePath.reset(0.0f, f13 * f12, 180.0f, 180.0f - f11);
        float f14 = f13 * 2.0f * f12;
        shapePath.addArc(0.0f, 0.0f, f14, f14, 180.0f, f11);
    }

    @Deprecated
    public RoundedCornerTreatment(float f11) {
        this.radius = f11;
    }
}
