package com.wang.avi.indicators;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.wang.avi.Indicator;
import java.util.ArrayList;

public class BallClipRotateMultipleIndicator extends Indicator {

    /* renamed from: c  reason: collision with root package name */
    public float f13698c = 1.0f;

    /* renamed from: d  reason: collision with root package name */
    public float f13699d;

    public void draw(Canvas canvas, Paint paint) {
        paint.setStrokeWidth(3.0f);
        paint.setStyle(Paint.Style.STROKE);
        float width = (float) (getWidth() / 2);
        float height = (float) (getHeight() / 2);
        canvas.save();
        canvas.translate(width, height);
        float f11 = this.f13698c;
        canvas.scale(f11, f11);
        canvas.rotate(this.f13699d);
        float[] fArr = {135.0f, -45.0f};
        for (int i11 = 0; i11 < 2; i11++) {
            canvas.drawArc(new RectF((-width) + 12.0f, (-height) + 12.0f, width - 12.0f, height - 12.0f), fArr[i11], 90.0f, false, paint);
        }
        canvas.restore();
        canvas.translate(width, height);
        float f12 = this.f13698c;
        canvas.scale(f12, f12);
        canvas.rotate(-this.f13699d);
        float[] fArr2 = {225.0f, 45.0f};
        for (int i12 = 0; i12 < 2; i12++) {
            canvas.drawArc(new RectF(((-width) / 1.8f) + 12.0f, ((-height) / 1.8f) + 12.0f, (width / 1.8f) - 12.0f, (height / 1.8f) - 12.0f), fArr2[i12], 90.0f, false, paint);
        }
    }

    public ArrayList<ValueAnimator> onCreateAnimators() {
        ArrayList<ValueAnimator> arrayList = new ArrayList<>();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 0.6f, 1.0f});
        ofFloat.setDuration(1000);
        ofFloat.setRepeatCount(-1);
        addUpdateListener(ofFloat, new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                BallClipRotateMultipleIndicator.this.f13698c = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                BallClipRotateMultipleIndicator.this.postInvalidate();
            }
        });
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{0.0f, 180.0f, 360.0f});
        ofFloat2.setDuration(1000);
        ofFloat2.setRepeatCount(-1);
        addUpdateListener(ofFloat2, new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                BallClipRotateMultipleIndicator.this.f13699d = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                BallClipRotateMultipleIndicator.this.postInvalidate();
            }
        });
        arrayList.add(ofFloat);
        arrayList.add(ofFloat2);
        return arrayList;
    }
}
