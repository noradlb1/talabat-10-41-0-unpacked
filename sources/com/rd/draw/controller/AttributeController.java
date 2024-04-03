package com.rd.draw.controller;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.rd.animation.type.AnimationType;
import com.rd.animation.type.ColorAnimation;
import com.rd.draw.data.Indicator;
import com.rd.draw.data.RtlMode;
import com.rd.pageindicatorview.R;

public class AttributeController {
    private static final int DEFAULT_IDLE_DURATION = 3000;
    private Indicator indicator;

    public AttributeController(@NonNull Indicator indicator2) {
        this.indicator = indicator2;
    }

    private AnimationType getAnimationType(int i11) {
        switch (i11) {
            case 0:
                return AnimationType.NONE;
            case 1:
                return AnimationType.COLOR;
            case 2:
                return AnimationType.SCALE;
            case 3:
                return AnimationType.WORM;
            case 4:
                return AnimationType.SLIDE;
            case 5:
                return AnimationType.FILL;
            case 6:
                return AnimationType.THIN_WORM;
            case 7:
                return AnimationType.DROP;
            case 8:
                return AnimationType.SWAP;
            case 9:
                return AnimationType.SCALE_DOWN;
            default:
                return AnimationType.NONE;
        }
    }

    private RtlMode getRtlMode(int i11) {
        if (i11 == 0) {
            return RtlMode.On;
        }
        if (i11 == 1) {
            return RtlMode.Off;
        }
        if (i11 != 2) {
            return RtlMode.Auto;
        }
        return RtlMode.Auto;
    }

    private void initAnimationAttribute(@NonNull TypedArray typedArray) {
        boolean z11 = typedArray.getBoolean(R.styleable.PageIndicatorView_piv_interactiveAnimation, false);
        long j11 = (long) typedArray.getInt(R.styleable.PageIndicatorView_piv_animationDuration, 350);
        if (j11 < 0) {
            j11 = 0;
        }
        AnimationType animationType = getAnimationType(typedArray.getInt(R.styleable.PageIndicatorView_piv_animationType, AnimationType.NONE.ordinal()));
        RtlMode rtlMode = getRtlMode(typedArray.getInt(R.styleable.PageIndicatorView_piv_rtl_mode, RtlMode.Off.ordinal()));
        boolean z12 = typedArray.getBoolean(R.styleable.PageIndicatorView_piv_fadeOnIdle, false);
        long j12 = (long) typedArray.getInt(R.styleable.PageIndicatorView_piv_idleDuration, 3000);
        this.indicator.setAnimationDuration(j11);
        this.indicator.setInteractiveAnimation(z11);
        this.indicator.setAnimationType(animationType);
        this.indicator.setRtlMode(rtlMode);
        this.indicator.setFadeOnIdle(z12);
        this.indicator.setIdleDuration(j12);
    }

    private void initColorAttribute(@NonNull TypedArray typedArray) {
        int color = typedArray.getColor(R.styleable.PageIndicatorView_piv_unselectedColor, Color.parseColor(ColorAnimation.DEFAULT_UNSELECTED_COLOR));
        int color2 = typedArray.getColor(R.styleable.PageIndicatorView_piv_selectedColor, Color.parseColor(ColorAnimation.DEFAULT_SELECTED_COLOR));
        this.indicator.setUnselectedColor(color);
        this.indicator.setSelectedColor(color2);
    }

