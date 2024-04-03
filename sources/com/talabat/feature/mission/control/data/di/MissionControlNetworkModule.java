package com.talabat.feature.mission.control.data.di;

import com.talabat.core.network.domain.MoshiRetrofit;
import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import com.talabat.feature.mission.control.data.remote.GroceryBaseUrl;
import com.talabat.feature.mission.control.data.remote.LifeStyleMissionControlApi;
import com.talabat.feature.mission.control.data.remote.PrimaryMissionControlApi;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\u000bH\u0007J$\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\u000bH\u0007J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u0011H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/talabat/feature/mission/control/data/di/MissionControlNetworkModule;", "", "()V", "QCOMMERCE_GROCERY_BASE_URL", "", "provideLifeStyleMissionControlApi", "Lcom/talabat/feature/mission/control/data/remote/LifeStyleMissionControlApi;", "baseUrl", "okHttpClient", "Lokhttp3/OkHttpClient;", "retrofitBuilder", "Lretrofit2/Retrofit$Builder;", "providePrimaryMissionControlApi", "Lcom/talabat/feature/mission/control/data/remote/PrimaryMissionControlApi;", "provideQCommerceGroceryBaseUrl", "baseUrlFactory", "Lcom/talabat/core/network/domain/endpoint/BaseUrlFactory;", "Lcom/talabat/feature/mission/control/data/remote/GroceryBaseUrl;", "com_talabat_feature_mission-control_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class MissionControlNetworkModule {
    @NotNull
    public static final MissionControlNetworkModule INSTANCE = new MissionControlNetworkModule();
    @NotNull
    private static final String QCOMMERCE_GROCERY_BASE_URL = "qcommerceGroceryBaseUrl";

    private MissionControlNetworkModule() {
    }

    @NotNull
    @Provides
    public final LifeStyleMissionControlApi provideLifeStyleMissionControlApi(@NotNull @Named("qcommerceGroceryBaseUrl") String str, @NotNull OkHttpClient okHttpClient, @NotNull @MoshiRetrofit Retrofit.Builder builder) {
        Intrinsics.checkNotNullParameter(str, "baseUrl");
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Intrinsics.checkNotNullParameter(builder, "retrofitBuilder");
        Retrofit build = builder.client(okHttpClient).baseUrl(str).build();
        Intrinsics.checkNotNullExpressionValue(build, "retrofitBuilder\n        …Url)\n            .build()");
        return (LifeStyleMissionControlApi) build.create(LifeStyleMissionControlApi.class);
    }

    @NotNull
    @Provides
    public final PrimaryMissionControlApi providePrimaryMissionControlApi(@NotNull @Named("qcommerceGroceryBaseUrl") String str, @NotNull OkHttpClient okHttpClient, @NotNull @MoshiRetrofit Retrofit.Builder builder) {
        Intrinsics.checkNotNullParameter(str, "baseUrl");
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Intrinsics.checkNotNullParameter(builder, "retrofitBuilder");
        Retrofit build = builder.client(okHttpClient).baseUrl(str).build();
        Intrinsics.checkNotNullExpressionValue(build, "retrofitBuilder\n        …Url)\n            .build()");
        return (PrimaryMissionControlApi) build.create(PrimaryMissionControlApi.class);
    }

    @NotNull
    @Provides
    @Named("qcommerceGroceryBaseUrl")
    public final String provideQCommerceGroceryBaseUrl(@NotNull BaseUrlFactory baseUrlFactory, @NotNull GroceryBaseUrl groceryBaseUrl) {
        Intrinsics.checkNotNullParameter(baseUrlFactory, "baseUrlFactory");
        Intrinsics.checkNotNullParameter(groceryBaseUrl, "baseUrl");
        return baseUrlFactory.baseUrl(groceryBaseUrl);
    }
}
