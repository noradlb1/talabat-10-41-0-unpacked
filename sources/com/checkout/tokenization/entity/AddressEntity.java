package com.checkout.tokenization.entity;

import com.adyen.checkout.core.model.Address;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BC\b\u0000\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0001\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003JE\u0010\u0017\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u00032\b\b\u0003\u0010\u0007\u001a\u00020\u00032\b\b\u0003\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/checkout/tokenization/entity/AddressEntity;", "", "addressLine1", "", "addressLine2", "city", "state", "zip", "country", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAddressLine1", "()Ljava/lang/String;", "getAddressLine2", "getCity", "getCountry", "getState", "getZip", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AddressEntity {
    @NotNull
    private final String addressLine1;
    @NotNull
    private final String addressLine2;
    @NotNull
    private final String city;
    @NotNull
    private final String country;
    @NotNull
    private final String state;
    @NotNull
    private final String zip;

    public AddressEntity(@NotNull @Json(name = "address_line1") String str, @NotNull @Json(name = "address_line2") String str2, @NotNull @Json(name = "city") String str3, @NotNull @Json(name = "state") String str4, @NotNull @Json(name = "zip") String str5, @NotNull @Json(name = "country") String str6) {
        Intrinsics.checkNotNullParameter(str, "addressLine1");
        Intrinsics.checkNotNullParameter(str2, "addressLine2");
        Intrinsics.checkNotNullParameter(str3, Address.KEY_CITY);
        Intrinsics.checkNotNullParameter(str4, "state");
        Intrinsics.checkNotNullParameter(str5, ArchiveStreamFactory.ZIP);
        Intrinsics.checkNotNullParameter(str6, "country");
        this.addressLine1 = str;
        this.addressLine2 = str2;
        this.city = str3;
        this.state = str4;
        this.zip = str5;
        this.country = str6;
    }

    public static /* synthetic */ AddressEntity copy$default(AddressEntity addressEntity, String str, String str2, String str3, String str4, String str5, String str6, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = addressEntity.addressLine1;
        }
        if ((i11 & 2) != 0) {
            str2 = addressEntity.addressLine2;
        }
        String str7 = str2;
        if ((i11 & 4) != 0) {
            str3 = addressEntity.city;
        }
        String str8 = str3;
        if ((i11 & 8) != 0) {
            str4 = addressEntity.state;
        }
        String str9 = str4;
        if ((i11 & 16) != 0) {
            str5 = addressEntity.zip;
        }
        String str10 = str5;
        if ((i11 & 32) != 0) {
            str6 = addressEntity.country;
        }
        return addressEntity.copy(str, str7, str8, str9, str10, str6);
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
    public final String component6() {
        return this.country;
    }

    @NotNull
    public final AddressEntity copy(@NotNull @Json(name = "address_line1") String str, @NotNull @Json(name = "address_line2") String str2, @NotNull @Json(name = "city") String str3, @NotNull @Json(name = "state") String str4, @NotNull @Json(name = "zip") String str5, @NotNull @Json(name = "country") String str6) {
        Intrinsics.checkNotNullParameter(str, "addressLine1");
        Intrinsics.checkNotNullParameter(str2, "addressLine2");
        Intrinsics.checkNotNullParameter(str3, Address.KEY_CITY);
        Intrinsics.checkNotNullParameter(str4, "state");
        Intrinsics.checkNotNullParameter(str5, ArchiveStreamFactory.ZIP);
        Intrinsics.checkNotNullParameter(str6, "country");
        return new AddressEntity(str, str2, str3, str4, str5, str6);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AddressEntity)) {
            return false;
        }
        AddressEntity addressEntity = (AddressEntity) obj;
        return Intrinsics.areEqual((Object) this.addressLine1, (Object) addressEntity.addressLine1) && Intrinsics.areEqual((Object) this.addressLine2, (Object) addressEntity.addressLine2) && Intrinsics.areEqual((Object) this.city, (Object) addressEntity.city) && Intrinsics.areEqual((Object) this.state, (Object) addressEntity.state) && Intrinsics.areEqual((Object) this.zip, (Object) addressEntity.zip) && Intrinsics.areEqual((Object) this.country, (Object) addressEntity.country);
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
    public final String getCountry() {
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
        String str6 = this.country;
        return "AddressEntity(addressLine1=" + str + ", addressLine2=" + str2 + ", city=" + str3 + ", state=" + str4 + ", zip=" + str5 + ", country=" + str6 + ")";
    }
}
