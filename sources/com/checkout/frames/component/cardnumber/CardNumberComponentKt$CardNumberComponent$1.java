package com.checkout.frames.component.cardnumber;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public /* synthetic */ class CardNumberComponentKt$CardNumberComponent$1 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
    public CardNumberComponentKt$CardNumberComponent$1(Object obj) {
        super(1, obj, CardNumberViewModel.class, "onFocusChanged", "onFocusChanged(Z)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z11) {
        ((CardNumberViewModel) this.receiver).onFocusChanged(z11);
    }
}
