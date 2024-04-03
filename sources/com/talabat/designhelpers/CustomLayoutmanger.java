package com.talabat.designhelpers;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;

public class CustomLayoutmanger extends LinearLayoutManager {
    public CustomLayoutmanger(Context context) {
        super(context);
    }

    public boolean supportsPredictiveItemAnimations() {
        return false;
    }

    public CustomLayoutmanger(Context context, int i11, boolean z11) {
        super(context, i11, z11);
    }

    public CustomLayoutmanger(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
    }
}
