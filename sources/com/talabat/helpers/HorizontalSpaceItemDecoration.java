package com.talabat.helpers;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class HorizontalSpaceItemDecoration extends RecyclerView.ItemDecoration {
    private final int horizontalSpaceHeight;

    public HorizontalSpaceItemDecoration(int i11) {
        this.horizontalSpaceHeight = i11;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        if (recyclerView.getChildAdapterPosition(view) == 0) {
            if (GlobalDataModel.SelectedLanguage.equals("en-US")) {
                rect.left = this.horizontalSpaceHeight;
            } else {
                rect.right = this.horizontalSpaceHeight;
            }
        }
        if (recyclerView.getChildAdapterPosition(view) == recyclerView.getAdapter().getItemCount()) {
            return;
        }
        if (GlobalDataModel.SelectedLanguage.equals("en-US")) {
            rect.right = this.horizontalSpaceHeight;
        } else {
            rect.left = this.horizontalSpaceHeight;
        }
    }
}
