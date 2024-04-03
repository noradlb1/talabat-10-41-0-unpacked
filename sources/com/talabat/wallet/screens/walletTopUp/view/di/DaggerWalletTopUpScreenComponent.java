package com.talabat.wallet.screens.walletTopUp.view.di;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.wallet.screens.walletTopUp.view.WalletTopUpScreen;
import com.talabat.wallet.screens.walletTopUp.view.WalletTopUpScreen_MembersInjector;
import com.talabat.wallet.screens.walletTopUp.view.di.WalletTopUpScreenComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerWalletTopUpScreenComponent {

    public static final class Factory implements WalletTopUpScreenComponent.Factory {
        private Factory() {
        }

        public WalletTopUpScreenComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            return new WalletTopUpScreenComponentImpl(configurationLocalCoreLibApi, configurationRemoteCoreLibApi);
        }
    }

    public static final class WalletTopUpScreenComponentImpl implements WalletTopUpScreenComponent {
        private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;
        private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;
        private final WalletTopUpScreenComponentImpl walletTopUpScreenComponentImpl;

        private WalletTopUpScreenComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2) {
            this.walletTopUpScreenComponentImpl = this;
            this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
            this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
        }

        @CanIgnoreReturnValue
        private WalletTopUpScreen injectWalletTopUpScreen(WalletTopUpScreen walletTopUpScreen) {
            WalletTopUpScreen_MembersInjector.injectConfigurationLocalRepository(walletTopUpScreen, (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository()));
            WalletTopUpScreen_MembersInjector.injectLocationConfigurationRepository(walletTopUpScreen, (LocationConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getLocationConfigurationRepository()));
            return walletTopUpScreen;
        }

        public void inject(WalletTopUpScreen walletTopUpScreen) {
            injectWalletTopUpScreen(walletTopUpScreen);
        }
    }

    private DaggerWalletTopUpScreenComponent() {
    }

    public static WalletTopUpScreenComponent.Factory factory() {
        return new Factory();
    }
}
