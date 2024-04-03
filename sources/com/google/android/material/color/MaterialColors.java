package com.google.android.material.color;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.R;
import com.google.android.material.resources.MaterialAttributes;

public class MaterialColors {
    public static final float ALPHA_DISABLED = 0.38f;
    public static final float ALPHA_DISABLED_LOW = 0.12f;
    public static final float ALPHA_FULL = 1.0f;
    public static final float ALPHA_LOW = 0.32f;
    public static final float ALPHA_MEDIUM = 0.54f;
    private static final int TONE_ACCENT_CONTAINER_DARK = 20;
    private static final int TONE_ACCENT_CONTAINER_LIGHT = 90;
    private static final int TONE_ACCENT_DARK = 70;
    private static final int TONE_ACCENT_LIGHT = 40;
    private static final int TONE_ON_ACCENT_CONTAINER_DARK = 80;
    private static final int TONE_ON_ACCENT_CONTAINER_LIGHT = 10;
    private static final int TONE_ON_ACCENT_DARK = 10;
    private static final int TONE_ON_ACCENT_LIGHT = 100;

    private MaterialColors() {
    }

    @ColorInt
    public static int compositeARGBWithAlpha(@ColorInt int i11, @IntRange(from = 0, to = 255) int i12) {
        return ColorUtils.setAlphaComponent(i11, (Color.alpha(i11) * i12) / 255);
    }

    @ColorInt
    public static int getColor(@NonNull View view, @AttrRes int i11) {
        return MaterialAttributes.resolveOrThrow(view, i11);
    }

    @ColorInt
    private static int getColorRole(@ColorInt int i11, @IntRange(from = 0, to = 100) int i12) {
        Hct fromInt = Hct.fromInt(i11);
        fromInt.setTone((float) i12);
        return fromInt.toInt();
    }

    @NonNull
    public static ColorRoles getColorRoles(@NonNull Context context, @ColorInt int i11) {
        return getColorRoles(i11, MaterialAttributes.resolveBoolean(context, R.attr.isLightTheme, true));
    }

    @ColorInt
    public static int harmonize(@ColorInt int i11, @ColorInt int i12) {
        return Blend.harmonize(i11, i12);
    }

    @ColorInt
    public static int harmonizeWithPrimary(@NonNull Context context, @ColorInt int i11) {
        return harmonize(i11, getColor(context, R.attr.colorPrimary, MaterialColors.class.getCanonicalName()));
    }

    public static boolean isColorLight(@ColorInt int i11) {
        return i11 != 0 && ColorUtils.calculateLuminance(i11) > 0.5d;
    }

    @ColorInt
    public static int layer(@NonNull View view, @AttrRes int i11, @AttrRes int i12) {
        return layer(view, i11, i12, 1.0f);
    }

    @ColorInt
    public static int getColor(Context context, @AttrRes int i11, String str) {
        return MaterialAttributes.resolveOrThrow(context, i11, str);
    }

    @ColorInt
    public static int layer(@NonNull View view, @AttrRes int i11, @AttrRes int i12, @FloatRange(from = 0.0d, to = 1.0d) float f11) {
        return layer(getColor(view, i11), getColor(view, i12), f11);
    }

    @ColorInt
    public static int getColor(@NonNull View view, @AttrRes int i11, @ColorInt int i12) {
        return getColor(view.getContext(), i11, i12);
    }

    @ColorInt
    public static int getColor(@NonNull Context context, @AttrRes int i11, @ColorInt int i12) {
        TypedValue resolve = MaterialAttributes.resolve(context, i11);
        return resolve != null ? resolve.data : i12;
    }

    @NonNull
    public static ColorRoles getColorRoles(@ColorInt int i11, boolean z11) {
        if (z11) {
            return new ColorRoles(getColorRole(i11, 40), getColorRole(i11, 100), getColorRole(i11, 90), getColorRole(i11, 10));
        }
        return new ColorRoles(getColorRole(i11, 70), getColorRole(i11, 10), getColorRole(i11, 20), getColorRole(i11, 80));
    }

    @ColorInt
    public static int layer(@ColorInt int i11, @ColorInt int i12, @FloatRange(from = 0.0d, to = 1.0d) float f11) {
        return layer(i11, ColorUtils.setAlphaComponent(i12, Math.round(((float) Color.alpha(i12)) * f11)));
    }

    @ColorInt
    public static int layer(@ColorInt int i11, @ColorInt int i12) {
        return ColorUtils.compositeColors(i12, i11);
    }
}
