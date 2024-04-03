package com.deliveryhero.perseus;

import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.talabat.core.tracking.data.constant.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.compress.archivers.cpio.CpioConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b&\u0018\u00002\u00020\u0001B\u0001\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u0016R\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018R\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010\u0010\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0018\"\u0004\b*\u0010\u001aR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0018R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0018\"\u0004\b/\u0010\u001aR\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R$\u00105\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u0003@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0018\"\u0004\b7\u0010\u001aR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\u0018R\u001a\u0010\u0011\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u0018\"\u0004\b:\u0010\u001a¨\u0006;"}, d2 = {"Lcom/deliveryhero/perseus/PerseusParamsConfig;", "", "advertisingId", "", "appId", "appName", "appVersionName", "adjustId", "uaId", "entity", "debuggable", "", "batchSize", "", "retentionTime", "", "countryCode", "userId", "baseUrlOverride", "globalEntityId", "consent", "Lcom/deliveryhero/perseus/Consent;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZIJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/deliveryhero/perseus/Consent;)V", "getAdjustId", "()Ljava/lang/String;", "setAdjustId", "(Ljava/lang/String;)V", "getAdvertisingId", "setAdvertisingId", "getAppId", "getAppName", "getAppVersionName", "getBaseUrlOverride", "getBatchSize", "()I", "setBatchSize", "(I)V", "getConsent", "()Lcom/deliveryhero/perseus/Consent;", "setConsent", "(Lcom/deliveryhero/perseus/Consent;)V", "getCountryCode", "setCountryCode", "getDebuggable", "()Z", "getEntity", "getGlobalEntityId", "setGlobalEntityId", "getRetentionTime", "()J", "setRetentionTime", "(J)V", "<set-?>", "sdkVersionName", "getSdkVersionName", "setSdkVersionName$perseus_release", "getUaId", "getUserId", "setUserId", "perseus_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PerseusParamsConfig {
    @NotNull
    private String adjustId;
    @NotNull
    private String advertisingId;
    @NotNull
    private final String appId;
    @NotNull
    private final String appName;
    @NotNull
    private final String appVersionName;
    @Nullable
    private final String baseUrlOverride;
    private int batchSize;
    @Nullable
    private Consent consent;
    @NotNull
    private String countryCode;
    private final boolean debuggable;
    @NotNull
    private final String entity;
    @Nullable
    private String globalEntityId;
    private long retentionTime;
    @NotNull
    private String sdkVersionName;
    @NotNull
    private final String uaId;
    @NotNull
    private String userId;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PerseusParamsConfig(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, boolean z11) {
        this(str, str2, str3, str4, str5, str6, str7, z11, 0, 0, (String) null, (String) null, (String) null, (String) null, (Consent) null, 32512, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, ConstantsKt.GOOGLE_AD_ID);
        Intrinsics.checkNotNullParameter(str2, "appId");
        Intrinsics.checkNotNullParameter(str3, AnalyticsAttribute.APP_NAME_ATTRIBUTE);
        Intrinsics.checkNotNullParameter(str4, "appVersionName");
        Intrinsics.checkNotNullParameter(str5, "adjustId");
        Intrinsics.checkNotNullParameter(str6, "uaId");
        Intrinsics.checkNotNullParameter(str7, "entity");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PerseusParamsConfig(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, boolean z11, int i11) {
        this(str, str2, str3, str4, str5, str6, str7, z11, i11, 0, (String) null, (String) null, (String) null, (String) null, (Consent) null, 32256, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, ConstantsKt.GOOGLE_AD_ID);
        Intrinsics.checkNotNullParameter(str2, "appId");
        Intrinsics.checkNotNullParameter(str3, AnalyticsAttribute.APP_NAME_ATTRIBUTE);
        Intrinsics.checkNotNullParameter(str4, "appVersionName");
        Intrinsics.checkNotNullParameter(str5, "adjustId");
        Intrinsics.checkNotNullParameter(str6, "uaId");
        Intrinsics.checkNotNullParameter(str7, "entity");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PerseusParamsConfig(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, boolean z11, int i11, long j11) {
        this(str, str2, str3, str4, str5, str6, str7, z11, i11, j11, (String) null, (String) null, (String) null, (String) null, (Consent) null, 31744, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, ConstantsKt.GOOGLE_AD_ID);
        Intrinsics.checkNotNullParameter(str2, "appId");
        Intrinsics.checkNotNullParameter(str3, AnalyticsAttribute.APP_NAME_ATTRIBUTE);
        Intrinsics.checkNotNullParameter(str4, "appVersionName");
        Intrinsics.checkNotNullParameter(str5, "adjustId");
        Intrinsics.checkNotNullParameter(str6, "uaId");
        Intrinsics.checkNotNullParameter(str7, "entity");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PerseusParamsConfig(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, boolean z11, int i11, long j11, @NotNull String str8) {
        this(str, str2, str3, str4, str5, str6, str7, z11, i11, j11, str8, (String) null, (String) null, (String) null, (Consent) null, 30720, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, ConstantsKt.GOOGLE_AD_ID);
        Intrinsics.checkNotNullParameter(str2, "appId");
        Intrinsics.checkNotNullParameter(str3, AnalyticsAttribute.APP_NAME_ATTRIBUTE);
        Intrinsics.checkNotNullParameter(str4, "appVersionName");
        Intrinsics.checkNotNullParameter(str5, "adjustId");
        Intrinsics.checkNotNullParameter(str6, "uaId");
        Intrinsics.checkNotNullParameter(str7, "entity");
        Intrinsics.checkNotNullParameter(str8, "countryCode");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PerseusParamsConfig(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, boolean z11, int i11, long j11, @NotNull String str8, @NotNull String str9) {
        this(str, str2, str3, str4, str5, str6, str7, z11, i11, j11, str8, str9, (String) null, (String) null, (Consent) null, 28672, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, ConstantsKt.GOOGLE_AD_ID);
        Intrinsics.checkNotNullParameter(str2, "appId");
        Intrinsics.checkNotNullParameter(str3, AnalyticsAttribute.APP_NAME_ATTRIBUTE);
        Intrinsics.checkNotNullParameter(str4, "appVersionName");
        Intrinsics.checkNotNullParameter(str5, "adjustId");
        Intrinsics.checkNotNullParameter(str6, "uaId");
        Intrinsics.checkNotNullParameter(str7, "entity");
        Intrinsics.checkNotNullParameter(str8, "countryCode");
        Intrinsics.checkNotNullParameter(str9, "userId");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PerseusParamsConfig(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, boolean z11, int i11, long j11, @NotNull String str8, @NotNull String str9, @Nullable String str10) {
        this(str, str2, str3, str4, str5, str6, str7, z11, i11, j11, str8, str9, str10, (String) null, (Consent) null, CpioConstants.C_ISBLK, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, ConstantsKt.GOOGLE_AD_ID);
        Intrinsics.checkNotNullParameter(str2, "appId");
        Intrinsics.checkNotNullParameter(str3, AnalyticsAttribute.APP_NAME_ATTRIBUTE);
        Intrinsics.checkNotNullParameter(str4, "appVersionName");
        Intrinsics.checkNotNullParameter(str5, "adjustId");
        Intrinsics.checkNotNullParameter(str6, "uaId");
        Intrinsics.checkNotNullParameter(str7, "entity");
        Intrinsics.checkNotNullParameter(str8, "countryCode");
        Intrinsics.checkNotNullParameter(str9, "userId");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @kotlin.jvm.JvmOverloads
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public PerseusParamsConfig(@org.jetbrains.annotations.NotNull java.lang.String r22, @org.jetbrains.annotations.NotNull java.lang.String r23, @org.jetbrains.annotations.NotNull java.lang.String r24, @org.jetbrains.annotations.NotNull java.lang.String r25, @org.jetbrains.annotations.NotNull java.lang.String r26, @org.jetbrains.annotations.NotNull java.lang.String r27, @org.jetbrains.annotations.NotNull java.lang.String r28, boolean r29, int r30, long r31, @org.jetbrains.annotations.NotNull java.lang.String r33, @org.jetbrains.annotations.NotNull java.lang.String r34, @org.jetbrains.annotations.Nullable java.lang.String r35, @org.jetbrains.annotations.Nullable java.lang.String r36) {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            r2 = r23
            r3 = r24
            r4 = r25
            r5 = r26
            r6 = r27
            r7 = r28
            r8 = r29
            r9 = r30
            r10 = r31
            r12 = r33
            r13 = r34
            r14 = r35
            r15 = r36
            r19 = r0
            java.lang.String r0 = "advertisingId"
            r20 = r1
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "appId"
            r1 = r23
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "appName"
            r1 = r24
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "appVersionName"
            r1 = r25
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "adjustId"
            r1 = r26
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "uaId"
            r1 = r27
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "entity"
            r1 = r28
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "countryCode"
            r1 = r33
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "userId"
            r1 = r34
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            r16 = 0
            r17 = 16384(0x4000, float:2.2959E-41)
            r18 = 0
            r0 = r19
            r1 = r20
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13, r14, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.perseus.PerseusParamsConfig.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, int, long, java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    @JvmOverloads
    public PerseusParamsConfig(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, boolean z11, int i11, long j11, @NotNull String str8, @NotNull String str9, @Nullable String str10, @Nullable String str11, @Nullable Consent consent2) {
        String str12 = str5;
        String str13 = str6;
        String str14 = str7;
        String str15 = str8;
        String str16 = str9;
        Intrinsics.checkNotNullParameter(str, ConstantsKt.GOOGLE_AD_ID);
        Intrinsics.checkNotNullParameter(str2, "appId");
        Intrinsics.checkNotNullParameter(str3, AnalyticsAttribute.APP_NAME_ATTRIBUTE);
        Intrinsics.checkNotNullParameter(str4, "appVersionName");
        Intrinsics.checkNotNullParameter(str12, "adjustId");
        Intrinsics.checkNotNullParameter(str13, "uaId");
        Intrinsics.checkNotNullParameter(str14, "entity");
        Intrinsics.checkNotNullParameter(str15, "countryCode");
        Intrinsics.checkNotNullParameter(str16, "userId");
        this.advertisingId = str;
        this.appId = str2;
        this.appName = str3;
        this.appVersionName = str4;
        this.adjustId = str12;
        this.uaId = str13;
        this.entity = str14;
        this.debuggable = z11;
        this.batchSize = i11;
        this.retentionTime = j11;
        this.countryCode = str15;
        this.userId = str16;
        this.baseUrlOverride = str10;
        this.globalEntityId = str11;
        this.consent = consent2;
        this.sdkVersionName = BuildConfig.VERSION_NAME;
    }

    @NotNull
    public final String getAdjustId() {
        return this.adjustId;
    }

    @NotNull
    public final String getAdvertisingId() {
        return this.advertisingId;
    }

    @NotNull
    public final String getAppId() {
        return this.appId;
    }

    @NotNull
    public final String getAppName() {
        return this.appName;
    }

    @NotNull
    public final String getAppVersionName() {
        return this.appVersionName;
    }

    @Nullable
    public final String getBaseUrlOverride() {
        return this.baseUrlOverride;
    }

    public final int getBatchSize() {
        return this.batchSize;
    }

    @Nullable
    public final Consent getConsent() {
        return this.consent;
    }

    @NotNull
    public final String getCountryCode() {
        return this.countryCode;
    }

    public final boolean getDebuggable() {
        return this.debuggable;
    }

    @NotNull
    public final String getEntity() {
        return this.entity;
    }

    @Nullable
    public final String getGlobalEntityId() {
        return this.globalEntityId;
    }

    public final long getRetentionTime() {
        return this.retentionTime;
    }

    @NotNull
    public final String getSdkVersionName() {
        return this.sdkVersionName;
    }

    @NotNull
    public final String getUaId() {
        return this.uaId;
    }

    @NotNull
    public final String getUserId() {
        return this.userId;
    }

    public final void setAdjustId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.adjustId = str;
    }

    public final void setAdvertisingId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.advertisingId = str;
    }

    public final void setBatchSize(int i11) {
        this.batchSize = i11;
    }

    public final void setConsent(@Nullable Consent consent2) {
        this.consent = consent2;
    }

    public final void setCountryCode(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.countryCode = str;
    }

    public final void setGlobalEntityId(@Nullable String str) {
        this.globalEntityId = str;
    }

    public final void setRetentionTime(long j11) {
        this.retentionTime = j11;
    }

    public final void setSdkVersionName$perseus_release(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sdkVersionName = str;
    }

    public final void setUserId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.userId = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PerseusParamsConfig(java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, boolean r27, int r28, long r29, java.lang.String r31, java.lang.String r32, java.lang.String r33, java.lang.String r34, com.deliveryhero.perseus.Consent r35, int r36, kotlin.jvm.internal.DefaultConstructorMarker r37) {
        /*
            r19 = this;
            r0 = r36
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x000a
            r1 = 10
            r11 = r1
            goto L_0x000c
        L_0x000a:
            r11 = r28
        L_0x000c:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0014
            r1 = 30
            r12 = r1
            goto L_0x0016
        L_0x0014:
            r12 = r29
        L_0x0016:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x001e
            r14 = r2
            goto L_0x0020
        L_0x001e:
            r14 = r31
        L_0x0020:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x0026
            r15 = r2
            goto L_0x0028
        L_0x0026:
            r15 = r32
        L_0x0028:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            r2 = 0
            if (r1 == 0) goto L_0x0030
            r16 = r2
            goto L_0x0032
        L_0x0030:
            r16 = r33
        L_0x0032:
            r1 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L_0x0039
            r17 = r2
            goto L_0x003b
        L_0x0039:
            r17 = r34
        L_0x003b:
            r0 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L_0x0042
            r18 = r2
            goto L_0x0044
        L_0x0042:
            r18 = r35
        L_0x0044:
            r2 = r19
            r3 = r20
            r4 = r21
            r5 = r22
            r6 = r23
            r7 = r24
            r8 = r25
            r9 = r26
            r10 = r27
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r14, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.perseus.PerseusParamsConfig.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, int, long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.deliveryhero.perseus.Consent, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
