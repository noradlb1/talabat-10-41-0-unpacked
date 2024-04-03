package com.huawei.agconnect.credential.obs;

import com.huawei.agconnect.AGConnectInstance;
import com.huawei.agconnect.common.api.BackendService;
import com.huawei.agconnect.common.api.BaseResponse;
import com.huawei.agconnect.common.api.Logger;
import com.huawei.agconnect.core.service.auth.AuthProvider;
import com.huawei.agconnect.core.service.auth.CredentialsProvider;
import com.huawei.agconnect.core.service.auth.Token;
import com.huawei.agconnect.https.adapter.JsonAdapterFactory;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.Tasks;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.okhttp3.OkHttp3Instrumentation;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import okhttp3.Authenticator;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

@Instrumented
final class k implements Authenticator {

    /* renamed from: a  reason: collision with root package name */
    private AGConnectInstance f47580a;

    /* renamed from: b  reason: collision with root package name */
    private BackendService.Options f47581b;

    public k(BackendService.Options options) {
        this.f47580a = options.getApp();
        this.f47581b = options;
    }

    public Request authenticate(Route route, Response response) {
        Logger.i("AGCAuthenticator", "authenticate");
        BaseResponse adapter = new JsonAdapterFactory().responseBodyAdapter(BaseResponse.class).adapter(response.body());
        Request.Builder newBuilder = response.request().newBuilder();
        boolean z11 = false;
        if (adapter != null) {
            int code = adapter.getRet().getCode();
            if (code == 205524993 && !this.f47581b.isClientTokenRefreshed()) {
                this.f47581b.setClientTokenRefreshed(true);
                try {
                    String tokenString = ((Token) Tasks.await(((CredentialsProvider) this.f47580a.getService(CredentialsProvider.class)).getTokens(true), 3, TimeUnit.SECONDS)).getTokenString();
                    newBuilder.removeHeader("Authorization");
                    newBuilder.addHeader("Authorization", "Bearer " + tokenString);
                    z11 = true;
                } catch (InterruptedException | ExecutionException | TimeoutException e11) {
                    throw new IOException(e11.getMessage());
                }
            }
            if (code == 205524994 && !this.f47581b.isAccessTokenRefreshed()) {
                Class cls = AuthProvider.class;
                if (((AuthProvider) this.f47580a.getService(cls)) != null) {
                    this.f47581b.setAccessTokenRefreshed(true);
                    Task tokens = ((AuthProvider) this.f47580a.getService(cls)).getTokens(true);
                    try {
                        newBuilder.removeHeader("access_token");
                        newBuilder.addHeader("access_token", ((Token) Tasks.await(tokens, 3, TimeUnit.SECONDS)).getTokenString());
                        z11 = true;
                    } catch (InterruptedException | ExecutionException | TimeoutException e12) {
                        throw new IOException(e12.getMessage());
                    }
                } else {
                    throw new IOException("Please intergrate agconnect-auth in project");
                }
            }
        }
        if (z11) {
            return !(newBuilder instanceof Request.Builder) ? newBuilder.build() : OkHttp3Instrumentation.build(newBuilder);
        }
        return null;
    }
}
