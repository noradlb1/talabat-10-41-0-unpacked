package com.instabug.bug.view.reporting;

import com.instabug.bug.n;
import com.instabug.bug.settings.b;
import com.instabug.library.util.InstabugSDKLogger;

class f implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ x f45884b;

    public f(x xVar) {
        this.f45884b = xVar;
    }

    public void run() {
        if (n.e().c() == null) {
            InstabugSDKLogger.v("IBG-BR", "Bug is null");
        } else if (n.e().c().l() >= 4 || !b.f().a().b()) {
            this.f45884b.e0();
        } else {
            this.f45884b.f0();
        }
    }
}
