package com.talabat.feature.tpro.presentation.benefits;

import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.feature.subscriptions.domain.ISubscriptionStatusRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsFeatureFlagsRepository;
import com.talabat.feature.tpro.presentation.benefits.viewmodel.TproBenefitsViewModelFactory;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class TproBenefitsFragment_MembersInjector implements MembersInjector<TproBenefitsFragment> {
    private final Provider<DeepLinkNavigator> deepLinkNavigatorProvider;
    private final Provider<Navigator> navigatorProvider;
    private final Provider<IObservabilityManager> observabilityManagerProvider;
    private final Provider<ISubscriptionStatusRepository> subcriptionStatusRepositoryProvider;
    private final Provider<ISubscriptionsFeatureFlagsRepository> subscriptionsFlagsProvider;
    private final Provider<TproBenefitsViewModelFactory> viewModelFactoryProvider;

    public TproBenefitsFragment_MembersInjector(Provider<TproBenefitsViewModelFactory> provider, Provider<ISubscriptionsFeatureFlagsRepository> provider2, Provider<ISubscriptionStatusRepository> provider3, Provider<DeepLinkNavigator> provider4, Provider<IObservabilityManager> provider5, Provider<Navigator> provider6) {
        this.viewModelFactoryProvider = provider;
        this.subscriptionsFlagsProvider = provider2;
        this.subcriptionStatusRepositoryProvider = provider3;
        this.deepLinkNavigatorProvider = provider4;
        this.observabilityManagerProvider = provider5;
        this.navigatorProvider = provider6;
    }

    public static MembersInjector<TproBenefitsFragment> create(Provider<TproBenefitsViewModelFactory> provider, Provider<ISubscriptionsFeatureFlagsRepository> provider2, Provider<ISubscriptionStatusRepository> provider3, Provider<DeepLinkNavigator> provider4, Provider<IObservabilityManager> provider5, Provider<Navigator> provider6) {
        return new TproBenefitsFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6);
    }

    @InjectedFieldSignature("com.talabat.feature.tpro.presentation.benefits.TproBenefitsFragment.deepLinkNavigator")
    public static void injectDeepLinkNavigator(TproBenefitsFragment tproBenefitsFragment, DeepLinkNavigator deepLinkNavigator) {
        tproBenefitsFragment.deepLinkNavigator = deepLinkNavigator;
    }

    @InjectedFieldSignature("com.talabat.feature.tpro.presentation.benefits.TproBenefitsFragment.navigator")
    public static void injectNavigator(TproBenefitsFragment tproBenefitsFragment, Navigator navigator) {
        tproBenefitsFragment.navigator = navigator;
    }

    @InjectedFieldSignature("com.talabat.feature.tpro.presentation.benefits.TproBenefitsFragment.observabilityManager")
    public static void injectObservabilityManager(TproBenefitsFragment tproBenefitsFragment, IObservabilityManager iObservabilityManager) {
        tproBenefitsFragment.observabilityManager = iObservabilityManager;
    }

    @InjectedFieldSignature("com.talabat.feature.tpro.presentation.benefits.TproBenefitsFragment.subcriptionStatusRepository")
    public static void injectSubcriptionStatusRepository(TproBenefitsFragment tproBenefitsFragment, ISubscriptionStatusRepository iSubscriptionStatusRepository) {
        tproBenefitsFragment.subcriptionStatusRepository = iSubscriptionStatusRepository;
    }

    @InjectedFieldSignature("com.talabat.feature.tpro.presentation.benefits.TproBenefitsFragment.subscriptionsFlags")
    public static void injectSubscriptionsFlags(TproBenefitsFragment tproBenefitsFragment, ISubscriptionsFeatureFlagsRepository iSubscriptionsFeatureFlagsRepository) {
        tproBenefitsFragment.subscriptionsFlags = iSubscriptionsFeatureFlagsRepository;
    }

    @InjectedFieldSignature("com.talabat.feature.tpro.presentation.benefits.TproBenefitsFragment.viewModelFactory")
    public static void injectViewModelFactory(TproBenefitsFragment tproBenefitsFragment, TproBenefitsViewModelFactory tproBenefitsViewModelFactory) {
        tproBenefitsFragment.viewModelFactory = tproBenefitsViewModelFactory;
    }

    public void injectMembers(TproBenefitsFragment tproBenefitsFragment) {
        injectViewModelFactory(tproBenefitsFragment, this.viewModelFactoryProvider.get());
        injectSubscriptionsFlags(tproBenefitsFragment, this.subscriptionsFlagsProvider.get());
        injectSubcriptionStatusRepository(tproBenefitsFragment, this.subcriptionStatusRepositoryProvider.get());
        injectDeepLinkNavigator(tproBenefitsFragment, this.deepLinkNavigatorProvider.get());
        injectObservabilityManager(tproBenefitsFragment, this.observabilityManagerProvider.get());
        injectNavigator(tproBenefitsFragment, this.navigatorProvider.get());
    }
}
