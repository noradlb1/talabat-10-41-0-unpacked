package com.talabat.feature.pickup.data.di;

import com.talabat.core.network.domain.GsonRetrofit;
import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import com.talabat.feature.pickup.data.PickupApi;
import com.talabat.feature.pickup.data.PickupBaseUrl;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\"\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u000e\u001a\u00020\u000fH\u0007¨\u0006\u0010"}, d2 = {"Lcom/talabat/feature/pickup/data/di/PickupNetworkModule;", "", "()V", "provideBaseUrl", "", "baseUrlFactory", "Lcom/talabat/core/network/domain/endpoint/BaseUrlFactory;", "pickupBaseUrl", "Lcom/talabat/feature/pickup/data/PickupBaseUrl;", "providePickupApi", "Lcom/talabat/feature/pickup/data/PickupApi;", "baseUrl", "okHttpClient", "Lokhttp3/OkHttpClient;", "retrofitBuilder", "Lretrofit2/Retrofit$Builder;", "com_talabat_feature_pickup_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class PickupNetworkModule {
    @NotNull
    public static final PickupNetworkModule INSTANCE = new PickupNetworkModule();

    private PickupNetworkModule() {
    }

    @NotNull
    @Provides
    public final String provideBaseUrl(@NotNull BaseUrlFactory baseUrlFactory, @NotNull PickupBaseUrl pickupBaseUrl) {
        Intrinsics.checkNotNullParameter(baseUrlFactory, "baseUrlFactory");
        Intrinsics.checkNotNullParameter(pickupBaseUrl, "pickupBaseUrl");
        return baseUrlFactory.baseUrl(pickupBaseUrl);
    }

    @NotNull
    @Provides
    public final PickupApi providePickupApi(@NotNull String str, @NotNull OkHttpClient okHttpClient, @NotNull @GsonRetrofit Retrofit.Builder builder) {
        Intrinsics.checkNotNullParameter(str, "baseUrl");
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Intrinsics.checkNotNullParameter(builder, "retrofitBuilder");
        Retrofit build = builder.client(okHttpClient.newBuilder().build()).baseUrl(str).build();
        Intrinsics.checkNotNullExpressionValue(build, "okHttpClient.newBuilder(…   .build()\n            }");
        return (PickupApi) build.create(PickupApi.class);
    }
}
