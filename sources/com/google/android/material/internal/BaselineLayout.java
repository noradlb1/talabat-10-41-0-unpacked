package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class BaselineLayout extends ViewGroup {
    private int baseline = -1;

    public BaselineLayout(Context context) {
        super(context, (AttributeSet) null, 0);
    }

    public int getBaseline() {
        return this.baseline;
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        int i15;
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingRight = ((i13 - i11) - getPaddingRight()) - paddingLeft;
        int paddingTop = getPaddingTop();
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = getChildAt(i16);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i17 = ((paddingRight - measuredWidth) / 2) + paddingLeft;
                if (this.baseline == -1 || childAt.getBaseline() == -1) {
                    i15 = paddingTop;
                } else {
                    i15 = (this.baseline + paddingTop) - childAt.getBaseline();
                }
                childAt.layout(i17, i15, measuredWidth + i17, measuredHeight + i15);
            }
        }
    }

    public void onMeasure(int i11, int i12) {
        int childCount = getChildCount();
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = -1;
        int i17 = -1;
        for (int i18 = 0; i18 < childCount; i18++) {
            View childAt = getChildAt(i18);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i11, i12);
                int baseline2 = childAt.getBaseline();
                if (baseline2 != -1) {
                    i16 = Math.max(i16, baseline2);
                    i17 = Math.max(i17, childAt.getMeasuredHeight() - baseline2);
                }
                i14 = Math.max(i14, childAt.getMeasuredWidth());
                i13 = Math.max(i13, childAt.getMeasuredHeight());
                i15 = View.combineMeasuredStates(i15, childAt.getMeasuredState());
            }
        }
        if (i16 != -1) {
            i13 = Math.max(i13, Math.max(i17, getPaddingBottom()) + i16);
            this.baseline = i16;
        }
        setMeasuredDimension(View.resolveSizeAndState(Math.max(i14, getSuggestedMinimumWidth()), i11, i15), View.resolveSizeAndState(Math.max(i13, getSuggestedMinimumHeight()), i12, i15 << 16));
    }

    public BaselineLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public BaselineLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
