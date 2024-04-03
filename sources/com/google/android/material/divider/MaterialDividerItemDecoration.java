package com.google.android.material.divider;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;

public class MaterialDividerItemDecoration extends RecyclerView.ItemDecoration {
    private static final int DEF_STYLE_RES = R.style.Widget_MaterialComponents_MaterialDivider;
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;
    @ColorInt
    private int color;
    @NonNull
    private Drawable dividerDrawable;
    private int insetEnd;
    private int insetStart;
    private int orientation;
    private final Rect tempRect;
    private int thickness;

    public MaterialDividerItemDecoration(@NonNull Context context, int i11) {
        this(context, (AttributeSet) null, i11);
    }

    private void drawForHorizontalOrientation(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView) {
        int i11;
        int i12;
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            i12 = recyclerView.getPaddingTop();
            i11 = recyclerView.getHeight() - recyclerView.getPaddingBottom();
            canvas.clipRect(recyclerView.getPaddingLeft(), i12, recyclerView.getWidth() - recyclerView.getPaddingRight(), i11);
        } else {
            i11 = recyclerView.getHeight();
            i12 = 0;
        }
        int i13 = i12 + this.insetStart;
        int i14 = i11 - this.insetEnd;
        int childCount = recyclerView.getChildCount();
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt = recyclerView.getChildAt(i15);
            recyclerView.getLayoutManager().getDecoratedBoundsWithMargins(childAt, this.tempRect);
            int round = this.tempRect.right + Math.round(childAt.getTranslationX());
            this.dividerDrawable.setBounds((round - this.dividerDrawable.getIntrinsicWidth()) - this.thickness, i13, round, i14);
            this.dividerDrawable.draw(canvas);
        }
        canvas.restore();
    }

    private void drawForVerticalOrientation(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView) {
        int i11;
        int i12;
        int i13;
        int i14;
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            i12 = recyclerView.getPaddingLeft();
            i11 = recyclerView.getWidth() - recyclerView.getPaddingRight();
            canvas.clipRect(i12, recyclerView.getPaddingTop(), i11, recyclerView.getHeight() - recyclerView.getPaddingBottom());
        } else {
            i11 = recyclerView.getWidth();
            i12 = 0;
        }
        boolean z11 = true;
        if (ViewCompat.getLayoutDirection(recyclerView) != 1) {
            z11 = false;
        }
        if (z11) {
            i13 = this.insetEnd;
        } else {
            i13 = this.insetStart;
        }
        int i15 = i12 + i13;
        if (z11) {
            i14 = this.insetStart;
        } else {
            i14 = this.insetEnd;
        }
        int i16 = i11 - i14;
        int childCount = recyclerView.getChildCount();
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt = recyclerView.getChildAt(i17);
            recyclerView.getDecoratedBoundsWithMargins(childAt, this.tempRect);
            int round = this.tempRect.bottom + Math.round(childAt.getTranslationY());
            this.dividerDrawable.setBounds(i15, (round - this.dividerDrawable.getIntrinsicHeight()) - this.thickness, i16, round);
            this.dividerDrawable.draw(canvas);
        }
        canvas.restore();
    }

    @ColorInt
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

    @Px
    public int getDividerThickness() {
        return this.thickness;
    }

    public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
        rect.set(0, 0, 0, 0);
        if (this.orientation == 1) {
            rect.bottom = this.dividerDrawable.getIntrinsicHeight() + this.thickness;
        } else {
            rect.right = this.dividerDrawable.getIntrinsicWidth() + this.thickness;
        }
    }

    public int getOrientation() {
        return this.orientation;
    }

    public void onDraw(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
        if (recyclerView.getLayoutManager() != null) {
            if (this.orientation == 1) {
                drawForVerticalOrientation(canvas, recyclerView);
            } else {
                drawForHorizontalOrientation(canvas, recyclerView);
            }
        }
    }

    public void setDividerColor(@ColorInt int i11) {
        this.color = i11;
        Drawable wrap = DrawableCompat.wrap(this.dividerDrawable);
        this.dividerDrawable = wrap;
        DrawableCompat.setTint(wrap, i11);
    }

    public void setDividerColorResource(@NonNull Context context, @ColorRes int i11) {
        setDividerColor(ContextCompat.getColor(context, i11));
    }

    public void setDividerInsetEnd(@Px int i11) {
        this.insetEnd = i11;
    }

    public void setDividerInsetEndResource(@NonNull Context context, @DimenRes int i11) {
        setDividerInsetEnd(context.getResources().getDimensionPixelOffset(i11));
    }

    public void setDividerInsetStart(@Px int i11) {
        this.insetStart = i11;
    }

    public void setDividerInsetStartResource(@NonNull Context context, @DimenRes int i11) {
        setDividerInsetStart(context.getResources().getDimensionPixelOffset(i11));
    }

    public void setDividerThickness(@Px int i11) {
        this.thickness = i11;
    }

    public void setDividerThicknessResource(@NonNull Context context, @DimenRes int i11) {
        setDividerThickness(context.getResources().getDimensionPixelSize(i11));
    }

    public void setOrientation(int i11) {
        if (i11 == 0 || i11 == 1) {
            this.orientation = i11;
            return;
        }
        throw new IllegalArgumentException("Invalid orientation: " + i11 + ". It should be either HORIZONTAL or VERTICAL");
    }

    public MaterialDividerItemDecoration(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        this(context, attributeSet, R.attr.materialDividerStyle, i11);
    }

    public MaterialDividerItemDecoration(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11, int i12) {
        this.tempRect = new Rect();
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context, attributeSet, R.styleable.MaterialDivider, i11, DEF_STYLE_RES, new int[0]);
        this.color = MaterialResources.getColorStateList(context, obtainStyledAttributes, R.styleable.MaterialDivider_dividerColor).getDefaultColor();
        this.thickness = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MaterialDivider_dividerThickness, context.getResources().getDimensionPixelSize(R.dimen.material_divider_thickness));
        this.insetStart = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.MaterialDivider_dividerInsetStart, 0);
        this.insetEnd = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.MaterialDivider_dividerInsetEnd, 0);
        obtainStyledAttributes.recycle();
        this.dividerDrawable = new ShapeDrawable();
        setDividerColor(this.color);
        setOrientation(i12);
    }
}
