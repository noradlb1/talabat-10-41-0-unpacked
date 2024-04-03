package com.talabat.talabatlife.ui.vendorOffers;

import com.talabat.talabatlife.ui.subscription.model.SubscriptionPaymentDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class VendorOffersFragment$observatory$4 extends FunctionReferenceImpl implements Function1<SubscriptionPaymentDisplayModel, Unit> {
    public VendorOffersFragment$observatory$4(Object obj) {
        super(1, obj, VendorOffersFragment.class, "subscriptionPayment", "subscriptionPayment(Lcom/talabat/talabatlife/ui/subscription/model/SubscriptionPaymentDisplayModel;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SubscriptionPaymentDisplayModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable SubscriptionPaymentDisplayModel subscriptionPaymentDisplayModel) {
        ((VendorOffersFragment) this.receiver).subscriptionPayment(subscriptionPaymentDisplayModel);
    }
}
