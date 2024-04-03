package px;

import androidx.lifecycle.Observer;
import com.talabat.wallet.bnplmanager.presentation.displaymodel.BNPLOrderPaymentState;
import com.talabat.wallet.bnplmanager.ui.BNPLInitiatePlaceOrderFragment;

public final /* synthetic */ class h implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BNPLInitiatePlaceOrderFragment f24060a;

    public /* synthetic */ h(BNPLInitiatePlaceOrderFragment bNPLInitiatePlaceOrderFragment) {
        this.f24060a = bNPLInitiatePlaceOrderFragment;
    }

    public final void onChanged(Object obj) {
        BNPLInitiatePlaceOrderFragment.m5950addObservers$lambda6(this.f24060a, (BNPLOrderPaymentState) obj);
    }
}
