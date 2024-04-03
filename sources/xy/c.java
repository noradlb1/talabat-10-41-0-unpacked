package xy;

import androidx.lifecycle.Observer;
import com.talabat.talabatcommon.model.wallet.WalletBannerDisplayModel;
import com.talabat.wallet.ui.walletDashboard.view.WalletDashboardFragment;

public final /* synthetic */ class c implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WalletDashboardFragment f24189a;

    public /* synthetic */ c(WalletDashboardFragment walletDashboardFragment) {
        this.f24189a = walletDashboardFragment;
    }

    public final void onChanged(Object obj) {
        WalletDashboardFragment.m6058getWalletBannerConfiguration$lambda6(this.f24189a, (WalletBannerDisplayModel) obj);
    }
}
