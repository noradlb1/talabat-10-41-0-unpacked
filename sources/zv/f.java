package zv;

import androidx.lifecycle.Observer;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.model.WalletAddCardDisplayModelState;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.view.AddCardCustomView;

public final /* synthetic */ class f implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AddCardCustomView f24251a;

    public /* synthetic */ f(AddCardCustomView addCardCustomView) {
        this.f24251a = addCardCustomView;
    }

    public final void onChanged(Object obj) {
        AddCardCustomView.m5797addCardToWalletDataObserver$lambda4(this.f24251a, (WalletAddCardDisplayModelState) obj);
    }
}
