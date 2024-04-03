package com.talabat.helpers;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import com.talabat.R;

public class TalabatReleativeLayout extends NestedScrollView {
    public TalabatReleativeLayout(Context context) {
        super(context);
    }

    private void setWhiteHeader() {
        setBackgroundResource(R.color.white);
    }

    public TalabatReleativeLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        setWhiteHeader();
    }

    public TalabatReleativeLayout(Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        setWhiteHeader();
    }
}
