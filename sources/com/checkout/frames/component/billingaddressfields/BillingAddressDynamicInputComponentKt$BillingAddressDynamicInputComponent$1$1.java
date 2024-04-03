package com.checkout.frames.component.billingaddressfields;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class BillingAddressDynamicInputComponentKt$BillingAddressDynamicInputComponent$1$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ Function2<Integer, Boolean, Unit> $onFocusChanged;
    final /* synthetic */ int $position;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BillingAddressDynamicInputComponentKt$BillingAddressDynamicInputComponent$1$1(Function2<? super Integer, ? super Boolean, Unit> function2, int i11) {
        super(1);
        this.$onFocusChanged = function2;
        this.$position = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z11) {
        this.$onFocusChanged.invoke(Integer.valueOf(this.$position), Boolean.valueOf(z11));
    }
}
