package com.checkout.frames.screen.billingaddress.billingaddressdetails;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public /* synthetic */ class BillingAddressDetailsScreenKt$BillingAddressDetailsScreen$2$2$1$3 extends FunctionReferenceImpl implements Function2<Integer, Boolean, Unit> {
    public BillingAddressDetailsScreenKt$BillingAddressDetailsScreen$2$2$1$3(Object obj) {
        super(2, obj, BillingAddressDetailsViewModel.class, "onFocusChanged", "onFocusChanged(IZ)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Number) obj).intValue(), ((Boolean) obj2).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i11, boolean z11) {
        ((BillingAddressDetailsViewModel) this.receiver).onFocusChanged(i11, z11);
    }
}
