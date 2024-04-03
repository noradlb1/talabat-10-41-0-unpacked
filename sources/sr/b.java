package sr;

import androidx.lifecycle.Observer;
import com.talabat.growth.ui.vouchers.entrypoint.HomeScreenHeaderVouchersView;

public final /* synthetic */ class b implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HomeScreenHeaderVouchersView f62901a;

    public /* synthetic */ b(HomeScreenHeaderVouchersView homeScreenHeaderVouchersView) {
        this.f62901a = homeScreenHeaderVouchersView;
    }

    public final void onChanged(Object obj) {
        this.f62901a.handleActiveVoucherVisibility((Boolean) obj);
    }
}
