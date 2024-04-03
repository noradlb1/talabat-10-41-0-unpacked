package ue;

import androidx.lifecycle.Observer;
import com.talabat.CartScreen;
import com.talabat.feature.fees.presentation.displaymodel.FeeValue;

public final /* synthetic */ class z0 implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CartScreen f57850a;

    public /* synthetic */ z0(CartScreen cartScreen) {
        this.f57850a = cartScreen;
    }

    public final void onChanged(Object obj) {
        this.f57850a.handleSmallOrderFeeValue((FeeValue) obj);
    }
}
