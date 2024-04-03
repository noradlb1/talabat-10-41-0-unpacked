package com.materialedittext;

import android.graphics.Color;

public class Colors {
    public static boolean isLight(int i11) {
        if (Math.sqrt((((double) (Color.red(i11) * Color.red(i11))) * 0.241d) + (((double) (Color.green(i11) * Color.green(i11))) * 0.691d) + (((double) (Color.blue(i11) * Color.blue(i11))) * 0.068d)) > 130.0d) {
            return true;
        }
        return false;
    }
}
