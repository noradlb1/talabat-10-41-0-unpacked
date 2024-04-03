package com.rd.animation.type;

import android.animation.IntEvaluator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.annotation.NonNull;
import com.rd.animation.controller.ValueController;
import com.rd.animation.data.type.SwapAnimationValue;

public class SwapAnimation extends BaseAnimation<ValueAnimator> {
    private static final String ANIMATION_COORDINATE = "ANIMATION_COORDINATE";
    private static final String ANIMATION_COORDINATE_REVERSE = "ANIMATION_COORDINATE_REVERSE";
    private static final int COORDINATE_NONE = -1;
    private int coordinateEnd = -1;
    private int coordinateStart = -1;
    private SwapAnimationValue value = new SwapAnimationValue();

    public SwapAnimation(@NonNull ValueController.UpdateListener updateListener) {
        super(updateListener);
    }

    private PropertyValuesHolder createColorPropertyHolder(String str, int i11, int i12) {
        PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt(str, new int[]{i11, i12});
        ofInt.setEvaluator(new IntEvaluator());
        return ofInt;
    }

    private boolean hasChanges(int i11, int i12) {
        if (this.coordinateStart == i11 && this.coordinateEnd == i12) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void onAnimateUpdated(@NonNull ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue(ANIMATION_COORDINATE)).intValue();
        int intValue2 = ((Integer) valueAnimator.getAnimatedValue(ANIMATION_COORDINATE_REVERSE)).intValue();
        this.value.setCoordinate(intValue);
        this.value.setCoordinateReverse(intValue2);
        ValueController.UpdateListener updateListener = this.f52889b;
        if (updateListener != null) {
            updateListener.onValueUpdated(this.value);
        }
    }

    @NonNull
    public SwapAnimation with(int i11, int i12) {
        if (this.f52890c != null && hasChanges(i11, i12)) {
            this.coordinateStart = i11;
            this.coordinateEnd = i12;
            ((ValueAnimator) this.f52890c).setValues(new PropertyValuesHolder[]{createColorPropertyHolder(ANIMATION_COORDINATE, i11, i12), createColorPropertyHolder(ANIMATION_COORDINATE_REVERSE, i12, i11)});
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
                SwapAnimation.this.onAnimateUpdated(valueAnimator);
            }
        });
        return valueAnimator;
    }

    public SwapAnimation progress(float f11) {
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
