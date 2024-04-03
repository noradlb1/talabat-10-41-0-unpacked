package com.checkout.validation.model;

import com.adyen.checkout.core.model.Address;
import com.checkout.base.model.Country;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B7\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006 "}, d2 = {"Lcom/checkout/validation/model/AddressValidationRequest;", "", "addressLine1", "", "addressLine2", "city", "state", "zip", "country", "Lcom/checkout/base/model/Country;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/checkout/base/model/Country;)V", "getAddressLine1", "()Ljava/lang/String;", "getAddressLine2", "getCity", "getCountry", "()Lcom/checkout/base/model/Country;", "getState", "getZip", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AddressValidationRequest {
    @NotNull
    private final String addressLine1;
    @NotNull
    private final String addressLine2;
    @NotNull
    private final String city;
    @NotNull
    private final Country country;
    @NotNull
    private final String state;
    @NotNull
    private final String zip;

    public AddressValidationRequest(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull Country country2) {
        Intrinsics.checkNotNullParameter(str, "addressLine1");
        Intrinsics.checkNotNullParameter(str2, "addressLine2");
        Intrinsics.checkNotNullParameter(str3, Address.KEY_CITY);
        Intrinsics.checkNotNullParameter(str4, "state");
        Intrinsics.checkNotNullParameter(str5, ArchiveStreamFactory.ZIP);
        Intrinsics.checkNotNullParameter(country2, "country");
        this.addressLine1 = str;
        this.addressLine2 = str2;
        this.city = str3;
        this.state = str4;
        this.zip = str5;
        this.country = country2;
    }

    public static /* synthetic */ AddressValidationRequest copy$default(AddressValidationRequest addressValidationRequest, String str, String str2, String str3, String str4, String str5, Country country2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = addressValidationRequest.addressLine1;
        }
        if ((i11 & 2) != 0) {
            str2 = addressValidationRequest.addressLine2;
        }
        String str6 = str2;
        if ((i11 & 4) != 0) {
            str3 = addressValidationRequest.city;
        }
        String str7 = str3;
        if ((i11 & 8) != 0) {
            str4 = addressValidationRequest.state;
        }
        String str8 = str4;
        if ((i11 & 16) != 0) {
            str5 = addressValidationRequest.zip;
        }
        String str9 = str5;
        if ((i11 & 32) != 0) {
            country2 = addressValidationRequest.country;
        }
        return addressValidationRequest.copy(str, str6, str7, str8, str9, country2);
    }

    @NotNull
    public final String component1() {
        return this.addressLine1;
    }

    @NotNull
    public final String component2() {
        return this.addressLine2;
    }

    @NotNull
    public final String component3() {
        return this.city;
    }

    @NotNull
    public final String component4() {
        return this.state;
    }

    @NotNull
    public final String component5() {
        return this.zip;
    }

    @NotNull
    public final Country component6() {
        return this.country;
    }

    @NotNull
    public final AddressValidationRequest copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull Country country2) {
        Intrinsics.checkNotNullParameter(str, "addressLine1");
        Intrinsics.checkNotNullParameter(str2, "addressLine2");
        Intrinsics.checkNotNullParameter(str3, Address.KEY_CITY);
        Intrinsics.checkNotNullParameter(str4, "state");
        Intrinsics.checkNotNullParameter(str5, ArchiveStreamFactory.ZIP);
        Intrinsics.checkNotNullParameter(country2, "country");
        return new AddressValidationRequest(str, str2, str3, str4, str5, country2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AddressValidationRequest)) {
            return false;
        }
        AddressValidationRequest addressValidationRequest = (AddressValidationRequest) obj;
        return Intrinsics.areEqual((Object) this.addressLine1, (Object) addressValidationRequest.addressLine1) && Intrinsics.areEqual((Object) this.addressLine2, (Object) addressValidationRequest.addressLine2) && Intrinsics.areEqual((Object) this.city, (Object) addressValidationRequest.city) && Intrinsics.areEqual((Object) this.state, (Object) addressValidationRequest.state) && Intrinsics.areEqual((Object) this.zip, (Object) addressValidationRequest.zip) && this.country == addressValidationRequest.country;
    }

    @NotNull
    public final String getAddressLine1() {
        return this.addressLine1;
    }

    @NotNull
    public final String getAddressLine2() {
        return this.addressLine2;
    }

    @NotNull
    public final String getCity() {
        return this.city;
    }

    @NotNull
    public final Country getCountry() {
        return this.country;
    }

    @NotNull
    public final String getState() {
        return this.state;
    }

    @NotNull
    public final String getZip() {
        return this.zip;
    }

    public int hashCode() {
        return (((((((((this.addressLine1.hashCode() * 31) + this.addressLine2.hashCode()) * 31) + this.city.hashCode()) * 31) + this.state.hashCode()) * 31) + this.zip.hashCode()) * 31) + this.country.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.addressLine1;
        String str2 = this.addressLine2;
        String str3 = this.city;
        String str4 = this.state;
        String str5 = this.zip;
        Country country2 = this.country;
        return "AddressValidationRequest(addressLine1=" + str + ", addressLine2=" + str2 + ", city=" + str3 + ", state=" + str4 + ", zip=" + str5 + ", country=" + country2 + ")";
    }
}
