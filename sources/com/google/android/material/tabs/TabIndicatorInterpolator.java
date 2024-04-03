package com.google.android.material.tabs;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.Dimension;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.tabs.TabLayout;

class TabIndicatorInterpolator {
    @Dimension(unit = 0)
    private static final int MIN_INDICATOR_WIDTH = 24;

    public static RectF calculateIndicatorWidthForTab(TabLayout tabLayout, @Nullable View view) {
        if (view == null) {
            return new RectF();
        }
        if (tabLayout.isTabIndicatorFullWidth() || !(view instanceof TabLayout.TabView)) {
            return new RectF((float) view.getLeft(), (float) view.getTop(), (float) view.getRight(), (float) view.getBottom());
        }
        return calculateTabViewContentBounds((TabLayout.TabView) view, 24);
    }

    public static RectF calculateTabViewContentBounds(@NonNull TabLayout.TabView tabView, @Dimension(unit = 0) int i11) {
        int contentWidth = tabView.getContentWidth();
        int contentHeight = tabView.getContentHeight();
        int dpToPx = (int) ViewUtils.dpToPx(tabView.getContext(), i11);
        if (contentWidth < dpToPx) {
            contentWidth = dpToPx;
        }
        int left = (tabView.getLeft() + tabView.getRight()) / 2;
        int top = (tabView.getTop() + tabView.getBottom()) / 2;
        int i12 = contentWidth / 2;
        return new RectF((float) (left - i12), (float) (top - (contentHeight / 2)), (float) (i12 + left), (float) (top + (left / 2)));
    }

    public void setIndicatorBoundsForOffset(TabLayout tabLayout, View view, View view2, @FloatRange(from = 0.0d, to = 1.0d) float f11, @NonNull Drawable drawable) {
        RectF calculateIndicatorWidthForTab = calculateIndicatorWidthForTab(tabLayout, view);
        RectF calculateIndicatorWidthForTab2 = calculateIndicatorWidthForTab(tabLayout, view2);
        drawable.setBounds(AnimationUtils.lerp((int) calculateIndicatorWidthForTab.left, (int) calculateIndicatorWidthForTab2.left, f11), drawable.getBounds().top, AnimationUtils.lerp((int) calculateIndicatorWidthForTab.right, (int) calculateIndicatorWidthForTab2.right, f11), drawable.getBounds().bottom);
    }

    public void setIndicatorBoundsForTab(TabLayout tabLayout, View view, @NonNull Drawable drawable) {
        RectF calculateIndicatorWidthForTab = calculateIndicatorWidthForTab(tabLayout, view);
        drawable.setBounds((int) calculateIndicatorWidthForTab.left, drawable.getBounds().top, (int) calculateIndicatorWidthForTab.right, drawable.getBounds().bottom);
    }
}
