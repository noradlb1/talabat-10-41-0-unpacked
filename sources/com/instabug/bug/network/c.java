package com.instabug.bug.network;

import com.instabug.bug.model.d;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.networkv2.RequestResponse;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.InstabugSDKLogger;

class c implements Request.Callbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Request.Callbacks f45693a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d f45694b;

    public c(d dVar, Request.Callbacks callbacks, d dVar2) {
        this.f45693a = callbacks;
        this.f45694b = dVar2;
    }

    /* renamed from: a */
    public void onSucceeded(RequestResponse requestResponse) {
        InstabugSDKLogger.d("IBG-BR", "uploading bug logs succeeded, Response code: " + requestResponse.getResponseCode());
        InstabugSDKLogger.v("IBG-BR", "uploading bug logs onNext, Response body: " + requestResponse.getResponseBody());
        this.f45693a.onSucceeded(Boolean.TRUE);
    }

    /* renamed from: a */
    public void onFailed(Throwable th2) {
        InstabugCore.reportError(th2, "uploading bug logs got error: " + th2.getMessage());
        InstabugSDKLogger.e("IBG-BR", "uploading bug logs got error", th2);
        this.f45693a.onFailed(this.f45694b);
    }
}
