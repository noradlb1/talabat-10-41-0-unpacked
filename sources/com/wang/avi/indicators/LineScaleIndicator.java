package com.wang.avi.indicators;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.wang.avi.Indicator;
import java.util.ArrayList;

public class LineScaleIndicator extends Indicator {
    public static final float SCALE = 1.0f;

    /* renamed from: c  reason: collision with root package name */
    public float[] f13778c = {1.0f, 1.0f, 1.0f, 1.0f, 1.0f};

    public void draw(Canvas canvas, Paint paint) {
        float width = (float) (getWidth() / 11);
        float height = (float) (getHeight() / 2);
        for (int i11 = 0; i11 < 5; i11++) {
            canvas.save();
            float f11 = width / 2.0f;
            canvas.translate((((float) ((i11 * 2) + 2)) * width) - f11, height);
            canvas.scale(1.0f, this.f13778c[i11]);
            canvas.drawRoundRect(new RectF((-width) / 2.0f, ((float) (-getHeight())) / 2.5f, f11, ((float) getHeight()) / 2.5f), 5.0f, 5.0f, paint);
            canvas.restore();
        }
    }

    public ArrayList<ValueAnimator> onCreateAnimators() {
        ArrayList<ValueAnimator> arrayList = new ArrayList<>();
        long[] jArr = {100, 200, 300, 400, 500};
        for (final int i11 = 0; i11 < 5; i11++) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 0.4f, 1.0f});
            ofFloat.setDuration(1000);
            ofFloat.setRepeatCount(-1);
            ofFloat.setStartDelay(jArr[i11]);
            addUpdateListener(ofFloat, new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    LineScaleIndicator.this.f13778c[i11] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    LineScaleIndicator.this.postInvalidate();
                }
            });
            arrayList.add(ofFloat);
        }
        return arrayList;
    }
}
