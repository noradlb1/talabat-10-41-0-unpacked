package com.instabug.library;

import com.instabug.library.Feature;
import com.instabug.library.core.b;
import com.instabug.library.internal.InstabugMediaProjectionIntent;
import com.instabug.library.model.v3Session.t;
import com.instabug.library.model.v3Session.u;
import com.instabug.library.networkv2.c;
import com.instabug.library.sessionV3.manager.i;
import com.instabug.library.sessionprofiler.e;
import com.instabug.library.util.InstabugSDKLogger;

class k implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c0 f50575b;

    public k(c0 c0Var) {
        this.f50575b = c0Var;
    }

    public void run() {
        try {
            c.h(this.f50575b.j());
            r0.e().p();
            i.f51800a.a((u) new t());
            this.f50575b.D();
            com.instabug.library.core.plugin.c.j();
            e.a().d();
            this.f50575b.S();
            this.f50575b.T();
            this.f50575b.Q();
            this.f50575b.M();
            b.b();
            InstabugMediaProjectionIntent.release();
            this.f50575b.W(InstabugState.DISABLED);
            this.f50575b.c0(Feature.State.DISABLED);
        } catch (Exception e11) {
            InstabugSDKLogger.e("IBG-Core", "Something went wrong while Pausing Instabug SDK", e11);
        }
    }
}
