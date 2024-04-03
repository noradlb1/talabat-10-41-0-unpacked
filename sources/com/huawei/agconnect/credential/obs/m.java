package com.huawei.agconnect.credential.obs;

import com.huawei.agconnect.AGConnectInstance;
import com.huawei.agconnect.core.service.auth.AuthProvider;
import com.huawei.agconnect.core.service.auth.Token;
import com.huawei.hmf.tasks.Tasks;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.okhttp3.OkHttp3Instrumentation;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

@Instrumented
final class m implements Interceptor {

    /* renamed from: a  reason: collision with root package name */
    private AGConnectInstance f47592a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f47593b;

    public m(AGConnectInstance aGConnectInstance, boolean z11) {
        this.f47592a = aGConnectInstance;
        this.f47593b = z11;
    }

    public Response intercept(Interceptor.Chain chain) {
        Class cls = AuthProvider.class;
        if (((AuthProvider) this.f47592a.getService(cls)) != null) {
            try {
                Token token = (Token) Tasks.await(((AuthProvider) this.f47592a.getService(cls)).getTokens(), 5, TimeUnit.SECONDS);
                if (token != null) {
                    Request.Builder addHeader = chain.request().newBuilder().addHeader("access_token", token.getTokenString());
                    return chain.proceed(!(addHeader instanceof Request.Builder) ? addHeader.build() : OkHttp3Instrumentation.build(addHeader));
                } else if (!this.f47593b) {
                    return chain.proceed(chain.request());
                } else {
                    throw new IOException("no user is signed");
                }
            } catch (InterruptedException | ExecutionException | TimeoutException e11) {
                throw new IOException(e11.getMessage());
            }
        } else if (!this.f47593b) {
            return chain.proceed(chain.request());
        } else {
            throw new IOException("Please intergrate agconnect-auth in project");
        }
    }
}
