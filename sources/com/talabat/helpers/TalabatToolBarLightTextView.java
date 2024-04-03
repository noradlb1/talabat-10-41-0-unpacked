package com.talabat.helpers;

import android.content.Context;
import android.util.AttributeSet;
import androidx.core.content.ContextCompat;
import com.talabat.R;
import com.talabat.TalabatTextView;

public class TalabatToolBarLightTextView extends TalabatTextView {
    public TalabatToolBarLightTextView(Context context) {
        super(context);
    }

    private void setColor() {
        setTextColor(ContextCompat.getColor(getContext(), R.color.toolbar_image_color));
    }

    public TalabatToolBarLightTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setColor();
    }

    public TalabatToolBarLightTextView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        setColor();
    }
}
