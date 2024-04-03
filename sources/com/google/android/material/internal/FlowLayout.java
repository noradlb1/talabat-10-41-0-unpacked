package com.google.android.material.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class FlowLayout extends ViewGroup {
    private int itemSpacing;
    private int lineSpacing;
    private int rowCount;
    private boolean singleLine;

    public FlowLayout(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private static int getMeasuredDimension(int i11, int i12, int i13) {
        return i12 != Integer.MIN_VALUE ? i12 != 1073741824 ? i13 : i11 : Math.min(i13, i11);
    }

    private void loadFromAttributes(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.FlowLayout, 0, 0);
        this.lineSpacing = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlowLayout_lineSpacing, 0);
        this.itemSpacing = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlowLayout_itemSpacing, 0);
        obtainStyledAttributes.recycle();
    }

    public int getItemSpacing() {
        return this.itemSpacing;
    }

    public int getLineSpacing() {
        return this.lineSpacing;
    }

    public int getRowCount() {
        return this.rowCount;
    }

    public int getRowIndex(@NonNull View view) {
        Object tag = view.getTag(R.id.row_index_key);
        if (!(tag instanceof Integer)) {
            return -1;
        }
        return ((Integer) tag).intValue();
    }

    public boolean isSingleLine() {
        return this.singleLine;
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        boolean z12;
        int i15;
        int i16;
        int i17;
        int i18;
        if (getChildCount() == 0) {
            this.rowCount = 0;
            return;
        }
        this.rowCount = 1;
        if (ViewCompat.getLayoutDirection(this) == 1) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z12) {
            i15 = getPaddingRight();
        } else {
            i15 = getPaddingLeft();
        }
        if (z12) {
            i16 = getPaddingLeft();
        } else {
            i16 = getPaddingRight();
        }
        int paddingTop = getPaddingTop();
        int i19 = (i13 - i11) - i16;
        int i21 = i15;
        int i22 = paddingTop;
        for (int i23 = 0; i23 < getChildCount(); i23++) {
            View childAt = getChildAt(i23);
            if (childAt.getVisibility() == 8) {
                childAt.setTag(R.id.row_index_key, -1);
            } else {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i17 = MarginLayoutParamsCompat.getMarginStart(marginLayoutParams);
                    i18 = MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams);
                } else {
                    i18 = 0;
                    i17 = 0;
                }
                int measuredWidth = i21 + i17 + childAt.getMeasuredWidth();
                if (!this.singleLine && measuredWidth > i19) {
                    i22 = this.lineSpacing + paddingTop;
                    this.rowCount++;
                    i21 = i15;
                }
                childAt.setTag(R.id.row_index_key, Integer.valueOf(this.rowCount - 1));
                int i24 = i21 + i17;
                int measuredWidth2 = childAt.getMeasuredWidth() + i24;
                int measuredHeight = childAt.getMeasuredHeight() + i22;
                if (z12) {
                    childAt.layout(i19 - measuredWidth2, i22, (i19 - i21) - i17, measuredHeight);
                } else {
                    childAt.layout(i24, i22, measuredWidth2, measuredHeight);
                }
                i21 += i17 + i18 + childAt.getMeasuredWidth() + this.itemSpacing;
                paddingTop = measuredHeight;
            }
        }
    }

    public void onMeasure(int i11, int i12) {
        int i13;
        int i14;
        int i15;
        int i16;
        int size = View.MeasureSpec.getSize(i11);
        int mode = View.MeasureSpec.getMode(i11);
        int size2 = View.MeasureSpec.getSize(i12);
        int mode2 = View.MeasureSpec.getMode(i12);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            i13 = size;
        } else {
            i13 = Integer.MAX_VALUE;
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = i13 - getPaddingRight();
        int i17 = paddingTop;
        int i18 = 0;
        for (int i19 = 0; i19 < getChildCount(); i19++) {
            View childAt = getChildAt(i19);
            if (childAt.getVisibility() == 8) {
                int i21 = i11;
                int i22 = i12;
            } else {
                measureChild(childAt, i11, i12);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i15 = marginLayoutParams.leftMargin + 0;
                    i14 = marginLayoutParams.rightMargin + 0;
                } else {
                    i15 = 0;
                    i14 = 0;
                }
                int i23 = paddingLeft;
                if (paddingLeft + i15 + childAt.getMeasuredWidth() <= paddingRight || isSingleLine()) {
                    i16 = i23;
                } else {
                    i16 = getPaddingLeft();
                    i17 = this.lineSpacing + paddingTop;
                }
                int measuredWidth = i16 + i15 + childAt.getMeasuredWidth();
                int measuredHeight = i17 + childAt.getMeasuredHeight();
                if (measuredWidth > i18) {
                    i18 = measuredWidth;
                }
                paddingLeft = i16 + i15 + i14 + childAt.getMeasuredWidth() + this.itemSpacing;
                if (i19 == getChildCount() - 1) {
                    i18 += i14;
                }
                paddingTop = measuredHeight;
            }
        }
        setMeasuredDimension(getMeasuredDimension(size, mode, i18 + getPaddingRight()), getMeasuredDimension(size2, mode2, paddingTop + getPaddingBottom()));
    }

    public void setItemSpacing(int i11) {
        this.itemSpacing = i11;
    }

    public void setLineSpacing(int i11) {
        this.lineSpacing = i11;
    }

    public void setSingleLine(boolean z11) {
        this.singleLine = z11;
    }

    public FlowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.singleLine = false;
        loadFromAttributes(context, attributeSet);
    }

    @TargetApi(21)
    public FlowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        this.singleLine = false;
        loadFromAttributes(context, attributeSet);
    }
}
