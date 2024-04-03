package com.huawei.agconnect.credential.obs;

import com.huawei.agconnect.AGConnectInstance;
import com.huawei.agconnect.core.service.auth.CredentialsProvider;
import com.huawei.agconnect.core.service.auth.Token;
import com.huawei.hmf.tasks.Task;
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
final class q implements Interceptor {

    /* renamed from: a  reason: collision with root package name */
    private AGConnectInstance f47609a;

    public q(AGConnectInstance aGConnectInstance) {
        this.f47609a = aGConnectInstance;
    }

    public Response intercept(Interceptor.Chain chain) {
        Task tokens = ((CredentialsProvider) this.f47609a.getService(CredentialsProvider.class)).getTokens();
        try {
            Request.Builder newBuilder = chain.request().newBuilder();
            Request.Builder addHeader = newBuilder.addHeader("Authorization", "Bearer " + ((Token) Tasks.await(tokens, 5, TimeUnit.SECONDS)).getTokenString());
            return chain.proceed(!(addHeader instanceof Request.Builder) ? addHeader.build() : OkHttp3Instrumentation.build(addHeader));
        } catch (InterruptedException | ExecutionException | TimeoutException e11) {
            throw new IOException(e11.getMessage());
        }
    }
}
