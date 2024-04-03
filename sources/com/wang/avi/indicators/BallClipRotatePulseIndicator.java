package com.wang.avi.indicators;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.wang.avi.Indicator;
import java.util.ArrayList;

public class BallClipRotatePulseIndicator extends Indicator {

    /* renamed from: c  reason: collision with root package name */
    public float f13702c;

    /* renamed from: d  reason: collision with root package name */
    public float f13703d;

    /* renamed from: e  reason: collision with root package name */
    public float f13704e;

    public void draw(Canvas canvas, Paint paint) {
        float width = (float) (getWidth() / 2);
        float height = (float) (getHeight() / 2);
        canvas.save();
        canvas.translate(width, height);
        float f11 = this.f13702c;
        canvas.scale(f11, f11);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(0.0f, 0.0f, width / 2.5f, paint);
        canvas.restore();
        canvas.translate(width, height);
        float f12 = this.f13703d;
        canvas.scale(f12, f12);
        canvas.rotate(this.f13704e);
        paint.setStrokeWidth(3.0f);
        paint.setStyle(Paint.Style.STROKE);
        float[] fArr = {225.0f, 45.0f};
        for (int i11 = 0; i11 < 2; i11++) {
            canvas.drawArc(new RectF((-width) + 12.0f, (-height) + 12.0f, width - 12.0f, height - 12.0f), fArr[i11], 90.0f, false, paint);
        }
    }

    public ArrayList<ValueAnimator> onCreateAnimators() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 0.3f, 1.0f});
        ofFloat.setDuration(1000);
        ofFloat.setRepeatCount(-1);
        addUpdateListener(ofFloat, new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                BallClipRotatePulseIndicator.this.f13702c = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                BallClipRotatePulseIndicator.this.postInvalidate();
            }
        });
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{1.0f, 0.6f, 1.0f});
        ofFloat2.setDuration(1000);
        ofFloat2.setRepeatCount(-1);
        addUpdateListener(ofFloat2, new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                BallClipRotatePulseIndicator.this.f13703d = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                BallClipRotatePulseIndicator.this.postInvalidate();
            }
        });
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(new float[]{0.0f, 180.0f, 360.0f});
        ofFloat3.setDuration(1000);
        ofFloat3.setRepeatCount(-1);
        addUpdateListener(ofFloat3, new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                BallClipRotatePulseIndicator.this.f13704e = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                BallClipRotatePulseIndicator.this.postInvalidate();
            }
        });
        ArrayList<ValueAnimator> arrayList = new ArrayList<>();
        arrayList.add(ofFloat);
        arrayList.add(ofFloat2);
        arrayList.add(ofFloat3);
        return arrayList;
    }
}
