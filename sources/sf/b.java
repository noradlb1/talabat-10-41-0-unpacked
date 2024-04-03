package sf;

import androidx.lifecycle.Observer;
import com.talabat.checkoutdotcom.CheckoutTokenScreen;
import com.talabat.talabatcommon.views.wallet.debitcarddeflection.presentation.displaymodel.PaymentButtonTypeDisplayModel;

public final /* synthetic */ class b implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CheckoutTokenScreen f57390a;

    public /* synthetic */ b(CheckoutTokenScreen checkoutTokenScreen) {
        this.f57390a = checkoutTokenScreen;
    }

    public final void onChanged(Object obj) {
        this.f57390a.updatePaymentMethod((PaymentButtonTypeDisplayModel) obj);
    }
}
