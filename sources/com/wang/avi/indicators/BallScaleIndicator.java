package com.wang.avi.indicators;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.animation.LinearInterpolator;
import com.wang.avi.Indicator;
import java.util.ArrayList;

public class BallScaleIndicator extends Indicator {

    /* renamed from: c  reason: collision with root package name */
    public float f13727c = 1.0f;

    /* renamed from: d  reason: collision with root package name */
    public int f13728d = 255;

    public void draw(Canvas canvas, Paint paint) {
        paint.setAlpha(this.f13728d);
        float f11 = this.f13727c;
        canvas.scale(f11, f11, (float) (getWidth() / 2), (float) (getHeight() / 2));
        paint.setAlpha(this.f13728d);
        canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), ((float) (getWidth() / 2)) - 4.0f, paint);
    }

    public ArrayList<ValueAnimator> onCreateAnimators() {
        ArrayList<ValueAnimator> arrayList = new ArrayList<>();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setDuration(1000);
        ofFloat.setRepeatCount(-1);
        addUpdateListener(ofFloat, new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                BallScaleIndicator.this.f13727c = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                BallScaleIndicator.this.postInvalidate();
            }
        });
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{255, 0});
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.setDuration(1000);
        ofInt.setRepeatCount(-1);
        addUpdateListener(ofInt, new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                BallScaleIndicator.this.f13728d = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                BallScaleIndicator.this.postInvalidate();
            }
        });
        arrayList.add(ofFloat);
        arrayList.add(ofInt);
        return arrayList;
    }
}
