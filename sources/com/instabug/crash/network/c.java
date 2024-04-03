package com.instabug.crash.network;

import com.instabug.crash.models.a;
import com.instabug.library.networkv2.RequestResponse;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.InstabugSDKLogger;

class c implements Request.Callbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Request.Callbacks f46429a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f46430b;

    public c(d dVar, Request.Callbacks callbacks, a aVar) {
        this.f46429a = callbacks;
        this.f46430b = aVar;
    }

    /* renamed from: a */
    public void onSucceeded(RequestResponse requestResponse) {
        InstabugSDKLogger.d("IBG-CR", "Uploading crash logs succeeded, Response code: " + requestResponse.getResponseCode());
        InstabugSDKLogger.v("IBG-CR", "uploading crash logs onNext, Response body: " + requestResponse.getResponseBody());
        this.f46429a.onSucceeded(Boolean.TRUE);
    }

    /* renamed from: a */
    public void onFailed(Throwable th2) {
        InstabugSDKLogger.e("IBG-CR", "uploading crash logs got error: " + th2.getMessage());
        this.f46429a.onFailed(this.f46430b);
    }
}
