package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.core.graphics.ColorUtils;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public class ThemeUtils {
    private static final String TAG = "ThemeUtils";
    private static final int[] TEMP_ARRAY = new int[1];
    private static final ThreadLocal<TypedValue> TL_TYPED_VALUE = new ThreadLocal<>();

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f893a = {-16842910};

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f894b = {16842908};

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f895c = {16843518};

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f896d = {16842919};

    /* renamed from: e  reason: collision with root package name */
    public static final int[] f897e = {16842912};

    /* renamed from: f  reason: collision with root package name */
    public static final int[] f898f = {16842913};

    /* renamed from: g  reason: collision with root package name */
    public static final int[] f899g = {-16842919, -16842908};

    /* renamed from: h  reason: collision with root package name */
    public static final int[] f900h = new int[0];

    private ThemeUtils() {
    }

    public static int a(@NonNull Context context, int i11, float f11) {
        int themeAttrColor = getThemeAttrColor(context, i11);
        return ColorUtils.setAlphaComponent(themeAttrColor, Math.round(((float) Color.alpha(themeAttrColor)) * f11));
    }

    public static void checkAppCompatTheme(@NonNull View view, @NonNull Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(R.styleable.AppCompatTheme);
        try {
            if (!obtainStyledAttributes.hasValue(R.styleable.AppCompatTheme_windowActionBar)) {
                Log.e(TAG, "View " + view.getClass() + " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @NonNull
    public static ColorStateList createDisabledStateList(int i11, int i12) {
        return new ColorStateList(new int[][]{f893a, f900h}, new int[]{i12, i11});
    }

    public static int getDisabledThemeAttrColor(@NonNull Context context, int i11) {
        ColorStateList themeAttrColorStateList = getThemeAttrColorStateList(context, i11);
        if (themeAttrColorStateList != null && themeAttrColorStateList.isStateful()) {
            return themeAttrColorStateList.getColorForState(f893a, themeAttrColorStateList.getDefaultColor());
        }
        TypedValue typedValue = getTypedValue();
        context.getTheme().resolveAttribute(16842803, typedValue, true);
        return a(context, i11, typedValue.getFloat());
    }

    public static int getThemeAttrColor(@NonNull Context context, int i11) {
        int[] iArr = TEMP_ARRAY;
        iArr[0] = i11;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, (AttributeSet) null, iArr);
        try {
            return obtainStyledAttributes.getColor(0, 0);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @Nullable
    public static ColorStateList getThemeAttrColorStateList(@NonNull Context context, int i11) {
        int[] iArr = TEMP_ARRAY;
        iArr[0] = i11;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, (AttributeSet) null, iArr);
        try {
            return obtainStyledAttributes.getColorStateList(0);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private static TypedValue getTypedValue() {
        ThreadLocal<TypedValue> threadLocal = TL_TYPED_VALUE;
        TypedValue typedValue = threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }
}
