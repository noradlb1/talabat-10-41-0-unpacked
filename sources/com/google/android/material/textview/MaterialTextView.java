package com.google.android.material.textview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleableRes;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.R;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

public class MaterialTextView extends AppCompatTextView {
    public MaterialTextView(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private void applyLineHeightFromViewAppearance(@NonNull Resources.Theme theme, int i11) {
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(i11, R.styleable.MaterialTextAppearance);
        int readFirstAvailableDimension = readFirstAvailableDimension(getContext(), obtainStyledAttributes, R.styleable.MaterialTextAppearance_android_lineHeight, R.styleable.MaterialTextAppearance_lineHeight);
        obtainStyledAttributes.recycle();
        if (readFirstAvailableDimension >= 0) {
            setLineHeight(readFirstAvailableDimension);
        }
    }

    private static boolean canApplyTextAppearanceLineHeight(Context context) {
        return MaterialAttributes.resolveBoolean(context, R.attr.textAppearanceLineHeightEnabled, true);
    }

    private static int findViewAppearanceResourceId(@NonNull Resources.Theme theme, @Nullable AttributeSet attributeSet, int i11, int i12) {
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, R.styleable.MaterialTextView, i11, i12);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.MaterialTextView_android_textAppearance, -1);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    private static int readFirstAvailableDimension(@NonNull Context context, @NonNull TypedArray typedArray, @StyleableRes @NonNull int... iArr) {
        int i11 = -1;
        for (int i12 = 0; i12 < iArr.length && i11 < 0; i12++) {
            i11 = MaterialResources.getDimensionPixelSize(context, typedArray, iArr[i12], -1);
        }
        return i11;
    }

    private static boolean viewAttrsHasLineHeight(@NonNull Context context, @NonNull Resources.Theme theme, @Nullable AttributeSet attributeSet, int i11, int i12) {
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, R.styleable.MaterialTextView, i11, i12);
        int readFirstAvailableDimension = readFirstAvailableDimension(context, obtainStyledAttributes, R.styleable.MaterialTextView_android_lineHeight, R.styleable.MaterialTextView_lineHeight);
        obtainStyledAttributes.recycle();
        if (readFirstAvailableDimension != -1) {
            return true;
        }
        return false;
    }

    public void setTextAppearance(@NonNull Context context, int i11) {
        super.setTextAppearance(context, i11);
        if (canApplyTextAppearanceLineHeight(context)) {
            applyLineHeightFromViewAppearance(context.getTheme(), i11);
        }
    }

    public MaterialTextView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public MaterialTextView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0);
    }

    public MaterialTextView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11, int i12) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i11, i12), attributeSet, i11);
        int findViewAppearanceResourceId;
        Context context2 = getContext();
        if (canApplyTextAppearanceLineHeight(context2)) {
            Resources.Theme theme = context2.getTheme();
            if (!viewAttrsHasLineHeight(context2, theme, attributeSet, i11, i12) && (findViewAppearanceResourceId = findViewAppearanceResourceId(theme, attributeSet, i11, i12)) != -1) {
                applyLineHeightFromViewAppearance(theme, findViewAppearanceResourceId);
            }
        }
    }
}
