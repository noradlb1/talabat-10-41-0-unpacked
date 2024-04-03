package com.instabug.crash.network;

import com.instabug.library.core.InstabugCore;
import com.instabug.library.diagnostics.IBGDiagnostics;
import com.instabug.library.internal.storage.AttachmentsUtility;
import com.instabug.library.networkv2.RateLimitedException;
import com.instabug.library.networkv2.RequestResponse;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.InstabugSDKLogger;
import org.json.JSONException;
import org.json.JSONObject;

class a implements Request.Callbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Request.Callbacks f46423a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ com.instabug.crash.models.a f46424b;

    public a(d dVar, Request.Callbacks callbacks, com.instabug.crash.models.a aVar) {
        this.f46423a = callbacks;
        this.f46424b = aVar;
    }

    /* renamed from: a */
    public void onSucceeded(RequestResponse requestResponse) {
        InstabugSDKLogger.d("IBG-CR", "reportingCrashRequest Succeeded, Response code: " + requestResponse.getResponseCode());
        InstabugSDKLogger.v("IBG-CR", "reportingCrashRequest Succeeded, Response body: " + requestResponse.getResponseBody());
        try {
            if (requestResponse.getResponseBody() != null) {
                this.f46423a.onSucceeded(new JSONObject((String) requestResponse.getResponseBody()).getString("id"));
            } else {
                this.f46423a.onFailed(new JSONException("requestResponse.getResponseBody() returned null"));
            }
        } catch (JSONException e11) {
            e11.printStackTrace();
            this.f46423a.onFailed(e11);
        }
    }

    /* renamed from: a */
    public void onFailed(Throwable th2) {
        if (th2 instanceof RateLimitedException) {
            this.f46423a.onFailed(th2);
            return;
        }
        IBGDiagnostics.reportNonFatalAndLog(th2, "Reporting crash got error: " + th2.getMessage(), "IBG-CR");
        InstabugSDKLogger.e("CrashesService", "reportingCrashRequest got error: ", th2);
        InstabugCore.reportError(th2, "Reporting crash got error: " + th2.getMessage());
        AttachmentsUtility.encryptAttachmentsAndUpdateDb(this.f46424b.a());
        this.f46423a.onFailed(th2);
    }
}
