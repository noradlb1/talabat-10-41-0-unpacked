package px;

import androidx.lifecycle.Observer;
import com.talabat.talabatcommon.model.wallet.WalletCardDisplayModel;
import com.talabat.wallet.bnplmanager.ui.BNPLInitiatePlaceOrderFragment;

public final /* synthetic */ class i implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BNPLInitiatePlaceOrderFragment f24061a;

    public /* synthetic */ i(BNPLInitiatePlaceOrderFragment bNPLInitiatePlaceOrderFragment) {
        this.f24061a = bNPLInitiatePlaceOrderFragment;
    }

    public final void onChanged(Object obj) {
        BNPLInitiatePlaceOrderFragment.m5951addObservers$lambda8(this.f24061a, (WalletCardDisplayModel) obj);
    }
}
