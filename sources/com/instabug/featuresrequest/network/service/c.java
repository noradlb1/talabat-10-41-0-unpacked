package com.instabug.featuresrequest.network.service;

import com.instabug.library.core.InstabugCore;
import com.instabug.library.networkv2.RequestResponse;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.InstabugSDKLogger;
import org.json.JSONException;
import org.json.JSONObject;

class c implements Request.Callbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Request.Callbacks f46574a;

    public c(g gVar, Request.Callbacks callbacks) {
        this.f46574a = callbacks;
    }

    /* renamed from: a */
    public void onSucceeded(RequestResponse requestResponse) {
        InstabugSDKLogger.d("IBG-FR", "FeaturesRequests request succeeded, Response code: " + requestResponse.getResponseCode());
        InstabugSDKLogger.v("IBG-FR", "FeaturesRequests request succeeded,Response body: " + requestResponse.getResponseBody());
        if (requestResponse.getResponseCode() == 200) {
            try {
                if (requestResponse.getResponseBody() == null) {
                    InstabugSDKLogger.e("IBG-FR", "Request response is null");
                } else {
                    this.f46574a.onSucceeded(new JSONObject((String) requestResponse.getResponseBody()));
                }
            } catch (JSONException e11) {
                InstabugCore.reportError(e11, "FeaturesRequests request got error: " + e11.getMessage());
                InstabugSDKLogger.e("IBG-FR", "FeaturesRequests request got JSONException: " + e11.getMessage(), e11);
                this.f46574a.onFailed(e11);
            }
        } else {
            Request.Callbacks callbacks = this.f46574a;
            callbacks.onFailed(new Throwable("Fetching FeaturesRequests request got error with response code:" + requestResponse.getResponseCode()));
        }
    }

    /* renamed from: a */
    public void onFailed(Throwable th2) {
        InstabugSDKLogger.e("IBG-FR", "FeaturesRequests request got error: ", th2);
        this.f46574a.onFailed(th2);
    }
}
