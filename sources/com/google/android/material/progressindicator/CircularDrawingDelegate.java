package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import com.google.android.material.color.MaterialColors;

final class CircularDrawingDelegate extends DrawingDelegate<CircularProgressIndicatorSpec> {
    private float adjustedRadius;
    private int arcDirectionFactor = 1;
    private float displayedCornerRadius;
    private float displayedTrackThickness;

    public CircularDrawingDelegate(@NonNull CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        super(circularProgressIndicatorSpec);
    }

    private void drawRoundedEnd(Canvas canvas, Paint paint, float f11, float f12, float f13) {
        canvas.save();
        canvas.rotate(f13);
        float f14 = this.adjustedRadius;
        float f15 = f11 / 2.0f;
        canvas.drawRoundRect(new RectF(f14 - f15, f12, f14 + f15, -f12), f12, f12, paint);
        canvas.restore();
    }

    private int getSize() {
        S s11 = this.spec;
        return ((CircularProgressIndicatorSpec) s11).indicatorSize + (((CircularProgressIndicatorSpec) s11).indicatorInset * 2);
    }

    public void adjustCanvas(@NonNull Canvas canvas, @FloatRange(from = 0.0d, to = 1.0d) float f11) {
        int i11;
        S s11 = this.spec;
        float f12 = (((float) ((CircularProgressIndicatorSpec) s11).indicatorSize) / 2.0f) + ((float) ((CircularProgressIndicatorSpec) s11).indicatorInset);
        canvas.translate(f12, f12);
        canvas.rotate(-90.0f);
        float f13 = -f12;
        canvas.clipRect(f13, f13, f12, f12);
        S s12 = this.spec;
        if (((CircularProgressIndicatorSpec) s12).indicatorDirection == 0) {
            i11 = 1;
        } else {
            i11 = -1;
        }
        this.arcDirectionFactor = i11;
        this.displayedTrackThickness = ((float) ((CircularProgressIndicatorSpec) s12).trackThickness) * f11;
        this.displayedCornerRadius = ((float) ((CircularProgressIndicatorSpec) s12).trackCornerRadius) * f11;
        this.adjustedRadius = ((float) (((CircularProgressIndicatorSpec) s12).indicatorSize - ((CircularProgressIndicatorSpec) s12).trackThickness)) / 2.0f;
        if ((this.drawable.isShowing() && ((CircularProgressIndicatorSpec) this.spec).showAnimationBehavior == 2) || (this.drawable.isHiding() && ((CircularProgressIndicatorSpec) this.spec).hideAnimationBehavior == 1)) {
            this.adjustedRadius += ((1.0f - f11) * ((float) ((CircularProgressIndicatorSpec) this.spec).trackThickness)) / 2.0f;
        } else if ((this.drawable.isShowing() && ((CircularProgressIndicatorSpec) this.spec).showAnimationBehavior == 1) || (this.drawable.isHiding() && ((CircularProgressIndicatorSpec) this.spec).hideAnimationBehavior == 2)) {
            this.adjustedRadius -= ((1.0f - f11) * ((float) ((CircularProgressIndicatorSpec) this.spec).trackThickness)) / 2.0f;
        }
    }

    public void fillIndicator(@NonNull Canvas canvas, @NonNull Paint paint, @FloatRange(from = 0.0d, to = 1.0d) float f11, @FloatRange(from = 0.0d, to = 1.0d) float f12, @ColorInt int i11) {
        float f13;
        Paint paint2 = paint;
        if (f11 != f12) {
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeCap(Paint.Cap.BUTT);
            paint.setAntiAlias(true);
            paint.setColor(i11);
            paint.setStrokeWidth(this.displayedTrackThickness);
            int i12 = this.arcDirectionFactor;
            float f14 = f11 * 360.0f * ((float) i12);
            if (f12 >= f11) {
                f13 = f12 - f11;
            } else {
                f13 = (1.0f + f12) - f11;
            }
            float f15 = f13 * 360.0f * ((float) i12);
            float f16 = this.adjustedRadius;
            canvas.drawArc(new RectF(-f16, -f16, f16, f16), f14, f15, false, paint);
            if (this.displayedCornerRadius > 0.0f && Math.abs(f15) < 360.0f) {
                paint.setStyle(Paint.Style.FILL);
                Canvas canvas2 = canvas;
                Paint paint3 = paint;
                drawRoundedEnd(canvas2, paint3, this.displayedTrackThickness, this.displayedCornerRadius, f14);
                drawRoundedEnd(canvas2, paint3, this.displayedTrackThickness, this.displayedCornerRadius, f14 + f15);
            }
        }
    }

    public void fillTrack(@NonNull Canvas canvas, @NonNull Paint paint) {
        int compositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(((CircularProgressIndicatorSpec) this.spec).trackColor, this.drawable.getAlpha());
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        paint.setColor(compositeARGBWithAlpha);
        paint.setStrokeWidth(this.displayedTrackThickness);
        float f11 = this.adjustedRadius;
        canvas.drawArc(new RectF(-f11, -f11, f11, f11), 0.0f, 360.0f, false, paint);
    }

    public int getPreferredHeight() {
        return getSize();
    }

    public int getPreferredWidth() {
        return getSize();
    }
}
