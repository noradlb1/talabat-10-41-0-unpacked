package com.talabat.configuration.location.model;

import com.google.gson.annotations.SerializedName;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b/\b\b\u0018\u00002\u00020\u0001B¡\u0001\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\f\u0012\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\f\u0012\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\f\u0012\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\u0012J\u0010\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010$J\u0010\u0010)\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010*\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010+\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010,\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010$J\u000b\u00102\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u00103\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u00104\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0016Jª\u0001\u00105\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\f2\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\f2\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\f2\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u00106J\u0013\u00107\u001a\u00020\f2\b\u00108\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00109\u001a\u00020\u0003HÖ\u0001J\t\u0010:\u001a\u00020\u0005HÖ\u0001R \u0010\u000e\u001a\u0004\u0018\u00010\f8\u0006X\u0004¢\u0006\u0010\n\u0002\u0010\u0017\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R \u0010\u000f\u001a\u0004\u0018\u00010\f8\u0006X\u0004¢\u0006\u0010\n\u0002\u0010\u0017\u0012\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0019\u0010\u0016R \u0010\u0010\u001a\u0004\u0018\u00010\f8\u0006X\u0004¢\u0006\u0010\n\u0002\u0010\u0017\u0012\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u0016R \u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006X\u0004¢\u0006\u0010\n\u0002\u0010\u0017\u0012\u0004\b\u001c\u0010\u0014\u001a\u0004\b\u001d\u0010\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001fR\u001a\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010%\u001a\u0004\b#\u0010$R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001fR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010%\u001a\u0004\b'\u0010$R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u000b\u0010\u0016R\u001a\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\r\u0010\u0016¨\u0006;"}, d2 = {"Lcom/talabat/configuration/location/model/AreaEntity;", "", "id", "", "areaCenterPointName", "", "areaCenterPointCoordinates", "areaName", "areaNotation", "cityId", "cityName", "isGemArea", "", "isPolygonServiceEnabled", "_ids", "_im", "_itg", "_rgrl", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "get_ids$annotations", "()V", "get_ids", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "get_im$annotations", "get_im", "get_itg$annotations", "get_itg", "get_rgrl$annotations", "get_rgrl", "getAreaCenterPointCoordinates", "()Ljava/lang/String;", "getAreaCenterPointName", "getAreaName", "getAreaNotation", "getCityId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCityName", "getId", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/talabat/configuration/location/model/AreaEntity;", "equals", "other", "hashCode", "toString", "com_talabat_core_configuration_remote_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AreaEntity {
    @SerializedName("ids")
    @Nullable
    private final Boolean _ids;
    @SerializedName("im")
    @Nullable
    private final Boolean _im;
    @SerializedName("itg")
    @Nullable
    private final Boolean _itg;
    @SerializedName("rgrl")
    @Nullable
    private final Boolean _rgrl;
    @SerializedName("polc")
    @Nullable
    private final String areaCenterPointCoordinates;
    @SerializedName("pol")
    @Nullable
    private final String areaCenterPointName;
    @SerializedName("an")
    @Nullable
    private final String areaName;
    @SerializedName("sl")
    @Nullable
    private final String areaNotation;
    @SerializedName("cid")
    @Nullable
    private final Integer cityId;
    @SerializedName("cn")
    @Nullable
    private final String cityName;
    @SerializedName("id")
    @Nullable

    /* renamed from: id  reason: collision with root package name */
    private final Integer f55773id;
    @SerializedName("isGemArea")
    @Nullable
    private final Boolean isGemArea;
    @SerializedName("ipse")
    @Nullable
    private final Boolean isPolygonServiceEnabled;

    public AreaEntity() {
        this((Integer) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, 8191, (DefaultConstructorMarker) null);
    }

    public AreaEntity(@Nullable @Json(name = "id") Integer num, @Nullable @Json(name = "pol") String str, @Nullable @Json(name = "polc") String str2, @Nullable @Json(name = "an") String str3, @Nullable @Json(name = "sl") String str4, @Nullable @Json(name = "cid") Integer num2, @Nullable @Json(name = "cn") String str5, @Nullable @Json(name = "isGemArea") Boolean bool, @Nullable @Json(name = "ipse") Boolean bool2, @Nullable @Json(name = "ids") Boolean bool3, @Nullable @Json(name = "im") Boolean bool4, @Nullable @Json(name = "itg") Boolean bool5, @Nullable @Json(name = "rgrl") Boolean bool6) {
        this.f55773id = num;
        this.areaCenterPointName = str;
        this.areaCenterPointCoordinates = str2;
        this.areaName = str3;
        this.areaNotation = str4;
        this.cityId = num2;
        this.cityName = str5;
        this.isGemArea = bool;
        this.isPolygonServiceEnabled = bool2;
        this._ids = bool3;
        this._im = bool4;
        this._itg = bool5;
        this._rgrl = bool6;
    }

    public static /* synthetic */ AreaEntity copy$default(AreaEntity areaEntity, Integer num, String str, String str2, String str3, String str4, Integer num2, String str5, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, int i11, Object obj) {
        AreaEntity areaEntity2 = areaEntity;
        int i12 = i11;
        return areaEntity.copy((i12 & 1) != 0 ? areaEntity2.f55773id : num, (i12 & 2) != 0 ? areaEntity2.areaCenterPointName : str, (i12 & 4) != 0 ? areaEntity2.areaCenterPointCoordinates : str2, (i12 & 8) != 0 ? areaEntity2.areaName : str3, (i12 & 16) != 0 ? areaEntity2.areaNotation : str4, (i12 & 32) != 0 ? areaEntity2.cityId : num2, (i12 & 64) != 0 ? areaEntity2.cityName : str5, (i12 & 128) != 0 ? areaEntity2.isGemArea : bool, (i12 & 256) != 0 ? areaEntity2.isPolygonServiceEnabled : bool2, (i12 & 512) != 0 ? areaEntity2._ids : bool3, (i12 & 1024) != 0 ? areaEntity2._im : bool4, (i12 & 2048) != 0 ? areaEntity2._itg : bool5, (i12 & 4096) != 0 ? areaEntity2._rgrl : bool6);
    }

    @Deprecated(message = "unclassified")
    public static /* synthetic */ void get_ids$annotations() {
    }

    @Deprecated(message = "unclassified")
    public static /* synthetic */ void get_im$annotations() {
    }

    @Deprecated(message = "unclassified")
    public static /* synthetic */ void get_itg$annotations() {
    }

    @Deprecated(message = "unclassified")
    public static /* synthetic */ void get_rgrl$annotations() {
    }

    @Nullable
    public final Integer component1() {
        return this.f55773id;
    }

    @Nullable
    public final Boolean component10() {
        return this._ids;
    }

    @Nullable
    public final Boolean component11() {
        return this._im;
    }

    @Nullable
    public final Boolean component12() {
        return this._itg;
    }

    @Nullable
    public final Boolean component13() {
        return this._rgrl;
    }

    @Nullable
    public final String component2() {
        return this.areaCenterPointName;
    }

    @Nullable
    public final String component3() {
        return this.areaCenterPointCoordinates;
    }

    @Nullable
    public final String component4() {
        return this.areaName;
    }

    @Nullable
    public final String component5() {
        return this.areaNotation;
    }

    @Nullable
    public final Integer component6() {
        return this.cityId;
    }

    @Nullable
    public final String component7() {
        return this.cityName;
    }

    @Nullable
    public final Boolean component8() {
        return this.isGemArea;
    }

    @Nullable
    public final Boolean component9() {
        return this.isPolygonServiceEnabled;
    }

    @NotNull
    public final AreaEntity copy(@Nullable @Json(name = "id") Integer num, @Nullable @Json(name = "pol") String str, @Nullable @Json(name = "polc") String str2, @Nullable @Json(name = "an") String str3, @Nullable @Json(name = "sl") String str4, @Nullable @Json(name = "cid") Integer num2, @Nullable @Json(name = "cn") String str5, @Nullable @Json(name = "isGemArea") Boolean bool, @Nullable @Json(name = "ipse") Boolean bool2, @Nullable @Json(name = "ids") Boolean bool3, @Nullable @Json(name = "im") Boolean bool4, @Nullable @Json(name = "itg") Boolean bool5, @Nullable @Json(name = "rgrl") Boolean bool6) {
        return new AreaEntity(num, str, str2, str3, str4, num2, str5, bool, bool2, bool3, bool4, bool5, bool6);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AreaEntity)) {
            return false;
        }
        AreaEntity areaEntity = (AreaEntity) obj;
        return Intrinsics.areEqual((Object) this.f55773id, (Object) areaEntity.f55773id) && Intrinsics.areEqual((Object) this.areaCenterPointName, (Object) areaEntity.areaCenterPointName) && Intrinsics.areEqual((Object) this.areaCenterPointCoordinates, (Object) areaEntity.areaCenterPointCoordinates) && Intrinsics.areEqual((Object) this.areaName, (Object) areaEntity.areaName) && Intrinsics.areEqual((Object) this.areaNotation, (Object) areaEntity.areaNotation) && Intrinsics.areEqual((Object) this.cityId, (Object) areaEntity.cityId) && Intrinsics.areEqual((Object) this.cityName, (Object) areaEntity.cityName) && Intrinsics.areEqual((Object) this.isGemArea, (Object) areaEntity.isGemArea) && Intrinsics.areEqual((Object) this.isPolygonServiceEnabled, (Object) areaEntity.isPolygonServiceEnabled) && Intrinsics.areEqual((Object) this._ids, (Object) areaEntity._ids) && Intrinsics.areEqual((Object) this._im, (Object) areaEntity._im) && Intrinsics.areEqual((Object) this._itg, (Object) areaEntity._itg) && Intrinsics.areEqual((Object) this._rgrl, (Object) areaEntity._rgrl);
    }

    @Nullable
    public final String getAreaCenterPointCoordinates() {
        return this.areaCenterPointCoordinates;
    }

    @Nullable
    public final String getAreaCenterPointName() {
        return this.areaCenterPointName;
    }

    @Nullable
    public final String getAreaName() {
        return this.areaName;
    }

    @Nullable
    public final String getAreaNotation() {
        return this.areaNotation;
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
    public final Integer getId() {
        return this.f55773id;
    }

    @Nullable
    public final Boolean get_ids() {
        return this._ids;
    }

    @Nullable
    public final Boolean get_im() {
        return this._im;
    }

    @Nullable
    public final Boolean get_itg() {
        return this._itg;
    }

    @Nullable
    public final Boolean get_rgrl() {
        return this._rgrl;
    }

    public int hashCode() {
        Integer num = this.f55773id;
        int i11 = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.areaCenterPointName;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.areaCenterPointCoordinates;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.areaName;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.areaNotation;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num2 = this.cityId;
        int hashCode6 = (hashCode5 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str5 = this.cityName;
        int hashCode7 = (hashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Boolean bool = this.isGemArea;
        int hashCode8 = (hashCode7 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.isPolygonServiceEnabled;
        int hashCode9 = (hashCode8 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this._ids;
        int hashCode10 = (hashCode9 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Boolean bool4 = this._im;
        int hashCode11 = (hashCode10 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        Boolean bool5 = this._itg;
        int hashCode12 = (hashCode11 + (bool5 == null ? 0 : bool5.hashCode())) * 31;
        Boolean bool6 = this._rgrl;
        if (bool6 != null) {
            i11 = bool6.hashCode();
        }
        return hashCode12 + i11;
    }

    @Nullable
    public final Boolean isGemArea() {
        return this.isGemArea;
    }

    @Nullable
    public final Boolean isPolygonServiceEnabled() {
        return this.isPolygonServiceEnabled;
    }

    @NotNull
    public String toString() {
        Integer num = this.f55773id;
        String str = this.areaCenterPointName;
        String str2 = this.areaCenterPointCoordinates;
        String str3 = this.areaName;
        String str4 = this.areaNotation;
        Integer num2 = this.cityId;
        String str5 = this.cityName;
        Boolean bool = this.isGemArea;
        Boolean bool2 = this.isPolygonServiceEnabled;
        Boolean bool3 = this._ids;
        Boolean bool4 = this._im;
        Boolean bool5 = this._itg;
        Boolean bool6 = this._rgrl;
        return "AreaEntity(id=" + num + ", areaCenterPointName=" + str + ", areaCenterPointCoordinates=" + str2 + ", areaName=" + str3 + ", areaNotation=" + str4 + ", cityId=" + num2 + ", cityName=" + str5 + ", isGemArea=" + bool + ", isPolygonServiceEnabled=" + bool2 + ", _ids=" + bool3 + ", _im=" + bool4 + ", _itg=" + bool5 + ", _rgrl=" + bool6 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AreaEntity(java.lang.Integer r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.Integer r20, java.lang.String r21, java.lang.Boolean r22, java.lang.Boolean r23, java.lang.Boolean r24, java.lang.Boolean r25, java.lang.Boolean r26, java.lang.Boolean r27, int r28, kotlin.jvm.internal.DefaultConstructorMarker r29) {
        /*
            r14 = this;
            r0 = r28
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r15
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0012
        L_0x0010:
            r3 = r16
        L_0x0012:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0018
            r4 = r2
            goto L_0x001a
        L_0x0018:
            r4 = r17
        L_0x001a:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0020
            r5 = r2
            goto L_0x0022
        L_0x0020:
            r5 = r18
        L_0x0022:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0028
            r6 = r2
            goto L_0x002a
        L_0x0028:
            r6 = r19
        L_0x002a:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0030
            r7 = r2
            goto L_0x0032
        L_0x0030:
            r7 = r20
        L_0x0032:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0038
            r8 = r2
            goto L_0x003a
        L_0x0038:
            r8 = r21
        L_0x003a:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0040
            r9 = r2
            goto L_0x0042
        L_0x0040:
            r9 = r22
        L_0x0042:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0048
            r10 = r2
            goto L_0x004a
        L_0x0048:
            r10 = r23
        L_0x004a:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0050
            r11 = r2
            goto L_0x0052
        L_0x0050:
            r11 = r24
        L_0x0052:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0058
            r12 = r2
            goto L_0x005a
        L_0x0058:
            r12 = r25
        L_0x005a:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0060
            r13 = r2
            goto L_0x0062
        L_0x0060:
            r13 = r26
        L_0x0062:
            r0 = r0 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L_0x0067
            goto L_0x0069
        L_0x0067:
            r2 = r27
        L_0x0069:
            r15 = r14
            r16 = r1
            r17 = r3
            r18 = r4
            r19 = r5
            r20 = r6
            r21 = r7
            r22 = r8
            r23 = r9
            r24 = r10
            r25 = r11
            r26 = r12
            r27 = r13
            r28 = r2
            r15.<init>(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.configuration.location.model.AreaEntity.<init>(java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
