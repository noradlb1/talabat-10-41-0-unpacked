package ue;

import androidx.lifecycle.Observer;
import com.talabat.CheckOutScreen;
import com.talabat.wallet.checkoutpaymentmanager.presentation.displaymodel.BNPLPopUpViewState;

public final /* synthetic */ class c4 implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CheckOutScreen f57463a;

    public /* synthetic */ c4(CheckOutScreen checkOutScreen) {
        this.f57463a = checkOutScreen;
    }

    public final void onChanged(Object obj) {
        this.f57463a.updateBNPLPopView((BNPLPopUpViewState) obj);
    }
}
