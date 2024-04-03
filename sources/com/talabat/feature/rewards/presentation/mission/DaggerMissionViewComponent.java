package com.talabat.feature.rewards.presentation.mission;

import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.feature.rewards.domain.MissionTracker;
import com.talabat.feature.rewards.domain.RewardsFeatureApi;
import com.talabat.feature.rewards.domain.RewardsMissionRepository;
import com.talabat.feature.rewards.domain.usecases.AcceptMissionRewardUseCase;
import com.talabat.feature.rewards.domain.usecases.AcceptMissionRewardUseCase_Factory;
import com.talabat.feature.rewards.domain.usecases.ClaimMissionRewardUseCase;
import com.talabat.feature.rewards.domain.usecases.ClaimMissionRewardUseCase_Factory;
import com.talabat.feature.rewards.domain.usecases.GetMissionUseCase;
import com.talabat.feature.rewards.domain.usecases.GetMissionUseCase_Factory;
import com.talabat.feature.rewards.presentation.mission.MissionViewComponent;
import com.talabat.feature.rewards.presentation.mission.viewmodel.MissionViewModel;
import com.talabat.feature.rewards.presentation.mission.viewmodel.MissionViewModelFactory;
import com.talabat.feature.rewards.presentation.mission.viewmodel.MissionViewModel_Factory;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import javax.inject.Provider;

@DaggerGenerated
public final class DaggerMissionViewComponent {

    public static final class Factory implements MissionViewComponent.Factory {
        private Factory() {
        }

        public MissionViewComponent create(RewardsFeatureApi rewardsFeatureApi, FeatureFlagCoreLibApi featureFlagCoreLibApi) {
            Preconditions.checkNotNull(rewardsFeatureApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            return new MissionViewComponentImpl(rewardsFeatureApi, featureFlagCoreLibApi);
        }
    }

    public static final class MissionViewComponentImpl implements MissionViewComponent {
        private Provider<AcceptMissionRewardUseCase> acceptMissionRewardUseCaseProvider;
        private Provider<ClaimMissionRewardUseCase> claimMissionRewardUseCaseProvider;
        private Provider<MissionTracker> getMissionTrackerProvider;
        private Provider<GetMissionUseCase> getMissionUseCaseProvider;
        private Provider<RewardsMissionRepository> getRepositoryProvider;
        private Provider<ITalabatFeatureFlag> getTalabatFeatureFlagProvider;
        private final MissionViewComponentImpl missionViewComponentImpl;
        private Provider<MissionViewModel> missionViewModelProvider;

        public static final class GetMissionTrackerProvider implements Provider<MissionTracker> {
            private final RewardsFeatureApi rewardsFeatureApi;

            public GetMissionTrackerProvider(RewardsFeatureApi rewardsFeatureApi2) {
                this.rewardsFeatureApi = rewardsFeatureApi2;
            }

            public MissionTracker get() {
                return (MissionTracker) Preconditions.checkNotNullFromComponent(this.rewardsFeatureApi.getMissionTracker());
            }
        }

        public static final class GetRepositoryProvider implements Provider<RewardsMissionRepository> {
            private final RewardsFeatureApi rewardsFeatureApi;

            public GetRepositoryProvider(RewardsFeatureApi rewardsFeatureApi2) {
                this.rewardsFeatureApi = rewardsFeatureApi2;
            }

            public RewardsMissionRepository get() {
                return (RewardsMissionRepository) Preconditions.checkNotNullFromComponent(this.rewardsFeatureApi.getRepository());
            }
        }

        public static final class GetTalabatFeatureFlagProvider implements Provider<ITalabatFeatureFlag> {
            private final FeatureFlagCoreLibApi featureFlagCoreLibApi;

            public GetTalabatFeatureFlagProvider(FeatureFlagCoreLibApi featureFlagCoreLibApi2) {
                this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
            }

            public ITalabatFeatureFlag get() {
                return (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag());
            }
        }

        private MissionViewComponentImpl(RewardsFeatureApi rewardsFeatureApi, FeatureFlagCoreLibApi featureFlagCoreLibApi) {
            this.missionViewComponentImpl = this;
            initialize(rewardsFeatureApi, featureFlagCoreLibApi);
        }

        private void initialize(RewardsFeatureApi rewardsFeatureApi, FeatureFlagCoreLibApi featureFlagCoreLibApi) {
            GetRepositoryProvider getRepositoryProvider2 = new GetRepositoryProvider(rewardsFeatureApi);
            this.getRepositoryProvider = getRepositoryProvider2;
            this.getMissionUseCaseProvider = GetMissionUseCase_Factory.create(getRepositoryProvider2);
            this.acceptMissionRewardUseCaseProvider = AcceptMissionRewardUseCase_Factory.create(this.getRepositoryProvider);
            this.claimMissionRewardUseCaseProvider = ClaimMissionRewardUseCase_Factory.create(this.getRepositoryProvider);
            this.getTalabatFeatureFlagProvider = new GetTalabatFeatureFlagProvider(featureFlagCoreLibApi);
            GetMissionTrackerProvider getMissionTrackerProvider2 = new GetMissionTrackerProvider(rewardsFeatureApi);
            this.getMissionTrackerProvider = getMissionTrackerProvider2;
            this.missionViewModelProvider = MissionViewModel_Factory.create(this.getMissionUseCaseProvider, this.acceptMissionRewardUseCaseProvider, this.claimMissionRewardUseCaseProvider, this.getTalabatFeatureFlagProvider, getMissionTrackerProvider2);
        }

        private RewardsMissionView injectRewardsMissionView(RewardsMissionView rewardsMissionView) {
            RewardsMissionView_MembersInjector.injectFactory(rewardsMissionView, missionViewModelFactory());
            return rewardsMissionView;
        }

        private MissionViewModelFactory missionViewModelFactory() {
            return new MissionViewModelFactory(this.missionViewModelProvider);
        }

        public void inject(RewardsMissionView rewardsMissionView) {
            injectRewardsMissionView(rewardsMissionView);
        }
    }

    private DaggerMissionViewComponent() {
    }

    public static MissionViewComponent.Factory factory() {
        return new Factory();
    }
}
