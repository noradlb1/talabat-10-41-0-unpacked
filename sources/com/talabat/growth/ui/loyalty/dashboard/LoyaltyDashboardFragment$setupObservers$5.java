package com.talabat.growth.ui.loyalty.dashboard;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class LoyaltyDashboardFragment$setupObservers$5 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
    public LoyaltyDashboardFragment$setupObservers$5(Object obj) {
        super(1, obj, LoyaltyDashboardFragment.class, "showHowItWorks", "showHowItWorks(Ljava/lang/Integer;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Integer) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Integer num) {
        ((LoyaltyDashboardFragment) this.receiver).showHowItWorks(num);
    }
}
