package com.talabat.feature.tpro.presentation.management.details;

import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.feature.subscriptions.domain.ISubscriptionStatusRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsFeatureFlagsRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsTracker;
import com.talabat.feature.tpro.presentation.management.details.viewmodel.TproSubscriptionDetailsViewModelFactory;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class TProSubscriptionDetailsFragment_MembersInjector implements MembersInjector<TProSubscriptionDetailsFragment> {
    private final Provider<DeepLinkNavigator> deepLinkNavigatorProvider;
    private final Provider<LocationConfigurationRepository> locationRepositoryProvider;
    private final Provider<Navigator> navigatorProvider;
    private final Provider<ISubscriptionStatusRepository> subscriptionStatusRepositoryProvider;
    private final Provider<ISubscriptionsFeatureFlagsRepository> subscriptionsFeatureFlagProvider;
    private final Provider<ISubscriptionsTracker> subscriptionsTrackerProvider;
    private final Provider<TproSubscriptionDetailsViewModelFactory> viewModelFactoryProvider;

    public TProSubscriptionDetailsFragment_MembersInjector(Provider<LocationConfigurationRepository> provider, Provider<ISubscriptionsFeatureFlagsRepository> provider2, Provider<ISubscriptionStatusRepository> provider3, Provider<ISubscriptionsTracker> provider4, Provider<Navigator> provider5, Provider<TproSubscriptionDetailsViewModelFactory> provider6, Provider<DeepLinkNavigator> provider7) {
        this.locationRepositoryProvider = provider;
        this.subscriptionsFeatureFlagProvider = provider2;
        this.subscriptionStatusRepositoryProvider = provider3;
        this.subscriptionsTrackerProvider = provider4;
        this.navigatorProvider = provider5;
        this.viewModelFactoryProvider = provider6;
        this.deepLinkNavigatorProvider = provider7;
    }

    public static MembersInjector<TProSubscriptionDetailsFragment> create(Provider<LocationConfigurationRepository> provider, Provider<ISubscriptionsFeatureFlagsRepository> provider2, Provider<ISubscriptionStatusRepository> provider3, Provider<ISubscriptionsTracker> provider4, Provider<Navigator> provider5, Provider<TproSubscriptionDetailsViewModelFactory> provider6, Provider<DeepLinkNavigator> provider7) {
        return new TProSubscriptionDetailsFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    @InjectedFieldSignature("com.talabat.feature.tpro.presentation.management.details.TProSubscriptionDetailsFragment.deepLinkNavigator")
    public static void injectDeepLinkNavigator(TProSubscriptionDetailsFragment tProSubscriptionDetailsFragment, DeepLinkNavigator deepLinkNavigator) {
        tProSubscriptionDetailsFragment.deepLinkNavigator = deepLinkNavigator;
    }

    @InjectedFieldSignature("com.talabat.feature.tpro.presentation.management.details.TProSubscriptionDetailsFragment.locationRepository")
    public static void injectLocationRepository(TProSubscriptionDetailsFragment tProSubscriptionDetailsFragment, LocationConfigurationRepository locationConfigurationRepository) {
        tProSubscriptionDetailsFragment.locationRepository = locationConfigurationRepository;
    }

    @InjectedFieldSignature("com.talabat.feature.tpro.presentation.management.details.TProSubscriptionDetailsFragment.navigator")
    public static void injectNavigator(TProSubscriptionDetailsFragment tProSubscriptionDetailsFragment, Navigator navigator) {
        tProSubscriptionDetailsFragment.navigator = navigator;
    }

    @InjectedFieldSignature("com.talabat.feature.tpro.presentation.management.details.TProSubscriptionDetailsFragment.subscriptionStatusRepository")
    public static void injectSubscriptionStatusRepository(TProSubscriptionDetailsFragment tProSubscriptionDetailsFragment, ISubscriptionStatusRepository iSubscriptionStatusRepository) {
        tProSubscriptionDetailsFragment.subscriptionStatusRepository = iSubscriptionStatusRepository;
    }

    @InjectedFieldSignature("com.talabat.feature.tpro.presentation.management.details.TProSubscriptionDetailsFragment.subscriptionsFeatureFlag")
    public static void injectSubscriptionsFeatureFlag(TProSubscriptionDetailsFragment tProSubscriptionDetailsFragment, ISubscriptionsFeatureFlagsRepository iSubscriptionsFeatureFlagsRepository) {
        tProSubscriptionDetailsFragment.subscriptionsFeatureFlag = iSubscriptionsFeatureFlagsRepository;
    }

    @InjectedFieldSignature("com.talabat.feature.tpro.presentation.management.details.TProSubscriptionDetailsFragment.subscriptionsTracker")
    public static void injectSubscriptionsTracker(TProSubscriptionDetailsFragment tProSubscriptionDetailsFragment, ISubscriptionsTracker iSubscriptionsTracker) {
        tProSubscriptionDetailsFragment.subscriptionsTracker = iSubscriptionsTracker;
    }

    @InjectedFieldSignature("com.talabat.feature.tpro.presentation.management.details.TProSubscriptionDetailsFragment.viewModelFactory")
    public static void injectViewModelFactory(TProSubscriptionDetailsFragment tProSubscriptionDetailsFragment, TproSubscriptionDetailsViewModelFactory tproSubscriptionDetailsViewModelFactory) {
        tProSubscriptionDetailsFragment.viewModelFactory = tproSubscriptionDetailsViewModelFactory;
    }

    public void injectMembers(TProSubscriptionDetailsFragment tProSubscriptionDetailsFragment) {
        injectLocationRepository(tProSubscriptionDetailsFragment, this.locationRepositoryProvider.get());
        injectSubscriptionsFeatureFlag(tProSubscriptionDetailsFragment, this.subscriptionsFeatureFlagProvider.get());
        injectSubscriptionStatusRepository(tProSubscriptionDetailsFragment, this.subscriptionStatusRepositoryProvider.get());
        injectSubscriptionsTracker(tProSubscriptionDetailsFragment, this.subscriptionsTrackerProvider.get());
        injectNavigator(tProSubscriptionDetailsFragment, this.navigatorProvider.get());
        injectViewModelFactory(tProSubscriptionDetailsFragment, this.viewModelFactoryProvider.get());
        injectDeepLinkNavigator(tProSubscriptionDetailsFragment, this.deepLinkNavigatorProvider.get());
    }
}
