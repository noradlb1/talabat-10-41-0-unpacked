package com.talabat.feature.address.data.remote.dto;

import androidx.autofill.HintConstants;
import com.adyen.checkout.core.model.Address;
import com.huawei.location.lite.common.log.logwrite.LogWriteConstants;
import com.visa.checkout.Profile;
import junit.runner.BaseTestRunner;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b<\b\b\u0018\u00002\u00020\u0001:\u0001ZBÇ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0018\u001a\u00020\t\u0012\u0006\u0010\u0019\u001a\u00020\u001a\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\u0006\u0010\u001d\u001a\u00020\u0003\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\u0002\u0010 J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\t\u0010D\u001a\u00020\tHÆ\u0003J\t\u0010E\u001a\u00020\u0016HÆ\u0003J\t\u0010F\u001a\u00020\u0016HÆ\u0003J\t\u0010G\u001a\u00020\tHÆ\u0003J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\t\u0010I\u001a\u00020\u001aHÆ\u0003J\t\u0010J\u001a\u00020\u001aHÆ\u0003J\t\u0010K\u001a\u00020\u0003HÆ\u0003J\t\u0010L\u001a\u00020\u0003HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u001fHÆ\u0003J\t\u0010N\u001a\u00020\u0006HÆ\u0003J\t\u0010O\u001a\u00020\u0003HÆ\u0003J\t\u0010P\u001a\u00020\tHÆ\u0003J\t\u0010Q\u001a\u00020\u0003HÆ\u0003J\t\u0010R\u001a\u00020\u0003HÆ\u0003J\t\u0010S\u001a\u00020\u0003HÆ\u0003J\t\u0010T\u001a\u00020\u0003HÆ\u0003Jû\u0001\u0010U\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\t2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0018\u001a\u00020\t2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÆ\u0001J\u0013\u0010V\u001a\u00020\u00162\b\u0010W\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010X\u001a\u00020\tHÖ\u0001J\t\u0010Y\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010$R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010$R\u0011\u0010\u0014\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u0018\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b)\u0010(R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010$R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010$R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010$R\u0011\u0010\u001c\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010$R\u0011\u0010\u001d\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010$R\u0011\u0010\u0017\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u00101R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u00101R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010$R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u0010\u001b\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b5\u00104R\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b6\u0010$R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b7\u0010$R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u0010$R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b9\u0010$R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b:\u0010$R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b;\u0010$R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b<\u0010(¨\u0006["}, d2 = {"Lcom/talabat/feature/address/data/remote/dto/UpdateAddressDto;", "", "profileId", "", "profileName", "areaId", "", "areaName", "type", "", "block", "judda", "street", "buildingNo", "floor", "suite", "extraDirections", "phoneNumber", "countryCode", "mobileNumber", "cityId", "isEligibleForDelivery", "", "isAreaDisabled", "country", "latitude", "", "longitude", "grl", "grlId", "error", "Lcom/talabat/feature/address/data/remote/dto/UpdateAddressDto$Error;", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZZIDDLjava/lang/String;Ljava/lang/String;Lcom/talabat/feature/address/data/remote/dto/UpdateAddressDto$Error;)V", "getAreaId", "()J", "getAreaName", "()Ljava/lang/String;", "getBlock", "getBuildingNo", "getCityId", "()I", "getCountry", "getCountryCode", "getError", "()Lcom/talabat/feature/address/data/remote/dto/UpdateAddressDto$Error;", "getExtraDirections", "getFloor", "getGrl", "getGrlId", "()Z", "getJudda", "getLatitude", "()D", "getLongitude", "getMobileNumber", "getPhoneNumber", "getProfileId", "getProfileName", "getStreet", "getSuite", "getType", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "Error", "com_talabat_feature_address_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UpdateAddressDto {
    private final long areaId;
    @NotNull
    private final String areaName;
    @NotNull
    private final String block;
    @NotNull
    private final String buildingNo;
    private final int cityId;
    private final int country;
    @NotNull
    private final String countryCode;
    @Nullable
    private final Error error;
    @NotNull
    private final String extraDirections;
    @NotNull
    private final String floor;
    @NotNull
    private final String grl;
    @NotNull
    private final String grlId;
    private final boolean isAreaDisabled;
    private final boolean isEligibleForDelivery;
    @NotNull
    private final String judda;
    private final double latitude;
    private final double longitude;
    @NotNull
    private final String mobileNumber;
    @NotNull
    private final String phoneNumber;
    @NotNull
    private final String profileId;
    @NotNull
    private final String profileName;
    @NotNull
    private final String street;
    @NotNull
    private final String suite;
    private final int type;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/talabat/feature/address/data/remote/dto/UpdateAddressDto$Error;", "", "statusCode", "", "message", "title", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "getStatusCode", "getTitle", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_address_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Error {
        @NotNull
        private final String message;
        @NotNull
        private final String statusCode;
        @NotNull
        private final String title;

        public Error(@NotNull String str, @NotNull String str2, @NotNull String str3) {
            Intrinsics.checkNotNullParameter(str, "statusCode");
            Intrinsics.checkNotNullParameter(str2, "message");
            Intrinsics.checkNotNullParameter(str3, "title");
            this.statusCode = str;
            this.message = str2;
            this.title = str3;
        }

        public static /* synthetic */ Error copy$default(Error error, String str, String str2, String str3, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = error.statusCode;
            }
            if ((i11 & 2) != 0) {
                str2 = error.message;
            }
            if ((i11 & 4) != 0) {
                str3 = error.title;
            }
            return error.copy(str, str2, str3);
        }

        @NotNull
        public final String component1() {
            return this.statusCode;
        }

        @NotNull
        public final String component2() {
            return this.message;
        }

        @NotNull
        public final String component3() {
            return this.title;
        }

        @NotNull
        public final Error copy(@NotNull String str, @NotNull String str2, @NotNull String str3) {
            Intrinsics.checkNotNullParameter(str, "statusCode");
            Intrinsics.checkNotNullParameter(str2, "message");
            Intrinsics.checkNotNullParameter(str3, "title");
            return new Error(str, str2, str3);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Error)) {
                return false;
            }
            Error error = (Error) obj;
            return Intrinsics.areEqual((Object) this.statusCode, (Object) error.statusCode) && Intrinsics.areEqual((Object) this.message, (Object) error.message) && Intrinsics.areEqual((Object) this.title, (Object) error.title);
        }

        @NotNull
        public final String getMessage() {
            return this.message;
        }

        @NotNull
        public final String getStatusCode() {
            return this.statusCode;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        public int hashCode() {
            return (((this.statusCode.hashCode() * 31) + this.message.hashCode()) * 31) + this.title.hashCode();
        }

        @NotNull
        public String toString() {
            String str = this.statusCode;
            String str2 = this.message;
            String str3 = this.title;
            return "Error(statusCode=" + str + ", message=" + str2 + ", title=" + str3 + ")";
        }
    }

    public UpdateAddressDto(@NotNull String str, @NotNull String str2, long j11, @NotNull String str3, int i11, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9, @NotNull String str10, @NotNull String str11, @NotNull String str12, @NotNull String str13, int i12, boolean z11, boolean z12, int i13, double d11, double d12, @NotNull String str14, @NotNull String str15, @Nullable Error error2) {
        String str16 = str;
        String str17 = str2;
        String str18 = str3;
        String str19 = str4;
        String str20 = str5;
        String str21 = str6;
        String str22 = str7;
        String str23 = str8;
        String str24 = str9;
        String str25 = str10;
        String str26 = str11;
        String str27 = str12;
        String str28 = str13;
        String str29 = str14;
        String str30 = str15;
        Intrinsics.checkNotNullParameter(str16, "profileId");
        Intrinsics.checkNotNullParameter(str17, Profile.PROFILE_NAME);
        Intrinsics.checkNotNullParameter(str18, "areaName");
        Intrinsics.checkNotNullParameter(str19, "block");
        Intrinsics.checkNotNullParameter(str20, "judda");
        Intrinsics.checkNotNullParameter(str21, Address.KEY_STREET);
        Intrinsics.checkNotNullParameter(str22, "buildingNo");
        Intrinsics.checkNotNullParameter(str23, LogWriteConstants.FLOOR);
        Intrinsics.checkNotNullParameter(str24, BaseTestRunner.SUITE_METHODNAME);
        Intrinsics.checkNotNullParameter(str25, "extraDirections");
        Intrinsics.checkNotNullParameter(str26, HintConstants.AUTOFILL_HINT_PHONE_NUMBER);
        Intrinsics.checkNotNullParameter(str27, "countryCode");
        Intrinsics.checkNotNullParameter(str28, "mobileNumber");
        Intrinsics.checkNotNullParameter(str29, "grl");
        Intrinsics.checkNotNullParameter(str30, "grlId");
        this.profileId = str16;
        this.profileName = str17;
        this.areaId = j11;
        this.areaName = str18;
        this.type = i11;
        this.block = str19;
        this.judda = str20;
        this.street = str21;
        this.buildingNo = str22;
        this.floor = str23;
        this.suite = str24;
        this.extraDirections = str25;
        this.phoneNumber = str26;
        this.countryCode = str27;
        this.mobileNumber = str28;
        this.cityId = i12;
        this.isEligibleForDelivery = z11;
        this.isAreaDisabled = z12;
        this.country = i13;
        this.latitude = d11;
        this.longitude = d12;
        this.grl = str29;
        this.grlId = str30;
        this.error = error2;
    }

    public static /* synthetic */ UpdateAddressDto copy$default(UpdateAddressDto updateAddressDto, String str, String str2, long j11, String str3, int i11, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, int i12, boolean z11, boolean z12, int i13, double d11, double d12, String str14, String str15, Error error2, int i14, Object obj) {
        UpdateAddressDto updateAddressDto2 = updateAddressDto;
        int i15 = i14;
        return updateAddressDto.copy((i15 & 1) != 0 ? updateAddressDto2.profileId : str, (i15 & 2) != 0 ? updateAddressDto2.profileName : str2, (i15 & 4) != 0 ? updateAddressDto2.areaId : j11, (i15 & 8) != 0 ? updateAddressDto2.areaName : str3, (i15 & 16) != 0 ? updateAddressDto2.type : i11, (i15 & 32) != 0 ? updateAddressDto2.block : str4, (i15 & 64) != 0 ? updateAddressDto2.judda : str5, (i15 & 128) != 0 ? updateAddressDto2.street : str6, (i15 & 256) != 0 ? updateAddressDto2.buildingNo : str7, (i15 & 512) != 0 ? updateAddressDto2.floor : str8, (i15 & 1024) != 0 ? updateAddressDto2.suite : str9, (i15 & 2048) != 0 ? updateAddressDto2.extraDirections : str10, (i15 & 4096) != 0 ? updateAddressDto2.phoneNumber : str11, (i15 & 8192) != 0 ? updateAddressDto2.countryCode : str12, (i15 & 16384) != 0 ? updateAddressDto2.mobileNumber : str13, (i15 & 32768) != 0 ? updateAddressDto2.cityId : i12, (i15 & 65536) != 0 ? updateAddressDto2.isEligibleForDelivery : z11, (i15 & 131072) != 0 ? updateAddressDto2.isAreaDisabled : z12, (i15 & 262144) != 0 ? updateAddressDto2.country : i13, (i15 & 524288) != 0 ? updateAddressDto2.latitude : d11, (i15 & 1048576) != 0 ? updateAddressDto2.longitude : d12, (i15 & 2097152) != 0 ? updateAddressDto2.grl : str14, (4194304 & i15) != 0 ? updateAddressDto2.grlId : str15, (i15 & 8388608) != 0 ? updateAddressDto2.error : error2);
    }

    @NotNull
    public final String component1() {
        return this.profileId;
    }

    @NotNull
    public final String component10() {
        return this.floor;
    }

    @NotNull
    public final String component11() {
        return this.suite;
    }

    @NotNull
    public final String component12() {
        return this.extraDirections;
    }

    @NotNull
    public final String component13() {
        return this.phoneNumber;
    }

    @NotNull
    public final String component14() {
        return this.countryCode;
    }

    @NotNull
    public final String component15() {
        return this.mobileNumber;
    }

    public final int component16() {
        return this.cityId;
    }

    public final boolean component17() {
        return this.isEligibleForDelivery;
    }

    public final boolean component18() {
        return this.isAreaDisabled;
    }

    public final int component19() {
        return this.country;
    }

    @NotNull
    public final String component2() {
        return this.profileName;
    }

    public final double component20() {
        return this.latitude;
    }

    public final double component21() {
        return this.longitude;
    }

    @NotNull
    public final String component22() {
        return this.grl;
    }

    @NotNull
    public final String component23() {
        return this.grlId;
    }

    @Nullable
    public final Error component24() {
        return this.error;
    }

    public final long component3() {
        return this.areaId;
    }

    @NotNull
    public final String component4() {
        return this.areaName;
    }

    public final int component5() {
        return this.type;
    }

    @NotNull
    public final String component6() {
        return this.block;
    }

    @NotNull
    public final String component7() {
        return this.judda;
    }

    @NotNull
    public final String component8() {
        return this.street;
    }

    @NotNull
    public final String component9() {
        return this.buildingNo;
    }

    @NotNull
    public final UpdateAddressDto copy(@NotNull String str, @NotNull String str2, long j11, @NotNull String str3, int i11, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9, @NotNull String str10, @NotNull String str11, @NotNull String str12, @NotNull String str13, int i12, boolean z11, boolean z12, int i13, double d11, double d12, @NotNull String str14, @NotNull String str15, @Nullable Error error2) {
        String str16 = str;
        Intrinsics.checkNotNullParameter(str16, "profileId");
        Intrinsics.checkNotNullParameter(str2, Profile.PROFILE_NAME);
        Intrinsics.checkNotNullParameter(str3, "areaName");
        Intrinsics.checkNotNullParameter(str4, "block");
        Intrinsics.checkNotNullParameter(str5, "judda");
        Intrinsics.checkNotNullParameter(str6, Address.KEY_STREET);
        Intrinsics.checkNotNullParameter(str7, "buildingNo");
        Intrinsics.checkNotNullParameter(str8, LogWriteConstants.FLOOR);
        Intrinsics.checkNotNullParameter(str9, BaseTestRunner.SUITE_METHODNAME);
        Intrinsics.checkNotNullParameter(str10, "extraDirections");
        Intrinsics.checkNotNullParameter(str11, HintConstants.AUTOFILL_HINT_PHONE_NUMBER);
        Intrinsics.checkNotNullParameter(str12, "countryCode");
        Intrinsics.checkNotNullParameter(str13, "mobileNumber");
        Intrinsics.checkNotNullParameter(str14, "grl");
        Intrinsics.checkNotNullParameter(str15, "grlId");
        return new UpdateAddressDto(str16, str2, j11, str3, i11, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, i12, z11, z12, i13, d11, d12, str14, str15, error2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UpdateAddressDto)) {
            return false;
        }
        UpdateAddressDto updateAddressDto = (UpdateAddressDto) obj;
        return Intrinsics.areEqual((Object) this.profileId, (Object) updateAddressDto.profileId) && Intrinsics.areEqual((Object) this.profileName, (Object) updateAddressDto.profileName) && this.areaId == updateAddressDto.areaId && Intrinsics.areEqual((Object) this.areaName, (Object) updateAddressDto.areaName) && this.type == updateAddressDto.type && Intrinsics.areEqual((Object) this.block, (Object) updateAddressDto.block) && Intrinsics.areEqual((Object) this.judda, (Object) updateAddressDto.judda) && Intrinsics.areEqual((Object) this.street, (Object) updateAddressDto.street) && Intrinsics.areEqual((Object) this.buildingNo, (Object) updateAddressDto.buildingNo) && Intrinsics.areEqual((Object) this.floor, (Object) updateAddressDto.floor) && Intrinsics.areEqual((Object) this.suite, (Object) updateAddressDto.suite) && Intrinsics.areEqual((Object) this.extraDirections, (Object) updateAddressDto.extraDirections) && Intrinsics.areEqual((Object) this.phoneNumber, (Object) updateAddressDto.phoneNumber) && Intrinsics.areEqual((Object) this.countryCode, (Object) updateAddressDto.countryCode) && Intrinsics.areEqual((Object) this.mobileNumber, (Object) updateAddressDto.mobileNumber) && this.cityId == updateAddressDto.cityId && this.isEligibleForDelivery == updateAddressDto.isEligibleForDelivery && this.isAreaDisabled == updateAddressDto.isAreaDisabled && this.country == updateAddressDto.country && Intrinsics.areEqual((Object) Double.valueOf(this.latitude), (Object) Double.valueOf(updateAddressDto.latitude)) && Intrinsics.areEqual((Object) Double.valueOf(this.longitude), (Object) Double.valueOf(updateAddressDto.longitude)) && Intrinsics.areEqual((Object) this.grl, (Object) updateAddressDto.grl) && Intrinsics.areEqual((Object) this.grlId, (Object) updateAddressDto.grlId) && Intrinsics.areEqual((Object) this.error, (Object) updateAddressDto.error);
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

    @Nullable
    public final Error getError() {
        return this.error;
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
    public final String getProfileId() {
        return this.profileId;
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
        int hashCode = ((((((((((((((((((((((((((((((this.profileId.hashCode() * 31) + this.profileName.hashCode()) * 31) + a.a(this.areaId)) * 31) + this.areaName.hashCode()) * 31) + this.type) * 31) + this.block.hashCode()) * 31) + this.judda.hashCode()) * 31) + this.street.hashCode()) * 31) + this.buildingNo.hashCode()) * 31) + this.floor.hashCode()) * 31) + this.suite.hashCode()) * 31) + this.extraDirections.hashCode()) * 31) + this.phoneNumber.hashCode()) * 31) + this.countryCode.hashCode()) * 31) + this.mobileNumber.hashCode()) * 31) + this.cityId) * 31;
        boolean z11 = this.isEligibleForDelivery;
        boolean z12 = true;
        if (z11) {
            z11 = true;
        }
        int i11 = (hashCode + (z11 ? 1 : 0)) * 31;
        boolean z13 = this.isAreaDisabled;
        if (!z13) {
            z12 = z13;
        }
        int a11 = (((((((((((i11 + (z12 ? 1 : 0)) * 31) + this.country) * 31) + Double.doubleToLongBits(this.latitude)) * 31) + Double.doubleToLongBits(this.longitude)) * 31) + this.grl.hashCode()) * 31) + this.grlId.hashCode()) * 31;
        Error error2 = this.error;
        return a11 + (error2 == null ? 0 : error2.hashCode());
    }

    public final boolean isAreaDisabled() {
        return this.isAreaDisabled;
    }

    public final boolean isEligibleForDelivery() {
        return this.isEligibleForDelivery;
    }

    @NotNull
    public String toString() {
        String str = this.profileId;
        String str2 = this.profileName;
        long j11 = this.areaId;
        String str3 = this.areaName;
        int i11 = this.type;
        String str4 = this.block;
        String str5 = this.judda;
        String str6 = this.street;
        String str7 = this.buildingNo;
        String str8 = this.floor;
        String str9 = this.suite;
        String str10 = this.extraDirections;
        String str11 = this.phoneNumber;
        String str12 = this.countryCode;
        String str13 = this.mobileNumber;
        int i12 = this.cityId;
        boolean z11 = this.isEligibleForDelivery;
        boolean z12 = this.isAreaDisabled;
        String str14 = str11;
        int i13 = this.country;
        double d11 = this.latitude;
        double d12 = this.longitude;
        String str15 = this.grl;
        String str16 = this.grlId;
        Error error2 = this.error;
        return "UpdateAddressDto(profileId=" + str + ", profileName=" + str2 + ", areaId=" + j11 + ", areaName=" + str3 + ", type=" + i11 + ", block=" + str4 + ", judda=" + str5 + ", street=" + str6 + ", buildingNo=" + str7 + ", floor=" + str8 + ", suite=" + str9 + ", extraDirections=" + str10 + ", phoneNumber=" + str14 + ", countryCode=" + str12 + ", mobileNumber=" + str13 + ", cityId=" + i12 + ", isEligibleForDelivery=" + z11 + ", isAreaDisabled=" + z12 + ", country=" + i13 + ", latitude=" + d11 + ", longitude=" + d12 + ", grl=" + str15 + ", grlId=" + str16 + ", error=" + error2 + ")";
    }
}
