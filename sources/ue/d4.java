package ue;

import androidx.lifecycle.Observer;
import com.talabat.CheckOutScreen;
import com.talabat.talabatcommon.views.wallet.debitcarddeflection.presentation.displaymodel.PaymentButtonTypeDisplayModel;

public final /* synthetic */ class d4 implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CheckOutScreen f57485a;

    public /* synthetic */ d4(CheckOutScreen checkOutScreen) {
        this.f57485a = checkOutScreen;
    }

    public final void onChanged(Object obj) {
        this.f57485a.updatePaymentMethod((PaymentButtonTypeDisplayModel) obj);
    }
}
