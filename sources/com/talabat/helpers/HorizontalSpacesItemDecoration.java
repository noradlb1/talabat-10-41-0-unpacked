package com.talabat.helpers;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class HorizontalSpacesItemDecoration extends RecyclerView.ItemDecoration {
    private int space;

    public HorizontalSpacesItemDecoration(int i11) {
        this.space = i11;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        if (GlobalDataModel.SelectedLanguage.equals(GlobalConstants.ARABIC)) {
            if (recyclerView.getChildLayoutPosition(view) == 0) {
                int i11 = this.space;
                rect.left = i11;
                rect.right = i11;
                return;
            }
            rect.left = this.space;
        } else if (recyclerView.getChildLayoutPosition(view) == 0) {
            int i12 = this.space;
            rect.left = i12;
            rect.right = i12;
        } else {
            rect.right = this.space;
        }
    }
}
