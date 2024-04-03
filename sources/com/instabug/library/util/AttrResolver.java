package com.instabug.library.util;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.TypedValue;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import com.instabug.library.R;

public class AttrResolver {
    @ColorInt
    public static int getBackgroundColor(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.instabug_background_color, typedValue, true);
        return typedValue.data;
    }

    @ColorInt
    public static int getColor(@NonNull Context context, int i11) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i11});
        int color = obtainStyledAttributes.getColor(0, 0);
        obtainStyledAttributes.recycle();
        return color;
    }

    public static int getDialogItemTextColor(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.instabug_dialog_item_text_color, typedValue, true);
        return typedValue.data;
    }

    @ColorInt
    public static int getDividerColor(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.instabug_divider_color, typedValue, true);
        return typedValue.data;
    }

    @DrawableRes
    public static int getDrawableResourceId(Context context, int i11) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i11, typedValue, true);
        return typedValue.resourceId;
    }

    @ColorInt
    public static int getTintingColor(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.instabug_theme_tinting_color, typedValue, true);
        return typedValue.data;
    }

    @ColorInt
    public static int resolveAttributeColor(@NonNull Context context, @AttrRes int i11) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i11, typedValue, true);
        return typedValue.data;
    }
}
