package com.talabat.wallet.screens.walletTopupCardList.view.di;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.wallet.screens.walletTopupCardList.view.WalletTopupCardListScreen;
import com.talabat.wallet.screens.walletTopupCardList.view.WalletTopupCardListScreen_MembersInjector;
import com.talabat.wallet.screens.walletTopupCardList.view.di.WalletTopupCardListScreenComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerWalletTopupCardListScreenComponent {

    public static final class Factory implements WalletTopupCardListScreenComponent.Factory {
        private Factory() {
        }

        public WalletTopupCardListScreenComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            return new WalletTopupCardListScreenComponentImpl(configurationLocalCoreLibApi, configurationRemoteCoreLibApi);
        }
    }

    public static final class WalletTopupCardListScreenComponentImpl implements WalletTopupCardListScreenComponent {
        private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;
        private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;
        private final WalletTopupCardListScreenComponentImpl walletTopupCardListScreenComponentImpl;

        private WalletTopupCardListScreenComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2) {
            this.walletTopupCardListScreenComponentImpl = this;
            this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
            this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
        }

        @CanIgnoreReturnValue
        private WalletTopupCardListScreen injectWalletTopupCardListScreen(WalletTopupCardListScreen walletTopupCardListScreen) {
            WalletTopupCardListScreen_MembersInjector.injectConfigurationLocalRepository(walletTopupCardListScreen, (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository()));
            WalletTopupCardListScreen_MembersInjector.injectLocationConfigurationRepository(walletTopupCardListScreen, (LocationConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getLocationConfigurationRepository()));
            return walletTopupCardListScreen;
        }

        public void inject(WalletTopupCardListScreen walletTopupCardListScreen) {
            injectWalletTopupCardListScreen(walletTopupCardListScreen);
        }
    }

    private DaggerWalletTopupCardListScreenComponent() {
    }

    public static WalletTopupCardListScreenComponent.Factory factory() {
        return new Factory();
    }
}
