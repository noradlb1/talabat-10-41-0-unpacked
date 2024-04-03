package com.instabug.library;

import com.instabug.library.core.plugin.c;
import com.instabug.library.sessionprofiler.e;
import com.instabug.library.util.InstabugSDKLogger;

class l implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c0 f50577b;

    public l(c0 c0Var) {
        this.f50577b = c0Var;
    }

    public void run() {
        try {
            if (Instabug.getApplicationContext() != null) {
                this.f50577b.D();
                c.b(Instabug.getApplicationContext());
                e.a().c();
                this.f50577b.x();
                this.f50577b.N();
                com.instabug.library.networkv2.c.e(this.f50577b.j());
                this.f50577b.J();
            }
        } catch (Exception e11) {
            InstabugSDKLogger.e("IBG-Core", "Something went wrong while Resuming Instabug SDK", e11);
        }
    }
}
