package com.talabat.core.network.network;

import android.util.Base64;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.okhttp3.OkHttp3Instrumentation;
import com.talabat.core.network.di.KeyValueHeaderKey;
import com.talabat.core.network.di.KeyValueHeaderValue;
import com.talabat.core.network.di.KeyValueHeaderValueShouldBase64Decoded;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

@Instrumented
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/talabat/core/network/network/KeyValueHeaderInterceptor;", "Lokhttp3/Interceptor;", "key", "", "value", "shouldBase64Decoded", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "com_talabat_core_network_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class KeyValueHeaderInterceptor implements Interceptor {
    @NotNull
    private final String key;
    private final boolean shouldBase64Decoded;
    @NotNull
    private final String value;

    @Inject
    public KeyValueHeaderInterceptor(@NotNull @KeyValueHeaderKey String str, @NotNull @KeyValueHeaderValue String str2, @KeyValueHeaderValueShouldBase64Decoded boolean z11) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "value");
        this.key = str;
        this.value = str2;
        this.shouldBase64Decoded = z11;
    }

    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) {
        String str;
        Request request;
        Intrinsics.checkNotNullParameter(chain, "chain");
        if (this.shouldBase64Decoded) {
            byte[] decode = Base64.decode(this.value, 0);
            Intrinsics.checkNotNullExpressionValue(decode, "decode(value, Base64.DEFAULT)");
            str = new String(decode, Charsets.UTF_8);
        } else {
            str = this.value;
        }
        Request.Builder header = chain.request().newBuilder().header(this.key, str);
        if (!(header instanceof Request.Builder)) {
            request = header.build();
        } else {
            request = OkHttp3Instrumentation.build(header);
        }
        return chain.proceed(request);
    }
}
