package com.checkout.tokenization.model;

import com.checkout.base.model.Country;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\tHÆ\u0003JE\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000eR\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000e¨\u0006("}, d2 = {"Lcom/checkout/tokenization/model/Address;", "", "addressLine1", "", "addressLine2", "city", "state", "zip", "country", "Lcom/checkout/base/model/Country;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/checkout/base/model/Country;)V", "getAddressLine1", "()Ljava/lang/String;", "setAddressLine1", "(Ljava/lang/String;)V", "getAddressLine2", "setAddressLine2", "getCity", "setCity", "getCountry", "()Lcom/checkout/base/model/Country;", "setCountry", "(Lcom/checkout/base/model/Country;)V", "getState", "setState", "getZip", "setZip", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Address {
    @NotNull
    private String addressLine1;
    @NotNull
    private String addressLine2;
    @NotNull
    private String city;
    @NotNull
    private Country country;
    @NotNull
    private String state;
    @NotNull
    private String zip;

    public Address(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull Country country2) {
        Intrinsics.checkNotNullParameter(str, "addressLine1");
        Intrinsics.checkNotNullParameter(str2, "addressLine2");
        Intrinsics.checkNotNullParameter(str3, com.adyen.checkout.core.model.Address.KEY_CITY);
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

    public static /* synthetic */ Address copy$default(Address address, String str, String str2, String str3, String str4, String str5, Country country2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = address.addressLine1;
        }
        if ((i11 & 2) != 0) {
            str2 = address.addressLine2;
        }
        String str6 = str2;
        if ((i11 & 4) != 0) {
            str3 = address.city;
        }
        String str7 = str3;
        if ((i11 & 8) != 0) {
            str4 = address.state;
        }
        String str8 = str4;
        if ((i11 & 16) != 0) {
            str5 = address.zip;
        }
        String str9 = str5;
        if ((i11 & 32) != 0) {
            country2 = address.country;
        }
        return address.copy(str, str6, str7, str8, str9, country2);
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
    public final Address copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull Country country2) {
        Intrinsics.checkNotNullParameter(str, "addressLine1");
        Intrinsics.checkNotNullParameter(str2, "addressLine2");
        Intrinsics.checkNotNullParameter(str3, com.adyen.checkout.core.model.Address.KEY_CITY);
        Intrinsics.checkNotNullParameter(str4, "state");
        Intrinsics.checkNotNullParameter(str5, ArchiveStreamFactory.ZIP);
        Intrinsics.checkNotNullParameter(country2, "country");
        return new Address(str, str2, str3, str4, str5, country2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Address)) {
            return false;
        }
        Address address = (Address) obj;
        return Intrinsics.areEqual((Object) this.addressLine1, (Object) address.addressLine1) && Intrinsics.areEqual((Object) this.addressLine2, (Object) address.addressLine2) && Intrinsics.areEqual((Object) this.city, (Object) address.city) && Intrinsics.areEqual((Object) this.state, (Object) address.state) && Intrinsics.areEqual((Object) this.zip, (Object) address.zip) && this.country == address.country;
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

    public final void setAddressLine1(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.addressLine1 = str;
    }

    public final void setAddressLine2(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.addressLine2 = str;
    }

    public final void setCity(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.city = str;
    }

    public final void setCountry(@NotNull Country country2) {
        Intrinsics.checkNotNullParameter(country2, "<set-?>");
        this.country = country2;
    }

    public final void setState(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.state = str;
    }

    public final void setZip(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.zip = str;
    }

    @NotNull
    public String toString() {
        String str = this.addressLine1;
        String str2 = this.addressLine2;
        String str3 = this.city;
        String str4 = this.state;
        String str5 = this.zip;
        Country country2 = this.country;
        return "Address(addressLine1=" + str + ", addressLine2=" + str2 + ", city=" + str3 + ", state=" + str4 + ", zip=" + str5 + ", country=" + country2 + ")";
    }
}
