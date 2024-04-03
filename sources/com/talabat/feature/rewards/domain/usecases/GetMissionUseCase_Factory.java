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
public final class GetMissionUseCase_Factory implements Factory<GetMissionUseCase> {
    private final Provider<RewardsMissionRepository> repositoryProvider;

    public GetMissionUseCase_Factory(Provider<RewardsMissionRepository> provider) {
        this.repositoryProvider = provider;
    }

    public static GetMissionUseCase_Factory create(Provider<RewardsMissionRepository> provider) {
        return new GetMissionUseCase_Factory(provider);
    }

    public static GetMissionUseCase newInstance(RewardsMissionRepository rewardsMissionRepository) {
        return new GetMissionUseCase(rewardsMissionRepository);
    }

    public GetMissionUseCase get() {
        return newInstance(this.repositoryProvider.get());
    }
}
