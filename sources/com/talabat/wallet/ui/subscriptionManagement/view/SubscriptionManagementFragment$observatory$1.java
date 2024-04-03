package com.talabat.wallet.ui.subscriptionManagement.view;

import com.talabat.talabatcommon.views.wallet.subscription.model.SubscriptionViewDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class SubscriptionManagementFragment$observatory$1 extends FunctionReferenceImpl implements Function1<SubscriptionViewDisplayModel, Unit> {
    public SubscriptionManagementFragment$observatory$1(Object obj) {
        super(1, obj, SubscriptionManagementFragment.class, "populateAdapter", "populateAdapter(Lcom/talabat/talabatcommon/views/wallet/subscription/model/SubscriptionViewDisplayModel;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SubscriptionViewDisplayModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable SubscriptionViewDisplayModel subscriptionViewDisplayModel) {
        ((SubscriptionManagementFragment) this.receiver).populateAdapter(subscriptionViewDisplayModel);
    }
}
