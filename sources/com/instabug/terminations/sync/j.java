package com.instabug.terminations.sync;

import com.instabug.commons.diagnostics.di.DiagnosticsLocator;
import com.instabug.commons.diagnostics.event.CalibrationDiagnosticEvent;
import com.instabug.library.networkv2.RequestResponse;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.terminations.di.d;
import com.instabug.terminations.model.b;
import org.jetbrains.annotations.Nullable;

public final class j implements Request.Callbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f52659a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ k f52660b;

    public j(b bVar, k kVar) {
        this.f52659a = bVar;
        this.f52660b = kVar;
    }

    /* renamed from: a */
    public void onSucceeded(@Nullable RequestResponse requestResponse) {
        this.f52659a.h();
        d.f52610a.b().a(this.f52659a);
        this.f52660b.a(this.f52659a);
        DiagnosticsLocator.getReporter().report(new CalibrationDiagnosticEvent((CalibrationDiagnosticEvent.IncidentType) new com.instabug.terminations.diagnostics.b(), CalibrationDiagnosticEvent.Action.Synced));
    }

    /* renamed from: a */
    public void onFailed(@Nullable Throwable th2) {
        if (th2 != null) {
            InstabugSDKLogger.e("IBG-CR", "Failed to upload termination logs", th2);
        }
    }
}
