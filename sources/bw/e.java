package bw;

import androidx.lifecycle.Observer;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.view.WalletPaymentOptionView;

public final /* synthetic */ class e implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WalletPaymentOptionView f11682a;

    public /* synthetic */ e(WalletPaymentOptionView walletPaymentOptionView) {
        this.f11682a = walletPaymentOptionView;
    }

    public final void onChanged(Object obj) {
        WalletPaymentOptionView.m5813addCardObservers$lambda8(this.f11682a, (Boolean) obj);
    }
}
