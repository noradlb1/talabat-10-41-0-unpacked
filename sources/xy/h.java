package xy;

import android.view.View;
import com.talabat.talabatcommon.model.wallet.WalletBannerDisplayModel;
import com.talabat.wallet.ui.walletDashboard.view.WalletDashboardFragment;

public final /* synthetic */ class h implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WalletDashboardFragment f24194b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ WalletBannerDisplayModel f24195c;

    public /* synthetic */ h(WalletDashboardFragment walletDashboardFragment, WalletBannerDisplayModel walletBannerDisplayModel) {
        this.f24194b = walletDashboardFragment;
        this.f24195c = walletBannerDisplayModel;
    }

    public final void onClick(View view) {
        WalletDashboardFragment.m6059loadDynamicBannerForEmptyView$lambda7(this.f24194b, this.f24195c, view);
    }
}
