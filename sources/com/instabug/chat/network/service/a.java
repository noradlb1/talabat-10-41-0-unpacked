package com.instabug.chat.network.service;

import com.instabug.library.networkv2.RequestResponse;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.InstabugSDKLogger;
import org.json.JSONException;
import org.json.JSONObject;

class a implements Request.Callbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Request.Callbacks f46093a;

    public a(g gVar, Request.Callbacks callbacks) {
        this.f46093a = callbacks;
    }

    /* renamed from: a */
    public void onSucceeded(RequestResponse requestResponse) {
        if (requestResponse != null) {
            InstabugSDKLogger.d("IBG-BR", "triggeringChatRequest Succeeded, Response code: " + requestResponse.getResponseCode());
            InstabugSDKLogger.v("IBG-BR", "triggeringChatRequest Succeeded, Response body: " + requestResponse.getResponseBody());
            if (requestResponse.getResponseCode() == 200) {
                try {
                    if (requestResponse.getResponseBody() != null) {
                        this.f46093a.onSucceeded(new JSONObject((String) requestResponse.getResponseBody()).getString("chat_number"));
                    }
                } catch (JSONException unused) {
                }
            } else {
                Request.Callbacks callbacks = this.f46093a;
                callbacks.onFailed(new Throwable("Triggering chat got error with response code:" + requestResponse.getResponseCode()));
            }
        }
    }

    /* renamed from: a */
    public void onFailed(Throwable th2) {
        InstabugSDKLogger.e("IBG-BR", "triggeringChatRequest got error: " + th2.getMessage());
        this.f46093a.onFailed(th2);
    }
}
