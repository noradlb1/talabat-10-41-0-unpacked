package sr;

import androidx.lifecycle.Observer;
import com.talabat.growth.ui.vouchers.entrypoint.HomeScreenHeaderVouchersView;

public final /* synthetic */ class a implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HomeScreenHeaderVouchersView f62900a;

    public /* synthetic */ a(HomeScreenHeaderVouchersView homeScreenHeaderVouchersView) {
        this.f62900a = homeScreenHeaderVouchersView;
    }

    public final void onChanged(Object obj) {
        this.f62900a.handleActiveVouchers((String) obj);
    }
}
