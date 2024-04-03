package com.talabat.feature.rewards.data.di;

import com.talabat.feature.rewards.data.remote.RewardsMissionApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named", "com.talabat.core.network.domain.MoshiRetrofit"})
public final class RewardsNetworkModule_ProvideRewardsMissionApiFactory implements Factory<RewardsMissionApi> {
    private final Provider<String> baseUrlProvider;
    private final Provider<OkHttpClient> okHttpClientProvider;
    private final Provider<Retrofit.Builder> retrofitBuilderProvider;

    public RewardsNetworkModule_ProvideRewardsMissionApiFactory(Provider<String> provider, Provider<OkHttpClient> provider2, Provider<Retrofit.Builder> provider3) {
        this.baseUrlProvider = provider;
        this.okHttpClientProvider = provider2;
        this.retrofitBuilderProvider = provider3;
    }

    public static RewardsNetworkModule_ProvideRewardsMissionApiFactory create(Provider<String> provider, Provider<OkHttpClient> provider2, Provider<Retrofit.Builder> provider3) {
        return new RewardsNetworkModule_ProvideRewardsMissionApiFactory(provider, provider2, provider3);
    }

    public static RewardsMissionApi provideRewardsMissionApi(String str, OkHttpClient okHttpClient, Retrofit.Builder builder) {
        return (RewardsMissionApi) Preconditions.checkNotNullFromProvides(RewardsNetworkModule.INSTANCE.provideRewardsMissionApi(str, okHttpClient, builder));
    }

    public RewardsMissionApi get() {
        return provideRewardsMissionApi(this.baseUrlProvider.get(), this.okHttpClientProvider.get(), this.retrofitBuilderProvider.get());
    }
}
