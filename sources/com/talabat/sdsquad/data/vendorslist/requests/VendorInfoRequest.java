package com.talabat.sdsquad.data.vendorslist.requests;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/talabat/sdsquad/data/vendorslist/requests/VendorInfoRequest;", "", "areaId", "", "cityId", "countryId", "(III)V", "getAreaId", "()I", "getCityId", "getCountryId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorInfoRequest {
    @SerializedName("areaId")
    private final int areaId;
    @SerializedName("cityId")
    private final int cityId;
    @SerializedName("countryId")
    private final int countryId;

    public VendorInfoRequest(int i11, int i12, int i13) {
        this.areaId = i11;
        this.cityId = i12;
        this.countryId = i13;
    }

    public static /* synthetic */ VendorInfoRequest copy$default(VendorInfoRequest vendorInfoRequest, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            i11 = vendorInfoRequest.areaId;
        }
        if ((i14 & 2) != 0) {
            i12 = vendorInfoRequest.cityId;
        }
        if ((i14 & 4) != 0) {
            i13 = vendorInfoRequest.countryId;
        }
        return vendorInfoRequest.copy(i11, i12, i13);
    }

    public final int component1() {
        return this.areaId;
    }

    public final int component2() {
        return this.cityId;
    }

    public final int component3() {
        return this.countryId;
    }

    @NotNull
    public final VendorInfoRequest copy(int i11, int i12, int i13) {
        return new VendorInfoRequest(i11, i12, i13);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VendorInfoRequest)) {
            return false;
        }
        VendorInfoRequest vendorInfoRequest = (VendorInfoRequest) obj;
        return this.areaId == vendorInfoRequest.areaId && this.cityId == vendorInfoRequest.cityId && this.countryId == vendorInfoRequest.countryId;
    }

    public final int getAreaId() {
        return this.areaId;
    }

    public final int getCityId() {
        return this.cityId;
    }

    public final int getCountryId() {
        return this.countryId;
    }

    public int hashCode() {
        return (((this.areaId * 31) + this.cityId) * 31) + this.countryId;
    }

    @NotNull
    public String toString() {
        int i11 = this.areaId;
        int i12 = this.cityId;
        int i13 = this.countryId;
        return "VendorInfoRequest(areaId=" + i11 + ", cityId=" + i12 + ", countryId=" + i13 + ")";
    }
}
