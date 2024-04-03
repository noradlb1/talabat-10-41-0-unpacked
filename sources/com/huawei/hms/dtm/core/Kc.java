package com.huawei.hms.dtm.core;

import android.app.Activity;

public class Kc implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Activity f48329a;

    public Kc(Activity activity) {
        this.f48329a = activity;
    }

    public void run() {
        Lc.f48339c.onActivityResumed(this.f48329a);
    }
}
