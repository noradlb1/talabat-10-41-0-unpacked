package com.talabat.feature.rewards.data.di;

import com.talabat.core.network.domain.MoshiRetrofit;
import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import com.talabat.feature.rewards.data.RewardsBaseUrl;
import com.talabat.feature.rewards.data.remote.RewardsMissionApi;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J$\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u000f\u001a\u00020\u0010H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/talabat/feature/rewards/data/di/RewardsNetworkModule;", "", "()V", "BASE_URL", "", "provideBaseUrl", "baseUrlFactory", "Lcom/talabat/core/network/domain/endpoint/BaseUrlFactory;", "rewardsBaseUrl", "Lcom/talabat/feature/rewards/data/RewardsBaseUrl;", "provideRewardsMissionApi", "Lcom/talabat/feature/rewards/data/remote/RewardsMissionApi;", "baseUrl", "okHttpClient", "Lokhttp3/OkHttpClient;", "retrofitBuilder", "Lretrofit2/Retrofit$Builder;", "com_talabat_feature_rewards_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class RewardsNetworkModule {
    @NotNull
    private static final String BASE_URL = "baseUrl";
    @NotNull
    public static final RewardsNetworkModule INSTANCE = new RewardsNetworkModule();

    private RewardsNetworkModule() {
    }

    @NotNull
    @Provides
    @Named("baseUrl")
    public final String provideBaseUrl(@NotNull BaseUrlFactory baseUrlFactory, @NotNull RewardsBaseUrl rewardsBaseUrl) {
        Intrinsics.checkNotNullParameter(baseUrlFactory, "baseUrlFactory");
        Intrinsics.checkNotNullParameter(rewardsBaseUrl, "rewardsBaseUrl");
        return baseUrlFactory.baseUrl(rewardsBaseUrl);
    }

    @NotNull
    @Provides
    public final RewardsMissionApi provideRewardsMissionApi(@NotNull @Named("baseUrl") String str, @NotNull OkHttpClient okHttpClient, @NotNull @MoshiRetrofit Retrofit.Builder builder) {
        Intrinsics.checkNotNullParameter(str, BASE_URL);
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Intrinsics.checkNotNullParameter(builder, "retrofitBuilder");
        Retrofit build = builder.client(okHttpClient.newBuilder().build()).baseUrl(str).build();
        Intrinsics.checkNotNullExpressionValue(build, "okHttpClient.newBuilder(…       .build()\n        }");
        return (RewardsMissionApi) build.create(RewardsMissionApi.class);
    }
}
