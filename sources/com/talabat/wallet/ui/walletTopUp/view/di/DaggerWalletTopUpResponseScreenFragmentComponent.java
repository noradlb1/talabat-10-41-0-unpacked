package com.talabat.wallet.ui.walletTopUp.view.di;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.wallet.ui.walletTopUp.view.di.WalletTopUpResponseScreenFragmentComponent;
import com.talabat.wallet.ui.walletTopUp.view.walletTopUpResponseScreen.WalletTopUpResponseScreenFragment;
import com.talabat.wallet.ui.walletTopUp.view.walletTopUpResponseScreen.WalletTopUpResponseScreenFragment_MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerWalletTopUpResponseScreenFragmentComponent {

    public static final class Factory implements WalletTopUpResponseScreenFragmentComponent.Factory {
        private Factory() {
        }

        public WalletTopUpResponseScreenFragmentComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            return new WalletTopUpResponseScreenFragmentComponentImpl(configurationLocalCoreLibApi);
        }
    }

    public static final class WalletTopUpResponseScreenFragmentComponentImpl implements WalletTopUpResponseScreenFragmentComponent {
        private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;
        private final WalletTopUpResponseScreenFragmentComponentImpl walletTopUpResponseScreenFragmentComponentImpl;

        private WalletTopUpResponseScreenFragmentComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2) {
            this.walletTopUpResponseScreenFragmentComponentImpl = this;
            this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
        }

        private WalletTopUpResponseScreenFragment injectWalletTopUpResponseScreenFragment(WalletTopUpResponseScreenFragment walletTopUpResponseScreenFragment) {
            WalletTopUpResponseScreenFragment_MembersInjector.injectConfigurationLocalRepository(walletTopUpResponseScreenFragment, (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository()));
            return walletTopUpResponseScreenFragment;
        }

        public void inject(WalletTopUpResponseScreenFragment walletTopUpResponseScreenFragment) {
            injectWalletTopUpResponseScreenFragment(walletTopUpResponseScreenFragment);
        }
    }

    private DaggerWalletTopUpResponseScreenFragmentComponent() {
    }

    public static WalletTopUpResponseScreenFragmentComponent.Factory factory() {
        return new Factory();
    }
}
