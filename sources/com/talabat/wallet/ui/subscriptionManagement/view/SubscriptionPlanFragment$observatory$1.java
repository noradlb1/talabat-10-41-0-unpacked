package com.talabat.wallet.ui.subscriptionManagement.view;

import com.talabat.talabatcommon.views.wallet.subscription.model.SubscriptionPlanDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class SubscriptionPlanFragment$observatory$1 extends FunctionReferenceImpl implements Function1<SubscriptionPlanDisplayModel, Unit> {
    public SubscriptionPlanFragment$observatory$1(Object obj) {
        super(1, obj, SubscriptionPlanFragment.class, "populateAdapterWithPlans", "populateAdapterWithPlans(Lcom/talabat/talabatcommon/views/wallet/subscription/model/SubscriptionPlanDisplayModel;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SubscriptionPlanDisplayModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable SubscriptionPlanDisplayModel subscriptionPlanDisplayModel) {
        ((SubscriptionPlanFragment) this.receiver).populateAdapterWithPlans(subscriptionPlanDisplayModel);
    }
}
