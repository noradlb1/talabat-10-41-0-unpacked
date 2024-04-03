package com.instabug.survey.ui.survey;

import android.text.TextUtils;
import com.instabug.library.ui.custom.InstabugViewPager;
import com.instabug.library.util.LocaleHelper;

class k implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ InstabugViewPager f52558b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ l f52559c;

    public k(l lVar, InstabugViewPager instabugViewPager) {
        this.f52559c = lVar;
        this.f52558b = instabugViewPager;
    }

    public void run() {
        l lVar = this.f52559c;
        if (lVar.G != null && lVar.getContext() != null) {
            if (LocaleHelper.isRTL(this.f52559c.getContext())) {
                this.f52558b.scrollBackward(true);
            } else if (this.f52559c.G.getQuestions().get(this.f52559c.J).a() != null && !TextUtils.isEmpty(this.f52559c.G.getQuestions().get(this.f52559c.J).a())) {
                this.f52558b.scrollForward(true);
            }
        }
    }
}
