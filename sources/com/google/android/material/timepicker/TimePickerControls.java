package com.google.android.material.timepicker;

import androidx.annotation.IntRange;
import androidx.annotation.StringRes;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

interface TimePickerControls {

    @Retention(RetentionPolicy.SOURCE)
    public @interface ActiveSelection {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ClockPeriod {
    }

    void setActiveSelection(int i11);

    void setHandRotation(float f11);

    void setValues(String[] strArr, @StringRes int i11);

    void updateTime(int i11, int i12, @IntRange(from = 0) int i13);
}
