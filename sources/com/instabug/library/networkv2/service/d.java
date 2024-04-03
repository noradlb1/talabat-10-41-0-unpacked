package com.instabug.library.networkv2.service;

import com.instabug.library.model.AssetEntity;
import com.instabug.library.networkv2.RequestResponse;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.InstabugSDKLogger;

class d implements Request.Callbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Request.Callbacks f51670a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetEntity f51671b;

    public d(e eVar, Request.Callbacks callbacks, AssetEntity assetEntity) {
        this.f51670a = callbacks;
        this.f51671b = assetEntity;
    }

    /* renamed from: a */
    public void onSucceeded(RequestResponse requestResponse) {
        if (requestResponse != null) {
            InstabugSDKLogger.d("IBG-Core", "downloadFile request onNext, Response code: " + requestResponse.getResponseCode());
            InstabugSDKLogger.v("IBG-Core", "Response body: " + requestResponse.getResponseBody());
            this.f51670a.onSucceeded(this.f51671b);
        }
    }

    /* renamed from: a */
    public void onFailed(Throwable th2) {
        InstabugSDKLogger.e("IBG-Core", "downloadFile request got error: " + th2.getMessage());
        this.f51670a.onFailed(th2);
    }
}
