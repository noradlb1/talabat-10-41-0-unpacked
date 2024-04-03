package com.deliveryhero.customerchat.eventTracking.data;

import com.deliveryhero.customerchat.telephony.domain.voipAnalytics.CallRegistrationStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b!\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\fHÆ\u0003J\u0001\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010,J\u0013\u0010-\u001a\u00020\u000e2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u000200HÖ\u0001J\t\u00101\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0015¨\u00062"}, d2 = {"Lcom/deliveryhero/customerchat/eventTracking/data/CallMetadata;", "", "callID", "", "duration", "receiverUserID", "receiverType", "source", "errorMessage", "endCallReason", "buttonToggleState", "registrationStatus", "Lcom/deliveryhero/customerchat/telephony/domain/voipAnalytics/CallRegistrationStatus;", "buttonState", "", "provider", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/deliveryhero/customerchat/telephony/domain/voipAnalytics/CallRegistrationStatus;Ljava/lang/Boolean;Ljava/lang/String;)V", "getButtonState", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getButtonToggleState", "()Ljava/lang/String;", "getCallID", "getDuration", "getEndCallReason", "getErrorMessage", "getProvider", "getReceiverType", "getReceiverUserID", "getRegistrationStatus", "()Lcom/deliveryhero/customerchat/telephony/domain/voipAnalytics/CallRegistrationStatus;", "getSource", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/deliveryhero/customerchat/telephony/domain/voipAnalytics/CallRegistrationStatus;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/deliveryhero/customerchat/eventTracking/data/CallMetadata;", "equals", "other", "hashCode", "", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CallMetadata {
    @Nullable
    private final Boolean buttonState;
    @Nullable
    private final String buttonToggleState;
    @Nullable
    private final String callID;
    @Nullable
    private final String duration;
    @Nullable
    private final String endCallReason;
    @Nullable
    private final String errorMessage;
    @Nullable
    private final String provider;
    @Nullable
    private final String receiverType;
    @Nullable
    private final String receiverUserID;
    @Nullable
    private final CallRegistrationStatus registrationStatus;
    @Nullable
    private final String source;

    public CallMetadata() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (CallRegistrationStatus) null, (Boolean) null, (String) null, 2047, (DefaultConstructorMarker) null);
    }

    public CallMetadata(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable CallRegistrationStatus callRegistrationStatus, @Nullable Boolean bool, @Nullable String str9) {
        this.callID = str;
        this.duration = str2;
        this.receiverUserID = str3;
        this.receiverType = str4;
        this.source = str5;
        this.errorMessage = str6;
        this.endCallReason = str7;
        this.buttonToggleState = str8;
        this.registrationStatus = callRegistrationStatus;
        this.buttonState = bool;
        this.provider = str9;
    }

    public static /* synthetic */ CallMetadata copy$default(CallMetadata callMetadata, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, CallRegistrationStatus callRegistrationStatus, Boolean bool, String str9, int i11, Object obj) {
        CallMetadata callMetadata2 = callMetadata;
        int i12 = i11;
        return callMetadata.copy((i12 & 1) != 0 ? callMetadata2.callID : str, (i12 & 2) != 0 ? callMetadata2.duration : str2, (i12 & 4) != 0 ? callMetadata2.receiverUserID : str3, (i12 & 8) != 0 ? callMetadata2.receiverType : str4, (i12 & 16) != 0 ? callMetadata2.source : str5, (i12 & 32) != 0 ? callMetadata2.errorMessage : str6, (i12 & 64) != 0 ? callMetadata2.endCallReason : str7, (i12 & 128) != 0 ? callMetadata2.buttonToggleState : str8, (i12 & 256) != 0 ? callMetadata2.registrationStatus : callRegistrationStatus, (i12 & 512) != 0 ? callMetadata2.buttonState : bool, (i12 & 1024) != 0 ? callMetadata2.provider : str9);
    }

    @Nullable
    public final String component1() {
        return this.callID;
    }

    @Nullable
    public final Boolean component10() {
        return this.buttonState;
    }

    @Nullable
    public final String component11() {
        return this.provider;
    }

    @Nullable
    public final String component2() {
        return this.duration;
    }

    @Nullable
    public final String component3() {
        return this.receiverUserID;
    }

    @Nullable
    public final String component4() {
        return this.receiverType;
    }

    @Nullable
    public final String component5() {
        return this.source;
    }

    @Nullable
    public final String component6() {
        return this.errorMessage;
    }

    @Nullable
    public final String component7() {
        return this.endCallReason;
    }

    @Nullable
    public final String component8() {
        return this.buttonToggleState;
    }

    @Nullable
    public final CallRegistrationStatus component9() {
        return this.registrationStatus;
    }

    @NotNull
    public final CallMetadata copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable CallRegistrationStatus callRegistrationStatus, @Nullable Boolean bool, @Nullable String str9) {
        return new CallMetadata(str, str2, str3, str4, str5, str6, str7, str8, callRegistrationStatus, bool, str9);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CallMetadata)) {
            return false;
        }
        CallMetadata callMetadata = (CallMetadata) obj;
        return Intrinsics.areEqual((Object) this.callID, (Object) callMetadata.callID) && Intrinsics.areEqual((Object) this.duration, (Object) callMetadata.duration) && Intrinsics.areEqual((Object) this.receiverUserID, (Object) callMetadata.receiverUserID) && Intrinsics.areEqual((Object) this.receiverType, (Object) callMetadata.receiverType) && Intrinsics.areEqual((Object) this.source, (Object) callMetadata.source) && Intrinsics.areEqual((Object) this.errorMessage, (Object) callMetadata.errorMessage) && Intrinsics.areEqual((Object) this.endCallReason, (Object) callMetadata.endCallReason) && Intrinsics.areEqual((Object) this.buttonToggleState, (Object) callMetadata.buttonToggleState) && this.registrationStatus == callMetadata.registrationStatus && Intrinsics.areEqual((Object) this.buttonState, (Object) callMetadata.buttonState) && Intrinsics.areEqual((Object) this.provider, (Object) callMetadata.provider);
    }

    @Nullable
    public final Boolean getButtonState() {
        return this.buttonState;
    }

    @Nullable
    public final String getButtonToggleState() {
        return this.buttonToggleState;
    }

    @Nullable
    public final String getCallID() {
        return this.callID;
    }

    @Nullable
    public final String getDuration() {
        return this.duration;
    }

    @Nullable
    public final String getEndCallReason() {
        return this.endCallReason;
    }

    @Nullable
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    @Nullable
    public final String getProvider() {
        return this.provider;
    }

    @Nullable
    public final String getReceiverType() {
        return this.receiverType;
    }

    @Nullable
    public final String getReceiverUserID() {
        return this.receiverUserID;
    }

    @Nullable
    public final CallRegistrationStatus getRegistrationStatus() {
        return this.registrationStatus;
    }

    @Nullable
    public final String getSource() {
        return this.source;
    }

    public int hashCode() {
        String str = this.callID;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.duration;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.receiverUserID;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.receiverType;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.source;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.errorMessage;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.endCallReason;
        int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.buttonToggleState;
        int hashCode8 = (hashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        CallRegistrationStatus callRegistrationStatus = this.registrationStatus;
        int hashCode9 = (hashCode8 + (callRegistrationStatus == null ? 0 : callRegistrationStatus.hashCode())) * 31;
        Boolean bool = this.buttonState;
        int hashCode10 = (hashCode9 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str9 = this.provider;
        if (str9 != null) {
            i11 = str9.hashCode();
        }
        return hashCode10 + i11;
    }

    @NotNull
    public String toString() {
        return "CallMetadata(callID=" + this.callID + ", duration=" + this.duration + ", receiverUserID=" + this.receiverUserID + ", receiverType=" + this.receiverType + ", source=" + this.source + ", errorMessage=" + this.errorMessage + ", endCallReason=" + this.endCallReason + ", buttonToggleState=" + this.buttonToggleState + ", registrationStatus=" + this.registrationStatus + ", buttonState=" + this.buttonState + ", provider=" + this.provider + ')';
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CallMetadata(java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, com.deliveryhero.customerchat.telephony.domain.voipAnalytics.CallRegistrationStatus r21, java.lang.Boolean r22, java.lang.String r23, int r24, kotlin.jvm.internal.DefaultConstructorMarker r25) {
        /*
            r12 = this;
            r0 = r24
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r13
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r14
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0017
            r4 = r2
            goto L_0x0018
        L_0x0017:
            r4 = r15
        L_0x0018:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001e
            r5 = r2
            goto L_0x0020
        L_0x001e:
            r5 = r16
        L_0x0020:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0026
            r6 = r2
            goto L_0x0028
        L_0x0026:
            r6 = r17
        L_0x0028:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002e
            r7 = r2
            goto L_0x0030
        L_0x002e:
            r7 = r18
        L_0x0030:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0036
            r8 = r2
            goto L_0x0038
        L_0x0036:
            r8 = r19
        L_0x0038:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x003e
            r9 = r2
            goto L_0x0040
        L_0x003e:
            r9 = r20
        L_0x0040:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0046
            r10 = r2
            goto L_0x0048
        L_0x0046:
            r10 = r21
        L_0x0048:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x004e
            r11 = r2
            goto L_0x0050
        L_0x004e:
            r11 = r22
        L_0x0050:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0055
            goto L_0x0057
        L_0x0055:
            r2 = r23
        L_0x0057:
            r13 = r12
            r14 = r1
            r15 = r3
            r16 = r4
            r17 = r5
            r18 = r6
            r19 = r7
            r20 = r8
            r21 = r9
            r22 = r10
            r23 = r11
            r24 = r2
            r13.<init>(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.customerchat.eventTracking.data.CallMetadata.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.deliveryhero.customerchat.telephony.domain.voipAnalytics.CallRegistrationStatus, java.lang.Boolean, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
