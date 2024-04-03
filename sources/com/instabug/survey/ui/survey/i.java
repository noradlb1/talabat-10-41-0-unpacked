package com.instabug.survey.ui.survey;

import com.instabug.library.ui.custom.InstabugViewPager;

class i implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ l f52555b;

    public i(l lVar) {
        this.f52555b = lVar;
    }

    public void run() {
        InstabugViewPager instabugViewPager = this.f52555b.I;
        if (instabugViewPager != null) {
            instabugViewPager.scrollForward(true);
        }
    }
}
