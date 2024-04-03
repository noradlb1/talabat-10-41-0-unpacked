package com.talabat.feature.tpro.presentation.management.details.upgrade.details;

import com.talabat.feature.subscriptions.domain.ISubscriptionsTracker;
import com.talabat.feature.tpro.presentation.management.details.upgrade.details.viewModel.TproUpgradeDetailsViewModelFactory;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class TproUpgradeDetailsBottomSheetFragment_MembersInjector implements MembersInjector<TproUpgradeDetailsBottomSheetFragment> {
    private final Provider<ISubscriptionsTracker> subscriptionsTrackerProvider;
    private final Provider<TproUpgradeDetailsViewModelFactory> viewModelFactoryProvider;

    public TproUpgradeDetailsBottomSheetFragment_MembersInjector(Provider<TproUpgradeDetailsViewModelFactory> provider, Provider<ISubscriptionsTracker> provider2) {
        this.viewModelFactoryProvider = provider;
        this.subscriptionsTrackerProvider = provider2;
    }

    public static MembersInjector<TproUpgradeDetailsBottomSheetFragment> create(Provider<TproUpgradeDetailsViewModelFactory> provider, Provider<ISubscriptionsTracker> provider2) {
        return new TproUpgradeDetailsBottomSheetFragment_MembersInjector(provider, provider2);
    }

    @InjectedFieldSignature("com.talabat.feature.tpro.presentation.management.details.upgrade.details.TproUpgradeDetailsBottomSheetFragment.subscriptionsTracker")
    public static void injectSubscriptionsTracker(TproUpgradeDetailsBottomSheetFragment tproUpgradeDetailsBottomSheetFragment, ISubscriptionsTracker iSubscriptionsTracker) {
        tproUpgradeDetailsBottomSheetFragment.subscriptionsTracker = iSubscriptionsTracker;
    }

    @InjectedFieldSignature("com.talabat.feature.tpro.presentation.management.details.upgrade.details.TproUpgradeDetailsBottomSheetFragment.viewModelFactory")
    public static void injectViewModelFactory(TproUpgradeDetailsBottomSheetFragment tproUpgradeDetailsBottomSheetFragment, TproUpgradeDetailsViewModelFactory tproUpgradeDetailsViewModelFactory) {
        tproUpgradeDetailsBottomSheetFragment.viewModelFactory = tproUpgradeDetailsViewModelFactory;
    }

    public void injectMembers(TproUpgradeDetailsBottomSheetFragment tproUpgradeDetailsBottomSheetFragment) {
        injectViewModelFactory(tproUpgradeDetailsBottomSheetFragment, this.viewModelFactoryProvider.get());
        injectSubscriptionsTracker(tproUpgradeDetailsBottomSheetFragment, this.subscriptionsTrackerProvider.get());
    }
}
