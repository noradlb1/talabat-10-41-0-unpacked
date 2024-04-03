package bw;

import androidx.lifecycle.Observer;
import com.talabat.talabatcommon.model.wallet.WalletBalanceDisplayModel;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.view.WalletPaymentOptionView;

public final /* synthetic */ class i implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WalletPaymentOptionView f11686a;

    public /* synthetic */ i(WalletPaymentOptionView walletPaymentOptionView) {
        this.f11686a = walletPaymentOptionView;
    }

    public final void onChanged(Object obj) {
        WalletPaymentOptionView.m5814addWalletBalanceObserver$lambda9(this.f11686a, (WalletBalanceDisplayModel) obj);
    }
}
