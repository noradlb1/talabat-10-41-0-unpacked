package ue;

import androidx.lifecycle.Observer;
import com.talabat.CartScreen;
import com.talabat.feature.fees.presentation.displaymodel.FeeValue;

public final /* synthetic */ class a1 implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CartScreen f57422a;

    public /* synthetic */ a1(CartScreen cartScreen) {
        this.f57422a = cartScreen;
    }

    public final void onChanged(Object obj) {
        this.f57422a.handleDeliveryFeeValue((FeeValue) obj);
    }
}
