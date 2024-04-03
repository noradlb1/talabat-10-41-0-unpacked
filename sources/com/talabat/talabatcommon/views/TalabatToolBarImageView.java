package com.talabat.talabatcommon.views;

import android.content.Context;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.talabat.talabatcommon.R;

public class TalabatToolBarImageView extends AppCompatImageView {
    public TalabatToolBarImageView(Context context) {
        super(context);
    }

    private void setImageColor() {
        getDrawable().setColorFilter(ContextCompat.getColor(getContext(), R.color.toolbar_image_color), PorterDuff.Mode.SRC_ATOP);
    }

    public TalabatToolBarImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        setImageColor();
    }

    public TalabatToolBarImageView(Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        setImageColor();
    }
}
