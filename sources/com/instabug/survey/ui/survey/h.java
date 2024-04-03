package com.instabug.survey.ui.survey;

import com.instabug.library.ui.custom.InstabugViewPager;

class h implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ InstabugViewPager f52554b;

    public h(l lVar, InstabugViewPager instabugViewPager) {
        this.f52554b = instabugViewPager;
    }

    public void run() {
        this.f52554b.scrollForward(true);
    }
}
