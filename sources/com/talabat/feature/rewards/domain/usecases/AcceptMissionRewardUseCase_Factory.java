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
public final class AcceptMissionRewardUseCase_Factory implements Factory<AcceptMissionRewardUseCase> {
    private final Provider<RewardsMissionRepository> repositoryProvider;

    public AcceptMissionRewardUseCase_Factory(Provider<RewardsMissionRepository> provider) {
        this.repositoryProvider = provider;
    }

    public static AcceptMissionRewardUseCase_Factory create(Provider<RewardsMissionRepository> provider) {
        return new AcceptMissionRewardUseCase_Factory(provider);
    }

    public static AcceptMissionRewardUseCase newInstance(RewardsMissionRepository rewardsMissionRepository) {
        return new AcceptMissionRewardUseCase(rewardsMissionRepository);
    }

    public AcceptMissionRewardUseCase get() {
        return newInstance(this.repositoryProvider.get());
    }
}
