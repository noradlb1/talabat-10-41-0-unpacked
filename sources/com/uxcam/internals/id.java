package com.uxcam.internals;

import android.util.DisplayMetrics;

public class id {
    public static boolean a() {
        DisplayMetrics displayMetrics = ia.c().getResources().getDisplayMetrics();
        if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
            return true;
        }
        return false;
    }
}
