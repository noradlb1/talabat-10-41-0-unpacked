package com.huawei.agconnect.credential.obs;

import android.text.TextUtils;
import com.huawei.agconnect.common.api.BackendService;
import com.huawei.agconnect.credential.Server;
import com.newrelic.agent.android.instrumentation.Instrumented;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.List;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

@Instrumented
final class u implements Interceptor {

    /* renamed from: a  reason: collision with root package name */
    private List<r> f47616a;

    public u(BackendService.Options options) {
        this.f47616a = l.a().a(options.getApp());
    }

    public u(String str, String str2) {
        this.f47616a = Collections.singletonList(new r(str, str2));
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x006a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private okhttp3.Response a(okhttp3.Interceptor.Chain r8, java.lang.String r9) {
        /*
            r7 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r9)
            r1 = 0
            if (r0 == 0) goto L_0x0008
            return r1
        L_0x0008:
            okhttp3.Request r0 = r8.request()
            java.lang.String r2 = ":"
            java.lang.String[] r2 = r9.split(r2)
            int r3 = r2.length
            r4 = 2
            java.lang.String r5 = "UrlInterceptorV2"
            r6 = 443(0x1bb, float:6.21E-43)
            if (r3 != r4) goto L_0x003e
            r3 = 1
            r3 = r2[r3]     // Catch:{ NumberFormatException -> 0x0025 }
            int r6 = java.lang.Integer.parseInt(r3)     // Catch:{ NumberFormatException -> 0x0025 }
            r3 = 0
            r2 = r2[r3]     // Catch:{ NumberFormatException -> 0x0025 }
            goto L_0x003f
        L_0x0025:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "port is error:"
            r2.append(r3)
            r2.append(r6)
            java.lang.String r3 = ", use default 443"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.huawei.agconnect.common.api.Logger.e(r5, r2)
        L_0x003e:
            r2 = r9
        L_0x003f:
            okhttp3.HttpUrl r3 = r0.url()
            okhttp3.HttpUrl$Builder r3 = r3.newBuilder()
            java.lang.String r4 = "https"
            okhttp3.HttpUrl$Builder r3 = r3.scheme(r4)
            okhttp3.HttpUrl$Builder r2 = r3.host(r2)
            okhttp3.HttpUrl$Builder r2 = r2.port(r6)
            okhttp3.HttpUrl r2 = r2.build()
            okhttp3.Request$Builder r0 = r0.newBuilder()
            okhttp3.Request$Builder r0 = r0.url((okhttp3.HttpUrl) r2)
            boolean r2 = r0 instanceof okhttp3.Request.Builder
            if (r2 != 0) goto L_0x006a
            okhttp3.Request r0 = r0.build()
            goto L_0x006e
        L_0x006a:
            okhttp3.Request r0 = com.newrelic.agent.android.instrumentation.okhttp3.OkHttp3Instrumentation.build(r0)
        L_0x006e:
            okhttp3.Response r8 = r8.proceed(r0)     // Catch:{ IOException -> 0x0073 }
            return r8
        L_0x0073:
            r8 = move-exception
            boolean r0 = r8 instanceof java.net.UnknownHostException
            if (r0 == 0) goto L_0x008d
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "UnknownHostException"
            r8.append(r0)
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            com.huawei.agconnect.common.api.Logger.e(r5, r8)
            return r1
        L_0x008d:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.agconnect.credential.obs.u.a(okhttp3.Interceptor$Chain, java.lang.String):okhttp3.Response");
    }

    public Response intercept(Interceptor.Chain chain) {
        Request request = chain.request();
        l.a().a(request.header("sdkServiceName"));
        if (!Server.GW.equals(request.url().scheme() + "://" + request.url().host()) || this.f47616a.isEmpty()) {
            return chain.proceed(request);
        }
        UnknownHostException unknownHostException = null;
        int i11 = 0;
        UnknownHostException unknownHostException2 = null;
        Response response = null;
        while (true) {
            if (i11 >= this.f47616a.size()) {
                unknownHostException = unknownHostException2;
                break;
            }
            r rVar = this.f47616a.get(i11);
            if (TextUtils.isEmpty(rVar.d())) {
                String a11 = rVar.a();
                String b11 = rVar.b();
                Response a12 = a(chain, a11);
                if (a12 == null) {
                    response = a(chain, b11);
                    if (response != null) {
                        rVar.a(b11, true);
                        break;
                    }
                    unknownHostException2 = new UnknownHostException("no host can access");
                    i11++;
                } else {
                    rVar.a(a11, false);
                    response = a12;
                    break;
                }
            } else {
                return a(chain, rVar.c());
            }
        }
        if (unknownHostException == null) {
            return response;
        }
        throw unknownHostException;
    }
}
