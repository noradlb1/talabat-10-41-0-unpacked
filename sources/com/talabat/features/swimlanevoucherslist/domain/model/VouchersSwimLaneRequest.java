package com.talabat.features.swimlanevoucherslist.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/talabat/features/swimlanevoucherslist/domain/model/VouchersSwimLaneRequest;", "", "vendorId", "", "countryId", "areaId", "", "brandId", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getAreaId", "()I", "getBrandId", "()Ljava/lang/String;", "getCountryId", "getVendorId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "com_talabat_feature_customer-vouchers-swimlane_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VouchersSwimLaneRequest {
    private final int areaId;
    @NotNull
    private final String brandId;
    @NotNull
    private final String countryId;
    @NotNull
    private final String vendorId;

    public VouchersSwimLaneRequest(@NotNull String str, @NotNull String str2, int i11, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "vendorId");
        Intrinsics.checkNotNullParameter(str2, "countryId");
        Intrinsics.checkNotNullParameter(str3, "brandId");
        this.vendorId = str;
        this.countryId = str2;
        this.areaId = i11;
        this.brandId = str3;
    }

    public static /* synthetic */ VouchersSwimLaneRequest copy$default(VouchersSwimLaneRequest vouchersSwimLaneRequest, String str, String str2, int i11, String str3, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = vouchersSwimLaneRequest.vendorId;
        }
        if ((i12 & 2) != 0) {
            str2 = vouchersSwimLaneRequest.countryId;
        }
        if ((i12 & 4) != 0) {
            i11 = vouchersSwimLaneRequest.areaId;
        }
        if ((i12 & 8) != 0) {
            str3 = vouchersSwimLaneRequest.brandId;
        }
        return vouchersSwimLaneRequest.copy(str, str2, i11, str3);
    }

    @NotNull
    public final String component1() {
        return this.vendorId;
    }

    @NotNull
    public final String component2() {
        return this.countryId;
    }

    public final int component3() {
        return this.areaId;
    }

    @NotNull
    public final String component4() {
        return this.brandId;
    }

    @NotNull
    public final VouchersSwimLaneRequest copy(@NotNull String str, @NotNull String str2, int i11, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "vendorId");
        Intrinsics.checkNotNullParameter(str2, "countryId");
        Intrinsics.checkNotNullParameter(str3, "brandId");
        return new VouchersSwimLaneRequest(str, str2, i11, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VouchersSwimLaneRequest)) {
            return false;
        }
        VouchersSwimLaneRequest vouchersSwimLaneRequest = (VouchersSwimLaneRequest) obj;
        return Intrinsics.areEqual((Object) this.vendorId, (Object) vouchersSwimLaneRequest.vendorId) && Intrinsics.areEqual((Object) this.countryId, (Object) vouchersSwimLaneRequest.countryId) && this.areaId == vouchersSwimLaneRequest.areaId && Intrinsics.areEqual((Object) this.brandId, (Object) vouchersSwimLaneRequest.brandId);
    }

    public final int getAreaId() {
        return this.areaId;
    }

    @NotNull
    public final String getBrandId() {
        return this.brandId;
    }

    @NotNull
    public final String getCountryId() {
        return this.countryId;
    }

    @NotNull
    public final String getVendorId() {
        return this.vendorId;
    }

    public int hashCode() {
        return (((((this.vendorId.hashCode() * 31) + this.countryId.hashCode()) * 31) + this.areaId) * 31) + this.brandId.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.vendorId;
        String str2 = this.countryId;
        int i11 = this.areaId;
        String str3 = this.brandId;
        return "VouchersSwimLaneRequest(vendorId=" + str + ", countryId=" + str2 + ", areaId=" + i11 + ", brandId=" + str3 + ")";
    }
}
