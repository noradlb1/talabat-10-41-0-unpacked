package com.wang.avi.indicators;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.wang.avi.Indicator;
import java.util.ArrayList;

public class BallBeatIndicator extends Indicator {
    public static final int ALPHA = 255;
    public static final float SCALE = 1.0f;

    /* renamed from: c  reason: collision with root package name */
    public int[] f13689c = {255, 255, 255};
    /* access modifiers changed from: private */
    public float[] scaleFloats = {1.0f, 1.0f, 1.0f};

    public void draw(Canvas canvas, Paint paint) {
        float width = (((float) getWidth()) - 8.0f) / 6.0f;
        float f11 = 2.0f * width;
        float width2 = ((float) (getWidth() / 2)) - (f11 + 4.0f);
        float height = (float) (getHeight() / 2);
        for (int i11 = 0; i11 < 3; i11++) {
            canvas.save();
            float f12 = (float) i11;
            canvas.translate((f11 * f12) + width2 + (f12 * 4.0f), height);
            float f13 = this.scaleFloats[i11];
            canvas.scale(f13, f13);
            paint.setAlpha(this.f13689c[i11]);
            canvas.drawCircle(0.0f, 0.0f, width, paint);
            canvas.restore();
        }
    }

    public ArrayList<ValueAnimator> onCreateAnimators() {
        ArrayList<ValueAnimator> arrayList = new ArrayList<>();
        int[] iArr = {350, 0, 350};
        for (final int i11 = 0; i11 < 3; i11++) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 0.75f, 1.0f});
            ofFloat.setDuration(700);
            ofFloat.setRepeatCount(-1);
            ofFloat.setStartDelay((long) iArr[i11]);
            addUpdateListener(ofFloat, new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    BallBeatIndicator.this.scaleFloats[i11] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    BallBeatIndicator.this.postInvalidate();
                }
            });
            ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{255, 51, 255});
            ofInt.setDuration(700);
            ofInt.setRepeatCount(-1);
            ofInt.setStartDelay((long) iArr[i11]);
            addUpdateListener(ofInt, new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    BallBeatIndicator.this.f13689c[i11] = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    BallBeatIndicator.this.postInvalidate();
                }
            });
            arrayList.add(ofFloat);
            arrayList.add(ofInt);
        }
        return arrayList;
    }
}
