package com.adyen.checkout.ui.internal.common.util;

import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adyen.checkout.ui.R;
import java.util.Arrays;

public final class TextViewUtil {
    private static final int DRAWABLE_BOTTOM = 3;
    private static final int DRAWABLE_LEFT = 0;
    private static final int DRAWABLE_RIGHT = 2;
    private static final int DRAWABLE_TOP = 1;

    private TextViewUtil() {
        throw new IllegalStateException("No instances.");
    }

    public static void addInputFilter(@NonNull TextView textView, @NonNull InputFilter... inputFilterArr) {
        InputFilter[] filters = textView.getFilters();
        if (filters != null) {
            int length = filters.length;
            int length2 = inputFilterArr.length;
            InputFilter[] inputFilterArr2 = (InputFilter[]) Arrays.copyOf(filters, length + length2);
            System.arraycopy(inputFilterArr, 0, inputFilterArr2, length, length2);
            inputFilterArr = inputFilterArr2;
        }
        textView.setFilters(inputFilterArr);
    }

    private static void ensureBoundsSet(@Nullable Drawable drawable) {
        if (drawable != null && drawable.getBounds().isEmpty()) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
    }

    public static void removeInputFilter(@NonNull TextView textView, @NonNull InputFilter... inputFilterArr) {
        InputFilter[] filters = textView.getFilters();
        if (filters != null) {
            for (InputFilter removeInputFilter : inputFilterArr) {
                filters = removeInputFilter(filters, removeInputFilter);
            }
            textView.setFilters(filters);
        }
    }

    public static void setCompoundDrawableLeft(@NonNull TextView textView, @Nullable Drawable drawable) {
        ensureBoundsSet(drawable);
        Drawable[] compoundDrawables = textView.getCompoundDrawables();
        textView.setCompoundDrawables(drawable, compoundDrawables[1], compoundDrawables[2], compoundDrawables[3]);
    }

    public static void setCompoundDrawableRight(@NonNull TextView textView, @Nullable Drawable drawable) {
        ensureBoundsSet(drawable);
        Drawable[] compoundDrawables = textView.getCompoundDrawables();
        textView.setCompoundDrawables(compoundDrawables[0], compoundDrawables[1], drawable, compoundDrawables[3]);
    }

    public static void setDefaultTextColor(@NonNull TextView textView) {
        textView.setTextColor(ThemeUtil.getAttributeColor(textView.getContext(), 16842806));
    }

    public static void setErrorTextColor(@NonNull TextView textView) {
        textView.setTextColor(ThemeUtil.getAttributeColor(textView.getContext(), R.attr.colorError));
    }

    @NonNull
    private static InputFilter[] removeInputFilter(@NonNull InputFilter[] inputFilterArr, @NonNull InputFilter inputFilter) {
        int i11 = 0;
        while (true) {
            if (i11 >= inputFilterArr.length) {
                i11 = -1;
                break;
            } else if (inputFilterArr[i11] == inputFilter) {
                break;
            } else {
                i11++;
            }
        }
        if (i11 == -1) {
            return inputFilterArr;
        }
        int length = inputFilterArr.length - 1;
        InputFilter[] inputFilterArr2 = new InputFilter[length];
        System.arraycopy(inputFilterArr, i11 + 1, inputFilterArr2, i11, length - i11);
        return inputFilterArr2;
    }
}
