package com.huawei.hms.dtm.core;

import android.view.View;
import android.view.ViewGroup;

/* renamed from: com.huawei.hms.dtm.core.ud  reason: case insensitive filesystem */
public class C0446ud implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ViewGroup f48612a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C0451vd f48613b;

    public C0446ud(C0451vd vdVar, ViewGroup viewGroup) {
        this.f48613b = vdVar;
        this.f48612a = viewGroup;
    }

    public void run() {
        View b11 = this.f48613b.b(this.f48612a);
        if (b11 != null) {
            this.f48612a.removeView(b11);
        }
        C0426qd qdVar = this.f48613b.f48589c;
        if (qdVar != null) {
            qdVar.dismiss();
        }
    }
}
