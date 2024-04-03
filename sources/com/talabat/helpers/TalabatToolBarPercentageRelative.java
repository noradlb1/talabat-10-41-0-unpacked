package com.talabat.helpers;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.percentlayout.widget.PercentRelativeLayout;
import com.talabat.R;

public class TalabatToolBarPercentageRelative extends PercentRelativeLayout {
    public TalabatToolBarPercentageRelative(Context context) {
        super(context);
    }

    private void setBoarderBackground() {
        setBackgroundColor(ContextCompat.getColor(getContext(), R.color.white));
    }

    public TalabatToolBarPercentageRelative(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        setBoarderBackground();
    }

    public TalabatToolBarPercentageRelative(Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        setBoarderBackground();
    }
}
