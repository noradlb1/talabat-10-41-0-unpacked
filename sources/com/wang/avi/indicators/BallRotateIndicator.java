package com.wang.avi.indicators;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.wang.avi.Indicator;
import java.util.ArrayList;

public class BallRotateIndicator extends Indicator {

    /* renamed from: c  reason: collision with root package name */
    public float f13723c = 0.5f;

    /* renamed from: d  reason: collision with root package name */
    public float f13724d;
    private Matrix mMatrix = new Matrix();

    public void draw(Canvas canvas, Paint paint) {
        float width = (float) (getWidth() / 10);
        float width2 = (float) (getWidth() / 2);
        float height = (float) (getHeight() / 2);
        canvas.rotate(this.f13724d, (float) centerX(), (float) centerY());
        canvas.save();
        float f11 = 2.0f * width;
        canvas.translate((width2 - f11) - width, height);
        float f12 = this.f13723c;
        canvas.scale(f12, f12);
        canvas.drawCircle(0.0f, 0.0f, width, paint);
        canvas.restore();
        canvas.save();
        canvas.translate(width2, height);
        float f13 = this.f13723c;
        canvas.scale(f13, f13);
        canvas.drawCircle(0.0f, 0.0f, width, paint);
        canvas.restore();
        canvas.save();
        canvas.translate(width2 + f11 + width, height);
        float f14 = this.f13723c;
        canvas.scale(f14, f14);
        canvas.drawCircle(0.0f, 0.0f, width, paint);
        canvas.restore();
    }

    public ArrayList<ValueAnimator> onCreateAnimators() {
        ArrayList<ValueAnimator> arrayList = new ArrayList<>();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.5f, 1.0f, 0.5f});
        ofFloat.setDuration(1000);
        ofFloat.setRepeatCount(-1);
        addUpdateListener(ofFloat, new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                BallRotateIndicator.this.f13723c = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                BallRotateIndicator.this.postInvalidate();
            }
        });
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{0.0f, 180.0f, 360.0f});
        addUpdateListener(ofFloat2, new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                BallRotateIndicator.this.f13724d = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                BallRotateIndicator.this.postInvalidate();
            }
        });
        ofFloat2.setDuration(1000);
        ofFloat2.setRepeatCount(-1);
        arrayList.add(ofFloat);
        arrayList.add(ofFloat2);
        return arrayList;
    }
}
