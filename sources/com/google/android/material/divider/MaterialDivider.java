package com.google.android.material.divider;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.shape.MaterialShapeDrawable;

public class MaterialDivider extends View {
    private static final int DEF_STYLE_RES = R.style.Widget_MaterialComponents_MaterialDivider;
    @ColorInt
    private int color;
    @NonNull
    private final MaterialShapeDrawable dividerDrawable;
    private int insetEnd;
    private int insetStart;
    private int thickness;

    public MaterialDivider(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    public int getDividerColor() {
        return this.color;
    }

    @Px
    public int getDividerInsetEnd() {
        return this.insetEnd;
    }

    @Px
    public int getDividerInsetStart() {
        return this.insetStart;
    }

    public int getDividerThickness() {
        return this.thickness;
    }

    public void onDraw(@NonNull Canvas canvas) {
        int i11;
        int i12;
        int i13;
        super.onDraw(canvas);
        boolean z11 = true;
        if (ViewCompat.getLayoutDirection(this) != 1) {
            z11 = false;
        }
        if (z11) {
            i11 = this.insetEnd;
        } else {
            i11 = this.insetStart;
        }
        if (z11) {
            i13 = getWidth();
            i12 = this.insetStart;
        } else {
            i13 = getWidth();
            i12 = this.insetEnd;
        }
        this.dividerDrawable.setBounds(i11, 0, i13 - i12, getBottom() - getTop());
        this.dividerDrawable.draw(canvas);
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        int mode = View.MeasureSpec.getMode(i12);
        int measuredHeight = getMeasuredHeight();
        if (mode == Integer.MIN_VALUE || mode == 0) {
            int i13 = this.thickness;
            if (i13 > 0 && measuredHeight != i13) {
                measuredHeight = i13;
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
    }

    public void setDividerColor(@ColorInt int i11) {
        if (this.color != i11) {
            this.color = i11;
            this.dividerDrawable.setFillColor(ColorStateList.valueOf(i11));
            invalidate();
        }
    }

    public void setDividerColorResource(@ColorRes int i11) {
        setDividerColor(ContextCompat.getColor(getContext(), i11));
    }

    public void setDividerInsetEnd(@Px int i11) {
        this.insetEnd = i11;
    }

    public void setDividerInsetEndResource(@DimenRes int i11) {
        setDividerInsetEnd(getContext().getResources().getDimensionPixelOffset(i11));
    }

    public void setDividerInsetStart(@Px int i11) {
        this.insetStart = i11;
    }

    public void setDividerInsetStartResource(@DimenRes int i11) {
        setDividerInsetStart(getContext().getResources().getDimensionPixelOffset(i11));
    }

    public void setDividerThickness(@Px int i11) {
        if (this.thickness != i11) {
            this.thickness = i11;
            requestLayout();
        }
    }

    public void setDividerThicknessResource(@DimenRes int i11) {
        setDividerThickness(getContext().getResources().getDimensionPixelSize(i11));
    }

    public MaterialDivider(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialDividerStyle);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MaterialDivider(@androidx.annotation.NonNull android.content.Context r8, @androidx.annotation.Nullable android.util.AttributeSet r9, int r10) {
        /*
            r7 = this;
            int r4 = DEF_STYLE_RES
            android.content.Context r8 = com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(r8, r9, r10, r4)
            r7.<init>(r8, r9, r10)
            android.content.Context r8 = r7.getContext()
            com.google.android.material.shape.MaterialShapeDrawable r0 = new com.google.android.material.shape.MaterialShapeDrawable
            r0.<init>()
            r7.dividerDrawable = r0
            int[] r2 = com.google.android.material.R.styleable.MaterialDivider
            r6 = 0
            int[] r5 = new int[r6]
            r0 = r8
            r1 = r9
            r3 = r10
            android.content.res.TypedArray r9 = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(r0, r1, r2, r3, r4, r5)
            int r10 = com.google.android.material.R.styleable.MaterialDivider_dividerThickness
            android.content.res.Resources r0 = r7.getResources()
            int r1 = com.google.android.material.R.dimen.material_divider_thickness
            int r0 = r0.getDimensionPixelSize(r1)
            int r10 = r9.getDimensionPixelSize(r10, r0)
            r7.thickness = r10
            int r10 = com.google.android.material.R.styleable.MaterialDivider_dividerInsetStart
            int r10 = r9.getDimensionPixelOffset(r10, r6)
            r7.insetStart = r10
            int r10 = com.google.android.material.R.styleable.MaterialDivider_dividerInsetEnd
            int r10 = r9.getDimensionPixelOffset(r10, r6)
            r7.insetEnd = r10
            int r10 = com.google.android.material.R.styleable.MaterialDivider_dividerColor
            android.content.res.ColorStateList r8 = com.google.android.material.resources.MaterialResources.getColorStateList((android.content.Context) r8, (android.content.res.TypedArray) r9, (int) r10)
            int r8 = r8.getDefaultColor()
            r7.setDividerColor(r8)
            r9.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.divider.MaterialDivider.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
