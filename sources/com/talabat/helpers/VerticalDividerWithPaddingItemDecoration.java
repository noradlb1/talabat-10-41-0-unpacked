package com.talabat.helpers;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class VerticalDividerWithPaddingItemDecoration extends RecyclerView.ItemDecoration {
    private static final int[] ATTRS = {16843284};
    private final Rect mBounds = new Rect();
    private Drawable mDivider;

    public VerticalDividerWithPaddingItemDecoration(Context context, int i11) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(ATTRS);
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        this.mDivider = new InsetDrawable(drawable, i11, 0, i11, 0);
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        if (recyclerView.getChildAdapterPosition(view) == state.getItemCount() - 1) {
            rect.setEmpty();
        } else {
            rect.set(0, 0, 0, this.mDivider.getIntrinsicHeight());
        }
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        int i11;
        int i12;
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            i11 = recyclerView.getPaddingLeft();
            i12 = recyclerView.getWidth() - recyclerView.getPaddingRight();
            canvas.clipRect(i11, recyclerView.getPaddingTop(), i12, recyclerView.getHeight() - recyclerView.getPaddingBottom());
        } else {
            i12 = recyclerView.getWidth();
            i11 = 0;
        }
        int childCount = recyclerView.getChildCount();
        for (int i13 = 0; i13 < childCount - 1; i13++) {
            View childAt = recyclerView.getChildAt(i13);
            recyclerView.getDecoratedBoundsWithMargins(childAt, this.mBounds);
            int round = this.mBounds.bottom + Math.round(childAt.getTranslationY());
            this.mDivider.setBounds(i11, round - this.mDivider.getIntrinsicHeight(), i12, round);
            this.mDivider.draw(canvas);
        }
        canvas.restore();
    }
}
