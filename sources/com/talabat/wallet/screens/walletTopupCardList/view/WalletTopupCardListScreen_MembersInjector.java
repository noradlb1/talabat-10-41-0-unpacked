package com.talabat.wallet.screens.walletTopupCardList.view;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.location.LocationConfigurationRepository;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class WalletTopupCardListScreen_MembersInjector implements MembersInjector<WalletTopupCardListScreen> {
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<LocationConfigurationRepository> locationConfigurationRepositoryProvider;

    public WalletTopupCardListScreen_MembersInjector(Provider<ConfigurationLocalRepository> provider, Provider<LocationConfigurationRepository> provider2) {
        this.configurationLocalRepositoryProvider = provider;
        this.locationConfigurationRepositoryProvider = provider2;
    }

    public static MembersInjector<WalletTopupCardListScreen> create(Provider<ConfigurationLocalRepository> provider, Provider<LocationConfigurationRepository> provider2) {
        return new WalletTopupCardListScreen_MembersInjector(provider, provider2);
    }

    @InjectedFieldSignature("com.talabat.wallet.screens.walletTopupCardList.view.WalletTopupCardListScreen.configurationLocalRepository")
    public static void injectConfigurationLocalRepository(WalletTopupCardListScreen walletTopupCardListScreen, ConfigurationLocalRepository configurationLocalRepository) {
        walletTopupCardListScreen.configurationLocalRepository = configurationLocalRepository;
    }

    @InjectedFieldSignature("com.talabat.wallet.screens.walletTopupCardList.view.WalletTopupCardListScreen.locationConfigurationRepository")
    public static void injectLocationConfigurationRepository(WalletTopupCardListScreen walletTopupCardListScreen, LocationConfigurationRepository locationConfigurationRepository) {
        walletTopupCardListScreen.locationConfigurationRepository = locationConfigurationRepository;
    }

    public void injectMembers(WalletTopupCardListScreen walletTopupCardListScreen) {
        injectConfigurationLocalRepository(walletTopupCardListScreen, this.configurationLocalRepositoryProvider.get());
        injectLocationConfigurationRepository(walletTopupCardListScreen, this.locationConfigurationRepositoryProvider.get());
    }
}
