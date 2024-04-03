package com.talabat.wallet.screens.walletTopUp.view;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.location.LocationConfigurationRepository;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class WalletTopUpScreen_MembersInjector implements MembersInjector<WalletTopUpScreen> {
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<LocationConfigurationRepository> locationConfigurationRepositoryProvider;

    public WalletTopUpScreen_MembersInjector(Provider<ConfigurationLocalRepository> provider, Provider<LocationConfigurationRepository> provider2) {
        this.configurationLocalRepositoryProvider = provider;
        this.locationConfigurationRepositoryProvider = provider2;
    }

    public static MembersInjector<WalletTopUpScreen> create(Provider<ConfigurationLocalRepository> provider, Provider<LocationConfigurationRepository> provider2) {
        return new WalletTopUpScreen_MembersInjector(provider, provider2);
    }

    @InjectedFieldSignature("com.talabat.wallet.screens.walletTopUp.view.WalletTopUpScreen.configurationLocalRepository")
    public static void injectConfigurationLocalRepository(WalletTopUpScreen walletTopUpScreen, ConfigurationLocalRepository configurationLocalRepository) {
        walletTopUpScreen.configurationLocalRepository = configurationLocalRepository;
    }

    @InjectedFieldSignature("com.talabat.wallet.screens.walletTopUp.view.WalletTopUpScreen.locationConfigurationRepository")
    public static void injectLocationConfigurationRepository(WalletTopUpScreen walletTopUpScreen, LocationConfigurationRepository locationConfigurationRepository) {
        walletTopUpScreen.locationConfigurationRepository = locationConfigurationRepository;
    }

    public void injectMembers(WalletTopUpScreen walletTopUpScreen) {
        injectConfigurationLocalRepository(walletTopUpScreen, this.configurationLocalRepositoryProvider.get());
        injectLocationConfigurationRepository(walletTopUpScreen, this.locationConfigurationRepositoryProvider.get());
    }
}
