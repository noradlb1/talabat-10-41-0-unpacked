package com.talabat.talabatlife.ui.onBoarding;

import com.talabat.talabatlife.ui.subscription.model.SubscriptionPaymentDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class TLifeOnBoardingFragment$observatory$6 extends FunctionReferenceImpl implements Function1<SubscriptionPaymentDisplayModel, Unit> {
    public TLifeOnBoardingFragment$observatory$6(Object obj) {
        super(1, obj, TLifeOnBoardingFragment.class, "updateNavigationAction", "updateNavigationAction(Lcom/talabat/talabatlife/ui/subscription/model/SubscriptionPaymentDisplayModel;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SubscriptionPaymentDisplayModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable SubscriptionPaymentDisplayModel subscriptionPaymentDisplayModel) {
        ((TLifeOnBoardingFragment) this.receiver).updateNavigationAction(subscriptionPaymentDisplayModel);
    }
}
