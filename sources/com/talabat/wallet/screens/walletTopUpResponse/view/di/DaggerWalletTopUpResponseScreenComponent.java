package com.talabat.wallet.screens.walletTopUpResponse.view.di;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.wallet.screens.walletTopUpResponse.view.WalletTopUpResponseScreen;
import com.talabat.wallet.screens.walletTopUpResponse.view.WalletTopUpResponseScreen_MembersInjector;
import com.talabat.wallet.screens.walletTopUpResponse.view.di.WalletTopUpResponseScreenComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerWalletTopUpResponseScreenComponent {

    public static final class Factory implements WalletTopUpResponseScreenComponent.Factory {
        private Factory() {
        }

        public WalletTopUpResponseScreenComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            return new WalletTopUpResponseScreenComponentImpl(configurationLocalCoreLibApi, configurationRemoteCoreLibApi);
        }
    }

    public static final class WalletTopUpResponseScreenComponentImpl implements WalletTopUpResponseScreenComponent {
        private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;
        private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;
        private final WalletTopUpResponseScreenComponentImpl walletTopUpResponseScreenComponentImpl;

        private WalletTopUpResponseScreenComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2) {
            this.walletTopUpResponseScreenComponentImpl = this;
            this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
            this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
        }

        @CanIgnoreReturnValue
        private WalletTopUpResponseScreen injectWalletTopUpResponseScreen(WalletTopUpResponseScreen walletTopUpResponseScreen) {
            WalletTopUpResponseScreen_MembersInjector.injectConfigurationLocalRepository(walletTopUpResponseScreen, (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository()));
            WalletTopUpResponseScreen_MembersInjector.injectLocationConfigurationRepository(walletTopUpResponseScreen, (LocationConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getLocationConfigurationRepository()));
            return walletTopUpResponseScreen;
        }

        public void inject(WalletTopUpResponseScreen walletTopUpResponseScreen) {
            injectWalletTopUpResponseScreen(walletTopUpResponseScreen);
        }
    }

    private DaggerWalletTopUpResponseScreenComponent() {
    }

    public static WalletTopUpResponseScreenComponent.Factory factory() {
        return new Factory();
    }
}
