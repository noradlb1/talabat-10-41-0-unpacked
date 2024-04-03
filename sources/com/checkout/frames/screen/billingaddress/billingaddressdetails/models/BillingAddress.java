package com.checkout.frames.screen.billingaddress.billingaddressdetails.models;

import com.checkout.base.model.Country;
import com.checkout.tokenization.model.Address;
import com.checkout.tokenization.model.Phone;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007\b\u0010¢\u0006\u0002\u0010\u0002B)\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\bHÆ\u0003J-\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0004HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/checkout/frames/screen/billingaddress/billingaddressdetails/models/BillingAddress;", "", "()V", "name", "", "address", "Lcom/checkout/tokenization/model/Address;", "phone", "Lcom/checkout/tokenization/model/Phone;", "(Ljava/lang/String;Lcom/checkout/tokenization/model/Address;Lcom/checkout/tokenization/model/Phone;)V", "getAddress", "()Lcom/checkout/tokenization/model/Address;", "getName", "()Ljava/lang/String;", "getPhone", "()Lcom/checkout/tokenization/model/Phone;", "setPhone", "(Lcom/checkout/tokenization/model/Phone;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BillingAddress {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final Lazy<BillingAddress> DEFAULT_BILLING_ADDRESS$delegate = LazyKt__LazyJVMKt.lazy(BillingAddress$Companion$DEFAULT_BILLING_ADDRESS$2.INSTANCE);
    @Nullable
    private final Address address;
    @Nullable

    /* renamed from: name  reason: collision with root package name */
    private final String f44267name;
    @Nullable
    private Phone phone;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0011\u0010\t\u001a\u00020\n*\u00020\u0004H\u0000¢\u0006\u0002\b\u000bR\u001b\u0010\u0003\u001a\u00020\u00048@X\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/checkout/frames/screen/billingaddress/billingaddressdetails/models/BillingAddress$Companion;", "", "()V", "DEFAULT_BILLING_ADDRESS", "Lcom/checkout/frames/screen/billingaddress/billingaddressdetails/models/BillingAddress;", "getDEFAULT_BILLING_ADDRESS$frames_release", "()Lcom/checkout/frames/screen/billingaddress/billingaddressdetails/models/BillingAddress;", "DEFAULT_BILLING_ADDRESS$delegate", "Lkotlin/Lazy;", "isEdited", "", "isEdited$frames_release", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final BillingAddress getDEFAULT_BILLING_ADDRESS$frames_release() {
            return (BillingAddress) BillingAddress.DEFAULT_BILLING_ADDRESS$delegate.getValue();
        }

        public final boolean isEdited$frames_release(@NotNull BillingAddress billingAddress) {
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            String str7;
            String str8;
            String str9;
            String str10;
            Country country;
            Intrinsics.checkNotNullParameter(billingAddress, "<this>");
            if (Intrinsics.areEqual((Object) billingAddress.getName(), (Object) getDEFAULT_BILLING_ADDRESS$frames_release().getName())) {
                Address address = billingAddress.getAddress();
                Country country2 = null;
                if (address != null) {
                    str = address.getAddressLine1();
                } else {
                    str = null;
                }
                Address address2 = getDEFAULT_BILLING_ADDRESS$frames_release().getAddress();
                if (address2 != null) {
                    str2 = address2.getAddressLine1();
                } else {
                    str2 = null;
                }
                if (Intrinsics.areEqual((Object) str, (Object) str2)) {
                    Address address3 = billingAddress.getAddress();
                    if (address3 != null) {
                        str3 = address3.getAddressLine2();
                    } else {
                        str3 = null;
                    }
                    Address address4 = getDEFAULT_BILLING_ADDRESS$frames_release().getAddress();
                    if (address4 != null) {
                        str4 = address4.getAddressLine2();
                    } else {
                        str4 = null;
                    }
                    if (Intrinsics.areEqual((Object) str3, (Object) str4)) {
                        Address address5 = billingAddress.getAddress();
                        if (address5 != null) {
                            str5 = address5.getCity();
                        } else {
                            str5 = null;
                        }
                        Address address6 = getDEFAULT_BILLING_ADDRESS$frames_release().getAddress();
                        if (address6 != null) {
                            str6 = address6.getCity();
                        } else {
                            str6 = null;
                        }
                        if (Intrinsics.areEqual((Object) str5, (Object) str6)) {
                            Address address7 = billingAddress.getAddress();
                            if (address7 != null) {
                                str7 = address7.getState();
                            } else {
                                str7 = null;
                            }
                            Address address8 = getDEFAULT_BILLING_ADDRESS$frames_release().getAddress();
                            if (address8 != null) {
                                str8 = address8.getState();
                            } else {
                                str8 = null;
                            }
                            if (Intrinsics.areEqual((Object) str7, (Object) str8)) {
                                Address address9 = billingAddress.getAddress();
                                if (address9 != null) {
                                    str9 = address9.getZip();
                                } else {
                                    str9 = null;
                                }
                                Address address10 = getDEFAULT_BILLING_ADDRESS$frames_release().getAddress();
                                if (address10 != null) {
                                    str10 = address10.getZip();
                                } else {
                                    str10 = null;
                                }
                                if (Intrinsics.areEqual((Object) str9, (Object) str10)) {
                                    Address address11 = billingAddress.getAddress();
                                    if (address11 != null) {
                                        country = address11.getCountry();
                                    } else {
                                        country = null;
                                    }
                                    Address address12 = getDEFAULT_BILLING_ADDRESS$frames_release().getAddress();
                                    if (address12 != null) {
                                        country2 = address12.getCountry();
                                    }
                                    if (country != country2 || !Intrinsics.areEqual((Object) billingAddress.getPhone(), (Object) getDEFAULT_BILLING_ADDRESS$frames_release().getPhone())) {
                                        return true;
                                    }
                                    return false;
                                }
                            }
                        }
                    }
                }
            }
            return true;
        }
    }

    public BillingAddress(@Nullable String str, @Nullable Address address2, @Nullable Phone phone2) {
        this.f44267name = str;
        this.address = address2;
        this.phone = phone2;
    }

    public static /* synthetic */ BillingAddress copy$default(BillingAddress billingAddress, String str, Address address2, Phone phone2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = billingAddress.f44267name;
        }
        if ((i11 & 2) != 0) {
            address2 = billingAddress.address;
        }
        if ((i11 & 4) != 0) {
            phone2 = billingAddress.phone;
        }
        return billingAddress.copy(str, address2, phone2);
    }

    @Nullable
    public final String component1() {
        return this.f44267name;
    }

    @Nullable
    public final Address component2() {
        return this.address;
    }

    @Nullable
    public final Phone component3() {
        return this.phone;
    }

    @NotNull
    public final BillingAddress copy(@Nullable String str, @Nullable Address address2, @Nullable Phone phone2) {
        return new BillingAddress(str, address2, phone2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BillingAddress)) {
            return false;
        }
        BillingAddress billingAddress = (BillingAddress) obj;
        return Intrinsics.areEqual((Object) this.f44267name, (Object) billingAddress.f44267name) && Intrinsics.areEqual((Object) this.address, (Object) billingAddress.address) && Intrinsics.areEqual((Object) this.phone, (Object) billingAddress.phone);
    }

    @Nullable
    public final Address getAddress() {
        return this.address;
    }

    @Nullable
    public final String getName() {
        return this.f44267name;
    }

    @Nullable
    public final Phone getPhone() {
        return this.phone;
    }

    public int hashCode() {
        String str = this.f44267name;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Address address2 = this.address;
        int hashCode2 = (hashCode + (address2 == null ? 0 : address2.hashCode())) * 31;
        Phone phone2 = this.phone;
        if (phone2 != null) {
            i11 = phone2.hashCode();
        }
        return hashCode2 + i11;
    }

    public final void setPhone(@Nullable Phone phone2) {
        this.phone = phone2;
    }

    @NotNull
    public String toString() {
        String str = this.f44267name;
        Address address2 = this.address;
        Phone phone2 = this.phone;
        return "BillingAddress(name=" + str + ", address=" + address2 + ", phone=" + phone2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BillingAddress(String str, Address address2, Phone phone2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : address2, (i11 & 4) != 0 ? null : phone2);
    }

    public BillingAddress() {
        this("", new Address("", "", "", "", "", Country.INVALID_COUNTRY), (Phone) null, 4, (DefaultConstructorMarker) null);
    }
}
