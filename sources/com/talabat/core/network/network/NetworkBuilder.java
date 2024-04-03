package com.talabat.core.network.network;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/talabat/core/network/network/NetworkBuilder;", "", "()V", "Companion", "com_talabat_core_network_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NetworkBuilder {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J'\u0010\u0003\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00040\b¢\u0006\u0002\u0010\tJ/\u0010\u0003\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00040\b2\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/talabat/core/network/network/NetworkBuilder$Companion;", "", "()V", "getService", "T", "baseURL", "", "endPoint", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "okHttpClient", "Lokhttp3/OkHttpClient;", "(Ljava/lang/String;Ljava/lang/Class;Lokhttp3/OkHttpClient;)Ljava/lang/Object;", "com_talabat_core_network_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final <T> T getService(@NotNull String str, @NotNull Class<T> cls) {
            Intrinsics.checkNotNullParameter(str, "baseURL");
            Intrinsics.checkNotNullParameter(cls, "endPoint");
            return getService(str, cls, OKHttpBuilder.getDefaultHttpClient$default(OKHttpBuilder.INSTANCE, (List) null, 0, 3, (Object) null));
        }

        public final <T> T getService(@NotNull String str, @NotNull Class<T> cls, @NotNull OkHttpClient okHttpClient) {
            Intrinsics.checkNotNullParameter(str, "baseURL");
            Intrinsics.checkNotNullParameter(cls, "endPoint");
            Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
            return new Retrofit.Builder().baseUrl(str).client(okHttpClient).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build().create(cls);
        }
    }
}
