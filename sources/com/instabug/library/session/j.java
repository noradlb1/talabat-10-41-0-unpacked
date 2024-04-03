package com.instabug.library.session;

import com.instabug.library.networkv2.RequestResponse;
import com.instabug.library.networkv2.request.Request;

class j implements Request.Callbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Request.Callbacks f51750a;

    public j(k kVar, Request.Callbacks callbacks) {
        this.f51750a = callbacks;
    }

    /* renamed from: a */
    public void onSucceeded(RequestResponse requestResponse) {
        this.f51750a.onSucceeded(requestResponse);
    }

    /* renamed from: a */
    public void onFailed(Throwable th2) {
        this.f51750a.onFailed(th2);
    }
}
