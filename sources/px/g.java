package px;

import androidx.lifecycle.Observer;
import com.talabat.wallet.bnplmanager.domain.entity.BNPLInstallmentToggleStatus;
import com.talabat.wallet.bnplmanager.ui.BNPLInitiatePlaceOrderFragment;

public final /* synthetic */ class g implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BNPLInitiatePlaceOrderFragment f24059a;

    public /* synthetic */ g(BNPLInitiatePlaceOrderFragment bNPLInitiatePlaceOrderFragment) {
        this.f24059a = bNPLInitiatePlaceOrderFragment;
    }

    public final void onChanged(Object obj) {
        BNPLInitiatePlaceOrderFragment.m5949addObservers$lambda4(this.f24059a, (BNPLInstallmentToggleStatus) obj);
    }
}
