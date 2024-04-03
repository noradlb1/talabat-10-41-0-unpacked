package com.instabug.library.firstseen;

import com.instabug.library.networkv2.RequestResponse;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.InstabugSDKLogger;
import org.json.JSONException;
import org.json.JSONObject;

class c implements Request.Callbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Request.Callbacks f34368a;

    public c(d dVar, Request.Callbacks callbacks) {
        this.f34368a = callbacks;
    }

    /* renamed from: a */
    public void onSucceeded(RequestResponse requestResponse) {
        if (requestResponse != null) {
            InstabugSDKLogger.d("IBG-Core", "getCurrentAppVersionFirstSeen Succeeded, Response code: " + requestResponse.getResponseCode());
            InstabugSDKLogger.v("IBG-Core", "Response: " + requestResponse);
            if (requestResponse.getResponseCode() == 200) {
                try {
                    if (requestResponse.getResponseBody() != null) {
                        this.f34368a.onSucceeded(new JSONObject((String) requestResponse.getResponseBody()));
                    } else {
                        this.f34368a.onSucceeded(new JSONObject());
                    }
                } catch (JSONException e11) {
                    InstabugSDKLogger.e("IBG-Core", "getCurrentAppVersionFirstSeen got JSONException: " + e11.getMessage(), e11);
                    this.f34368a.onFailed(e11);
                }
            } else {
                Request.Callbacks callbacks = this.f34368a;
                callbacks.onFailed(new Throwable("getCurrentAppVersionFirstSeen got error with response code:" + requestResponse.getResponseCode()));
            }
        }
    }

    /* renamed from: a */
    public void onFailed(Throwable th2) {
        InstabugSDKLogger.e("IBG-Core", "getCurrentAppVersionFirstSeen got error: " + th2.getMessage(), th2);
        this.f34368a.onFailed(th2);
    }
}
