package com.talabat.offering.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BY\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J]\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\f\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u0010R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u0010¨\u0006%"}, d2 = {"Lcom/talabat/offering/data/SubscriptionVerificationEvent;", "", "channel", "", "screenType", "screenName", "eventOrigin", "subscriptionType", "failReason", "mobileVerificationStatus", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getChannel", "()Ljava/lang/String;", "getEventOrigin", "getFailReason", "setFailReason", "(Ljava/lang/String;)V", "getMobileVerificationStatus", "setMobileVerificationStatus", "getScreenName", "getScreenType", "getSubscriptionType", "setSubscriptionType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_Offering_Offering"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionVerificationEvent {
    @Nullable
    private final String channel;
    @Nullable
    private final String eventOrigin;
    @Nullable
    private String failReason;
    @Nullable
    private String mobileVerificationStatus;
    @Nullable
    private final String screenName;
    @Nullable
    private final String screenType;
    @Nullable
    private String subscriptionType;

    public SubscriptionVerificationEvent() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 127, (DefaultConstructorMarker) null);
    }

    public SubscriptionVerificationEvent(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7) {
        this.channel = str;
        this.screenType = str2;
        this.screenName = str3;
        this.eventOrigin = str4;
        this.subscriptionType = str5;
        this.failReason = str6;
        this.mobileVerificationStatus = str7;
    }

    public static /* synthetic */ SubscriptionVerificationEvent copy$default(SubscriptionVerificationEvent subscriptionVerificationEvent, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = subscriptionVerificationEvent.channel;
        }
        if ((i11 & 2) != 0) {
            str2 = subscriptionVerificationEvent.screenType;
        }
        String str8 = str2;
        if ((i11 & 4) != 0) {
            str3 = subscriptionVerificationEvent.screenName;
        }
        String str9 = str3;
        if ((i11 & 8) != 0) {
            str4 = subscriptionVerificationEvent.eventOrigin;
        }
        String str10 = str4;
        if ((i11 & 16) != 0) {
            str5 = subscriptionVerificationEvent.subscriptionType;
        }
        String str11 = str5;
        if ((i11 & 32) != 0) {
            str6 = subscriptionVerificationEvent.failReason;
        }
        String str12 = str6;
        if ((i11 & 64) != 0) {
            str7 = subscriptionVerificationEvent.mobileVerificationStatus;
        }
        return subscriptionVerificationEvent.copy(str, str8, str9, str10, str11, str12, str7);
    }

    @Nullable
    public final String component1() {
        return this.channel;
    }

    @Nullable
    public final String component2() {
        return this.screenType;
    }

    @Nullable
    public final String component3() {
        return this.screenName;
    }

    @Nullable
    public final String component4() {
        return this.eventOrigin;
    }

    @Nullable
    public final String component5() {
        return this.subscriptionType;
    }

    @Nullable
    public final String component6() {
        return this.failReason;
    }

    @Nullable
    public final String component7() {
        return this.mobileVerificationStatus;
    }

    @NotNull
    public final SubscriptionVerificationEvent copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7) {
        return new SubscriptionVerificationEvent(str, str2, str3, str4, str5, str6, str7);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubscriptionVerificationEvent)) {
            return false;
        }
        SubscriptionVerificationEvent subscriptionVerificationEvent = (SubscriptionVerificationEvent) obj;
        return Intrinsics.areEqual((Object) this.channel, (Object) subscriptionVerificationEvent.channel) && Intrinsics.areEqual((Object) this.screenType, (Object) subscriptionVerificationEvent.screenType) && Intrinsics.areEqual((Object) this.screenName, (Object) subscriptionVerificationEvent.screenName) && Intrinsics.areEqual((Object) this.eventOrigin, (Object) subscriptionVerificationEvent.eventOrigin) && Intrinsics.areEqual((Object) this.subscriptionType, (Object) subscriptionVerificationEvent.subscriptionType) && Intrinsics.areEqual((Object) this.failReason, (Object) subscriptionVerificationEvent.failReason) && Intrinsics.areEqual((Object) this.mobileVerificationStatus, (Object) subscriptionVerificationEvent.mobileVerificationStatus);
    }

    @Nullable
    public final String getChannel() {
        return this.channel;
    }

    @Nullable
    public final String getEventOrigin() {
        return this.eventOrigin;
    }

    @Nullable
    public final String getFailReason() {
        return this.failReason;
    }

    @Nullable
    public final String getMobileVerificationStatus() {
        return this.mobileVerificationStatus;
    }

    @Nullable
    public final String getScreenName() {
        return this.screenName;
    }

    @Nullable
    public final String getScreenType() {
        return this.screenType;
    }

    @Nullable
    public final String getSubscriptionType() {
        return this.subscriptionType;
    }

    public int hashCode() {
        String str = this.channel;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.screenType;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.screenName;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.eventOrigin;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.subscriptionType;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.failReason;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.mobileVerificationStatus;
        if (str7 != null) {
            i11 = str7.hashCode();
        }
        return hashCode6 + i11;
    }

    public final void setFailReason(@Nullable String str) {
        this.failReason = str;
    }

    public final void setMobileVerificationStatus(@Nullable String str) {
        this.mobileVerificationStatus = str;
    }

    public final void setSubscriptionType(@Nullable String str) {
        this.subscriptionType = str;
    }

    @NotNull
    public String toString() {
        String str = this.channel;
        String str2 = this.screenType;
        String str3 = this.screenName;
        String str4 = this.eventOrigin;
        String str5 = this.subscriptionType;
        String str6 = this.failReason;
        String str7 = this.mobileVerificationStatus;
        return "SubscriptionVerificationEvent(channel=" + str + ", screenType=" + str2 + ", screenName=" + str3 + ", eventOrigin=" + str4 + ", subscriptionType=" + str5 + ", failReason=" + str6 + ", mobileVerificationStatus=" + str7 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SubscriptionVerificationEvent(java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, int r14, kotlin.jvm.internal.DefaultConstructorMarker r15) {
        /*
            r6 = this;
            r15 = r14 & 1
            r0 = 0
            if (r15 == 0) goto L_0x0007
            r15 = r0
            goto L_0x0008
        L_0x0007:
            r15 = r7
        L_0x0008:
            r7 = r14 & 2
            if (r7 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r8
        L_0x000f:
            r7 = r14 & 4
            if (r7 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r9
        L_0x0016:
            r7 = r14 & 8
            if (r7 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r10
        L_0x001d:
            r7 = r14 & 16
            if (r7 == 0) goto L_0x0023
            r4 = r0
            goto L_0x0024
        L_0x0023:
            r4 = r11
        L_0x0024:
            r7 = r14 & 32
            if (r7 == 0) goto L_0x002a
            r5 = r0
            goto L_0x002b
        L_0x002a:
            r5 = r12
        L_0x002b:
            r7 = r14 & 64
            if (r7 == 0) goto L_0x0031
            r14 = r0
            goto L_0x0032
        L_0x0031:
            r14 = r13
        L_0x0032:
            r7 = r6
            r8 = r15
            r9 = r1
            r10 = r2
            r11 = r3
            r12 = r4
            r13 = r5
            r7.<init>(r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.offering.data.SubscriptionVerificationEvent.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
