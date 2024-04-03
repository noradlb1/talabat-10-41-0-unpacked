package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import com.google.android.material.color.MaterialColors;

final class LinearDrawingDelegate extends DrawingDelegate<LinearProgressIndicatorSpec> {
    private float displayedCornerRadius;
    private float displayedTrackThickness;
    private float trackLength = 300.0f;

    public LinearDrawingDelegate(@NonNull LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(linearProgressIndicatorSpec);
    }

    public void adjustCanvas(@NonNull Canvas canvas, @FloatRange(from = 0.0d, to = 1.0d) float f11) {
        Rect clipBounds = canvas.getClipBounds();
        this.trackLength = (float) clipBounds.width();
        float f12 = (float) ((LinearProgressIndicatorSpec) this.spec).trackThickness;
        canvas.translate(((float) clipBounds.left) + (((float) clipBounds.width()) / 2.0f), ((float) clipBounds.top) + (((float) clipBounds.height()) / 2.0f) + Math.max(0.0f, ((float) (clipBounds.height() - ((LinearProgressIndicatorSpec) this.spec).trackThickness)) / 2.0f));
        if (((LinearProgressIndicatorSpec) this.spec).drawHorizontallyInverse) {
            canvas.scale(-1.0f, 1.0f);
        }
        if ((this.drawable.isShowing() && ((LinearProgressIndicatorSpec) this.spec).showAnimationBehavior == 1) || (this.drawable.isHiding() && ((LinearProgressIndicatorSpec) this.spec).hideAnimationBehavior == 2)) {
            canvas.scale(1.0f, -1.0f);
        }
        if (this.drawable.isShowing() || this.drawable.isHiding()) {
            canvas.translate(0.0f, (((float) ((LinearProgressIndicatorSpec) this.spec).trackThickness) * (f11 - 1.0f)) / 2.0f);
        }
        float f13 = this.trackLength;
        canvas.clipRect((-f13) / 2.0f, (-f12) / 2.0f, f13 / 2.0f, f12 / 2.0f);
        S s11 = this.spec;
        this.displayedTrackThickness = ((float) ((LinearProgressIndicatorSpec) s11).trackThickness) * f11;
        this.displayedCornerRadius = ((float) ((LinearProgressIndicatorSpec) s11).trackCornerRadius) * f11;
    }

    public void fillIndicator(@NonNull Canvas canvas, @NonNull Paint paint, @FloatRange(from = 0.0d, to = 1.0d) float f11, @FloatRange(from = 0.0d, to = 1.0d) float f12, @ColorInt int i11) {
        if (f11 != f12) {
            float f13 = this.trackLength;
            float f14 = this.displayedCornerRadius;
            paint.setStyle(Paint.Style.FILL);
            paint.setAntiAlias(true);
            paint.setColor(i11);
            float f15 = this.displayedTrackThickness;
            RectF rectF = new RectF(((-f13) / 2.0f) + (f11 * (f13 - (f14 * 2.0f))), (-f15) / 2.0f, ((-f13) / 2.0f) + (f12 * (f13 - (f14 * 2.0f))) + (f14 * 2.0f), f15 / 2.0f);
            float f16 = this.displayedCornerRadius;
            canvas.drawRoundRect(rectF, f16, f16, paint);
        }
    }

    public void fillTrack(@NonNull Canvas canvas, @NonNull Paint paint) {
        int compositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(((LinearProgressIndicatorSpec) this.spec).trackColor, this.drawable.getAlpha());
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setColor(compositeARGBWithAlpha);
        float f11 = this.trackLength;
        float f12 = this.displayedTrackThickness;
        RectF rectF = new RectF((-f11) / 2.0f, (-f12) / 2.0f, f11 / 2.0f, f12 / 2.0f);
        float f13 = this.displayedCornerRadius;
        canvas.drawRoundRect(rectF, f13, f13, paint);
    }

    public int getPreferredHeight() {
        return ((LinearProgressIndicatorSpec) this.spec).trackThickness;
    }

    public int getPreferredWidth() {
        return -1;
    }
}
