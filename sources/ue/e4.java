package ue;

import androidx.lifecycle.Observer;
import com.talabat.CheckOutScreen;
import com.talabat.wallet.payproxymanager.preesentation.displaymodel.SendCVVToProxyDisplayModel;

public final /* synthetic */ class e4 implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CheckOutScreen f57503a;

    public /* synthetic */ e4(CheckOutScreen checkOutScreen) {
        this.f57503a = checkOutScreen;
    }

    public final void onChanged(Object obj) {
        this.f57503a.updatePayProxyData((SendCVVToProxyDisplayModel) obj);
    }
}
