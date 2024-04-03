package com.talabat;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.material.tabs.TabLayout;

public class TalabatTabLayout extends TabLayout {
    public TalabatTabLayout(Context context) {
        super(context);
    }

    public void addTab(TabLayout.Tab tab) {
        super.addTab(tab);
        ((TextView) ((ViewGroup) ((ViewGroup) getChildAt(0)).getChildAt(tab.getPosition())).getChildAt(1)).setTextAppearance(getContext(), R.style.textViewRegular);
    }

    public TalabatTabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TalabatTabLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
