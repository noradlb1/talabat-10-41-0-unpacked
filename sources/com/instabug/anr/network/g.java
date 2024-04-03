package com.instabug.anr.network;

import android.content.Context;
import androidx.annotation.Nullable;
import com.instabug.anr.model.b;
import com.instabug.commons.diagnostics.di.DiagnosticsLocator;
import com.instabug.commons.diagnostics.event.CalibrationDiagnosticEvent;
import com.instabug.crash.utils.e;
import com.instabug.library.Instabug;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.InstabugSDKLogger;

class g implements Request.Callbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f45089a;

    public g(b bVar) {
        this.f45089a = bVar;
    }

    /* renamed from: a */
    public void onSucceeded(@Nullable Boolean bool) {
        InstabugSDKLogger.d("IBG-CR", "Anr attachments uploaded successfully");
        Context applicationContext = Instabug.getApplicationContext();
        if (applicationContext != null) {
            e.b(applicationContext, this.f45089a);
        } else {
            InstabugSDKLogger.e("IBG-CR", "unable to delete state file for ANR with id: " + this.f45089a.c() + "due to null context reference");
        }
        DiagnosticsLocator.getReporter().report(new CalibrationDiagnosticEvent((CalibrationDiagnosticEvent.IncidentType) new com.instabug.anr.diagnostics.b(), CalibrationDiagnosticEvent.Action.Synced));
    }

    /* renamed from: a */
    public void onFailed(b bVar) {
        InstabugSDKLogger.e("IBG-CR", "Something went wrong while uploading ANR attachments");
    }
}
