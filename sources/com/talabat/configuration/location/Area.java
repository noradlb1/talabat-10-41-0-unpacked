package com.talabat.configuration.location;

import com.talabat.domain.location.GeoCoordinate;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\nHÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/talabat/configuration/location/Area;", "", "id", "", "areaCenterPointCoordinates", "Lcom/talabat/domain/location/GeoCoordinate;", "areaName", "", "cityId", "isPolygonServiceEnabled", "", "(ILcom/talabat/domain/location/GeoCoordinate;Ljava/lang/String;IZ)V", "getAreaCenterPointCoordinates", "()Lcom/talabat/domain/location/GeoCoordinate;", "getAreaName", "()Ljava/lang/String;", "getCityId", "()I", "getId", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "Companion", "com_talabat_core_configuration_remote_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Area {
    public static final int BAD_ID = -1;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final GeoCoordinate areaCenterPointCoordinates;
    @NotNull
    private final String areaName;
    private final int cityId;

    /* renamed from: id  reason: collision with root package name */
    private final int f55766id;
    private final boolean isPolygonServiceEnabled;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J8\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/talabat/configuration/location/Area$Companion;", "", "()V", "BAD_ID", "", "default", "Lcom/talabat/configuration/location/Area;", "id", "areaCenterPointCoordinates", "Lcom/talabat/domain/location/GeoCoordinate;", "areaName", "", "cityId", "isPolygonServiceEnabled", "", "com_talabat_core_configuration_remote_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ Area default$default(Companion companion, int i11, GeoCoordinate geoCoordinate, String str, int i12, boolean z11, int i13, Object obj) {
            if ((i13 & 1) != 0) {
                i11 = 0;
            }
            if ((i13 & 2) != 0) {
                geoCoordinate = GeoCoordinate.Companion.getZERO();
            }
            if ((i13 & 4) != 0) {
                str = "";
            }
            if ((i13 & 8) != 0) {
                i12 = 0;
            }
            if ((i13 & 16) != 0) {
                z11 = false;
            }
            return companion.m9574default(i11, geoCoordinate, str, i12, z11);
        }

        @NotNull
        /* renamed from: default  reason: not valid java name */
        public final Area m9574default(int i11, @NotNull GeoCoordinate geoCoordinate, @NotNull String str, int i12, boolean z11) {
            Intrinsics.checkNotNullParameter(geoCoordinate, "areaCenterPointCoordinates");
            Intrinsics.checkNotNullParameter(str, "areaName");
            return new Area(i11, geoCoordinate, str, i12, z11);
        }
    }

    public Area(int i11, @NotNull GeoCoordinate geoCoordinate, @NotNull String str, int i12, boolean z11) {
        Intrinsics.checkNotNullParameter(geoCoordinate, "areaCenterPointCoordinates");
        Intrinsics.checkNotNullParameter(str, "areaName");
        this.f55766id = i11;
        this.areaCenterPointCoordinates = geoCoordinate;
        this.areaName = str;
        this.cityId = i12;
        this.isPolygonServiceEnabled = z11;
    }

    public static /* synthetic */ Area copy$default(Area area, int i11, GeoCoordinate geoCoordinate, String str, int i12, boolean z11, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i11 = area.f55766id;
        }
        if ((i13 & 2) != 0) {
            geoCoordinate = area.areaCenterPointCoordinates;
        }
        GeoCoordinate geoCoordinate2 = geoCoordinate;
        if ((i13 & 4) != 0) {
            str = area.areaName;
        }
        String str2 = str;
        if ((i13 & 8) != 0) {
            i12 = area.cityId;
        }
        int i14 = i12;
        if ((i13 & 16) != 0) {
            z11 = area.isPolygonServiceEnabled;
        }
        return area.copy(i11, geoCoordinate2, str2, i14, z11);
    }

    public final int component1() {
        return this.f55766id;
    }

    @NotNull
    public final GeoCoordinate component2() {
        return this.areaCenterPointCoordinates;
    }

    @NotNull
    public final String component3() {
        return this.areaName;
    }

    public final int component4() {
        return this.cityId;
    }

    public final boolean component5() {
        return this.isPolygonServiceEnabled;
    }

    @NotNull
    public final Area copy(int i11, @NotNull GeoCoordinate geoCoordinate, @NotNull String str, int i12, boolean z11) {
        Intrinsics.checkNotNullParameter(geoCoordinate, "areaCenterPointCoordinates");
        Intrinsics.checkNotNullParameter(str, "areaName");
        return new Area(i11, geoCoordinate, str, i12, z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Area)) {
            return false;
        }
        Area area = (Area) obj;
        return this.f55766id == area.f55766id && Intrinsics.areEqual((Object) this.areaCenterPointCoordinates, (Object) area.areaCenterPointCoordinates) && Intrinsics.areEqual((Object) this.areaName, (Object) area.areaName) && this.cityId == area.cityId && this.isPolygonServiceEnabled == area.isPolygonServiceEnabled;
    }

    @NotNull
    public final GeoCoordinate getAreaCenterPointCoordinates() {
        return this.areaCenterPointCoordinates;
    }

    @NotNull
    public final String getAreaName() {
        return this.areaName;
    }

    public final int getCityId() {
        return this.cityId;
    }

    public final int getId() {
        return this.f55766id;
    }

    public int hashCode() {
        int hashCode = ((((((this.f55766id * 31) + this.areaCenterPointCoordinates.hashCode()) * 31) + this.areaName.hashCode()) * 31) + this.cityId) * 31;
        boolean z11 = this.isPolygonServiceEnabled;
        if (z11) {
            z11 = true;
        }
        return hashCode + (z11 ? 1 : 0);
    }

    public final boolean isPolygonServiceEnabled() {
        return this.isPolygonServiceEnabled;
    }

    @NotNull
    public String toString() {
        int i11 = this.f55766id;
        GeoCoordinate geoCoordinate = this.areaCenterPointCoordinates;
        String str = this.areaName;
        int i12 = this.cityId;
        boolean z11 = this.isPolygonServiceEnabled;
        return "Area(id=" + i11 + ", areaCenterPointCoordinates=" + geoCoordinate + ", areaName=" + str + ", cityId=" + i12 + ", isPolygonServiceEnabled=" + z11 + ")";
    }
}
