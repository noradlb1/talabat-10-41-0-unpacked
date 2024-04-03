package com.instabug.library.tracking;

import com.instabug.library.core.InstabugCore;
import com.instabug.library.diagnostics.IBGDiagnostics;
import com.instabug.library.model.p;
import com.instabug.library.usersteps.h;

class m implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f51936b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f51937c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f51938d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f51939e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ n f51940f;

    public m(n nVar, String str, String str2, String str3, String str4) {
        this.f51940f = nVar;
        this.f51936b = str;
        this.f51937c = str2;
        this.f51938d = str3;
        this.f51939e = str4;
    }

    public void run() {
        if (!InstabugCore.isForegroundBusy()) {
            p a11 = this.f51940f.a(this.f51936b);
            a11.b(h.a(this.f51936b, this.f51937c, this.f51938d, this.f51939e));
            a11.e(this.f51937c);
            a11.a((String) null);
            a11.d((String) null);
            this.f51940f.c();
            try {
                this.f51940f.f51942a.add(a11);
            } catch (Exception e11) {
                IBGDiagnostics.reportNonFatalAndLog(e11, "Error while adding step to userTracking steps", "IBG-Core");
            }
        }
    }
}
