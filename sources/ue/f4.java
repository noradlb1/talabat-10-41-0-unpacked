package ue;

import androidx.lifecycle.Observer;
import com.talabat.CheckOutScreen;
import com.talabat.wallet.bnplmanager.presentation.displaymodel.BNPLOrderPaymentState;

public final /* synthetic */ class f4 implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CheckOutScreen f57523a;

    public /* synthetic */ f4(CheckOutScreen checkOutScreen) {
        this.f57523a = checkOutScreen;
    }

    public final void onChanged(Object obj) {
        this.f57523a.updateBNPLOrderPaymentResult((BNPLOrderPaymentState) obj);
    }
}
