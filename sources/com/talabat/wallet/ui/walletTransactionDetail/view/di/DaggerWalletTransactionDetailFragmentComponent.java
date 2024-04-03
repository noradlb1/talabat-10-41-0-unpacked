package com.talabat.wallet.ui.walletTransactionDetail.view.di;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.feature.cancellationpolicy.domain.HelpCenterFeatureApi;
import com.talabat.feature.cancellationpolicy.domain.IHelpCenterDeeplinkBuilder;
import com.talabat.wallet.ui.walletTransactionDetail.view.WalletTransactionDetailFragment;
import com.talabat.wallet.ui.walletTransactionDetail.view.WalletTransactionDetailFragment_MembersInjector;
import com.talabat.wallet.ui.walletTransactionDetail.view.di.WalletTransactionDetailFragmentComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerWalletTransactionDetailFragmentComponent {

    public static final class Factory implements WalletTransactionDetailFragmentComponent.Factory {
        private Factory() {
        }

        public WalletTransactionDetailFragmentComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, NavigationCoreLibApi navigationCoreLibApi, DeepLinkCoreLibApi deepLinkCoreLibApi, HelpCenterFeatureApi helpCenterFeatureApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            Preconditions.checkNotNull(navigationCoreLibApi);
            Preconditions.checkNotNull(deepLinkCoreLibApi);
            Preconditions.checkNotNull(helpCenterFeatureApi);
            return new WalletTransactionDetailFragmentComponentImpl(configurationLocalCoreLibApi, configurationRemoteCoreLibApi, featureFlagCoreLibApi, navigationCoreLibApi, deepLinkCoreLibApi, helpCenterFeatureApi);
        }
    }

    public static final class WalletTransactionDetailFragmentComponentImpl implements WalletTransactionDetailFragmentComponent {
        private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;
        private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;
        private final DeepLinkCoreLibApi deepLinkCoreLibApi;
        private final HelpCenterFeatureApi helpCenterFeatureApi;
        private final NavigationCoreLibApi navigationCoreLibApi;
        private final WalletTransactionDetailFragmentComponentImpl walletTransactionDetailFragmentComponentImpl;

        private WalletTransactionDetailFragmentComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2, FeatureFlagCoreLibApi featureFlagCoreLibApi, NavigationCoreLibApi navigationCoreLibApi2, DeepLinkCoreLibApi deepLinkCoreLibApi2, HelpCenterFeatureApi helpCenterFeatureApi2) {
            this.walletTransactionDetailFragmentComponentImpl = this;
            this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
            this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
            this.navigationCoreLibApi = navigationCoreLibApi2;
            this.deepLinkCoreLibApi = deepLinkCoreLibApi2;
            this.helpCenterFeatureApi = helpCenterFeatureApi2;
        }

        private WalletTransactionDetailFragment injectWalletTransactionDetailFragment(WalletTransactionDetailFragment walletTransactionDetailFragment) {
            WalletTransactionDetailFragment_MembersInjector.injectConfigurationLocalRepository(walletTransactionDetailFragment, (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository()));
            WalletTransactionDetailFragment_MembersInjector.injectLocationConfigurationRepository(walletTransactionDetailFragment, (LocationConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getLocationConfigurationRepository()));
            WalletTransactionDetailFragment_MembersInjector.injectNavigator(walletTransactionDetailFragment, (Navigator) Preconditions.checkNotNullFromComponent(this.navigationCoreLibApi.getNavigator()));
            WalletTransactionDetailFragment_MembersInjector.injectDeepLinkNavigator(walletTransactionDetailFragment, (DeepLinkNavigator) Preconditions.checkNotNullFromComponent(this.deepLinkCoreLibApi.getDeepLinkNavigator()));
            WalletTransactionDetailFragment_MembersInjector.injectHelpDeeplinkBuilder(walletTransactionDetailFragment, (IHelpCenterDeeplinkBuilder) Preconditions.checkNotNullFromComponent(this.helpCenterFeatureApi.getHelpCenterDeeplinkNavigator()));
            return walletTransactionDetailFragment;
        }

        public void inject(WalletTransactionDetailFragment walletTransactionDetailFragment) {
            injectWalletTransactionDetailFragment(walletTransactionDetailFragment);
        }
    }

    private DaggerWalletTransactionDetailFragmentComponent() {
    }

    public static WalletTransactionDetailFragmentComponent.Factory factory() {
        return new Factory();
    }
}
