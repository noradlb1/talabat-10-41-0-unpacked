package com.huawei.hms.dtm.core;

import android.app.Activity;

public class Nd implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Activity f48375a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Rd f48376b;

    public Nd(Rd rd2, Activity activity) {
        this.f48376b = rd2;
        this.f48375a = activity;
    }

    public void run() {
        Ed.d().a(this.f48375a);
    }
}
