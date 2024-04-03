package ue;

import androidx.lifecycle.Observer;
import com.talabat.CheckOutScreen;
import com.talabat.wallet.checkoutpaymentmanager.presentation.displaymodel.BNPLPlanEligibilityState;

public final /* synthetic */ class b4 implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CheckOutScreen f57447a;

    public /* synthetic */ b4(CheckOutScreen checkOutScreen) {
        this.f57447a = checkOutScreen;
    }

    public final void onChanged(Object obj) {
        this.f57447a.updateBNPLWidget((BNPLPlanEligibilityState) obj);
    }
}
