package com.talabat.feature.rewards.presentation.mission.viewmodel;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.feature.rewards.domain.MissionTracker;
import com.talabat.feature.rewards.domain.usecases.AcceptMissionRewardUseCase;
import com.talabat.feature.rewards.domain.usecases.ClaimMissionRewardUseCase;
import com.talabat.feature.rewards.domain.usecases.GetMissionUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class MissionViewModel_Factory implements Factory<MissionViewModel> {
    private final Provider<AcceptMissionRewardUseCase> acceptMissionRewardUseCaseProvider;
    private final Provider<ClaimMissionRewardUseCase> claimMissionRewardUseCaseProvider;
    private final Provider<ITalabatFeatureFlag> funWithFlagsProvider;
    private final Provider<GetMissionUseCase> getMissionUseCaseProvider;
    private final Provider<MissionTracker> missionTrackerProvider;

    public MissionViewModel_Factory(Provider<GetMissionUseCase> provider, Provider<AcceptMissionRewardUseCase> provider2, Provider<ClaimMissionRewardUseCase> provider3, Provider<ITalabatFeatureFlag> provider4, Provider<MissionTracker> provider5) {
        this.getMissionUseCaseProvider = provider;
        this.acceptMissionRewardUseCaseProvider = provider2;
        this.claimMissionRewardUseCaseProvider = provider3;
        this.funWithFlagsProvider = provider4;
        this.missionTrackerProvider = provider5;
    }

    public static MissionViewModel_Factory create(Provider<GetMissionUseCase> provider, Provider<AcceptMissionRewardUseCase> provider2, Provider<ClaimMissionRewardUseCase> provider3, Provider<ITalabatFeatureFlag> provider4, Provider<MissionTracker> provider5) {
        return new MissionViewModel_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static MissionViewModel newInstance(GetMissionUseCase getMissionUseCase, AcceptMissionRewardUseCase acceptMissionRewardUseCase, ClaimMissionRewardUseCase claimMissionRewardUseCase, ITalabatFeatureFlag iTalabatFeatureFlag, MissionTracker missionTracker) {
        return new MissionViewModel(getMissionUseCase, acceptMissionRewardUseCase, claimMissionRewardUseCase, iTalabatFeatureFlag, missionTracker);
    }

    public MissionViewModel get() {
        return newInstance(this.getMissionUseCaseProvider.get(), this.acceptMissionRewardUseCaseProvider.get(), this.claimMissionRewardUseCaseProvider.get(), this.funWithFlagsProvider.get(), this.missionTrackerProvider.get());
    }
}
