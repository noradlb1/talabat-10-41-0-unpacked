package com.talabat.fluttercore.domain.entities;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003JI\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÖ\u0001J\t\u0010 \u001a\u00020\bHÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0013\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013¨\u0006!"}, d2 = {"Lcom/talabat/fluttercore/domain/entities/FlutterArea;", "", "longitude", "", "latitude", "areaId", "", "areaName", "", "cityId", "cityName", "(DDILjava/lang/String;ILjava/lang/String;)V", "getAreaId", "()I", "getAreaName", "()Ljava/lang/String;", "getCityId", "getCityName", "getLatitude", "()D", "getLongitude", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "com_talabat_NewArchi_TalabatFlutterCore_TalabatFlutterCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FlutterArea {
    private final int areaId;
    @Nullable
    private final String areaName;
    private final int cityId;
    @Nullable
    private final String cityName;
    private final double latitude;
    private final double longitude;

    public FlutterArea(double d11, double d12, int i11, @Nullable String str, int i12, @Nullable String str2) {
        this.longitude = d11;
        this.latitude = d12;
        this.areaId = i11;
        this.areaName = str;
        this.cityId = i12;
        this.cityName = str2;
    }

    public static /* synthetic */ FlutterArea copy$default(FlutterArea flutterArea, double d11, double d12, int i11, String str, int i12, String str2, int i13, Object obj) {
        FlutterArea flutterArea2 = flutterArea;
        return flutterArea.copy((i13 & 1) != 0 ? flutterArea2.longitude : d11, (i13 & 2) != 0 ? flutterArea2.latitude : d12, (i13 & 4) != 0 ? flutterArea2.areaId : i11, (i13 & 8) != 0 ? flutterArea2.areaName : str, (i13 & 16) != 0 ? flutterArea2.cityId : i12, (i13 & 32) != 0 ? flutterArea2.cityName : str2);
    }

    public final double component1() {
        return this.longitude;
    }

    public final double component2() {
        return this.latitude;
    }

    public final int component3() {
        return this.areaId;
    }

    @Nullable
    public final String component4() {
        return this.areaName;
    }

    public final int component5() {
        return this.cityId;
    }

    @Nullable
    public final String component6() {
        return this.cityName;
    }

    @NotNull
    public final FlutterArea copy(double d11, double d12, int i11, @Nullable String str, int i12, @Nullable String str2) {
        return new FlutterArea(d11, d12, i11, str, i12, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FlutterArea)) {
            return false;
        }
        FlutterArea flutterArea = (FlutterArea) obj;
        return Intrinsics.areEqual((Object) Double.valueOf(this.longitude), (Object) Double.valueOf(flutterArea.longitude)) && Intrinsics.areEqual((Object) Double.valueOf(this.latitude), (Object) Double.valueOf(flutterArea.latitude)) && this.areaId == flutterArea.areaId && Intrinsics.areEqual((Object) this.areaName, (Object) flutterArea.areaName) && this.cityId == flutterArea.cityId && Intrinsics.areEqual((Object) this.cityName, (Object) flutterArea.cityName);
    }

    public final int getAreaId() {
        return this.areaId;
    }

    @Nullable
    public final String getAreaName() {
        return this.areaName;
    }

    public final int getCityId() {
        return this.cityId;
    }

    @Nullable
    public final String getCityName() {
        return this.cityName;
    }

    public final double getLatitude() {
        return this.latitude;
    }

    public final double getLongitude() {
        return this.longitude;
    }

    public int hashCode() {
        int a11 = ((((Double.doubleToLongBits(this.longitude) * 31) + Double.doubleToLongBits(this.latitude)) * 31) + this.areaId) * 31;
        String str = this.areaName;
        int i11 = 0;
        int hashCode = (((a11 + (str == null ? 0 : str.hashCode())) * 31) + this.cityId) * 31;
        String str2 = this.cityName;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return hashCode + i11;
    }

    @NotNull
    public String toString() {
        double d11 = this.longitude;
        double d12 = this.latitude;
        int i11 = this.areaId;
        String str = this.areaName;
        int i12 = this.cityId;
        String str2 = this.cityName;
        return "FlutterArea(longitude=" + d11 + ", latitude=" + d12 + ", areaId=" + i11 + ", areaName=" + str + ", cityId=" + i12 + ", cityName=" + str2 + ")";
    }
}
