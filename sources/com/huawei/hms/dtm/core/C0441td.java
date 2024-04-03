package com.huawei.hms.dtm.core;

import android.annotation.SuppressLint;
import android.view.ViewGroup;

/* renamed from: com.huawei.hms.dtm.core.td  reason: case insensitive filesystem */
public class C0441td implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ViewGroup f48603a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C0451vd f48604b;

    public C0441td(C0451vd vdVar, ViewGroup viewGroup) {
        this.f48604b = vdVar;
        this.f48603a = viewGroup;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void run() {
        if (!this.f48604b.c(this.f48603a)) {
            C0451vd vdVar = this.f48604b;
            vdVar.a(vdVar.f48588b, this.f48603a, vdVar.f48587a);
            this.f48603a.addView(this.f48604b.f48587a);
            if (!Jc.b().c()) {
                this.f48604b.c();
            }
        }
    }
}
