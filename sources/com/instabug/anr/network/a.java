package com.instabug.anr.network;

import com.instabug.anr.model.b;
import com.instabug.library.internal.storage.AttachmentsUtility;
import com.instabug.library.networkv2.RateLimitedException;
import com.instabug.library.networkv2.RequestResponse;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.InstabugSDKLogger;
import org.json.JSONException;
import org.json.JSONObject;

class a implements Request.Callbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Request.Callbacks f45076a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ b f45077b;

    public a(d dVar, Request.Callbacks callbacks, b bVar) {
        this.f45076a = callbacks;
        this.f45077b = bVar;
    }

    /* renamed from: a */
    public void onSucceeded(RequestResponse requestResponse) {
        InstabugSDKLogger.d("IBG-CR", "ReportingAnrRequest Succeeded, Response code: " + requestResponse.getResponseCode());
        InstabugSDKLogger.v("IBG-CR", "ReportingAnrRequest Succeeded, Response body: " + requestResponse.getResponseBody());
        try {
            if (requestResponse.getResponseBody() != null) {
                this.f45076a.onSucceeded(new JSONObject((String) requestResponse.getResponseBody()).getString("id"));
                return;
            }
            this.f45076a.onFailed(new JSONException("requestResponse.getResponseBody() returned null"));
        } catch (JSONException e11) {
            InstabugSDKLogger.e("IBG-CR", "Couldn't parse Anr request response.", e11);
        }
    }

    /* renamed from: a */
    public void onFailed(Throwable th2) {
        if (th2 instanceof RateLimitedException) {
            this.f45076a.onFailed(th2);
            return;
        }
        InstabugSDKLogger.e("IBG-CR", "ReportingAnrRequest got error: ", th2);
        InstabugSDKLogger.e("AnrsService", "ReportingAnrRequest got error: ", th2);
        AttachmentsUtility.encryptAttachmentsAndUpdateDb(this.f45077b.b());
        this.f45076a.onFailed(th2);
    }
}
