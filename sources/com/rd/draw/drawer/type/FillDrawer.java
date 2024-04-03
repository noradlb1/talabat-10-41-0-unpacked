package com.rd.draw.drawer.type;

import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.annotation.NonNull;
import com.rd.animation.data.Value;
import com.rd.animation.data.type.FillAnimationValue;
import com.rd.draw.data.Indicator;

public class FillDrawer extends BaseDrawer {
    private Paint strokePaint;

    public FillDrawer(@NonNull Paint paint, @NonNull Indicator indicator) {
        super(paint, indicator);
        Paint paint2 = new Paint();
        this.strokePaint = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.strokePaint.setAntiAlias(true);
    }

    public void draw(@NonNull Canvas canvas, @NonNull Value value, int i11, int i12, int i13) {
        if (value instanceof FillAnimationValue) {
            FillAnimationValue fillAnimationValue = (FillAnimationValue) value;
            int unselectedColor = this.f52920b.getUnselectedColor();
            float radius = (float) this.f52920b.getRadius();
            int stroke = this.f52920b.getStroke();
            int selectedPosition = this.f52920b.getSelectedPosition();
            int selectingPosition = this.f52920b.getSelectingPosition();
            int lastSelectedPosition = this.f52920b.getLastSelectedPosition();
            if (this.f52920b.isInteractiveAnimation()) {
                if (i11 == selectingPosition) {
                    unselectedColor = fillAnimationValue.getColor();
                    radius = (float) fillAnimationValue.getRadius();
                    stroke = fillAnimationValue.getStroke();
                } else if (i11 == selectedPosition) {
                    unselectedColor = fillAnimationValue.getColorReverse();
                    radius = (float) fillAnimationValue.getRadiusReverse();
                    stroke = fillAnimationValue.getStrokeReverse();
                }
            } else if (i11 == selectedPosition) {
                unselectedColor = fillAnimationValue.getColor();
                radius = (float) fillAnimationValue.getRadius();
                stroke = fillAnimationValue.getStroke();
            } else if (i11 == lastSelectedPosition) {
                unselectedColor = fillAnimationValue.getColorReverse();
                radius = (float) fillAnimationValue.getRadiusReverse();
                stroke = fillAnimationValue.getStrokeReverse();
            }
            this.strokePaint.setColor(unselectedColor);
            this.strokePaint.setStrokeWidth((float) this.f52920b.getStroke());
            float f11 = (float) i12;
            float f12 = (float) i13;
            canvas.drawCircle(f11, f12, (float) this.f52920b.getRadius(), this.strokePaint);
            this.strokePaint.setStrokeWidth((float) stroke);
            canvas.drawCircle(f11, f12, radius, this.strokePaint);
        }
    }
}
