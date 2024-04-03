package com.checkout.frames.screen.billingaddress.billingaddressdetails.models;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"withOptional", "Lcom/checkout/frames/screen/billingaddress/billingaddressdetails/models/BillingFormFields;", "isOptional", "", "frames_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class BillingFormFieldsKt {
    @NotNull
    public static final BillingFormFields withOptional(@NotNull BillingFormFields billingFormFields, boolean z11) {
        Intrinsics.checkNotNullParameter(billingFormFields, "<this>");
        billingFormFields.setFieldOptional$frames_release(z11);
        return billingFormFields;
    }
}
