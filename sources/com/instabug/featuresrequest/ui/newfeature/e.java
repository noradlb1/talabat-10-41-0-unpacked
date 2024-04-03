package com.instabug.featuresrequest.ui.newfeature;

import android.annotation.SuppressLint;
import android.view.View;
import com.instabug.featuresrequest.R;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.AttrResolver;
import com.instabug.library.view.ViewUtils;

class e implements View.OnFocusChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ g f46803b;

    public e(g gVar) {
        this.f46803b = gVar;
    }

    @SuppressLint({"STARVATION"})
    public void onFocusChange(View view, boolean z11) {
        View K0;
        int i11;
        if (this.f46803b.getContext() != null && (K0 = this.f46803b.f46817n) != null) {
            if (z11) {
                K0.getLayoutParams().height = ViewUtils.convertDpToPx(this.f46803b.getContext(), 2.0f);
                i11 = SettingsManager.getInstance().getPrimaryColor();
            } else {
                K0.getLayoutParams().height = ViewUtils.convertDpToPx(this.f46803b.getContext(), 1.0f);
                i11 = AttrResolver.getColor(this.f46803b.getContext(), R.attr.ib_fr_add_comment_edit_text_underline_color);
            }
            K0.setBackgroundColor(i11);
            K0.requestLayout();
            View unused = this.f46803b.f46817n = K0;
        }
    }
}
