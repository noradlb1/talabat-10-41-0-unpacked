package com.talabat.feature.address.data;

import com.google.gson.annotations.SerializedName;
import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\bF\b\b\u0018\u00002\u00020\u0001Bµ\u0002\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0003\u0010\t\u001a\u00020\u0005\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0003\u0010\u000b\u001a\u00020\u0005\u0012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0003\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0003\u0010\u0014\u001a\u00020\u0013\u0012\b\b\u0003\u0010\u0015\u001a\u00020\u0013\u0012\n\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0003\u0010\u0017\u001a\u00020\u0018\u0012\b\b\u0003\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0003\u0010 \u001a\u00020\u0005¢\u0006\u0002\u0010!J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010D\u001a\u00020\u0013HÆ\u0003J\t\u0010E\u001a\u00020\u0013HÆ\u0003J\t\u0010F\u001a\u00020\u0013HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010H\u001a\u00020\u0018HÆ\u0003J\t\u0010I\u001a\u00020\u0005HÆ\u0003J\t\u0010J\u001a\u00020\u0018HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010Q\u001a\u00020\u0005HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010U\u001a\u00020\u0005HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010W\u001a\u00020\u0005HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0003HÆ\u0003J¹\u0002\u0010Y\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\t\u001a\u00020\u00052\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u000b\u001a\u00020\u00052\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0012\u001a\u00020\u00132\b\b\u0003\u0010\u0014\u001a\u00020\u00132\b\b\u0003\u0010\u0015\u001a\u00020\u00132\n\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0017\u001a\u00020\u00182\b\b\u0003\u0010\u0019\u001a\u00020\u00182\n\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u001c\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u001d\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u001e\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u001f\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010 \u001a\u00020\u0005HÆ\u0001J\u0013\u0010Z\u001a\u00020\u00132\b\u0010[\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\\\u001a\u00020\u0005HÖ\u0001J\t\u0010]\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010%R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010%R\u0016\u0010\t\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010#R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010%R\u0016\u0010\u000b\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010#R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010%R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010%R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010%R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010%R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010%R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010%R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010%R\u0016\u0010\u0012\u001a\u00020\u00138\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u00102R\u0016\u0010\u0014\u001a\u00020\u00138\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u00102R\u0016\u0010\u0015\u001a\u00020\u00138\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u00102R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010%R\u0016\u0010\u0017\u001a\u00020\u00188\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0016\u0010\u0019\u001a\u00020\u00188\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u00105R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010%R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010%R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010%R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010%R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010%R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010%R\u0016\u0010 \u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010#¨\u0006^"}, d2 = {"Lcom/talabat/feature/address/data/AddressDto;", "", "id", "", "areaId", "", "areaName", "block", "buildingNo", "cityId", "countryName", "countyId", "extraDirections", "floor", "geoAddressMsg", "geoAddressTitle", "grl", "grlid", "isAreaSplit", "", "isDeliverable", "isOldAddreses", "judda", "latitude", "", "longitude", "mobileNumber", "mobilNumberCountryCode", "phoneNumber", "profileName", "street", "suite", "type", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZLjava/lang/String;DDLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getAreaId", "()I", "getAreaName", "()Ljava/lang/String;", "getBlock", "getBuildingNo", "getCityId", "getCountryName", "getCountyId", "getExtraDirections", "getFloor", "getGeoAddressMsg", "getGeoAddressTitle", "getGrl", "getGrlid", "getId", "()Z", "getJudda", "getLatitude", "()D", "getLongitude", "getMobilNumberCountryCode", "getMobileNumber", "getPhoneNumber", "getProfileName", "getStreet", "getSuite", "getType", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "com_talabat_feature_address_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AddressDto {
    @SerializedName("aid")
    private final int areaId;
    @SerializedName("an")
    @Nullable
    private final String areaName;
    @SerializedName("blk")
    @Nullable
    private final String block;
    @SerializedName("bno")
    @Nullable
    private final String buildingNo;
    @SerializedName("cid")
    private final int cityId;
    @SerializedName("cnm")
    @Nullable
    private final String countryName;
    @SerializedName("cnt")
    private final int countyId;
    @SerializedName("exd")
    @Nullable
    private final String extraDirections;
    @SerializedName("fl")
    @Nullable
    private final String floor;
    @SerializedName("msg")
    @Nullable
    private final String geoAddressMsg;
    @SerializedName("title")
    @Nullable
    private final String geoAddressTitle;
    @SerializedName("grl")
    @Nullable
    private final String grl;
    @SerializedName("grlid")
    @Nullable
    private final String grlid;
    @SerializedName("eid")
    @NotNull

    /* renamed from: id  reason: collision with root package name */
    private final String f58353id;
    @SerializedName("asplt")
    private final boolean isAreaSplit;
    @SerializedName("efd")
    private final boolean isDeliverable;
    @SerializedName("iso")
    private final boolean isOldAddreses;
    @SerializedName("jd")
    @Nullable
    private final String judda;
    @SerializedName("ltd")
    private final double latitude;
    @SerializedName("lngt")
    private final double longitude;
    @SerializedName("ccd")
    @Nullable
    private final String mobilNumberCountryCode;
    @SerializedName("mob")
    @Nullable
    private final String mobileNumber;
    @SerializedName("ph")
    @Nullable
    private final String phoneNumber;
    @SerializedName("pn")
    @Nullable
    private final String profileName;
    @SerializedName("st")
    @Nullable
    private final String street;
    @SerializedName("su")
    @Nullable
    private final String suite;
    @SerializedName("type")
    private final int type;

    public AddressDto() {
        this((String) null, 0, (String) null, (String) null, (String) null, 0, (String) null, 0, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, false, false, false, (String) null, 0.0d, 0.0d, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 0, 134217727, (DefaultConstructorMarker) null);
    }

    public AddressDto(@NotNull @Json(name = "eid") String str, @Json(name = "aid") int i11, @Nullable @Json(name = "an") String str2, @Nullable @Json(name = "blk") String str3, @Nullable @Json(name = "bno") String str4, @Json(name = "cid") int i12, @Nullable @Json(name = "cnm") String str5, @Json(name = "cnt") int i13, @Nullable @Json(name = "exd") String str6, @Nullable @Json(name = "fl") String str7, @Nullable @Json(name = "msg") String str8, @Nullable @Json(name = "title") String str9, @Nullable @Json(name = "grl") String str10, @Nullable @Json(name = "grlid") String str11, @Json(name = "asplt") boolean z11, @Json(name = "efd") boolean z12, @Json(name = "iso") boolean z13, @Nullable @Json(name = "jd") String str12, @Json(name = "ltd") double d11, @Json(name = "lngt") double d12, @Nullable @Json(name = "mob") String str13, @Nullable @Json(name = "ccd") String str14, @Nullable @Json(name = "ph") String str15, @Nullable @Json(name = "pn") String str16, @Nullable @Json(name = "st") String str17, @Nullable @Json(name = "su") String str18, @Json(name = "type") int i14) {
        Intrinsics.checkNotNullParameter(str, "id");
        this.f58353id = str;
        this.areaId = i11;
        this.areaName = str2;
        this.block = str3;
        this.buildingNo = str4;
        this.cityId = i12;
        this.countryName = str5;
        this.countyId = i13;
        this.extraDirections = str6;
        this.floor = str7;
        this.geoAddressMsg = str8;
        this.geoAddressTitle = str9;
        this.grl = str10;
        this.grlid = str11;
        this.isAreaSplit = z11;
        this.isDeliverable = z12;
        this.isOldAddreses = z13;
        this.judda = str12;
        this.latitude = d11;
        this.longitude = d12;
        this.mobileNumber = str13;
        this.mobilNumberCountryCode = str14;
        this.phoneNumber = str15;
        this.profileName = str16;
        this.street = str17;
        this.suite = str18;
        this.type = i14;
    }

    public static /* synthetic */ AddressDto copy$default(AddressDto addressDto, String str, int i11, String str2, String str3, String str4, int i12, String str5, int i13, String str6, String str7, String str8, String str9, String str10, String str11, boolean z11, boolean z12, boolean z13, String str12, double d11, double d12, String str13, String str14, String str15, String str16, String str17, String str18, int i14, int i15, Object obj) {
        AddressDto addressDto2 = addressDto;
        int i16 = i15;
        return addressDto.copy((i16 & 1) != 0 ? addressDto2.f58353id : str, (i16 & 2) != 0 ? addressDto2.areaId : i11, (i16 & 4) != 0 ? addressDto2.areaName : str2, (i16 & 8) != 0 ? addressDto2.block : str3, (i16 & 16) != 0 ? addressDto2.buildingNo : str4, (i16 & 32) != 0 ? addressDto2.cityId : i12, (i16 & 64) != 0 ? addressDto2.countryName : str5, (i16 & 128) != 0 ? addressDto2.countyId : i13, (i16 & 256) != 0 ? addressDto2.extraDirections : str6, (i16 & 512) != 0 ? addressDto2.floor : str7, (i16 & 1024) != 0 ? addressDto2.geoAddressMsg : str8, (i16 & 2048) != 0 ? addressDto2.geoAddressTitle : str9, (i16 & 4096) != 0 ? addressDto2.grl : str10, (i16 & 8192) != 0 ? addressDto2.grlid : str11, (i16 & 16384) != 0 ? addressDto2.isAreaSplit : z11, (i16 & 32768) != 0 ? addressDto2.isDeliverable : z12, (i16 & 65536) != 0 ? addressDto2.isOldAddreses : z13, (i16 & 131072) != 0 ? addressDto2.judda : str12, (i16 & 262144) != 0 ? addressDto2.latitude : d11, (i16 & 524288) != 0 ? addressDto2.longitude : d12, (i16 & 1048576) != 0 ? addressDto2.mobileNumber : str13, (2097152 & i16) != 0 ? addressDto2.mobilNumberCountryCode : str14, (i16 & 4194304) != 0 ? addressDto2.phoneNumber : str15, (i16 & 8388608) != 0 ? addressDto2.profileName : str16, (i16 & 16777216) != 0 ? addressDto2.street : str17, (i16 & 33554432) != 0 ? addressDto2.suite : str18, (i16 & 67108864) != 0 ? addressDto2.type : i14);
    }

    @NotNull
    public final String component1() {
        return this.f58353id;
    }

    @Nullable
    public final String component10() {
        return this.floor;
    }

    @Nullable
    public final String component11() {
        return this.geoAddressMsg;
    }

    @Nullable
    public final String component12() {
        return this.geoAddressTitle;
    }

    @Nullable
    public final String component13() {
        return this.grl;
    }

    @Nullable
    public final String component14() {
        return this.grlid;
    }

    public final boolean component15() {
        return this.isAreaSplit;
    }

    public final boolean component16() {
        return this.isDeliverable;
    }

    public final boolean component17() {
        return this.isOldAddreses;
    }

    @Nullable
    public final String component18() {
        return this.judda;
    }

    public final double component19() {
        return this.latitude;
    }

    public final int component2() {
        return this.areaId;
    }

    public final double component20() {
        return this.longitude;
    }

    @Nullable
    public final String component21() {
        return this.mobileNumber;
    }

    @Nullable
    public final String component22() {
        return this.mobilNumberCountryCode;
    }

    @Nullable
    public final String component23() {
        return this.phoneNumber;
    }

    @Nullable
    public final String component24() {
        return this.profileName;
    }

    @Nullable
    public final String component25() {
        return this.street;
    }

    @Nullable
    public final String component26() {
        return this.suite;
    }

    public final int component27() {
        return this.type;
    }

    @Nullable
    public final String component3() {
        return this.areaName;
    }

    @Nullable
    public final String component4() {
        return this.block;
    }

    @Nullable
    public final String component5() {
        return this.buildingNo;
    }

    public final int component6() {
        return this.cityId;
    }

    @Nullable
    public final String component7() {
        return this.countryName;
    }

    public final int component8() {
        return this.countyId;
    }

    @Nullable
    public final String component9() {
        return this.extraDirections;
    }

    @NotNull
    public final AddressDto copy(@NotNull @Json(name = "eid") String str, @Json(name = "aid") int i11, @Nullable @Json(name = "an") String str2, @Nullable @Json(name = "blk") String str3, @Nullable @Json(name = "bno") String str4, @Json(name = "cid") int i12, @Nullable @Json(name = "cnm") String str5, @Json(name = "cnt") int i13, @Nullable @Json(name = "exd") String str6, @Nullable @Json(name = "fl") String str7, @Nullable @Json(name = "msg") String str8, @Nullable @Json(name = "title") String str9, @Nullable @Json(name = "grl") String str10, @Nullable @Json(name = "grlid") String str11, @Json(name = "asplt") boolean z11, @Json(name = "efd") boolean z12, @Json(name = "iso") boolean z13, @Nullable @Json(name = "jd") String str12, @Json(name = "ltd") double d11, @Json(name = "lngt") double d12, @Nullable @Json(name = "mob") String str13, @Nullable @Json(name = "ccd") String str14, @Nullable @Json(name = "ph") String str15, @Nullable @Json(name = "pn") String str16, @Nullable @Json(name = "st") String str17, @Nullable @Json(name = "su") String str18, @Json(name = "type") int i14) {
        String str19 = str;
        String str20 = str19;
        Intrinsics.checkNotNullParameter(str19, "id");
        return new AddressDto(str19, i11, str2, str3, str4, i12, str5, i13, str6, str7, str8, str9, str10, str11, z11, z12, z13, str12, d11, d12, str13, str14, str15, str16, str17, str18, i14);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AddressDto)) {
            return false;
        }
        AddressDto addressDto = (AddressDto) obj;
        return Intrinsics.areEqual((Object) this.f58353id, (Object) addressDto.f58353id) && this.areaId == addressDto.areaId && Intrinsics.areEqual((Object) this.areaName, (Object) addressDto.areaName) && Intrinsics.areEqual((Object) this.block, (Object) addressDto.block) && Intrinsics.areEqual((Object) this.buildingNo, (Object) addressDto.buildingNo) && this.cityId == addressDto.cityId && Intrinsics.areEqual((Object) this.countryName, (Object) addressDto.countryName) && this.countyId == addressDto.countyId && Intrinsics.areEqual((Object) this.extraDirections, (Object) addressDto.extraDirections) && Intrinsics.areEqual((Object) this.floor, (Object) addressDto.floor) && Intrinsics.areEqual((Object) this.geoAddressMsg, (Object) addressDto.geoAddressMsg) && Intrinsics.areEqual((Object) this.geoAddressTitle, (Object) addressDto.geoAddressTitle) && Intrinsics.areEqual((Object) this.grl, (Object) addressDto.grl) && Intrinsics.areEqual((Object) this.grlid, (Object) addressDto.grlid) && this.isAreaSplit == addressDto.isAreaSplit && this.isDeliverable == addressDto.isDeliverable && this.isOldAddreses == addressDto.isOldAddreses && Intrinsics.areEqual((Object) this.judda, (Object) addressDto.judda) && Intrinsics.areEqual((Object) Double.valueOf(this.latitude), (Object) Double.valueOf(addressDto.latitude)) && Intrinsics.areEqual((Object) Double.valueOf(this.longitude), (Object) Double.valueOf(addressDto.longitude)) && Intrinsics.areEqual((Object) this.mobileNumber, (Object) addressDto.mobileNumber) && Intrinsics.areEqual((Object) this.mobilNumberCountryCode, (Object) addressDto.mobilNumberCountryCode) && Intrinsics.areEqual((Object) this.phoneNumber, (Object) addressDto.phoneNumber) && Intrinsics.areEqual((Object) this.profileName, (Object) addressDto.profileName) && Intrinsics.areEqual((Object) this.street, (Object) addressDto.street) && Intrinsics.areEqual((Object) this.suite, (Object) addressDto.suite) && this.type == addressDto.type;
    }

    public final int getAreaId() {
        return this.areaId;
    }

    @Nullable
    public final String getAreaName() {
        return this.areaName;
    }

    @Nullable
    public final String getBlock() {
        return this.block;
    }

    @Nullable
    public final String getBuildingNo() {
        return this.buildingNo;
    }

    public final int getCityId() {
        return this.cityId;
    }

    @Nullable
    public final String getCountryName() {
        return this.countryName;
    }

    public final int getCountyId() {
        return this.countyId;
    }

    @Nullable
    public final String getExtraDirections() {
        return this.extraDirections;
    }

    @Nullable
    public final String getFloor() {
        return this.floor;
    }

    @Nullable
    public final String getGeoAddressMsg() {
        return this.geoAddressMsg;
    }

    @Nullable
    public final String getGeoAddressTitle() {
        return this.geoAddressTitle;
    }

    @Nullable
    public final String getGrl() {
        return this.grl;
    }

    @Nullable
    public final String getGrlid() {
        return this.grlid;
    }

    @NotNull
    public final String getId() {
        return this.f58353id;
    }

    @Nullable
    public final String getJudda() {
        return this.judda;
    }

    public final double getLatitude() {
        return this.latitude;
    }

    public final double getLongitude() {
        return this.longitude;
    }

    @Nullable
    public final String getMobilNumberCountryCode() {
        return this.mobilNumberCountryCode;
    }

    @Nullable
    public final String getMobileNumber() {
        return this.mobileNumber;
    }

    @Nullable
    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    @Nullable
    public final String getProfileName() {
        return this.profileName;
    }

    @Nullable
    public final String getStreet() {
        return this.street;
    }

    @Nullable
    public final String getSuite() {
        return this.suite;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        int hashCode = ((this.f58353id.hashCode() * 31) + this.areaId) * 31;
        String str = this.areaName;
        int i11 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.block;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.buildingNo;
        int hashCode4 = (((hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.cityId) * 31;
        String str4 = this.countryName;
        int hashCode5 = (((hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.countyId) * 31;
        String str5 = this.extraDirections;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.floor;
        int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.geoAddressMsg;
        int hashCode8 = (hashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.geoAddressTitle;
        int hashCode9 = (hashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.grl;
        int hashCode10 = (hashCode9 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.grlid;
        int hashCode11 = (hashCode10 + (str10 == null ? 0 : str10.hashCode())) * 31;
        boolean z11 = this.isAreaSplit;
        boolean z12 = true;
        if (z11) {
            z11 = true;
        }
        int i12 = (hashCode11 + (z11 ? 1 : 0)) * 31;
        boolean z13 = this.isDeliverable;
        if (z13) {
            z13 = true;
        }
        int i13 = (i12 + (z13 ? 1 : 0)) * 31;
        boolean z14 = this.isOldAddreses;
        if (!z14) {
            z12 = z14;
        }
        int i14 = (i13 + (z12 ? 1 : 0)) * 31;
        String str11 = this.judda;
        int hashCode12 = (((((i14 + (str11 == null ? 0 : str11.hashCode())) * 31) + Double.doubleToLongBits(this.latitude)) * 31) + Double.doubleToLongBits(this.longitude)) * 31;
        String str12 = this.mobileNumber;
        int hashCode13 = (hashCode12 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.mobilNumberCountryCode;
        int hashCode14 = (hashCode13 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.phoneNumber;
        int hashCode15 = (hashCode14 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.profileName;
        int hashCode16 = (hashCode15 + (str15 == null ? 0 : str15.hashCode())) * 31;
        String str16 = this.street;
        int hashCode17 = (hashCode16 + (str16 == null ? 0 : str16.hashCode())) * 31;
        String str17 = this.suite;
        if (str17 != null) {
            i11 = str17.hashCode();
        }
        return ((hashCode17 + i11) * 31) + this.type;
    }

    public final boolean isAreaSplit() {
        return this.isAreaSplit;
    }

    public final boolean isDeliverable() {
        return this.isDeliverable;
    }

    public final boolean isOldAddreses() {
        return this.isOldAddreses;
    }

    @NotNull
    public String toString() {
        String str = this.f58353id;
        int i11 = this.areaId;
        String str2 = this.areaName;
        String str3 = this.block;
        String str4 = this.buildingNo;
        int i12 = this.cityId;
        String str5 = this.countryName;
        int i13 = this.countyId;
        String str6 = this.extraDirections;
        String str7 = this.floor;
        String str8 = this.geoAddressMsg;
        String str9 = this.geoAddressTitle;
        String str10 = this.grl;
        String str11 = this.grlid;
        boolean z11 = this.isAreaSplit;
        boolean z12 = this.isDeliverable;
        boolean z13 = this.isOldAddreses;
        String str12 = str11;
        String str13 = this.judda;
        double d11 = this.latitude;
        double d12 = this.longitude;
        String str14 = this.mobileNumber;
        String str15 = this.mobilNumberCountryCode;
        String str16 = this.phoneNumber;
        String str17 = this.profileName;
        String str18 = this.street;
        String str19 = this.suite;
        int i14 = this.type;
        return "AddressDto(id=" + str + ", areaId=" + i11 + ", areaName=" + str2 + ", block=" + str3 + ", buildingNo=" + str4 + ", cityId=" + i12 + ", countryName=" + str5 + ", countyId=" + i13 + ", extraDirections=" + str6 + ", floor=" + str7 + ", geoAddressMsg=" + str8 + ", geoAddressTitle=" + str9 + ", grl=" + str10 + ", grlid=" + str12 + ", isAreaSplit=" + z11 + ", isDeliverable=" + z12 + ", isOldAddreses=" + z13 + ", judda=" + str13 + ", latitude=" + d11 + ", longitude=" + d12 + ", mobileNumber=" + str14 + ", mobilNumberCountryCode=" + str15 + ", phoneNumber=" + str16 + ", profileName=" + str17 + ", street=" + str18 + ", suite=" + str19 + ", type=" + i14 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AddressDto(java.lang.String r31, int r32, java.lang.String r33, java.lang.String r34, java.lang.String r35, int r36, java.lang.String r37, int r38, java.lang.String r39, java.lang.String r40, java.lang.String r41, java.lang.String r42, java.lang.String r43, java.lang.String r44, boolean r45, boolean r46, boolean r47, java.lang.String r48, double r49, double r51, java.lang.String r53, java.lang.String r54, java.lang.String r55, java.lang.String r56, java.lang.String r57, java.lang.String r58, int r59, int r60, kotlin.jvm.internal.DefaultConstructorMarker r61) {
        /*
            r30 = this;
            r0 = r60
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0009
            java.lang.String r1 = ""
            goto L_0x000b
        L_0x0009:
            r1 = r31
        L_0x000b:
            r2 = r0 & 2
            if (r2 == 0) goto L_0x0011
            r2 = 0
            goto L_0x0013
        L_0x0011:
            r2 = r32
        L_0x0013:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0019
            r4 = 0
            goto L_0x001b
        L_0x0019:
            r4 = r33
        L_0x001b:
            r6 = r0 & 8
            if (r6 == 0) goto L_0x0021
            r6 = 0
            goto L_0x0023
        L_0x0021:
            r6 = r34
        L_0x0023:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x0029
            r7 = 0
            goto L_0x002b
        L_0x0029:
            r7 = r35
        L_0x002b:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x0031
            r8 = 0
            goto L_0x0033
        L_0x0031:
            r8 = r36
        L_0x0033:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x0039
            r9 = 0
            goto L_0x003b
        L_0x0039:
            r9 = r37
        L_0x003b:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x0041
            r10 = 0
            goto L_0x0043
        L_0x0041:
            r10 = r38
        L_0x0043:
            r11 = r0 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L_0x0049
            r11 = 0
            goto L_0x004b
        L_0x0049:
            r11 = r39
        L_0x004b:
            r12 = r0 & 512(0x200, float:7.175E-43)
            if (r12 == 0) goto L_0x0051
            r12 = 0
            goto L_0x0053
        L_0x0051:
            r12 = r40
        L_0x0053:
            r13 = r0 & 1024(0x400, float:1.435E-42)
            if (r13 == 0) goto L_0x0059
            r13 = 0
            goto L_0x005b
        L_0x0059:
            r13 = r41
        L_0x005b:
            r14 = r0 & 2048(0x800, float:2.87E-42)
            if (r14 == 0) goto L_0x0061
            r14 = 0
            goto L_0x0063
        L_0x0061:
            r14 = r42
        L_0x0063:
            r15 = r0 & 4096(0x1000, float:5.74E-42)
            if (r15 == 0) goto L_0x0069
            r15 = 0
            goto L_0x006b
        L_0x0069:
            r15 = r43
        L_0x006b:
            r3 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r3 == 0) goto L_0x0071
            r3 = 0
            goto L_0x0073
        L_0x0071:
            r3 = r44
        L_0x0073:
            r5 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r5 == 0) goto L_0x0079
            r5 = 0
            goto L_0x007b
        L_0x0079:
            r5 = r45
        L_0x007b:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x0085
            r16 = 0
            goto L_0x0087
        L_0x0085:
            r16 = r46
        L_0x0087:
            r17 = 65536(0x10000, float:9.18355E-41)
            r17 = r0 & r17
            if (r17 == 0) goto L_0x0090
            r17 = 0
            goto L_0x0092
        L_0x0090:
            r17 = r47
        L_0x0092:
            r18 = 131072(0x20000, float:1.83671E-40)
            r18 = r0 & r18
            if (r18 == 0) goto L_0x009b
            r18 = 0
            goto L_0x009d
        L_0x009b:
            r18 = r48
        L_0x009d:
            r19 = 262144(0x40000, float:3.67342E-40)
            r19 = r0 & r19
            r20 = 0
            if (r19 == 0) goto L_0x00a8
            r22 = r20
            goto L_0x00aa
        L_0x00a8:
            r22 = r49
        L_0x00aa:
            r19 = 524288(0x80000, float:7.34684E-40)
            r19 = r0 & r19
            if (r19 == 0) goto L_0x00b1
            goto L_0x00b3
        L_0x00b1:
            r20 = r51
        L_0x00b3:
            r19 = 1048576(0x100000, float:1.469368E-39)
            r19 = r0 & r19
            if (r19 == 0) goto L_0x00bc
            r19 = 0
            goto L_0x00be
        L_0x00bc:
            r19 = r53
        L_0x00be:
            r24 = 2097152(0x200000, float:2.938736E-39)
            r24 = r0 & r24
            if (r24 == 0) goto L_0x00c7
            r24 = 0
            goto L_0x00c9
        L_0x00c7:
            r24 = r54
        L_0x00c9:
            r25 = 4194304(0x400000, float:5.877472E-39)
            r25 = r0 & r25
            if (r25 == 0) goto L_0x00d2
            r25 = 0
            goto L_0x00d4
        L_0x00d2:
            r25 = r55
        L_0x00d4:
            r26 = 8388608(0x800000, float:1.17549435E-38)
            r26 = r0 & r26
            if (r26 == 0) goto L_0x00dd
            r26 = 0
            goto L_0x00df
        L_0x00dd:
            r26 = r56
        L_0x00df:
            r27 = 16777216(0x1000000, float:2.3509887E-38)
            r27 = r0 & r27
            if (r27 == 0) goto L_0x00e8
            r27 = 0
            goto L_0x00ea
        L_0x00e8:
            r27 = r57
        L_0x00ea:
            r28 = 33554432(0x2000000, float:9.403955E-38)
            r28 = r0 & r28
            if (r28 == 0) goto L_0x00f3
            r28 = 0
            goto L_0x00f5
        L_0x00f3:
            r28 = r58
        L_0x00f5:
            r29 = 67108864(0x4000000, float:1.5046328E-36)
            r0 = r0 & r29
            if (r0 == 0) goto L_0x00fd
            r0 = 0
            goto L_0x00ff
        L_0x00fd:
            r0 = r59
        L_0x00ff:
            r31 = r30
            r32 = r1
            r33 = r2
            r34 = r4
            r35 = r6
            r36 = r7
            r37 = r8
            r38 = r9
            r39 = r10
            r40 = r11
            r41 = r12
            r42 = r13
            r43 = r14
            r44 = r15
            r45 = r3
            r46 = r5
            r47 = r16
            r48 = r17
            r49 = r18
            r50 = r22
            r52 = r20
            r54 = r19
            r55 = r24
            r56 = r25
            r57 = r26
            r58 = r27
            r59 = r28
            r60 = r0
            r31.<init>(r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r52, r54, r55, r56, r57, r58, r59, r60)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.address.data.AddressDto.<init>(java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, boolean, boolean, java.lang.String, double, double, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
