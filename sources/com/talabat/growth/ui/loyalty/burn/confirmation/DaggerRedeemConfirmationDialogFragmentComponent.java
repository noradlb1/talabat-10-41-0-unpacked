package com.talabat.growth.ui.loyalty.burn.confirmation;

import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.feature.rewards.domain.RewardsFeatureApi;
import com.talabat.feature.rewards.domain.RewardsTracker;
import com.talabat.growth.ui.loyalty.burn.confirmation.RedeemConfirmationDialogFragmentComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerRedeemConfirmationDialogFragmentComponent {

    public static final class Factory implements RedeemConfirmationDialogFragmentComponent.Factory {
        private Factory() {
        }

        public RedeemConfirmationDialogFragmentComponent create(ObservabilityCoreLibApi observabilityCoreLibApi, RewardsFeatureApi rewardsFeatureApi) {
            Preconditions.checkNotNull(observabilityCoreLibApi);
            Preconditions.checkNotNull(rewardsFeatureApi);
            return new RedeemConfirmationDialogFragmentComponentImpl(observabilityCoreLibApi, rewardsFeatureApi);
        }
    }

    public static final class RedeemConfirmationDialogFragmentComponentImpl implements RedeemConfirmationDialogFragmentComponent {
        private final ObservabilityCoreLibApi observabilityCoreLibApi;
        private final RedeemConfirmationDialogFragmentComponentImpl redeemConfirmationDialogFragmentComponentImpl;
        private final RewardsFeatureApi rewardsFeatureApi;

        private RedeemConfirmationDialogFragmentComponentImpl(ObservabilityCoreLibApi observabilityCoreLibApi2, RewardsFeatureApi rewardsFeatureApi2) {
            this.redeemConfirmationDialogFragmentComponentImpl = this;
            this.observabilityCoreLibApi = observabilityCoreLibApi2;
            this.rewardsFeatureApi = rewardsFeatureApi2;
        }

        private RedeemConfirmationDialogFragment injectRedeemConfirmationDialogFragment(RedeemConfirmationDialogFragment redeemConfirmationDialogFragment) {
            RedeemConfirmationDialogFragment_MembersInjector.injectObservabilityManager(redeemConfirmationDialogFragment, (IObservabilityManager) Preconditions.checkNotNullFromComponent(this.observabilityCoreLibApi.getObservabilityManager()));
            RedeemConfirmationDialogFragment_MembersInjector.injectRewardsTracker(redeemConfirmationDialogFragment, (RewardsTracker) Preconditions.checkNotNullFromComponent(this.rewardsFeatureApi.getRewardsTracker()));
            return redeemConfirmationDialogFragment;
        }

        public void inject(RedeemConfirmationDialogFragment redeemConfirmationDialogFragment) {
            injectRedeemConfirmationDialogFragment(redeemConfirmationDialogFragment);
        }
    }

    private DaggerRedeemConfirmationDialogFragmentComponent() {
    }

    public static RedeemConfirmationDialogFragmentComponent.Factory factory() {
        return new Factory();
    }
}
