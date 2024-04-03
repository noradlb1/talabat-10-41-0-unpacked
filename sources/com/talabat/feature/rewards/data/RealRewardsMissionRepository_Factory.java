package com.talabat.feature.rewards.data;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.feature.rewards.data.remote.RewardsMissionApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class RealRewardsMissionRepository_Factory implements Factory<RealRewardsMissionRepository> {
    private final Provider<RewardsMissionApi> apiProvider;
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;

    public RealRewardsMissionRepository_Factory(Provider<RewardsMissionApi> provider, Provider<ConfigurationLocalRepository> provider2) {
        this.apiProvider = provider;
        this.configurationLocalRepositoryProvider = provider2;
    }

    public static RealRewardsMissionRepository_Factory create(Provider<RewardsMissionApi> provider, Provider<ConfigurationLocalRepository> provider2) {
        return new RealRewardsMissionRepository_Factory(provider, provider2);
    }

    public static RealRewardsMissionRepository newInstance(RewardsMissionApi rewardsMissionApi, ConfigurationLocalRepository configurationLocalRepository) {
        return new RealRewardsMissionRepository(rewardsMissionApi, configurationLocalRepository);
    }

    public RealRewardsMissionRepository get() {
        return newInstance(this.apiProvider.get(), this.configurationLocalRepositoryProvider.get());
    }
}
