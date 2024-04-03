package cs;

import androidx.lifecycle.Observer;
import com.talabat.home.HomeScreenActivity;
import library.talabat.mvp.home.VoucherStateDomainModel;

public final /* synthetic */ class i implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HomeScreenActivity f61808a;

    public /* synthetic */ i(HomeScreenActivity homeScreenActivity) {
        this.f61808a = homeScreenActivity;
    }

    public final void onChanged(Object obj) {
        HomeScreenActivity.m10640observerVoucherState$lambda47(this.f61808a, (VoucherStateDomainModel) obj);
    }
}
