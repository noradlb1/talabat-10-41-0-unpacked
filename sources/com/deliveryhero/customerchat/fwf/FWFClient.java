package com.deliveryhero.customerchat.fwf;

import com.deliveryhero.customerchat.configuration.ChatConfigProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f¨\u0006\r"}, d2 = {"Lcom/deliveryhero/customerchat/fwf/FWFClient;", "", "()V", "build", "Lretrofit2/Retrofit;", "baseUrl", "", "chatConfigProvider", "Lcom/deliveryhero/customerchat/configuration/ChatConfigProvider;", "baseClient", "Lokhttp3/OkHttpClient;", "moshiConverterFactory", "Lretrofit2/converter/moshi/MoshiConverterFactory;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FWFClient {
    @NotNull
    public static final FWFClient INSTANCE = new FWFClient();

    private FWFClient() {
    }

    public static /* synthetic */ Retrofit build$default(FWFClient fWFClient, String str, ChatConfigProvider chatConfigProvider, OkHttpClient okHttpClient, MoshiConverterFactory moshiConverterFactory, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            okHttpClient = new OkHttpClient();
        }
        if ((i11 & 8) != 0) {
            moshiConverterFactory = MoshiConverterFactory.create();
            Intrinsics.checkNotNullExpressionValue(moshiConverterFactory, "create()");
        }
        return fWFClient.build(str, chatConfigProvider, okHttpClient, moshiConverterFactory);
    }

    @NotNull
    public final Retrofit build(@NotNull String str, @NotNull ChatConfigProvider chatConfigProvider, @NotNull OkHttpClient okHttpClient, @NotNull MoshiConverterFactory moshiConverterFactory) {
        Intrinsics.checkNotNullParameter(str, "baseUrl");
        Intrinsics.checkNotNullParameter(chatConfigProvider, "chatConfigProvider");
        Intrinsics.checkNotNullParameter(okHttpClient, "baseClient");
        Intrinsics.checkNotNullParameter(moshiConverterFactory, "moshiConverterFactory");
        Retrofit build = new Retrofit.Builder().baseUrl(str).client(okHttpClient.newBuilder().addInterceptor(new FwFHttpAuthInterceptor(chatConfigProvider)).build()).addConverterFactory(moshiConverterFactory).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n            .b…ory)\n            .build()");
        return build;
    }
}
