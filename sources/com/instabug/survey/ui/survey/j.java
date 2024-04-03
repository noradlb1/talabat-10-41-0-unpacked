package com.instabug.survey.ui.survey;

import android.text.TextUtils;
import com.instabug.library.ui.custom.InstabugViewPager;
import com.instabug.library.util.LocaleHelper;

class j implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ InstabugViewPager f52556b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ l f52557c;

    public j(l lVar, InstabugViewPager instabugViewPager) {
        this.f52557c = lVar;
        this.f52556b = instabugViewPager;
    }

    public void run() {
        l lVar = this.f52557c;
        if (lVar.G != null && lVar.getContext() != null && this.f52556b != null) {
            if (!LocaleHelper.isRTL(this.f52557c.getContext())) {
                this.f52556b.scrollBackward(true);
            } else if (this.f52557c.G.getQuestions().get(this.f52557c.J).a() != null && !TextUtils.isEmpty(this.f52557c.G.getQuestions().get(this.f52557c.J).a())) {
                this.f52556b.scrollForward(true);
            }
        }
    }
}
