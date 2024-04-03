package com.talabat.helpers;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class SimpleDividerItemDecoration extends RecyclerView.ItemDecoration {
    private Drawable mDivider;

    public SimpleDividerItemDecoration(Context context, int i11) {
        this.mDivider = context.getResources().getDrawable(i11);
    }

    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = recyclerView.getChildAt(i11);
            int bottom = childAt.getBottom() + ((RecyclerView.LayoutParams) childAt.getLayoutParams()).bottomMargin;
            this.mDivider.setBounds(paddingLeft, bottom, width, this.mDivider.getIntrinsicHeight() + bottom);
            this.mDivider.draw(canvas);
        }
    }
}
