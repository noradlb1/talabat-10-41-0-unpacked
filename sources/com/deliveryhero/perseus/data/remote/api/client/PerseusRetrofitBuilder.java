package com.deliveryhero.perseus.data.remote.api.client;

import com.deliveryhero.perseus.PerseusParamsConfig;
import com.deliveryhero.perseus.core.config.PerseusConfigProvider;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Collection;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010H\u0002R\u0014\u0010\b\u001a\u00020\t8BX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/deliveryhero/perseus/data/remote/api/client/PerseusRetrofitBuilder;", "", "configProvider", "Lcom/deliveryhero/perseus/core/config/PerseusConfigProvider;", "interceptors", "", "Lokhttp3/Interceptor;", "(Lcom/deliveryhero/perseus/core/config/PerseusConfigProvider;Ljava/util/Set;)V", "config", "Lcom/deliveryhero/perseus/PerseusParamsConfig;", "getConfig", "()Lcom/deliveryhero/perseus/PerseusParamsConfig;", "build", "Lretrofit2/Retrofit;", "createHttpClient", "Lokhttp3/OkHttpClient;", "", "Companion", "perseus_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PerseusRetrofitBuilder {
    @NotNull
    public static final String BASE_URL = "https://perseus-productanalytics.deliveryhero.net";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String DATE_FORMAT_DATE_TIME = "yyyy-MM-dd HH:mm:ss";
    @NotNull
    public static final String DEBUG_BASE_URL = "https://perseus-stg.deliveryhero.net";
    @NotNull
    private final PerseusConfigProvider configProvider;
    @NotNull
    private final Set<Interceptor> interceptors;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/deliveryhero/perseus/data/remote/api/client/PerseusRetrofitBuilder$Companion;", "", "()V", "BASE_URL", "", "DATE_FORMAT_DATE_TIME", "DEBUG_BASE_URL", "perseus_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public PerseusRetrofitBuilder(@NotNull PerseusConfigProvider perseusConfigProvider, @NotNull Set<? extends Interceptor> set) {
        Intrinsics.checkNotNullParameter(perseusConfigProvider, "configProvider");
        Intrinsics.checkNotNullParameter(set, "interceptors");
        this.configProvider = perseusConfigProvider;
        this.interceptors = set;
    }

    private final OkHttpClient createHttpClient(Collection<? extends Interceptor> collection) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        for (Interceptor addInterceptor : collection) {
            builder.addInterceptor(addInterceptor);
        }
        return builder.build();
    }

    private final PerseusParamsConfig getConfig() {
        return this.configProvider.provideConfig();
    }

    @NotNull
    public final Retrofit build() {
        boolean z11;
        String str;
        Gson create = new GsonBuilder().setDateFormat(DATE_FORMAT_DATE_TIME).create();
        String baseUrlOverride = getConfig().getBaseUrlOverride();
        if (baseUrlOverride == null || baseUrlOverride.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            str = getConfig().getBaseUrlOverride();
        } else if (getConfig().getDebuggable()) {
            str = DEBUG_BASE_URL;
        } else {
            str = BASE_URL;
        }
        Retrofit.Builder builder = new Retrofit.Builder();
        Intrinsics.checkNotNull(str);
        Retrofit build = builder.baseUrl(str).client(createHttpClient(this.interceptors)).addConverterFactory(GsonConverterFactory.create(create)).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n            .b…e())\n            .build()");
        return build;
    }
}
