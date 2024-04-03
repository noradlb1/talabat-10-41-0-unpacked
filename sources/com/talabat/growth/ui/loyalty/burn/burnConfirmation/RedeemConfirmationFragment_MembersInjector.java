package com.talabat.growth.ui.loyalty.burn.burnConfirmation;

import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.feature.rewards.domain.RewardsTracker;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class RedeemConfirmationFragment_MembersInjector implements MembersInjector<RedeemConfirmationFragment> {
    private final Provider<IObservabilityManager> observabilityManagerProvider;
    private final Provider<RewardsTracker> rewardsTrackerProvider;

    public RedeemConfirmationFragment_MembersInjector(Provider<IObservabilityManager> provider, Provider<RewardsTracker> provider2) {
        this.observabilityManagerProvider = provider;
        this.rewardsTrackerProvider = provider2;
    }

    public static MembersInjector<RedeemConfirmationFragment> create(Provider<IObservabilityManager> provider, Provider<RewardsTracker> provider2) {
        return new RedeemConfirmationFragment_MembersInjector(provider, provider2);
    }

    @InjectedFieldSignature("com.talabat.growth.ui.loyalty.burn.burnConfirmation.RedeemConfirmationFragment.observabilityManager")
    public static void injectObservabilityManager(RedeemConfirmationFragment redeemConfirmationFragment, IObservabilityManager iObservabilityManager) {
        redeemConfirmationFragment.observabilityManager = iObservabilityManager;
    }

    @InjectedFieldSignature("com.talabat.growth.ui.loyalty.burn.burnConfirmation.RedeemConfirmationFragment.rewardsTracker")
    public static void injectRewardsTracker(RedeemConfirmationFragment redeemConfirmationFragment, RewardsTracker rewardsTracker) {
        redeemConfirmationFragment.rewardsTracker = rewardsTracker;
    }

    public void injectMembers(RedeemConfirmationFragment redeemConfirmationFragment) {
        injectObservabilityManager(redeemConfirmationFragment, this.observabilityManagerProvider.get());
        injectRewardsTracker(redeemConfirmationFragment, this.rewardsTrackerProvider.get());
    }
}
