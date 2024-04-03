package wx;

import com.talabat.wallet.screens.walletAddCard.view.WalletAddCreditCardScreen;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WalletAddCreditCardScreen f24173b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f24174c;

    public /* synthetic */ a(WalletAddCreditCardScreen walletAddCreditCardScreen, String str) {
        this.f24173b = walletAddCreditCardScreen;
        this.f24174c = str;
    }

    public final void run() {
        WalletAddCreditCardScreen.m5967onErrorReceived$lambda12(this.f24173b, this.f24174c);
    }
}
