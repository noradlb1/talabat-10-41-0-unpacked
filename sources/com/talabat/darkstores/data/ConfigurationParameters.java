package com.talabat.darkstores.data;

import JsonModels.parser.UniversalGson;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.darkstores.data.discovery.model.Point;
import com.talabat.darkstores.feature.Darkstores;
import com.visa.checkout.Profile;
import datamodels.Restaurant;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0018\b\b\u0018\u00002\u00020\u0001B{\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003¢\u0006\u0002\u0010\u0016J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u000fHÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\t\u0010>\u001a\u00020\u0013HÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\tHÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\t\u0010G\u001a\u00020\fHÆ\u0003J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\u0001\u0010I\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u0003HÆ\u0001J\u0013\u0010J\u001a\u00020\u000f2\b\u0010K\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010L\u001a\u00020\u0013HÖ\u0001J\t\u0010M\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0017\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001dR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001dR\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001dR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010(R\u0011\u0010)\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b)\u0010(R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001dR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010-\u001a\u00020.¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001dR\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001dR\u0011\u00103\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u001dR\u0011\u00105\u001a\u000206¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0011\u00109\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u001d¨\u0006N"}, d2 = {"Lcom/talabat/darkstores/data/ConfigurationParameters;", "", "restaurantJson", "", "countryCode", "languageCode", "currencyCode", "djiniGlobalEntityId", "location", "Lcom/talabat/darkstores/data/discovery/model/Point;", "customerId", "environment", "Lcom/talabat/darkstores/data/Environment;", "searchTerm", "isFromDeeplink", "", "darkstoresTrackingData", "Lcom/talabat/darkstores/feature/Darkstores$DarkstoresTrackingData;", "deeplinkType", "", "eventOrigin", "experimentKey", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/talabat/darkstores/data/discovery/model/Point;Ljava/lang/String;Lcom/talabat/darkstores/data/Environment;Ljava/lang/String;ZLcom/talabat/darkstores/feature/Darkstores$DarkstoresTrackingData;ILjava/lang/String;Ljava/lang/String;)V", "branchId", "getBranchId", "()I", "chainId", "getChainId", "getCountryCode", "()Ljava/lang/String;", "getCurrencyCode", "getCustomerId", "getDarkstoresTrackingData", "()Lcom/talabat/darkstores/feature/Darkstores$DarkstoresTrackingData;", "getDeeplinkType", "getDjiniGlobalEntityId", "getEnvironment", "()Lcom/talabat/darkstores/data/Environment;", "getEventOrigin", "getExperimentKey", "()Z", "isMigrated", "getLanguageCode", "getLocation", "()Lcom/talabat/darkstores/data/discovery/model/Point;", "restaurant", "Ldatamodels/Restaurant;", "getRestaurant", "()Ldatamodels/Restaurant;", "getRestaurantJson", "getSearchTerm", "sessionId", "getSessionId", "talabatVendorInfo", "Lcom/talabat/darkstores/data/TalabatVendorInfo;", "getTalabatVendorInfo", "()Lcom/talabat/darkstores/data/TalabatVendorInfo;", "vendorCode", "getVendorCode", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ConfigurationParameters {
    private final int branchId;
    private final int chainId;
    @NotNull
    private final String countryCode;
    @NotNull
    private final String currencyCode;
    @NotNull
    private final String customerId;
    @Nullable
    private final Darkstores.DarkstoresTrackingData darkstoresTrackingData;
    private final int deeplinkType;
    @NotNull
    private final String djiniGlobalEntityId;
    @NotNull
    private final Environment environment;
    @NotNull
    private final String eventOrigin;
    @NotNull
    private final String experimentKey;
    private final boolean isFromDeeplink;
    private final boolean isMigrated;
    @NotNull
    private final String languageCode;
    @NotNull
    private final Point location;
    @NotNull
    private final Restaurant restaurant;
    @NotNull
    private final String restaurantJson;
    @NotNull
    private final String searchTerm;
    @NotNull
    private final String sessionId;
    @NotNull
    private final TalabatVendorInfo talabatVendorInfo;
    @NotNull
    private final String vendorCode;

    public ConfigurationParameters(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull Point point, @NotNull String str6, @NotNull Environment environment2, @NotNull String str7, boolean z11, @Nullable Darkstores.DarkstoresTrackingData darkstoresTrackingData2, int i11, @NotNull String str8, @NotNull String str9) {
        Intrinsics.checkNotNullParameter(str, "restaurantJson");
        Intrinsics.checkNotNullParameter(str2, "countryCode");
        Intrinsics.checkNotNullParameter(str3, RemoteConfigConstants.RequestFieldKey.LANGUAGE_CODE);
        Intrinsics.checkNotNullParameter(str4, "currencyCode");
        Intrinsics.checkNotNullParameter(str5, "djiniGlobalEntityId");
        Intrinsics.checkNotNullParameter(point, "location");
        Intrinsics.checkNotNullParameter(str6, "customerId");
        Intrinsics.checkNotNullParameter(environment2, Profile.ENVIRONMENT);
        Intrinsics.checkNotNullParameter(str7, "searchTerm");
        Intrinsics.checkNotNullParameter(str8, "eventOrigin");
        Intrinsics.checkNotNullParameter(str9, "experimentKey");
        this.restaurantJson = str;
        this.countryCode = str2;
        this.languageCode = str3;
        this.currencyCode = str4;
        this.djiniGlobalEntityId = str5;
        this.location = point;
        this.customerId = str6;
        this.environment = environment2;
        this.searchTerm = str7;
        this.isFromDeeplink = z11;
        this.darkstoresTrackingData = darkstoresTrackingData2;
        this.deeplinkType = i11;
        this.eventOrigin = str8;
        this.experimentKey = str9;
        Gson gson = UniversalGson.INSTANCE.gson;
        Class cls = Restaurant.class;
        Object fromJson = !(gson instanceof Gson) ? gson.fromJson(str, cls) : GsonInstrumentation.fromJson(gson, str, cls);
        Intrinsics.checkNotNullExpressionValue(fromJson, "INSTANCE.gson.fromJson(\n…taurant::class.java\n    )");
        Restaurant restaurant2 = (Restaurant) fromJson;
        this.restaurant = restaurant2;
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        this.sessionId = uuid;
        this.vendorCode = String.valueOf(restaurant2.branchId);
        this.chainId = restaurant2.f13872id;
        this.branchId = restaurant2.branchId;
        String str10 = restaurant2.f13873name;
        Intrinsics.checkNotNullExpressionValue(str10, "restaurant.name");
        this.talabatVendorInfo = new TalabatVendorInfo(str10);
        this.isMigrated = restaurant2.isMigrated;
    }

    public static /* synthetic */ ConfigurationParameters copy$default(ConfigurationParameters configurationParameters, String str, String str2, String str3, String str4, String str5, Point point, String str6, Environment environment2, String str7, boolean z11, Darkstores.DarkstoresTrackingData darkstoresTrackingData2, int i11, String str8, String str9, int i12, Object obj) {
        ConfigurationParameters configurationParameters2 = configurationParameters;
        int i13 = i12;
        return configurationParameters.copy((i13 & 1) != 0 ? configurationParameters2.restaurantJson : str, (i13 & 2) != 0 ? configurationParameters2.countryCode : str2, (i13 & 4) != 0 ? configurationParameters2.languageCode : str3, (i13 & 8) != 0 ? configurationParameters2.currencyCode : str4, (i13 & 16) != 0 ? configurationParameters2.djiniGlobalEntityId : str5, (i13 & 32) != 0 ? configurationParameters2.location : point, (i13 & 64) != 0 ? configurationParameters2.customerId : str6, (i13 & 128) != 0 ? configurationParameters2.environment : environment2, (i13 & 256) != 0 ? configurationParameters2.searchTerm : str7, (i13 & 512) != 0 ? configurationParameters2.isFromDeeplink : z11, (i13 & 1024) != 0 ? configurationParameters2.darkstoresTrackingData : darkstoresTrackingData2, (i13 & 2048) != 0 ? configurationParameters2.deeplinkType : i11, (i13 & 4096) != 0 ? configurationParameters2.eventOrigin : str8, (i13 & 8192) != 0 ? configurationParameters2.experimentKey : str9);
    }

    @NotNull
    public final String component1() {
        return this.restaurantJson;
    }

    public final boolean component10() {
        return this.isFromDeeplink;
    }

    @Nullable
    public final Darkstores.DarkstoresTrackingData component11() {
        return this.darkstoresTrackingData;
    }

    public final int component12() {
        return this.deeplinkType;
    }

    @NotNull
    public final String component13() {
        return this.eventOrigin;
    }

    @NotNull
    public final String component14() {
        return this.experimentKey;
    }

    @NotNull
    public final String component2() {
        return this.countryCode;
    }

    @NotNull
    public final String component3() {
        return this.languageCode;
    }

    @NotNull
    public final String component4() {
        return this.currencyCode;
    }

    @NotNull
    public final String component5() {
        return this.djiniGlobalEntityId;
    }

    @NotNull
    public final Point component6() {
        return this.location;
    }

    @NotNull
    public final String component7() {
        return this.customerId;
    }

    @NotNull
    public final Environment component8() {
        return this.environment;
    }

    @NotNull
    public final String component9() {
        return this.searchTerm;
    }

    @NotNull
    public final ConfigurationParameters copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull Point point, @NotNull String str6, @NotNull Environment environment2, @NotNull String str7, boolean z11, @Nullable Darkstores.DarkstoresTrackingData darkstoresTrackingData2, int i11, @NotNull String str8, @NotNull String str9) {
        String str10 = str;
        Intrinsics.checkNotNullParameter(str10, "restaurantJson");
        String str11 = str2;
        Intrinsics.checkNotNullParameter(str11, "countryCode");
        String str12 = str3;
        Intrinsics.checkNotNullParameter(str12, RemoteConfigConstants.RequestFieldKey.LANGUAGE_CODE);
        String str13 = str4;
        Intrinsics.checkNotNullParameter(str13, "currencyCode");
        String str14 = str5;
        Intrinsics.checkNotNullParameter(str14, "djiniGlobalEntityId");
        Point point2 = point;
        Intrinsics.checkNotNullParameter(point2, "location");
        String str15 = str6;
        Intrinsics.checkNotNullParameter(str15, "customerId");
        Environment environment3 = environment2;
        Intrinsics.checkNotNullParameter(environment3, Profile.ENVIRONMENT);
        String str16 = str7;
        Intrinsics.checkNotNullParameter(str16, "searchTerm");
        String str17 = str8;
        Intrinsics.checkNotNullParameter(str17, "eventOrigin");
        String str18 = str9;
        Intrinsics.checkNotNullParameter(str18, "experimentKey");
        return new ConfigurationParameters(str10, str11, str12, str13, str14, point2, str15, environment3, str16, z11, darkstoresTrackingData2, i11, str17, str18);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConfigurationParameters)) {
            return false;
        }
        ConfigurationParameters configurationParameters = (ConfigurationParameters) obj;
        return Intrinsics.areEqual((Object) this.restaurantJson, (Object) configurationParameters.restaurantJson) && Intrinsics.areEqual((Object) this.countryCode, (Object) configurationParameters.countryCode) && Intrinsics.areEqual((Object) this.languageCode, (Object) configurationParameters.languageCode) && Intrinsics.areEqual((Object) this.currencyCode, (Object) configurationParameters.currencyCode) && Intrinsics.areEqual((Object) this.djiniGlobalEntityId, (Object) configurationParameters.djiniGlobalEntityId) && Intrinsics.areEqual((Object) this.location, (Object) configurationParameters.location) && Intrinsics.areEqual((Object) this.customerId, (Object) configurationParameters.customerId) && this.environment == configurationParameters.environment && Intrinsics.areEqual((Object) this.searchTerm, (Object) configurationParameters.searchTerm) && this.isFromDeeplink == configurationParameters.isFromDeeplink && Intrinsics.areEqual((Object) this.darkstoresTrackingData, (Object) configurationParameters.darkstoresTrackingData) && this.deeplinkType == configurationParameters.deeplinkType && Intrinsics.areEqual((Object) this.eventOrigin, (Object) configurationParameters.eventOrigin) && Intrinsics.areEqual((Object) this.experimentKey, (Object) configurationParameters.experimentKey);
    }

    public final int getBranchId() {
        return this.branchId;
    }

    public final int getChainId() {
        return this.chainId;
    }

    @NotNull
    public final String getCountryCode() {
        return this.countryCode;
    }

    @NotNull
    public final String getCurrencyCode() {
        return this.currencyCode;
    }

    @NotNull
    public final String getCustomerId() {
        return this.customerId;
    }

    @Nullable
    public final Darkstores.DarkstoresTrackingData getDarkstoresTrackingData() {
        return this.darkstoresTrackingData;
    }

    public final int getDeeplinkType() {
        return this.deeplinkType;
    }

    @NotNull
    public final String getDjiniGlobalEntityId() {
        return this.djiniGlobalEntityId;
    }

    @NotNull
    public final Environment getEnvironment() {
        return this.environment;
    }

    @NotNull
    public final String getEventOrigin() {
        return this.eventOrigin;
    }

    @NotNull
    public final String getExperimentKey() {
        return this.experimentKey;
    }

    @NotNull
    public final String getLanguageCode() {
        return this.languageCode;
    }

    @NotNull
    public final Point getLocation() {
        return this.location;
    }

    @NotNull
    public final Restaurant getRestaurant() {
        return this.restaurant;
    }

    @NotNull
    public final String getRestaurantJson() {
        return this.restaurantJson;
    }

    @NotNull
    public final String getSearchTerm() {
        return this.searchTerm;
    }

    @NotNull
    public final String getSessionId() {
        return this.sessionId;
    }

    @NotNull
    public final TalabatVendorInfo getTalabatVendorInfo() {
        return this.talabatVendorInfo;
    }

    @NotNull
    public final String getVendorCode() {
        return this.vendorCode;
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((this.restaurantJson.hashCode() * 31) + this.countryCode.hashCode()) * 31) + this.languageCode.hashCode()) * 31) + this.currencyCode.hashCode()) * 31) + this.djiniGlobalEntityId.hashCode()) * 31) + this.location.hashCode()) * 31) + this.customerId.hashCode()) * 31) + this.environment.hashCode()) * 31) + this.searchTerm.hashCode()) * 31;
        boolean z11 = this.isFromDeeplink;
        if (z11) {
            z11 = true;
        }
        int i11 = (hashCode + (z11 ? 1 : 0)) * 31;
        Darkstores.DarkstoresTrackingData darkstoresTrackingData2 = this.darkstoresTrackingData;
        return ((((((i11 + (darkstoresTrackingData2 == null ? 0 : darkstoresTrackingData2.hashCode())) * 31) + this.deeplinkType) * 31) + this.eventOrigin.hashCode()) * 31) + this.experimentKey.hashCode();
    }

    public final boolean isFromDeeplink() {
        return this.isFromDeeplink;
    }

    public final boolean isMigrated() {
        return this.isMigrated;
    }

    @NotNull
    public String toString() {
        String str = this.restaurantJson;
        String str2 = this.countryCode;
        String str3 = this.languageCode;
        String str4 = this.currencyCode;
        String str5 = this.djiniGlobalEntityId;
        Point point = this.location;
        String str6 = this.customerId;
        Environment environment2 = this.environment;
        String str7 = this.searchTerm;
        boolean z11 = this.isFromDeeplink;
        Darkstores.DarkstoresTrackingData darkstoresTrackingData2 = this.darkstoresTrackingData;
        int i11 = this.deeplinkType;
        String str8 = this.eventOrigin;
        String str9 = this.experimentKey;
        return "ConfigurationParameters(restaurantJson=" + str + ", countryCode=" + str2 + ", languageCode=" + str3 + ", currencyCode=" + str4 + ", djiniGlobalEntityId=" + str5 + ", location=" + point + ", customerId=" + str6 + ", environment=" + environment2 + ", searchTerm=" + str7 + ", isFromDeeplink=" + z11 + ", darkstoresTrackingData=" + darkstoresTrackingData2 + ", deeplinkType=" + i11 + ", eventOrigin=" + str8 + ", experimentKey=" + str9 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ConfigurationParameters(java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, com.talabat.darkstores.data.discovery.model.Point r24, java.lang.String r25, com.talabat.darkstores.data.Environment r26, java.lang.String r27, boolean r28, com.talabat.darkstores.feature.Darkstores.DarkstoresTrackingData r29, int r30, java.lang.String r31, java.lang.String r32, int r33, kotlin.jvm.internal.DefaultConstructorMarker r34) {
        /*
            r18 = this;
            r0 = r33
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x000b
            r16 = r2
            goto L_0x000d
        L_0x000b:
            r16 = r31
        L_0x000d:
            r0 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x0014
            r17 = r2
            goto L_0x0016
        L_0x0014:
            r17 = r32
        L_0x0016:
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r21
            r7 = r22
            r8 = r23
            r9 = r24
            r10 = r25
            r11 = r26
            r12 = r27
            r13 = r28
            r14 = r29
            r15 = r30
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.darkstores.data.ConfigurationParameters.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.talabat.darkstores.data.discovery.model.Point, java.lang.String, com.talabat.darkstores.data.Environment, java.lang.String, boolean, com.talabat.darkstores.feature.Darkstores$DarkstoresTrackingData, int, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
