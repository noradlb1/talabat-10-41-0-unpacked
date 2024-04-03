package com.talabat.helpers;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.R;

public class VerticalSearchSpaceItemDecoration extends RecyclerView.ItemDecoration {
    private Context mContext;

    public VerticalSearchSpaceItemDecoration(Context context) {
        this.mContext = context;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        if (recyclerView.getChildViewHolder(view).getItemViewType() == 3) {
            rect.top = this.mContext.getResources().getDimensionPixelOffset(R.dimen.margin_32dp);
        } else if (recyclerView.getChildViewHolder(view).getItemViewType() == 2) {
            rect.top = this.mContext.getResources().getDimensionPixelOffset(R.dimen.margin_24dp);
        }
    }
}
