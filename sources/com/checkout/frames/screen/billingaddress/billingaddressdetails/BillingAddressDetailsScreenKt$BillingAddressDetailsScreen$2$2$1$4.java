package com.checkout.frames.screen.billingaddress.billingaddressdetails;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public /* synthetic */ class BillingAddressDetailsScreenKt$BillingAddressDetailsScreen$2$2$1$4 extends FunctionReferenceImpl implements Function2<Integer, String, Unit> {
    public BillingAddressDetailsScreenKt$BillingAddressDetailsScreen$2$2$1$4(Object obj) {
        super(2, obj, BillingAddressDetailsViewModel.class, "onAddressFieldTextChange", "onAddressFieldTextChange(ILjava/lang/String;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Number) obj).intValue(), (String) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(int i11, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "p1");
        ((BillingAddressDetailsViewModel) this.receiver).onAddressFieldTextChange(i11, str);
    }
}
