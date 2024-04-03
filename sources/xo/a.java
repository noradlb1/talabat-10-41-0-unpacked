package xo;

import androidx.lifecycle.Observer;
import com.talabat.feature.subscriptions.domain.model.ProVendorMov;
import com.talabat.feature.tpro.presentation.helperview.mov.wrapper.VendorMenuTProMovWrapper;

public final /* synthetic */ class a implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VendorMenuTProMovWrapper f63035a;

    public /* synthetic */ a(VendorMenuTProMovWrapper vendorMenuTProMovWrapper) {
        this.f63035a = vendorMenuTProMovWrapper;
    }

    public final void onChanged(Object obj) {
        this.f63035a.handleProVendorMov((ProVendorMov) obj);
    }
}
