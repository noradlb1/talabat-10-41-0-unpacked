package com.talabat.wallet.screens.walletDashboardDetail.view.di;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.wallet.screens.walletDashboardDetail.view.WalletTransactionDetailScreen;
import com.talabat.wallet.screens.walletDashboardDetail.view.WalletTransactionDetailScreen_MembersInjector;
import com.talabat.wallet.screens.walletDashboardDetail.view.di.WalletTransactionDetailScreenComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerWalletTransactionDetailScreenComponent {

    public static final class Factory implements WalletTransactionDetailScreenComponent.Factory {
        private Factory() {
        }

        public WalletTransactionDetailScreenComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            return new WalletTransactionDetailScreenComponentImpl(configurationLocalCoreLibApi, configurationRemoteCoreLibApi);
        }
    }

    public static final class WalletTransactionDetailScreenComponentImpl implements WalletTransactionDetailScreenComponent {
        private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;
        private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;
        private final WalletTransactionDetailScreenComponentImpl walletTransactionDetailScreenComponentImpl;

        private WalletTransactionDetailScreenComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2) {
            this.walletTransactionDetailScreenComponentImpl = this;
            this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
            this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
        }

        @CanIgnoreReturnValue
        private WalletTransactionDetailScreen injectWalletTransactionDetailScreen(WalletTransactionDetailScreen walletTransactionDetailScreen) {
            WalletTransactionDetailScreen_MembersInjector.injectConfigurationLocalRepository(walletTransactionDetailScreen, (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository()));
            WalletTransactionDetailScreen_MembersInjector.injectLocationConfigurationRepository(walletTransactionDetailScreen, (LocationConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getLocationConfigurationRepository()));
            return walletTransactionDetailScreen;
        }

        public void inject(WalletTransactionDetailScreen walletTransactionDetailScreen) {
            injectWalletTransactionDetailScreen(walletTransactionDetailScreen);
        }
    }

    private DaggerWalletTransactionDetailScreenComponent() {
    }

    public static WalletTransactionDetailScreenComponent.Factory factory() {
        return new Factory();
    }
}
