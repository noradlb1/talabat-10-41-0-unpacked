package zv;

import androidx.lifecycle.Observer;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.view.AddCardCustomView;

public final /* synthetic */ class e implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AddCardCustomView f24250a;

    public /* synthetic */ e(AddCardCustomView addCardCustomView) {
        this.f24250a = addCardCustomView;
    }

    public final void onChanged(Object obj) {
        AddCardCustomView.m5799cardFieldsValidationDataObserver$lambda3(this.f24250a, (Boolean) obj);
    }
}
