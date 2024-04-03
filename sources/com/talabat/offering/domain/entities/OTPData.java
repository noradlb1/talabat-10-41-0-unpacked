package com.talabat.offering.domain.entities;

import com.talabat.mapper.ModelMapping;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0019\b\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003JJ\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\tHÖ\u0001J\t\u0010!\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0006\u0010\u0011R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010¨\u0006\""}, d2 = {"Lcom/talabat/offering/domain/entities/OTPData;", "", "duration", "", "errorsMsg", "", "isSuccess", "", "otpLength", "", "requestId", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;)V", "getDuration", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getErrorsMsg", "()Ljava/lang/String;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getOtpLength", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getRequestId", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;)Lcom/talabat/offering/domain/entities/OTPData;", "equals", "other", "hashCode", "toString", "com_talabat_NewArchi_Offering_Offering"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OTPData {
    @ModelMapping({"duration"})
    @Nullable
    private final Long duration;
    @ModelMapping({"errors"})
    @Nullable
    private final String errorsMsg;
    @ModelMapping({"isSuccess"})
    @Nullable
    private final Boolean isSuccess;
    @ModelMapping({"otpLength"})
    @Nullable
    private final Integer otpLength;
    @ModelMapping({"requestId"})
    @Nullable
    private final String requestId;

    public OTPData() {
        this((Long) null, (String) null, (Boolean) null, (Integer) null, (String) null, 31, (DefaultConstructorMarker) null);
    }

    public OTPData(@Nullable Long l11, @Nullable String str, @Nullable Boolean bool, @Nullable Integer num, @Nullable String str2) {
        this.duration = l11;
        this.errorsMsg = str;
        this.isSuccess = bool;
        this.otpLength = num;
        this.requestId = str2;
    }

    public static /* synthetic */ OTPData copy$default(OTPData oTPData, Long l11, String str, Boolean bool, Integer num, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            l11 = oTPData.duration;
        }
        if ((i11 & 2) != 0) {
            str = oTPData.errorsMsg;
        }
        String str3 = str;
        if ((i11 & 4) != 0) {
            bool = oTPData.isSuccess;
        }
        Boolean bool2 = bool;
        if ((i11 & 8) != 0) {
            num = oTPData.otpLength;
        }
        Integer num2 = num;
        if ((i11 & 16) != 0) {
            str2 = oTPData.requestId;
        }
        return oTPData.copy(l11, str3, bool2, num2, str2);
    }

    @Nullable
    public final Long component1() {
        return this.duration;
    }

    @Nullable
    public final String component2() {
        return this.errorsMsg;
    }

    @Nullable
    public final Boolean component3() {
        return this.isSuccess;
    }

    @Nullable
    public final Integer component4() {
        return this.otpLength;
    }

    @Nullable
    public final String component5() {
        return this.requestId;
    }

    @NotNull
    public final OTPData copy(@Nullable Long l11, @Nullable String str, @Nullable Boolean bool, @Nullable Integer num, @Nullable String str2) {
        return new OTPData(l11, str, bool, num, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OTPData)) {
            return false;
        }
        OTPData oTPData = (OTPData) obj;
        return Intrinsics.areEqual((Object) this.duration, (Object) oTPData.duration) && Intrinsics.areEqual((Object) this.errorsMsg, (Object) oTPData.errorsMsg) && Intrinsics.areEqual((Object) this.isSuccess, (Object) oTPData.isSuccess) && Intrinsics.areEqual((Object) this.otpLength, (Object) oTPData.otpLength) && Intrinsics.areEqual((Object) this.requestId, (Object) oTPData.requestId);
    }

    @Nullable
    public final Long getDuration() {
        return this.duration;
    }

    @Nullable
    public final String getErrorsMsg() {
        return this.errorsMsg;
    }

    @Nullable
    public final Integer getOtpLength() {
        return this.otpLength;
    }

    @Nullable
    public final String getRequestId() {
        return this.requestId;
    }

    public int hashCode() {
        Long l11 = this.duration;
        int i11 = 0;
        int hashCode = (l11 == null ? 0 : l11.hashCode()) * 31;
        String str = this.errorsMsg;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool = this.isSuccess;
        int hashCode3 = (hashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        Integer num = this.otpLength;
        int hashCode4 = (hashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.requestId;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return hashCode4 + i11;
    }

    @Nullable
    public final Boolean isSuccess() {
        return this.isSuccess;
    }

    @NotNull
    public String toString() {
        Long l11 = this.duration;
        String str = this.errorsMsg;
        Boolean bool = this.isSuccess;
        Integer num = this.otpLength;
        String str2 = this.requestId;
        return "OTPData(duration=" + l11 + ", errorsMsg=" + str + ", isSuccess=" + bool + ", otpLength=" + num + ", requestId=" + str2 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ OTPData(java.lang.Long r5, java.lang.String r6, java.lang.Boolean r7, java.lang.Integer r8, java.lang.String r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.offering.domain.entities.OTPData.<init>(java.lang.Long, java.lang.String, java.lang.Boolean, java.lang.Integer, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
