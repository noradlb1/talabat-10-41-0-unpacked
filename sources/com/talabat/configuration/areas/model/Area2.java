package com.talabat.configuration.areas.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u001b\b\b\u0018\u00002\u00020\u0001BY\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0017Jb\u0010 \u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020\u000b2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0003HÖ\u0001J\t\u0010%\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0012\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0014\u0010\u000eR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017¨\u0006&"}, d2 = {"Lcom/talabat/configuration/areas/model/Area2;", "", "areaId", "", "areaName", "", "cityId", "cityName", "countryId", "polygonCenter", "polygonEnabled", "", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;)V", "getAreaId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAreaName", "()Ljava/lang/String;", "getCityId", "getCityName", "getCountryId", "getPolygonCenter", "getPolygonEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/talabat/configuration/areas/model/Area2;", "equals", "other", "hashCode", "toString", "com_talabat_core_configuration_remote_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Area2 {
    @Nullable
    private final Integer areaId;
    @Nullable
    private final String areaName;
    @Nullable
    private final Integer cityId;
    @Nullable
    private final String cityName;
    @Nullable
    private final Integer countryId;
    @Nullable
    private final String polygonCenter;
    @Nullable
    private final Boolean polygonEnabled;

    public Area2() {
        this((Integer) null, (String) null, (Integer) null, (String) null, (Integer) null, (String) null, (Boolean) null, 127, (DefaultConstructorMarker) null);
    }

    public Area2(@Nullable @Json(name = "area_id") Integer num, @Nullable @Json(name = "area_name") String str, @Nullable @Json(name = "city_id") Integer num2, @Nullable @Json(name = "city_name") String str2, @Nullable @Json(name = "country_id") Integer num3, @Nullable @Json(name = "polygon_center") String str3, @Nullable @Json(name = "polygon_enabled") Boolean bool) {
        this.areaId = num;
        this.areaName = str;
        this.cityId = num2;
        this.cityName = str2;
        this.countryId = num3;
        this.polygonCenter = str3;
        this.polygonEnabled = bool;
    }

    public static /* synthetic */ Area2 copy$default(Area2 area2, Integer num, String str, Integer num2, String str2, Integer num3, String str3, Boolean bool, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = area2.areaId;
        }
        if ((i11 & 2) != 0) {
            str = area2.areaName;
        }
        String str4 = str;
        if ((i11 & 4) != 0) {
            num2 = area2.cityId;
        }
        Integer num4 = num2;
        if ((i11 & 8) != 0) {
            str2 = area2.cityName;
        }
        String str5 = str2;
        if ((i11 & 16) != 0) {
            num3 = area2.countryId;
        }
        Integer num5 = num3;
        if ((i11 & 32) != 0) {
            str3 = area2.polygonCenter;
        }
        String str6 = str3;
        if ((i11 & 64) != 0) {
            bool = area2.polygonEnabled;
        }
        return area2.copy(num, str4, num4, str5, num5, str6, bool);
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
    public final Integer component3() {
        return this.cityId;
    }

    @Nullable
    public final String component4() {
        return this.cityName;
    }

    @Nullable
    public final Integer component5() {
        return this.countryId;
    }

    @Nullable
    public final String component6() {
        return this.polygonCenter;
    }

    @Nullable
    public final Boolean component7() {
        return this.polygonEnabled;
    }

    @NotNull
    public final Area2 copy(@Nullable @Json(name = "area_id") Integer num, @Nullable @Json(name = "area_name") String str, @Nullable @Json(name = "city_id") Integer num2, @Nullable @Json(name = "city_name") String str2, @Nullable @Json(name = "country_id") Integer num3, @Nullable @Json(name = "polygon_center") String str3, @Nullable @Json(name = "polygon_enabled") Boolean bool) {
        return new Area2(num, str, num2, str2, num3, str3, bool);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Area2)) {
            return false;
        }
        Area2 area2 = (Area2) obj;
        return Intrinsics.areEqual((Object) this.areaId, (Object) area2.areaId) && Intrinsics.areEqual((Object) this.areaName, (Object) area2.areaName) && Intrinsics.areEqual((Object) this.cityId, (Object) area2.cityId) && Intrinsics.areEqual((Object) this.cityName, (Object) area2.cityName) && Intrinsics.areEqual((Object) this.countryId, (Object) area2.countryId) && Intrinsics.areEqual((Object) this.polygonCenter, (Object) area2.polygonCenter) && Intrinsics.areEqual((Object) this.polygonEnabled, (Object) area2.polygonEnabled);
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
    public final Integer getCityId() {
        return this.cityId;
    }

    @Nullable
    public final String getCityName() {
        return this.cityName;
    }

    @Nullable
    public final Integer getCountryId() {
        return this.countryId;
    }

    @Nullable
    public final String getPolygonCenter() {
        return this.polygonCenter;
    }

    @Nullable
    public final Boolean getPolygonEnabled() {
        return this.polygonEnabled;
    }

    public int hashCode() {
        Integer num = this.areaId;
        int i11 = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.areaName;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num2 = this.cityId;
        int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str2 = this.cityName;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num3 = this.countryId;
        int hashCode5 = (hashCode4 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str3 = this.polygonCenter;
        int hashCode6 = (hashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Boolean bool = this.polygonEnabled;
        if (bool != null) {
            i11 = bool.hashCode();
        }
        return hashCode6 + i11;
    }

    @NotNull
    public String toString() {
        Integer num = this.areaId;
        String str = this.areaName;
        Integer num2 = this.cityId;
        String str2 = this.cityName;
        Integer num3 = this.countryId;
        String str3 = this.polygonCenter;
        Boolean bool = this.polygonEnabled;
        return "Area2(areaId=" + num + ", areaName=" + str + ", cityId=" + num2 + ", cityName=" + str2 + ", countryId=" + num3 + ", polygonCenter=" + str3 + ", polygonEnabled=" + bool + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Area2(java.lang.Integer r7, java.lang.String r8, java.lang.Integer r9, java.lang.String r10, java.lang.Integer r11, java.lang.String r12, java.lang.Boolean r13, int r14, kotlin.jvm.internal.DefaultConstructorMarker r15) {
        /*
            r6 = this;
            r15 = r14 & 1
            r0 = 0
            if (r15 == 0) goto L_0x0007
            r15 = r0
            goto L_0x0008
        L_0x0007:
            r15 = r7
        L_0x0008:
            r7 = r14 & 2
            if (r7 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r8
        L_0x000f:
            r7 = r14 & 4
            if (r7 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r9
        L_0x0016:
            r7 = r14 & 8
            if (r7 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r10
        L_0x001d:
            r7 = r14 & 16
            if (r7 == 0) goto L_0x0023
            r4 = r0
            goto L_0x0024
        L_0x0023:
            r4 = r11
        L_0x0024:
            r7 = r14 & 32
            if (r7 == 0) goto L_0x002a
            r5 = r0
            goto L_0x002b
        L_0x002a:
            r5 = r12
        L_0x002b:
            r7 = r14 & 64
            if (r7 == 0) goto L_0x0031
            r14 = r0
            goto L_0x0032
        L_0x0031:
            r14 = r13
        L_0x0032:
            r7 = r6
            r8 = r15
            r9 = r1
            r10 = r2
            r11 = r3
            r12 = r4
            r13 = r5
            r7.<init>(r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.configuration.areas.model.Area2.<init>(java.lang.Integer, java.lang.String, java.lang.Integer, java.lang.String, java.lang.Integer, java.lang.String, java.lang.Boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
