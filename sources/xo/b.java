package xo;

import androidx.lifecycle.Observer;
import com.talabat.feature.tpro.presentation.helperview.mov.wrapper.VendorMenuTProMovWrapper;

public final /* synthetic */ class b implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VendorMenuTProMovWrapper f63036a;

    public /* synthetic */ b(VendorMenuTProMovWrapper vendorMenuTProMovWrapper) {
        this.f63036a = vendorMenuTProMovWrapper;
    }

    public final void onChanged(Object obj) {
        this.f63036a.handleProVendorMovFailure((Throwable) obj);
    }
}
