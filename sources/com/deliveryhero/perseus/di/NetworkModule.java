package com.deliveryhero.perseus.di;

import com.deliveryhero.perseus.PerseusApp;
import com.deliveryhero.perseus.data.remote.api.PerseusHitsApi;
import com.deliveryhero.perseus.data.remote.api.PerseusLoggerApi;
import com.deliveryhero.perseus.data.remote.api.client.PerseusRetrofitBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/deliveryhero/perseus/di/NetworkModule;", "", "()V", "perseusHitsApi", "Lcom/deliveryhero/perseus/data/remote/api/PerseusHitsApi;", "getPerseusHitsApi", "()Lcom/deliveryhero/perseus/data/remote/api/PerseusHitsApi;", "setPerseusHitsApi", "(Lcom/deliveryhero/perseus/data/remote/api/PerseusHitsApi;)V", "perseusLoggerApi", "Lcom/deliveryhero/perseus/data/remote/api/PerseusLoggerApi;", "getPerseusLoggerApi", "()Lcom/deliveryhero/perseus/data/remote/api/PerseusLoggerApi;", "setPerseusLoggerApi", "(Lcom/deliveryhero/perseus/data/remote/api/PerseusLoggerApi;)V", "retrofit", "Lretrofit2/Retrofit;", "perseus_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class NetworkModule {
    @NotNull
    public static final NetworkModule INSTANCE = new NetworkModule();
    @NotNull
    private static PerseusHitsApi perseusHitsApi;
    @NotNull
    private static PerseusLoggerApi perseusLoggerApi;
    @NotNull
    private static final Retrofit retrofit;

    static {
        Retrofit build = new PerseusRetrofitBuilder(CoreModule.INSTANCE.getPerseusConfigProvider(), PerseusApp.INSTANCE.getInterceptors$perseus_release()).build();
        retrofit = build;
        Object create = build.create(PerseusLoggerApi.class);
        Intrinsics.checkNotNullExpressionValue(create, "retrofit.create(PerseusLoggerApi::class.java)");
        perseusLoggerApi = (PerseusLoggerApi) create;
        Object create2 = build.create(PerseusHitsApi.class);
        Intrinsics.checkNotNullExpressionValue(create2, "retrofit.create(PerseusHitsApi::class.java)");
        perseusHitsApi = (PerseusHitsApi) create2;
    }

    private NetworkModule() {
    }

    @NotNull
    public final PerseusHitsApi getPerseusHitsApi() {
        return perseusHitsApi;
    }

    @NotNull
    public final PerseusLoggerApi getPerseusLoggerApi() {
        return perseusLoggerApi;
    }

    public final void setPerseusHitsApi(@NotNull PerseusHitsApi perseusHitsApi2) {
        Intrinsics.checkNotNullParameter(perseusHitsApi2, "<set-?>");
        perseusHitsApi = perseusHitsApi2;
    }

    public final void setPerseusLoggerApi(@NotNull PerseusLoggerApi perseusLoggerApi2) {
        Intrinsics.checkNotNullParameter(perseusLoggerApi2, "<set-?>");
        perseusLoggerApi = perseusLoggerApi2;
    }
}
