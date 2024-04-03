package com.talabat.wallet.ui.walletTransactionDetail.view.di;

import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.wallet.ui.walletTransactionDetail.view.di.WalletTransactionDetailRefundFragmentComponent;
import com.talabat.wallet.ui.walletTransactionDetail.view.refundBottomSheet.WalletTransactionDetailRefundFragment;
import com.talabat.wallet.ui.walletTransactionDetail.view.refundBottomSheet.WalletTransactionDetailRefundFragment_MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerWalletTransactionDetailRefundFragmentComponent {

    public static final class Factory implements WalletTransactionDetailRefundFragmentComponent.Factory {
        private Factory() {
        }

        public WalletTransactionDetailRefundFragmentComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            return new WalletTransactionDetailRefundFragmentComponentImpl(configurationLocalCoreLibApi, configurationRemoteCoreLibApi);
        }
    }

    public static final class WalletTransactionDetailRefundFragmentComponentImpl implements WalletTransactionDetailRefundFragmentComponent {
        private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;
        private final WalletTransactionDetailRefundFragmentComponentImpl walletTransactionDetailRefundFragmentComponentImpl;

        private WalletTransactionDetailRefundFragmentComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2) {
            this.walletTransactionDetailRefundFragmentComponentImpl = this;
            this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
        }

        private WalletTransactionDetailRefundFragment injectWalletTransactionDetailRefundFragment(WalletTransactionDetailRefundFragment walletTransactionDetailRefundFragment) {
            WalletTransactionDetailRefundFragment_MembersInjector.injectLocationConfigurationRepository(walletTransactionDetailRefundFragment, (LocationConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getLocationConfigurationRepository()));
            return walletTransactionDetailRefundFragment;
        }

        public void inject(WalletTransactionDetailRefundFragment walletTransactionDetailRefundFragment) {
            injectWalletTransactionDetailRefundFragment(walletTransactionDetailRefundFragment);
        }
    }

    private DaggerWalletTransactionDetailRefundFragmentComponent() {
    }

    public static WalletTransactionDetailRefundFragmentComponent.Factory factory() {
        return new Factory();
    }
}
