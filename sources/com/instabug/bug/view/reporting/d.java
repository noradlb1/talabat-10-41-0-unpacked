package com.instabug.bug.view.reporting;

import com.instabug.bug.n;
import com.instabug.library.util.InstabugSDKLogger;

class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ x f45879b;

    public d(x xVar) {
        this.f45879b = xVar;
    }

    public void run() {
        String str;
        if (n.e().c() == null) {
            str = "Bug is null";
        } else if (n.e().c().l() >= 4) {
            this.f45879b.e0();
            return;
        } else if (this.f45879b.C != null) {
            ((h0) this.f45879b.C).b();
            return;
        } else {
            str = "Presenter is null";
        }
        InstabugSDKLogger.v("IBG-BR", str);
    }
}
