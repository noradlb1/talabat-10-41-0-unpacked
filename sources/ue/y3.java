package ue;

import androidx.lifecycle.Observer;
import com.talabat.CheckOutScreen;
import com.talabat.wallet.checkoutpaymentmanager.presentation.displaymodel.CheckoutPaymentUpdateDisplayModel;

public final /* synthetic */ class y3 implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CheckOutScreen f57837a;

    public /* synthetic */ y3(CheckOutScreen checkOutScreen) {
        this.f57837a = checkOutScreen;
    }

    public final void onChanged(Object obj) {
        this.f57837a.updateCheckoutPaymentView((CheckoutPaymentUpdateDisplayModel) obj);
    }
}
