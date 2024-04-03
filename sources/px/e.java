package px;

import androidx.lifecycle.Observer;
import com.talabat.wallet.bnplmanager.presentation.displaymodel.BNPLPaymentDetailsState;
import com.talabat.wallet.bnplmanager.ui.BNPLInitiatePlaceOrderFragment;

public final /* synthetic */ class e implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BNPLInitiatePlaceOrderFragment f24057a;

    public /* synthetic */ e(BNPLInitiatePlaceOrderFragment bNPLInitiatePlaceOrderFragment) {
        this.f24057a = bNPLInitiatePlaceOrderFragment;
    }

    public final void onChanged(Object obj) {
        BNPLInitiatePlaceOrderFragment.m5947addObservers$lambda1(this.f24057a, (BNPLPaymentDetailsState) obj);
    }
}
