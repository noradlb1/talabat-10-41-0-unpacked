package com.instabug.survey.announcements.ui.fragment.whatsnew;

import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import com.instabug.survey.R;
import com.instabug.survey.announcements.ui.custom.DynamicRelativeLayout;

class c implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d f52299b;

    public c(d dVar) {
        this.f52299b = dVar;
    }

    public void onGlobalLayout() {
        if (this.f52299b.H != null && this.f52299b.f52300f != null && this.f52299b.f52301g != null) {
            d dVar = this.f52299b;
            if (dVar.K != null) {
                if (((DynamicRelativeLayout) dVar.H).a()) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f52299b.f52300f.getLayoutParams();
                    layoutParams.addRule(12);
                    layoutParams.removeRule(3);
                    this.f52299b.f52300f.setLayoutParams(layoutParams);
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f52299b.f52301g.getLayoutParams();
                    layoutParams2.addRule(10);
                    this.f52299b.f52301g.setLayoutParams(layoutParams2);
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f52299b.K.getLayoutParams();
                    layoutParams3.addRule(2, R.id.instabug_btn_submit);
                    this.f52299b.K.setLayoutParams(layoutParams3);
                }
                this.f52299b.H.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        }
    }
}
