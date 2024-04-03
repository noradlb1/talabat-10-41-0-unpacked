package com.talabat.perseus.config;

import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.talabat.core.fwf.data.FunWithFlagsConstants;
import com.talabat.core.tracking.data.constant.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\"\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003¢\u0006\u0002\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u000bHÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\u0001\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010,\u001a\u00020\u000b2\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\t\u0010/\u001a\u000200HÖ\u0001J\t\u00101\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0014\u0010\u0006\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0014\u0010\u0007\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0014\u0010\b\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0014\u0010\t\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0014\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\f\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0014\u0010\r\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u0014\u0010\u000e\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012R\u0014\u0010\u000f\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0012¨\u00062"}, d2 = {"Lcom/talabat/perseus/config/InnerPerseusConfig;", "Lcom/talabat/perseus/config/PerseusConfig;", "adjustId", "", "advertisingId", "appId", "appName", "appVersionName", "baseUrl", "countryCode", "debuggable", "", "entity", "globalEntityId", "uaId", "userId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAdjustId", "()Ljava/lang/String;", "getAdvertisingId", "getAppId", "getAppName", "getAppVersionName", "getBaseUrl", "getCountryCode", "getDebuggable", "()Z", "getEntity", "getGlobalEntityId", "getUaId", "getUserId", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "", "toString", "perseus_analytics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class InnerPerseusConfig implements PerseusConfig {
    @NotNull
    private final String adjustId;
    @NotNull
    private final String advertisingId;
    @NotNull
    private final String appId;
    @NotNull
    private final String appName;
    @NotNull
    private final String appVersionName;
    @NotNull
    private final String baseUrl;
    @NotNull
    private final String countryCode;
    private final boolean debuggable;
    @NotNull
    private final String entity;
    @NotNull
    private final String globalEntityId;
    @NotNull
    private final String uaId;
    @NotNull
    private final String userId;

    public InnerPerseusConfig(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, boolean z11, @NotNull String str8, @NotNull String str9, @NotNull String str10, @NotNull String str11) {
        Intrinsics.checkNotNullParameter(str, "adjustId");
        Intrinsics.checkNotNullParameter(str2, ConstantsKt.GOOGLE_AD_ID);
        Intrinsics.checkNotNullParameter(str3, "appId");
        Intrinsics.checkNotNullParameter(str4, AnalyticsAttribute.APP_NAME_ATTRIBUTE);
        Intrinsics.checkNotNullParameter(str5, "appVersionName");
        Intrinsics.checkNotNullParameter(str6, "baseUrl");
        Intrinsics.checkNotNullParameter(str7, "countryCode");
        Intrinsics.checkNotNullParameter(str8, "entity");
        Intrinsics.checkNotNullParameter(str9, FunWithFlagsConstants.ATTRIBUTE_GLOBAL_ENTITY_ID);
        Intrinsics.checkNotNullParameter(str10, "uaId");
        Intrinsics.checkNotNullParameter(str11, "userId");
        this.adjustId = str;
        this.advertisingId = str2;
        this.appId = str3;
        this.appName = str4;
        this.appVersionName = str5;
        this.baseUrl = str6;
        this.countryCode = str7;
        this.debuggable = z11;
        this.entity = str8;
        this.globalEntityId = str9;
        this.uaId = str10;
        this.userId = str11;
    }

    public static /* synthetic */ InnerPerseusConfig copy$default(InnerPerseusConfig innerPerseusConfig, String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z11, String str8, String str9, String str10, String str11, int i11, Object obj) {
        int i12 = i11;
        return innerPerseusConfig.copy((i12 & 1) != 0 ? innerPerseusConfig.getAdjustId() : str, (i12 & 2) != 0 ? innerPerseusConfig.getAdvertisingId() : str2, (i12 & 4) != 0 ? innerPerseusConfig.getAppId() : str3, (i12 & 8) != 0 ? innerPerseusConfig.getAppName() : str4, (i12 & 16) != 0 ? innerPerseusConfig.getAppVersionName() : str5, (i12 & 32) != 0 ? innerPerseusConfig.getBaseUrl() : str6, (i12 & 64) != 0 ? innerPerseusConfig.getCountryCode() : str7, (i12 & 128) != 0 ? innerPerseusConfig.getDebuggable() : z11, (i12 & 256) != 0 ? innerPerseusConfig.getEntity() : str8, (i12 & 512) != 0 ? innerPerseusConfig.getGlobalEntityId() : str9, (i12 & 1024) != 0 ? innerPerseusConfig.getUaId() : str10, (i12 & 2048) != 0 ? innerPerseusConfig.getUserId() : str11);
    }

    @NotNull
    public final String component1() {
        return getAdjustId();
    }

    @NotNull
    public final String component10() {
        return getGlobalEntityId();
    }

    @NotNull
    public final String component11() {
        return getUaId();
    }

    @NotNull
    public final String component12() {
        return getUserId();
    }

    @NotNull
    public final String component2() {
        return getAdvertisingId();
    }

    @NotNull
    public final String component3() {
        return getAppId();
    }

    @NotNull
    public final String component4() {
        return getAppName();
    }

    @NotNull
    public final String component5() {
        return getAppVersionName();
    }

    @NotNull
    public final String component6() {
        return getBaseUrl();
    }

    @NotNull
    public final String component7() {
        return getCountryCode();
    }

    public final boolean component8() {
        return getDebuggable();
    }

    @NotNull
    public final String component9() {
        return getEntity();
    }

    @NotNull
    public final InnerPerseusConfig copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, boolean z11, @NotNull String str8, @NotNull String str9, @NotNull String str10, @NotNull String str11) {
        Intrinsics.checkNotNullParameter(str, "adjustId");
        String str12 = str2;
        Intrinsics.checkNotNullParameter(str12, ConstantsKt.GOOGLE_AD_ID);
        String str13 = str3;
        Intrinsics.checkNotNullParameter(str13, "appId");
        String str14 = str4;
        Intrinsics.checkNotNullParameter(str14, AnalyticsAttribute.APP_NAME_ATTRIBUTE);
        String str15 = str5;
        Intrinsics.checkNotNullParameter(str15, "appVersionName");
        String str16 = str6;
        Intrinsics.checkNotNullParameter(str16, "baseUrl");
        String str17 = str7;
        Intrinsics.checkNotNullParameter(str17, "countryCode");
        String str18 = str8;
        Intrinsics.checkNotNullParameter(str18, "entity");
        String str19 = str9;
        Intrinsics.checkNotNullParameter(str19, FunWithFlagsConstants.ATTRIBUTE_GLOBAL_ENTITY_ID);
        String str20 = str10;
        Intrinsics.checkNotNullParameter(str20, "uaId");
        String str21 = str11;
        Intrinsics.checkNotNullParameter(str21, "userId");
        return new InnerPerseusConfig(str, str12, str13, str14, str15, str16, str17, z11, str18, str19, str20, str21);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InnerPerseusConfig)) {
            return false;
        }
        InnerPerseusConfig innerPerseusConfig = (InnerPerseusConfig) obj;
        return Intrinsics.areEqual((Object) getAdjustId(), (Object) innerPerseusConfig.getAdjustId()) && Intrinsics.areEqual((Object) getAdvertisingId(), (Object) innerPerseusConfig.getAdvertisingId()) && Intrinsics.areEqual((Object) getAppId(), (Object) innerPerseusConfig.getAppId()) && Intrinsics.areEqual((Object) getAppName(), (Object) innerPerseusConfig.getAppName()) && Intrinsics.areEqual((Object) getAppVersionName(), (Object) innerPerseusConfig.getAppVersionName()) && Intrinsics.areEqual((Object) getBaseUrl(), (Object) innerPerseusConfig.getBaseUrl()) && Intrinsics.areEqual((Object) getCountryCode(), (Object) innerPerseusConfig.getCountryCode()) && getDebuggable() == innerPerseusConfig.getDebuggable() && Intrinsics.areEqual((Object) getEntity(), (Object) innerPerseusConfig.getEntity()) && Intrinsics.areEqual((Object) getGlobalEntityId(), (Object) innerPerseusConfig.getGlobalEntityId()) && Intrinsics.areEqual((Object) getUaId(), (Object) innerPerseusConfig.getUaId()) && Intrinsics.areEqual((Object) getUserId(), (Object) innerPerseusConfig.getUserId());
    }

    @NotNull
    public String getAdjustId() {
        return this.adjustId;
    }

    @NotNull
    public String getAdvertisingId() {
        return this.advertisingId;
    }

    @NotNull
    public String getAppId() {
        return this.appId;
    }

    @NotNull
    public String getAppName() {
        return this.appName;
    }

    @NotNull
    public String getAppVersionName() {
        return this.appVersionName;
    }

    @NotNull
    public String getBaseUrl() {
        return this.baseUrl;
    }

    @NotNull
    public String getCountryCode() {
        return this.countryCode;
    }

    public boolean getDebuggable() {
        return this.debuggable;
    }

    @NotNull
    public String getEntity() {
        return this.entity;
    }

    @NotNull
    public String getGlobalEntityId() {
        return this.globalEntityId;
    }

    @NotNull
    public String getUaId() {
        return this.uaId;
    }

    @NotNull
    public String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        int hashCode = ((((((((((((getAdjustId().hashCode() * 31) + getAdvertisingId().hashCode()) * 31) + getAppId().hashCode()) * 31) + getAppName().hashCode()) * 31) + getAppVersionName().hashCode()) * 31) + getBaseUrl().hashCode()) * 31) + getCountryCode().hashCode()) * 31;
        boolean debuggable2 = getDebuggable();
        if (debuggable2) {
            debuggable2 = true;
        }
        return ((((((((hashCode + (debuggable2 ? 1 : 0)) * 31) + getEntity().hashCode()) * 31) + getGlobalEntityId().hashCode()) * 31) + getUaId().hashCode()) * 31) + getUserId().hashCode();
    }

    @NotNull
    public String toString() {
        return "InnerPerseusConfig(adjustId=" + getAdjustId() + ", advertisingId=" + getAdvertisingId() + ", appId=" + getAppId() + ", appName=" + getAppName() + ", appVersionName=" + getAppVersionName() + ", baseUrl=" + getBaseUrl() + ", countryCode=" + getCountryCode() + ", debuggable=" + getDebuggable() + ", entity=" + getEntity() + ", globalEntityId=" + getGlobalEntityId() + ", uaId=" + getUaId() + ", userId=" + getUserId() + ')';
    }
}
