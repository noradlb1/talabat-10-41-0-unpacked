package com.talabat.helpers;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import com.talabat.R;

public class TalabatToolBar extends Toolbar {
    public TalabatToolBar(Context context) {
        super(context);
    }

    private void setWhiteHeader() {
        setBackgroundResource(R.color.ds_neutral_white);
        setLayoutAnimationListener((Animation.AnimationListener) null);
        setElevation(0.0f);
        setFitsSystemWindows(true);
    }

    public TalabatToolBar(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        setWhiteHeader();
    }

    public TalabatToolBar(Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        setWhiteHeader();
    }
}
