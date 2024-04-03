package com.talabat.helpers;

import android.content.Context;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.talabat.R;

public class TalabatToolBarTalabatLogo extends AppCompatImageView {
    public TalabatToolBarTalabatLogo(Context context) {
        super(context);
    }

    private void setImageColor() {
        getDrawable().setColorFilter(ContextCompat.getColor(getContext(), R.color.toolbar_talabat_logo), PorterDuff.Mode.SRC_ATOP);
    }

    public TalabatToolBarTalabatLogo(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        setImageColor();
    }

    public TalabatToolBarTalabatLogo(Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        setImageColor();
    }
}
