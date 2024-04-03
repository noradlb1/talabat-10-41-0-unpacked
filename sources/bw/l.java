package bw;

import androidx.lifecycle.Observer;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletPaymentWidgetDisplayModel;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.view.WalletPaymentOptionView;

public final /* synthetic */ class l implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WalletPaymentOptionView f11689a;

    public /* synthetic */ l(WalletPaymentOptionView walletPaymentOptionView) {
        this.f11689a = walletPaymentOptionView;
    }

    public final void onChanged(Object obj) {
        WalletPaymentOptionView.m5820walletWidgetConfigDataObserver$lambda2(this.f11689a, (WalletPaymentWidgetDisplayModel) obj);
    }
}
