package com.talabat;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Px;

public class ScrollPreventedTalabatTextView extends TalabatTextView {
    public ScrollPreventedTalabatTextView(Context context) {
        super(context);
    }

    public void scrollTo(@Px int i11, @Px int i12) {
    }

    public ScrollPreventedTalabatTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScrollPreventedTalabatTextView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
