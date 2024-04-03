package lr;

import android.view.View;
import com.talabat.growth.ui.loyalty.dashboard.LoyaltyDashboardFragment;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoyaltyDashboardFragment f62259b;

    public /* synthetic */ a(LoyaltyDashboardFragment loyaltyDashboardFragment) {
        this.f62259b = loyaltyDashboardFragment;
    }

    public final void onClick(View view) {
        LoyaltyDashboardFragment.m10607setupLoyaltyPointsSummary$lambda1(this.f62259b, view);
    }
}
