package com.rd.animation.type;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.annotation.NonNull;
import com.rd.animation.controller.ValueController;
import com.rd.animation.data.type.DropAnimationValue;
import java.util.Iterator;

public class DropAnimation extends BaseAnimation<AnimatorSet> {
    private int heightEnd;
    private int heightStart;
    private int radius;
    private DropAnimationValue value = new DropAnimationValue();
    private int widthEnd;
    private int widthStart;

    /* renamed from: com.rd.animation.type.DropAnimation$2  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f52896a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.rd.animation.type.DropAnimation$AnimationType[] r0 = com.rd.animation.type.DropAnimation.AnimationType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f52896a = r0
                com.rd.animation.type.DropAnimation$AnimationType r1 = com.rd.animation.type.DropAnimation.AnimationType.Width     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f52896a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.rd.animation.type.DropAnimation$AnimationType r1 = com.rd.animation.type.DropAnimation.AnimationType.Height     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f52896a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.rd.animation.type.DropAnimation$AnimationType r1 = com.rd.animation.type.DropAnimation.AnimationType.Radius     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.rd.animation.type.DropAnimation.AnonymousClass2.<clinit>():void");
        }
    }

    public enum AnimationType {
        Width,
        Height,
        Radius
    }

    public DropAnimation(@NonNull ValueController.UpdateListener updateListener) {
        super(updateListener);
    }

    private ValueAnimator createValueAnimation(int i11, int i12, long j11, final AnimationType animationType) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i11, i12});
        ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
        ofInt.setDuration(j11);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                DropAnimation.this.onAnimatorUpdate(valueAnimator, animationType);
            }
        });
        return ofInt;
    }

    private boolean hasChanges(int i11, int i12, int i13, int i14, int i15) {
        if (this.widthStart == i11 && this.widthEnd == i12 && this.heightStart == i13 && this.heightEnd == i14 && this.radius == i15) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void onAnimatorUpdate(@NonNull ValueAnimator valueAnimator, @NonNull AnimationType animationType) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        int i11 = AnonymousClass2.f52896a[animationType.ordinal()];
        if (i11 == 1) {
            this.value.setWidth(intValue);
        } else if (i11 == 2) {
            this.value.setHeight(intValue);
        } else if (i11 == 3) {
            this.value.setRadius(intValue);
        }
        ValueController.UpdateListener updateListener = this.f52889b;
        if (updateListener != null) {
            updateListener.onValueUpdated(this.value);
        }
    }

    public DropAnimation with(int i11, int i12, int i13, int i14, int i15) {
        int i16 = i15;
        if (hasChanges(i11, i12, i13, i14, i15)) {
            this.f52890c = createAnimator();
            int i17 = i11;
            this.widthStart = i17;
            int i18 = i12;
            this.widthEnd = i18;
            this.heightStart = i13;
            this.heightEnd = i14;
            this.radius = i16;
            int i19 = (int) (((double) i16) / 1.5d);
            long j11 = this.f52888a;
            ValueAnimator createValueAnimation = createValueAnimation(i17, i18, j11, AnimationType.Width);
            AnimationType animationType = AnimationType.Height;
            long j12 = j11 / 2;
            ValueAnimator createValueAnimation2 = createValueAnimation(i13, i14, j12, animationType);
            AnimationType animationType2 = AnimationType.Radius;
            ValueAnimator createValueAnimation3 = createValueAnimation(i14, i13, j12, animationType);
            ValueAnimator createValueAnimation4 = createValueAnimation(i19, i15, j12, animationType2);
            ((AnimatorSet) this.f52890c).play(createValueAnimation2).with(createValueAnimation(i15, i19, j12, animationType2)).with(createValueAnimation).before(createValueAnimation3).before(createValueAnimation4);
        }
        return this;
    }

    @NonNull
    public AnimatorSet createAnimator() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        return animatorSet;
    }

    public DropAnimation duration(long j11) {
        super.duration(j11);
        return this;
    }

    public DropAnimation progress(float f11) {
        T t11 = this.f52890c;
        if (t11 != null) {
            long j11 = (long) (f11 * ((float) this.f52888a));
            Iterator<Animator> it = ((AnimatorSet) t11).getChildAnimations().iterator();
            boolean z11 = false;
            while (it.hasNext()) {
                ValueAnimator valueAnimator = (ValueAnimator) it.next();
                long duration = valueAnimator.getDuration();
                long j12 = z11 ? j11 - duration : j11;
                if (j12 >= 0) {
                    if (j12 >= duration) {
                        j12 = duration;
                    }
                    if (valueAnimator.getValues() != null && valueAnimator.getValues().length > 0) {
                        valueAnimator.setCurrentPlayTime(j12);
                    }
                    if (!z11 && duration >= this.f52888a) {
                        z11 = true;
                    }
                }
            }
        }
        return this;
    }
}
