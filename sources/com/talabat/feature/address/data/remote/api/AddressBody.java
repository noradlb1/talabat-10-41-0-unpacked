package com.talabat.feature.address.data.remote.api;

import androidx.autofill.HintConstants;
import com.adyen.checkout.core.model.Address;
import com.google.gson.annotations.SerializedName;
import com.huawei.location.lite.common.log.logwrite.LogWriteConstants;
import com.visa.checkout.Profile;
import junit.runner.BaseTestRunner;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0006\n\u0002\b2\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B¥\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\b\u0012\u0006\u0010\u0014\u001a\u00020\b\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0003¢\u0006\u0002\u0010\u001aJ\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\bHÆ\u0003J\t\u0010:\u001a\u00020\bHÆ\u0003J\t\u0010;\u001a\u00020\u0016HÆ\u0003J\t\u0010<\u001a\u00020\u0016HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0005HÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\t\u0010A\u001a\u00020\bHÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003JÑ\u0001\u0010G\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u0003HÆ\u0001J\u0013\u0010H\u001a\u00020I2\b\u0010J\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010K\u001a\u00020\bHÖ\u0001J\t\u0010L\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001eR\u0016\u0010\u0013\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0016\u0010\u0014\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u0016\u0010\u0011\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001eR\u0016\u0010\u000f\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001eR\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001eR\u0016\u0010\u0018\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001eR\u0016\u0010\u0019\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001eR\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001eR\u0016\u0010\u0015\u001a\u00020\u00168\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0016\u0010\u0017\u001a\u00020\u00168\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010+R\u0016\u0010\u0012\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001eR\u0016\u0010\u0010\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001eR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001eR\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001eR\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001eR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\"¨\u0006M"}, d2 = {"Lcom/talabat/feature/address/data/remote/api/AddressBody;", "", "profileName", "", "areaId", "", "areaName", "type", "", "block", "judda", "street", "buildingNo", "floor", "suite", "extraDirections", "phoneNumber", "countryCode", "mobileNumber", "cityId", "country", "latitude", "", "longitude", "grl", "grlId", "(Ljava/lang/String;JLjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIDDLjava/lang/String;Ljava/lang/String;)V", "getAreaId", "()J", "getAreaName", "()Ljava/lang/String;", "getBlock", "getBuildingNo", "getCityId", "()I", "getCountry", "getCountryCode", "getExtraDirections", "getFloor", "getGrl", "getGrlId", "getJudda", "getLatitude", "()D", "getLongitude", "getMobileNumber", "getPhoneNumber", "getProfileName", "getStreet", "getSuite", "getType", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "com_talabat_feature_address_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AddressBody {
    @SerializedName("area_id")
    private final long areaId;
    @SerializedName("area_name")
    @NotNull
    private final String areaName;
    @SerializedName("block")
    @NotNull
    private final String block;
    @SerializedName("building_no")
    @NotNull
    private final String buildingNo;
    @SerializedName("city_id")
    private final int cityId;
    @SerializedName("country")
    private final int country;
    @SerializedName("country_code")
    @NotNull
    private final String countryCode;
    @SerializedName("extra_directions")
    @NotNull
    private final String extraDirections;
    @SerializedName("floor")
    @NotNull
    private final String floor;
    @SerializedName("grl")
    @NotNull
    private final String grl;
    @SerializedName("grl_id")
    @NotNull
    private final String grlId;
    @SerializedName("judda")
    @NotNull
    private final String judda;
    @SerializedName("latitude")
    private final double latitude;
    @SerializedName("longitude")
    private final double longitude;
    @SerializedName("mobile_number")
    @NotNull
    private final String mobileNumber;
    @SerializedName("phone_number")
    @NotNull
    private final String phoneNumber;
    @SerializedName("profile_name")
    @NotNull
    private final String profileName;
    @SerializedName("street")
    @NotNull
    private final String street;
    @SerializedName("suite")
    @NotNull
    private final String suite;
    @SerializedName("type")
    private final int type;

    public AddressBody(@NotNull String str, long j11, @NotNull String str2, int i11, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9, @NotNull String str10, @NotNull String str11, @NotNull String str12, int i12, int i13, double d11, double d12, @NotNull String str13, @NotNull String str14) {
        String str15 = str;
        String str16 = str2;
        String str17 = str3;
        String str18 = str4;
        String str19 = str5;
        String str20 = str6;
        String str21 = str7;
        String str22 = str8;
        String str23 = str9;
        String str24 = str10;
        String str25 = str11;
        String str26 = str12;
        String str27 = str13;
        Intrinsics.checkNotNullParameter(str15, Profile.PROFILE_NAME);
        Intrinsics.checkNotNullParameter(str16, "areaName");
        Intrinsics.checkNotNullParameter(str17, "block");
        Intrinsics.checkNotNullParameter(str18, "judda");
        Intrinsics.checkNotNullParameter(str19, Address.KEY_STREET);
        Intrinsics.checkNotNullParameter(str20, "buildingNo");
        Intrinsics.checkNotNullParameter(str21, LogWriteConstants.FLOOR);
        Intrinsics.checkNotNullParameter(str22, BaseTestRunner.SUITE_METHODNAME);
        Intrinsics.checkNotNullParameter(str23, "extraDirections");
        Intrinsics.checkNotNullParameter(str24, HintConstants.AUTOFILL_HINT_PHONE_NUMBER);
        Intrinsics.checkNotNullParameter(str25, "countryCode");
        Intrinsics.checkNotNullParameter(str26, "mobileNumber");
        Intrinsics.checkNotNullParameter(str27, "grl");
        Intrinsics.checkNotNullParameter(str14, "grlId");
        this.profileName = str15;
        this.areaId = j11;
        this.areaName = str16;
        this.type = i11;
        this.block = str17;
        this.judda = str18;
        this.street = str19;
        this.buildingNo = str20;
        this.floor = str21;
        this.suite = str22;
        this.extraDirections = str23;
        this.phoneNumber = str24;
        this.countryCode = str25;
        this.mobileNumber = str26;
        this.cityId = i12;
        this.country = i13;
        this.latitude = d11;
        this.longitude = d12;
        this.grl = str27;
        this.grlId = str14;
    }

    public static /* synthetic */ AddressBody copy$default(AddressBody addressBody, String str, long j11, String str2, int i11, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, int i12, int i13, double d11, double d12, String str13, String str14, int i14, Object obj) {
        AddressBody addressBody2 = addressBody;
        int i15 = i14;
        return addressBody.copy((i15 & 1) != 0 ? addressBody2.profileName : str, (i15 & 2) != 0 ? addressBody2.areaId : j11, (i15 & 4) != 0 ? addressBody2.areaName : str2, (i15 & 8) != 0 ? addressBody2.type : i11, (i15 & 16) != 0 ? addressBody2.block : str3, (i15 & 32) != 0 ? addressBody2.judda : str4, (i15 & 64) != 0 ? addressBody2.street : str5, (i15 & 128) != 0 ? addressBody2.buildingNo : str6, (i15 & 256) != 0 ? addressBody2.floor : str7, (i15 & 512) != 0 ? addressBody2.suite : str8, (i15 & 1024) != 0 ? addressBody2.extraDirections : str9, (i15 & 2048) != 0 ? addressBody2.phoneNumber : str10, (i15 & 4096) != 0 ? addressBody2.countryCode : str11, (i15 & 8192) != 0 ? addressBody2.mobileNumber : str12, (i15 & 16384) != 0 ? addressBody2.cityId : i12, (i15 & 32768) != 0 ? addressBody2.country : i13, (i15 & 65536) != 0 ? addressBody2.latitude : d11, (i15 & 131072) != 0 ? addressBody2.longitude : d12, (i15 & 262144) != 0 ? addressBody2.grl : str13, (i15 & 524288) != 0 ? addressBody2.grlId : str14);
    }

    @NotNull
    public final String component1() {
        return this.profileName;
    }

    @NotNull
    public final String component10() {
        return this.suite;
    }

    @NotNull
    public final String component11() {
        return this.extraDirections;
    }

    @NotNull
    public final String component12() {
        return this.phoneNumber;
    }

    @NotNull
    public final String component13() {
        return this.countryCode;
    }

    @NotNull
    public final String component14() {
        return this.mobileNumber;
    }

    public final int component15() {
        return this.cityId;
    }

    public final int component16() {
        return this.country;
    }

    public final double component17() {
        return this.latitude;
    }

    public final double component18() {
        return this.longitude;
    }

    @NotNull
    public final String component19() {
        return this.grl;
    }

    public final long component2() {
        return this.areaId;
    }

    @NotNull
    public final String component20() {
        return this.grlId;
    }

    @NotNull
    public final String component3() {
        return this.areaName;
    }

    public final int component4() {
        return this.type;
    }

    @NotNull
    public final String component5() {
        return this.block;
    }

    @NotNull
    public final String component6() {
        return this.judda;
    }

    @NotNull
    public final String component7() {
        return this.street;
    }

    @NotNull
    public final String component8() {
        return this.buildingNo;
    }

    @NotNull
    public final String component9() {
        return this.floor;
    }

    @NotNull
    public final AddressBody copy(@NotNull String str, long j11, @NotNull String str2, int i11, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9, @NotNull String str10, @NotNull String str11, @NotNull String str12, int i12, int i13, double d11, double d12, @NotNull String str13, @NotNull String str14) {
        String str15 = str;
        Intrinsics.checkNotNullParameter(str15, Profile.PROFILE_NAME);
        Intrinsics.checkNotNullParameter(str2, "areaName");
        Intrinsics.checkNotNullParameter(str3, "block");
        Intrinsics.checkNotNullParameter(str4, "judda");
        Intrinsics.checkNotNullParameter(str5, Address.KEY_STREET);
        Intrinsics.checkNotNullParameter(str6, "buildingNo");
        Intrinsics.checkNotNullParameter(str7, LogWriteConstants.FLOOR);
        Intrinsics.checkNotNullParameter(str8, BaseTestRunner.SUITE_METHODNAME);
        Intrinsics.checkNotNullParameter(str9, "extraDirections");
        Intrinsics.checkNotNullParameter(str10, HintConstants.AUTOFILL_HINT_PHONE_NUMBER);
        Intrinsics.checkNotNullParameter(str11, "countryCode");
        Intrinsics.checkNotNullParameter(str12, "mobileNumber");
        Intrinsics.checkNotNullParameter(str13, "grl");
        Intrinsics.checkNotNullParameter(str14, "grlId");
        return new AddressBody(str15, j11, str2, i11, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, i12, i13, d11, d12, str13, str14);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AddressBody)) {
            return false;
        }
        AddressBody addressBody = (AddressBody) obj;
        return Intrinsics.areEqual((Object) this.profileName, (Object) addressBody.profileName) && this.areaId == addressBody.areaId && Intrinsics.areEqual((Object) this.areaName, (Object) addressBody.areaName) && this.type == addressBody.type && Intrinsics.areEqual((Object) this.block, (Object) addressBody.block) && Intrinsics.areEqual((Object) this.judda, (Object) addressBody.judda) && Intrinsics.areEqual((Object) this.street, (Object) addressBody.street) && Intrinsics.areEqual((Object) this.buildingNo, (Object) addressBody.buildingNo) && Intrinsics.areEqual((Object) this.floor, (Object) addressBody.floor) && Intrinsics.areEqual((Object) this.suite, (Object) addressBody.suite) && Intrinsics.areEqual((Object) this.extraDirections, (Object) addressBody.extraDirections) && Intrinsics.areEqual((Object) this.phoneNumber, (Object) addressBody.phoneNumber) && Intrinsics.areEqual((Object) this.countryCode, (Object) addressBody.countryCode) && Intrinsics.areEqual((Object) this.mobileNumber, (Object) addressBody.mobileNumber) && this.cityId == addressBody.cityId && this.country == addressBody.country && Intrinsics.areEqual((Object) Double.valueOf(this.latitude), (Object) Double.valueOf(addressBody.latitude)) && Intrinsics.areEqual((Object) Double.valueOf(this.longitude), (Object) Double.valueOf(addressBody.longitude)) && Intrinsics.areEqual((Object) this.grl, (Object) addressBody.grl) && Intrinsics.areEqual((Object) this.grlId, (Object) addressBody.grlId);
    }

    public final long getAreaId() {
        return this.areaId;
    }

    @NotNull
    public final String getAreaName() {
        return this.areaName;
    }

    @NotNull
    public final String getBlock() {
        return this.block;
    }

    @NotNull
    public final String getBuildingNo() {
        return this.buildingNo;
    }

    public final int getCityId() {
        return this.cityId;
    }

    public final int getCountry() {
        return this.country;
    }

    @NotNull
    public final String getCountryCode() {
        return this.countryCode;
    }

    @NotNull
    public final String getExtraDirections() {
        return this.extraDirections;
    }

    @NotNull
    public final String getFloor() {
        return this.floor;
    }

    @NotNull
    public final String getGrl() {
        return this.grl;
    }

    @NotNull
    public final String getGrlId() {
        return this.grlId;
    }

    @NotNull
    public final String getJudda() {
        return this.judda;
    }

    public final double getLatitude() {
        return this.latitude;
    }

    public final double getLongitude() {
        return this.longitude;
    }

    @NotNull
    public final String getMobileNumber() {
        return this.mobileNumber;
    }

    @NotNull
    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    @NotNull
    public final String getProfileName() {
        return this.profileName;
    }

    @NotNull
    public final String getStreet() {
        return this.street;
    }

    @NotNull
    public final String getSuite() {
        return this.suite;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((this.profileName.hashCode() * 31) + a.a(this.areaId)) * 31) + this.areaName.hashCode()) * 31) + this.type) * 31) + this.block.hashCode()) * 31) + this.judda.hashCode()) * 31) + this.street.hashCode()) * 31) + this.buildingNo.hashCode()) * 31) + this.floor.hashCode()) * 31) + this.suite.hashCode()) * 31) + this.extraDirections.hashCode()) * 31) + this.phoneNumber.hashCode()) * 31) + this.countryCode.hashCode()) * 31) + this.mobileNumber.hashCode()) * 31) + this.cityId) * 31) + this.country) * 31) + Double.doubleToLongBits(this.latitude)) * 31) + Double.doubleToLongBits(this.longitude)) * 31) + this.grl.hashCode()) * 31) + this.grlId.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.profileName;
        long j11 = this.areaId;
        String str2 = this.areaName;
        int i11 = this.type;
        String str3 = this.block;
        String str4 = this.judda;
        String str5 = this.street;
        String str6 = this.buildingNo;
        String str7 = this.floor;
        String str8 = this.suite;
        String str9 = this.extraDirections;
        String str10 = this.phoneNumber;
        String str11 = this.countryCode;
        String str12 = this.mobileNumber;
        int i12 = this.cityId;
        String str13 = str11;
        int i13 = this.country;
        double d11 = this.latitude;
        double d12 = this.longitude;
        String str14 = this.grl;
        String str15 = this.grlId;
        return "AddressBody(profileName=" + str + ", areaId=" + j11 + ", areaName=" + str2 + ", type=" + i11 + ", block=" + str3 + ", judda=" + str4 + ", street=" + str5 + ", buildingNo=" + str6 + ", floor=" + str7 + ", suite=" + str8 + ", extraDirections=" + str9 + ", phoneNumber=" + str10 + ", countryCode=" + str13 + ", mobileNumber=" + str12 + ", cityId=" + i12 + ", country=" + i13 + ", latitude=" + d11 + ", longitude=" + d12 + ", grl=" + str14 + ", grlId=" + str15 + ")";
    }
}
