package com.talabat.core.network.midas;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/talabat/core/network/midas/MidasHttpInterceptor;", "Lokhttp3/Interceptor;", "()V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "com_talabat_core_network_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MidasHttpInterceptor implements Interceptor {
    @NotNull
    public static final MidasHttpInterceptor INSTANCE = new MidasHttpInterceptor();

    private MidasHttpInterceptor() {
    }

    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Response proceed = chain.proceed(chain.request());
        String access$readResponseAsString = MidasHttpInterceptorKt.readResponseAsString(proceed);
        if (access$readResponseAsString != null) {
            MidasHttpInterceptorKt.updateMidasRequestId(access$readResponseAsString);
        }
        return proceed;
    }
}
