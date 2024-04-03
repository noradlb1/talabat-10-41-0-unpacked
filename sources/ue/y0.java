package ue;

import androidx.lifecycle.Observer;
import com.talabat.CartScreen;
import com.talabat.feature.fees.presentation.displaymodel.FeeValue;

public final /* synthetic */ class y0 implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CartScreen f57832a;

    public /* synthetic */ y0(CartScreen cartScreen) {
        this.f57832a = cartScreen;
    }

    public final void onChanged(Object obj) {
        this.f57832a.handleServiceFeeValue((FeeValue) obj);
    }
}
