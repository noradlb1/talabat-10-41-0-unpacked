package com.talabat.wallet.ui.subscriptionManagement.view.bottomsheet;

import com.talabat.talabatcommon.views.wallet.subscription.model.SubscriptionCancellationReasonsDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class SubscriptionCancellationFragment$addObservers$1 extends FunctionReferenceImpl implements Function1<SubscriptionCancellationReasonsDisplayModel, Unit> {
    public SubscriptionCancellationFragment$addObservers$1(Object obj) {
        super(1, obj, SubscriptionCancellationFragment.class, "updateSubscriptionCancellationReasons", "updateSubscriptionCancellationReasons(Lcom/talabat/talabatcommon/views/wallet/subscription/model/SubscriptionCancellationReasonsDisplayModel;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SubscriptionCancellationReasonsDisplayModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable SubscriptionCancellationReasonsDisplayModel subscriptionCancellationReasonsDisplayModel) {
        ((SubscriptionCancellationFragment) this.receiver).updateSubscriptionCancellationReasons(subscriptionCancellationReasonsDisplayModel);
    }
}
