package com.talabat.growth.ui.loyalty.dashboard.di;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.feature.cancellationpolicy.domain.HelpCenterFeatureApi;
import com.talabat.feature.cancellationpolicy.domain.IHelpCenterDeeplinkBuilder;
import com.talabat.feature.rewards.domain.RewardsFeatureApi;
import com.talabat.feature.rewards.domain.RewardsTracker;
import com.talabat.growth.ui.loyalty.dashboard.LoyaltyDashboardFragment;
import com.talabat.growth.ui.loyalty.dashboard.LoyaltyDashboardFragment_MembersInjector;
import com.talabat.growth.ui.loyalty.dashboard.di.LoyaltyDashboardFragmentComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerLoyaltyDashboardFragmentComponent {

    public static final class Factory implements LoyaltyDashboardFragmentComponent.Factory {
        private Factory() {
        }

        public LoyaltyDashboardFragmentComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, RewardsFeatureApi rewardsFeatureApi, DispatcherCoreLibApi dispatcherCoreLibApi, NavigationCoreLibApi navigationCoreLibApi, DeepLinkCoreLibApi deepLinkCoreLibApi, HelpCenterFeatureApi helpCenterFeatureApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            Preconditions.checkNotNull(rewardsFeatureApi);
            Preconditions.checkNotNull(dispatcherCoreLibApi);
            Preconditions.checkNotNull(navigationCoreLibApi);
            Preconditions.checkNotNull(deepLinkCoreLibApi);
            Preconditions.checkNotNull(helpCenterFeatureApi);
            return new LoyaltyDashboardFragmentComponentImpl(configurationLocalCoreLibApi, configurationRemoteCoreLibApi, featureFlagCoreLibApi, rewardsFeatureApi, dispatcherCoreLibApi, navigationCoreLibApi, deepLinkCoreLibApi, helpCenterFeatureApi);
        }
    }

    public static final class LoyaltyDashboardFragmentComponentImpl implements LoyaltyDashboardFragmentComponent {
        private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;
        private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;
        private final DeepLinkCoreLibApi deepLinkCoreLibApi;
        private final DispatcherCoreLibApi dispatcherCoreLibApi;
        private final FeatureFlagCoreLibApi featureFlagCoreLibApi;
        private final HelpCenterFeatureApi helpCenterFeatureApi;
        private final LoyaltyDashboardFragmentComponentImpl loyaltyDashboardFragmentComponentImpl;
        private final NavigationCoreLibApi navigationCoreLibApi;
        private final RewardsFeatureApi rewardsFeatureApi;

        private LoyaltyDashboardFragmentComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2, FeatureFlagCoreLibApi featureFlagCoreLibApi2, RewardsFeatureApi rewardsFeatureApi2, DispatcherCoreLibApi dispatcherCoreLibApi2, NavigationCoreLibApi navigationCoreLibApi2, DeepLinkCoreLibApi deepLinkCoreLibApi2, HelpCenterFeatureApi helpCenterFeatureApi2) {
            this.loyaltyDashboardFragmentComponentImpl = this;
            this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
            this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
            this.rewardsFeatureApi = rewardsFeatureApi2;
            this.dispatcherCoreLibApi = dispatcherCoreLibApi2;
            this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
            this.navigationCoreLibApi = navigationCoreLibApi2;
            this.deepLinkCoreLibApi = deepLinkCoreLibApi2;
            this.helpCenterFeatureApi = helpCenterFeatureApi2;
        }

        private LoyaltyDashboardFragment injectLoyaltyDashboardFragment(LoyaltyDashboardFragment loyaltyDashboardFragment) {
            LoyaltyDashboardFragment_MembersInjector.injectConfigurationLocalRepository(loyaltyDashboardFragment, (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository()));
            LoyaltyDashboardFragment_MembersInjector.injectFeatureFlagRepository(loyaltyDashboardFragment, (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
            LoyaltyDashboardFragment_MembersInjector.injectRewardsTracker(loyaltyDashboardFragment, (RewardsTracker) Preconditions.checkNotNullFromComponent(this.rewardsFeatureApi.getRewardsTracker()));
            LoyaltyDashboardFragment_MembersInjector.injectCoroutineDispatchersFactory(loyaltyDashboardFragment, (CoroutineDispatchersFactory) Preconditions.checkNotNullFromComponent(this.dispatcherCoreLibApi.getCoroutineDispatchersFactory()));
            LoyaltyDashboardFragment_MembersInjector.injectLocationConfigurationRepository(loyaltyDashboardFragment, (LocationConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getLocationConfigurationRepository()));
            LoyaltyDashboardFragment_MembersInjector.injectNavigator(loyaltyDashboardFragment, (Navigator) Preconditions.checkNotNullFromComponent(this.navigationCoreLibApi.getNavigator()));
            LoyaltyDashboardFragment_MembersInjector.injectDeepLinkNavigator(loyaltyDashboardFragment, (DeepLinkNavigator) Preconditions.checkNotNullFromComponent(this.deepLinkCoreLibApi.getDeepLinkNavigator()));
            LoyaltyDashboardFragment_MembersInjector.injectHelpDeeplinkBuilder(loyaltyDashboardFragment, (IHelpCenterDeeplinkBuilder) Preconditions.checkNotNullFromComponent(this.helpCenterFeatureApi.getHelpCenterDeeplinkNavigator()));
            return loyaltyDashboardFragment;
        }

        public void inject(LoyaltyDashboardFragment loyaltyDashboardFragment) {
            injectLoyaltyDashboardFragment(loyaltyDashboardFragment);
        }
    }

    private DaggerLoyaltyDashboardFragmentComponent() {
    }

    public static LoyaltyDashboardFragmentComponent.Factory factory() {
        return new Factory();
    }
}
