package com.talabat.darkstores.data.discovery.model;

import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J-\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/talabat/darkstores/data/discovery/model/Location;", "", "point", "Lcom/talabat/darkstores/data/discovery/model/Point;", "areaId", "", "timezone", "(Lcom/talabat/darkstores/data/discovery/model/Point;Ljava/lang/String;Ljava/lang/String;)V", "getAreaId", "()Ljava/lang/String;", "getPoint", "()Lcom/talabat/darkstores/data/discovery/model/Point;", "getTimezone", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Location {
    @Nullable
    private final String areaId;
    @Nullable
    private final Point point;
    @Nullable
    private final String timezone;

    public Location() {
        this((Point) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public Location(@Nullable Point point2, @Nullable String str, @Nullable String str2) {
        this.point = point2;
        this.areaId = str;
        this.timezone = str2;
    }

    public static /* synthetic */ Location copy$default(Location location, Point point2, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            point2 = location.point;
        }
        if ((i11 & 2) != 0) {
            str = location.areaId;
        }
        if ((i11 & 4) != 0) {
            str2 = location.timezone;
        }
        return location.copy(point2, str, str2);
    }

    @Nullable
    public final Point component1() {
        return this.point;
    }

    @Nullable
    public final String component2() {
        return this.areaId;
    }

    @Nullable
    public final String component3() {
        return this.timezone;
    }

    @NotNull
    public final Location copy(@Nullable Point point2, @Nullable String str, @Nullable String str2) {
        return new Location(point2, str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Location)) {
            return false;
        }
        Location location = (Location) obj;
        return Intrinsics.areEqual((Object) this.point, (Object) location.point) && Intrinsics.areEqual((Object) this.areaId, (Object) location.areaId) && Intrinsics.areEqual((Object) this.timezone, (Object) location.timezone);
    }

    @Nullable
    public final String getAreaId() {
        return this.areaId;
    }

    @Nullable
    public final Point getPoint() {
        return this.point;
    }

    @Nullable
    public final String getTimezone() {
        return this.timezone;
    }

    public int hashCode() {
        Point point2 = this.point;
        int i11 = 0;
        int hashCode = (point2 == null ? 0 : point2.hashCode()) * 31;
        String str = this.areaId;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.timezone;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return hashCode2 + i11;
    }

    @NotNull
    public String toString() {
        Point point2 = this.point;
        String str = this.areaId;
        String str2 = this.timezone;
        return "Location(point=" + point2 + ", areaId=" + str + ", timezone=" + str2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Location(Point point2, String str, String str2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : point2, (i11 & 2) != 0 ? null : str, (i11 & 4) != 0 ? null : str2);
    }
}
