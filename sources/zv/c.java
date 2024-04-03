package zv;

import androidx.lifecycle.Observer;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.model.WalletValidateExpiryDateState;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.view.AddCardCustomView;

public final /* synthetic */ class c implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AddCardCustomView f24248a;

    public /* synthetic */ c(AddCardCustomView addCardCustomView) {
        this.f24248a = addCardCustomView;
    }

    public final void onChanged(Object obj) {
        AddCardCustomView.m5803validateCardExpiryDateDataObserver$lambda1(this.f24248a, (WalletValidateExpiryDateState) obj);
    }
}
