package com.instabug.bug;

import com.instabug.bug.BugReporting;
import com.instabug.library.Feature;
import com.instabug.library.util.InstabugSDKLogger;

class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BugReporting.e f45634b;

    public d(BugReporting.e eVar) {
        this.f45634b = eVar;
    }

    public void run() {
        Feature.State state = this.f45634b.f45600a;
        if (state == null) {
            InstabugSDKLogger.w("IBG-BR", "state object passed to BugReporting.setState() is null");
        } else {
            h.a(state);
        }
    }
}
