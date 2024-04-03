package com.instabug.library.invocation.invoker;

import android.app.Activity;

class i implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Activity f51345b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ p f51346c;

    public i(p pVar, Activity activity) {
        this.f51346c = pVar;
        this.f51345b = activity;
    }

    public void run() {
        if (this.f51346c.c(this.f51345b)) {
            boolean unused = this.f51346c.E = true;
            n E = this.f51346c.A;
            if (E != null) {
                E.d();
            }
        }
        if (!this.f51346c.f51372k) {
            this.f51346c.o();
        }
    }
}
