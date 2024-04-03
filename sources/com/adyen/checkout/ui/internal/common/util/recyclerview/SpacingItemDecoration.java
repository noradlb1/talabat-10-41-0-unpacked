package com.adyen.checkout.ui.internal.common.util.recyclerview;

import android.graphics.Rect;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public final class SpacingItemDecoration extends RecyclerView.ItemDecoration {
    private int mSpacing;

    public SpacingItemDecoration(int i11) {
        this.mSpacing = i11;
    }

    public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        rect.right = this.mSpacing;
    }
}
