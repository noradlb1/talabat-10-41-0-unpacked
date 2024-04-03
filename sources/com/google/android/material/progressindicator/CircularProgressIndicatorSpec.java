package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.StyleRes;
import com.google.android.material.R;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;

public final class CircularProgressIndicatorSpec extends BaseProgressIndicatorSpec {
    public int indicatorDirection;
    @Px
    public int indicatorInset;
    @Px
    public int indicatorSize;

    public CircularProgressIndicatorSpec(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.circularProgressIndicatorStyle);
    }

    public void validateSpec() {
    }

    public CircularProgressIndicatorSpec(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i11) {
        this(context, attributeSet, i11, CircularProgressIndicator.DEF_STYLE_RES);
    }

    public CircularProgressIndicatorSpec(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i11, @StyleRes int i12) {
        super(context, attributeSet, i11, i12);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.mtrl_progress_circular_size_medium);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R.dimen.mtrl_progress_circular_inset_medium);
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context, attributeSet, R.styleable.CircularProgressIndicator, i11, i12, new int[0]);
        this.indicatorSize = Math.max(MaterialResources.getDimensionPixelSize(context, obtainStyledAttributes, R.styleable.CircularProgressIndicator_indicatorSize, dimensionPixelSize), this.trackThickness * 2);
        this.indicatorInset = MaterialResources.getDimensionPixelSize(context, obtainStyledAttributes, R.styleable.CircularProgressIndicator_indicatorInset, dimensionPixelSize2);
        this.indicatorDirection = obtainStyledAttributes.getInt(R.styleable.CircularProgressIndicator_indicatorDirectionCircular, 0);
        obtainStyledAttributes.recycle();
        validateSpec();
    }
}
