package qu;

import androidx.lifecycle.Observer;
import com.talabat.sidemenu.SideMenuRewardViewPresenter;

public final /* synthetic */ class m implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SideMenuRewardViewPresenter f62856a;

    public /* synthetic */ m(SideMenuRewardViewPresenter sideMenuRewardViewPresenter) {
        this.f62856a = sideMenuRewardViewPresenter;
    }

    public final void onChanged(Object obj) {
        this.f62856a.enableRewards(((Boolean) obj).booleanValue());
    }
}
