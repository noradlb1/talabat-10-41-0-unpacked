package com.rd.draw.drawer.type;

import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.annotation.NonNull;
import com.rd.animation.type.AnimationType;
import com.rd.draw.data.Indicator;

public class BasicDrawer extends BaseDrawer {
    private Paint strokePaint;

    public BasicDrawer(@NonNull Paint paint, @NonNull Indicator indicator) {
        super(paint, indicator);
        Paint paint2 = new Paint();
        this.strokePaint = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.strokePaint.setAntiAlias(true);
        this.strokePaint.setStrokeWidth((float) indicator.getStroke());
    }

    public void draw(@NonNull Canvas canvas, int i11, boolean z11, int i12, int i13) {
        Paint paint;
        float radius = (float) this.f52920b.getRadius();
        int stroke = this.f52920b.getStroke();
        float scaleFactor = this.f52920b.getScaleFactor();
        int selectedColor = this.f52920b.getSelectedColor();
        int unselectedColor = this.f52920b.getUnselectedColor();
        int selectedPosition = this.f52920b.getSelectedPosition();
        AnimationType animationType = this.f52920b.getAnimationType();
        if ((animationType == AnimationType.SCALE && !z11) || (animationType == AnimationType.SCALE_DOWN && z11)) {
            radius *= scaleFactor;
        }
        if (i11 != selectedPosition) {
            selectedColor = unselectedColor;
        }
        if (animationType != AnimationType.FILL || i11 == selectedPosition) {
            paint = this.f52919a;
        } else {
            paint = this.strokePaint;
            paint.setStrokeWidth((float) stroke);
        }
        paint.setColor(selectedColor);
        canvas.drawCircle((float) i12, (float) i13, radius, paint);
    }
}
