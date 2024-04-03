package com.talabat.wallet.ui.subscriptionManagement.view.fragment;

import com.talabat.talabatcommon.views.wallet.subscription.model.SubscriptionItemDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class SubscriptionDetailFragment$observatory$1 extends FunctionReferenceImpl implements Function1<SubscriptionItemDisplayModel, Unit> {
    public SubscriptionDetailFragment$observatory$1(Object obj) {
        super(1, obj, SubscriptionDetailFragment.class, "updateSubscriptionDetail", "updateSubscriptionDetail(Lcom/talabat/talabatcommon/views/wallet/subscription/model/SubscriptionItemDisplayModel;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SubscriptionItemDisplayModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable SubscriptionItemDisplayModel subscriptionItemDisplayModel) {
        ((SubscriptionDetailFragment) this.receiver).updateSubscriptionDetail(subscriptionItemDisplayModel);
    }
}
