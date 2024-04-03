package com.talabat.wallet.screens.goToWallet.presenter;

import com.talabat.wallet.screens.goToWallet.view.GoToWalletView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/talabat/wallet/screens/goToWallet/presenter/GoToWalletPresenter;", "Lcom/talabat/wallet/screens/goToWallet/presenter/IGotoWalletPresenter;", "goToWalletView", "Lcom/talabat/wallet/screens/goToWallet/view/GoToWalletView;", "(Lcom/talabat/wallet/screens/goToWallet/view/GoToWalletView;)V", "onDestroy", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GoToWalletPresenter implements IGotoWalletPresenter {
    @Nullable
    private GoToWalletView goToWalletView;

    public GoToWalletPresenter(@NotNull GoToWalletView goToWalletView2) {
        Intrinsics.checkNotNullParameter(goToWalletView2, "goToWalletView");
        this.goToWalletView = goToWalletView2;
    }

    public void onDestroy() {
        this.goToWalletView = null;
    }
}
