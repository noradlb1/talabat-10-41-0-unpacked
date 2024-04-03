package kz;

import androidx.lifecycle.Observer;
import com.talabat.wallet.ui.walletTransactionDetail.model.WalletOrderDetailModelState;
import com.talabat.wallet.ui.walletTransactionDetail.view.walletTransactionBodyView.WalletTransactionRefundView;

public final /* synthetic */ class f implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WalletTransactionRefundView f23918a;

    public /* synthetic */ f(WalletTransactionRefundView walletTransactionRefundView) {
        this.f23918a = walletTransactionRefundView;
    }

    public final void onChanged(Object obj) {
        WalletTransactionRefundView.m6089addObservers$lambda5(this.f23918a, (WalletOrderDetailModelState) obj);
    }
}
