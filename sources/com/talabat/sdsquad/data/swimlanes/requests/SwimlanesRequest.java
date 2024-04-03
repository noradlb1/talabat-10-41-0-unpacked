package com.talabat.sdsquad.data.swimlanes.requests;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\b\u001a\u00020\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u000eR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/talabat/sdsquad/data/swimlanes/requests/SwimlanesRequest;", "", "areaId", "", "countryId", "latitude", "", "longitude", "isMultipleSwimlanes", "", "(IILjava/lang/String;Ljava/lang/String;Z)V", "getAreaId", "()I", "getCountryId", "()Z", "getLatitude", "()Ljava/lang/String;", "getLongitude", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SwimlanesRequest {
    @SerializedName("areaId")
    private final int areaId;
    @SerializedName("countryId")
    private final int countryId;
    @SerializedName("isMultipleSL")
    private final boolean isMultipleSwimlanes;
    @SerializedName("latitude")
    @NotNull
    private final String latitude;
    @SerializedName("longitude")
    @NotNull
    private final String longitude;

    public SwimlanesRequest(int i11, int i12, @NotNull String str, @NotNull String str2, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "latitude");
        Intrinsics.checkNotNullParameter(str2, "longitude");
        this.areaId = i11;
        this.countryId = i12;
        this.latitude = str;
        this.longitude = str2;
        this.isMultipleSwimlanes = z11;
    }

    public static /* synthetic */ SwimlanesRequest copy$default(SwimlanesRequest swimlanesRequest, int i11, int i12, String str, String str2, boolean z11, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i11 = swimlanesRequest.areaId;
        }
        if ((i13 & 2) != 0) {
            i12 = swimlanesRequest.countryId;
        }
        int i14 = i12;
        if ((i13 & 4) != 0) {
            str = swimlanesRequest.latitude;
        }
        String str3 = str;
        if ((i13 & 8) != 0) {
            str2 = swimlanesRequest.longitude;
        }
        String str4 = str2;
        if ((i13 & 16) != 0) {
            z11 = swimlanesRequest.isMultipleSwimlanes;
        }
        return swimlanesRequest.copy(i11, i14, str3, str4, z11);
    }

    public final int component1() {
        return this.areaId;
    }

    public final int component2() {
        return this.countryId;
    }

    @NotNull
    public final String component3() {
        return this.latitude;
    }

    @NotNull
    public final String component4() {
        return this.longitude;
    }

    public final boolean component5() {
        return this.isMultipleSwimlanes;
    }

    @NotNull
    public final SwimlanesRequest copy(int i11, int i12, @NotNull String str, @NotNull String str2, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "latitude");
        Intrinsics.checkNotNullParameter(str2, "longitude");
        return new SwimlanesRequest(i11, i12, str, str2, z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SwimlanesRequest)) {
            return false;
        }
        SwimlanesRequest swimlanesRequest = (SwimlanesRequest) obj;
        return this.areaId == swimlanesRequest.areaId && this.countryId == swimlanesRequest.countryId && Intrinsics.areEqual((Object) this.latitude, (Object) swimlanesRequest.latitude) && Intrinsics.areEqual((Object) this.longitude, (Object) swimlanesRequest.longitude) && this.isMultipleSwimlanes == swimlanesRequest.isMultipleSwimlanes;
    }

    public final int getAreaId() {
        return this.areaId;
    }

    public final int getCountryId() {
        return this.countryId;
    }

    @NotNull
    public final String getLatitude() {
        return this.latitude;
    }

    @NotNull
    public final String getLongitude() {
        return this.longitude;
    }

    public int hashCode() {
        int hashCode = ((((((this.areaId * 31) + this.countryId) * 31) + this.latitude.hashCode()) * 31) + this.longitude.hashCode()) * 31;
        boolean z11 = this.isMultipleSwimlanes;
        if (z11) {
            z11 = true;
        }
        return hashCode + (z11 ? 1 : 0);
    }

    public final boolean isMultipleSwimlanes() {
        return this.isMultipleSwimlanes;
    }

    @NotNull
    public String toString() {
        int i11 = this.areaId;
        int i12 = this.countryId;
        String str = this.latitude;
        String str2 = this.longitude;
        boolean z11 = this.isMultipleSwimlanes;
        return "SwimlanesRequest(areaId=" + i11 + ", countryId=" + i12 + ", latitude=" + str + ", longitude=" + str2 + ", isMultipleSwimlanes=" + z11 + ")";
    }
}
