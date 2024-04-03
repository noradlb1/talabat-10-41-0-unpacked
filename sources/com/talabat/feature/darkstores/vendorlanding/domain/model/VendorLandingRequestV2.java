package com.talabat.feature.darkstores.vendorlanding.domain.model;

import com.talabat.observabilityNew.squads.nfv.ObservableAttributesNames;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/talabat/feature/darkstores/vendorlanding/domain/model/VendorLandingRequestV2;", "", "countryCode", "", "vendorCode", "isDarkstore", "", "latitude", "longitude", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "getCountryCode", "()Ljava/lang/String;", "()Z", "getLatitude", "getLongitude", "getVendorCode", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "com_talabat_feature_darkstores-vendor-landing_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorLandingRequestV2 {
    @NotNull
    private final String countryCode;
    private final boolean isDarkstore;
    @NotNull
    private final String latitude;
    @NotNull
    private final String longitude;
    @NotNull
    private final String vendorCode;

    public VendorLandingRequestV2(@NotNull String str, @NotNull String str2, boolean z11, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "countryCode");
        Intrinsics.checkNotNullParameter(str2, ObservableAttributesNames.VENDOR_CODE);
        Intrinsics.checkNotNullParameter(str3, "latitude");
        Intrinsics.checkNotNullParameter(str4, "longitude");
        this.countryCode = str;
        this.vendorCode = str2;
        this.isDarkstore = z11;
        this.latitude = str3;
        this.longitude = str4;
    }

    public static /* synthetic */ VendorLandingRequestV2 copy$default(VendorLandingRequestV2 vendorLandingRequestV2, String str, String str2, boolean z11, String str3, String str4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = vendorLandingRequestV2.countryCode;
        }
        if ((i11 & 2) != 0) {
            str2 = vendorLandingRequestV2.vendorCode;
        }
        String str5 = str2;
        if ((i11 & 4) != 0) {
            z11 = vendorLandingRequestV2.isDarkstore;
        }
        boolean z12 = z11;
        if ((i11 & 8) != 0) {
            str3 = vendorLandingRequestV2.latitude;
        }
        String str6 = str3;
        if ((i11 & 16) != 0) {
            str4 = vendorLandingRequestV2.longitude;
        }
        return vendorLandingRequestV2.copy(str, str5, z12, str6, str4);
    }

    @NotNull
    public final String component1() {
        return this.countryCode;
    }

    @NotNull
    public final String component2() {
        return this.vendorCode;
    }

    public final boolean component3() {
        return this.isDarkstore;
    }

    @NotNull
    public final String component4() {
        return this.latitude;
    }

    @NotNull
    public final String component5() {
        return this.longitude;
    }

    @NotNull
    public final VendorLandingRequestV2 copy(@NotNull String str, @NotNull String str2, boolean z11, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "countryCode");
        Intrinsics.checkNotNullParameter(str2, ObservableAttributesNames.VENDOR_CODE);
        Intrinsics.checkNotNullParameter(str3, "latitude");
        Intrinsics.checkNotNullParameter(str4, "longitude");
        return new VendorLandingRequestV2(str, str2, z11, str3, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VendorLandingRequestV2)) {
            return false;
        }
        VendorLandingRequestV2 vendorLandingRequestV2 = (VendorLandingRequestV2) obj;
        return Intrinsics.areEqual((Object) this.countryCode, (Object) vendorLandingRequestV2.countryCode) && Intrinsics.areEqual((Object) this.vendorCode, (Object) vendorLandingRequestV2.vendorCode) && this.isDarkstore == vendorLandingRequestV2.isDarkstore && Intrinsics.areEqual((Object) this.latitude, (Object) vendorLandingRequestV2.latitude) && Intrinsics.areEqual((Object) this.longitude, (Object) vendorLandingRequestV2.longitude);
    }

    @NotNull
    public final String getCountryCode() {
        return this.countryCode;
    }

    @NotNull
    public final String getLatitude() {
        return this.latitude;
    }

    @NotNull
    public final String getLongitude() {
        return this.longitude;
    }

    @NotNull
    public final String getVendorCode() {
        return this.vendorCode;
    }

    public int hashCode() {
        int hashCode = ((this.countryCode.hashCode() * 31) + this.vendorCode.hashCode()) * 31;
        boolean z11 = this.isDarkstore;
        if (z11) {
            z11 = true;
        }
        return ((((hashCode + (z11 ? 1 : 0)) * 31) + this.latitude.hashCode()) * 31) + this.longitude.hashCode();
    }

    public final boolean isDarkstore() {
        return this.isDarkstore;
    }

    @NotNull
    public String toString() {
        String str = this.countryCode;
        String str2 = this.vendorCode;
        boolean z11 = this.isDarkstore;
        String str3 = this.latitude;
        String str4 = this.longitude;
        return "VendorLandingRequestV2(countryCode=" + str + ", vendorCode=" + str2 + ", isDarkstore=" + z11 + ", latitude=" + str3 + ", longitude=" + str4 + ")";
    }
}
