package com.talabat.collectiondetails.utils;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.designsystem.marshmallow.R;

public class FreshVerticalSpaceItemDecoration extends RecyclerView.ItemDecoration {
    private boolean mIsCollection;
    private final Resources mResources;

    public FreshVerticalSpaceItemDecoration(Resources resources, boolean z11) {
        this.mResources = resources;
        this.mIsCollection = z11;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        if (recyclerView.getAdapter() != null) {
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            int itemViewType = recyclerView.getAdapter().getItemViewType(childAdapterPosition);
            if (recyclerView.getChildAdapterPosition(view) != 0 || !this.mIsCollection) {
                if (recyclerView.getChildAdapterPosition(view) == 0) {
                    rect.top = this.mResources.getDimensionPixelOffset(R.dimen.ds_m);
                    return;
                }
                int itemViewType2 = recyclerView.getAdapter().getItemViewType(childAdapterPosition - 1);
                if (itemViewType != itemViewType2) {
                    if (itemViewType2 != 1) {
                        rect.top = this.mResources.getDimensionPixelOffset(R.dimen.ds_xxl);
                    } else if (itemViewType == 2) {
                        rect.top = this.mResources.getDimensionPixelOffset(R.dimen.ds_l);
                    } else if (itemViewType == 13) {
                        rect.top = this.mResources.getDimensionPixelOffset(R.dimen.ds_s);
                    }
                } else if (itemViewType == 2) {
                    rect.top = this.mResources.getDimensionPixelOffset(R.dimen.ds_xl);
                } else {
                    rect.top = this.mResources.getDimensionPixelOffset(R.dimen.ds_l);
                }
            } else if (itemViewType == 2) {
                rect.top = this.mResources.getDimensionPixelOffset(R.dimen.ds_xl);
            } else if (itemViewType == 13) {
                rect.top = this.mResources.getDimensionPixelOffset(R.dimen.ds_l);
            }
        }
    }
}
