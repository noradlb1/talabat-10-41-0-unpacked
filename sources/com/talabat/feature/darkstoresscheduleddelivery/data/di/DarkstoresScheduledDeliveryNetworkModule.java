package com.talabat.feature.darkstoresscheduleddelivery.data.di;

import com.talabat.core.network.domain.MoshiRetrofit;
import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import com.talabat.feature.darkstoresscheduleddelivery.data.remote.DarkstoresScheduleDeliveryBaseUrl;
import com.talabat.feature.darkstoresscheduleddelivery.data.remote.DarkstoresScheduledDeliveryApi;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\"\u0010\r\u001a\u00020\f2\b\b\u0001\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0004H\u0007¨\u0006\u0013"}, d2 = {"Lcom/talabat/feature/darkstoresscheduleddelivery/data/di/DarkstoresScheduledDeliveryNetworkModule;", "", "()V", "provideBaseUrl", "", "baseUrlFactory", "Lcom/talabat/core/network/domain/endpoint/BaseUrlFactory;", "darkstoresScheduleDeliveryBaseUrl", "Lcom/talabat/feature/darkstoresscheduleddelivery/data/remote/DarkstoresScheduleDeliveryBaseUrl;", "provideDarkstoresScheduledDeliveryApi", "Lcom/talabat/feature/darkstoresscheduleddelivery/data/remote/DarkstoresScheduledDeliveryApi;", "retrofit", "Lretrofit2/Retrofit;", "provideRetrofit", "retrofitBuilder", "Lretrofit2/Retrofit$Builder;", "okHttpClient", "Lokhttp3/OkHttpClient;", "baseUrl", "com_talabat_feature_darkstores-scheduled-delivery_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class DarkstoresScheduledDeliveryNetworkModule {
    @NotNull
    @Provides
    public final String provideBaseUrl(@NotNull BaseUrlFactory baseUrlFactory, @NotNull DarkstoresScheduleDeliveryBaseUrl darkstoresScheduleDeliveryBaseUrl) {
        Intrinsics.checkNotNullParameter(baseUrlFactory, "baseUrlFactory");
        Intrinsics.checkNotNullParameter(darkstoresScheduleDeliveryBaseUrl, "darkstoresScheduleDeliveryBaseUrl");
        return baseUrlFactory.baseUrl(darkstoresScheduleDeliveryBaseUrl);
    }

    @NotNull
    @Provides
    public final DarkstoresScheduledDeliveryApi provideDarkstoresScheduledDeliveryApi(@NotNull Retrofit retrofit) {
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        return (DarkstoresScheduledDeliveryApi) retrofit.create(DarkstoresScheduledDeliveryApi.class);
    }

    @NotNull
    @Provides
    public final Retrofit provideRetrofit(@NotNull @MoshiRetrofit Retrofit.Builder builder, @NotNull OkHttpClient okHttpClient, @NotNull String str) {
        Intrinsics.checkNotNullParameter(builder, "retrofitBuilder");
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Intrinsics.checkNotNullParameter(str, "baseUrl");
        Retrofit build = builder.client(okHttpClient).baseUrl(str).build();
        Intrinsics.checkNotNullExpressionValue(build, "retrofitBuilder.client(o…baseUrl)\n        .build()");
        return build;
    }
}
