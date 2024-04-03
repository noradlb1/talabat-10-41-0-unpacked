package com.talabat.restaurants.v2.data.vendors;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/talabat/restaurants/v2/data/vendors/AreaParams;", "", "lat", "", "lon", "areaId", "", "countryId", "(Ljava/lang/String;Ljava/lang/String;II)V", "getAreaId", "()I", "getCountryId", "getLat", "()Ljava/lang/String;", "getLon", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AreaParams {
    private final int areaId;
    private final int countryId;
    @NotNull
    private final String lat;
    @NotNull
    private final String lon;

    public AreaParams(@NotNull String str, @NotNull String str2, int i11, int i12) {
        Intrinsics.checkNotNullParameter(str, "lat");
        Intrinsics.checkNotNullParameter(str2, "lon");
        this.lat = str;
        this.lon = str2;
        this.areaId = i11;
        this.countryId = i12;
    }

    public static /* synthetic */ AreaParams copy$default(AreaParams areaParams, String str, String str2, int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            str = areaParams.lat;
        }
        if ((i13 & 2) != 0) {
            str2 = areaParams.lon;
        }
        if ((i13 & 4) != 0) {
            i11 = areaParams.areaId;
        }
        if ((i13 & 8) != 0) {
            i12 = areaParams.countryId;
        }
        return areaParams.copy(str, str2, i11, i12);
    }

    @NotNull
    public final String component1() {
        return this.lat;
    }

    @NotNull
    public final String component2() {
        return this.lon;
    }

    public final int component3() {
        return this.areaId;
    }

    public final int component4() {
        return this.countryId;
    }

    @NotNull
    public final AreaParams copy(@NotNull String str, @NotNull String str2, int i11, int i12) {
        Intrinsics.checkNotNullParameter(str, "lat");
        Intrinsics.checkNotNullParameter(str2, "lon");
        return new AreaParams(str, str2, i11, i12);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AreaParams)) {
            return false;
        }
        AreaParams areaParams = (AreaParams) obj;
        return Intrinsics.areEqual((Object) this.lat, (Object) areaParams.lat) && Intrinsics.areEqual((Object) this.lon, (Object) areaParams.lon) && this.areaId == areaParams.areaId && this.countryId == areaParams.countryId;
    }

    public final int getAreaId() {
        return this.areaId;
    }

    public final int getCountryId() {
        return this.countryId;
    }

    @NotNull
    public final String getLat() {
        return this.lat;
    }

    @NotNull
    public final String getLon() {
        return this.lon;
    }

    public int hashCode() {
        return (((((this.lat.hashCode() * 31) + this.lon.hashCode()) * 31) + this.areaId) * 31) + this.countryId;
    }

    @NotNull
    public String toString() {
        String str = this.lat;
        String str2 = this.lon;
        int i11 = this.areaId;
        int i12 = this.countryId;
        return "AreaParams(lat=" + str + ", lon=" + str2 + ", areaId=" + i11 + ", countryId=" + i12 + ")";
    }
}
