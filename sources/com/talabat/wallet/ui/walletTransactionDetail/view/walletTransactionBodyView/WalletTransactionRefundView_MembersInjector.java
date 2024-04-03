package com.talabat.wallet.ui.walletTransactionDetail.view.walletTransactionBodyView;

import com.talabat.configuration.ConfigurationLocalRepository;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class WalletTransactionRefundView_MembersInjector implements MembersInjector<WalletTransactionRefundView> {
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;

    public WalletTransactionRefundView_MembersInjector(Provider<ConfigurationLocalRepository> provider) {
        this.configurationLocalRepositoryProvider = provider;
    }

    public static MembersInjector<WalletTransactionRefundView> create(Provider<ConfigurationLocalRepository> provider) {
        return new WalletTransactionRefundView_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.talabat.wallet.ui.walletTransactionDetail.view.walletTransactionBodyView.WalletTransactionRefundView.configurationLocalRepository")
    public static void injectConfigurationLocalRepository(WalletTransactionRefundView walletTransactionRefundView, ConfigurationLocalRepository configurationLocalRepository) {
        walletTransactionRefundView.configurationLocalRepository = configurationLocalRepository;
    }

    public void injectMembers(WalletTransactionRefundView walletTransactionRefundView) {
        injectConfigurationLocalRepository(walletTransactionRefundView, this.configurationLocalRepositoryProvider.get());
    }
}
