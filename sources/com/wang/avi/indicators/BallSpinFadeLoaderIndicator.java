package com.wang.avi.indicators;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.wang.avi.Indicator;
import java.util.ArrayList;

public class BallSpinFadeLoaderIndicator extends Indicator {
    public static final int ALPHA = 255;
    public static final float SCALE = 1.0f;

    /* renamed from: c  reason: collision with root package name */
    public float[] f13743c = {1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f};

    /* renamed from: d  reason: collision with root package name */
    public int[] f13744d = {255, 255, 255, 255, 255, 255, 255, 255};

    public final class Point {

        /* renamed from: x  reason: collision with root package name */
        public float f13750x;

        /* renamed from: y  reason: collision with root package name */
        public float f13751y;

        public Point(float f11, float f12) {
            this.f13750x = f11;
            this.f13751y = f12;
        }
    }

    public Point a(int i11, int i12, float f11, double d11) {
        double d12 = (double) f11;
        return new Point((float) (((double) (i11 / 2)) + (Math.cos(d11) * d12)), (float) (((double) (i12 / 2)) + (d12 * Math.sin(d11))));
    }

    public void draw(Canvas canvas, Paint paint) {
        float width = (float) (getWidth() / 10);
        for (int i11 = 0; i11 < 8; i11++) {
            canvas.save();
            Point a11 = a(getWidth(), getHeight(), ((float) (getWidth() / 2)) - width, 0.7853981633974483d * ((double) i11));
            canvas.translate(a11.f13750x, a11.f13751y);
            float f11 = this.f13743c[i11];
            canvas.scale(f11, f11);
            paint.setAlpha(this.f13744d[i11]);
            canvas.drawCircle(0.0f, 0.0f, width, paint);
            canvas.restore();
        }
    }

    public ArrayList<ValueAnimator> onCreateAnimators() {
        ArrayList<ValueAnimator> arrayList = new ArrayList<>();
        int[] iArr = {0, 120, PsExtractor.VIDEO_STREAM_MASK, 360, 480, 600, 720, 780, 840};
        for (final int i11 = 0; i11 < 8; i11++) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 0.4f, 1.0f});
            ofFloat.setDuration(1000);
            ofFloat.setRepeatCount(-1);
            ofFloat.setStartDelay((long) iArr[i11]);
            addUpdateListener(ofFloat, new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    BallSpinFadeLoaderIndicator.this.f13743c[i11] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    BallSpinFadeLoaderIndicator.this.postInvalidate();
                }
            });
            ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{255, 77, 255});
            ofInt.setDuration(1000);
            ofInt.setRepeatCount(-1);
            ofInt.setStartDelay((long) iArr[i11]);
            addUpdateListener(ofInt, new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    BallSpinFadeLoaderIndicator.this.f13744d[i11] = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    BallSpinFadeLoaderIndicator.this.postInvalidate();
                }
            });
            arrayList.add(ofFloat);
            arrayList.add(ofInt);
        }
        return arrayList;
    }
}
