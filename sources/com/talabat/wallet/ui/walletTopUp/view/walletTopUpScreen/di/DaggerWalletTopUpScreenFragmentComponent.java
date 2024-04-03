package com.talabat.wallet.ui.walletTopUp.view.walletTopUpScreen.di;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.wallet.ui.walletTopUp.view.walletTopUpScreen.WalletTopUpScreenFragment;
import com.talabat.wallet.ui.walletTopUp.view.walletTopUpScreen.WalletTopUpScreenFragment_MembersInjector;
import com.talabat.wallet.ui.walletTopUp.view.walletTopUpScreen.di.WalletTopUpScreenFragmentComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerWalletTopUpScreenFragmentComponent {

    public static final class Factory implements WalletTopUpScreenFragmentComponent.Factory {
        private Factory() {
        }

        public WalletTopUpScreenFragmentComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, TrackingCoreLibApi trackingCoreLibApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            Preconditions.checkNotNull(trackingCoreLibApi);
            return new WalletTopUpScreenFragmentComponentImpl(configurationLocalCoreLibApi, configurationRemoteCoreLibApi, featureFlagCoreLibApi, trackingCoreLibApi);
        }
    }

    public static final class WalletTopUpScreenFragmentComponentImpl implements WalletTopUpScreenFragmentComponent {
        private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;
        private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;
        private final FeatureFlagCoreLibApi featureFlagCoreLibApi;
        private final TrackingCoreLibApi trackingCoreLibApi;
        private final WalletTopUpScreenFragmentComponentImpl walletTopUpScreenFragmentComponentImpl;

        private WalletTopUpScreenFragmentComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2, FeatureFlagCoreLibApi featureFlagCoreLibApi2, TrackingCoreLibApi trackingCoreLibApi2) {
            this.walletTopUpScreenFragmentComponentImpl = this;
            this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
            this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
            this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
            this.trackingCoreLibApi = trackingCoreLibApi2;
        }

        private WalletTopUpScreenFragment injectWalletTopUpScreenFragment(WalletTopUpScreenFragment walletTopUpScreenFragment) {
            WalletTopUpScreenFragment_MembersInjector.injectConfigurationLocalRepository(walletTopUpScreenFragment, (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository()));
            WalletTopUpScreenFragment_MembersInjector.injectLocationConfigurationRepository(walletTopUpScreenFragment, (LocationConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getLocationConfigurationRepository()));
            WalletTopUpScreenFragment_MembersInjector.injectFeatureFlag(walletTopUpScreenFragment, (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
            WalletTopUpScreenFragment_MembersInjector.injectTalabatTracker(walletTopUpScreenFragment, (TalabatTracker) Preconditions.checkNotNullFromComponent(this.trackingCoreLibApi.getTalabatTracker()));
            return walletTopUpScreenFragment;
        }

        public void inject(WalletTopUpScreenFragment walletTopUpScreenFragment) {
            injectWalletTopUpScreenFragment(walletTopUpScreenFragment);
        }
    }

    private DaggerWalletTopUpScreenFragmentComponent() {
    }

    public static WalletTopUpScreenFragmentComponent.Factory factory() {
        return new Factory();
    }
}
