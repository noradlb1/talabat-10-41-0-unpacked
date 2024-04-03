package com.talabat.location.area.domain.repository;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001d"}, d2 = {"Lcom/talabat/location/area/domain/repository/Area;", "", "id", "", "name", "", "cityId", "cityName", "countryId", "(JLjava/lang/String;JLjava/lang/String;J)V", "getCityId", "()J", "getCityName", "()Ljava/lang/String;", "getCountryId", "getId", "getName", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Area {
    private final long cityId;
    @NotNull
    private final String cityName;
    private final long countryId;

    /* renamed from: id  reason: collision with root package name */
    private final long f61027id;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f61028name;

    public Area(long j11, @NotNull String str, long j12, @NotNull String str2, long j13) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "cityName");
        this.f61027id = j11;
        this.f61028name = str;
        this.cityId = j12;
        this.cityName = str2;
        this.countryId = j13;
    }

    public static /* synthetic */ Area copy$default(Area area, long j11, String str, long j12, String str2, long j13, int i11, Object obj) {
        Area area2 = area;
        return area.copy((i11 & 1) != 0 ? area2.f61027id : j11, (i11 & 2) != 0 ? area2.f61028name : str, (i11 & 4) != 0 ? area2.cityId : j12, (i11 & 8) != 0 ? area2.cityName : str2, (i11 & 16) != 0 ? area2.countryId : j13);
    }

    public final long component1() {
        return this.f61027id;
    }

    @NotNull
    public final String component2() {
        return this.f61028name;
    }

    public final long component3() {
        return this.cityId;
    }

    @NotNull
    public final String component4() {
        return this.cityName;
    }

    public final long component5() {
        return this.countryId;
    }

    @NotNull
    public final Area copy(long j11, @NotNull String str, long j12, @NotNull String str2, long j13) {
        Intrinsics.checkNotNullParameter(str, "name");
        String str3 = str2;
        Intrinsics.checkNotNullParameter(str3, "cityName");
        return new Area(j11, str, j12, str3, j13);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Area)) {
            return false;
        }
        Area area = (Area) obj;
        return this.f61027id == area.f61027id && Intrinsics.areEqual((Object) this.f61028name, (Object) area.f61028name) && this.cityId == area.cityId && Intrinsics.areEqual((Object) this.cityName, (Object) area.cityName) && this.countryId == area.countryId;
    }

    public final long getCityId() {
        return this.cityId;
    }

    @NotNull
    public final String getCityName() {
        return this.cityName;
    }

    public final long getCountryId() {
        return this.countryId;
    }

    public final long getId() {
        return this.f61027id;
    }

    @NotNull
    public final String getName() {
        return this.f61028name;
    }

    public int hashCode() {
        return (((((((a.a(this.f61027id) * 31) + this.f61028name.hashCode()) * 31) + a.a(this.cityId)) * 31) + this.cityName.hashCode()) * 31) + a.a(this.countryId);
    }

    @NotNull
    public String toString() {
        long j11 = this.f61027id;
        String str = this.f61028name;
        long j12 = this.cityId;
        String str2 = this.cityName;
        long j13 = this.countryId;
        return "Area(id=" + j11 + ", name=" + str + ", cityId=" + j12 + ", cityName=" + str2 + ", countryId=" + j13 + ")";
    }
}
