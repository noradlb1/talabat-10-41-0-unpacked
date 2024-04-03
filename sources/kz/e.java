package kz;

import androidx.lifecycle.Observer;
import com.talabat.wallet.ui.walletTransactionDetail.model.WalletRefundDisplayModelState;
import com.talabat.wallet.ui.walletTransactionDetail.view.walletTransactionBodyView.WalletTransactionRefundView;

public final /* synthetic */ class e implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WalletTransactionRefundView f23917a;

    public /* synthetic */ e(WalletTransactionRefundView walletTransactionRefundView) {
        this.f23917a = walletTransactionRefundView;
    }

    public final void onChanged(Object obj) {
        WalletTransactionRefundView.m6088addObservers$lambda4(this.f23917a, (WalletRefundDisplayModelState) obj);
    }
}
