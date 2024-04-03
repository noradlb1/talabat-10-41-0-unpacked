package ue;

import androidx.lifecycle.Observer;
import com.talabat.CheckOutScreen;
import com.talabat.wallet.bnplmanager.domain.entity.BNPLPaymentFallbackEligibleStatus;

public final /* synthetic */ class u2 implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CheckOutScreen f57767a;

    public /* synthetic */ u2(CheckOutScreen checkOutScreen) {
        this.f57767a = checkOutScreen;
    }

    public final void onChanged(Object obj) {
        this.f57767a.handleBnplPaymentFallbackEligibileState((BNPLPaymentFallbackEligibleStatus) obj);
    }
}
