package com.instabug.featuresrequest.network.service;

import com.instabug.library.networkv2.RequestResponse;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.InstabugSDKLogger;

class a implements Request.Callbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Request.Callbacks f46571a;

    public a(b bVar, Request.Callbacks callbacks) {
        this.f46571a = callbacks;
    }

    /* renamed from: a */
    public void onSucceeded(RequestResponse requestResponse) {
        Request.Callbacks callbacks;
        Boolean bool;
        InstabugSDKLogger.d("IBG-FR", "sendFeatureRequest request Succeeded, Response code: " + requestResponse.getResponseCode());
        InstabugSDKLogger.v("IBG-FR", "Sending feature request Response body: " + requestResponse.getResponseBody());
        if (requestResponse.getResponseCode() != 200 || requestResponse.getResponseBody() == null) {
            callbacks = this.f46571a;
            bool = Boolean.FALSE;
        } else {
            callbacks = this.f46571a;
            bool = Boolean.TRUE;
        }
        callbacks.onSucceeded(bool);
    }

    /* renamed from: a */
    public void onFailed(Throwable th2) {
        InstabugSDKLogger.e("IBG-FR", "sendFeatureRequest request got error: ", th2);
        this.f46571a.onFailed(th2);
    }
}
