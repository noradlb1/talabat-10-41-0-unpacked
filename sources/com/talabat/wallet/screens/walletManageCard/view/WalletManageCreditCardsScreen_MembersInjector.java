package com.talabat.wallet.screens.walletManageCard.view;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.location.LocationConfigurationRepository;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class WalletManageCreditCardsScreen_MembersInjector implements MembersInjector<WalletManageCreditCardsScreen> {
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<LocationConfigurationRepository> locationConfigurationRepositoryProvider;

    public WalletManageCreditCardsScreen_MembersInjector(Provider<ConfigurationLocalRepository> provider, Provider<LocationConfigurationRepository> provider2) {
        this.configurationLocalRepositoryProvider = provider;
        this.locationConfigurationRepositoryProvider = provider2;
    }

    public static MembersInjector<WalletManageCreditCardsScreen> create(Provider<ConfigurationLocalRepository> provider, Provider<LocationConfigurationRepository> provider2) {
        return new WalletManageCreditCardsScreen_MembersInjector(provider, provider2);
    }

    @InjectedFieldSignature("com.talabat.wallet.screens.walletManageCard.view.WalletManageCreditCardsScreen.configurationLocalRepository")
    public static void injectConfigurationLocalRepository(WalletManageCreditCardsScreen walletManageCreditCardsScreen, ConfigurationLocalRepository configurationLocalRepository) {
        walletManageCreditCardsScreen.configurationLocalRepository = configurationLocalRepository;
    }

    @InjectedFieldSignature("com.talabat.wallet.screens.walletManageCard.view.WalletManageCreditCardsScreen.locationConfigurationRepository")
    public static void injectLocationConfigurationRepository(WalletManageCreditCardsScreen walletManageCreditCardsScreen, LocationConfigurationRepository locationConfigurationRepository) {
        walletManageCreditCardsScreen.locationConfigurationRepository = locationConfigurationRepository;
    }

    public void injectMembers(WalletManageCreditCardsScreen walletManageCreditCardsScreen) {
        injectConfigurationLocalRepository(walletManageCreditCardsScreen, this.configurationLocalRepositoryProvider.get());
        injectLocationConfigurationRepository(walletManageCreditCardsScreen, this.locationConfigurationRepositoryProvider.get());
    }
}
