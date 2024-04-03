package com.deliveryhero.perseus.data.remote.api.model;

import androidx.annotation.Keep;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.google.gson.annotations.SerializedName;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.talabat.core.tracking.data.constant.ConstantsKt;
import com.visa.checkout.Profile;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b7\b\u0011\u0018\u00002\u00020\u0001BË\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u0003¢\u0006\u0002\u0010\u001cR\u001e\u0010\u000b\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001e\"\u0004\b\"\u0010 R\u001e\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001e\"\u0004\b$\u0010 R\u001e\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001e\"\u0004\b&\u0010 R\u001e\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001e\"\u0004\b(\u0010 R\u001e\u0010\u000f\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001e\"\u0004\b*\u0010 R\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001e\"\u0004\b,\u0010 R \u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001e\"\u0004\b.\u0010 R\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001e\"\u0004\b0\u0010 R\u0016\u0010\u001b\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001eR\u0016\u0010\u0016\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001eR\u0016\u0010\u001a\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001eR \u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u001e\"\u0004\b5\u0010 R\"\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010:\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0016\u0010\u0019\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\u001eR\u0016\u0010\u0017\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\u001eR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u001e\"\u0004\b>\u0010 R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u001e\"\u0004\b@\u0010 R\u0016\u0010\u0018\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010\u001eR\u001e\u0010\u0013\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u001e\"\u0004\bC\u0010 R\u001e\u0010\u0010\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u001e\"\u0004\bE\u0010 R\u001e\u0010\u000e\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u001e\"\u0004\bG\u0010 R\u001e\u0010\f\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u001e\"\u0004\bI\u0010 R\u001e\u0010\r\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u001e\"\u0004\bK\u0010 ¨\u0006L"}, d2 = {"Lcom/deliveryhero/perseus/data/remote/api/model/BaseHitDetails;", "", "platform", "", "payloadTimestamp", "clientSentTimestamp", "country", "advertisingId", "appId", "appName", "appVersionCode", "adjustId", "userAgent", "userId", "uaId", "clientId", "sessionId", "globalEntityId", "consent", "sdkVersion", "hitNumber", "", "deviceInfo", "operatingSystemVersion", "screenResolution", "marketingName", "deviceModel", "deviceBrand", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAdjustId", "()Ljava/lang/String;", "setAdjustId", "(Ljava/lang/String;)V", "getAdvertisingId", "setAdvertisingId", "getAppId", "setAppId", "getAppName", "setAppName", "getAppVersionCode", "setAppVersionCode", "getClientId", "setClientId", "getClientSentTimestamp", "setClientSentTimestamp", "getConsent", "setConsent", "getCountry", "setCountry", "getDeviceBrand", "getDeviceInfo", "getDeviceModel", "getGlobalEntityId", "setGlobalEntityId", "getHitNumber", "()Ljava/lang/Long;", "setHitNumber", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getMarketingName", "getOperatingSystemVersion", "getPayloadTimestamp", "setPayloadTimestamp", "getPlatform", "setPlatform", "getScreenResolution", "getSdkVersion", "setSdkVersion", "getSessionId", "setSessionId", "getUaId", "setUaId", "getUserAgent", "setUserAgent", "getUserId", "setUserId", "perseus_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Keep
public class BaseHitDetails {
    @SerializedName("adjustId")
    @NotNull
    private String adjustId;
    @SerializedName("advertisingId")
    @NotNull
    private String advertisingId;
    @SerializedName("appId")
    @NotNull
    private String appId;
    @SerializedName("appName")
    @NotNull
    private String appName;
    @SerializedName("appVersionCode")
    @NotNull
    private String appVersionCode;
    @SerializedName("clientId")
    @NotNull
    private String clientId;
    @SerializedName("clientSentTimestamp")
    @NotNull
    private String clientSentTimestamp;
    @SerializedName("consent")
    @Nullable
    private String consent;
    @SerializedName("country")
    @NotNull
    private String country;
    @SerializedName("mobileDeviceBranding")
    @NotNull
    private final String deviceBrand;
    @SerializedName("deviceMobileDeviceInfo")
    @NotNull
    private final String deviceInfo;
    @SerializedName("mobileDeviceModel")
    @NotNull
    private final String deviceModel;
    @SerializedName("globalEntityId")
    @Nullable
    private String globalEntityId;
    @SerializedName("hitNumber")
    @Nullable
    private Long hitNumber;
    @SerializedName("mobileDeviceMarketingName")
    @NotNull
    private final String marketingName;
    @SerializedName("deviceOperatingSystemVersion")
    @NotNull
    private final String operatingSystemVersion;
    @SerializedName("payloadTimestamp")
    @NotNull
    private String payloadTimestamp;
    @SerializedName("platform")
    @NotNull
    private String platform;
    @SerializedName("deviceScreenResolution")
    @NotNull
    private final String screenResolution;
    @SerializedName("sdkVersion")
    @NotNull
    private String sdkVersion;
    @SerializedName("sessionId")
    @NotNull
    private String sessionId;
    @SerializedName("uaId")
    @NotNull
    private String uaId;
    @SerializedName("userAgent")
    @NotNull
    private String userAgent;
    @SerializedName("userId")
    @NotNull
    private String userId;

    public BaseHitDetails(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9, @NotNull String str10, @NotNull String str11, @NotNull String str12, @NotNull String str13, @NotNull String str14, @Nullable String str15, @Nullable String str16, @NotNull String str17, @Nullable Long l11, @NotNull String str18, @NotNull String str19, @NotNull String str20, @NotNull String str21, @NotNull String str22, @NotNull String str23) {
        String str24 = str;
        String str25 = str2;
        String str26 = str3;
        String str27 = str4;
        String str28 = str5;
        String str29 = str6;
        String str30 = str7;
        String str31 = str8;
        String str32 = str9;
        String str33 = str10;
        String str34 = str11;
        String str35 = str12;
        String str36 = str13;
        String str37 = str14;
        String str38 = str18;
        Intrinsics.checkNotNullParameter(str24, "platform");
        Intrinsics.checkNotNullParameter(str25, "payloadTimestamp");
        Intrinsics.checkNotNullParameter(str26, "clientSentTimestamp");
        Intrinsics.checkNotNullParameter(str27, "country");
        Intrinsics.checkNotNullParameter(str28, ConstantsKt.GOOGLE_AD_ID);
        Intrinsics.checkNotNullParameter(str29, "appId");
        Intrinsics.checkNotNullParameter(str30, AnalyticsAttribute.APP_NAME_ATTRIBUTE);
        Intrinsics.checkNotNullParameter(str31, "appVersionCode");
        Intrinsics.checkNotNullParameter(str32, "adjustId");
        Intrinsics.checkNotNullParameter(str33, "userAgent");
        Intrinsics.checkNotNullParameter(str34, "userId");
        Intrinsics.checkNotNullParameter(str35, "uaId");
        Intrinsics.checkNotNullParameter(str36, Profile.CLIENT_ID);
        Intrinsics.checkNotNullParameter(str37, "sessionId");
        Intrinsics.checkNotNullParameter(str17, RemoteConfigConstants.RequestFieldKey.SDK_VERSION);
        Intrinsics.checkNotNullParameter(str18, "deviceInfo");
        Intrinsics.checkNotNullParameter(str19, "operatingSystemVersion");
        Intrinsics.checkNotNullParameter(str20, "screenResolution");
        Intrinsics.checkNotNullParameter(str21, "marketingName");
        Intrinsics.checkNotNullParameter(str22, AnalyticsAttribute.DEVICE_MODEL_ATTRIBUTE);
        Intrinsics.checkNotNullParameter(str23, "deviceBrand");
        this.platform = str24;
        this.payloadTimestamp = str25;
        this.clientSentTimestamp = str26;
        this.country = str27;
        this.advertisingId = str28;
        this.appId = str29;
        this.appName = str30;
        this.appVersionCode = str31;
        this.adjustId = str32;
        this.userAgent = str33;
        this.userId = str34;
        this.uaId = str35;
        this.clientId = str36;
        this.sessionId = str37;
        this.globalEntityId = str15;
        this.consent = str16;
        this.sdkVersion = str17;
        this.hitNumber = l11;
        this.deviceInfo = str18;
        this.operatingSystemVersion = str19;
        this.screenResolution = str20;
        this.marketingName = str21;
        this.deviceModel = str22;
        this.deviceBrand = str23;
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
    public final String getAppVersionCode() {
        return this.appVersionCode;
    }

    @NotNull
    public final String getClientId() {
        return this.clientId;
    }

    @NotNull
    public final String getClientSentTimestamp() {
        return this.clientSentTimestamp;
    }

    @Nullable
    public final String getConsent() {
        return this.consent;
    }

    @NotNull
    public final String getCountry() {
        return this.country;
    }

    @NotNull
    public final String getDeviceBrand() {
        return this.deviceBrand;
    }

    @NotNull
    public final String getDeviceInfo() {
        return this.deviceInfo;
    }

    @NotNull
    public final String getDeviceModel() {
        return this.deviceModel;
    }

    @Nullable
    public final String getGlobalEntityId() {
        return this.globalEntityId;
    }

    @Nullable
    public final Long getHitNumber() {
        return this.hitNumber;
    }

    @NotNull
    public final String getMarketingName() {
        return this.marketingName;
    }

    @NotNull
    public final String getOperatingSystemVersion() {
        return this.operatingSystemVersion;
    }

    @NotNull
    public final String getPayloadTimestamp() {
        return this.payloadTimestamp;
    }

    @NotNull
    public final String getPlatform() {
        return this.platform;
    }

    @NotNull
    public final String getScreenResolution() {
        return this.screenResolution;
    }

    @NotNull
    public final String getSdkVersion() {
        return this.sdkVersion;
    }

    @NotNull
    public final String getSessionId() {
        return this.sessionId;
    }

    @NotNull
    public final String getUaId() {
        return this.uaId;
    }

    @NotNull
    public final String getUserAgent() {
        return this.userAgent;
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

    public final void setAppId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.appId = str;
    }

    public final void setAppName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.appName = str;
    }

    public final void setAppVersionCode(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.appVersionCode = str;
    }

    public final void setClientId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.clientId = str;
    }

    public final void setClientSentTimestamp(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.clientSentTimestamp = str;
    }

    public final void setConsent(@Nullable String str) {
        this.consent = str;
    }

    public final void setCountry(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.country = str;
    }

    public final void setGlobalEntityId(@Nullable String str) {
        this.globalEntityId = str;
    }

    public final void setHitNumber(@Nullable Long l11) {
        this.hitNumber = l11;
    }

    public final void setPayloadTimestamp(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.payloadTimestamp = str;
    }

    public final void setPlatform(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.platform = str;
    }

    public final void setSdkVersion(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sdkVersion = str;
    }

    public final void setSessionId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sessionId = str;
    }

    public final void setUaId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.uaId = str;
    }

    public final void setUserAgent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.userAgent = str;
    }

    public final void setUserId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.userId = str;
    }
}
