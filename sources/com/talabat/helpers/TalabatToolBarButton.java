package com.talabat.helpers;

import android.content.Context;
import android.util.AttributeSet;
import androidx.core.content.ContextCompat;
import com.talabat.R;
import com.talabat.TalabatButton;

public class TalabatToolBarButton extends TalabatButton {
    public TalabatToolBarButton(Context context) {
        super(context);
    }

    private void setColor() {
        setTextColor(ContextCompat.getColor(getContext(), R.color.toolbar_text_color));
    }

    public TalabatToolBarButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setColor();
    }

    public TalabatToolBarButton(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        setColor();
    }
}
