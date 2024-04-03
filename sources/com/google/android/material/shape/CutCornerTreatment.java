package com.google.android.material.shape;

import androidx.annotation.NonNull;

public class CutCornerTreatment extends CornerTreatment {
    float size;

    public CutCornerTreatment() {
        this.size = -1.0f;
    }

    public void getCornerPath(@NonNull ShapePath shapePath, float f11, float f12, float f13) {
        shapePath.reset(0.0f, f13 * f12, 180.0f, 180.0f - f11);
        double d11 = (double) f13;
        double d12 = (double) f12;
        shapePath.lineTo((float) (Math.sin(Math.toRadians((double) f11)) * d11 * d12), (float) (Math.sin(Math.toRadians((double) (90.0f - f11))) * d11 * d12));
    }

    @Deprecated
    public CutCornerTreatment(float f11) {
        this.size = f11;
    }
}
