package com.instabug.chat.network.service;

import com.instabug.library.networkv2.RequestResponse;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.InstabugSDKLogger;

class f implements Request.Callbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Request.Callbacks f46102a;

    public f(g gVar, Request.Callbacks callbacks) {
        this.f46102a = callbacks;
    }

    /* renamed from: a */
    public void onSucceeded(RequestResponse requestResponse) {
        if (requestResponse != null) {
            InstabugSDKLogger.d("IBG-BR", "Sending push notification request Succeeded");
            if (requestResponse.getResponseCode() == 200) {
                this.f46102a.onSucceeded(Boolean.TRUE);
                return;
            }
            InstabugSDKLogger.e("IBG-BR", "sending push notification token got error with response code: " + requestResponse.getResponseCode());
        }
    }

    /* renamed from: a */
    public void onFailed(Throwable th2) {
        InstabugSDKLogger.e("IBG-BR", "sending push notification token got error: " + th2.getMessage());
    }
}
