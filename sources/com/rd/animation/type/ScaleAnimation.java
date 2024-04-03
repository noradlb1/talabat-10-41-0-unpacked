package com.rd.animation.type;

import android.animation.IntEvaluator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.annotation.NonNull;
import com.rd.animation.controller.ValueController;
import com.rd.animation.data.type.ScaleAnimationValue;

public class ScaleAnimation extends ColorAnimation {
    public static final float DEFAULT_SCALE_FACTOR = 0.7f;
    public static final float MAX_SCALE_FACTOR = 1.0f;
    public static final float MIN_SCALE_FACTOR = 0.3f;

    /* renamed from: f  reason: collision with root package name */
    public int f52898f;

    /* renamed from: g  reason: collision with root package name */
    public float f52899g;
    private ScaleAnimationValue value = new ScaleAnimationValue();

    public ScaleAnimation(@NonNull ValueController.UpdateListener updateListener) {
        super(updateListener);
    }

    private boolean hasChanges(int i11, int i12, int i13, float f11) {
        if (this.f52891d == i11 && this.f52892e == i12 && this.f52898f == i13 && this.f52899g == f11) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void onAnimateUpdated(@NonNull ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_COLOR")).intValue();
        int intValue2 = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_COLOR_REVERSE")).intValue();
        int intValue3 = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_SCALE")).intValue();
        int intValue4 = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_SCALE_REVERSE")).intValue();
        this.value.setColor(intValue);
        this.value.setColorReverse(intValue2);
        this.value.setRadius(intValue3);
        this.value.setRadiusReverse(intValue4);
        ValueController.UpdateListener updateListener = this.f52889b;
        if (updateListener != null) {
            updateListener.onValueUpdated(this.value);
        }
    }

    @NonNull
    public PropertyValuesHolder d(boolean z11) {
        int i11;
        String str;
        int i12;
        if (z11) {
            i11 = this.f52898f;
            i12 = (int) (((float) i11) * this.f52899g);
            str = "ANIMATION_SCALE_REVERSE";
        } else {
            i12 = this.f52898f;
            i11 = (int) (((float) i12) * this.f52899g);
            str = "ANIMATION_SCALE";
        }
        PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt(str, new int[]{i11, i12});
        ofInt.setEvaluator(new IntEvaluator());
        return ofInt;
    }

    @NonNull
    public ScaleAnimation with(int i11, int i12, int i13, float f11) {
        if (this.f52890c != null && hasChanges(i11, i12, i13, f11)) {
            this.f52891d = i11;
            this.f52892e = i12;
            this.f52898f = i13;
            this.f52899g = f11;
            ((ValueAnimator) this.f52890c).setValues(new PropertyValuesHolder[]{b(false), b(true), d(false), d(true)});
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
                ScaleAnimation.this.onAnimateUpdated(valueAnimator);
            }
        });
        return valueAnimator;
    }
}
