package lr;

import android.view.View;
import com.talabat.growth.ui.loyalty.burn.models.BurnItemCategoryDisplayModel;
import com.talabat.growth.ui.loyalty.dashboard.LoyaltyDashboardFragment;

public final /* synthetic */ class d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoyaltyDashboardFragment f62265b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f62266c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f62267d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ BurnItemCategoryDisplayModel f62268e;

    public /* synthetic */ d(LoyaltyDashboardFragment loyaltyDashboardFragment, String str, int i11, BurnItemCategoryDisplayModel burnItemCategoryDisplayModel) {
        this.f62265b = loyaltyDashboardFragment;
        this.f62266c = str;
        this.f62267d = i11;
        this.f62268e = burnItemCategoryDisplayModel;
    }

    public final void onClick(View view) {
        LoyaltyDashboardFragment.m10604getHeroCard$lambda12$lambda11(this.f62265b, this.f62266c, this.f62267d, this.f62268e, view);
    }
}
