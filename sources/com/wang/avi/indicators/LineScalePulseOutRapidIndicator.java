package com.wang.avi.indicators;

import android.animation.ValueAnimator;
import java.util.ArrayList;

public class LineScalePulseOutRapidIndicator extends LineScaleIndicator {
    public ArrayList<ValueAnimator> onCreateAnimators() {
        ArrayList<ValueAnimator> arrayList = new ArrayList<>();
        long[] jArr = {400, 200, 0, 200, 400};
        for (final int i11 = 0; i11 < 5; i11++) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 0.4f, 1.0f});
            ofFloat.setDuration(1000);
            ofFloat.setRepeatCount(-1);
            ofFloat.setStartDelay(jArr[i11]);
            addUpdateListener(ofFloat, new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    LineScalePulseOutRapidIndicator.this.f13778c[i11] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    LineScalePulseOutRapidIndicator.this.postInvalidate();
                }
            });
            arrayList.add(ofFloat);
        }
        return arrayList;
    }
}
