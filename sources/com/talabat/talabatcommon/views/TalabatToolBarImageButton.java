package com.talabat.talabatcommon.views;

import android.content.Context;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.content.ContextCompat;
import com.talabat.talabatcommon.R;

public class TalabatToolBarImageButton extends AppCompatImageButton {
    public TalabatToolBarImageButton(Context context) {
        super(context);
    }

    private void setImageColor() {
        getDrawable().setColorFilter(ContextCompat.getColor(getContext(), R.color.tool_bar_button_color), PorterDuff.Mode.SRC_ATOP);
    }

    public TalabatToolBarImageButton(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        setImageColor();
    }

    public TalabatToolBarImageButton(Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        setImageColor();
    }
}
