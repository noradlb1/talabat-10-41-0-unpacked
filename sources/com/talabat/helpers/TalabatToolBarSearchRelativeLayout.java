package com.talabat.helpers;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.talabat.R;

public class TalabatToolBarSearchRelativeLayout extends RelativeLayout {
    public TalabatToolBarSearchRelativeLayout(Context context) {
        super(context);
    }

    private void setBoarderBackground() {
        setBackgroundResource(R.drawable.edittext_boarder);
    }

    public TalabatToolBarSearchRelativeLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        setBoarderBackground();
    }

    public TalabatToolBarSearchRelativeLayout(Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        setBoarderBackground();
    }
}
