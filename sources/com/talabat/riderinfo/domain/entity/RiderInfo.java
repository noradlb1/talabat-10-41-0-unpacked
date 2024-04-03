package com.talabat.riderinfo.domain.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/talabat/riderinfo/domain/entity/RiderInfo;", "", "channel", "", "customerId", "sessionToken", "riderPhoneNumber", "riderName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getChannel", "()Ljava/lang/String;", "getCustomerId", "getRiderName", "getRiderPhoneNumber", "getSessionToken", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_RiderInfo_RiderInfo"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RiderInfo {
    @Nullable
    private final String channel;
    @Nullable
    private final String customerId;
    @Nullable
    private final String riderName;
    @Nullable
    private final String riderPhoneNumber;
    @Nullable
    private final String sessionToken;

    public RiderInfo() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, 31, (DefaultConstructorMarker) null);
    }

    public RiderInfo(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        this.channel = str;
        this.customerId = str2;
        this.sessionToken = str3;
        this.riderPhoneNumber = str4;
        this.riderName = str5;
    }

    public static /* synthetic */ RiderInfo copy$default(RiderInfo riderInfo, String str, String str2, String str3, String str4, String str5, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = riderInfo.channel;
        }
        if ((i11 & 2) != 0) {
            str2 = riderInfo.customerId;
        }
        String str6 = str2;
        if ((i11 & 4) != 0) {
            str3 = riderInfo.sessionToken;
        }
        String str7 = str3;
        if ((i11 & 8) != 0) {
            str4 = riderInfo.riderPhoneNumber;
        }
        String str8 = str4;
        if ((i11 & 16) != 0) {
            str5 = riderInfo.riderName;
        }
        return riderInfo.copy(str, str6, str7, str8, str5);
    }

    @Nullable
    public final String component1() {
        return this.channel;
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
        return this.riderPhoneNumber;
    }

    @Nullable
    public final String component5() {
        return this.riderName;
    }

    @NotNull
    public final RiderInfo copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        return new RiderInfo(str, str2, str3, str4, str5);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RiderInfo)) {
            return false;
        }
        RiderInfo riderInfo = (RiderInfo) obj;
        return Intrinsics.areEqual((Object) this.channel, (Object) riderInfo.channel) && Intrinsics.areEqual((Object) this.customerId, (Object) riderInfo.customerId) && Intrinsics.areEqual((Object) this.sessionToken, (Object) riderInfo.sessionToken) && Intrinsics.areEqual((Object) this.riderPhoneNumber, (Object) riderInfo.riderPhoneNumber) && Intrinsics.areEqual((Object) this.riderName, (Object) riderInfo.riderName);
    }

    @Nullable
    public final String getChannel() {
        return this.channel;
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
    public final String getRiderPhoneNumber() {
        return this.riderPhoneNumber;
    }

    @Nullable
    public final String getSessionToken() {
        return this.sessionToken;
    }

    public int hashCode() {
        String str = this.channel;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.customerId;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.sessionToken;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.riderPhoneNumber;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.riderName;
        if (str5 != null) {
            i11 = str5.hashCode();
        }
        return hashCode4 + i11;
    }

    @NotNull
    public String toString() {
        String str = this.channel;
        String str2 = this.customerId;
        String str3 = this.sessionToken;
        String str4 = this.riderPhoneNumber;
        String str5 = this.riderName;
        return "RiderInfo(channel=" + str + ", customerId=" + str2 + ", sessionToken=" + str3 + ", riderPhoneNumber=" + str4 + ", riderName=" + str5 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ RiderInfo(java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.riderinfo.domain.entity.RiderInfo.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
