package com.checkout.frames.component.billingaddressfields;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class BillingAddressDynamicInputComponentKt$BillingAddressDynamicInputComponent$2$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ Function2<Integer, String, Unit> $onValueChange;
    final /* synthetic */ int $position;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BillingAddressDynamicInputComponentKt$BillingAddressDynamicInputComponent$2$1(Function2<? super Integer, ? super String, Unit> function2, int i11) {
        super(1);
        this.$onValueChange = function2;
        this.$position = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        this.$onValueChange.invoke(Integer.valueOf(this.$position), str);
    }
}
