package com.adyen.checkout.ui.internal.common.util.recyclerview;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class HeaderItemDecoration extends RecyclerView.ItemDecoration {
    private Callback mCallback;
    private View mHeader;

    public interface Callback {
        boolean isHeaderPosition(int i11);
    }

    public HeaderItemDecoration(@NonNull View view, @Nullable Callback callback) {
        this.mHeader = view;
        if (view.getMeasuredHeight() == 0) {
            this.mHeader.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        }
        this.mCallback = callback;
    }

    public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        Callback callback = this.mCallback;
        if (callback == null || callback.isHeaderPosition(childAdapterPosition)) {
            rect.set(view.getPaddingLeft(), this.mHeader.getMeasuredHeight(), view.getPaddingRight(), view.getPaddingBottom());
        }
    }

    public void onDrawOver(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
        for (int i11 = 0; i11 < recyclerView.getChildCount(); i11++) {
            View childAt = recyclerView.getChildAt(i11);
            int childAdapterPosition = recyclerView.getChildAdapterPosition(childAt);
            Callback callback = this.mCallback;
            if (callback == null || callback.isHeaderPosition(childAdapterPosition)) {
                int measuredHeight = this.mHeader.getMeasuredHeight();
                this.mHeader.layout(recyclerView.getLeft(), 0, recyclerView.getRight(), measuredHeight);
                canvas.save();
                canvas.translate(0.0f, (((float) childAt.getTop()) + childAt.getTranslationY()) - ((float) measuredHeight));
                this.mHeader.draw(canvas);
                canvas.restore();
            }
        }
    }
}
