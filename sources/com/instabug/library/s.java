package com.instabug.library;

import com.instabug.library.core.plugin.c;
import com.instabug.library.diagnostics.d;
import com.instabug.library.model.session.SessionState;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.InstabugSDKLogger;
import io.reactivex.functions.Consumer;

class s implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c0 f50591b;

    public s(c0 c0Var) {
        this.f50591b = c0Var;
    }

    /* renamed from: a */
    public void accept(SessionState sessionState) {
        d.a(sessionState);
        if (sessionState.equals(SessionState.FINISH)) {
            InstabugSDKLogger.logEndSession(System.currentTimeMillis());
            if (!c.h()) {
                this.f50591b.h();
            }
            this.f50591b.m();
            c.i();
        } else if (sessionState.equals(SessionState.START)) {
            this.f50591b.f50535c.a(SettingsManager.getInstance().getSessionsSyncConfigurations());
            InstabugSDKLogger.logSessionDetails(new l0(this.f50591b.j()).a());
            this.f50591b.f50543k.debounce((Runnable) new v0(this));
            this.f50591b.N();
            this.f50591b.C();
            this.f50591b.P();
            c.k();
        }
        this.f50591b.G();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a() {
        this.f50591b.A();
    }
}
