package com.google.android.material.transition;

class FitModeResult {
    final float currentEndHeight;
    final float currentEndWidth;
    final float currentStartHeight;
    final float currentStartWidth;
    final float endScale;
    final float startScale;

    public FitModeResult(float f11, float f12, float f13, float f14, float f15, float f16) {
        this.startScale = f11;
        this.endScale = f12;
        this.currentStartWidth = f13;
        this.currentStartHeight = f14;
        this.currentEndWidth = f15;
        this.currentEndHeight = f16;
    }
}
