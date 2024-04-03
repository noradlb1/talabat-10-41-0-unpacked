package com.talabat.darkstores.data.darkstores;

import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.okhttp3.OkHttp3Instrumentation;
import com.talabat.darkstores.common.helpers.Base64Helper;
import com.visa.checkout.Profile;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

@Instrumented
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/talabat/darkstores/data/darkstores/AuthHeaderInterceptor;", "Lokhttp3/Interceptor;", "apiKey", "", "base64Helper", "Lcom/talabat/darkstores/common/helpers/Base64Helper;", "(Ljava/lang/String;Lcom/talabat/darkstores/common/helpers/Base64Helper;)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AuthHeaderInterceptor implements Interceptor {
    @NotNull
    private final String apiKey;
    @NotNull
    private final Base64Helper base64Helper;

    @Inject
    public AuthHeaderInterceptor(@NotNull String str, @NotNull Base64Helper base64Helper2) {
        Intrinsics.checkNotNullParameter(str, Profile.API_KEY);
        Intrinsics.checkNotNullParameter(base64Helper2, "base64Helper");
        this.apiKey = str;
        this.base64Helper = base64Helper2;
    }

    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) {
        Request request;
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request.Builder header = chain.request().newBuilder().header("X-API-Key", Base64Helper.decodeFromBase64ToString$default(this.base64Helper, this.apiKey, 0, 2, (Object) null));
        if (!(header instanceof Request.Builder)) {
            request = header.build();
        } else {
            request = OkHttp3Instrumentation.build(header);
        }
        return chain.proceed(request);
    }
}
