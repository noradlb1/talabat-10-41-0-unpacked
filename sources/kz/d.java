package kz;

import androidx.lifecycle.Observer;
import com.talabat.wallet.ui.walletTransactionDetail.model.WalletRefundDisplayModelState;
import com.talabat.wallet.ui.walletTransactionDetail.view.walletTransactionBodyView.WalletTransactionRefundView;

public final /* synthetic */ class d implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WalletTransactionRefundView f23916a;

    public /* synthetic */ d(WalletTransactionRefundView walletTransactionRefundView) {
        this.f23916a = walletTransactionRefundView;
    }

    public final void onChanged(Object obj) {
        WalletTransactionRefundView.m6087addObservers$lambda3(this.f23916a, (WalletRefundDisplayModelState) obj);
    }
}
