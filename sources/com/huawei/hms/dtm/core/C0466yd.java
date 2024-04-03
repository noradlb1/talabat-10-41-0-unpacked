package com.huawei.hms.dtm.core;

import android.view.View;
import android.view.ViewGroup;

/* renamed from: com.huawei.hms.dtm.core.yd  reason: case insensitive filesystem */
public class C0466yd implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ViewGroup f48638a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C0471zd f48639b;

    public C0466yd(C0471zd zdVar, ViewGroup viewGroup) {
        this.f48639b = zdVar;
        this.f48638a = viewGroup;
    }

    public void run() {
        View b11 = this.f48639b.b(this.f48638a);
        if (b11 != null) {
            this.f48638a.removeView(b11);
        }
        C0426qd qdVar = this.f48639b.f48589c;
        if (qdVar != null) {
            qdVar.dismiss();
        }
    }
}
