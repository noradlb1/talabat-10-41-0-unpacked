package com.talabat.riderinfo.data.dto;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\f¨\u0006!"}, d2 = {"Lcom/talabat/riderinfo/data/dto/RiderInfoDto;", "", "channelId", "", "customerId", "sessionToken", "riderPhone", "riderName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getChannelId", "()Ljava/lang/String;", "setChannelId", "(Ljava/lang/String;)V", "getCustomerId", "setCustomerId", "getRiderName", "setRiderName", "getRiderPhone", "setRiderPhone", "getSessionToken", "setSessionToken", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_RiderInfo_RiderInfo"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RiderInfoDto {
    @SerializedName("channel")
    @Nullable
    private String channelId;
    @SerializedName("customer_id")
    @Nullable
    private String customerId;
    @SerializedName("rider_name")
    @Nullable
    private String riderName;
    @SerializedName("rider_phone")
    @Nullable
    private String riderPhone;
    @SerializedName("session_token")
    @Nullable
    private String sessionToken;

    public RiderInfoDto() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, 31, (DefaultConstructorMarker) null);
    }

    public RiderInfoDto(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        this.channelId = str;
        this.customerId = str2;
        this.sessionToken = str3;
        this.riderPhone = str4;
        this.riderName = str5;
    }

    public static /* synthetic */ RiderInfoDto copy$default(RiderInfoDto riderInfoDto, String str, String str2, String str3, String str4, String str5, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = riderInfoDto.channelId;
        }
        if ((i11 & 2) != 0) {
            str2 = riderInfoDto.customerId;
        }
        String str6 = str2;
        if ((i11 & 4) != 0) {
            str3 = riderInfoDto.sessionToken;
        }
        String str7 = str3;
        if ((i11 & 8) != 0) {
            str4 = riderInfoDto.riderPhone;
        }
        String str8 = str4;
        if ((i11 & 16) != 0) {
            str5 = riderInfoDto.riderName;
        }
        return riderInfoDto.copy(str, str6, str7, str8, str5);
    }

    @Nullable
    public final String component1() {
        return this.channelId;
    }

    @Nullable
    public final String component2() {
        return this.customerId;
    }

    @Nullable
    public final String component3() {
        return this.sessionToken;
    }

    @Nullable
    public final String component4() {
        return this.riderPhone;
    }

    @Nullable
    public final String component5() {
        return this.riderName;
    }

    @NotNull
    public final RiderInfoDto copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        return new RiderInfoDto(str, str2, str3, str4, str5);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RiderInfoDto)) {
            return false;
        }
        RiderInfoDto riderInfoDto = (RiderInfoDto) obj;
        return Intrinsics.areEqual((Object) this.channelId, (Object) riderInfoDto.channelId) && Intrinsics.areEqual((Object) this.customerId, (Object) riderInfoDto.customerId) && Intrinsics.areEqual((Object) this.sessionToken, (Object) riderInfoDto.sessionToken) && Intrinsics.areEqual((Object) this.riderPhone, (Object) riderInfoDto.riderPhone) && Intrinsics.areEqual((Object) this.riderName, (Object) riderInfoDto.riderName);
    }

    @Nullable
    public final String getChannelId() {
        return this.channelId;
    }

    @Nullable
    public final String getCustomerId() {
        return this.customerId;
    }

    @Nullable
    public final String getRiderName() {
        return this.riderName;
    }

    @Nullable
    public final String getRiderPhone() {
        return this.riderPhone;
    }

    @Nullable
    public final String getSessionToken() {
        return this.sessionToken;
    }

    public int hashCode() {
        String str = this.channelId;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.customerId;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.sessionToken;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.riderPhone;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.riderName;
        if (str5 != null) {
            i11 = str5.hashCode();
        }
        return hashCode4 + i11;
    }

    public final void setChannelId(@Nullable String str) {
        this.channelId = str;
    }

    public final void setCustomerId(@Nullable String str) {
        this.customerId = str;
    }

    public final void setRiderName(@Nullable String str) {
        this.riderName = str;
    }

    public final void setRiderPhone(@Nullable String str) {
        this.riderPhone = str;
    }

    public final void setSessionToken(@Nullable String str) {
        this.sessionToken = str;
    }

    @NotNull
    public String toString() {
        String str = this.channelId;
        String str2 = this.customerId;
        String str3 = this.sessionToken;
        String str4 = this.riderPhone;
        String str5 = this.riderName;
        return "RiderInfoDto(channelId=" + str + ", customerId=" + str2 + ", sessionToken=" + str3 + ", riderPhone=" + str4 + ", riderName=" + str5 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ RiderInfoDto(java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.riderinfo.data.dto.RiderInfoDto.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
