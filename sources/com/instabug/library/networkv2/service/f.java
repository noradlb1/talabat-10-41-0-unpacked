package com.instabug.library.networkv2.service;

import com.instabug.library.networkv2.RequestResponse;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.InstabugSDKLogger;

class f implements Request.Callbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Request.Callbacks f51674a;

    public f(g gVar, Request.Callbacks callbacks) {
        this.f51674a = callbacks;
    }

    /* renamed from: a */
    public void onSucceeded(RequestResponse requestResponse) {
        if (requestResponse != null && requestResponse.getResponseBody() != null) {
            InstabugSDKLogger.d("IBG-Core", "migrateUUID request Succeeded, Response code: " + requestResponse.getResponseCode());
            InstabugSDKLogger.v("IBG-Core", "Response body: " + requestResponse.getResponseBody());
            this.f51674a.onSucceeded((String) requestResponse.getResponseBody());
        }
    }

    /* renamed from: a */
    public void onFailed(Throwable th2) {
        InstabugSDKLogger.e("IBG-Core", "migrateUUID request got error: " + th2.getMessage(), th2);
        this.f51674a.onFailed(th2);
    }
}
