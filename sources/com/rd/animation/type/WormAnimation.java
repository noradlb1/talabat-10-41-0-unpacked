package com.rd.animation.type;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.annotation.NonNull;
import com.rd.animation.controller.ValueController;
import com.rd.animation.data.type.WormAnimationValue;
import java.util.Iterator;

public class WormAnimation extends BaseAnimation<AnimatorSet> {

    /* renamed from: d  reason: collision with root package name */
    public int f52904d;

    /* renamed from: e  reason: collision with root package name */
    public int f52905e;

    /* renamed from: f  reason: collision with root package name */
    public int f52906f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f52907g;

    /* renamed from: h  reason: collision with root package name */
    public int f52908h;

    /* renamed from: i  reason: collision with root package name */
    public int f52909i;
    private WormAnimationValue value = new WormAnimationValue();

    public class RectValues {

        /* renamed from: a  reason: collision with root package name */
        public final int f52913a;

        /* renamed from: b  reason: collision with root package name */
        public final int f52914b;

        /* renamed from: c  reason: collision with root package name */
        public final int f52915c;

        /* renamed from: d  reason: collision with root package name */
        public final int f52916d;

        public RectValues(int i11, int i12, int i13, int i14) {
            this.f52913a = i11;
            this.f52914b = i12;
            this.f52915c = i13;
            this.f52916d = i14;
        }
    }

    public WormAnimation(@NonNull ValueController.UpdateListener updateListener) {
        super(updateListener);
    }

    /* access modifiers changed from: private */
    public void onAnimateUpdated(@NonNull WormAnimationValue wormAnimationValue, @NonNull ValueAnimator valueAnimator, boolean z11) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        if (this.f52907g) {
            if (!z11) {
                wormAnimationValue.setRectEnd(intValue);
            } else {
                wormAnimationValue.setRectStart(intValue);
            }
        } else if (!z11) {
            wormAnimationValue.setRectStart(intValue);
        } else {
            wormAnimationValue.setRectEnd(intValue);
        }
        ValueController.UpdateListener updateListener = this.f52889b;
        if (updateListener != null) {
            updateListener.onValueUpdated(wormAnimationValue);
        }
    }

    @NonNull
    public RectValues b(boolean z11) {
        int i11;
        int i12;
        int i13;
        int i14;
        if (z11) {
            int i15 = this.f52904d;
            int i16 = this.f52906f;
            i14 = i15 + i16;
            int i17 = this.f52905e;
            i12 = i17 + i16;
            i11 = i15 - i16;
            i13 = i17 - i16;
        } else {
            int i18 = this.f52904d;
            int i19 = this.f52906f;
            i14 = i18 - i19;
            int i21 = this.f52905e;
            i12 = i21 - i19;
            i11 = i18 + i19;
            i13 = i21 + i19;
        }
        return new RectValues(i14, i12, i11, i13);
    }

    public ValueAnimator c(int i11, int i12, long j11, final boolean z11, final WormAnimationValue wormAnimationValue) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i11, i12});
        ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
        ofInt.setDuration(j11);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                WormAnimation.this.onAnimateUpdated(wormAnimationValue, valueAnimator, z11);
            }
        });
        return ofInt;
    }

    public boolean d(int i11, int i12, int i13, boolean z11) {
        if (this.f52904d == i11 && this.f52905e == i12 && this.f52906f == i13 && this.f52907g == z11) {
            return false;
        }
        return true;
    }

    public WormAnimation with(int i11, int i12, int i13, boolean z11) {
        if (d(i11, i12, i13, z11)) {
            this.f52890c = createAnimator();
            this.f52904d = i11;
            this.f52905e = i12;
            this.f52906f = i13;
            this.f52907g = z11;
            int i14 = i11 - i13;
            this.f52908h = i14;
            this.f52909i = i11 + i13;
            this.value.setRectStart(i14);
            this.value.setRectEnd(this.f52909i);
            RectValues b11 = b(z11);
            long j11 = this.f52888a / 2;
            ((AnimatorSet) this.f52890c).playSequentially(new Animator[]{c(b11.f52913a, b11.f52914b, j11, false, this.value), c(b11.f52915c, b11.f52916d, j11, true, this.value)});
        }
        return this;
    }

    @NonNull
    public AnimatorSet createAnimator() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        return animatorSet;
    }

    public WormAnimation duration(long j11) {
        super.duration(j11);
        return this;
    }

    public WormAnimation progress(float f11) {
        T t11 = this.f52890c;
        if (t11 == null) {
            return this;
        }
        long j11 = (long) (f11 * ((float) this.f52888a));
        Iterator<Animator> it = ((AnimatorSet) t11).getChildAnimations().iterator();
        while (it.hasNext()) {
            ValueAnimator valueAnimator = (ValueAnimator) it.next();
            long duration = valueAnimator.getDuration();
            if (j11 <= duration) {
                duration = j11;
            }
            valueAnimator.setCurrentPlayTime(duration);
            j11 -= duration;
        }
        return this;
    }
}
