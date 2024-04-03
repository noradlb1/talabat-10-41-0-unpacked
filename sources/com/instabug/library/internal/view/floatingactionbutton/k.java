package com.instabug.library.internal.view.floatingactionbutton;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import com.instabug.library.R;

public class k extends d {
    public k(Context context) {
        this(context, (AttributeSet) null);
    }

    @StringRes
    public int getButtonContentDescription() {
        return R.string.ibg_scren_recording_stop_btn_content_description;
    }

    public Drawable getIconDrawable() {
        float j11 = j(R.dimen.instabug_fab_icon_size_mini);
        float j12 = j(R.dimen.instabug_fab_size_mini);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new j(this, j(R.dimen.instabug_fab_circle_icon_stroke), j11 / 2.0f, j12, j11));
        shapeDrawable.getPaint().setAntiAlias(true);
        return shapeDrawable;
    }

    public void h(Context context, @Nullable AttributeSet attributeSet) {
        super.h(context, attributeSet);
        setSize(1);
        setId(R.id.instabug_video_stop_button);
        setNextFocusForwardId(R.id.instabug_floating_button);
    }

    public k(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
