package com.rd.animation.type;

import android.animation.IntEvaluator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.annotation.NonNull;
import com.rd.animation.controller.ValueController;
import com.rd.animation.data.type.FillAnimationValue;

public class FillAnimation extends ColorAnimation {
    private static final String ANIMATION_RADIUS = "ANIMATION_RADIUS";
    private static final String ANIMATION_RADIUS_REVERSE = "ANIMATION_RADIUS_REVERSE";
    private static final String ANIMATION_STROKE = "ANIMATION_STROKE";
    private static final String ANIMATION_STROKE_REVERSE = "ANIMATION_STROKE_REVERSE";
    public static final int DEFAULT_STROKE_DP = 1;
    private int radius;
    private int stroke;
    private FillAnimationValue value = new FillAnimationValue();

    public FillAnimation(@NonNull ValueController.UpdateListener updateListener) {
        super(updateListener);
    }

    @NonNull
    private PropertyValuesHolder createRadiusPropertyHolder(boolean z11) {
        int i11;
        String str;
        int i12;
        if (z11) {
            i11 = this.radius;
            i12 = i11 / 2;
            str = ANIMATION_RADIUS_REVERSE;
        } else {
            i12 = this.radius;
            i11 = i12 / 2;
            str = ANIMATION_RADIUS;
        }
        PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt(str, new int[]{i12, i11});
        ofInt.setEvaluator(new IntEvaluator());
        return ofInt;
    }

    @NonNull
    private PropertyValuesHolder createStrokePropertyHolder(boolean z11) {
        int i11;
        String str;
        int i12;
        if (z11) {
            i11 = this.radius;
            str = ANIMATION_STROKE_REVERSE;
            i12 = 0;
        } else {
            int i13 = this.radius;
            str = ANIMATION_STROKE;
            i12 = i13;
            i11 = 0;
        }
        PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt(str, new int[]{i11, i12});
        ofInt.setEvaluator(new IntEvaluator());
        return ofInt;
    }

    private boolean hasChanges(int i11, int i12, int i13, int i14) {
        if (this.f52891d == i11 && this.f52892e == i12 && this.radius == i13 && this.stroke == i14) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void onAnimateUpdated(@NonNull ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_COLOR")).intValue();
        int intValue2 = ((Integer) valueAnimator.getAnimatedValue("ANIMATION_COLOR_REVERSE")).intValue();
        int intValue3 = ((Integer) valueAnimator.getAnimatedValue(ANIMATION_RADIUS)).intValue();
        int intValue4 = ((Integer) valueAnimator.getAnimatedValue(ANIMATION_RADIUS_REVERSE)).intValue();
        int intValue5 = ((Integer) valueAnimator.getAnimatedValue(ANIMATION_STROKE)).intValue();
        int intValue6 = ((Integer) valueAnimator.getAnimatedValue(ANIMATION_STROKE_REVERSE)).intValue();
        this.value.setColor(intValue);
        this.value.setColorReverse(intValue2);
        this.value.setRadius(intValue3);
        this.value.setRadiusReverse(intValue4);
        this.value.setStroke(intValue5);
        this.value.setStrokeReverse(intValue6);
        ValueController.UpdateListener updateListener = this.f52889b;
        if (updateListener != null) {
            updateListener.onValueUpdated(this.value);
        }
    }

    @NonNull
    public FillAnimation with(int i11, int i12, int i13, int i14) {
        if (this.f52890c != null && hasChanges(i11, i12, i13, i14)) {
            this.f52891d = i11;
            this.f52892e = i12;
            this.radius = i13;
            this.stroke = i14;
            ((ValueAnimator) this.f52890c).setValues(new PropertyValuesHolder[]{b(false), b(true), createRadiusPropertyHolder(false), createRadiusPropertyHolder(true), createStrokePropertyHolder(false), createStrokePropertyHolder(true)});
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
                FillAnimation.this.onAnimateUpdated(valueAnimator);
            }
        });
        return valueAnimator;
    }
}
