package com.talabat.talabatlife.features.vendors.vendorAreas.models;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\nJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010!\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0017JJ\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u0003HÖ\u0001J\t\u0010(\u001a\u00020\u0005HÖ\u0001R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\"\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019¨\u0006)"}, d2 = {"Lcom/talabat/talabatlife/features/vendors/vendorAreas/models/Area;", "", "areaId", "", "areaName", "", "cityName", "latitude", "", "longitude", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;)V", "getAreaId", "()Ljava/lang/Integer;", "setAreaId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getAreaName", "()Ljava/lang/String;", "setAreaName", "(Ljava/lang/String;)V", "getCityName", "setCityName", "getLatitude", "()Ljava/lang/Double;", "setLatitude", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getLongitude", "setLongitude", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;)Lcom/talabat/talabatlife/features/vendors/vendorAreas/models/Area;", "equals", "", "other", "hashCode", "toString", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Area {
    @SerializedName("areaId")
    @Nullable
    private Integer areaId;
    @SerializedName("areaName")
    @Nullable
    private String areaName;
    @SerializedName("cityName")
    @Nullable
    private String cityName;
    @SerializedName("latitude")
    @Nullable
    private Double latitude;
    @SerializedName("longitude")
    @Nullable
    private Double longitude;

    public Area() {
        this((Integer) null, (String) null, (String) null, (Double) null, (Double) null, 31, (DefaultConstructorMarker) null);
    }

    public Area(@Nullable Integer num, @Nullable String str, @Nullable String str2, @Nullable Double d11, @Nullable Double d12) {
        this.areaId = num;
        this.areaName = str;
        this.cityName = str2;
        this.latitude = d11;
        this.longitude = d12;
    }

    public static /* synthetic */ Area copy$default(Area area, Integer num, String str, String str2, Double d11, Double d12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = area.areaId;
        }
        if ((i11 & 2) != 0) {
            str = area.areaName;
        }
        String str3 = str;
        if ((i11 & 4) != 0) {
            str2 = area.cityName;
        }
        String str4 = str2;
        if ((i11 & 8) != 0) {
            d11 = area.latitude;
        }
        Double d13 = d11;
        if ((i11 & 16) != 0) {
            d12 = area.longitude;
        }
        return area.copy(num, str3, str4, d13, d12);
    }

    @Nullable
    public final Integer component1() {
        return this.areaId;
    }

    @Nullable
    public final String component2() {
        return this.areaName;
    }

    @Nullable
    public final String component3() {
        return this.cityName;
    }

    @Nullable
    public final Double component4() {
        return this.latitude;
    }

    @Nullable
    public final Double component5() {
        return this.longitude;
    }

    @NotNull
    public final Area copy(@Nullable Integer num, @Nullable String str, @Nullable String str2, @Nullable Double d11, @Nullable Double d12) {
        return new Area(num, str, str2, d11, d12);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Area)) {
            return false;
        }
        Area area = (Area) obj;
        return Intrinsics.areEqual((Object) this.areaId, (Object) area.areaId) && Intrinsics.areEqual((Object) this.areaName, (Object) area.areaName) && Intrinsics.areEqual((Object) this.cityName, (Object) area.cityName) && Intrinsics.areEqual((Object) this.latitude, (Object) area.latitude) && Intrinsics.areEqual((Object) this.longitude, (Object) area.longitude);
    }

    @Nullable
    public final Integer getAreaId() {
        return this.areaId;
    }

    @Nullable
    public final String getAreaName() {
        return this.areaName;
    }

    @Nullable
    public final String getCityName() {
        return this.cityName;
    }

    @Nullable
    public final Double getLatitude() {
        return this.latitude;
    }

    @Nullable
    public final Double getLongitude() {
        return this.longitude;
    }

    public int hashCode() {
        Integer num = this.areaId;
        int i11 = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.areaName;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.cityName;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Double d11 = this.latitude;
        int hashCode4 = (hashCode3 + (d11 == null ? 0 : d11.hashCode())) * 31;
        Double d12 = this.longitude;
        if (d12 != null) {
            i11 = d12.hashCode();
        }
        return hashCode4 + i11;
    }

    public final void setAreaId(@Nullable Integer num) {
        this.areaId = num;
    }

    public final void setAreaName(@Nullable String str) {
        this.areaName = str;
    }

    public final void setCityName(@Nullable String str) {
        this.cityName = str;
    }

    public final void setLatitude(@Nullable Double d11) {
        this.latitude = d11;
    }

    public final void setLongitude(@Nullable Double d11) {
        this.longitude = d11;
    }

    @NotNull
    public String toString() {
        Integer num = this.areaId;
        String str = this.areaName;
        String str2 = this.cityName;
        Double d11 = this.latitude;
        Double d12 = this.longitude;
        return "Area(areaId=" + num + ", areaName=" + str + ", cityName=" + str2 + ", latitude=" + d11 + ", longitude=" + d12 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Area(java.lang.Integer r5, java.lang.String r6, java.lang.String r7, java.lang.Double r8, java.lang.Double r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
        /*
            r4 = this;
            r11 = r10 & 1
            r0 = 0
            if (r11 == 0) goto L_0x0007
            r11 = r0
            goto L_0x0008
        L_0x0007:
            r11 = r5
        L_0x0008:
            r5 = r10 & 2
            if (r5 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r6
        L_0x000f:
            r5 = r10 & 4
            if (r5 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r7
        L_0x0016:
            r5 = r10 & 8
            if (r5 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r8
        L_0x001d:
            r5 = r10 & 16
            if (r5 == 0) goto L_0x0023
            r10 = r0
            goto L_0x0024
        L_0x0023:
            r10 = r9
        L_0x0024:
            r5 = r4
            r6 = r11
            r7 = r1
            r8 = r2
            r9 = r3
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatlife.features.vendors.vendorAreas.models.Area.<init>(java.lang.Integer, java.lang.String, java.lang.String, java.lang.Double, java.lang.Double, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
