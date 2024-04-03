package com.instabug.chat.network.service;

import com.instabug.library.networkv2.RequestResponse;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.InstabugSDKLogger;
import org.json.JSONException;
import org.json.JSONObject;

class b implements Request.Callbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Request.Callbacks f46094a;

    public b(g gVar, Request.Callbacks callbacks) {
        this.f46094a = callbacks;
    }

    /* renamed from: a */
    public void onSucceeded(RequestResponse requestResponse) {
        if (requestResponse != null) {
            InstabugSDKLogger.d("IBG-BR", "sendMessage request Succeeded, Response code: " + requestResponse.getResponseCode());
            InstabugSDKLogger.v("IBG-BR", "sendMessage request Succeeded, Response body: " + requestResponse.getResponseBody());
            if (requestResponse.getResponseCode() == 200) {
                try {
                    Object responseBody = requestResponse.getResponseBody();
                    if (responseBody instanceof String) {
                        this.f46094a.onSucceeded(new JSONObject((String) responseBody).getString("message_id"));
                    }
                } catch (JSONException e11) {
                    InstabugSDKLogger.e("IBG-BR", "Sending message got error: " + e11.getMessage());
                }
            } else {
                Request.Callbacks callbacks = this.f46094a;
                callbacks.onFailed(new Throwable("Sending message got error with response code:" + requestResponse.getResponseCode()));
            }
        }
    }

    /* renamed from: a */
    public void onFailed(Throwable th2) {
        InstabugSDKLogger.e("IBG-BR", "sendMessage request got error: " + th2.getMessage());
        this.f46094a.onFailed(th2);
    }
}
