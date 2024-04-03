package com.instabug.crash.network;

import android.content.Context;
import androidx.annotation.Nullable;
import com.instabug.commons.diagnostics.di.DiagnosticsLocator;
import com.instabug.commons.diagnostics.event.CalibrationDiagnosticEvent;
import com.instabug.crash.diagnostics.b;
import com.instabug.crash.models.a;
import com.instabug.crash.utils.e;
import com.instabug.library.Instabug;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.InstabugSDKLogger;

class g implements Request.Callbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f46437a;

    public g(a aVar) {
        this.f46437a = aVar;
    }

    /* renamed from: a */
    public void onSucceeded(@Nullable Boolean bool) {
        InstabugSDKLogger.d("IBG-CR", "Crash attachments uploaded successfully");
        Context applicationContext = Instabug.getApplicationContext();
        if (applicationContext != null) {
            e.b(applicationContext, this.f46437a);
        } else {
            InstabugSDKLogger.v("IBG-CR", "unable to delete state file for crash with id: " + this.f46437a.e() + "due to null context reference");
        }
        DiagnosticsLocator.getReporter().report(new CalibrationDiagnosticEvent((CalibrationDiagnosticEvent.IncidentType) new b(), CalibrationDiagnosticEvent.Action.Synced));
        h.e();
    }

    /* renamed from: a */
    public void onFailed(a aVar) {
        InstabugSDKLogger.e("IBG-CR", "Something went wrong while uploading crash attachments");
    }
}
