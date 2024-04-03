package com.instabug.chat.network.service;

import com.instabug.library.networkv2.RequestResponse;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.InstabugSDKLogger;

class d implements Request.Callbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Request.Callbacks f46099a;

    public d(g gVar, Request.Callbacks callbacks) {
        this.f46099a = callbacks;
    }

    /* renamed from: a */
    public void onSucceeded(RequestResponse requestResponse) {
        InstabugSDKLogger.d("IBG-BR", "syncMessages request Succeeded, Response code: " + requestResponse.getResponseCode());
        InstabugSDKLogger.v("IBG-BR", "syncMessages request Succeeded, Response body: " + requestResponse.getResponseBody());
        this.f46099a.onSucceeded(requestResponse);
    }

    /* renamed from: a */
    public void onFailed(Throwable th2) {
        InstabugSDKLogger.v("IBG-BR", "syncMessages request got error: " + th2.getMessage());
        this.f46099a.onFailed(th2);
    }
}
