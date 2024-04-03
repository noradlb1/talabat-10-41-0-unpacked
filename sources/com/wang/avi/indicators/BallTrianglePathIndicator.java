package com.wang.avi.indicators;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.animation.LinearInterpolator;
import com.google.android.exoplayer2.ExoPlayer;
import com.wang.avi.Indicator;
import java.util.ArrayList;

public class BallTrianglePathIndicator extends Indicator {

    /* renamed from: c  reason: collision with root package name */
    public float[] f13752c = new float[3];

    /* renamed from: d  reason: collision with root package name */
    public float[] f13753d = new float[3];

    public void draw(Canvas canvas, Paint paint) {
        paint.setStrokeWidth(3.0f);
        paint.setStyle(Paint.Style.STROKE);
        for (int i11 = 0; i11 < 3; i11++) {
            canvas.save();
            canvas.translate(this.f13752c[i11], this.f13753d[i11]);
            canvas.drawCircle(0.0f, 0.0f, (float) (getWidth() / 10), paint);
            canvas.restore();
        }
    }

    public ArrayList<ValueAnimator> onCreateAnimators() {
        ArrayList<ValueAnimator> arrayList = new ArrayList<>();
        float width = (float) (getWidth() / 5);
        float width2 = (float) (getWidth() / 5);
        for (final int i11 = 0; i11 < 3; i11++) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{(float) (getWidth() / 2), ((float) getWidth()) - width, width, (float) (getWidth() / 2)});
            if (i11 == 1) {
                ofFloat = ValueAnimator.ofFloat(new float[]{((float) getWidth()) - width, width, (float) (getWidth() / 2), ((float) getWidth()) - width});
            } else if (i11 == 2) {
                ofFloat = ValueAnimator.ofFloat(new float[]{width, (float) (getWidth() / 2), ((float) getWidth()) - width, width});
            }
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{width2, ((float) getHeight()) - width2, ((float) getHeight()) - width2, width2});
            if (i11 == 1) {
                ofFloat2 = ValueAnimator.ofFloat(new float[]{((float) getHeight()) - width2, ((float) getHeight()) - width2, width2, ((float) getHeight()) - width2});
            } else if (i11 == 2) {
                ofFloat2 = ValueAnimator.ofFloat(new float[]{((float) getHeight()) - width2, width2, ((float) getHeight()) - width2, ((float) getHeight()) - width2});
            }
            ofFloat.setDuration(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
            ofFloat.setInterpolator(new LinearInterpolator());
            ofFloat.setRepeatCount(-1);
            addUpdateListener(ofFloat, new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    BallTrianglePathIndicator.this.f13752c[i11] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    BallTrianglePathIndicator.this.postInvalidate();
                }
            });
            ofFloat2.setDuration(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
            ofFloat2.setInterpolator(new LinearInterpolator());
            ofFloat2.setRepeatCount(-1);
            addUpdateListener(ofFloat2, new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    BallTrianglePathIndicator.this.f13753d[i11] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    BallTrianglePathIndicator.this.postInvalidate();
                }
            });
            arrayList.add(ofFloat);
            arrayList.add(ofFloat2);
        }
        return arrayList;
    }
}
