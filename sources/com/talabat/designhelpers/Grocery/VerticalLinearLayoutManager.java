package com.talabat.designhelpers.Grocery;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;

public class VerticalLinearLayoutManager extends LinearLayoutManager {
    public VerticalLinearLayoutManager(Context context, int i11, boolean z11) {
        super(context, i11, z11);
    }

    public boolean canScrollHorizontally() {
        return false;
    }

    public boolean canScrollVertically() {
        return true;
    }
}
