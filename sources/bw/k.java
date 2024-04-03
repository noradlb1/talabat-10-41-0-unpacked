package bw;

import androidx.lifecycle.Observer;
import com.talabat.talabatcommon.model.wallet.WalletBalanceDisplayModel;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.view.WalletPaymentOptionView;

public final /* synthetic */ class k implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WalletPaymentOptionView f11688a;

    public /* synthetic */ k(WalletPaymentOptionView walletPaymentOptionView) {
        this.f11688a = walletPaymentOptionView;
    }

    public final void onChanged(Object obj) {
        WalletPaymentOptionView.m5817walletBalanceDataObserver$lambda1(this.f11688a, (WalletBalanceDisplayModel) obj);
    }
}
