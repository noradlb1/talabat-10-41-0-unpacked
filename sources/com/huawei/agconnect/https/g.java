package com.huawei.agconnect.https;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

class g implements Interceptor {

    /* renamed from: a  reason: collision with root package name */
    private int f47659a;

    /* renamed from: b  reason: collision with root package name */
    private int f47660b;

    public g(int i11) {
        this.f47659a = i11;
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        Response proceed;
        int i11;
        Request request = chain.request();
        while (true) {
            proceed = chain.proceed(request);
            if (proceed.isSuccessful() || (i11 = this.f47660b) >= this.f47659a) {
                return proceed;
            }
            this.f47660b = i11 + 1;
        }
        return proceed;
    }
}
