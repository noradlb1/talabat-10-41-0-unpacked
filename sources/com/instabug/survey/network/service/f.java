package com.instabug.survey.network.service;

import com.instabug.library.networkv2.RequestResponse;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.InstabugSDKLogger;
import org.json.JSONException;
import org.json.JSONObject;

class f implements Request.Callbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Request.Callbacks f52416a;

    public f(g gVar, Request.Callbacks callbacks) {
        this.f52416a = callbacks;
    }

    /* renamed from: a */
    public void onSucceeded(RequestResponse requestResponse) {
        JSONObject jSONObject;
        Request.Callbacks callbacks;
        InstabugSDKLogger.d("IBG-Surveys", "Resolving the country info finished, Response code: " + requestResponse.getResponseCode());
        try {
            if (requestResponse.getResponseCode() == 200) {
                if (requestResponse.getResponseBody() != null) {
                    callbacks = this.f52416a;
                    jSONObject = new JSONObject((String) requestResponse.getResponseBody());
                } else {
                    callbacks = this.f52416a;
                    jSONObject = new JSONObject();
                }
                callbacks.onSucceeded(jSONObject);
                return;
            }
            Request.Callbacks callbacks2 = this.f52416a;
            callbacks2.onFailed(new Throwable("resolving the country info got error with response code:" + requestResponse.getResponseCode()));
        } catch (JSONException unused) {
            InstabugSDKLogger.e("IBG-Surveys", "Resolving the country info  failed, Response code: " + requestResponse.getResponseCode());
            Request.Callbacks callbacks3 = this.f52416a;
            callbacks3.onFailed(new Throwable("resolving the country info got error with response code:" + requestResponse.getResponseCode()));
        }
    }

    /* renamed from: a */
    public void onFailed(Throwable th2) {
        InstabugSDKLogger.e("IBG-Surveys", "resolving the country info got eror: " + th2.getMessage());
        this.f52416a.onFailed(th2);
    }
}
