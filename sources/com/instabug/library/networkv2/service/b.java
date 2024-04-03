package com.instabug.library.networkv2.service;

import com.instabug.library.core.InstabugCore;
import com.instabug.library.networkv2.RequestResponse;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.InstabugSDKLogger;

class b implements Request.Callbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Request.Callbacks f51663a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c f51664b;

    public b(c cVar, Request.Callbacks callbacks) {
        this.f51664b = cVar;
        this.f51663a = callbacks;
    }

    /* renamed from: a */
    public void onSucceeded(RequestResponse requestResponse) {
        if (requestResponse != null && this.f51664b.a(requestResponse) != null) {
            InstabugSDKLogger.d("IBG-Core", "getAppFeatures request completed");
            InstabugSDKLogger.v("IBG-Core", "getAppFeatures request completed, response: " + requestResponse.getResponseBody());
            this.f51663a.onSucceeded(this.f51664b.a(requestResponse));
        }
    }

    /* renamed from: a */
    public void onFailed(Throwable th2) {
        InstabugSDKLogger.e("IBG-Core", "getAppFeatures request got error: " + th2.getMessage());
        InstabugCore.reportError(th2, "Failed to cache features settings due to: " + th2.getMessage());
        this.f51663a.onFailed(th2);
    }
}
