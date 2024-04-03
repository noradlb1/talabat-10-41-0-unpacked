package com.wang.avi.indicators;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.wang.avi.Indicator;
import java.util.ArrayList;

public class BallPulseIndicator extends Indicator {
    public static final float SCALE = 1.0f;
    /* access modifiers changed from: private */
    public float[] scaleFloats = {1.0f, 1.0f, 1.0f};

    public void draw(Canvas canvas, Paint paint) {
        float min = (((float) Math.min(getWidth(), getHeight())) - 8.0f) / 6.0f;
        float f11 = 2.0f * min;
        float width = ((float) (getWidth() / 2)) - (f11 + 4.0f);
        float height = (float) (getHeight() / 2);
        for (int i11 = 0; i11 < 3; i11++) {
            canvas.save();
            float f12 = (float) i11;
            canvas.translate((f11 * f12) + width + (f12 * 4.0f), height);
            float f13 = this.scaleFloats[i11];
            canvas.scale(f13, f13);
            canvas.drawCircle(0.0f, 0.0f, min, paint);
            canvas.restore();
        }
    }

    public ArrayList<ValueAnimator> onCreateAnimators() {
        ArrayList<ValueAnimator> arrayList = new ArrayList<>();
        int[] iArr = {120, PsExtractor.VIDEO_STREAM_MASK, 360};
        for (final int i11 = 0; i11 < 3; i11++) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 0.3f, 1.0f});
            ofFloat.setDuration(750);
            ofFloat.setRepeatCount(-1);
            ofFloat.setStartDelay((long) iArr[i11]);
            addUpdateListener(ofFloat, new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    BallPulseIndicator.this.scaleFloats[i11] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    BallPulseIndicator.this.postInvalidate();
                }
            });
            arrayList.add(ofFloat);
        }
        return arrayList;
    }
}
