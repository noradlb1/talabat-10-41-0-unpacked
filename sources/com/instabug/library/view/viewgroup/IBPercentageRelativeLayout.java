package com.instabug.library.view.viewgroup;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.instabug.library.R;
import com.instabug.library.util.ScreenUtility;

public class IBPercentageRelativeLayout extends RelativeLayout implements b {
    private final float maxHeightRatio;
    private final a presenter;

    public IBPercentageRelativeLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public float getMaxHeightRatio() {
        return this.maxHeightRatio;
    }

    public float getScreenHeight() {
        if (!ScreenUtility.hasNavBar(getContext())) {
            return (float) Resources.getSystem().getDisplayMetrics().heightPixels;
        }
        return (float) (Resources.getSystem().getDisplayMetrics().heightPixels - ScreenUtility.getNavigationBarHeight(getResources()));
    }

    public void onMeasure(int i11, int i12) {
        int[] a11 = this.presenter.a(i11, i12);
        super.onMeasure(a11[0], a11[1]);
    }

    public IBPercentageRelativeLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public IBPercentageRelativeLayout(Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.IBPercentageRelativeLayout);
            this.maxHeightRatio = obtainStyledAttributes.getFloat(R.styleable.IBPercentageRelativeLayout_maxHeightRatio, 100.0f);
            obtainStyledAttributes.recycle();
        } else {
            this.maxHeightRatio = 100.0f;
        }
        this.presenter = new c(this);
    }
}
