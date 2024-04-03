package com.instabug.bug.view.reporting;

import com.instabug.bug.n;
import com.instabug.library.util.InstabugSDKLogger;

class y implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ i0 f45943b;

    public y(g0 g0Var, i0 i0Var) {
        this.f45943b = i0Var;
    }

    public void run() {
        InstabugSDKLogger.v("IBG-BR", "READ_EXTERNAL_STORAGE Permission granted");
        n.e().g();
        this.f45943b.f();
    }
}
