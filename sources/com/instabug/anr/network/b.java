package com.instabug.anr.network;

import com.instabug.library.networkv2.RequestResponse;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.InstabugSDKLogger;

class b implements Request.Callbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Request.Callbacks f45078a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ com.instabug.anr.model.b f45079b;

    public b(d dVar, Request.Callbacks callbacks, com.instabug.anr.model.b bVar) {
        this.f45078a = callbacks;
        this.f45079b = bVar;
    }

    /* renamed from: a */
    public void onSucceeded(RequestResponse requestResponse) {
        InstabugSDKLogger.d("IBG-CR", "Uploading ANR logs succeeded, Response code: " + requestResponse.getResponseCode());
        InstabugSDKLogger.v("IBG-CR", "Uploading ANR logs succeeded,, Response body: " + requestResponse.getResponseBody());
        this.f45078a.onSucceeded(Boolean.TRUE);
    }

    /* renamed from: a */
    public void onFailed(Throwable th2) {
        InstabugSDKLogger.e("IBG-CR", "Uploading ANR logs got error: " + th2.getMessage());
        this.f45078a.onFailed(this.f45079b);
    }
}
