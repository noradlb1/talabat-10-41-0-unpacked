package com.wang.avi.indicators;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.wang.avi.Indicator;
import java.util.ArrayList;
import net.bytebuddy.jar.asm.Opcodes;

public class BallPulseSyncIndicator extends Indicator {

    /* renamed from: c  reason: collision with root package name */
    public float[] f13720c = new float[3];

    public void draw(Canvas canvas, Paint paint) {
        float width = (((float) getWidth()) - 8.0f) / 6.0f;
        float f11 = 2.0f * width;
        float width2 = ((float) (getWidth() / 2)) - (f11 + 4.0f);
        for (int i11 = 0; i11 < 3; i11++) {
            canvas.save();
            float f12 = (float) i11;
            canvas.translate((f11 * f12) + width2 + (f12 * 4.0f), this.f13720c[i11]);
            canvas.drawCircle(0.0f, 0.0f, width, paint);
            canvas.restore();
        }
    }

    public ArrayList<ValueAnimator> onCreateAnimators() {
        ArrayList<ValueAnimator> arrayList = new ArrayList<>();
        float width = (((float) getWidth()) - 8.0f) / 6.0f;
        int[] iArr = {70, Opcodes.F2L, 210};
        for (final int i11 = 0; i11 < 3; i11++) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{(float) (getHeight() / 2), ((float) (getHeight() / 2)) - (2.0f * width), (float) (getHeight() / 2)});
            ofFloat.setDuration(600);
            ofFloat.setRepeatCount(-1);
            ofFloat.setStartDelay((long) iArr[i11]);
            addUpdateListener(ofFloat, new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    BallPulseSyncIndicator.this.f13720c[i11] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    BallPulseSyncIndicator.this.postInvalidate();
                }
            });
            arrayList.add(ofFloat);
        }
        return arrayList;
    }
}
