package com.huawei.agconnect.https;

import okhttp3.Request;

class f<HttpsRequest> {

    /* renamed from: a  reason: collision with root package name */
    private HttpsRequest f47658a;

    private f(HttpsRequest httpsrequest) {
        this.f47658a = httpsrequest;
    }

    public static <HttpsRequest> f a(HttpsRequest httpsrequest) {
        return new f(httpsrequest);
    }

    public Request.Builder a() {
        return a.a(this.f47658a);
    }
}
