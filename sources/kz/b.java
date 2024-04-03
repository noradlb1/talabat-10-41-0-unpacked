package kz;

import androidx.lifecycle.Observer;
import com.talabat.wallet.ui.walletTransactionDetail.model.WalletOrderDetailModelState;
import com.talabat.wallet.ui.walletTransactionDetail.view.walletTransactionBodyView.WalletDetailTransactionPaidView;

public final /* synthetic */ class b implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WalletDetailTransactionPaidView f23914a;

    public /* synthetic */ b(WalletDetailTransactionPaidView walletDetailTransactionPaidView) {
        this.f23914a = walletDetailTransactionPaidView;
    }

    public final void onChanged(Object obj) {
        WalletDetailTransactionPaidView.m6082onAttachedToWindow$lambda3(this.f23914a, (WalletOrderDetailModelState) obj);
    }
}
