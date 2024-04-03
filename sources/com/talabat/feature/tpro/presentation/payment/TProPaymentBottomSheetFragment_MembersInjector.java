package com.talabat.feature.tpro.presentation.payment;

import com.talabat.feature.subscriptions.domain.ISubscriptionsFeatureFlagsRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsTracker;
import com.talabat.feature.tpro.presentation.payment.viewmodel.TProPaymentBottomSheetViewModelFactory;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Named;
import javax.inject.Provider;

@QualifierMetadata({"javax.inject.Named"})
@DaggerGenerated
public final class TProPaymentBottomSheetFragment_MembersInjector implements MembersInjector<TProPaymentBottomSheetFragment> {
    private final Provider<Boolean> isCoffeeEnabledProvider;
    private final Provider<ISubscriptionsFeatureFlagsRepository> subscriptionsFeatureFlagsRepositoryProvider;
    private final Provider<ISubscriptionsTracker> subscriptionsTrackerProvider;
    private final Provider<TProPaymentBottomSheetViewModelFactory> viewModelFactoryProvider;

    public TProPaymentBottomSheetFragment_MembersInjector(Provider<TProPaymentBottomSheetViewModelFactory> provider, Provider<ISubscriptionsTracker> provider2, Provider<ISubscriptionsFeatureFlagsRepository> provider3, Provider<Boolean> provider4) {
        this.viewModelFactoryProvider = provider;
        this.subscriptionsTrackerProvider = provider2;
        this.subscriptionsFeatureFlagsRepositoryProvider = provider3;
        this.isCoffeeEnabledProvider = provider4;
    }

    public static MembersInjector<TProPaymentBottomSheetFragment> create(Provider<TProPaymentBottomSheetViewModelFactory> provider, Provider<ISubscriptionsTracker> provider2, Provider<ISubscriptionsFeatureFlagsRepository> provider3, Provider<Boolean> provider4) {
        return new TProPaymentBottomSheetFragment_MembersInjector(provider, provider2, provider3, provider4);
    }

    @InjectedFieldSignature("com.talabat.feature.tpro.presentation.payment.TProPaymentBottomSheetFragment.isCoffeeEnabled")
    @Named("isTproCoffeeEnabled")
    public static void injectIsCoffeeEnabled(TProPaymentBottomSheetFragment tProPaymentBottomSheetFragment, boolean z11) {
        tProPaymentBottomSheetFragment.isCoffeeEnabled = z11;
    }

    @InjectedFieldSignature("com.talabat.feature.tpro.presentation.payment.TProPaymentBottomSheetFragment.subscriptionsFeatureFlagsRepository")
    public static void injectSubscriptionsFeatureFlagsRepository(TProPaymentBottomSheetFragment tProPaymentBottomSheetFragment, ISubscriptionsFeatureFlagsRepository iSubscriptionsFeatureFlagsRepository) {
        tProPaymentBottomSheetFragment.subscriptionsFeatureFlagsRepository = iSubscriptionsFeatureFlagsRepository;
    }

    @InjectedFieldSignature("com.talabat.feature.tpro.presentation.payment.TProPaymentBottomSheetFragment.subscriptionsTracker")
    public static void injectSubscriptionsTracker(TProPaymentBottomSheetFragment tProPaymentBottomSheetFragment, ISubscriptionsTracker iSubscriptionsTracker) {
        tProPaymentBottomSheetFragment.subscriptionsTracker = iSubscriptionsTracker;
    }

    @InjectedFieldSignature("com.talabat.feature.tpro.presentation.payment.TProPaymentBottomSheetFragment.viewModelFactory")
    public static void injectViewModelFactory(TProPaymentBottomSheetFragment tProPaymentBottomSheetFragment, TProPaymentBottomSheetViewModelFactory tProPaymentBottomSheetViewModelFactory) {
        tProPaymentBottomSheetFragment.viewModelFactory = tProPaymentBottomSheetViewModelFactory;
    }

    public void injectMembers(TProPaymentBottomSheetFragment tProPaymentBottomSheetFragment) {
        injectViewModelFactory(tProPaymentBottomSheetFragment, this.viewModelFactoryProvider.get());
        injectSubscriptionsTracker(tProPaymentBottomSheetFragment, this.subscriptionsTrackerProvider.get());
        injectSubscriptionsFeatureFlagsRepository(tProPaymentBottomSheetFragment, this.subscriptionsFeatureFlagsRepositoryProvider.get());
        injectIsCoffeeEnabled(tProPaymentBottomSheetFragment, this.isCoffeeEnabledProvider.get().booleanValue());
    }
}
