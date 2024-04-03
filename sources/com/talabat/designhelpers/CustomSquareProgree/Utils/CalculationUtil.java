package com.talabat.designhelpers.CustomSquareProgree.Utils;

import android.content.Context;
import android.util.TypedValue;

public class CalculationUtil {
    public static int convertDpToPx(float f11, Context context) {
        return (int) TypedValue.applyDimension(1, f11, context.getResources().getDisplayMetrics());
    }
}
