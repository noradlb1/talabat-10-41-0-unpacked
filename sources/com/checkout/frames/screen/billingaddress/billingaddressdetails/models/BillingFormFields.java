package com.checkout.frames.screen.billingaddress.billingaddressdetails.models;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0001\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u0011\b\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, d2 = {"Lcom/checkout/frames/screen/billingaddress/billingaddressdetails/models/BillingFormFields;", "", "isFieldOptional", "", "(Ljava/lang/String;IZ)V", "isFieldOptional$frames_release", "()Z", "setFieldOptional$frames_release", "(Z)V", "FullName", "AddressLineOne", "AddressLineTwo", "City", "State", "PostCode", "Country", "Phone", "Companion", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public enum BillingFormFields {
    FullName(false, 1, (boolean) null),
    AddressLineOne(false, 1, (boolean) null),
    AddressLineTwo(false, 1, (boolean) null),
    City(false, 1, (boolean) null),
    State(false, 1, (boolean) null),
    PostCode(false, 1, (boolean) null),
    Country(false, 1, (boolean) null),
    Phone(false, 1, (boolean) null);
    
    @NotNull
    public static final Companion Companion = null;
    private boolean isFieldOptional;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007¨\u0006\u0007"}, d2 = {"Lcom/checkout/frames/screen/billingaddress/billingaddressdetails/models/BillingFormFields$Companion;", "", "()V", "fetchAllDefaultBillingFormFields", "", "Lcom/checkout/frames/screen/billingaddress/billingaddressdetails/models/BillingFormFields;", "fetchAllMandatoryBillingFormFields", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final List<BillingFormFields> fetchAllDefaultBillingFormFields() {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(CollectionsKt__CollectionsKt.listOf(BillingFormFieldsKt.withOptional(BillingFormFields.FullName, false), BillingFormFieldsKt.withOptional(BillingFormFields.AddressLineOne, false), BillingFormFieldsKt.withOptional(BillingFormFields.AddressLineTwo, true), BillingFormFieldsKt.withOptional(BillingFormFields.City, false), BillingFormFieldsKt.withOptional(BillingFormFields.State, true), BillingFormFieldsKt.withOptional(BillingFormFields.PostCode, false), BillingFormFieldsKt.withOptional(BillingFormFields.Country, false), BillingFormFieldsKt.withOptional(BillingFormFields.Phone, false)));
            return arrayList;
        }

        @JvmStatic
        @NotNull
        public final List<BillingFormFields> fetchAllMandatoryBillingFormFields() {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(CollectionsKt__CollectionsKt.listOf(BillingFormFieldsKt.withOptional(BillingFormFields.Country, false), BillingFormFieldsKt.withOptional(BillingFormFields.Phone, false)));
            return arrayList;
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    private BillingFormFields(boolean z11) {
        this.isFieldOptional = z11;
    }

    @JvmStatic
    @NotNull
    public static final List<BillingFormFields> fetchAllDefaultBillingFormFields() {
        return Companion.fetchAllDefaultBillingFormFields();
    }

    @JvmStatic
    @NotNull
    public static final List<BillingFormFields> fetchAllMandatoryBillingFormFields() {
        return Companion.fetchAllMandatoryBillingFormFields();
    }

    public final boolean isFieldOptional$frames_release() {
        return this.isFieldOptional;
    }

    public final void setFieldOptional$frames_release(boolean z11) {
        this.isFieldOptional = z11;
    }
}
