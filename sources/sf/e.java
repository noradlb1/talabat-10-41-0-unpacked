package sf;

import androidx.lifecycle.Observer;
import com.talabat.checkoutdotcom.CheckoutTokenScreen;
import com.talabat.feature.fees.presentation.displaymodel.FeeValue;

public final /* synthetic */ class e implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CheckoutTokenScreen f57393a;

    public /* synthetic */ e(CheckoutTokenScreen checkoutTokenScreen) {
        this.f57393a = checkoutTokenScreen;
    }

    public final void onChanged(Object obj) {
        this.f57393a.showServiceFee((FeeValue) obj);
    }
}
