package sf;

import androidx.lifecycle.Observer;
import com.talabat.checkoutdotcom.CheckoutTokenScreen;
import com.talabat.feature.fees.presentation.displaymodel.FeeValue;

public final /* synthetic */ class f implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CheckoutTokenScreen f57394a;

    public /* synthetic */ f(CheckoutTokenScreen checkoutTokenScreen) {
        this.f57394a = checkoutTokenScreen;
    }

    public final void onChanged(Object obj) {
        this.f57394a.showSmallOrderFee((FeeValue) obj);
    }
}
