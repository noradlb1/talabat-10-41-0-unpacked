package com.adyen.checkout.ui.internal.common.util.recyclerview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class DividerItemDecoration extends RecyclerView.ItemDecoration {
    private final Rect mBounds = new Rect();
    private Callback mCallback;
    private Drawable mDivider;

    public interface Callback {
        boolean isDividerPosition(int i11);
    }

    public DividerItemDecoration(@NonNull Context context, @Nullable Callback callback) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new int[]{16843284});
        this.mDivider = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        this.mCallback = callback;
    }

    private boolean isDividerPosition(int i11) {
        Callback callback = this.mCallback;
        return callback == null || callback.isDividerPosition(i11);
    }

    public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
        if (isDividerPosition(recyclerView.getChildAdapterPosition(view))) {
            rect.set(0, 0, 0, this.mDivider.getIntrinsicHeight());
        }
    }

    public void onDraw(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
        int i11;
        int i12;
        if (recyclerView.getLayoutManager() != null) {
            canvas.save();
            if (recyclerView.getClipToPadding()) {
                i11 = recyclerView.getPaddingLeft();
                i12 = recyclerView.getWidth() - recyclerView.getPaddingRight();
                canvas.clipRect(i11, recyclerView.getPaddingTop(), i12, recyclerView.getHeight() - recyclerView.getPaddingBottom());
            } else {
                i12 = recyclerView.getWidth();
                i11 = 0;
            }
            for (int i13 = 0; i13 < recyclerView.getChildCount(); i13++) {
                View childAt = recyclerView.getChildAt(i13);
                if (isDividerPosition(recyclerView.getChildAdapterPosition(childAt))) {
                    recyclerView.getDecoratedBoundsWithMargins(childAt, this.mBounds);
                    int round = this.mBounds.bottom + Math.round(childAt.getTranslationY());
                    this.mDivider.setBounds(i11, round - this.mDivider.getIntrinsicHeight(), i12, round);
                    this.mDivider.draw(canvas);
                }
            }
        }
    }
}
