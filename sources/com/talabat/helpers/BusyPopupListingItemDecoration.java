package com.talabat.helpers;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.R;

public class BusyPopupListingItemDecoration extends RecyclerView.ItemDecoration {
    private boolean mIsCollection;
    private final Resources mResources;

    public BusyPopupListingItemDecoration(Resources resources) {
        this.mResources = resources;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        if (recyclerView.getAdapter() != null) {
            if (recyclerView.getChildAdapterPosition(view) == 0) {
                rect.top = this.mResources.getDimensionPixelOffset(R.dimen._0margin);
            } else {
                rect.top = this.mResources.getDimensionPixelOffset(R.dimen.f54608s);
            }
        }
    }
}
