package com.talabat.wallet.ui.walletTransactionDetail.view.refundBottomSheet;

import com.talabat.configuration.location.LocationConfigurationRepository;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class WalletTransactionDetailRefundFragment_MembersInjector implements MembersInjector<WalletTransactionDetailRefundFragment> {
    private final Provider<LocationConfigurationRepository> locationConfigurationRepositoryProvider;

    public WalletTransactionDetailRefundFragment_MembersInjector(Provider<LocationConfigurationRepository> provider) {
        this.locationConfigurationRepositoryProvider = provider;
    }

    public static MembersInjector<WalletTransactionDetailRefundFragment> create(Provider<LocationConfigurationRepository> provider) {
        return new WalletTransactionDetailRefundFragment_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.talabat.wallet.ui.walletTransactionDetail.view.refundBottomSheet.WalletTransactionDetailRefundFragment.locationConfigurationRepository")
    public static void injectLocationConfigurationRepository(WalletTransactionDetailRefundFragment walletTransactionDetailRefundFragment, LocationConfigurationRepository locationConfigurationRepository) {
        walletTransactionDetailRefundFragment.locationConfigurationRepository = locationConfigurationRepository;
    }

    public void injectMembers(WalletTransactionDetailRefundFragment walletTransactionDetailRefundFragment) {
        injectLocationConfigurationRepository(walletTransactionDetailRefundFragment, this.locationConfigurationRepositoryProvider.get());
    }
}
