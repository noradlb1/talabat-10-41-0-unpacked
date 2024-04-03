package com.talabat.growth.ui.loyalty.history;

import com.talabat.growth.ui.loyalty.models.LoyaltyHistoryDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class LoyaltyHistoryFragment$observatory$1 extends FunctionReferenceImpl implements Function1<LoyaltyHistoryDisplayModel, Unit> {
    public LoyaltyHistoryFragment$observatory$1(Object obj) {
        super(1, obj, LoyaltyHistoryFragment.class, "updateUI", "updateUI(Lcom/talabat/growth/ui/loyalty/models/LoyaltyHistoryDisplayModel;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LoyaltyHistoryDisplayModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable LoyaltyHistoryDisplayModel loyaltyHistoryDisplayModel) {
        ((LoyaltyHistoryFragment) this.receiver).updateUI(loyaltyHistoryDisplayModel);
    }
}
