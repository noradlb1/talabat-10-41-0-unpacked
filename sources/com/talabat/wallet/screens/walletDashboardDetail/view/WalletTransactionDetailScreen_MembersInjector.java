package com.talabat.wallet.screens.walletDashboardDetail.view;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.location.LocationConfigurationRepository;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class WalletTransactionDetailScreen_MembersInjector implements MembersInjector<WalletTransactionDetailScreen> {
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<LocationConfigurationRepository> locationConfigurationRepositoryProvider;

    public WalletTransactionDetailScreen_MembersInjector(Provider<ConfigurationLocalRepository> provider, Provider<LocationConfigurationRepository> provider2) {
        this.configurationLocalRepositoryProvider = provider;
        this.locationConfigurationRepositoryProvider = provider2;
    }

    public static MembersInjector<WalletTransactionDetailScreen> create(Provider<ConfigurationLocalRepository> provider, Provider<LocationConfigurationRepository> provider2) {
        return new WalletTransactionDetailScreen_MembersInjector(provider, provider2);
    }

    @InjectedFieldSignature("com.talabat.wallet.screens.walletDashboardDetail.view.WalletTransactionDetailScreen.configurationLocalRepository")
    public static void injectConfigurationLocalRepository(WalletTransactionDetailScreen walletTransactionDetailScreen, ConfigurationLocalRepository configurationLocalRepository) {
        walletTransactionDetailScreen.configurationLocalRepository = configurationLocalRepository;
    }

    @InjectedFieldSignature("com.talabat.wallet.screens.walletDashboardDetail.view.WalletTransactionDetailScreen.locationConfigurationRepository")
    public static void injectLocationConfigurationRepository(WalletTransactionDetailScreen walletTransactionDetailScreen, LocationConfigurationRepository locationConfigurationRepository) {
        walletTransactionDetailScreen.locationConfigurationRepository = locationConfigurationRepository;
    }

    public void injectMembers(WalletTransactionDetailScreen walletTransactionDetailScreen) {
        injectConfigurationLocalRepository(walletTransactionDetailScreen, this.configurationLocalRepositoryProvider.get());
        injectLocationConfigurationRepository(walletTransactionDetailScreen, this.locationConfigurationRepositoryProvider.get());
    }
}
