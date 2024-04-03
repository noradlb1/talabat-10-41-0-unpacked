package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.StyleableRes;
import androidx.appcompat.widget.TintTypedArray;
import com.google.android.material.R;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class ThemeEnforcement {
    private static final int[] APPCOMPAT_CHECK_ATTRS = {R.attr.colorPrimary};
    private static final String APPCOMPAT_THEME_NAME = "Theme.AppCompat";
    private static final int[] MATERIAL_CHECK_ATTRS = {R.attr.colorPrimaryVariant};
    private static final String MATERIAL_THEME_NAME = "Theme.MaterialComponents";

    private ThemeEnforcement() {
    }

    public static void checkAppCompatTheme(@NonNull Context context) {
        checkTheme(context, APPCOMPAT_CHECK_ATTRS, APPCOMPAT_THEME_NAME);
    }

    private static void checkCompatibleTheme(@NonNull Context context, AttributeSet attributeSet, @AttrRes int i11, @StyleRes int i12) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ThemeEnforcement, i11, i12);
        boolean z11 = obtainStyledAttributes.getBoolean(R.styleable.ThemeEnforcement_enforceMaterialTheme, false);
        obtainStyledAttributes.recycle();
        if (z11) {
            TypedValue typedValue = new TypedValue();
            if (!context.getTheme().resolveAttribute(R.attr.isMaterialTheme, typedValue, true) || (typedValue.type == 18 && typedValue.data == 0)) {
                checkMaterialTheme(context);
            }
        }
        checkAppCompatTheme(context);
    }

    public static void checkMaterialTheme(@NonNull Context context) {
        checkTheme(context, MATERIAL_CHECK_ATTRS, MATERIAL_THEME_NAME);
    }

    private static void checkTextAppearance(@NonNull Context context, AttributeSet attributeSet, @StyleableRes @NonNull int[] iArr, @AttrRes int i11, @StyleRes int i12, @StyleableRes @Nullable int... iArr2) {
        boolean z11;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ThemeEnforcement, i11, i12);
        boolean z12 = false;
        if (!obtainStyledAttributes.getBoolean(R.styleable.ThemeEnforcement_enforceTextAppearance, false)) {
            obtainStyledAttributes.recycle();
            return;
        }
        if (iArr2 == null || iArr2.length == 0) {
            if (obtainStyledAttributes.getResourceId(R.styleable.ThemeEnforcement_android_textAppearance, -1) != -1) {
                z12 = true;
            }
            z11 = z12;
        } else {
            z11 = isCustomTextAppearanceValid(context, attributeSet, iArr, i11, i12, iArr2);
        }
        obtainStyledAttributes.recycle();
        if (!z11) {
            throw new IllegalArgumentException("This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant).");
        }
    }

    private static void checkTheme(@NonNull Context context, @NonNull int[] iArr, String str) {
        if (!isTheme(context, iArr)) {
            throw new IllegalArgumentException("The style on this component requires your app theme to be " + str + " (or a descendant).");
        }
    }

    public static boolean isAppCompatTheme(@NonNull Context context) {
        return isTheme(context, APPCOMPAT_CHECK_ATTRS);
    }

    private static boolean isCustomTextAppearanceValid(@NonNull Context context, AttributeSet attributeSet, @StyleableRes @NonNull int[] iArr, @AttrRes int i11, @StyleRes int i12, @StyleableRes @NonNull int... iArr2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i11, i12);
        for (int resourceId : iArr2) {
            if (obtainStyledAttributes.getResourceId(resourceId, -1) == -1) {
                obtainStyledAttributes.recycle();
                return false;
            }
        }
        obtainStyledAttributes.recycle();
        return true;
    }

    public static boolean isMaterialTheme(@NonNull Context context) {
        return isTheme(context, MATERIAL_CHECK_ATTRS);
    }

    private static boolean isTheme(@NonNull Context context, @NonNull int[] iArr) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(iArr);
        for (int i11 = 0; i11 < iArr.length; i11++) {
            if (!obtainStyledAttributes.hasValue(i11)) {
                obtainStyledAttributes.recycle();
                return false;
            }
        }
        obtainStyledAttributes.recycle();
        return true;
    }

    @NonNull
    public static TypedArray obtainStyledAttributes(@NonNull Context context, AttributeSet attributeSet, @StyleableRes @NonNull int[] iArr, @AttrRes int i11, @StyleRes int i12, @StyleableRes int... iArr2) {
        checkCompatibleTheme(context, attributeSet, i11, i12);
        checkTextAppearance(context, attributeSet, iArr, i11, i12, iArr2);
        return context.obtainStyledAttributes(attributeSet, iArr, i11, i12);
    }

    public static TintTypedArray obtainTintedStyledAttributes(@NonNull Context context, AttributeSet attributeSet, @StyleableRes @NonNull int[] iArr, @AttrRes int i11, @StyleRes int i12, @StyleableRes int... iArr2) {
        checkCompatibleTheme(context, attributeSet, i11, i12);
        checkTextAppearance(context, attributeSet, iArr, i11, i12, iArr2);
        return TintTypedArray.obtainStyledAttributes(context, attributeSet, iArr, i11, i12);
    }
}
