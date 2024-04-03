package com.talabat.growth.ui.loyalty.dashboard;

import com.talabat.growth.ui.loyalty.models.LoyaltyPointsDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class LoyaltyDashboardFragment$setupObservers$6 extends FunctionReferenceImpl implements Function1<LoyaltyPointsDisplayModel, Unit> {
    public LoyaltyDashboardFragment$setupObservers$6(Object obj) {
        super(1, obj, LoyaltyDashboardFragment.class, "showHistory", "showHistory(Lcom/talabat/growth/ui/loyalty/models/LoyaltyPointsDisplayModel;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LoyaltyPointsDisplayModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable LoyaltyPointsDisplayModel loyaltyPointsDisplayModel) {
        ((LoyaltyDashboardFragment) this.receiver).showHistory(loyaltyPointsDisplayModel);
    }
}
