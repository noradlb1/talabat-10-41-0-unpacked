package com.talabat.wallet.ui.walletTransactionDetail.view.walletTransactionBodyView.di;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.wallet.ui.walletTransactionDetail.view.walletTransactionBodyView.WalletTransactionRefundView;
import com.talabat.wallet.ui.walletTransactionDetail.view.walletTransactionBodyView.WalletTransactionRefundView_MembersInjector;
import com.talabat.wallet.ui.walletTransactionDetail.view.walletTransactionBodyView.di.WalletTransactionRefundViewComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerWalletTransactionRefundViewComponent {

    public static final class Factory implements WalletTransactionRefundViewComponent.Factory {
        private Factory() {
        }

        public WalletTransactionRefundViewComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            return new WalletTransactionRefundViewComponentImpl(configurationLocalCoreLibApi);
        }
    }

    public static final class WalletTransactionRefundViewComponentImpl implements WalletTransactionRefundViewComponent {
        private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;
        private final WalletTransactionRefundViewComponentImpl walletTransactionRefundViewComponentImpl;

        private WalletTransactionRefundViewComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2) {
            this.walletTransactionRefundViewComponentImpl = this;
            this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
        }

        private WalletTransactionRefundView injectWalletTransactionRefundView(WalletTransactionRefundView walletTransactionRefundView) {
            WalletTransactionRefundView_MembersInjector.injectConfigurationLocalRepository(walletTransactionRefundView, (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository()));
            return walletTransactionRefundView;
        }

        public void inject(WalletTransactionRefundView walletTransactionRefundView) {
            injectWalletTransactionRefundView(walletTransactionRefundView);
        }
    }

    private DaggerWalletTransactionRefundViewComponent() {
    }

    public static WalletTransactionRefundViewComponent.Factory factory() {
        return new Factory();
    }
}
