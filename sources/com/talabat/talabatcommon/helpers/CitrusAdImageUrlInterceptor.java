package com.talabat.talabatcommon.helpers;

import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.okhttp3.OkHttp3Instrumentation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

@Instrumented
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/talabat/talabatcommon/helpers/CitrusAdImageUrlInterceptor;", "Lokhttp3/Interceptor;", "()V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CitrusAdImageUrlInterceptor implements Interceptor {
    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) {
        Request request;
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request2 = chain.request();
        if (!StringsKt__StringsKt.contains$default((CharSequence) request2.url().host(), (CharSequence) "flavedo.io", false, 2, (Object) null)) {
            return chain.proceed(request2);
        }
        Request.Builder removeHeader = chain.request().newBuilder().removeHeader("Authorization");
        if (!(removeHeader instanceof Request.Builder)) {
            request = removeHeader.build();
        } else {
            request = OkHttp3Instrumentation.build(removeHeader);
        }
        return chain.proceed(request);
    }
}
