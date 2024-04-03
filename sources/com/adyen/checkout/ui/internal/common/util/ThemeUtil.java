package com.adyen.checkout.ui.internal.common.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.DrawableCompat;
import com.adyen.checkout.ui.R;

public final class ThemeUtil {
    private ThemeUtil() {
        throw new IllegalStateException("No instances.");
    }

    public static void applyPrimaryThemeColor(@NonNull Context context, @NonNull Drawable... drawableArr) {
        int primaryThemeColor = getPrimaryThemeColor(context);
        for (Drawable drawable : drawableArr) {
            if (drawable != null) {
                setTint(drawable, primaryThemeColor);
            }
        }
    }

    @ColorInt
    public static int getAttributeColor(@NonNull Context context, @AttrRes int i11) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new TypedValue().data, new int[]{i11});
        int color = obtainStyledAttributes.getColor(0, 0);
        obtainStyledAttributes.recycle();
        return color;
    }

    @ColorInt
    public static int getPrimaryThemeColor(@NonNull Context context) {
        return getAttributeColor(context, R.attr.colorPrimary);
    }

    @NonNull
    public static Context getThemedActionBarContext(@NonNull Activity activity) {
        Context context = null;
        if (activity instanceof AppCompatActivity) {
            ActionBar supportActionBar = ((AppCompatActivity) activity).getSupportActionBar();
            if (supportActionBar != null) {
                context = supportActionBar.getThemedContext();
            }
            if (context != null) {
                return context;
            }
            return activity;
        }
        android.app.ActionBar actionBar = activity.getActionBar();
        if (actionBar != null) {
            context = actionBar.getThemedContext();
        }
        if (context != null) {
            return context;
        }
        return activity;
    }

    private static void setTint(@NonNull Drawable drawable, @ColorInt int i11) {
        DrawableCompat.setTint(drawable, i11);
    }

    public static void setTintFromAttributeColor(@NonNull Context context, @NonNull Drawable drawable, @AttrRes int i11) {
        setTint(drawable, getAttributeColor(context, i11));
    }
}
