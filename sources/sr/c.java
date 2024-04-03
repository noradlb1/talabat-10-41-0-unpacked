package sr;

import androidx.lifecycle.Observer;
import com.talabat.growth.ui.vouchers.entrypoint.HomeScreenHeaderVouchersView;

public final /* synthetic */ class c implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HomeScreenHeaderVouchersView f62902a;

    public /* synthetic */ c(HomeScreenHeaderVouchersView homeScreenHeaderVouchersView) {
        this.f62902a = homeScreenHeaderVouchersView;
    }

    public final void onChanged(Object obj) {
        this.f62902a.getActiveVouchers(((Boolean) obj).booleanValue());
    }
}
