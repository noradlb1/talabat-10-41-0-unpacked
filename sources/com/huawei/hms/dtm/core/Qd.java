package com.huawei.hms.dtm.core;

import android.app.Activity;

public class Qd implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Activity f48397a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Rd f48398b;

    public Qd(Rd rd2, Activity activity) {
        this.f48398b = rd2;
        this.f48397a = activity;
    }

    public void run() {
        be.b(this.f48397a);
        Ed.d().a(this.f48397a);
        C0352c.a(this.f48397a);
    }
}
