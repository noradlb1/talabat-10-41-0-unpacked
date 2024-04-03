package com.google.android.material.canvas;

import android.graphics.Canvas;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class CanvasCompat {
    private CanvasCompat() {
    }

    public static int saveLayerAlpha(@NonNull Canvas canvas, @Nullable RectF rectF, int i11) {
        return canvas.saveLayerAlpha(rectF, i11);
    }

    public static int saveLayerAlpha(@NonNull Canvas canvas, float f11, float f12, float f13, float f14, int i11) {
        return canvas.saveLayerAlpha(f11, f12, f13, f14, i11);
    }
}
