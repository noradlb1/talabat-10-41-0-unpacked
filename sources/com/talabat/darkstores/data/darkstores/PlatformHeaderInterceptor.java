package com.talabat.darkstores.data.darkstores;

import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.okhttp3.OkHttp3Instrumentation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

@Instrumented
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/talabat/darkstores/data/darkstores/PlatformHeaderInterceptor;", "Lokhttp3/Interceptor;", "()V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PlatformHeaderInterceptor implements Interceptor {
    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) {
        Request request;
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request.Builder header = chain.request().newBuilder().header("X-Platform", "android");
        if (!(header instanceof Request.Builder)) {
            request = header.build();
        } else {
            request = OkHttp3Instrumentation.build(header);
        }
        return chain.proceed(request);
    }
}
