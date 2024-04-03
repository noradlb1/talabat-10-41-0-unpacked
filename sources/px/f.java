package px;

import androidx.lifecycle.Observer;
import com.talabat.wallet.bnplmanager.ui.BNPLInitiatePlaceOrderFragment;

public final /* synthetic */ class f implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BNPLInitiatePlaceOrderFragment f24058a;

    public /* synthetic */ f(BNPLInitiatePlaceOrderFragment bNPLInitiatePlaceOrderFragment) {
        this.f24058a = bNPLInitiatePlaceOrderFragment;
    }

    public final void onChanged(Object obj) {
        BNPLInitiatePlaceOrderFragment.m5948addObservers$lambda2(this.f24058a, (Boolean) obj);
    }
}
