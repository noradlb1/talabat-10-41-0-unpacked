package com.talabat.growth.ui.loyalty.burn.burnConfirmation;

import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.feature.rewards.domain.RewardsFeatureApi;
import com.talabat.feature.rewards.domain.RewardsTracker;
import com.talabat.growth.ui.loyalty.burn.burnConfirmation.RedeemConfirmationFragmentComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerRedeemConfirmationFragmentComponent {

    public static final class Factory implements RedeemConfirmationFragmentComponent.Factory {
        private Factory() {
        }

        public RedeemConfirmationFragmentComponent create(ObservabilityCoreLibApi observabilityCoreLibApi, RewardsFeatureApi rewardsFeatureApi) {
            Preconditions.checkNotNull(observabilityCoreLibApi);
            Preconditions.checkNotNull(rewardsFeatureApi);
            return new RedeemConfirmationFragmentComponentImpl(observabilityCoreLibApi, rewardsFeatureApi);
        }
    }

    public static final class RedeemConfirmationFragmentComponentImpl implements RedeemConfirmationFragmentComponent {
        private final ObservabilityCoreLibApi observabilityCoreLibApi;
        private final RedeemConfirmationFragmentComponentImpl redeemConfirmationFragmentComponentImpl;
        private final RewardsFeatureApi rewardsFeatureApi;

        private RedeemConfirmationFragmentComponentImpl(ObservabilityCoreLibApi observabilityCoreLibApi2, RewardsFeatureApi rewardsFeatureApi2) {
            this.redeemConfirmationFragmentComponentImpl = this;
            this.observabilityCoreLibApi = observabilityCoreLibApi2;
            this.rewardsFeatureApi = rewardsFeatureApi2;
        }

        private RedeemConfirmationFragment injectRedeemConfirmationFragment(RedeemConfirmationFragment redeemConfirmationFragment) {
            RedeemConfirmationFragment_MembersInjector.injectObservabilityManager(redeemConfirmationFragment, (IObservabilityManager) Preconditions.checkNotNullFromComponent(this.observabilityCoreLibApi.getObservabilityManager()));
            RedeemConfirmationFragment_MembersInjector.injectRewardsTracker(redeemConfirmationFragment, (RewardsTracker) Preconditions.checkNotNullFromComponent(this.rewardsFeatureApi.getRewardsTracker()));
            return redeemConfirmationFragment;
        }

        public void inject(RedeemConfirmationFragment redeemConfirmationFragment) {
            injectRedeemConfirmationFragment(redeemConfirmationFragment);
        }
    }

    private DaggerRedeemConfirmationFragmentComponent() {
    }

    public static RedeemConfirmationFragmentComponent.Factory factory() {
        return new Factory();
    }
}
