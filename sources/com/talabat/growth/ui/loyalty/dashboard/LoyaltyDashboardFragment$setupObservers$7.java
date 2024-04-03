package com.talabat.growth.ui.loyalty.dashboard;

import com.talabat.growth.ui.loyalty.dashboard.viewModel.FeaturedListData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class LoyaltyDashboardFragment$setupObservers$7 extends FunctionReferenceImpl implements Function1<FeaturedListData, Unit> {
    public LoyaltyDashboardFragment$setupObservers$7(Object obj) {
        super(1, obj, LoyaltyDashboardFragment.class, "navigateToFeaturedList", "navigateToFeaturedList(Lcom/talabat/growth/ui/loyalty/dashboard/viewModel/FeaturedListData;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((FeaturedListData) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable FeaturedListData featuredListData) {
        ((LoyaltyDashboardFragment) this.receiver).navigateToFeaturedList(featuredListData);
    }
}
