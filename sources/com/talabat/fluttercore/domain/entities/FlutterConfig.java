package com.talabat.fluttercore.domain.entities;

import com.talabat.card_tokenization.CardTokenizationPlugin;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b.\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B¡\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u0006\u0010\u0019\u001a\u00020\u0003¢\u0006\u0002\u0010\u001aJ\t\u00102\u001a\u00020\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\t\u00104\u001a\u00020\u0012HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0018HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003JÇ\u0001\u0010C\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u0003HÆ\u0001J\u0013\u0010D\u001a\u00020\u00182\b\u0010E\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010F\u001a\u00020GHÖ\u0001J\t\u0010H\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0019\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\"R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\"R\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\"R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010'R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\"R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\"R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\"R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\"R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\"R\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\"¨\u0006I"}, d2 = {"Lcom/talabat/fluttercore/domain/entities/FlutterConfig;", "", "env", "", "token", "lang", "customer", "Lcom/talabat/fluttercore/domain/entities/FlutterCustomerInfo;", "country", "Lcom/talabat/fluttercore/domain/entities/FlutterCountryInfo;", "selectedArea", "Lcom/talabat/fluttercore/domain/entities/FlutterArea;", "perseusClientId", "persuesSessionId", "persuesHitMatchId", "languageModel", "Lcom/talabat/fluttercore/domain/entities/FlutterLanguage;", "appInfo", "Lcom/talabat/fluttercore/domain/entities/FlutterAppInfo;", "deviceID", "deviceVersion", "googleClientId", "traceIdForNullCountry", "isDatalayerEnabled", "", "datalayerKey", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/talabat/fluttercore/domain/entities/FlutterCustomerInfo;Lcom/talabat/fluttercore/domain/entities/FlutterCountryInfo;Lcom/talabat/fluttercore/domain/entities/FlutterArea;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/talabat/fluttercore/domain/entities/FlutterLanguage;Lcom/talabat/fluttercore/domain/entities/FlutterAppInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getAppInfo", "()Lcom/talabat/fluttercore/domain/entities/FlutterAppInfo;", "getCountry", "()Lcom/talabat/fluttercore/domain/entities/FlutterCountryInfo;", "getCustomer", "()Lcom/talabat/fluttercore/domain/entities/FlutterCustomerInfo;", "getDatalayerKey", "()Ljava/lang/String;", "getDeviceID", "getDeviceVersion", "getEnv", "getGoogleClientId", "()Z", "getLang", "getLanguageModel", "()Lcom/talabat/fluttercore/domain/entities/FlutterLanguage;", "getPerseusClientId", "getPersuesHitMatchId", "getPersuesSessionId", "getSelectedArea", "()Lcom/talabat/fluttercore/domain/entities/FlutterArea;", "getToken", "getTraceIdForNullCountry", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "com_talabat_NewArchi_TalabatFlutterCore_TalabatFlutterCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Deprecated(message = "Don't extend. Use *Config classes from :core:configuration:remote:domain instead")
public final class FlutterConfig {
    @NotNull
    private final FlutterAppInfo appInfo;
    @Nullable
    private final FlutterCountryInfo country;
    @Nullable
    private final FlutterCustomerInfo customer;
    @NotNull
    private final String datalayerKey;
    @Nullable
    private final String deviceID;
    @Nullable
    private final String deviceVersion;
    @NotNull
    private final String env;
    @NotNull
    private final String googleClientId;
    private final boolean isDatalayerEnabled;
    @NotNull
    private final String lang;
    @Nullable
    private final FlutterLanguage languageModel;
    @Nullable
    private final String perseusClientId;
    @Nullable
    private final String persuesHitMatchId;
    @Nullable
    private final String persuesSessionId;
    @Nullable
    private final FlutterArea selectedArea;
    @Nullable
    private final String token;
    @NotNull
    private final String traceIdForNullCountry;

    public FlutterConfig(@NotNull String str, @Nullable String str2, @NotNull String str3, @Nullable FlutterCustomerInfo flutterCustomerInfo, @Nullable FlutterCountryInfo flutterCountryInfo, @Nullable FlutterArea flutterArea, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable FlutterLanguage flutterLanguage, @NotNull FlutterAppInfo flutterAppInfo, @Nullable String str7, @Nullable String str8, @NotNull String str9, @NotNull String str10, boolean z11, @NotNull String str11) {
        FlutterAppInfo flutterAppInfo2 = flutterAppInfo;
        String str12 = str9;
        String str13 = str10;
        String str14 = str11;
        Intrinsics.checkNotNullParameter(str, CardTokenizationPlugin.ARG_ENV_KEY);
        Intrinsics.checkNotNullParameter(str3, "lang");
        Intrinsics.checkNotNullParameter(flutterAppInfo2, "appInfo");
        Intrinsics.checkNotNullParameter(str12, "googleClientId");
        Intrinsics.checkNotNullParameter(str13, "traceIdForNullCountry");
        Intrinsics.checkNotNullParameter(str14, "datalayerKey");
        this.env = str;
        this.token = str2;
        this.lang = str3;
        this.customer = flutterCustomerInfo;
        this.country = flutterCountryInfo;
        this.selectedArea = flutterArea;
        this.perseusClientId = str4;
        this.persuesSessionId = str5;
        this.persuesHitMatchId = str6;
        this.languageModel = flutterLanguage;
        this.appInfo = flutterAppInfo2;
        this.deviceID = str7;
        this.deviceVersion = str8;
        this.googleClientId = str12;
        this.traceIdForNullCountry = str13;
        this.isDatalayerEnabled = z11;
        this.datalayerKey = str14;
    }

    public static /* synthetic */ FlutterConfig copy$default(FlutterConfig flutterConfig, String str, String str2, String str3, FlutterCustomerInfo flutterCustomerInfo, FlutterCountryInfo flutterCountryInfo, FlutterArea flutterArea, String str4, String str5, String str6, FlutterLanguage flutterLanguage, FlutterAppInfo flutterAppInfo, String str7, String str8, String str9, String str10, boolean z11, String str11, int i11, Object obj) {
        FlutterConfig flutterConfig2 = flutterConfig;
        int i12 = i11;
        return flutterConfig.copy((i12 & 1) != 0 ? flutterConfig2.env : str, (i12 & 2) != 0 ? flutterConfig2.token : str2, (i12 & 4) != 0 ? flutterConfig2.lang : str3, (i12 & 8) != 0 ? flutterConfig2.customer : flutterCustomerInfo, (i12 & 16) != 0 ? flutterConfig2.country : flutterCountryInfo, (i12 & 32) != 0 ? flutterConfig2.selectedArea : flutterArea, (i12 & 64) != 0 ? flutterConfig2.perseusClientId : str4, (i12 & 128) != 0 ? flutterConfig2.persuesSessionId : str5, (i12 & 256) != 0 ? flutterConfig2.persuesHitMatchId : str6, (i12 & 512) != 0 ? flutterConfig2.languageModel : flutterLanguage, (i12 & 1024) != 0 ? flutterConfig2.appInfo : flutterAppInfo, (i12 & 2048) != 0 ? flutterConfig2.deviceID : str7, (i12 & 4096) != 0 ? flutterConfig2.deviceVersion : str8, (i12 & 8192) != 0 ? flutterConfig2.googleClientId : str9, (i12 & 16384) != 0 ? flutterConfig2.traceIdForNullCountry : str10, (i12 & 32768) != 0 ? flutterConfig2.isDatalayerEnabled : z11, (i12 & 65536) != 0 ? flutterConfig2.datalayerKey : str11);
    }

    @NotNull
    public final String component1() {
        return this.env;
    }

    @Nullable
    public final FlutterLanguage component10() {
        return this.languageModel;
    }

    @NotNull
    public final FlutterAppInfo component11() {
        return this.appInfo;
    }

    @Nullable
    public final String component12() {
        return this.deviceID;
    }

    @Nullable
    public final String component13() {
        return this.deviceVersion;
    }

    @NotNull
    public final String component14() {
        return this.googleClientId;
    }

    @NotNull
    public final String component15() {
        return this.traceIdForNullCountry;
    }

    public final boolean component16() {
        return this.isDatalayerEnabled;
    }

    @NotNull
    public final String component17() {
        return this.datalayerKey;
    }

    @Nullable
    public final String component2() {
        return this.token;
    }

    @NotNull
    public final String component3() {
        return this.lang;
    }

    @Nullable
    public final FlutterCustomerInfo component4() {
        return this.customer;
    }

    @Nullable
    public final FlutterCountryInfo component5() {
        return this.country;
    }

    @Nullable
    public final FlutterArea component6() {
        return this.selectedArea;
    }

    @Nullable
    public final String component7() {
        return this.perseusClientId;
    }

    @Nullable
    public final String component8() {
        return this.persuesSessionId;
    }

    @Nullable
    public final String component9() {
        return this.persuesHitMatchId;
    }

    @NotNull
    public final FlutterConfig copy(@NotNull String str, @Nullable String str2, @NotNull String str3, @Nullable FlutterCustomerInfo flutterCustomerInfo, @Nullable FlutterCountryInfo flutterCountryInfo, @Nullable FlutterArea flutterArea, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable FlutterLanguage flutterLanguage, @NotNull FlutterAppInfo flutterAppInfo, @Nullable String str7, @Nullable String str8, @NotNull String str9, @NotNull String str10, boolean z11, @NotNull String str11) {
        String str12 = str;
        Intrinsics.checkNotNullParameter(str12, CardTokenizationPlugin.ARG_ENV_KEY);
        Intrinsics.checkNotNullParameter(str3, "lang");
        Intrinsics.checkNotNullParameter(flutterAppInfo, "appInfo");
        Intrinsics.checkNotNullParameter(str9, "googleClientId");
        Intrinsics.checkNotNullParameter(str10, "traceIdForNullCountry");
        Intrinsics.checkNotNullParameter(str11, "datalayerKey");
        return new FlutterConfig(str12, str2, str3, flutterCustomerInfo, flutterCountryInfo, flutterArea, str4, str5, str6, flutterLanguage, flutterAppInfo, str7, str8, str9, str10, z11, str11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FlutterConfig)) {
            return false;
        }
        FlutterConfig flutterConfig = (FlutterConfig) obj;
        return Intrinsics.areEqual((Object) this.env, (Object) flutterConfig.env) && Intrinsics.areEqual((Object) this.token, (Object) flutterConfig.token) && Intrinsics.areEqual((Object) this.lang, (Object) flutterConfig.lang) && Intrinsics.areEqual((Object) this.customer, (Object) flutterConfig.customer) && Intrinsics.areEqual((Object) this.country, (Object) flutterConfig.country) && Intrinsics.areEqual((Object) this.selectedArea, (Object) flutterConfig.selectedArea) && Intrinsics.areEqual((Object) this.perseusClientId, (Object) flutterConfig.perseusClientId) && Intrinsics.areEqual((Object) this.persuesSessionId, (Object) flutterConfig.persuesSessionId) && Intrinsics.areEqual((Object) this.persuesHitMatchId, (Object) flutterConfig.persuesHitMatchId) && Intrinsics.areEqual((Object) this.languageModel, (Object) flutterConfig.languageModel) && Intrinsics.areEqual((Object) this.appInfo, (Object) flutterConfig.appInfo) && Intrinsics.areEqual((Object) this.deviceID, (Object) flutterConfig.deviceID) && Intrinsics.areEqual((Object) this.deviceVersion, (Object) flutterConfig.deviceVersion) && Intrinsics.areEqual((Object) this.googleClientId, (Object) flutterConfig.googleClientId) && Intrinsics.areEqual((Object) this.traceIdForNullCountry, (Object) flutterConfig.traceIdForNullCountry) && this.isDatalayerEnabled == flutterConfig.isDatalayerEnabled && Intrinsics.areEqual((Object) this.datalayerKey, (Object) flutterConfig.datalayerKey);
    }

    @NotNull
    public final FlutterAppInfo getAppInfo() {
        return this.appInfo;
    }

    @Nullable
    public final FlutterCountryInfo getCountry() {
        return this.country;
    }

    @Nullable
    public final FlutterCustomerInfo getCustomer() {
        return this.customer;
    }

    @NotNull
    public final String getDatalayerKey() {
        return this.datalayerKey;
    }

    @Nullable
    public final String getDeviceID() {
        return this.deviceID;
    }

    @Nullable
    public final String getDeviceVersion() {
        return this.deviceVersion;
    }

    @NotNull
    public final String getEnv() {
        return this.env;
    }

    @NotNull
    public final String getGoogleClientId() {
        return this.googleClientId;
    }

    @NotNull
    public final String getLang() {
        return this.lang;
    }

    @Nullable
    public final FlutterLanguage getLanguageModel() {
        return this.languageModel;
    }

    @Nullable
    public final String getPerseusClientId() {
        return this.perseusClientId;
    }

    @Nullable
    public final String getPersuesHitMatchId() {
        return this.persuesHitMatchId;
    }

    @Nullable
    public final String getPersuesSessionId() {
        return this.persuesSessionId;
    }

    @Nullable
    public final FlutterArea getSelectedArea() {
        return this.selectedArea;
    }

    @Nullable
    public final String getToken() {
        return this.token;
    }

    @NotNull
    public final String getTraceIdForNullCountry() {
        return this.traceIdForNullCountry;
    }

    public int hashCode() {
        int hashCode = this.env.hashCode() * 31;
        String str = this.token;
        int i11 = 0;
        int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.lang.hashCode()) * 31;
        FlutterCustomerInfo flutterCustomerInfo = this.customer;
        int hashCode3 = (hashCode2 + (flutterCustomerInfo == null ? 0 : flutterCustomerInfo.hashCode())) * 31;
        FlutterCountryInfo flutterCountryInfo = this.country;
        int hashCode4 = (hashCode3 + (flutterCountryInfo == null ? 0 : flutterCountryInfo.hashCode())) * 31;
        FlutterArea flutterArea = this.selectedArea;
        int hashCode5 = (hashCode4 + (flutterArea == null ? 0 : flutterArea.hashCode())) * 31;
        String str2 = this.perseusClientId;
        int hashCode6 = (hashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.persuesSessionId;
        int hashCode7 = (hashCode6 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.persuesHitMatchId;
        int hashCode8 = (hashCode7 + (str4 == null ? 0 : str4.hashCode())) * 31;
        FlutterLanguage flutterLanguage = this.languageModel;
        int hashCode9 = (((hashCode8 + (flutterLanguage == null ? 0 : flutterLanguage.hashCode())) * 31) + this.appInfo.hashCode()) * 31;
        String str5 = this.deviceID;
        int hashCode10 = (hashCode9 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.deviceVersion;
        if (str6 != null) {
            i11 = str6.hashCode();
        }
        int hashCode11 = (((((hashCode10 + i11) * 31) + this.googleClientId.hashCode()) * 31) + this.traceIdForNullCountry.hashCode()) * 31;
        boolean z11 = this.isDatalayerEnabled;
        if (z11) {
            z11 = true;
        }
        return ((hashCode11 + (z11 ? 1 : 0)) * 31) + this.datalayerKey.hashCode();
    }

    public final boolean isDatalayerEnabled() {
        return this.isDatalayerEnabled;
    }

    @NotNull
    public String toString() {
        String str = this.env;
        String str2 = this.token;
        String str3 = this.lang;
        FlutterCustomerInfo flutterCustomerInfo = this.customer;
        FlutterCountryInfo flutterCountryInfo = this.country;
        FlutterArea flutterArea = this.selectedArea;
        String str4 = this.perseusClientId;
        String str5 = this.persuesSessionId;
        String str6 = this.persuesHitMatchId;
        FlutterLanguage flutterLanguage = this.languageModel;
        FlutterAppInfo flutterAppInfo = this.appInfo;
        String str7 = this.deviceID;
        String str8 = this.deviceVersion;
        String str9 = this.googleClientId;
        String str10 = this.traceIdForNullCountry;
        boolean z11 = this.isDatalayerEnabled;
        String str11 = this.datalayerKey;
        return "FlutterConfig(env=" + str + ", token=" + str2 + ", lang=" + str3 + ", customer=" + flutterCustomerInfo + ", country=" + flutterCountryInfo + ", selectedArea=" + flutterArea + ", perseusClientId=" + str4 + ", persuesSessionId=" + str5 + ", persuesHitMatchId=" + str6 + ", languageModel=" + flutterLanguage + ", appInfo=" + flutterAppInfo + ", deviceID=" + str7 + ", deviceVersion=" + str8 + ", googleClientId=" + str9 + ", traceIdForNullCountry=" + str10 + ", isDatalayerEnabled=" + z11 + ", datalayerKey=" + str11 + ")";
    }
}
