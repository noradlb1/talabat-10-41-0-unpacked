package ue;

import androidx.lifecycle.Observer;
import com.talabat.CheckOutScreen;
import com.talabat.feature.fees.presentation.displaymodel.FeeValue;

public final /* synthetic */ class p4 implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CheckOutScreen f57690a;

    public /* synthetic */ p4(CheckOutScreen checkOutScreen) {
        this.f57690a = checkOutScreen;
    }

    public final void onChanged(Object obj) {
        this.f57690a.handleSmallOrderFee((FeeValue) obj);
    }
}
