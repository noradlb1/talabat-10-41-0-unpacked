package com.talabat.growth.ui.loyalty.dashboard;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.feature.cancellationpolicy.domain.IHelpCenterDeeplinkBuilder;
import com.talabat.feature.rewards.domain.RewardsTracker;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class LoyaltyDashboardFragment_MembersInjector implements MembersInjector<LoyaltyDashboardFragment> {
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<CoroutineDispatchersFactory> coroutineDispatchersFactoryProvider;
    private final Provider<DeepLinkNavigator> deepLinkNavigatorProvider;
    private final Provider<ITalabatFeatureFlag> featureFlagRepositoryProvider;
    private final Provider<IHelpCenterDeeplinkBuilder> helpDeeplinkBuilderProvider;
    private final Provider<LocationConfigurationRepository> locationConfigurationRepositoryProvider;
    private final Provider<Navigator> navigatorProvider;
    private final Provider<RewardsTracker> rewardsTrackerProvider;

    public LoyaltyDashboardFragment_MembersInjector(Provider<ConfigurationLocalRepository> provider, Provider<ITalabatFeatureFlag> provider2, Provider<RewardsTracker> provider3, Provider<CoroutineDispatchersFactory> provider4, Provider<LocationConfigurationRepository> provider5, Provider<Navigator> provider6, Provider<DeepLinkNavigator> provider7, Provider<IHelpCenterDeeplinkBuilder> provider8) {
        this.configurationLocalRepositoryProvider = provider;
        this.featureFlagRepositoryProvider = provider2;
        this.rewardsTrackerProvider = provider3;
        this.coroutineDispatchersFactoryProvider = provider4;
        this.locationConfigurationRepositoryProvider = provider5;
        this.navigatorProvider = provider6;
        this.deepLinkNavigatorProvider = provider7;
        this.helpDeeplinkBuilderProvider = provider8;
    }

    public static MembersInjector<LoyaltyDashboardFragment> create(Provider<ConfigurationLocalRepository> provider, Provider<ITalabatFeatureFlag> provider2, Provider<RewardsTracker> provider3, Provider<CoroutineDispatchersFactory> provider4, Provider<LocationConfigurationRepository> provider5, Provider<Navigator> provider6, Provider<DeepLinkNavigator> provider7, Provider<IHelpCenterDeeplinkBuilder> provider8) {
        return new LoyaltyDashboardFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    @InjectedFieldSignature("com.talabat.growth.ui.loyalty.dashboard.LoyaltyDashboardFragment.configurationLocalRepository")
    public static void injectConfigurationLocalRepository(LoyaltyDashboardFragment loyaltyDashboardFragment, ConfigurationLocalRepository configurationLocalRepository) {
        loyaltyDashboardFragment.configurationLocalRepository = configurationLocalRepository;
    }

    @InjectedFieldSignature("com.talabat.growth.ui.loyalty.dashboard.LoyaltyDashboardFragment.coroutineDispatchersFactory")
    public static void injectCoroutineDispatchersFactory(LoyaltyDashboardFragment loyaltyDashboardFragment, CoroutineDispatchersFactory coroutineDispatchersFactory) {
        loyaltyDashboardFragment.coroutineDispatchersFactory = coroutineDispatchersFactory;
    }

    @InjectedFieldSignature("com.talabat.growth.ui.loyalty.dashboard.LoyaltyDashboardFragment.deepLinkNavigator")
    public static void injectDeepLinkNavigator(LoyaltyDashboardFragment loyaltyDashboardFragment, DeepLinkNavigator deepLinkNavigator) {
        loyaltyDashboardFragment.deepLinkNavigator = deepLinkNavigator;
    }

    @InjectedFieldSignature("com.talabat.growth.ui.loyalty.dashboard.LoyaltyDashboardFragment.featureFlagRepository")
    public static void injectFeatureFlagRepository(LoyaltyDashboardFragment loyaltyDashboardFragment, ITalabatFeatureFlag iTalabatFeatureFlag) {
        loyaltyDashboardFragment.featureFlagRepository = iTalabatFeatureFlag;
    }

    @InjectedFieldSignature("com.talabat.growth.ui.loyalty.dashboard.LoyaltyDashboardFragment.helpDeeplinkBuilder")
    public static void injectHelpDeeplinkBuilder(LoyaltyDashboardFragment loyaltyDashboardFragment, IHelpCenterDeeplinkBuilder iHelpCenterDeeplinkBuilder) {
        loyaltyDashboardFragment.helpDeeplinkBuilder = iHelpCenterDeeplinkBuilder;
    }

    @InjectedFieldSignature("com.talabat.growth.ui.loyalty.dashboard.LoyaltyDashboardFragment.locationConfigurationRepository")
    public static void injectLocationConfigurationRepository(LoyaltyDashboardFragment loyaltyDashboardFragment, LocationConfigurationRepository locationConfigurationRepository) {
        loyaltyDashboardFragment.locationConfigurationRepository = locationConfigurationRepository;
    }

    @InjectedFieldSignature("com.talabat.growth.ui.loyalty.dashboard.LoyaltyDashboardFragment.navigator")
    public static void injectNavigator(LoyaltyDashboardFragment loyaltyDashboardFragment, Navigator navigator) {
        loyaltyDashboardFragment.navigator = navigator;
    }

    @InjectedFieldSignature("com.talabat.growth.ui.loyalty.dashboard.LoyaltyDashboardFragment.rewardsTracker")
    public static void injectRewardsTracker(LoyaltyDashboardFragment loyaltyDashboardFragment, RewardsTracker rewardsTracker) {
        loyaltyDashboardFragment.rewardsTracker = rewardsTracker;
    }

    public void injectMembers(LoyaltyDashboardFragment loyaltyDashboardFragment) {
        injectConfigurationLocalRepository(loyaltyDashboardFragment, this.configurationLocalRepositoryProvider.get());
        injectFeatureFlagRepository(loyaltyDashboardFragment, this.featureFlagRepositoryProvider.get());
        injectRewardsTracker(loyaltyDashboardFragment, this.rewardsTrackerProvider.get());
        injectCoroutineDispatchersFactory(loyaltyDashboardFragment, this.coroutineDispatchersFactoryProvider.get());
        injectLocationConfigurationRepository(loyaltyDashboardFragment, this.locationConfigurationRepositoryProvider.get());
        injectNavigator(loyaltyDashboardFragment, this.navigatorProvider.get());
        injectDeepLinkNavigator(loyaltyDashboardFragment, this.deepLinkNavigatorProvider.get());
        injectHelpDeeplinkBuilder(loyaltyDashboardFragment, this.helpDeeplinkBuilderProvider.get());
    }
}
