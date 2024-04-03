package com.rd.utils;

import android.content.res.Resources;
import android.util.TypedValue;

public class DensityUtils {
    public static int dpToPx(int i11) {
        return (int) TypedValue.applyDimension(1, (float) i11, Resources.getSystem().getDisplayMetrics());
    }

    public static int pxToDp(float f11) {
        return (int) TypedValue.applyDimension(0, f11, Resources.getSystem().getDisplayMetrics());
    }
}
