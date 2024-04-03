package com.google.android.material.shape;

import android.graphics.RectF;
import androidx.annotation.NonNull;

public class CornerTreatment {
    @Deprecated
    public void getCornerPath(float f11, float f12, @NonNull ShapePath shapePath) {
    }

    public void getCornerPath(@NonNull ShapePath shapePath, float f11, float f12, float f13) {
        getCornerPath(f11, f12, shapePath);
    }

    public void getCornerPath(@NonNull ShapePath shapePath, float f11, float f12, @NonNull RectF rectF, @NonNull CornerSize cornerSize) {
        getCornerPath(shapePath, f11, f12, cornerSize.getCornerSize(rectF));
    }
}
