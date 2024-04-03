package com.wang.avi.indicators;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.animation.LinearInterpolator;
import com.wang.avi.Indicator;
import java.util.ArrayList;

public class BallZigZagIndicator extends Indicator {

    /* renamed from: c  reason: collision with root package name */
    public float[] f13762c = new float[2];

    /* renamed from: d  reason: collision with root package name */
    public float[] f13763d = new float[2];

    public void draw(Canvas canvas, Paint paint) {
        for (int i11 = 0; i11 < 2; i11++) {
            canvas.save();
            canvas.translate(this.f13762c[i11], this.f13763d[i11]);
            canvas.drawCircle(0.0f, 0.0f, (float) (getWidth() / 10), paint);
            canvas.restore();
        }
    }

    public ArrayList<ValueAnimator> onCreateAnimators() {
        ArrayList<ValueAnimator> arrayList = new ArrayList<>();
        float width = (float) (getWidth() / 6);
        float width2 = (float) (getWidth() / 6);
        for (final int i11 = 0; i11 < 2; i11++) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{width, ((float) getWidth()) - width, (float) (getWidth() / 2), width});
            if (i11 == 1) {
                ofFloat = ValueAnimator.ofFloat(new float[]{((float) getWidth()) - width, width, (float) (getWidth() / 2), ((float) getWidth()) - width});
            }
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{width2, width2, (float) (getHeight() / 2), width2});
            if (i11 == 1) {
                ofFloat2 = ValueAnimator.ofFloat(new float[]{((float) getHeight()) - width2, ((float) getHeight()) - width2, (float) (getHeight() / 2), ((float) getHeight()) - width2});
            }
            ofFloat.setDuration(1000);
            ofFloat.setInterpolator(new LinearInterpolator());
            ofFloat.setRepeatCount(-1);
            addUpdateListener(ofFloat, new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    BallZigZagIndicator.this.f13762c[i11] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    BallZigZagIndicator.this.postInvalidate();
                }
            });
            ofFloat2.setDuration(1000);
            ofFloat2.setInterpolator(new LinearInterpolator());
            ofFloat2.setRepeatCount(-1);
            addUpdateListener(ofFloat2, new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    BallZigZagIndicator.this.f13763d[i11] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    BallZigZagIndicator.this.postInvalidate();
                }
            });
            arrayList.add(ofFloat);
            arrayList.add(ofFloat2);
        }
        return arrayList;
    }
}
