package ue;

import androidx.lifecycle.Observer;
import com.talabat.CheckOutScreen;
import com.talabat.wallet.checkoutpaymentmanager.presentation.displaymodel.WalletBalanceDisplayModel;

public final /* synthetic */ class a4 implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CheckOutScreen f57426a;

    public /* synthetic */ a4(CheckOutScreen checkOutScreen) {
        this.f57426a = checkOutScreen;
    }

    public final void onChanged(Object obj) {
        this.f57426a.updateWalletBalanceView((WalletBalanceDisplayModel) obj);
    }
}
