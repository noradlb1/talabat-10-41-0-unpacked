package com.deliveryhero.customerchat.fwf;

import com.huawei.location.lite.common.util.DeviceInfoUtil;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BU\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0001\u0010\b\u001a\u00020\u0003\u0012\b\b\u0001\u0010\t\u001a\u00020\u0003\u0012\b\b\u0001\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003JY\u0010\u001d\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u00032\b\b\u0003\u0010\u0007\u001a\u00020\u00032\b\b\u0003\u0010\b\u001a\u00020\u00032\b\b\u0003\u0010\t\u001a\u00020\u00032\b\b\u0003\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006$"}, d2 = {"Lcom/deliveryhero/customerchat/fwf/Custom;", "", "customUserId", "", "gid", "country", "userType", "deviceOsVersion", "platformName", "appVersion", "applicationId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppVersion", "()Ljava/lang/String;", "getApplicationId", "getCountry", "getCustomUserId", "getDeviceOsVersion", "getGid", "getPlatformName", "getUserType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Custom {
    @NotNull
    private final String appVersion;
    @NotNull
    private final String applicationId;
    @NotNull
    private final String country;
    @NotNull
    private final String customUserId;
    @NotNull
    private final String deviceOsVersion;
    @NotNull
    private final String gid;
    @NotNull
    private final String platformName;
    @NotNull
    private final String userType;

    public Custom(@NotNull @Json(name = "customUserId") String str, @NotNull @Json(name = "gid") String str2, @NotNull @Json(name = "country") String str3, @NotNull @Json(name = "userType") String str4, @NotNull @Json(name = "deviceOsVersion") String str5, @NotNull @Json(name = "platformName") String str6, @NotNull @Json(name = "appVersion") String str7, @NotNull @Json(name = "applicationId") String str8) {
        Intrinsics.checkNotNullParameter(str, "customUserId");
        Intrinsics.checkNotNullParameter(str2, "gid");
        Intrinsics.checkNotNullParameter(str3, "country");
        Intrinsics.checkNotNullParameter(str4, DeviceInfoUtil.DeviceProperty.USERTYPE);
        Intrinsics.checkNotNullParameter(str5, "deviceOsVersion");
        Intrinsics.checkNotNullParameter(str6, "platformName");
        Intrinsics.checkNotNullParameter(str7, "appVersion");
        Intrinsics.checkNotNullParameter(str8, "applicationId");
        this.customUserId = str;
        this.gid = str2;
        this.country = str3;
        this.userType = str4;
        this.deviceOsVersion = str5;
        this.platformName = str6;
        this.appVersion = str7;
        this.applicationId = str8;
    }

    public static /* synthetic */ Custom copy$default(Custom custom, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i11, Object obj) {
        Custom custom2 = custom;
        int i12 = i11;
        return custom.copy((i12 & 1) != 0 ? custom2.customUserId : str, (i12 & 2) != 0 ? custom2.gid : str2, (i12 & 4) != 0 ? custom2.country : str3, (i12 & 8) != 0 ? custom2.userType : str4, (i12 & 16) != 0 ? custom2.deviceOsVersion : str5, (i12 & 32) != 0 ? custom2.platformName : str6, (i12 & 64) != 0 ? custom2.appVersion : str7, (i12 & 128) != 0 ? custom2.applicationId : str8);
    }

    @NotNull
    public final String component1() {
        return this.customUserId;
    }

    @NotNull
    public final String component2() {
        return this.gid;
    }

    @NotNull
    public final String component3() {
        return this.country;
    }

    @NotNull
    public final String component4() {
        return this.userType;
    }

    @NotNull
    public final String component5() {
        return this.deviceOsVersion;
    }

    @NotNull
    public final String component6() {
        return this.platformName;
    }

    @NotNull
    public final String component7() {
        return this.appVersion;
    }

    @NotNull
    public final String component8() {
        return this.applicationId;
    }

    @NotNull
    public final Custom copy(@NotNull @Json(name = "customUserId") String str, @NotNull @Json(name = "gid") String str2, @NotNull @Json(name = "country") String str3, @NotNull @Json(name = "userType") String str4, @NotNull @Json(name = "deviceOsVersion") String str5, @NotNull @Json(name = "platformName") String str6, @NotNull @Json(name = "appVersion") String str7, @NotNull @Json(name = "applicationId") String str8) {
        Intrinsics.checkNotNullParameter(str, "customUserId");
        Intrinsics.checkNotNullParameter(str2, "gid");
        Intrinsics.checkNotNullParameter(str3, "country");
        Intrinsics.checkNotNullParameter(str4, DeviceInfoUtil.DeviceProperty.USERTYPE);
        Intrinsics.checkNotNullParameter(str5, "deviceOsVersion");
        String str9 = str6;
        Intrinsics.checkNotNullParameter(str9, "platformName");
        String str10 = str7;
        Intrinsics.checkNotNullParameter(str10, "appVersion");
        String str11 = str8;
        Intrinsics.checkNotNullParameter(str11, "applicationId");
        return new Custom(str, str2, str3, str4, str5, str9, str10, str11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Custom)) {
            return false;
        }
        Custom custom = (Custom) obj;
        return Intrinsics.areEqual((Object) this.customUserId, (Object) custom.customUserId) && Intrinsics.areEqual((Object) this.gid, (Object) custom.gid) && Intrinsics.areEqual((Object) this.country, (Object) custom.country) && Intrinsics.areEqual((Object) this.userType, (Object) custom.userType) && Intrinsics.areEqual((Object) this.deviceOsVersion, (Object) custom.deviceOsVersion) && Intrinsics.areEqual((Object) this.platformName, (Object) custom.platformName) && Intrinsics.areEqual((Object) this.appVersion, (Object) custom.appVersion) && Intrinsics.areEqual((Object) this.applicationId, (Object) custom.applicationId);
    }

    @NotNull
    public final String getAppVersion() {
        return this.appVersion;
    }

    @NotNull
    public final String getApplicationId() {
        return this.applicationId;
    }

    @NotNull
    public final String getCountry() {
        return this.country;
    }

    @NotNull
    public final String getCustomUserId() {
        return this.customUserId;
    }

    @NotNull
    public final String getDeviceOsVersion() {
        return this.deviceOsVersion;
    }

    @NotNull
    public final String getGid() {
        return this.gid;
    }

    @NotNull
    public final String getPlatformName() {
        return this.platformName;
    }

    @NotNull
    public final String getUserType() {
        return this.userType;
    }

    public int hashCode() {
        return (((((((((((((this.customUserId.hashCode() * 31) + this.gid.hashCode()) * 31) + this.country.hashCode()) * 31) + this.userType.hashCode()) * 31) + this.deviceOsVersion.hashCode()) * 31) + this.platformName.hashCode()) * 31) + this.appVersion.hashCode()) * 31) + this.applicationId.hashCode();
    }

    @NotNull
    public String toString() {
        return "Custom(customUserId=" + this.customUserId + ", gid=" + this.gid + ", country=" + this.country + ", userType=" + this.userType + ", deviceOsVersion=" + this.deviceOsVersion + ", platformName=" + this.platformName + ", appVersion=" + this.appVersion + ", applicationId=" + this.applicationId + ')';
    }
}
