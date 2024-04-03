package com.rd.animation.type;

import android.animation.IntEvaluator;
import android.animation.PropertyValuesHolder;
import androidx.annotation.NonNull;
import com.rd.animation.controller.ValueController;

public class ScaleDownAnimation extends ScaleAnimation {
    public ScaleDownAnimation(@NonNull ValueController.UpdateListener updateListener) {
        super(updateListener);
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
        PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt(str, new int[]{i12, i11});
        ofInt.setEvaluator(new IntEvaluator());
        return ofInt;
    }
}
