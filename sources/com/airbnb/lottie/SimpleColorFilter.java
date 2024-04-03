package com.airbnb.lottie;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import androidx.annotation.ColorInt;

public class SimpleColorFilter extends PorterDuffColorFilter {
    public SimpleColorFilter(@ColorInt int i11) {
        super(i11, PorterDuff.Mode.SRC_ATOP);
    }
}
