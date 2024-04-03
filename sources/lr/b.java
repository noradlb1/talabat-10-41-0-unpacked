package lr;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.talabat.growth.ui.loyalty.dashboard.LoyaltyDashboardFragment;

public final /* synthetic */ class b implements SwipeRefreshLayout.OnRefreshListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoyaltyDashboardFragment f62260b;

    public /* synthetic */ b(LoyaltyDashboardFragment loyaltyDashboardFragment) {
        this.f62260b = loyaltyDashboardFragment;
    }

    public final void onRefresh() {
        LoyaltyDashboardFragment.m10608setupSwipeRefresh$lambda3(this.f62260b);
    }
}
