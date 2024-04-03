package ue;

import androidx.lifecycle.Observer;
import com.talabat.CheckOutScreen;
import com.talabat.feature.fees.presentation.displaymodel.FeeValue;

public final /* synthetic */ class q4 implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CheckOutScreen f57704a;

    public /* synthetic */ q4(CheckOutScreen checkOutScreen) {
        this.f57704a = checkOutScreen;
    }

    public final void onChanged(Object obj) {
        this.f57704a.handleDeliveryFee((FeeValue) obj);
    }
}
