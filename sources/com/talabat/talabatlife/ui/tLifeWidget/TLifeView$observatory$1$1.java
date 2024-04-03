package com.talabat.talabatlife.ui.tLifeWidget;

import com.talabat.talabatlife.ui.tLifeWidget.model.SubscriptionStatusDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class TLifeView$observatory$1$1 extends FunctionReferenceImpl implements Function1<SubscriptionStatusDisplayModel, Unit> {
    public TLifeView$observatory$1$1(Object obj) {
        super(1, obj, TLifeView.class, "updateUserTLifeSubscription", "updateUserTLifeSubscription(Lcom/talabat/talabatlife/ui/tLifeWidget/model/SubscriptionStatusDisplayModel;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SubscriptionStatusDisplayModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable SubscriptionStatusDisplayModel subscriptionStatusDisplayModel) {
        ((TLifeView) this.receiver).updateUserTLifeSubscription(subscriptionStatusDisplayModel);
    }
}
