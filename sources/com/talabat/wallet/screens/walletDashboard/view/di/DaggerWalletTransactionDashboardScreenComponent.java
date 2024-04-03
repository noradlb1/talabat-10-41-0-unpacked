package com.talabat.wallet.screens.walletDashboard.view.di;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.wallet.screens.walletDashboard.view.WalletTransactionDashboardScreen;
import com.talabat.wallet.screens.walletDashboard.view.WalletTransactionDashboardScreen_MembersInjector;
import com.talabat.wallet.screens.walletDashboard.view.di.WalletTransactionDashboardScreenComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerWalletTransactionDashboardScreenComponent {

    public static final class Factory implements WalletTransactionDashboardScreenComponent.Factory {
        private Factory() {
        }

        public WalletTransactionDashboardScreenComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            return new WalletTransactionDashboardScreenComponentImpl(configurationLocalCoreLibApi, configurationRemoteCoreLibApi);
        }
    }

    public static final class WalletTransactionDashboardScreenComponentImpl implements WalletTransactionDashboardScreenComponent {
        private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;
        private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;
        private final WalletTransactionDashboardScreenComponentImpl walletTransactionDashboardScreenComponentImpl;

        private WalletTransactionDashboardScreenComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2) {
            this.walletTransactionDashboardScreenComponentImpl = this;
            this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
            this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
        }

        @CanIgnoreReturnValue
        private WalletTransactionDashboardScreen injectWalletTransactionDashboardScreen(WalletTransactionDashboardScreen walletTransactionDashboardScreen) {
            WalletTransactionDashboardScreen_MembersInjector.injectConfigurationLocalRepository(walletTransactionDashboardScreen, (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository()));
            WalletTransactionDashboardScreen_MembersInjector.injectLocationConfigurationRepository(walletTransactionDashboardScreen, (LocationConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getLocationConfigurationRepository()));
            return walletTransactionDashboardScreen;
        }

        public void inject(WalletTransactionDashboardScreen walletTransactionDashboardScreen) {
            injectWalletTransactionDashboardScreen(walletTransactionDashboardScreen);
        }
    }

    private DaggerWalletTransactionDashboardScreenComponent() {
    }

    public static WalletTransactionDashboardScreenComponent.Factory factory() {
        return new Factory();
    }
}
