package androidx.core.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.annotation.AnyRes;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleableRes;
import org.xmlpull.v1.XmlPullParser;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class TypedArrayUtils {
    private static final String NAMESPACE = "http://schemas.android.com/apk/res/android";

    private TypedArrayUtils() {
    }

    public static int getAttr(@NonNull Context context, int i11, int i12) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i11, typedValue, true);
        if (typedValue.resourceId != 0) {
            return i11;
        }
        return i12;
    }

    public static boolean getBoolean(@NonNull TypedArray typedArray, @StyleableRes int i11, @StyleableRes int i12, boolean z11) {
        return typedArray.getBoolean(i11, typedArray.getBoolean(i12, z11));
    }

    @Nullable
    public static Drawable getDrawable(@NonNull TypedArray typedArray, @StyleableRes int i11, @StyleableRes int i12) {
        Drawable drawable = typedArray.getDrawable(i11);
        if (drawable == null) {
            return typedArray.getDrawable(i12);
        }
        return drawable;
    }

    public static int getInt(@NonNull TypedArray typedArray, @StyleableRes int i11, @StyleableRes int i12, int i13) {
        return typedArray.getInt(i11, typedArray.getInt(i12, i13));
    }

    public static boolean getNamedBoolean(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, @StyleableRes int i11, boolean z11) {
        if (!hasAttribute(xmlPullParser, str)) {
            return z11;
        }
        return typedArray.getBoolean(i11, z11);
    }

    @ColorInt
    public static int getNamedColor(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, @StyleableRes int i11, @ColorInt int i12) {
        if (!hasAttribute(xmlPullParser, str)) {
            return i12;
        }
        return typedArray.getColor(i11, i12);
    }

    @Nullable
    public static ColorStateList getNamedColorStateList(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @Nullable Resources.Theme theme, @NonNull String str, @StyleableRes int i11) {
        if (!hasAttribute(xmlPullParser, str)) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(i11, typedValue);
        int i12 = typedValue.type;
        if (i12 == 2) {
            throw new UnsupportedOperationException("Failed to resolve attribute at index " + i11 + ": " + typedValue);
        } else if (i12 < 28 || i12 > 31) {
            return ColorStateListInflaterCompat.inflate(typedArray.getResources(), typedArray.getResourceId(i11, 0), theme);
        } else {
            return getNamedColorStateListFromInt(typedValue);
        }
    }

    @NonNull
    private static ColorStateList getNamedColorStateListFromInt(@NonNull TypedValue typedValue) {
        return ColorStateList.valueOf(typedValue.data);
    }

    public static ComplexColorCompat getNamedComplexColor(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @Nullable Resources.Theme theme, @NonNull String str, @StyleableRes int i11, @ColorInt int i12) {
        if (hasAttribute(xmlPullParser, str)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i11, typedValue);
            int i13 = typedValue.type;
            if (i13 >= 28 && i13 <= 31) {
                return ComplexColorCompat.a(typedValue.data);
            }
            ComplexColorCompat inflate = ComplexColorCompat.inflate(typedArray.getResources(), typedArray.getResourceId(i11, 0), theme);
            if (inflate != null) {
                return inflate;
            }
        }
        return ComplexColorCompat.a(i12);
    }

    public static float getNamedFloat(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, @StyleableRes int i11, float f11) {
        if (!hasAttribute(xmlPullParser, str)) {
            return f11;
        }
        return typedArray.getFloat(i11, f11);
    }

    public static int getNamedInt(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, @StyleableRes int i11, int i12) {
        if (!hasAttribute(xmlPullParser, str)) {
            return i12;
        }
        return typedArray.getInt(i11, i12);
    }

    @AnyRes
    public static int getNamedResourceId(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, @StyleableRes int i11, @AnyRes int i12) {
        if (!hasAttribute(xmlPullParser, str)) {
            return i12;
        }
        return typedArray.getResourceId(i11, i12);
    }

    @Nullable
    public static String getNamedString(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, @StyleableRes int i11) {
        if (!hasAttribute(xmlPullParser, str)) {
            return null;
        }
        return typedArray.getString(i11);
    }

    @AnyRes
    public static int getResourceId(@NonNull TypedArray typedArray, @StyleableRes int i11, @StyleableRes int i12, @AnyRes int i13) {
        return typedArray.getResourceId(i11, typedArray.getResourceId(i12, i13));
    }

    @Nullable
    public static String getString(@NonNull TypedArray typedArray, @StyleableRes int i11, @StyleableRes int i12) {
        String string = typedArray.getString(i11);
        if (string == null) {
            return typedArray.getString(i12);
        }
        return string;
    }

    @Nullable
    public static CharSequence getText(@NonNull TypedArray typedArray, @StyleableRes int i11, @StyleableRes int i12) {
        CharSequence text = typedArray.getText(i11);
        if (text == null) {
            return typedArray.getText(i12);
        }
        return text;
    }

    @Nullable
    public static CharSequence[] getTextArray(@NonNull TypedArray typedArray, @StyleableRes int i11, @StyleableRes int i12) {
        CharSequence[] textArray = typedArray.getTextArray(i11);
        if (textArray == null) {
            return typedArray.getTextArray(i12);
        }
        return textArray;
    }

    public static boolean hasAttribute(@NonNull XmlPullParser xmlPullParser, @NonNull String str) {
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null) {
            return true;
        }
        return false;
    }

    @NonNull
    public static TypedArray obtainAttributes(@NonNull Resources resources, @Nullable Resources.Theme theme, @NonNull AttributeSet attributeSet, @NonNull int[] iArr) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, iArr);
        }
        return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    @Nullable
    public static TypedValue peekNamedValue(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, int i11) {
        if (!hasAttribute(xmlPullParser, str)) {
            return null;
        }
        return typedArray.peekValue(i11);
    }
}
