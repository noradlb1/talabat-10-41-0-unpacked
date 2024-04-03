package com.huawei.hms.dtm.core;

import android.app.Activity;
import android.widget.Toast;

public class Pd implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Activity f48386a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Rd f48387b;

    public Pd(Rd rd2, Activity activity) {
        this.f48387b = rd2;
        this.f48386a = activity;
    }

    public void run() {
        Toast.makeText(this.f48386a, J.a(R.string.dtm_visual_toast_disconnect), 0).show();
        Ed.d().a();
        C0392k.c().a();
        Runnable unused = this.f48387b.f48404b = null;
        C0352c.b(this.f48386a);
    }
}
