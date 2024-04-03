package com.materialedittext;

import android.content.Context;
import android.util.TypedValue;

class Density {
    public static int dp2px(Context context, float f11) {
        return Math.round(TypedValue.applyDimension(1, f11, context.getResources().getDisplayMetrics()));
    }
}
