package com.talabat.fluttercore.domain.entities;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b@\b\b\u0018\u00002\u00020\u0001B×\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0014\u001a\u00020\t\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0019\u001a\u00020\t\u0012\b\b\u0002\u0010\u001a\u001a\u00020\t\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u001cJ\t\u0010;\u001a\u00020\u0003HÆ\u0003J\u0010\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\u0010\u0010=\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u00105J\u000b\u0010>\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010A\u001a\u00020\tHÆ\u0003J\t\u0010B\u001a\u00020\u0016HÆ\u0003J\u0010\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\u000b\u0010D\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010E\u001a\u00020\tHÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010G\u001a\u00020\tHÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010K\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010 J\u000b\u0010L\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010N\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\u000b\u0010O\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0002\u0010P\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0014\u001a\u00020\t2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0019\u001a\u00020\t2\b\b\u0002\u0010\u001a\u001a\u00020\t2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010QJ\u0013\u0010R\u001a\u00020\t2\b\u0010S\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010T\u001a\u00020\u0003HÖ\u0001J\t\u0010U\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001eR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001eR\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001eR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0014\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010,R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001eR\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001eR\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b1\u0010#R\u0011\u0010\u0019\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b2\u0010,R\u0011\u0010\u001a\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b3\u0010,R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u00106\u001a\u0004\b4\u00105R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b7\u0010#R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\u001eR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u001eR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u001e¨\u0006V"}, d2 = {"Lcom/talabat/fluttercore/domain/entities/FlutterCustomerInfo;", "", "id", "", "firstName", "", "lastName", "email", "blocked", "", "housePhone", "workPhone", "tokenProvider", "birthDate", "countryId", "talabatCredit", "", "userName", "userId", "encgid", "isTproUser", "minimOrderValueToEnableTproDiscount", "", "registrationType", "gender", "subscribedToNewsletter", "subscribedToSMS", "mobileNumber", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZFLjava/lang/Integer;Ljava/lang/String;ZZLjava/lang/String;)V", "getBirthDate", "()Ljava/lang/String;", "getBlocked", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCountryId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getEmail", "getEncgid", "getFirstName", "getGender", "getHousePhone", "getId", "()I", "()Z", "getLastName", "getMinimOrderValueToEnableTproDiscount", "()F", "getMobileNumber", "getRegistrationType", "getSubscribedToNewsletter", "getSubscribedToSMS", "getTalabatCredit", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getTokenProvider", "getUserId", "getUserName", "getWorkPhone", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZFLjava/lang/Integer;Ljava/lang/String;ZZLjava/lang/String;)Lcom/talabat/fluttercore/domain/entities/FlutterCustomerInfo;", "equals", "other", "hashCode", "toString", "com_talabat_NewArchi_TalabatFlutterCore_TalabatFlutterCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FlutterCustomerInfo {
    @Nullable
    private final String birthDate;
    @Nullable
    private final Boolean blocked;
    @Nullable
    private final Integer countryId;
    @Nullable
    private final String email;
    @Nullable
    private final String encgid;
    @Nullable
    private final String firstName;
    @Nullable
    private final String gender;
    @Nullable
    private final String housePhone;

    /* renamed from: id  reason: collision with root package name */
    private final int f59771id;
    private final boolean isTproUser;
    @Nullable
    private final String lastName;
    private final float minimOrderValueToEnableTproDiscount;
    @Nullable
    private final String mobileNumber;
    @Nullable
    private final Integer registrationType;
    private final boolean subscribedToNewsletter;
    private final boolean subscribedToSMS;
    @Nullable
    private final Double talabatCredit;
    @Nullable
    private final Integer tokenProvider;
    @Nullable
    private final String userId;
    @Nullable
    private final String userName;
    @Nullable
    private final String workPhone;

    public FlutterCustomerInfo(int i11, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Boolean bool, @Nullable String str4, @Nullable String str5, @Nullable Integer num, @Nullable String str6, @Nullable Integer num2, @Nullable Double d11, @Nullable String str7, @Nullable String str8, @Nullable String str9, boolean z11, float f11, @Nullable Integer num3, @Nullable String str10, boolean z12, boolean z13, @Nullable String str11) {
        this.f59771id = i11;
        this.firstName = str;
        this.lastName = str2;
        this.email = str3;
        this.blocked = bool;
        this.housePhone = str4;
        this.workPhone = str5;
        this.tokenProvider = num;
        this.birthDate = str6;
        this.countryId = num2;
        this.talabatCredit = d11;
        this.userName = str7;
        this.userId = str8;
        this.encgid = str9;
        this.isTproUser = z11;
        this.minimOrderValueToEnableTproDiscount = f11;
        this.registrationType = num3;
        this.gender = str10;
        this.subscribedToNewsletter = z12;
        this.subscribedToSMS = z13;
        this.mobileNumber = str11;
    }

    public static /* synthetic */ FlutterCustomerInfo copy$default(FlutterCustomerInfo flutterCustomerInfo, int i11, String str, String str2, String str3, Boolean bool, String str4, String str5, Integer num, String str6, Integer num2, Double d11, String str7, String str8, String str9, boolean z11, float f11, Integer num3, String str10, boolean z12, boolean z13, String str11, int i12, Object obj) {
        FlutterCustomerInfo flutterCustomerInfo2 = flutterCustomerInfo;
        int i13 = i12;
        return flutterCustomerInfo.copy((i13 & 1) != 0 ? flutterCustomerInfo2.f59771id : i11, (i13 & 2) != 0 ? flutterCustomerInfo2.firstName : str, (i13 & 4) != 0 ? flutterCustomerInfo2.lastName : str2, (i13 & 8) != 0 ? flutterCustomerInfo2.email : str3, (i13 & 16) != 0 ? flutterCustomerInfo2.blocked : bool, (i13 & 32) != 0 ? flutterCustomerInfo2.housePhone : str4, (i13 & 64) != 0 ? flutterCustomerInfo2.workPhone : str5, (i13 & 128) != 0 ? flutterCustomerInfo2.tokenProvider : num, (i13 & 256) != 0 ? flutterCustomerInfo2.birthDate : str6, (i13 & 512) != 0 ? flutterCustomerInfo2.countryId : num2, (i13 & 1024) != 0 ? flutterCustomerInfo2.talabatCredit : d11, (i13 & 2048) != 0 ? flutterCustomerInfo2.userName : str7, (i13 & 4096) != 0 ? flutterCustomerInfo2.userId : str8, (i13 & 8192) != 0 ? flutterCustomerInfo2.encgid : str9, (i13 & 16384) != 0 ? flutterCustomerInfo2.isTproUser : z11, (i13 & 32768) != 0 ? flutterCustomerInfo2.minimOrderValueToEnableTproDiscount : f11, (i13 & 65536) != 0 ? flutterCustomerInfo2.registrationType : num3, (i13 & 131072) != 0 ? flutterCustomerInfo2.gender : str10, (i13 & 262144) != 0 ? flutterCustomerInfo2.subscribedToNewsletter : z12, (i13 & 524288) != 0 ? flutterCustomerInfo2.subscribedToSMS : z13, (i13 & 1048576) != 0 ? flutterCustomerInfo2.mobileNumber : str11);
    }

    public final int component1() {
        return this.f59771id;
    }

    @Nullable
    public final Integer component10() {
        return this.countryId;
    }

    @Nullable
    public final Double component11() {
        return this.talabatCredit;
    }

    @Nullable
    public final String component12() {
        return this.userName;
    }

    @Nullable
    public final String component13() {
        return this.userId;
    }

    @Nullable
    public final String component14() {
        return this.encgid;
    }

    public final boolean component15() {
        return this.isTproUser;
    }

    public final float component16() {
        return this.minimOrderValueToEnableTproDiscount;
    }

    @Nullable
    public final Integer component17() {
        return this.registrationType;
    }

    @Nullable
    public final String component18() {
        return this.gender;
    }

    public final boolean component19() {
        return this.subscribedToNewsletter;
    }

    @Nullable
    public final String component2() {
        return this.firstName;
    }

    public final boolean component20() {
        return this.subscribedToSMS;
    }

    @Nullable
    public final String component21() {
        return this.mobileNumber;
    }

    @Nullable
    public final String component3() {
        return this.lastName;
    }

    @Nullable
    public final String component4() {
        return this.email;
    }

    @Nullable
    public final Boolean component5() {
        return this.blocked;
    }

    @Nullable
    public final String component6() {
        return this.housePhone;
    }

    @Nullable
    public final String component7() {
        return this.workPhone;
    }

    @Nullable
    public final Integer component8() {
        return this.tokenProvider;
    }

    @Nullable
    public final String component9() {
        return this.birthDate;
    }

    @NotNull
    public final FlutterCustomerInfo copy(int i11, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Boolean bool, @Nullable String str4, @Nullable String str5, @Nullable Integer num, @Nullable String str6, @Nullable Integer num2, @Nullable Double d11, @Nullable String str7, @Nullable String str8, @Nullable String str9, boolean z11, float f11, @Nullable Integer num3, @Nullable String str10, boolean z12, boolean z13, @Nullable String str11) {
        return new FlutterCustomerInfo(i11, str, str2, str3, bool, str4, str5, num, str6, num2, d11, str7, str8, str9, z11, f11, num3, str10, z12, z13, str11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FlutterCustomerInfo)) {
            return false;
        }
        FlutterCustomerInfo flutterCustomerInfo = (FlutterCustomerInfo) obj;
        return this.f59771id == flutterCustomerInfo.f59771id && Intrinsics.areEqual((Object) this.firstName, (Object) flutterCustomerInfo.firstName) && Intrinsics.areEqual((Object) this.lastName, (Object) flutterCustomerInfo.lastName) && Intrinsics.areEqual((Object) this.email, (Object) flutterCustomerInfo.email) && Intrinsics.areEqual((Object) this.blocked, (Object) flutterCustomerInfo.blocked) && Intrinsics.areEqual((Object) this.housePhone, (Object) flutterCustomerInfo.housePhone) && Intrinsics.areEqual((Object) this.workPhone, (Object) flutterCustomerInfo.workPhone) && Intrinsics.areEqual((Object) this.tokenProvider, (Object) flutterCustomerInfo.tokenProvider) && Intrinsics.areEqual((Object) this.birthDate, (Object) flutterCustomerInfo.birthDate) && Intrinsics.areEqual((Object) this.countryId, (Object) flutterCustomerInfo.countryId) && Intrinsics.areEqual((Object) this.talabatCredit, (Object) flutterCustomerInfo.talabatCredit) && Intrinsics.areEqual((Object) this.userName, (Object) flutterCustomerInfo.userName) && Intrinsics.areEqual((Object) this.userId, (Object) flutterCustomerInfo.userId) && Intrinsics.areEqual((Object) this.encgid, (Object) flutterCustomerInfo.encgid) && this.isTproUser == flutterCustomerInfo.isTproUser && Intrinsics.areEqual((Object) Float.valueOf(this.minimOrderValueToEnableTproDiscount), (Object) Float.valueOf(flutterCustomerInfo.minimOrderValueToEnableTproDiscount)) && Intrinsics.areEqual((Object) this.registrationType, (Object) flutterCustomerInfo.registrationType) && Intrinsics.areEqual((Object) this.gender, (Object) flutterCustomerInfo.gender) && this.subscribedToNewsletter == flutterCustomerInfo.subscribedToNewsletter && this.subscribedToSMS == flutterCustomerInfo.subscribedToSMS && Intrinsics.areEqual((Object) this.mobileNumber, (Object) flutterCustomerInfo.mobileNumber);
    }

    @Nullable
    public final String getBirthDate() {
        return this.birthDate;
    }

    @Nullable
    public final Boolean getBlocked() {
        return this.blocked;
    }

    @Nullable
    public final Integer getCountryId() {
        return this.countryId;
    }

    @Nullable
    public final String getEmail() {
        return this.email;
    }

    @Nullable
    public final String getEncgid() {
        return this.encgid;
    }

    @Nullable
    public final String getFirstName() {
        return this.firstName;
    }

    @Nullable
    public final String getGender() {
        return this.gender;
    }

    @Nullable
    public final String getHousePhone() {
        return this.housePhone;
    }

    public final int getId() {
        return this.f59771id;
    }

    @Nullable
    public final String getLastName() {
        return this.lastName;
    }

    public final float getMinimOrderValueToEnableTproDiscount() {
        return this.minimOrderValueToEnableTproDiscount;
    }

    @Nullable
    public final String getMobileNumber() {
        return this.mobileNumber;
    }

    @Nullable
    public final Integer getRegistrationType() {
        return this.registrationType;
    }

    public final boolean getSubscribedToNewsletter() {
        return this.subscribedToNewsletter;
    }

    public final boolean getSubscribedToSMS() {
        return this.subscribedToSMS;
    }

    @Nullable
    public final Double getTalabatCredit() {
        return this.talabatCredit;
    }

    @Nullable
    public final Integer getTokenProvider() {
        return this.tokenProvider;
    }

    @Nullable
    public final String getUserId() {
        return this.userId;
    }

    @Nullable
    public final String getUserName() {
        return this.userName;
    }

    @Nullable
    public final String getWorkPhone() {
        return this.workPhone;
    }

    public int hashCode() {
        int i11 = this.f59771id * 31;
        String str = this.firstName;
        int i12 = 0;
        int hashCode = (i11 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.lastName;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.email;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Boolean bool = this.blocked;
        int hashCode4 = (hashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str4 = this.housePhone;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.workPhone;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Integer num = this.tokenProvider;
        int hashCode7 = (hashCode6 + (num == null ? 0 : num.hashCode())) * 31;
        String str6 = this.birthDate;
        int hashCode8 = (hashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Integer num2 = this.countryId;
        int hashCode9 = (hashCode8 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Double d11 = this.talabatCredit;
        int hashCode10 = (hashCode9 + (d11 == null ? 0 : d11.hashCode())) * 31;
        String str7 = this.userName;
        int hashCode11 = (hashCode10 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.userId;
        int hashCode12 = (hashCode11 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.encgid;
        int hashCode13 = (hashCode12 + (str9 == null ? 0 : str9.hashCode())) * 31;
        boolean z11 = this.isTproUser;
        boolean z12 = true;
        if (z11) {
            z11 = true;
        }
        int floatToIntBits = (((hashCode13 + (z11 ? 1 : 0)) * 31) + Float.floatToIntBits(this.minimOrderValueToEnableTproDiscount)) * 31;
        Integer num3 = this.registrationType;
        int hashCode14 = (floatToIntBits + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str10 = this.gender;
        int hashCode15 = (hashCode14 + (str10 == null ? 0 : str10.hashCode())) * 31;
        boolean z13 = this.subscribedToNewsletter;
        if (z13) {
            z13 = true;
        }
        int i13 = (hashCode15 + (z13 ? 1 : 0)) * 31;
        boolean z14 = this.subscribedToSMS;
        if (!z14) {
            z12 = z14;
        }
        int i14 = (i13 + (z12 ? 1 : 0)) * 31;
        String str11 = this.mobileNumber;
        if (str11 != null) {
            i12 = str11.hashCode();
        }
        return i14 + i12;
    }

    public final boolean isTproUser() {
        return this.isTproUser;
    }

    @NotNull
    public String toString() {
        int i11 = this.f59771id;
        String str = this.firstName;
        String str2 = this.lastName;
        String str3 = this.email;
        Boolean bool = this.blocked;
        String str4 = this.housePhone;
        String str5 = this.workPhone;
        Integer num = this.tokenProvider;
        String str6 = this.birthDate;
        Integer num2 = this.countryId;
        Double d11 = this.talabatCredit;
        String str7 = this.userName;
        String str8 = this.userId;
        String str9 = this.encgid;
        boolean z11 = this.isTproUser;
        float f11 = this.minimOrderValueToEnableTproDiscount;
        Integer num3 = this.registrationType;
        String str10 = this.gender;
        boolean z12 = this.subscribedToNewsletter;
        boolean z13 = this.subscribedToSMS;
        String str11 = this.mobileNumber;
        return "FlutterCustomerInfo(id=" + i11 + ", firstName=" + str + ", lastName=" + str2 + ", email=" + str3 + ", blocked=" + bool + ", housePhone=" + str4 + ", workPhone=" + str5 + ", tokenProvider=" + num + ", birthDate=" + str6 + ", countryId=" + num2 + ", talabatCredit=" + d11 + ", userName=" + str7 + ", userId=" + str8 + ", encgid=" + str9 + ", isTproUser=" + z11 + ", minimOrderValueToEnableTproDiscount=" + f11 + ", registrationType=" + num3 + ", gender=" + str10 + ", subscribedToNewsletter=" + z12 + ", subscribedToSMS=" + z13 + ", mobileNumber=" + str11 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ FlutterCustomerInfo(int r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, java.lang.Boolean r30, java.lang.String r31, java.lang.String r32, java.lang.Integer r33, java.lang.String r34, java.lang.Integer r35, java.lang.Double r36, java.lang.String r37, java.lang.String r38, java.lang.String r39, boolean r40, float r41, java.lang.Integer r42, java.lang.String r43, boolean r44, boolean r45, java.lang.String r46, int r47, kotlin.jvm.internal.DefaultConstructorMarker r48) {
        /*
            r25 = this;
            r0 = r47
            r1 = r0 & 16384(0x4000, float:2.2959E-41)
            r2 = 0
            if (r1 == 0) goto L_0x000a
            r18 = r2
            goto L_0x000c
        L_0x000a:
            r18 = r40
        L_0x000c:
            r1 = 32768(0x8000, float:4.5918E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0016
            r1 = 0
            r19 = r1
            goto L_0x0018
        L_0x0016:
            r19 = r41
        L_0x0018:
            r1 = 262144(0x40000, float:3.67342E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0020
            r22 = r2
            goto L_0x0022
        L_0x0020:
            r22 = r44
        L_0x0022:
            r1 = 524288(0x80000, float:7.34684E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x002a
            r23 = r2
            goto L_0x002c
        L_0x002a:
            r23 = r45
        L_0x002c:
            r1 = 1048576(0x100000, float:1.469368E-39)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x0036
            java.lang.String r0 = ""
            r24 = r0
            goto L_0x0038
        L_0x0036:
            r24 = r46
        L_0x0038:
            r3 = r25
            r4 = r26
            r5 = r27
            r6 = r28
            r7 = r29
            r8 = r30
            r9 = r31
            r10 = r32
            r11 = r33
            r12 = r34
            r13 = r35
            r14 = r36
            r15 = r37
            r16 = r38
            r17 = r39
            r20 = r42
            r21 = r43
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.fluttercore.domain.entities.FlutterCustomerInfo.<init>(int, java.lang.String, java.lang.String, java.lang.String, java.lang.Boolean, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.lang.Integer, java.lang.Double, java.lang.String, java.lang.String, java.lang.String, boolean, float, java.lang.Integer, java.lang.String, boolean, boolean, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
