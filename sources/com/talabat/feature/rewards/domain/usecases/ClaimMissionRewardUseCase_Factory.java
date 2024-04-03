package com.talabat.feature.rewards.domain.usecases;

import com.talabat.feature.rewards.domain.RewardsMissionRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class ClaimMissionRewardUseCase_Factory implements Factory<ClaimMissionRewardUseCase> {
    private final Provider<RewardsMissionRepository> repositoryProvider;

    public ClaimMissionRewardUseCase_Factory(Provider<RewardsMissionRepository> provider) {
        this.repositoryProvider = provider;
    }

    public static ClaimMissionRewardUseCase_Factory create(Provider<RewardsMissionRepository> provider) {
        return new ClaimMissionRewardUseCase_Factory(provider);
    }

    public static ClaimMissionRewardUseCase newInstance(RewardsMissionRepository rewardsMissionRepository) {
        return new ClaimMissionRewardUseCase(rewardsMissionRepository);
    }

    public ClaimMissionRewardUseCase get() {
        return newInstance(this.repositoryProvider.get());
    }
}
