package com.instabug.chat.network.service;

import com.instabug.chat.model.d;
import com.instabug.library.networkv2.RequestResponse;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.InstabugSDKLogger;

class e implements Request.Callbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Request.Callbacks f46100a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d f46101b;

    public e(g gVar, Request.Callbacks callbacks, d dVar) {
        this.f46100a = callbacks;
        this.f46101b = dVar;
    }

    /* renamed from: a */
    public void onSucceeded(RequestResponse requestResponse) {
        InstabugSDKLogger.d("IBG-BR", "uploading chat logs onNext, Response code: " + requestResponse.getResponseCode());
        InstabugSDKLogger.v("IBG-BR", "uploading chat logs onNext, Response body: " + requestResponse.getResponseBody());
    }

    /* renamed from: a */
    public void onFailed(Throwable th2) {
        InstabugSDKLogger.d("IBG-BR", "uploading chat logs got error: " + th2.getMessage());
        this.f46100a.onFailed(this.f46101b);
    }
}
