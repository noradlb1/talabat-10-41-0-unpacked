package com.rd.animation.type;

import android.animation.IntEvaluator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.annotation.NonNull;
import com.rd.animation.controller.ValueController;
import com.rd.animation.data.type.SlideAnimationValue;

public class SlideAnimation extends BaseAnimation<ValueAnimator> {
    private static final String ANIMATION_COORDINATE = "ANIMATION_COORDINATE";
    private static final int COORDINATE_NONE = -1;
    private int coordinateEnd = -1;
    private int coordinateStart = -1;
    private SlideAnimationValue value = new SlideAnimationValue();

    public SlideAnimation(@NonNull ValueController.UpdateListener updateListener) {
        super(updateListener);
    }

    private PropertyValuesHolder createSlidePropertyHolder() {
        PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt(ANIMATION_COORDINATE, new int[]{this.coordinateStart, this.coordinateEnd});
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
        this.value.setCoordinate(((Integer) valueAnimator.getAnimatedValue(ANIMATION_COORDINATE)).intValue());
        ValueController.UpdateListener updateListener = this.f52889b;
        if (updateListener != null) {
            updateListener.onValueUpdated(this.value);
        }
    }

    @NonNull
    public SlideAnimation with(int i11, int i12) {
        if (this.f52890c != null && hasChanges(i11, i12)) {
            this.coordinateStart = i11;
            this.coordinateEnd = i12;
            ((ValueAnimator) this.f52890c).setValues(new PropertyValuesHolder[]{createSlidePropertyHolder()});
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
                SlideAnimation.this.onAnimateUpdated(valueAnimator);
            }
        });
        return valueAnimator;
    }

    public SlideAnimation progress(float f11) {
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
