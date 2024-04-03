package ue;

import androidx.lifecycle.Observer;
import com.talabat.CheckOutScreen;
import com.talabat.wallet.checkoutbinvoucher.presentation.displaymodel.CheckoutBinVoucherState;

public final /* synthetic */ class v2 implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CheckOutScreen f57790a;

    public /* synthetic */ v2(CheckOutScreen checkOutScreen) {
        this.f57790a = checkOutScreen;
    }

    public final void onChanged(Object obj) {
        this.f57790a.updateBinVoucherData((CheckoutBinVoucherState) obj);
    }
}
