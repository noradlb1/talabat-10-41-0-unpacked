package com.talabat.growth.ui.loyalty.burn.confirmation;

import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.feature.rewards.domain.RewardsTracker;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class RedeemConfirmationDialogFragment_MembersInjector implements MembersInjector<RedeemConfirmationDialogFragment> {
    private final Provider<IObservabilityManager> observabilityManagerProvider;
    private final Provider<RewardsTracker> rewardsTrackerProvider;

    public RedeemConfirmationDialogFragment_MembersInjector(Provider<IObservabilityManager> provider, Provider<RewardsTracker> provider2) {
        this.observabilityManagerProvider = provider;
        this.rewardsTrackerProvider = provider2;
    }

    public static MembersInjector<RedeemConfirmationDialogFragment> create(Provider<IObservabilityManager> provider, Provider<RewardsTracker> provider2) {
        return new RedeemConfirmationDialogFragment_MembersInjector(provider, provider2);
    }

    @InjectedFieldSignature("com.talabat.growth.ui.loyalty.burn.confirmation.RedeemConfirmationDialogFragment.observabilityManager")
    public static void injectObservabilityManager(RedeemConfirmationDialogFragment redeemConfirmationDialogFragment, IObservabilityManager iObservabilityManager) {
        redeemConfirmationDialogFragment.observabilityManager = iObservabilityManager;
    }

    @InjectedFieldSignature("com.talabat.growth.ui.loyalty.burn.confirmation.RedeemConfirmationDialogFragment.rewardsTracker")
    public static void injectRewardsTracker(RedeemConfirmationDialogFragment redeemConfirmationDialogFragment, RewardsTracker rewardsTracker) {
        redeemConfirmationDialogFragment.rewardsTracker = rewardsTracker;
    }

    public void injectMembers(RedeemConfirmationDialogFragment redeemConfirmationDialogFragment) {
        injectObservabilityManager(redeemConfirmationDialogFragment, this.observabilityManagerProvider.get());
        injectRewardsTracker(redeemConfirmationDialogFragment, this.rewardsTrackerProvider.get());
    }
}
