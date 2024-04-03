package com.google.android.material.resources;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleableRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.TintTypedArray;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class MaterialResources {
    private static final float FONT_SCALE_1_3 = 1.3f;
    private static final float FONT_SCALE_2_0 = 2.0f;

    private MaterialResources() {
    }

    @Nullable
    public static ColorStateList getColorStateList(@NonNull Context context, @NonNull TypedArray typedArray, @StyleableRes int i11) {
        int resourceId;
        ColorStateList colorStateList;
        if (!typedArray.hasValue(i11) || (resourceId = typedArray.getResourceId(i11, 0)) == 0 || (colorStateList = AppCompatResources.getColorStateList(context, resourceId)) == null) {
            return typedArray.getColorStateList(i11);
        }
        return colorStateList;
    }

    public static int getDimensionPixelSize(@NonNull Context context, @NonNull TypedArray typedArray, @StyleableRes int i11, int i12) {
        TypedValue typedValue = new TypedValue();
        if (!typedArray.getValue(i11, typedValue) || typedValue.type != 2) {
            return typedArray.getDimensionPixelSize(i11, i12);
        }
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{typedValue.data});
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, i12);
        obtainStyledAttributes.recycle();
        return dimensionPixelSize;
    }

    @Nullable
    public static Drawable getDrawable(@NonNull Context context, @NonNull TypedArray typedArray, @StyleableRes int i11) {
        int resourceId;
        Drawable drawable;
        if (!typedArray.hasValue(i11) || (resourceId = typedArray.getResourceId(i11, 0)) == 0 || (drawable = AppCompatResources.getDrawable(context, resourceId)) == null) {
            return typedArray.getDrawable(i11);
        }
        return drawable;
    }

    @StyleableRes
    public static int getIndexWithValue(@NonNull TypedArray typedArray, @StyleableRes int i11, @StyleableRes int i12) {
        return typedArray.hasValue(i11) ? i11 : i12;
    }

    @Nullable
    public static TextAppearance getTextAppearance(@NonNull Context context, @NonNull TypedArray typedArray, @StyleableRes int i11) {
        int resourceId;
        if (!typedArray.hasValue(i11) || (resourceId = typedArray.getResourceId(i11, 0)) == 0) {
            return null;
        }
        return new TextAppearance(context, resourceId);
    }

    public static boolean isFontScaleAtLeast1_3(@NonNull Context context) {
        return context.getResources().getConfiguration().fontScale >= FONT_SCALE_1_3;
    }

    public static boolean isFontScaleAtLeast2_0(@NonNull Context context) {
        return context.getResources().getConfiguration().fontScale >= 2.0f;
    }

    @Nullable
    public static ColorStateList getColorStateList(@NonNull Context context, @NonNull TintTypedArray tintTypedArray, @StyleableRes int i11) {
        int resourceId;
        ColorStateList colorStateList;
        if (!tintTypedArray.hasValue(i11) || (resourceId = tintTypedArray.getResourceId(i11, 0)) == 0 || (colorStateList = AppCompatResources.getColorStateList(context, resourceId)) == null) {
            return tintTypedArray.getColorStateList(i11);
        }
        return colorStateList;
    }
}
