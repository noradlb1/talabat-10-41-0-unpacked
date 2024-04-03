package com.instabug.library.tracking;

import com.instabug.library.core.InstabugCore;
import com.instabug.library.diagnostics.IBGDiagnostics;
import com.instabug.library.model.p;
import com.instabug.library.usersteps.h;

class l implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f51933b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f51934c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ n f51935d;

    public l(n nVar, String str, String str2) {
        this.f51935d = nVar;
        this.f51933b = str;
        this.f51934c = str2;
    }

    public void run() {
        if (!InstabugCore.isForegroundBusy()) {
            p a11 = this.f51935d.a(this.f51933b);
            a11.b(h.a(this.f51933b, this.f51934c));
            a11.e(this.f51934c);
            a11.a((String) null);
            a11.d((String) null);
            this.f51935d.c();
            try {
                this.f51935d.f51942a.add(a11);
            } catch (Exception e11) {
                IBGDiagnostics.reportNonFatalAndLog(e11, "Error while adding step to userTracking steps", "IBG-Core");
            }
        }
    }
}
