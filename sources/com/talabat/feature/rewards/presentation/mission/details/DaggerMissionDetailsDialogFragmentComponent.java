package com.talabat.feature.rewards.presentation.mission.details;

import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.feature.rewards.domain.MissionTracker;
import com.talabat.feature.rewards.domain.RewardsFeatureApi;
import com.talabat.feature.rewards.presentation.mission.details.MissionDetailsDialogFragmentComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerMissionDetailsDialogFragmentComponent {

    public static final class Factory implements MissionDetailsDialogFragmentComponent.Factory {
        private Factory() {
        }

        public MissionDetailsDialogFragmentComponent create(RewardsFeatureApi rewardsFeatureApi, DeepLinkCoreLibApi deepLinkCoreLibApi) {
            Preconditions.checkNotNull(rewardsFeatureApi);
            Preconditions.checkNotNull(deepLinkCoreLibApi);
            return new MissionDetailsDialogFragmentComponentImpl(rewardsFeatureApi, deepLinkCoreLibApi);
        }
    }

    public static final class MissionDetailsDialogFragmentComponentImpl implements MissionDetailsDialogFragmentComponent {
        private final DeepLinkCoreLibApi deepLinkCoreLibApi;
        private final MissionDetailsDialogFragmentComponentImpl missionDetailsDialogFragmentComponentImpl;
        private final RewardsFeatureApi rewardsFeatureApi;

        private MissionDetailsDialogFragmentComponentImpl(RewardsFeatureApi rewardsFeatureApi2, DeepLinkCoreLibApi deepLinkCoreLibApi2) {
            this.missionDetailsDialogFragmentComponentImpl = this;
            this.deepLinkCoreLibApi = deepLinkCoreLibApi2;
            this.rewardsFeatureApi = rewardsFeatureApi2;
        }

        private MissionDetailsDialogFragment injectMissionDetailsDialogFragment(MissionDetailsDialogFragment missionDetailsDialogFragment) {
            MissionDetailsDialogFragment_MembersInjector.injectDeepLinkNavigator(missionDetailsDialogFragment, (DeepLinkNavigator) Preconditions.checkNotNullFromComponent(this.deepLinkCoreLibApi.getDeepLinkNavigator()));
            MissionDetailsDialogFragment_MembersInjector.injectMissionTracker(missionDetailsDialogFragment, (MissionTracker) Preconditions.checkNotNullFromComponent(this.rewardsFeatureApi.getMissionTracker()));
            return missionDetailsDialogFragment;
        }

        public void inject(MissionDetailsDialogFragment missionDetailsDialogFragment) {
            injectMissionDetailsDialogFragment(missionDetailsDialogFragment);
        }
    }

    private DaggerMissionDetailsDialogFragmentComponent() {
    }

    public static MissionDetailsDialogFragmentComponent.Factory factory() {
        return new Factory();
    }
}
