package com.google.android.material.transition.platform;

import android.graphics.RectF;
import androidx.annotation.RequiresApi;

@RequiresApi(21)
interface FitModeEvaluator {
    void applyMask(RectF rectF, float f11, FitModeResult fitModeResult);

    FitModeResult evaluate(float f11, float f12, float f13, float f14, float f15, float f16, float f17);

    boolean shouldMaskStartBounds(FitModeResult fitModeResult);
}
