package com.google.android.material.tabs;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import com.google.android.material.animation.AnimationUtils;

class ElasticTabIndicatorInterpolator extends TabIndicatorInterpolator {
    private static float accInterp(@FloatRange(from = 0.0d, to = 1.0d) float f11) {
        return (float) (1.0d - Math.cos((((double) f11) * 3.141592653589793d) / 2.0d));
    }

    private static float decInterp(@FloatRange(from = 0.0d, to = 1.0d) float f11) {
        return (float) Math.sin((((double) f11) * 3.141592653589793d) / 2.0d);
    }

    public void setIndicatorBoundsForOffset(TabLayout tabLayout, View view, View view2, float f11, @NonNull Drawable drawable) {
        boolean z11;
        float f12;
        float f13;
        RectF calculateIndicatorWidthForTab = TabIndicatorInterpolator.calculateIndicatorWidthForTab(tabLayout, view);
        RectF calculateIndicatorWidthForTab2 = TabIndicatorInterpolator.calculateIndicatorWidthForTab(tabLayout, view2);
        if (calculateIndicatorWidthForTab.left < calculateIndicatorWidthForTab2.left) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            f13 = accInterp(f11);
            f12 = decInterp(f11);
        } else {
            f13 = decInterp(f11);
            f12 = accInterp(f11);
        }
        drawable.setBounds(AnimationUtils.lerp((int) calculateIndicatorWidthForTab.left, (int) calculateIndicatorWidthForTab2.left, f13), drawable.getBounds().top, AnimationUtils.lerp((int) calculateIndicatorWidthForTab.right, (int) calculateIndicatorWidthForTab2.right, f12), drawable.getBounds().bottom);
    }
}
