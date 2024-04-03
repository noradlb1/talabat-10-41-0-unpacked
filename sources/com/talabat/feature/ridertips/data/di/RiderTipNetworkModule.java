package com.talabat.feature.ridertips.data.di;

import com.talabat.core.network.domain.MoshiRetrofit;
import com.talabat.core.network.endpoint.MonolithEndPointProvider;
import com.talabat.feature.ridertips.data.remote.RiderTipApi;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0007J$\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/talabat/feature/ridertips/data/di/RiderTipNetworkModule;", "", "()V", "BASE_URL", "", "provideBaseUrl", "provideRiderTipApi", "Lcom/talabat/feature/ridertips/data/remote/RiderTipApi;", "baseUrl", "okHttpClient", "Lokhttp3/OkHttpClient;", "retrofitBuilder", "Lretrofit2/Retrofit$Builder;", "com_talabat_feature_ridertips_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class RiderTipNetworkModule {
    @NotNull
    private static final String BASE_URL = "baseUrl";
    @NotNull
    public static final RiderTipNetworkModule INSTANCE = new RiderTipNetworkModule();

    private RiderTipNetworkModule() {
    }

    @NotNull
    @Provides
    @Named("baseUrl")
    public final String provideBaseUrl() {
        return MonolithEndPointProvider.INSTANCE.getBaseUrl();
    }

    @NotNull
    @Provides
    public final RiderTipApi provideRiderTipApi(@NotNull @Named("baseUrl") String str, @NotNull OkHttpClient okHttpClient, @NotNull @MoshiRetrofit Retrofit.Builder builder) {
        Intrinsics.checkNotNullParameter(str, BASE_URL);
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Intrinsics.checkNotNullParameter(builder, "retrofitBuilder");
        Retrofit build = builder.client(okHttpClient.newBuilder().build()).baseUrl(str).build();
        Intrinsics.checkNotNullExpressionValue(build, "okHttpClient.newBuilder(…   .build()\n            }");
        return (RiderTipApi) build.create(RiderTipApi.class);
    }
}
