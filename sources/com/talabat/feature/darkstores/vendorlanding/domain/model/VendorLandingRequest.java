package com.talabat.feature.darkstores.vendorlanding.domain.model;

import com.talabat.observabilityNew.squads.nfv.ObservableAttributesNames;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/talabat/feature/darkstores/vendorlanding/domain/model/VendorLandingRequest;", "", "countryCode", "", "vendorCode", "talabatBranchId", "isDarkstore", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getCountryCode", "()Ljava/lang/String;", "()Z", "getTalabatBranchId", "getVendorCode", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "com_talabat_feature_darkstores-vendor-landing_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorLandingRequest {
    @NotNull
    private final String countryCode;
    private final boolean isDarkstore;
    @NotNull
    private final String talabatBranchId;
    @NotNull
    private final String vendorCode;

    public VendorLandingRequest(@NotNull String str, @NotNull String str2, @NotNull String str3, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "countryCode");
        Intrinsics.checkNotNullParameter(str2, ObservableAttributesNames.VENDOR_CODE);
        Intrinsics.checkNotNullParameter(str3, "talabatBranchId");
        this.countryCode = str;
        this.vendorCode = str2;
        this.talabatBranchId = str3;
        this.isDarkstore = z11;
    }

    public static /* synthetic */ VendorLandingRequest copy$default(VendorLandingRequest vendorLandingRequest, String str, String str2, String str3, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = vendorLandingRequest.countryCode;
        }
        if ((i11 & 2) != 0) {
            str2 = vendorLandingRequest.vendorCode;
        }
        if ((i11 & 4) != 0) {
            str3 = vendorLandingRequest.talabatBranchId;
        }
        if ((i11 & 8) != 0) {
            z11 = vendorLandingRequest.isDarkstore;
        }
        return vendorLandingRequest.copy(str, str2, str3, z11);
    }

    @NotNull
    public final String component1() {
        return this.countryCode;
    }

    @NotNull
    public final String component2() {
        return this.vendorCode;
    }

    @NotNull
    public final String component3() {
        return this.talabatBranchId;
    }

    public final boolean component4() {
        return this.isDarkstore;
    }

    @NotNull
    public final VendorLandingRequest copy(@NotNull String str, @NotNull String str2, @NotNull String str3, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "countryCode");
        Intrinsics.checkNotNullParameter(str2, ObservableAttributesNames.VENDOR_CODE);
        Intrinsics.checkNotNullParameter(str3, "talabatBranchId");
        return new VendorLandingRequest(str, str2, str3, z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VendorLandingRequest)) {
            return false;
        }
        VendorLandingRequest vendorLandingRequest = (VendorLandingRequest) obj;
        return Intrinsics.areEqual((Object) this.countryCode, (Object) vendorLandingRequest.countryCode) && Intrinsics.areEqual((Object) this.vendorCode, (Object) vendorLandingRequest.vendorCode) && Intrinsics.areEqual((Object) this.talabatBranchId, (Object) vendorLandingRequest.talabatBranchId) && this.isDarkstore == vendorLandingRequest.isDarkstore;
    }

    @NotNull
    public final String getCountryCode() {
        return this.countryCode;
    }

    @NotNull
    public final String getTalabatBranchId() {
        return this.talabatBranchId;
    }

    @NotNull
    public final String getVendorCode() {
        return this.vendorCode;
    }

    public int hashCode() {
        int hashCode = ((((this.countryCode.hashCode() * 31) + this.vendorCode.hashCode()) * 31) + this.talabatBranchId.hashCode()) * 31;
        boolean z11 = this.isDarkstore;
        if (z11) {
            z11 = true;
        }
        return hashCode + (z11 ? 1 : 0);
    }

    public final boolean isDarkstore() {
        return this.isDarkstore;
    }

    @NotNull
    public String toString() {
        String str = this.countryCode;
        String str2 = this.vendorCode;
        String str3 = this.talabatBranchId;
        boolean z11 = this.isDarkstore;
        return "VendorLandingRequest(countryCode=" + str + ", vendorCode=" + str2 + ", talabatBranchId=" + str3 + ", isDarkstore=" + z11 + ")";
    }
}
