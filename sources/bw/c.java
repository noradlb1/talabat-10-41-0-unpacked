package bw;

import androidx.lifecycle.Observer;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.view.WalletPaymentOptionView;

public final /* synthetic */ class c implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WalletPaymentOptionView f11681a;

    public /* synthetic */ c(WalletPaymentOptionView walletPaymentOptionView) {
        this.f11681a = walletPaymentOptionView;
    }

    public final void onChanged(Object obj) {
        WalletPaymentOptionView.m5812addCardObservers$lambda7(this.f11681a, (Boolean) obj);
    }
}
