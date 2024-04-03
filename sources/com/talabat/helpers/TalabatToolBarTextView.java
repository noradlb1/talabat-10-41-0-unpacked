package com.talabat.helpers;

import android.content.Context;
import android.util.AttributeSet;
import androidx.core.content.ContextCompat;
import com.talabat.R;
import com.talabat.TalabatTextView;

public class TalabatToolBarTextView extends TalabatTextView {
    public TalabatToolBarTextView(Context context) {
        super(context);
    }

    private void setColor() {
        setTextColor(ContextCompat.getColor(getContext(), R.color.toolbar_text_color));
    }

    public TalabatToolBarTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setColor();
    }

    public TalabatToolBarTextView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        setColor();
    }
}
