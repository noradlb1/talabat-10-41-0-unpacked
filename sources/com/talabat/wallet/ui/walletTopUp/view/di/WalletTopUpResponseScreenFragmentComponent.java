package com.talabat.wallet.ui.walletTopUp.view.di;

import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.wallet.ui.walletTopUp.view.walletTopUpResponseScreen.WalletTopUpResponseScreenFragment;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/talabat/wallet/ui/walletTopUp/view/di/WalletTopUpResponseScreenFragmentComponent;", "", "inject", "", "walletTopUpResponseScreenFragment", "Lcom/talabat/wallet/ui/walletTopUp/view/walletTopUpResponseScreen/WalletTopUpResponseScreenFragment;", "Factory", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(dependencies = {ConfigurationLocalCoreLibApi.class})
public interface WalletTopUpResponseScreenFragmentComponent {

    @Component.Factory
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/talabat/wallet/ui/walletTopUp/view/di/WalletTopUpResponseScreenFragmentComponent$Factory;", "", "create", "Lcom/talabat/wallet/ui/walletTopUp/view/di/WalletTopUpResponseScreenFragmentComponent;", "configurationLocalCoreLibApi", "Lcom/talabat/configuration/di/ConfigurationLocalCoreLibApi;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        WalletTopUpResponseScreenFragmentComponent create(@NotNull ConfigurationLocalCoreLibApi configurationLocalCoreLibApi);
    }

    void inject(@NotNull WalletTopUpResponseScreenFragment walletTopUpResponseScreenFragment);
}
