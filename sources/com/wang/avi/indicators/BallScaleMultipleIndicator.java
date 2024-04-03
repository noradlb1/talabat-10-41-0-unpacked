package com.wang.avi.indicators;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.animation.LinearInterpolator;
import com.wang.avi.Indicator;
import java.util.ArrayList;

public class BallScaleMultipleIndicator extends Indicator {

    /* renamed from: c  reason: collision with root package name */
    public float[] f13731c = {1.0f, 1.0f, 1.0f};

    /* renamed from: d  reason: collision with root package name */
    public int[] f13732d = {255, 255, 255};

    public void draw(Canvas canvas, Paint paint) {
        for (int i11 = 0; i11 < 3; i11++) {
            paint.setAlpha(this.f13732d[i11]);
            float f11 = this.f13731c[i11];
            canvas.scale(f11, f11, (float) (getWidth() / 2), (float) (getHeight() / 2));
            canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), ((float) (getWidth() / 2)) - 4.0f, paint);
        }
    }

    public ArrayList<ValueAnimator> onCreateAnimators() {
        ArrayList<ValueAnimator> arrayList = new ArrayList<>();
        long[] jArr = {0, 200, 400};
        for (final int i11 = 0; i11 < 3; i11++) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            ofFloat.setInterpolator(new LinearInterpolator());
            ofFloat.setDuration(1000);
            ofFloat.setRepeatCount(-1);
            addUpdateListener(ofFloat, new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    BallScaleMultipleIndicator.this.f13731c[i11] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    BallScaleMultipleIndicator.this.postInvalidate();
                }
            });
            ofFloat.setStartDelay(jArr[i11]);
            ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{255, 0});
            ofInt.setInterpolator(new LinearInterpolator());
            ofInt.setDuration(1000);
            ofInt.setRepeatCount(-1);
            addUpdateListener(ofInt, new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    BallScaleMultipleIndicator.this.f13732d[i11] = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    BallScaleMultipleIndicator.this.postInvalidate();
                }
            });
            ofFloat.setStartDelay(jArr[i11]);
            arrayList.add(ofFloat);
            arrayList.add(ofInt);
        }
        return arrayList;
    }
}
