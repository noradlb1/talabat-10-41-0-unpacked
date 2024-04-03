package com.wang.avi.indicators;

import android.animation.ValueAnimator;
import android.view.animation.LinearInterpolator;
import com.google.android.exoplayer2.ExoPlayer;
import java.util.ArrayList;

public class BallZigZagDeflectIndicator extends BallZigZagIndicator {
    public ArrayList<ValueAnimator> onCreateAnimators() {
        ArrayList<ValueAnimator> arrayList = new ArrayList<>();
        float width = (float) (getWidth() / 6);
        float width2 = (float) (getWidth() / 6);
        for (final int i11 = 0; i11 < 2; i11++) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{width, ((float) getWidth()) - width, width, ((float) getWidth()) - width, width});
            if (i11 == 1) {
                ofFloat = ValueAnimator.ofFloat(new float[]{((float) getWidth()) - width, width, ((float) getWidth()) - width, width, ((float) getWidth()) - width});
            }
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{width2, width2, ((float) getHeight()) - width2, ((float) getHeight()) - width2, width2});
            if (i11 == 1) {
                ofFloat2 = ValueAnimator.ofFloat(new float[]{((float) getHeight()) - width2, ((float) getHeight()) - width2, width2, width2, ((float) getHeight()) - width2});
            }
            ofFloat.setDuration(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
            ofFloat.setInterpolator(new LinearInterpolator());
            ofFloat.setRepeatCount(-1);
            addUpdateListener(ofFloat, new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    BallZigZagDeflectIndicator.this.f13762c[i11] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    BallZigZagDeflectIndicator.this.postInvalidate();
                }
            });
            ofFloat2.setDuration(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
            ofFloat2.setInterpolator(new LinearInterpolator());
            ofFloat2.setRepeatCount(-1);
            addUpdateListener(ofFloat2, new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    BallZigZagDeflectIndicator.this.f13763d[i11] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    BallZigZagDeflectIndicator.this.postInvalidate();
                }
            });
            arrayList.add(ofFloat);
            arrayList.add(ofFloat2);
        }
        return arrayList;
    }
}
