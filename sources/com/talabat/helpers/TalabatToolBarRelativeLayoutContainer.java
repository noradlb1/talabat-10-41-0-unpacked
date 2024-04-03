package com.talabat.helpers;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.talabat.R;

public class TalabatToolBarRelativeLayoutContainer extends RelativeLayout {
    public TalabatToolBarRelativeLayoutContainer(Context context) {
        super(context);
    }

    private void setWhiteHeader() {
        setBackgroundResource(R.color.white);
    }

    public TalabatToolBarRelativeLayoutContainer(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        setWhiteHeader();
    }

    public TalabatToolBarRelativeLayoutContainer(Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        setWhiteHeader();
    }
}
