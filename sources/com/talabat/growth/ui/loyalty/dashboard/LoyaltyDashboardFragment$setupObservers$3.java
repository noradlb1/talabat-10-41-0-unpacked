package com.talabat.growth.ui.loyalty.dashboard;

import com.talabat.growth.ui.loyalty.burn.models.BurnListDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class LoyaltyDashboardFragment$setupObservers$3 extends FunctionReferenceImpl implements Function1<BurnListDisplayModel, Unit> {
    public LoyaltyDashboardFragment$setupObservers$3(Object obj) {
        super(1, obj, LoyaltyDashboardFragment.class, "updateBurnOptions", "updateBurnOptions(Lcom/talabat/growth/ui/loyalty/burn/models/BurnListDisplayModel;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((BurnListDisplayModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable BurnListDisplayModel burnListDisplayModel) {
        ((LoyaltyDashboardFragment) this.receiver).updateBurnOptions(burnListDisplayModel);
    }
}
