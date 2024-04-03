package com.instabug.library.internal.view.floatingactionbutton;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.instabug.library.R;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.util.LocaleUtils;
import com.instabug.library.view.a;

public class f extends d {
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public boolean f51267m;

    public f(Context context) {
        this(context, (AttributeSet) null);
    }

    public void d() {
        this.f51267m = false;
        g();
        setTextColor(ViewCompat.MEASURED_STATE_MASK);
        setContentDescription(LocaleUtils.getLocaleStringResource(InstabugCore.getLocale(getContext()), R.string.ibg_screen_recording_unmute_btn_content_description, getContext()));
    }

    public void e() {
        this.f51267m = true;
        g();
        setTextColor(-1);
        setContentDescription(LocaleUtils.getLocaleStringResource(InstabugCore.getLocale(getContext()), R.string.ibg_screen_recording_mute_btn_content_description, getContext()));
    }

    public boolean f() {
        if (this.f51267m) {
            d();
        } else {
            e();
        }
        return this.f51267m;
    }

    public int getButtonContentDescription() {
        if (this.f51267m) {
            return R.string.ibg_screen_recording_unmute_btn_content_description;
        }
        return R.string.ibg_screen_recording_mute_btn_content_description;
    }

    public Drawable getIconDrawable() {
        float j11 = j(R.dimen.instabug_fab_icon_size_mini);
        float j12 = j(R.dimen.instabug_fab_size_mini);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new e(this, j(R.dimen.instabug_fab_circle_icon_stroke), j11 / 2.0f, j12, j11));
        shapeDrawable.getPaint().setAntiAlias(true);
        return shapeDrawable;
    }

    public void h(Context context, @Nullable AttributeSet attributeSet) {
        super.h(context, attributeSet);
        setSize(1);
        setId(R.id.instabug_video_mute_button);
        setNextFocusForwardId(R.id.instabug_video_stop_button);
        setText(a.a(1));
        setGravity(17);
        d();
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public f(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
