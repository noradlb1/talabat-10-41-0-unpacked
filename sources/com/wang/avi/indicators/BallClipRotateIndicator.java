package com.wang.avi.indicators;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.wang.avi.Indicator;
import java.util.ArrayList;

public class BallClipRotateIndicator extends Indicator {

    /* renamed from: c  reason: collision with root package name */
    public float f13694c = 1.0f;

    /* renamed from: d  reason: collision with root package name */
    public float f13695d;

    public void draw(Canvas canvas, Paint paint) {
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3.0f);
        float width = (float) (getWidth() / 2);
        float height = (float) (getHeight() / 2);
        canvas.translate(width, height);
        float f11 = this.f13694c;
        canvas.scale(f11, f11);
        canvas.rotate(this.f13695d);
        canvas.drawArc(new RectF((-width) + 12.0f, (-height) + 12.0f, (width + 0.0f) - 12.0f, (height + 0.0f) - 12.0f), -45.0f, 270.0f, false, paint);
    }

    public ArrayList<ValueAnimator> onCreateAnimators() {
        ArrayList<ValueAnimator> arrayList = new ArrayList<>();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 0.6f, 0.5f, 1.0f});
        ofFloat.setDuration(750);
        ofFloat.setRepeatCount(-1);
        addUpdateListener(ofFloat, new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                BallClipRotateIndicator.this.f13694c = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                BallClipRotateIndicator.this.postInvalidate();
            }
        });
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{0.0f, 180.0f, 360.0f});
        ofFloat2.setDuration(750);
        ofFloat2.setRepeatCount(-1);
        addUpdateListener(ofFloat2, new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                BallClipRotateIndicator.this.f13695d = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                BallClipRotateIndicator.this.postInvalidate();
            }
        });
        arrayList.add(ofFloat);
        arrayList.add(ofFloat2);
        return arrayList;
    }
}
