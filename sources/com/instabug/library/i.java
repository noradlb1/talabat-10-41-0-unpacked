package com.instabug.library;

import com.instabug.library.Feature;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.b;
import com.instabug.library.internal.InstabugMediaProjectionIntent;
import com.instabug.library.internal.dataretention.files.d;
import com.instabug.library.model.v3Session.t;
import com.instabug.library.model.v3Session.u;
import com.instabug.library.networkv2.c;
import com.instabug.library.sessionprofiler.e;
import com.instabug.library.tracking.InstabugInternalTrackingDelegate;
import com.instabug.library.util.InstabugSDKLogger;

class i implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c0 f50570b;

    public i(c0 c0Var) {
        this.f50570b = c0Var;
    }

    public void run() {
        c.h(this.f50570b.j());
        InstabugSDKLogger.d("IBG-Core", "Stopping Instabug SDK functionality");
        InstabugCore.setAutoScreenRecordingEnabled(false);
        this.f50570b.W(InstabugState.DISABLED);
        this.f50570b.c0(Feature.State.DISABLED);
        e.a().d();
        this.f50570b.S();
        this.f50570b.M();
        com.instabug.library.core.plugin.c.j();
        r0.e().p();
        com.instabug.library.sessionV3.manager.i.f51800a.a((u) new t());
        InstabugInternalTrackingDelegate.getInstance().unregisterLifecycleListeners(this.f50570b.f50536d);
        this.f50570b.s();
        this.f50570b.e();
        this.f50570b.f();
        this.f50570b.R();
        this.f50570b.T();
        this.f50570b.Q();
        b.b();
        boolean unused = this.f50570b.f50545m = false;
        InstabugMediaProjectionIntent.release();
        new com.instabug.library.internal.orchestrator.b(d.b(), new com.instabug.library.internal.dataretention.core.c[0]).run();
    }
}
