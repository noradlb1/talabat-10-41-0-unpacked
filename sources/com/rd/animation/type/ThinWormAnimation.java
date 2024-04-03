package com.rd.animation.type;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.annotation.NonNull;
import com.rd.animation.controller.ValueController;
import com.rd.animation.data.type.ThinWormAnimationValue;
import com.rd.animation.type.WormAnimation;

public class ThinWormAnimation extends WormAnimation {
    private ThinWormAnimationValue value = new ThinWormAnimationValue();

    public ThinWormAnimation(@NonNull ValueController.UpdateListener updateListener) {
        super(updateListener);
    }

    private ValueAnimator createHeightAnimator(int i11, int i12, long j11) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i11, i12});
        ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
        ofInt.setDuration(j11);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ThinWormAnimation.this.onAnimateUpdated(valueAnimator);
            }
        });
        return ofInt;
    }

    /* access modifiers changed from: private */
    public void onAnimateUpdated(@NonNull ValueAnimator valueAnimator) {
        this.value.setHeight(((Integer) valueAnimator.getAnimatedValue()).intValue());
        ValueController.UpdateListener updateListener = this.f52889b;
        if (updateListener != null) {
            updateListener.onValueUpdated(this.value);
        }
    }

    public WormAnimation with(int i11, int i12, int i13, boolean z11) {
        int i14 = i11;
        int i15 = i13;
        boolean z12 = z11;
        if (d(i11, i12, i13, z11)) {
            this.f52890c = createAnimator();
            this.f52904d = i14;
            this.f52905e = i12;
            this.f52906f = i15;
            this.f52907g = z12;
            int i16 = i15 * 2;
            int i17 = i14 - i15;
            this.f52908h = i17;
            this.f52909i = i14 + i15;
            this.value.setRectStart(i17);
            this.value.setRectEnd(this.f52909i);
            this.value.setHeight(i16);
            WormAnimation.RectValues b11 = b(z12);
            long j11 = this.f52888a;
            long j12 = (long) (((double) j11) * 0.8d);
            long j13 = (long) (((double) j11) * 0.2d);
            long j14 = (long) (((double) j11) * 0.5d);
            long j15 = (long) (((double) j11) * 0.5d);
            long j16 = j12;
            ValueAnimator c11 = c(b11.f52913a, b11.f52914b, j16, false, this.value);
            ValueAnimator c12 = c(b11.f52915c, b11.f52916d, j16, true, this.value);
            c12.setStartDelay(j13);
            long j17 = j15;
            ValueAnimator createHeightAnimator = createHeightAnimator(i16, i15, j17);
            ValueAnimator createHeightAnimator2 = createHeightAnimator(i15, i16, j17);
            createHeightAnimator2.setStartDelay(j14);
            ((AnimatorSet) this.f52890c).playTogether(new Animator[]{c11, c12, createHeightAnimator, createHeightAnimator2});
        }
        return this;
    }

    public ThinWormAnimation duration(long j11) {
        super.duration(j11);
        return this;
    }

    public ThinWormAnimation progress(float f11) {
        T t11 = this.f52890c;
        if (t11 != null) {
            long j11 = (long) (f11 * ((float) this.f52888a));
            int size = ((AnimatorSet) t11).getChildAnimations().size();
            for (int i11 = 0; i11 < size; i11++) {
                ValueAnimator valueAnimator = (ValueAnimator) ((AnimatorSet) this.f52890c).getChildAnimations().get(i11);
                long startDelay = j11 - valueAnimator.getStartDelay();
                long duration = valueAnimator.getDuration();
                if (startDelay > duration) {
                    startDelay = duration;
                } else if (startDelay < 0) {
                    startDelay = 0;
                }
                if ((i11 != size - 1 || startDelay > 0) && valueAnimator.getValues() != null && valueAnimator.getValues().length > 0) {
                    valueAnimator.setCurrentPlayTime(startDelay);
                }
            }
        }
        return this;
    }
}
