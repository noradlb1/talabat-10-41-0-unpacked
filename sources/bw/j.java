package bw;

import androidx.lifecycle.Observer;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletPaymentDisplayModel;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.view.WalletPaymentOptionView;

public final /* synthetic */ class j implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WalletPaymentOptionView f11687a;

    public /* synthetic */ j(WalletPaymentOptionView walletPaymentOptionView) {
        this.f11687a = walletPaymentOptionView;
    }

    public final void onChanged(Object obj) {
        WalletPaymentOptionView.m5819walletTopUpDataObserver$lambda0(this.f11687a, (WalletPaymentDisplayModel) obj);
    }
}
