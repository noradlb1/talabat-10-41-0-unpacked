package com.talabat.helpers;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.talabat.R;

public class TalabatToolBarSearchLinearLayout extends LinearLayout {
    public TalabatToolBarSearchLinearLayout(Context context) {
        super(context);
    }

    private void setBoarderBackground() {
        setBackgroundResource(R.drawable.edittext_boarder);
    }

    public TalabatToolBarSearchLinearLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        setBoarderBackground();
    }

    public TalabatToolBarSearchLinearLayout(Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        setBoarderBackground();
    }
}
