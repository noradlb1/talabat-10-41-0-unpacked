package ue;

import androidx.lifecycle.Observer;
import com.talabat.CheckOutScreen;
import com.talabat.talabatcommon.views.checkoutForceCVV.viewModel.displaymodel.ProceedToPaymentDisplayModel;

public final /* synthetic */ class r3 implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CheckOutScreen f57717a;

    public /* synthetic */ r3(CheckOutScreen checkOutScreen) {
        this.f57717a = checkOutScreen;
    }

    public final void onChanged(Object obj) {
        this.f57717a.updateProceedToPayment((ProceedToPaymentDisplayModel) obj);
    }
}
