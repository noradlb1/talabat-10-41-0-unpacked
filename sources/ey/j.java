package ey;

import JsonModels.Request.WalletSetDefaultCreditCardRequest;
import com.talabat.wallet.screens.walletManageCard.view.WalletManageCreditCardsScreen;

public final /* synthetic */ class j implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WalletManageCreditCardsScreen f14044b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ WalletSetDefaultCreditCardRequest f14045c;

    public /* synthetic */ j(WalletManageCreditCardsScreen walletManageCreditCardsScreen, WalletSetDefaultCreditCardRequest walletSetDefaultCreditCardRequest) {
        this.f14044b = walletManageCreditCardsScreen;
        this.f14045c = walletSetDefaultCreditCardRequest;
    }

    public final void run() {
        WalletManageCreditCardsScreen.m5989setDefaultCreditCard$lambda12(this.f14044b, this.f14045c);
    }
}
