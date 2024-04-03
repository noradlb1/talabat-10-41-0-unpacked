package com.talabat.feature.tpro.presentation.benefits.adapter.onboarding;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class TProOnBoardingAdapter$onBindViewHolder$1 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
    public TProOnBoardingAdapter$onBindViewHolder$1(Object obj) {
        super(1, obj, TProOnBoardingAdapter.class, "notifyForAnimation", "notifyForAnimation(I)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i11) {
        ((TProOnBoardingAdapter) this.receiver).notifyForAnimation(i11);
    }
}
