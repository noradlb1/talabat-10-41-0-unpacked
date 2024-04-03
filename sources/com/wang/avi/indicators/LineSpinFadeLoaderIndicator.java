package com.wang.avi.indicators;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.wang.avi.indicators.BallSpinFadeLoaderIndicator;

public class LineSpinFadeLoaderIndicator extends BallSpinFadeLoaderIndicator {
    public void draw(Canvas canvas, Paint paint) {
        float width = (float) (getWidth() / 10);
        for (int i11 = 0; i11 < 8; i11++) {
            canvas.save();
            BallSpinFadeLoaderIndicator.Point a11 = a(getWidth(), getHeight(), (((float) getWidth()) / 2.5f) - width, 0.7853981633974483d * ((double) i11));
            canvas.translate(a11.f13750x, a11.f13751y);
            float f11 = this.f13743c[i11];
            canvas.scale(f11, f11);
            canvas.rotate((float) (i11 * 45));
            paint.setAlpha(this.f13744d[i11]);
            float f12 = -width;
            canvas.drawRoundRect(new RectF(f12, f12 / 1.5f, width * 1.5f, width / 1.5f), 5.0f, 5.0f, paint);
            canvas.restore();
        }
    }
}
