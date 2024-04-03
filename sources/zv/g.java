package zv;

import androidx.lifecycle.Observer;
import com.talabat.talabatcommon.views.wallet.debitcarddeflection.presentation.displaymodel.DebitCardBinVerificationDisplayModel;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.view.AddCardCustomView;

public final /* synthetic */ class g implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AddCardCustomView f24252a;

    public /* synthetic */ g(AddCardCustomView addCardCustomView) {
        this.f24252a = addCardCustomView;
    }

    public final void onChanged(Object obj) {
        AddCardCustomView.m5800debitCardBinVerificationDataObserver$lambda5(this.f24252a, (DebitCardBinVerificationDisplayModel) obj);
    }
}
