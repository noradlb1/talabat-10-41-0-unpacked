package com.talabat.feature.tpro.presentation.management.details;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class TProSubscriptionDetailsFragment$bindContent$1$contentAdapter$3 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
    public TProSubscriptionDetailsFragment$bindContent$1$contentAdapter$3(Object obj) {
        super(1, obj, TProSubscriptionDetailsFragment.class, "onCreditCardsLoaded", "onCreditCardsLoaded(Z)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z11) {
        ((TProSubscriptionDetailsFragment) this.receiver).onCreditCardsLoaded(z11);
    }
}
