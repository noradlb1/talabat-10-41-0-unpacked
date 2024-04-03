package com.talabat.growth.ui.loyalty.dashboard;

import com.talabat.growth.ui.loyalty.dashboard.viewModel.LoyaltyDashboardViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class LoyaltyDashboardFragment$showBottomSheet$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LoyaltyDashboardFragment f60655g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LoyaltyDashboardFragment$showBottomSheet$1(LoyaltyDashboardFragment loyaltyDashboardFragment) {
        super(0);
        this.f60655g = loyaltyDashboardFragment;
    }

    public final void invoke() {
        LoyaltyDashboardViewModel.getPointsSummary$default(this.f60655g.getViewModel(), (String) null, 1, (Object) null);
    }
}
