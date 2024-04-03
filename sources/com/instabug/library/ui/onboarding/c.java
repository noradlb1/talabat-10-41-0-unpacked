package com.instabug.library.ui.onboarding;

import android.annotation.SuppressLint;

class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ e f51980b;

    public c(e eVar) {
        this.f51980b = eVar;
    }

    @SuppressLint({"NULL_DEREFERENCE"})
    public void run() {
        if (this.f51980b.f51983a != null) {
            this.f51980b.f51983a.dismiss();
        }
    }
}
