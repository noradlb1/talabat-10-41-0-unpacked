package zv;

import androidx.lifecycle.Observer;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.model.WalletValidateCardNumberState;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.view.AddCardCustomView;

public final /* synthetic */ class b implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AddCardCustomView f24247a;

    public /* synthetic */ b(AddCardCustomView addCardCustomView) {
        this.f24247a = addCardCustomView;
    }

    public final void onChanged(Object obj) {
        AddCardCustomView.m5804validateCardNumberDataObserver$lambda0(this.f24247a, (WalletValidateCardNumberState) obj);
    }
}
