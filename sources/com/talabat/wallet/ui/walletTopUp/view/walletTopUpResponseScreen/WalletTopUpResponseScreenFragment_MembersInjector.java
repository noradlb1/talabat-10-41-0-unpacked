package com.talabat.wallet.ui.walletTopUp.view.walletTopUpResponseScreen;

import com.talabat.configuration.ConfigurationLocalRepository;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class WalletTopUpResponseScreenFragment_MembersInjector implements MembersInjector<WalletTopUpResponseScreenFragment> {
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;

    public WalletTopUpResponseScreenFragment_MembersInjector(Provider<ConfigurationLocalRepository> provider) {
        this.configurationLocalRepositoryProvider = provider;
    }

    public static MembersInjector<WalletTopUpResponseScreenFragment> create(Provider<ConfigurationLocalRepository> provider) {
        return new WalletTopUpResponseScreenFragment_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.talabat.wallet.ui.walletTopUp.view.walletTopUpResponseScreen.WalletTopUpResponseScreenFragment.configurationLocalRepository")
    public static void injectConfigurationLocalRepository(WalletTopUpResponseScreenFragment walletTopUpResponseScreenFragment, ConfigurationLocalRepository configurationLocalRepository) {
        walletTopUpResponseScreenFragment.configurationLocalRepository = configurationLocalRepository;
    }

    public void injectMembers(WalletTopUpResponseScreenFragment walletTopUpResponseScreenFragment) {
        injectConfigurationLocalRepository(walletTopUpResponseScreenFragment, this.configurationLocalRepositoryProvider.get());
    }
}
