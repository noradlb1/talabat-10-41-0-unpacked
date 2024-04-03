package com.instabug.library.invocation.invoker;

import android.widget.FrameLayout;

class l implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FrameLayout.LayoutParams f51349b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ p f51350c;

    public l(p pVar, FrameLayout.LayoutParams layoutParams) {
        this.f51350c = pVar;
        this.f51349b = layoutParams;
    }

    public void run() {
        if (this.f51350c.f51378q != null && this.f51350c.f51362a != null) {
            this.f51349b.leftMargin = this.f51350c.f51362a.leftMargin - this.f51350c.f51378q.getWidth();
            this.f51349b.rightMargin = this.f51350c.f51366e - this.f51350c.f51362a.leftMargin;
            this.f51349b.topMargin = this.f51350c.f51362a.topMargin + ((((this.f51350c.f51362a.height + this.f51350c.f51387z) / 2) - this.f51350c.f51378q.getHeight()) / 2);
            this.f51350c.f51378q.setLayoutParams(this.f51349b);
        }
    }
}
