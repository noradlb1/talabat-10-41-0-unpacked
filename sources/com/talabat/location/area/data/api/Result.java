package com.talabat.location.area.data.api;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJJ\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000f\u0010\u000bR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u001a\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u001f"}, d2 = {"Lcom/talabat/location/area/data/api/Result;", "", "areaId", "", "areaName", "", "cityId", "cityName", "countryId", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;)V", "getAreaId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getAreaName", "()Ljava/lang/String;", "getCityId", "getCityName", "getCountryId", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;)Lcom/talabat/location/area/data/api/Result;", "equals", "", "other", "hashCode", "", "toString", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Result {
    @SerializedName("area_id")
    @Nullable
    private final Long areaId;
    @SerializedName("area_name")
    @Nullable
    private final String areaName;
    @SerializedName("city_id")
    @Nullable
    private final Long cityId;
    @SerializedName("city_name")
    @Nullable
    private final String cityName;
    @SerializedName("country_id")
    @Nullable
    private final Long countryId;

    public Result(@Nullable Long l11, @Nullable String str, @Nullable Long l12, @Nullable String str2, @Nullable Long l13) {
        this.areaId = l11;
        this.areaName = str;
        this.cityId = l12;
        this.cityName = str2;
        this.countryId = l13;
    }

    public static /* synthetic */ Result copy$default(Result result, Long l11, String str, Long l12, String str2, Long l13, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            l11 = result.areaId;
        }
        if ((i11 & 2) != 0) {
            str = result.areaName;
        }
        String str3 = str;
        if ((i11 & 4) != 0) {
            l12 = result.cityId;
        }
        Long l14 = l12;
        if ((i11 & 8) != 0) {
            str2 = result.cityName;
        }
        String str4 = str2;
        if ((i11 & 16) != 0) {
            l13 = result.countryId;
        }
        return result.copy(l11, str3, l14, str4, l13);
    }

    @Nullable
    public final Long component1() {
        return this.areaId;
    }

    @Nullable
    public final String component2() {
        return this.areaName;
    }

    @Nullable
    public final Long component3() {
        return this.cityId;
    }

    @Nullable
    public final String component4() {
        return this.cityName;
    }

    @Nullable
    public final Long component5() {
        return this.countryId;
    }

    @NotNull
    public final Result copy(@Nullable Long l11, @Nullable String str, @Nullable Long l12, @Nullable String str2, @Nullable Long l13) {
        return new Result(l11, str, l12, str2, l13);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Result)) {
            return false;
        }
        Result result = (Result) obj;
        return Intrinsics.areEqual((Object) this.areaId, (Object) result.areaId) && Intrinsics.areEqual((Object) this.areaName, (Object) result.areaName) && Intrinsics.areEqual((Object) this.cityId, (Object) result.cityId) && Intrinsics.areEqual((Object) this.cityName, (Object) result.cityName) && Intrinsics.areEqual((Object) this.countryId, (Object) result.countryId);
    }

    @Nullable
    public final Long getAreaId() {
        return this.areaId;
    }

    @Nullable
    public final String getAreaName() {
        return this.areaName;
    }

    @Nullable
    public final Long getCityId() {
        return this.cityId;
    }

    @Nullable
    public final String getCityName() {
        return this.cityName;
    }

    @Nullable
    public final Long getCountryId() {
        return this.countryId;
    }

    public int hashCode() {
        Long l11 = this.areaId;
        int i11 = 0;
        int hashCode = (l11 == null ? 0 : l11.hashCode()) * 31;
        String str = this.areaName;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Long l12 = this.cityId;
        int hashCode3 = (hashCode2 + (l12 == null ? 0 : l12.hashCode())) * 31;
        String str2 = this.cityName;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l13 = this.countryId;
        if (l13 != null) {
            i11 = l13.hashCode();
        }
        return hashCode4 + i11;
    }

    @NotNull
    public String toString() {
        Long l11 = this.areaId;
        String str = this.areaName;
        Long l12 = this.cityId;
        String str2 = this.cityName;
        Long l13 = this.countryId;
        return "Result(areaId=" + l11 + ", areaName=" + str + ", cityId=" + l12 + ", cityName=" + str2 + ", countryId=" + l13 + ")";
    }
}
