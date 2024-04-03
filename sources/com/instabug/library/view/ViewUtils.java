package com.instabug.library.view;

import android.content.Context;
import android.util.TypedValue;
import androidx.annotation.Nullable;

public class ViewUtils {
    public static int convertDpToPx(@Nullable Context context, float f11) {
        if (context == null) {
            return (int) f11;
        }
        return (int) TypedValue.applyDimension(1, f11, context.getResources().getDisplayMetrics());
    }
}
