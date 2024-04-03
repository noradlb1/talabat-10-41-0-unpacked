package com.google.android.material.navigationrail;

import android.content.Context;
import android.view.View;
import androidx.annotation.DimenRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.google.android.material.R;
import com.google.android.material.navigation.NavigationBarItemView;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
final class NavigationRailItemView extends NavigationBarItemView {
    public NavigationRailItemView(@NonNull Context context) {
        super(context);
    }

    @DimenRes
    public int getItemDefaultMarginResId() {
        return R.dimen.mtrl_navigation_rail_icon_margin;
    }

    @LayoutRes
    public int getItemLayoutResId() {
        return R.layout.mtrl_navigation_rail_item;
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        if (View.MeasureSpec.getMode(i12) == 0) {
            setMeasuredDimension(getMeasuredWidthAndState(), View.resolveSizeAndState(Math.max(getMeasuredHeight(), View.MeasureSpec.getSize(i12)), i12, 0));
        }
    }
}
