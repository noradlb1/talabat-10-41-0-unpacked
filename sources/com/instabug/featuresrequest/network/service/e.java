package com.instabug.featuresrequest.network.service;

import com.instabug.library.core.InstabugCore;
import com.instabug.library.networkv2.RequestResponse;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.InstabugSDKLogger;
import org.json.JSONException;
import org.json.JSONObject;

class e implements Request.Callbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Request.Callbacks f46576a;

    public e(g gVar, Request.Callbacks callbacks) {
        this.f46576a = callbacks;
    }

    /* renamed from: a */
    public void onSucceeded(RequestResponse requestResponse) {
        InstabugSDKLogger.d("IBG-FR", "Getting feature-request details Succeeded, Response code: " + requestResponse.getResponseCode());
        InstabugSDKLogger.v("IBG-FR", "Getting feature-request details Succeeded, Response body: " + requestResponse.getResponseBody());
        if (requestResponse.getResponseCode() == 200) {
            try {
                if (requestResponse.getResponseBody() == null) {
                    InstabugSDKLogger.e("IBG-FR", "Request response is null");
                } else {
                    this.f46576a.onSucceeded(new JSONObject((String) requestResponse.getResponseBody()));
                }
            } catch (JSONException e11) {
                InstabugSDKLogger.e("IBG-FR", "getting feature-request details got JSONException: " + e11.getMessage(), e11);
                this.f46576a.onFailed(e11);
                InstabugCore.reportError(e11, "getting feature-request details got error: " + e11.getMessage());
            }
        } else {
            Request.Callbacks callbacks = this.f46576a;
            callbacks.onFailed(new Throwable("getting feature-request details request got error with response code:" + requestResponse.getResponseCode()));
        }
    }

    /* renamed from: a */
    public void onFailed(Throwable th2) {
        InstabugSDKLogger.e("IBG-FR", "getting feature-request details got error: " + th2.getMessage(), th2);
        this.f46576a.onFailed(th2);
        InstabugCore.reportError(th2, "getting feature-request details got error: " + th2.getMessage());
    }
}
