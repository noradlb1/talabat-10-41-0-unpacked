package com.huawei.hms.dtm.core;

import android.annotation.SuppressLint;
import android.view.ViewGroup;

/* renamed from: com.huawei.hms.dtm.core.xd  reason: case insensitive filesystem */
public class C0461xd implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ViewGroup f48631a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C0471zd f48632b;

    public C0461xd(C0471zd zdVar, ViewGroup viewGroup) {
        this.f48632b = zdVar;
        this.f48631a = viewGroup;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void run() {
        if (!this.f48632b.c(this.f48631a)) {
            C0471zd zdVar = this.f48632b;
            zdVar.a(zdVar.f48588b, this.f48631a, zdVar.f48587a);
            this.f48631a.addView(this.f48632b.f48587a);
            if (!Ed.d().e()) {
                this.f48632b.c();
            }
        }
    }
}
