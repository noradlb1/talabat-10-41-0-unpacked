package qu;

import androidx.lifecycle.Observer;
import com.talabat.sidemenu.SideMenuRewardViewPresenter;
import com.talabat.talabatcore.exception.Failure;

public final /* synthetic */ class o implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SideMenuRewardViewPresenter f62858a;

    public /* synthetic */ o(SideMenuRewardViewPresenter sideMenuRewardViewPresenter) {
        this.f62858a = sideMenuRewardViewPresenter;
    }

    public final void onChanged(Object obj) {
        this.f62858a.failed((Failure) obj);
    }
}
