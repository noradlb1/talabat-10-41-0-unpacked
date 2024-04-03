package com.talabat.di.wallet;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.di.wallet.WalletManageCreditCardsScreenComponent;
import com.talabat.wallet.screens.walletManageCard.view.WalletManageCreditCardsScreen;
import com.talabat.wallet.screens.walletManageCard.view.WalletManageCreditCardsScreen_MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerWalletManageCreditCardsScreenComponent {

    public static final class Factory implements WalletManageCreditCardsScreenComponent.Factory {
        private Factory() {
        }

        public WalletManageCreditCardsScreenComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            return new WalletManageCreditCardsScreenComponentImpl(configurationLocalCoreLibApi, configurationRemoteCoreLibApi);
        }
    }

    public static final class WalletManageCreditCardsScreenComponentImpl implements WalletManageCreditCardsScreenComponent {
        private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;
        private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;
        private final WalletManageCreditCardsScreenComponentImpl walletManageCreditCardsScreenComponentImpl;

        private WalletManageCreditCardsScreenComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2) {
            this.walletManageCreditCardsScreenComponentImpl = this;
            this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
            this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
        }

        @CanIgnoreReturnValue
        private WalletManageCreditCardsScreen injectWalletManageCreditCardsScreen(WalletManageCreditCardsScreen walletManageCreditCardsScreen) {
            WalletManageCreditCardsScreen_MembersInjector.injectConfigurationLocalRepository(walletManageCreditCardsScreen, (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository()));
            WalletManageCreditCardsScreen_MembersInjector.injectLocationConfigurationRepository(walletManageCreditCardsScreen, (LocationConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getLocationConfigurationRepository()));
            return walletManageCreditCardsScreen;
        }

        public void inject(WalletManageCreditCardsScreen walletManageCreditCardsScreen) {
            injectWalletManageCreditCardsScreen(walletManageCreditCardsScreen);
        }
    }

    private DaggerWalletManageCreditCardsScreenComponent() {
    }

    public static WalletManageCreditCardsScreenComponent.Factory factory() {
        return new Factory();
    }
}
