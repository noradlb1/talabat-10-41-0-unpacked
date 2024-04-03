package com.google.android.material.transition.platform;

import androidx.annotation.RequiresApi;

@RequiresApi(21)
interface FadeModeEvaluator {
    FadeModeResult evaluate(float f11, float f12, float f13, float f14);
}
