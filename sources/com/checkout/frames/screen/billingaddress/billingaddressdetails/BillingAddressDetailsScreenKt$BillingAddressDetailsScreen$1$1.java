package com.checkout.frames.screen.billingaddress.billingaddressdetails;

import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class BillingAddressDetailsScreenKt$BillingAddressDetailsScreen$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ MutableState<Boolean> $resetFocus;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BillingAddressDetailsScreenKt$BillingAddressDetailsScreen$1$1(MutableState<Boolean> mutableState) {
        super(0);
        this.$resetFocus = mutableState;
    }

    public final void invoke() {
        this.$resetFocus.setValue(Boolean.TRUE);
    }
}
