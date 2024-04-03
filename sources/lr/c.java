package lr;

import android.view.View;
import com.talabat.growth.ui.loyalty.burn.models.BurnItemCategoryDisplayModel;
import com.talabat.growth.ui.loyalty.dashboard.LoyaltyDashboardFragment;

public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoyaltyDashboardFragment f62261b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f62262c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f62263d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ BurnItemCategoryDisplayModel f62264e;

    public /* synthetic */ c(LoyaltyDashboardFragment loyaltyDashboardFragment, String str, int i11, BurnItemCategoryDisplayModel burnItemCategoryDisplayModel) {
        this.f62261b = loyaltyDashboardFragment;
        this.f62262c = str;
        this.f62263d = i11;
        this.f62264e = burnItemCategoryDisplayModel;
    }

    public final void onClick(View view) {
        LoyaltyDashboardFragment.m10605getHorizontalListView$lambda14$lambda13(this.f62261b, this.f62262c, this.f62263d, this.f62264e, view);
    }
}
