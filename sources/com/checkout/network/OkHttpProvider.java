package com.checkout.network;

import com.checkout.network.extension.OkHttpProviderExtensionKt;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/checkout/network/OkHttpProvider;", "", "()V", "createOkHttpClient", "Lokhttp3/OkHttpClient;", "publicKey", "", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class OkHttpProvider {
    @NotNull
    public static final OkHttpProvider INSTANCE = new OkHttpProvider();

    private OkHttpProvider() {
    }

    @NotNull
    public final OkHttpClient createOkHttpClient(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "publicKey");
        OkHttpClient.Builder retryOnConnectionFailure = new OkHttpClient.Builder().connectionSpecs(OkHttpProviderExtensionKt.buildConnectionSpecs()).retryOnConnectionFailure(true);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return OkHttpProviderExtensionKt.addRequestInterceptors(OkHttpProviderExtensionKt.addLocalInterceptors(retryOnConnectionFailure.connectTimeout(10000, timeUnit).callTimeout(10000, timeUnit).readTimeout(30000, timeUnit)), str).build();
    }
}
