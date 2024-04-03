package com.talabat.wallet.ui.walletDashboard.view.di;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.wallet.ui.walletDashboard.view.WalletDashboardFragment;
import com.talabat.wallet.ui.walletDashboard.view.WalletDashboardFragment_MembersInjector;
import com.talabat.wallet.ui.walletDashboard.view.di.WalletDashboardFragmentComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerWalletDashboardFragmentComponent {

    public static final class Factory implements WalletDashboardFragmentComponent.Factory {
        private Factory() {
        }

        public WalletDashboardFragmentComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, NavigationCoreLibApi navigationCoreLibApi, TrackingCoreLibApi trackingCoreLibApi, DeepLinkCoreLibApi deepLinkCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            Preconditions.checkNotNull(navigationCoreLibApi);
            Preconditions.checkNotNull(trackingCoreLibApi);
            Preconditions.checkNotNull(deepLinkCoreLibApi);
            Preconditions.checkNotNull(observabilityCoreLibApi);
            return new WalletDashboardFragmentComponentImpl(configurationLocalCoreLibApi, configurationRemoteCoreLibApi, featureFlagCoreLibApi, navigationCoreLibApi, trackingCoreLibApi, deepLinkCoreLibApi, observabilityCoreLibApi);
        }
    }

    public static final class WalletDashboardFragmentComponentImpl implements WalletDashboardFragmentComponent {
        private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;
        private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;
        private final DeepLinkCoreLibApi deepLinkCoreLibApi;
        private final FeatureFlagCoreLibApi featureFlagCoreLibApi;
        private final NavigationCoreLibApi navigationCoreLibApi;
        private final ObservabilityCoreLibApi observabilityCoreLibApi;
        private final TrackingCoreLibApi trackingCoreLibApi;
        private final WalletDashboardFragmentComponentImpl walletDashboardFragmentComponentImpl;

        private WalletDashboardFragmentComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2, FeatureFlagCoreLibApi featureFlagCoreLibApi2, NavigationCoreLibApi navigationCoreLibApi2, TrackingCoreLibApi trackingCoreLibApi2, DeepLinkCoreLibApi deepLinkCoreLibApi2, ObservabilityCoreLibApi observabilityCoreLibApi2) {
            this.walletDashboardFragmentComponentImpl = this;
            this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
            this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
            this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
            this.navigationCoreLibApi = navigationCoreLibApi2;
            this.deepLinkCoreLibApi = deepLinkCoreLibApi2;
            this.trackingCoreLibApi = trackingCoreLibApi2;
            this.observabilityCoreLibApi = observabilityCoreLibApi2;
        }

        private WalletDashboardFragment injectWalletDashboardFragment(WalletDashboardFragment walletDashboardFragment) {
            WalletDashboardFragment_MembersInjector.injectConfigurationLocalRepository(walletDashboardFragment, (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository()));
            WalletDashboardFragment_MembersInjector.injectLocationConfigurationRepository(walletDashboardFragment, (LocationConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getLocationConfigurationRepository()));
            WalletDashboardFragment_MembersInjector.injectTalabatFeatureFlag(walletDashboardFragment, (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
            WalletDashboardFragment_MembersInjector.injectNavigator(walletDashboardFragment, (Navigator) Preconditions.checkNotNullFromComponent(this.navigationCoreLibApi.getNavigator()));
            WalletDashboardFragment_MembersInjector.injectDeepLinkNavigator(walletDashboardFragment, (DeepLinkNavigator) Preconditions.checkNotNullFromComponent(this.deepLinkCoreLibApi.getDeepLinkNavigator()));
            WalletDashboardFragment_MembersInjector.injectTalabatTracker(walletDashboardFragment, (TalabatTracker) Preconditions.checkNotNullFromComponent(this.trackingCoreLibApi.getTalabatTracker()));
            WalletDashboardFragment_MembersInjector.injectObservabilityManager(walletDashboardFragment, (IObservabilityManager) Preconditions.checkNotNullFromComponent(this.observabilityCoreLibApi.getObservabilityManager()));
            return walletDashboardFragment;
        }

        public void inject(WalletDashboardFragment walletDashboardFragment) {
            injectWalletDashboardFragment(walletDashboardFragment);
        }
    }

    private DaggerWalletDashboardFragmentComponent() {
    }

    public static WalletDashboardFragmentComponent.Factory factory() {
        return new Factory();
    }
}
