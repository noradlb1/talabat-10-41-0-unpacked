package com.talabat.core.network.network;

import com.talabat.core.network.endpoint.MonolithEndPointProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0003\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0006¢\u0006\u0002\u0010\u0007J'\u0010\u0003\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u00042\u0006\u0010\b\u001a\u00020\t2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0006¢\u0006\u0002\u0010\nJ/\u0010\u0003\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u00042\u0006\u0010\b\u001a\u00020\t2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00062\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/talabat/core/network/network/TalabatAPIBuilder;", "", "()V", "createApi", "T", "endPoint", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "baseUrl", "", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "okHttpClient", "Lokhttp3/OkHttpClient;", "(Ljava/lang/String;Ljava/lang/Class;Lokhttp3/OkHttpClient;)Ljava/lang/Object;", "com_talabat_core_network_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TalabatAPIBuilder {
    public final <T> T createApi(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "endPoint");
        return NetworkBuilder.Companion.getService(MonolithEndPointProvider.INSTANCE.getBaseUrl(), cls);
    }

    public final <T> T createApi(@NotNull String str, @NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(str, "baseUrl");
        Intrinsics.checkNotNullParameter(cls, "endPoint");
        return NetworkBuilder.Companion.getService(str, cls);
    }

    public final <T> T createApi(@NotNull String str, @NotNull Class<T> cls, @NotNull OkHttpClient okHttpClient) {
        Intrinsics.checkNotNullParameter(str, "baseUrl");
        Intrinsics.checkNotNullParameter(cls, "endPoint");
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        return NetworkBuilder.Companion.getService(str, cls, okHttpClient);
    }
}
