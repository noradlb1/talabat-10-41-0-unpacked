package com.talabat.wallet.screens.walletDashboard.view;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.location.LocationConfigurationRepository;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class WalletTransactionDashboardScreen_MembersInjector implements MembersInjector<WalletTransactionDashboardScreen> {
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<LocationConfigurationRepository> locationConfigurationRepositoryProvider;

    public WalletTransactionDashboardScreen_MembersInjector(Provider<ConfigurationLocalRepository> provider, Provider<LocationConfigurationRepository> provider2) {
        this.configurationLocalRepositoryProvider = provider;
        this.locationConfigurationRepositoryProvider = provider2;
    }

    public static MembersInjector<WalletTransactionDashboardScreen> create(Provider<ConfigurationLocalRepository> provider, Provider<LocationConfigurationRepository> provider2) {
        return new WalletTransactionDashboardScreen_MembersInjector(provider, provider2);
    }

    @InjectedFieldSignature("com.talabat.wallet.screens.walletDashboard.view.WalletTransactionDashboardScreen.configurationLocalRepository")
    public static void injectConfigurationLocalRepository(WalletTransactionDashboardScreen walletTransactionDashboardScreen, ConfigurationLocalRepository configurationLocalRepository) {
        walletTransactionDashboardScreen.configurationLocalRepository = configurationLocalRepository;
    }

    @InjectedFieldSignature("com.talabat.wallet.screens.walletDashboard.view.WalletTransactionDashboardScreen.locationConfigurationRepository")
    public static void injectLocationConfigurationRepository(WalletTransactionDashboardScreen walletTransactionDashboardScreen, LocationConfigurationRepository locationConfigurationRepository) {
        walletTransactionDashboardScreen.locationConfigurationRepository = locationConfigurationRepository;
    }

    public void injectMembers(WalletTransactionDashboardScreen walletTransactionDashboardScreen) {
        injectConfigurationLocalRepository(walletTransactionDashboardScreen, this.configurationLocalRepositoryProvider.get());
        injectLocationConfigurationRepository(walletTransactionDashboardScreen, this.locationConfigurationRepositoryProvider.get());
    }
}
