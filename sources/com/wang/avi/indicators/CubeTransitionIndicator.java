package com.wang.avi.indicators;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.animation.LinearInterpolator;
import com.wang.avi.Indicator;
import java.util.ArrayList;

public class CubeTransitionIndicator extends Indicator {

    /* renamed from: c  reason: collision with root package name */
    public float[] f13768c = new float[2];

    /* renamed from: d  reason: collision with root package name */
    public float[] f13769d = new float[2];

    /* renamed from: e  reason: collision with root package name */
    public float f13770e;

    /* renamed from: f  reason: collision with root package name */
    public float f13771f = 1.0f;

    public void draw(Canvas canvas, Paint paint) {
        float width = (float) (getWidth() / 5);
        float height = (float) (getHeight() / 5);
        for (int i11 = 0; i11 < 2; i11++) {
            canvas.save();
            canvas.translate(this.f13768c[i11], this.f13769d[i11]);
            canvas.rotate(this.f13770e);
            float f11 = this.f13771f;
            canvas.scale(f11, f11);
            canvas.drawRect(new RectF((-width) / 2.0f, (-height) / 2.0f, width / 2.0f, height / 2.0f), paint);
            canvas.restore();
        }
    }

    public ArrayList<ValueAnimator> onCreateAnimators() {
        ArrayList<ValueAnimator> arrayList = new ArrayList<>();
        float width = (float) (getWidth() / 5);
        float height = (float) (getHeight() / 5);
        for (final int i11 = 0; i11 < 2; i11++) {
            this.f13768c[i11] = width;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{width, ((float) getWidth()) - width, ((float) getWidth()) - width, width, width});
            if (i11 == 1) {
                ofFloat = ValueAnimator.ofFloat(new float[]{((float) getWidth()) - width, width, width, ((float) getWidth()) - width, ((float) getWidth()) - width});
            }
            ofFloat.setInterpolator(new LinearInterpolator());
            ofFloat.setDuration(1600);
            ofFloat.setRepeatCount(-1);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    CubeTransitionIndicator.this.f13768c[i11] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    CubeTransitionIndicator.this.postInvalidate();
                }
            });
            this.f13769d[i11] = height;
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{height, height, ((float) getHeight()) - height, ((float) getHeight()) - height, height});
            if (i11 == 1) {
                ofFloat2 = ValueAnimator.ofFloat(new float[]{((float) getHeight()) - height, ((float) getHeight()) - height, height, height, ((float) getHeight()) - height});
            }
            ofFloat2.setDuration(1600);
            ofFloat2.setInterpolator(new LinearInterpolator());
            ofFloat2.setRepeatCount(-1);
            addUpdateListener(ofFloat2, new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    CubeTransitionIndicator.this.f13769d[i11] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    CubeTransitionIndicator.this.postInvalidate();
                }
            });
            arrayList.add(ofFloat);
            arrayList.add(ofFloat2);
        }
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(new float[]{1.0f, 0.5f, 1.0f, 0.5f, 1.0f});
        ofFloat3.setDuration(1600);
        ofFloat3.setInterpolator(new LinearInterpolator());
        ofFloat3.setRepeatCount(-1);
        addUpdateListener(ofFloat3, new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                CubeTransitionIndicator.this.f13771f = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CubeTransitionIndicator.this.postInvalidate();
            }
        });
        ValueAnimator ofFloat4 = ValueAnimator.ofFloat(new float[]{0.0f, 180.0f, 360.0f, 540.0f, 720.0f});
        ofFloat4.setDuration(1600);
        ofFloat4.setInterpolator(new LinearInterpolator());
        ofFloat4.setRepeatCount(-1);
        addUpdateListener(ofFloat4, new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                CubeTransitionIndicator.this.f13770e = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CubeTransitionIndicator.this.postInvalidate();
            }
        });
        arrayList.add(ofFloat3);
        arrayList.add(ofFloat4);
        return arrayList;
    }
}
