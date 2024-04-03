package com.wang.avi.indicators;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.wang.avi.Indicator;
import io.flutter.plugin.platform.PlatformPlugin;
import java.util.ArrayList;

public class BallGridPulseIndicator extends Indicator {
    public static final int ALPHA = 255;
    public static final float SCALE = 1.0f;

    /* renamed from: c  reason: collision with root package name */
    public int[] f13711c = {255, 255, 255, 255, 255, 255, 255, 255, 255};

    /* renamed from: d  reason: collision with root package name */
    public float[] f13712d = {1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f};

    public void draw(Canvas canvas, Paint paint) {
        float width = (((float) getWidth()) - 16.0f) / 6.0f;
        float f11 = 2.0f * width;
        float f12 = f11 + 4.0f;
        float width2 = ((float) (getWidth() / 2)) - f12;
        float width3 = ((float) (getWidth() / 2)) - f12;
        for (int i11 = 0; i11 < 3; i11++) {
            for (int i12 = 0; i12 < 3; i12++) {
                canvas.save();
                float f13 = (float) i12;
                float f14 = (f11 * f13) + width2 + (f13 * 4.0f);
                float f15 = (float) i11;
                canvas.translate(f14, (f11 * f15) + width3 + (f15 * 4.0f));
                int i13 = (i11 * 3) + i12;
                float f16 = this.f13712d[i13];
                canvas.scale(f16, f16);
                paint.setAlpha(this.f13711c[i13]);
                canvas.drawCircle(0.0f, 0.0f, width, paint);
                canvas.restore();
            }
        }
    }

    public ArrayList<ValueAnimator> onCreateAnimators() {
        ArrayList<ValueAnimator> arrayList = new ArrayList<>();
        int[] iArr = {720, 1020, PlatformPlugin.DEFAULT_SYSTEM_UI, 1420, 1450, 1180, 870, 1450, 1060};
        int[] iArr2 = {-60, 250, -170, 480, 310, 30, 460, 780, 450};
        for (final int i11 = 0; i11 < 9; i11++) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 0.5f, 1.0f});
            ofFloat.setDuration((long) iArr[i11]);
            ofFloat.setRepeatCount(-1);
            ofFloat.setStartDelay((long) iArr2[i11]);
            addUpdateListener(ofFloat, new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    BallGridPulseIndicator.this.f13712d[i11] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    BallGridPulseIndicator.this.postInvalidate();
                }
            });
            ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{255, 210, 122, 255});
            ofInt.setDuration((long) iArr[i11]);
            ofInt.setRepeatCount(-1);
            ofInt.setStartDelay((long) iArr2[i11]);
            addUpdateListener(ofInt, new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    BallGridPulseIndicator.this.f13711c[i11] = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    BallGridPulseIndicator.this.postInvalidate();
                }
            });
            arrayList.add(ofFloat);
            arrayList.add(ofInt);
        }
        return arrayList;
    }
}
