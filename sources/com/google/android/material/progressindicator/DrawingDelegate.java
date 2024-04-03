package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;

abstract class DrawingDelegate<S extends BaseProgressIndicatorSpec> {
    protected DrawableWithAnimatedVisibilityChange drawable;
    S spec;

    public DrawingDelegate(S s11) {
        this.spec = s11;
    }

    public abstract void adjustCanvas(@NonNull Canvas canvas, @FloatRange(from = 0.0d, to = 1.0d) float f11);

    public abstract void fillIndicator(@NonNull Canvas canvas, @NonNull Paint paint, @FloatRange(from = 0.0d, to = 1.0d) float f11, @FloatRange(from = 0.0d, to = 1.0d) float f12, @ColorInt int i11);

    public abstract void fillTrack(@NonNull Canvas canvas, @NonNull Paint paint);

    public abstract int getPreferredHeight();

    public abstract int getPreferredWidth();

    public void registerDrawable(@NonNull DrawableWithAnimatedVisibilityChange drawableWithAnimatedVisibilityChange) {
        this.drawable = drawableWithAnimatedVisibilityChange;
    }

    public void validateSpecAndAdjustCanvas(@NonNull Canvas canvas, @FloatRange(from = 0.0d, to = 1.0d) float f11) {
        this.spec.validateSpec();
        adjustCanvas(canvas, f11);
    }
}
