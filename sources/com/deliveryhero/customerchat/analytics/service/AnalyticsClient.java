package com.deliveryhero.customerchat.analytics.service;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/deliveryhero/customerchat/analytics/service/AnalyticsClient;", "", "()V", "getClient", "Lretrofit2/Retrofit;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AnalyticsClient {
    @NotNull
    public static final AnalyticsClient INSTANCE = new AnalyticsClient();

    private AnalyticsClient() {
    }

    @NotNull
    public final Retrofit getClient() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        Retrofit build = new Retrofit.Builder().baseUrl(AnalyticsClientKt.DUMMY_URL).addConverterFactory(MoshiConverterFactory.create()).client(new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build()).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n            //…ent)\n            .build()");
        return build;
    }
}
