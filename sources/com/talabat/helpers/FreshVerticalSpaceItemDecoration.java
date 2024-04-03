package com.talabat.helpers;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.R;

public class FreshVerticalSpaceItemDecoration extends RecyclerView.ItemDecoration {
    private static final int INVALID_POSITION = -1;
    private boolean mIsCollection;
    private final Resources mResources;

    public FreshVerticalSpaceItemDecoration(Resources resources, boolean z11) {
        this.mResources = resources;
        this.mIsCollection = z11;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int childAdapterPosition;
        if (recyclerView.getAdapter() != null && (childAdapterPosition = recyclerView.getChildAdapterPosition(view)) != -1) {
            int itemViewType = recyclerView.getAdapter().getItemViewType(childAdapterPosition);
            if (recyclerView.getChildAdapterPosition(view) != 0 || !this.mIsCollection) {
                if (recyclerView.getChildAdapterPosition(view) == 0) {
                    rect.top = this.mResources.getDimensionPixelOffset(R.dimen.ds_m);
                    return;
                }
                int itemViewType2 = recyclerView.getAdapter().getItemViewType(childAdapterPosition - 1);
                if (itemViewType != itemViewType2) {
                    if (itemViewType2 == 1) {
                        if (itemViewType == 2) {
                            rect.top = this.mResources.getDimensionPixelOffset(R.dimen.f54606l);
                        } else if (itemViewType == 13) {
                            rect.top = this.mResources.getDimensionPixelOffset(R.dimen.f54608s);
                        }
                    } else if (itemViewType == 16) {
                        rect.top = this.mResources.getDimensionPixelOffset(R.dimen.ds_zero);
                    } else {
                        rect.top = this.mResources.getDimensionPixelOffset(R.dimen.xxl);
                    }
                } else if (itemViewType == 2) {
                    rect.top = this.mResources.getDimensionPixelOffset(R.dimen.f54609xl);
                } else {
                    rect.top = this.mResources.getDimensionPixelOffset(R.dimen.ds_l);
                }
            } else if (itemViewType == 2) {
                rect.top = this.mResources.getDimensionPixelOffset(R.dimen.f54609xl);
            } else if (itemViewType == 13) {
                rect.top = this.mResources.getDimensionPixelOffset(R.dimen.f54606l);
            }
        }
    }
}
