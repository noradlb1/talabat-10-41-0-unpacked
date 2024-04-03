package qu;

import androidx.lifecycle.Observer;
import com.talabat.growth.ui.loyalty.models.LoyaltyPointsDisplayModel;
import com.talabat.sidemenu.SideMenuRewardViewPresenter;

public final /* synthetic */ class n implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SideMenuRewardViewPresenter f62857a;

    public /* synthetic */ n(SideMenuRewardViewPresenter sideMenuRewardViewPresenter) {
        this.f62857a = sideMenuRewardViewPresenter;
    }

    public final void onChanged(Object obj) {
        this.f62857a.updateUI((LoyaltyPointsDisplayModel) obj);
    }
}
