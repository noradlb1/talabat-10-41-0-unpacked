package com.talabat.core.safety.data.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b0\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B¹\u0001\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010/\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003JÂ\u0001\u00105\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00106J\u0013\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010:\u001a\u00020\u0007HÖ\u0001J\t\u0010;\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0015R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b \u0010\u001aR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0015R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0015R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0015R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b$\u0010\u001aR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0015¨\u0006<"}, d2 = {"Lcom/talabat/core/safety/data/model/ShieldInfoDto;", "", "androidInstallationPath", "", "androidPackageName", "appVersion", "countryId", "", "customerId", "deviceAdjustId", "deviceAdvertisingId", "androidId", "deviceModel", "eventType", "ipAddress", "perseusClientId", "perseusSessionId", "platformId", "playIntegrityResponse", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getAndroidId", "()Ljava/lang/String;", "getAndroidInstallationPath", "getAndroidPackageName", "getAppVersion", "getCountryId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCustomerId", "getDeviceAdjustId", "getDeviceAdvertisingId", "getDeviceModel", "getEventType", "getIpAddress", "getPerseusClientId", "getPerseusSessionId", "getPlatformId", "getPlayIntegrityResponse", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/talabat/core/safety/data/model/ShieldInfoDto;", "equals", "", "other", "hashCode", "toString", "com_talabat_core_safety_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ShieldInfoDto {
    @Nullable
    private final String androidId;
    @Nullable
    private final String androidInstallationPath;
    @Nullable
    private final String androidPackageName;
    @Nullable
    private final String appVersion;
    @Nullable
    private final Integer countryId;
    @Nullable
    private final String customerId;
    @Nullable
    private final String deviceAdjustId;
    @Nullable
    private final String deviceAdvertisingId;
    @Nullable
    private final String deviceModel;
    @Nullable
    private final Integer eventType;
    @Nullable
    private final String ipAddress;
    @Nullable
    private final String perseusClientId;
    @Nullable
    private final String perseusSessionId;
    @Nullable
    private final Integer platformId;
    @Nullable
    private final String playIntegrityResponse;

    public ShieldInfoDto(@Nullable @Json(name = "AndroidInstallationPath") String str, @Nullable @Json(name = "AndroidPackageName") String str2, @Nullable @Json(name = "AppVersion") String str3, @Nullable @Json(name = "CountryId") Integer num, @Nullable @Json(name = "CustomerId") String str4, @Nullable @Json(name = "DeviceAdjustId") String str5, @Nullable @Json(name = "DeviceAdvertisingId") String str6, @Nullable @Json(name = "DeviceId") String str7, @Nullable @Json(name = "DeviceModel") String str8, @Nullable @Json(name = "EventType") Integer num2, @Nullable @Json(name = "IpAddress") String str9, @Nullable @Json(name = "PerseusClientId") String str10, @Nullable @Json(name = "PerseusSessionId") String str11, @Nullable @Json(name = "PlatformId") Integer num3, @Nullable @Json(name = "PlayIntegrityResponse") String str12) {
        this.androidInstallationPath = str;
        this.androidPackageName = str2;
        this.appVersion = str3;
        this.countryId = num;
        this.customerId = str4;
        this.deviceAdjustId = str5;
        this.deviceAdvertisingId = str6;
        this.androidId = str7;
        this.deviceModel = str8;
        this.eventType = num2;
        this.ipAddress = str9;
        this.perseusClientId = str10;
        this.perseusSessionId = str11;
        this.platformId = num3;
        this.playIntegrityResponse = str12;
    }

    public static /* synthetic */ ShieldInfoDto copy$default(ShieldInfoDto shieldInfoDto, String str, String str2, String str3, Integer num, String str4, String str5, String str6, String str7, String str8, Integer num2, String str9, String str10, String str11, Integer num3, String str12, int i11, Object obj) {
        ShieldInfoDto shieldInfoDto2 = shieldInfoDto;
        int i12 = i11;
        return shieldInfoDto.copy((i12 & 1) != 0 ? shieldInfoDto2.androidInstallationPath : str, (i12 & 2) != 0 ? shieldInfoDto2.androidPackageName : str2, (i12 & 4) != 0 ? shieldInfoDto2.appVersion : str3, (i12 & 8) != 0 ? shieldInfoDto2.countryId : num, (i12 & 16) != 0 ? shieldInfoDto2.customerId : str4, (i12 & 32) != 0 ? shieldInfoDto2.deviceAdjustId : str5, (i12 & 64) != 0 ? shieldInfoDto2.deviceAdvertisingId : str6, (i12 & 128) != 0 ? shieldInfoDto2.androidId : str7, (i12 & 256) != 0 ? shieldInfoDto2.deviceModel : str8, (i12 & 512) != 0 ? shieldInfoDto2.eventType : num2, (i12 & 1024) != 0 ? shieldInfoDto2.ipAddress : str9, (i12 & 2048) != 0 ? shieldInfoDto2.perseusClientId : str10, (i12 & 4096) != 0 ? shieldInfoDto2.perseusSessionId : str11, (i12 & 8192) != 0 ? shieldInfoDto2.platformId : num3, (i12 & 16384) != 0 ? shieldInfoDto2.playIntegrityResponse : str12);
    }

    @Nullable
    public final String component1() {
        return this.androidInstallationPath;
    }

    @Nullable
    public final Integer component10() {
        return this.eventType;
    }

    @Nullable
    public final String component11() {
        return this.ipAddress;
    }

    @Nullable
    public final String component12() {
        return this.perseusClientId;
    }

    @Nullable
    public final String component13() {
        return this.perseusSessionId;
    }

    @Nullable
    public final Integer component14() {
        return this.platformId;
    }

    @Nullable
    public final String component15() {
        return this.playIntegrityResponse;
    }

    @Nullable
    public final String component2() {
        return this.androidPackageName;
    }

    @Nullable
    public final String component3() {
        return this.appVersion;
    }

    @Nullable
    public final Integer component4() {
        return this.countryId;
    }

    @Nullable
    public final String component5() {
        return this.customerId;
    }

    @Nullable
    public final String component6() {
        return this.deviceAdjustId;
    }

    @Nullable
    public final String component7() {
        return this.deviceAdvertisingId;
    }

    @Nullable
    public final String component8() {
        return this.androidId;
    }

    @Nullable
    public final String component9() {
        return this.deviceModel;
    }

    @NotNull
    public final ShieldInfoDto copy(@Nullable @Json(name = "AndroidInstallationPath") String str, @Nullable @Json(name = "AndroidPackageName") String str2, @Nullable @Json(name = "AppVersion") String str3, @Nullable @Json(name = "CountryId") Integer num, @Nullable @Json(name = "CustomerId") String str4, @Nullable @Json(name = "DeviceAdjustId") String str5, @Nullable @Json(name = "DeviceAdvertisingId") String str6, @Nullable @Json(name = "DeviceId") String str7, @Nullable @Json(name = "DeviceModel") String str8, @Nullable @Json(name = "EventType") Integer num2, @Nullable @Json(name = "IpAddress") String str9, @Nullable @Json(name = "PerseusClientId") String str10, @Nullable @Json(name = "PerseusSessionId") String str11, @Nullable @Json(name = "PlatformId") Integer num3, @Nullable @Json(name = "PlayIntegrityResponse") String str12) {
        return new ShieldInfoDto(str, str2, str3, num, str4, str5, str6, str7, str8, num2, str9, str10, str11, num3, str12);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShieldInfoDto)) {
            return false;
        }
        ShieldInfoDto shieldInfoDto = (ShieldInfoDto) obj;
        return Intrinsics.areEqual((Object) this.androidInstallationPath, (Object) shieldInfoDto.androidInstallationPath) && Intrinsics.areEqual((Object) this.androidPackageName, (Object) shieldInfoDto.androidPackageName) && Intrinsics.areEqual((Object) this.appVersion, (Object) shieldInfoDto.appVersion) && Intrinsics.areEqual((Object) this.countryId, (Object) shieldInfoDto.countryId) && Intrinsics.areEqual((Object) this.customerId, (Object) shieldInfoDto.customerId) && Intrinsics.areEqual((Object) this.deviceAdjustId, (Object) shieldInfoDto.deviceAdjustId) && Intrinsics.areEqual((Object) this.deviceAdvertisingId, (Object) shieldInfoDto.deviceAdvertisingId) && Intrinsics.areEqual((Object) this.androidId, (Object) shieldInfoDto.androidId) && Intrinsics.areEqual((Object) this.deviceModel, (Object) shieldInfoDto.deviceModel) && Intrinsics.areEqual((Object) this.eventType, (Object) shieldInfoDto.eventType) && Intrinsics.areEqual((Object) this.ipAddress, (Object) shieldInfoDto.ipAddress) && Intrinsics.areEqual((Object) this.perseusClientId, (Object) shieldInfoDto.perseusClientId) && Intrinsics.areEqual((Object) this.perseusSessionId, (Object) shieldInfoDto.perseusSessionId) && Intrinsics.areEqual((Object) this.platformId, (Object) shieldInfoDto.platformId) && Intrinsics.areEqual((Object) this.playIntegrityResponse, (Object) shieldInfoDto.playIntegrityResponse);
    }

    @Nullable
    public final String getAndroidId() {
        return this.androidId;
    }

    @Nullable
    public final String getAndroidInstallationPath() {
        return this.androidInstallationPath;
    }

    @Nullable
    public final String getAndroidPackageName() {
        return this.androidPackageName;
    }

    @Nullable
    public final String getAppVersion() {
        return this.appVersion;
    }

    @Nullable
    public final Integer getCountryId() {
        return this.countryId;
    }

    @Nullable
    public final String getCustomerId() {
        return this.customerId;
    }

    @Nullable
    public final String getDeviceAdjustId() {
        return this.deviceAdjustId;
    }

    @Nullable
    public final String getDeviceAdvertisingId() {
        return this.deviceAdvertisingId;
    }

    @Nullable
    public final String getDeviceModel() {
        return this.deviceModel;
    }

    @Nullable
    public final Integer getEventType() {
        return this.eventType;
    }

    @Nullable
    public final String getIpAddress() {
        return this.ipAddress;
    }

    @Nullable
    public final String getPerseusClientId() {
        return this.perseusClientId;
    }

    @Nullable
    public final String getPerseusSessionId() {
        return this.perseusSessionId;
    }

    @Nullable
    public final Integer getPlatformId() {
        return this.platformId;
    }

    @Nullable
    public final String getPlayIntegrityResponse() {
        return this.playIntegrityResponse;
    }

    public int hashCode() {
        String str = this.androidInstallationPath;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.androidPackageName;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.appVersion;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.countryId;
        int hashCode4 = (hashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        String str4 = this.customerId;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.deviceAdjustId;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.deviceAdvertisingId;
        int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.androidId;
        int hashCode8 = (hashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.deviceModel;
        int hashCode9 = (hashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31;
        Integer num2 = this.eventType;
        int hashCode10 = (hashCode9 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str9 = this.ipAddress;
        int hashCode11 = (hashCode10 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.perseusClientId;
        int hashCode12 = (hashCode11 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.perseusSessionId;
        int hashCode13 = (hashCode12 + (str11 == null ? 0 : str11.hashCode())) * 31;
        Integer num3 = this.platformId;
        int hashCode14 = (hashCode13 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str12 = this.playIntegrityResponse;
        if (str12 != null) {
            i11 = str12.hashCode();
        }
        return hashCode14 + i11;
    }

    @NotNull
    public String toString() {
        String str = this.androidInstallationPath;
        String str2 = this.androidPackageName;
        String str3 = this.appVersion;
        Integer num = this.countryId;
        String str4 = this.customerId;
        String str5 = this.deviceAdjustId;
        String str6 = this.deviceAdvertisingId;
        String str7 = this.androidId;
        String str8 = this.deviceModel;
        Integer num2 = this.eventType;
        String str9 = this.ipAddress;
        String str10 = this.perseusClientId;
        String str11 = this.perseusSessionId;
        Integer num3 = this.platformId;
        String str12 = this.playIntegrityResponse;
        return "ShieldInfoDto(androidInstallationPath=" + str + ", androidPackageName=" + str2 + ", appVersion=" + str3 + ", countryId=" + num + ", customerId=" + str4 + ", deviceAdjustId=" + str5 + ", deviceAdvertisingId=" + str6 + ", androidId=" + str7 + ", deviceModel=" + str8 + ", eventType=" + num2 + ", ipAddress=" + str9 + ", perseusClientId=" + str10 + ", perseusSessionId=" + str11 + ", platformId=" + num3 + ", playIntegrityResponse=" + str12 + ")";
    }
}