    private void initCountAttribute(@NonNull TypedArray typedArray) {
        int resourceId = typedArray.getResourceId(R.styleable.PageIndicatorView_piv_viewPager, -1);
        boolean z11 = typedArray.getBoolean(R.styleable.PageIndicatorView_piv_autoVisibility, true);
        int i11 = 0;
        boolean z12 = typedArray.getBoolean(R.styleable.PageIndicatorView_piv_dynamicCount, false);
        int i12 = typedArray.getInt(R.styleable.PageIndicatorView_piv_count, -1);
        if (i12 == -1) {
            i12 = 3;
        }
        int i13 = typedArray.getInt(R.styleable.PageIndicatorView_piv_select, 0);
        if (i13 >= 0 && (i12 <= 0 || i13 <= i12 - 1)) {
            i11 = i13;
        }
        this.indicator.setViewPagerId(resourceId);
        this.indicator.setAutoVisibility(z11);
        this.indicator.setDynamicCount(z12);
        this.indicator.setCount(i12);
        this.indicator.setSelectedPosition(i11);
        this.indicator.setSelectingPosition(i11);
        this.indicator.setLastSelectedPosition(i11);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0049, code lost:
        if (r4 > 1.0f) goto L_0x0043;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void initSizeAttribute(@androidx.annotation.NonNull android.content.res.TypedArray r8) {
        /*
            r7 = this;
            int r0 = com.rd.pageindicatorview.R.styleable.PageIndicatorView_piv_orientation
            com.rd.draw.data.Orientation r1 = com.rd.draw.data.Orientation.HORIZONTAL
            int r2 = r1.ordinal()
            int r0 = r8.getInt(r0, r2)
            if (r0 != 0) goto L_0x000f
            goto L_0x0011
        L_0x000f:
            com.rd.draw.data.Orientation r1 = com.rd.draw.data.Orientation.VERTICAL
        L_0x0011:
            int r0 = com.rd.pageindicatorview.R.styleable.PageIndicatorView_piv_radius
            r2 = 6
            int r2 = com.rd.utils.DensityUtils.dpToPx(r2)
            float r2 = (float) r2
            float r0 = r8.getDimension(r0, r2)
            int r0 = (int) r0
            r2 = 0
            if (r0 >= 0) goto L_0x0022
            r0 = r2
        L_0x0022:
            int r3 = com.rd.pageindicatorview.R.styleable.PageIndicatorView_piv_padding
            r4 = 8
            int r4 = com.rd.utils.DensityUtils.dpToPx(r4)
            float r4 = (float) r4
            float r3 = r8.getDimension(r3, r4)
            int r3 = (int) r3
            if (r3 >= 0) goto L_0x0033
            r3 = r2
        L_0x0033:
            int r4 = com.rd.pageindicatorview.R.styleable.PageIndicatorView_piv_scaleFactor
            r5 = 1060320051(0x3f333333, float:0.7)
            float r4 = r8.getFloat(r4, r5)
            r5 = 1050253722(0x3e99999a, float:0.3)
            int r6 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r6 >= 0) goto L_0x0045
        L_0x0043:
            r4 = r5
            goto L_0x004c
        L_0x0045:
            r5 = 1065353216(0x3f800000, float:1.0)
            int r6 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r6 <= 0) goto L_0x004c
            goto L_0x0043
        L_0x004c:
            int r5 = com.rd.pageindicatorview.R.styleable.PageIndicatorView_piv_strokeWidth
            r6 = 1
            int r6 = com.rd.utils.DensityUtils.dpToPx(r6)
            float r6 = (float) r6
            float r8 = r8.getDimension(r5, r6)
            int r8 = (int) r8
            if (r8 <= r0) goto L_0x005c
            r8 = r0
        L_0x005c:
            com.rd.draw.data.Indicator r5 = r7.indicator
            com.rd.animation.type.AnimationType r5 = r5.getAnimationType()
            com.rd.animation.type.AnimationType r6 = com.rd.animation.type.AnimationType.FILL
            if (r5 == r6) goto L_0x0067
            goto L_0x0068
        L_0x0067:
            r2 = r8
        L_0x0068:
            com.rd.draw.data.Indicator r8 = r7.indicator
            r8.setRadius(r0)
            com.rd.draw.data.Indicator r8 = r7.indicator
            r8.setOrientation(r1)
            com.rd.draw.data.Indicator r8 = r7.indicator
            r8.setPadding(r3)
            com.rd.draw.data.Indicator r8 = r7.indicator
            r8.setScaleFactor(r4)
            com.rd.draw.data.Indicator r8 = r7.indicator
            r8.setStroke(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rd.draw.controller.AttributeController.initSizeAttribute(android.content.res.TypedArray):void");
    }

    public void init(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PageIndicatorView, 0, 0);
        initCountAttribute(obtainStyledAttributes);
        initColorAttribute(obtainStyledAttributes);
        initAnimationAttribute(obtainStyledAttributes);
        initSizeAttribute(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }
}
