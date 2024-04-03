package com.deliveryhero.chatsdk.provider;

import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.okhttp3.OkHttp3Instrumentation;
import com.squareup.moshi.Moshi;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.jetbrains.annotations.NotNull;
import org.koin.core.module.Module;
import org.koin.dsl.ModuleKt;

@Instrumented
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/deliveryhero/chatsdk/provider/Provider;", "", "()V", "client", "Lokhttp3/OkHttpClient;", "getClient", "()Lokhttp3/OkHttpClient;", "client$delegate", "Lkotlin/Lazy;", "networkModule", "Lorg/koin/core/module/Module;", "getNetworkModule", "()Lorg/koin/core/module/Module;", "provideMoshi", "Lcom/squareup/moshi/Moshi;", "provideRequest", "Lokhttp3/Request;", "baseUrl", "", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Provider {
    @NotNull
    public static final Provider INSTANCE = new Provider();
    @NotNull
    private static final Lazy client$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, Provider$client$2.INSTANCE);
    @NotNull
    private static final Module networkModule = ModuleKt.module$default(false, Provider$networkModule$1.INSTANCE, 1, (Object) null);

    private Provider() {
    }

    /* access modifiers changed from: private */
    public final OkHttpClient getClient() {
        Object value = client$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-client>(...)");
        return (OkHttpClient) value;
    }

    @NotNull
    public final Module getNetworkModule() {
        return networkModule;
    }

    @NotNull
    public final Moshi provideMoshi() {
        return RetrofitBuilderKt.getMoshi();
    }

    @NotNull
    public final Request provideRequest(@NotNull String str) {
        Request request;
        Intrinsics.checkNotNullParameter(str, "baseUrl");
        Request.Builder url = new Request.Builder().url(str);
        if (!(url instanceof Request.Builder)) {
            request = url.build();
        } else {
            request = OkHttp3Instrumentation.build(url);
        }
        Intrinsics.checkNotNullExpressionValue(request, "Builder()\n            .u…Url)\n            .build()");
        return request;
    }
}
