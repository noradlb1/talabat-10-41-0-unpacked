package com.instabug.library.session;

import com.instabug.library.diagnostics.IBGDiagnostics;
import com.instabug.library.model.session.SessionsBatchDTO;
import com.instabug.library.networkv2.RateLimitedException;
import com.instabug.library.networkv2.RequestResponse;
import com.instabug.library.networkv2.request.Request;
import java.util.List;

class m implements Request.Callbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SessionsBatchDTO f51753a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f51754b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ n f51755c;

    public m(n nVar, SessionsBatchDTO sessionsBatchDTO, List list) {
        this.f51755c = nVar;
        this.f51753a = sessionsBatchDTO;
        this.f51754b = list;
    }

    /* renamed from: a */
    public void onSucceeded(RequestResponse requestResponse) {
        n nVar = this.f51755c;
        nVar.a("Synced a batch of " + this.f51753a.getSessions().size() + " session/s.");
        this.f51755c.f51761f.a(0);
        this.f51755c.f51759d.b(this.f51754b).a(this.f51754b);
    }

    /* renamed from: a */
    public void onFailed(Throwable th2) {
        if (th2 instanceof RateLimitedException) {
            this.f51755c.a((RateLimitedException) th2, this.f51753a);
            return;
        }
        IBGDiagnostics.reportNonFatalAndLog(th2, "Syncing Sessions filed due to: " + th2.getMessage(), "IBG-Core");
    }
}
