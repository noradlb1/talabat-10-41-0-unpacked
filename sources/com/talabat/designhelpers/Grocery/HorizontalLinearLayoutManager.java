package com.talabat.designhelpers.Grocery;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;

public class HorizontalLinearLayoutManager extends LinearLayoutManager {
    public HorizontalLinearLayoutManager(Context context, int i11, boolean z11) {
        super(context, i11, z11);
    }

    public boolean canScrollHorizontally() {
        return true;
    }

    public boolean canScrollVertically() {
        return false;
    }
}
