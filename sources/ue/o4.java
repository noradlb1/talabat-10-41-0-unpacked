package ue;

import androidx.lifecycle.Observer;
import com.talabat.CheckOutScreen;
import com.talabat.feature.fees.presentation.displaymodel.FeeValue;

public final /* synthetic */ class o4 implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CheckOutScreen f57675a;

    public /* synthetic */ o4(CheckOutScreen checkOutScreen) {
        this.f57675a = checkOutScreen;
    }

    public final void onChanged(Object obj) {
        this.f57675a.handleServiceFee((FeeValue) obj);
    }
}
