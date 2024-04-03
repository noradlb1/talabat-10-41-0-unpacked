package com.instabug.featuresrequest.utils;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.view.View;
import androidx.annotation.Nullable;

public abstract class b {
    public static void a(@Nullable View view, int i11) {
        if (view != null) {
            Drawable background = view.getBackground();
            if (background instanceof ShapeDrawable) {
                ((ShapeDrawable) background).getPaint().setColor(i11);
            } else if (background instanceof GradientDrawable) {
                ((GradientDrawable) background).setColor(i11);
            } else if (background instanceof ColorDrawable) {
                ((ColorDrawable) background).setColor(i11);
            }
        }
    }
}
