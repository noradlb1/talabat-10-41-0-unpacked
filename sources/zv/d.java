package zv;

import androidx.lifecycle.Observer;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.model.WalletValidateCardCVVState;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.view.AddCardCustomView;

public final /* synthetic */ class d implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AddCardCustomView f24249a;

    public /* synthetic */ d(AddCardCustomView addCardCustomView) {
        this.f24249a = addCardCustomView;
    }

    public final void onChanged(Object obj) {
        AddCardCustomView.m5802validateCardCVVDataObserver$lambda2(this.f24249a, (WalletValidateCardCVVState) obj);
    }
}
