package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationBarMenuView;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class BottomNavigationMenuView extends NavigationBarMenuView {
    private final int activeItemMaxWidth;
    private final int activeItemMinWidth;
    private final int inactiveItemMaxWidth;
    private final int inactiveItemMinWidth;
    private boolean itemHorizontalTranslationEnabled;
    private int[] tempChildWidths = new int[5];

    public BottomNavigationMenuView(@NonNull Context context) {
        super(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        setLayoutParams(layoutParams);
        Resources resources = getResources();
        this.inactiveItemMaxWidth = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_max_width);
        this.inactiveItemMinWidth = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_min_width);
        this.activeItemMaxWidth = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_max_width);
        this.activeItemMinWidth = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_min_width);
    }

    @NonNull
    public NavigationBarItemView createNavigationBarItemView(@NonNull Context context) {
        return new BottomNavigationItemView(context);
    }

    public boolean isItemHorizontalTranslationEnabled() {
        return this.itemHorizontalTranslationEnabled;
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        int childCount = getChildCount();
        int i15 = i13 - i11;
        int i16 = i14 - i12;
        int i17 = 0;
        for (int i18 = 0; i18 < childCount; i18++) {
            View childAt = getChildAt(i18);
            if (childAt.getVisibility() != 8) {
                if (ViewCompat.getLayoutDirection(this) == 1) {
                    int i19 = i15 - i17;
                    childAt.layout(i19 - childAt.getMeasuredWidth(), 0, i19, i16);
                } else {
                    childAt.layout(i17, 0, childAt.getMeasuredWidth() + i17, i16);
                }
                i17 += childAt.getMeasuredWidth();
            }
        }
    }

    public void onMeasure(int i11, int i12) {
        int i13;
        int i14;
        int i15;
        MenuBuilder menu = getMenu();
        int size = View.MeasureSpec.getSize(i11);
        int size2 = menu.getVisibleItems().size();
        int childCount = getChildCount();
        int size3 = View.MeasureSpec.getSize(i12);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size3, 1073741824);
        int i16 = 1;
        if (!isShifting(getLabelVisibilityMode(), size2) || !isItemHorizontalTranslationEnabled()) {
            if (size2 != 0) {
                i16 = size2;
            }
            int min = Math.min(size / i16, this.activeItemMaxWidth);
            int i17 = size - (size2 * min);
            for (int i18 = 0; i18 < childCount; i18++) {
                if (getChildAt(i18).getVisibility() != 8) {
                    int[] iArr = this.tempChildWidths;
                    iArr[i18] = min;
                    if (i17 > 0) {
                        iArr[i18] = min + 1;
                        i17--;
                    }
                } else {
                    this.tempChildWidths[i18] = 0;
                }
            }
        } else {
            View childAt = getChildAt(getSelectedItemPosition());
            int i19 = this.activeItemMinWidth;
            if (childAt.getVisibility() != 8) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(this.activeItemMaxWidth, Integer.MIN_VALUE), makeMeasureSpec);
                i19 = Math.max(i19, childAt.getMeasuredWidth());
            }
            if (childAt.getVisibility() != 8) {
                i13 = 1;
            } else {
                i13 = 0;
            }
            int i21 = size2 - i13;
            int min2 = Math.min(size - (this.inactiveItemMinWidth * i21), Math.min(i19, this.activeItemMaxWidth));
            int i22 = size - min2;
            if (i21 == 0) {
                i14 = 1;
            } else {
                i14 = i21;
            }
            int min3 = Math.min(i22 / i14, this.inactiveItemMaxWidth);
            int i23 = i22 - (i21 * min3);
            for (int i24 = 0; i24 < childCount; i24++) {
                if (getChildAt(i24).getVisibility() != 8) {
                    int[] iArr2 = this.tempChildWidths;
                    if (i24 == getSelectedItemPosition()) {
                        i15 = min2;
                    } else {
                        i15 = min3;
                    }
                    iArr2[i24] = i15;
                    if (i23 > 0) {
                        int[] iArr3 = this.tempChildWidths;
                        iArr3[i24] = iArr3[i24] + 1;
                        i23--;
                    }
                } else {
                    this.tempChildWidths[i24] = 0;
                }
            }
        }
        int i25 = 0;
        for (int i26 = 0; i26 < childCount; i26++) {
            View childAt2 = getChildAt(i26);
            if (childAt2.getVisibility() != 8) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec(this.tempChildWidths[i26], 1073741824), makeMeasureSpec);
                childAt2.getLayoutParams().width = childAt2.getMeasuredWidth();
                i25 += childAt2.getMeasuredWidth();
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(i25, View.MeasureSpec.makeMeasureSpec(i25, 1073741824), 0), View.resolveSizeAndState(size3, i12, 0));
    }

    public void setItemHorizontalTranslationEnabled(boolean z11) {
        this.itemHorizontalTranslationEnabled = z11;
    }
}
