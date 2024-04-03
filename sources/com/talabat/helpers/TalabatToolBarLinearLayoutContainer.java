package com.talabat.helpers;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.talabat.R;

public class TalabatToolBarLinearLayoutContainer extends LinearLayout {
    public TalabatToolBarLinearLayoutContainer(Context context) {
        super(context);
    }

    private void setWhiteHeader() {
        setBackgroundResource(R.color.white);
    }

    public TalabatToolBarLinearLayoutContainer(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        setWhiteHeader();
    }

    public TalabatToolBarLinearLayoutContainer(Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        setWhiteHeader();
    }
}
