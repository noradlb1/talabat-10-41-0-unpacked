package com.instabug.bug.view.reporting;

import com.instabug.bug.n;
import com.instabug.library.util.InstabugSDKLogger;

class e implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ x f45882b;

    public e(x xVar) {
        this.f45882b = xVar;
    }

    public void run() {
        String str;
        if (n.e().c() == null) {
            str = "Bug is null";
        } else if (n.e().c().l() >= 4) {
            this.f45882b.e0();
            return;
        } else if (this.f45882b.C != null) {
            ((h0) this.f45882b.C).j();
            return;
        } else {
            str = "Presenter is null";
        }
        InstabugSDKLogger.v("IBG-BR", str);
    }
}
