package com.rd.animation.type;

import android.animation.ArgbEvaluator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.rd.animation.controller.ValueController;
import com.rd.animation.data.type.ColorAnimationValue;

public class ColorAnimation extends BaseAnimation<ValueAnimator> {
    public static final String DEFAULT_SELECTED_COLOR = "#ffffff";
    public static final String DEFAULT_UNSELECTED_COLOR = "#33ffffff";

    /* renamed from: d  reason: collision with root package name */
    public int f52891d;

    /* renamed from: e  reason: collision with root package name */
    public int f52892e;
    private ColorAnimationValue value = new ColorAnimationValue();

    public ColorAnimation(@Nullable ValueController.UpdateListener updateListener) {
        super(updateListener);
    }

    private boolean hasChanges(int i11, int i12) {
        if (this.f52891d == i11 && this.f52892e == i12) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void onAnimateUpdated(@NonNull ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_COLOR")).intValue();
        int intValue2 = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_COLOR_REVERSE")).intValue();
        this.value.setColor(intValue);
        this.value.setColorReverse(intValue2);
        ValueController.UpdateListener updateListener = this.f52889b;
        if (updateListener != null) {
            updateListener.onValueUpdated(this.value);
        }
    }

    public PropertyValuesHolder b(boolean z11) {
        int i11;
        String str;
        int i12;
        if (z11) {
            i11 = this.f52892e;
            i12 = this.f52891d;
            str = "ANIMATION_COLOR_REVERSE";
        } else {
            i11 = this.f52891d;
            i12 = this.f52892e;
            str = "ANIMATION_COLOR";
        }
        PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt(str, new int[]{i11, i12});
        ofInt.setEvaluator(new ArgbEvaluator());
        return ofInt;
    }

    @NonNull
    public ColorAnimation with(int i11, int i12) {
        if (this.f52890c != null && hasChanges(i11, i12)) {
            this.f52891d = i11;
            this.f52892e = i12;
            ((ValueAnimator) this.f52890c).setValues(new PropertyValuesHolder[]{b(false), b(true)});
        }
        return this;
    }

    @NonNull
    public ValueAnimator createAnimator() {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setDuration(350);
        valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ColorAnimation.this.onAnimateUpdated(valueAnimator);
            }
        });
        return valueAnimator;
    }

    public ColorAnimation progress(float f11) {
        T t11 = this.f52890c;
        if (t11 != null) {
            long j11 = (long) (f11 * ((float) this.f52888a));
            if (((ValueAnimator) t11).getValues() != null && ((ValueAnimator) this.f52890c).getValues().length > 0) {
                ((ValueAnimator) this.f52890c).setCurrentPlayTime(j11);
            }
        }
        return this;
    }
}
