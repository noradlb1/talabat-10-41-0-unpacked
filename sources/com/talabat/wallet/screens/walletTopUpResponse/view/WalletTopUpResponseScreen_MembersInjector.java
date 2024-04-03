package com.talabat.wallet.screens.walletTopUpResponse.view;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.location.LocationConfigurationRepository;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class WalletTopUpResponseScreen_MembersInjector implements MembersInjector<WalletTopUpResponseScreen> {
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<LocationConfigurationRepository> locationConfigurationRepositoryProvider;

    public WalletTopUpResponseScreen_MembersInjector(Provider<ConfigurationLocalRepository> provider, Provider<LocationConfigurationRepository> provider2) {
        this.configurationLocalRepositoryProvider = provider;
        this.locationConfigurationRepositoryProvider = provider2;
    }

    public static MembersInjector<WalletTopUpResponseScreen> create(Provider<ConfigurationLocalRepository> provider, Provider<LocationConfigurationRepository> provider2) {
        return new WalletTopUpResponseScreen_MembersInjector(provider, provider2);
    }

    @InjectedFieldSignature("com.talabat.wallet.screens.walletTopUpResponse.view.WalletTopUpResponseScreen.configurationLocalRepository")
    public static void injectConfigurationLocalRepository(WalletTopUpResponseScreen walletTopUpResponseScreen, ConfigurationLocalRepository configurationLocalRepository) {
        walletTopUpResponseScreen.configurationLocalRepository = configurationLocalRepository;
    }

    @InjectedFieldSignature("com.talabat.wallet.screens.walletTopUpResponse.view.WalletTopUpResponseScreen.locationConfigurationRepository")
    public static void injectLocationConfigurationRepository(WalletTopUpResponseScreen walletTopUpResponseScreen, LocationConfigurationRepository locationConfigurationRepository) {
        walletTopUpResponseScreen.locationConfigurationRepository = locationConfigurationRepository;
    }

    public void injectMembers(WalletTopUpResponseScreen walletTopUpResponseScreen) {
        injectConfigurationLocalRepository(walletTopUpResponseScreen, this.configurationLocalRepositoryProvider.get());
        injectLocationConfigurationRepository(walletTopUpResponseScreen, this.locationConfigurationRepositoryProvider.get());
    }
}
