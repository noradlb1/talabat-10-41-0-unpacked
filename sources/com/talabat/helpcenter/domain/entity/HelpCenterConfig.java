package com.talabat.helpcenter.domain.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\"\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010'\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0001\u0010)\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010*J\u0013\u0010+\u001a\u00020\u00032\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020.HÖ\u0001J\t\u0010/\u001a\u00020\u000bHÖ\u0001R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0018\u0010\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0019\u0010\u0016R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001a\u0010\u0016R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001b\u0010\u0016R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001c\u0010\u0016R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001d\u0010\u0016¨\u00060"}, d2 = {"Lcom/talabat/helpcenter/domain/entity/HelpCenterConfig;", "", "showRiderChat", "", "showLiveChat", "showOrderInfo", "showRateOrder", "showVendorPhone", "showLiveChatInDirectly", "shouldSoftDeflect", "ccr1", "", "ccr2", "ccr3", "dhCode", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCcr1", "()Ljava/lang/String;", "getCcr2", "getCcr3", "getDhCode", "getShouldSoftDeflect", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getShowLiveChat", "getShowLiveChatInDirectly", "getShowOrderInfo", "getShowRateOrder", "getShowRiderChat", "getShowVendorPhone", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/talabat/helpcenter/domain/entity/HelpCenterConfig;", "equals", "other", "hashCode", "", "toString", "com_talabat_NewArchi_TalabatHelpCenter_TalabatHelpCenter"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HelpCenterConfig {
    @Nullable
    private final String ccr1;
    @Nullable
    private final String ccr2;
    @Nullable
    private final String ccr3;
    @Nullable
    private final String dhCode;
    @Nullable
    private final Boolean shouldSoftDeflect;
    @Nullable
    private final Boolean showLiveChat;
    @Nullable
    private final Boolean showLiveChatInDirectly;
    @Nullable
    private final Boolean showOrderInfo;
    @Nullable
    private final Boolean showRateOrder;
    @Nullable
    private final Boolean showRiderChat;
    @Nullable
    private final Boolean showVendorPhone;

    public HelpCenterConfig() {
        this((Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (String) null, (String) null, (String) null, (String) null, 2047, (DefaultConstructorMarker) null);
    }

    public HelpCenterConfig(@Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable Boolean bool4, @Nullable Boolean bool5, @Nullable Boolean bool6, @Nullable Boolean bool7, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        this.showRiderChat = bool;
        this.showLiveChat = bool2;
        this.showOrderInfo = bool3;
        this.showRateOrder = bool4;
        this.showVendorPhone = bool5;
        this.showLiveChatInDirectly = bool6;
        this.shouldSoftDeflect = bool7;
        this.ccr1 = str;
        this.ccr2 = str2;
        this.ccr3 = str3;
        this.dhCode = str4;
    }

    public static /* synthetic */ HelpCenterConfig copy$default(HelpCenterConfig helpCenterConfig, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, String str, String str2, String str3, String str4, int i11, Object obj) {
        HelpCenterConfig helpCenterConfig2 = helpCenterConfig;
        int i12 = i11;
        return helpCenterConfig.copy((i12 & 1) != 0 ? helpCenterConfig2.showRiderChat : bool, (i12 & 2) != 0 ? helpCenterConfig2.showLiveChat : bool2, (i12 & 4) != 0 ? helpCenterConfig2.showOrderInfo : bool3, (i12 & 8) != 0 ? helpCenterConfig2.showRateOrder : bool4, (i12 & 16) != 0 ? helpCenterConfig2.showVendorPhone : bool5, (i12 & 32) != 0 ? helpCenterConfig2.showLiveChatInDirectly : bool6, (i12 & 64) != 0 ? helpCenterConfig2.shouldSoftDeflect : bool7, (i12 & 128) != 0 ? helpCenterConfig2.ccr1 : str, (i12 & 256) != 0 ? helpCenterConfig2.ccr2 : str2, (i12 & 512) != 0 ? helpCenterConfig2.ccr3 : str3, (i12 & 1024) != 0 ? helpCenterConfig2.dhCode : str4);
    }

    @Nullable
    public final Boolean component1() {
        return this.showRiderChat;
    }

    @Nullable
    public final String component10() {
        return this.ccr3;
    }

    @Nullable
    public final String component11() {
        return this.dhCode;
    }

    @Nullable
    public final Boolean component2() {
        return this.showLiveChat;
    }

    @Nullable
    public final Boolean component3() {
        return this.showOrderInfo;
    }

    @Nullable
    public final Boolean component4() {
        return this.showRateOrder;
    }

    @Nullable
    public final Boolean component5() {
        return this.showVendorPhone;
    }

    @Nullable
    public final Boolean component6() {
        return this.showLiveChatInDirectly;
    }

    @Nullable
    public final Boolean component7() {
        return this.shouldSoftDeflect;
    }

    @Nullable
    public final String component8() {
        return this.ccr1;
    }

    @Nullable
    public final String component9() {
        return this.ccr2;
    }

    @NotNull
    public final HelpCenterConfig copy(@Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable Boolean bool4, @Nullable Boolean bool5, @Nullable Boolean bool6, @Nullable Boolean bool7, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        return new HelpCenterConfig(bool, bool2, bool3, bool4, bool5, bool6, bool7, str, str2, str3, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HelpCenterConfig)) {
            return false;
        }
        HelpCenterConfig helpCenterConfig = (HelpCenterConfig) obj;
        return Intrinsics.areEqual((Object) this.showRiderChat, (Object) helpCenterConfig.showRiderChat) && Intrinsics.areEqual((Object) this.showLiveChat, (Object) helpCenterConfig.showLiveChat) && Intrinsics.areEqual((Object) this.showOrderInfo, (Object) helpCenterConfig.showOrderInfo) && Intrinsics.areEqual((Object) this.showRateOrder, (Object) helpCenterConfig.showRateOrder) && Intrinsics.areEqual((Object) this.showVendorPhone, (Object) helpCenterConfig.showVendorPhone) && Intrinsics.areEqual((Object) this.showLiveChatInDirectly, (Object) helpCenterConfig.showLiveChatInDirectly) && Intrinsics.areEqual((Object) this.shouldSoftDeflect, (Object) helpCenterConfig.shouldSoftDeflect) && Intrinsics.areEqual((Object) this.ccr1, (Object) helpCenterConfig.ccr1) && Intrinsics.areEqual((Object) this.ccr2, (Object) helpCenterConfig.ccr2) && Intrinsics.areEqual((Object) this.ccr3, (Object) helpCenterConfig.ccr3) && Intrinsics.areEqual((Object) this.dhCode, (Object) helpCenterConfig.dhCode);
    }

    @Nullable
    public final String getCcr1() {
        return this.ccr1;
    }

    @Nullable
    public final String getCcr2() {
        return this.ccr2;
    }

    @Nullable
    public final String getCcr3() {
        return this.ccr3;
    }

    @Nullable
    public final String getDhCode() {
        return this.dhCode;
    }

    @Nullable
    public final Boolean getShouldSoftDeflect() {
        return this.shouldSoftDeflect;
    }

    @Nullable
    public final Boolean getShowLiveChat() {
        return this.showLiveChat;
    }

    @Nullable
    public final Boolean getShowLiveChatInDirectly() {
        return this.showLiveChatInDirectly;
    }

    @Nullable
    public final Boolean getShowOrderInfo() {
        return this.showOrderInfo;
    }

    @Nullable
    public final Boolean getShowRateOrder() {
        return this.showRateOrder;
    }

    @Nullable
    public final Boolean getShowRiderChat() {
        return this.showRiderChat;
    }

    @Nullable
    public final Boolean getShowVendorPhone() {
        return this.showVendorPhone;
    }

    public int hashCode() {
        Boolean bool = this.showRiderChat;
        int i11 = 0;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Boolean bool2 = this.showLiveChat;
        int hashCode2 = (hashCode + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.showOrderInfo;
        int hashCode3 = (hashCode2 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Boolean bool4 = this.showRateOrder;
        int hashCode4 = (hashCode3 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        Boolean bool5 = this.showVendorPhone;
        int hashCode5 = (hashCode4 + (bool5 == null ? 0 : bool5.hashCode())) * 31;
        Boolean bool6 = this.showLiveChatInDirectly;
        int hashCode6 = (hashCode5 + (bool6 == null ? 0 : bool6.hashCode())) * 31;
        Boolean bool7 = this.shouldSoftDeflect;
        int hashCode7 = (hashCode6 + (bool7 == null ? 0 : bool7.hashCode())) * 31;
        String str = this.ccr1;
        int hashCode8 = (hashCode7 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.ccr2;
        int hashCode9 = (hashCode8 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.ccr3;
        int hashCode10 = (hashCode9 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.dhCode;
        if (str4 != null) {
            i11 = str4.hashCode();
        }
        return hashCode10 + i11;
    }

    @NotNull
    public String toString() {
        Boolean bool = this.showRiderChat;
        Boolean bool2 = this.showLiveChat;
        Boolean bool3 = this.showOrderInfo;
        Boolean bool4 = this.showRateOrder;
        Boolean bool5 = this.showVendorPhone;
        Boolean bool6 = this.showLiveChatInDirectly;
        Boolean bool7 = this.shouldSoftDeflect;
        String str = this.ccr1;
        String str2 = this.ccr2;
        String str3 = this.ccr3;
        String str4 = this.dhCode;
        return "HelpCenterConfig(showRiderChat=" + bool + ", showLiveChat=" + bool2 + ", showOrderInfo=" + bool3 + ", showRateOrder=" + bool4 + ", showVendorPhone=" + bool5 + ", showLiveChatInDirectly=" + bool6 + ", shouldSoftDeflect=" + bool7 + ", ccr1=" + str + ", ccr2=" + str2 + ", ccr3=" + str3 + ", dhCode=" + str4 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ HelpCenterConfig(java.lang.Boolean r13, java.lang.Boolean r14, java.lang.Boolean r15, java.lang.Boolean r16, java.lang.Boolean r17, java.lang.Boolean r18, java.lang.Boolean r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, int r24, kotlin.jvm.internal.DefaultConstructorMarker r25) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.helpcenter.domain.entity.HelpCenterConfig.<init>(java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
