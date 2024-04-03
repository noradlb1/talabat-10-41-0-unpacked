package sr;

import androidx.lifecycle.Observer;
import com.talabat.growth.ui.vouchers.entrypoint.HomeScreenHeaderVouchersView;

public final /* synthetic */ class d implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HomeScreenHeaderVouchersView f62903a;

    public /* synthetic */ d(HomeScreenHeaderVouchersView homeScreenHeaderVouchersView) {
        this.f62903a = homeScreenHeaderVouchersView;
    }

    public final void onChanged(Object obj) {
        HomeScreenHeaderVouchersView.m10614onAttachedToWindow$lambda2$lambda1(this.f62903a, (Boolean) obj);
    }
}
