package com.talabat.core.tracking.data.common;

import android.content.Context;
import buisnessmodels.Customer;
import com.adjust.sdk.Adjust;
import com.adjust.sdk.AdjustAttribution;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.core.buildconfig.TalabatEnvironment;
import com.talabat.core.tracking.domain.CommonAttributes;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.LoggedInHelper;
import datamodels.CustomerInfo;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tracking.deeplink.DeepLinkParser;
import tracking.deeplink.DeepLinkResult;
import tracking.gtm.TalabatGTM;
import tracking.perseus.TalabatPerseus;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\bH\u0016J\b\u0010\u000e\u001a\u00020\bH\u0016J\b\u0010\u000f\u001a\u00020\bH\u0016J\b\u0010\u0010\u001a\u00020\bH\u0016J\b\u0010\u0011\u001a\u00020\bH\u0016J\b\u0010\u0012\u001a\u00020\bH\u0016J\b\u0010\u0013\u001a\u00020\bH\u0016J\b\u0010\u0014\u001a\u00020\bH\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\bH\u0016J\b\u0010\u0018\u001a\u00020\bH\u0016J\b\u0010\u0019\u001a\u00020\bH\u0016J\b\u0010\u001a\u001a\u00020\bH\u0016J\b\u0010\u001b\u001a\u00020\bH\u0016J\b\u0010\u001c\u001a\u00020\bH\u0016J\b\u0010\u001d\u001a\u00020\bH\u0016J\b\u0010\u001e\u001a\u00020\bH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\bH\u0016J\b\u0010\"\u001a\u00020\bH\u0016J\b\u0010#\u001a\u00020\bH\u0016J\b\u0010$\u001a\u00020\bH\u0016J\b\u0010%\u001a\u00020\bH\u0016J\b\u0010&\u001a\u00020\bH\u0016J\b\u0010'\u001a\u00020\bH\u0016J\b\u0010(\u001a\u00020\bH\u0016J\b\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/talabat/core/tracking/data/common/CommonAttributesImpl;", "Lcom/talabat/core/tracking/domain/CommonAttributes;", "appVersionProvider", "Lcom/talabat/configuration/discovery/AppVersionProvider;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "(Lcom/talabat/configuration/discovery/AppVersionProvider;Lcom/talabat/configuration/ConfigurationLocalRepository;)V", "getAdGroup", "", "getAdId", "getAppVersion", "getCampaign", "getClickLabel", "getClientId", "getCreative", "getCustomerCode", "getDeeplinkCampaign", "getDeeplinkContent", "getDeeplinkId", "getDeeplinkMedium", "getDeeplinkQuery", "getDeeplinkResult", "Ltracking/deeplink/DeepLinkResult;", "getDeeplinkSource", "getDeeplinkTerm", "getGoogleAdId", "getHitMatchId", "getNetwork", "getSelectedAddress", "getSelectedArea", "getSelectedCity", "getSelectedCityId", "", "getSelectedCountry", "getSelectedLanguage", "getSelectedLatitude", "getSelectedLongitude", "getSessionId", "getTrackerToken", "getUserId", "getUserTimeStamp", "isProdBuild", "", "isUserLoggedIn", "com_talabat_core_tracking_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CommonAttributesImpl implements CommonAttributes {
    @NotNull
    private final AppVersionProvider appVersionProvider;
    @NotNull
    private final ConfigurationLocalRepository configurationLocalRepository;

    @Inject
    public CommonAttributesImpl(@NotNull AppVersionProvider appVersionProvider2, @NotNull ConfigurationLocalRepository configurationLocalRepository2) {
        Intrinsics.checkNotNullParameter(appVersionProvider2, "appVersionProvider");
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        this.appVersionProvider = appVersionProvider2;
        this.configurationLocalRepository = configurationLocalRepository2;
    }

    private final DeepLinkResult getDeeplinkResult() {
        boolean z11;
        String deepLinksQuery = GlobalDataModel.getDeepLinksQuery();
        if (deepLinksQuery == null || deepLinksQuery.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return new DeepLinkResult();
        }
        DeepLinkResult parse = DeepLinkParser.parse(deepLinksQuery);
        Intrinsics.checkNotNullExpressionValue(parse, "parse(query)");
        return parse;
    }

    @NotNull
    public String getAdGroup() {
        AdjustAttribution attribution = Adjust.getAttribution();
        return HelperKt.value(attribution != null ? attribution.adgroup : null);
    }

    @NotNull
    public String getAdId() {
        AdjustAttribution attribution = Adjust.getAttribution();
        return HelperKt.value(attribution != null ? attribution.adid : null);
    }

    @NotNull
    public String getAppVersion() {
        String appVersion = this.appVersionProvider.appVersion();
        return appVersion == null ? "" : appVersion;
    }

    @NotNull
    public String getCampaign() {
        AdjustAttribution attribution = Adjust.getAttribution();
        return HelperKt.value(attribution != null ? attribution.campaign : null);
    }

    @NotNull
    public String getClickLabel() {
        AdjustAttribution attribution = Adjust.getAttribution();
        return HelperKt.value(attribution != null ? attribution.clickLabel : null);
    }

    @NotNull
    public String getClientId() {
        String myClientId$default = TalabatPerseus.Companion.getMyClientId$default(TalabatPerseus.Companion, (Context) null, 1, (Object) null);
        return myClientId$default == null ? "" : myClientId$default;
    }

    @NotNull
    public String getCreative() {
        AdjustAttribution attribution = Adjust.getAttribution();
        return HelperKt.value(attribution != null ? attribution.creative : null);
    }

    @NotNull
    public String getCustomerCode() {
        CustomerInfo customerInfo = Customer.getInstance().getCustomerInfo();
        String num = customerInfo != null ? Integer.valueOf(customerInfo.f13850id).toString() : null;
        if (num == null) {
            num = "";
        }
        return HelperKt.value(num);
    }

    @NotNull
    public String getDeeplinkCampaign() {
        return HelperKt.value(getDeeplinkResult().campaign);
    }

    @NotNull
    public String getDeeplinkContent() {
        return HelperKt.value(getDeeplinkResult().getContent());
    }

    @NotNull
    public String getDeeplinkId() {
        return HelperKt.value(getDeeplinkResult().getId());
    }

    @NotNull
    public String getDeeplinkMedium() {
        return HelperKt.value(getDeeplinkResult().medium);
    }

    @NotNull
    public String getDeeplinkQuery() {
        return HelperKt.value(GlobalDataModel.getDeepLinksQuery());
    }

    @NotNull
    public String getDeeplinkSource() {
        return HelperKt.value(getDeeplinkResult().source);
    }

    @NotNull
    public String getDeeplinkTerm() {
        return HelperKt.value(getDeeplinkResult().getTerm());
    }

    @NotNull
    public String getGoogleAdId() {
        return HelperKt.value(GlobalDataModel.googleAdId);
    }

    @NotNull
    public String getHitMatchId() {
        return TalabatPerseus.Companion.getHitMatchId();
    }

    @NotNull
    public String getNetwork() {
        AdjustAttribution attribution = Adjust.getAttribution();
        return HelperKt.value(attribution != null ? attribution.network : null);
    }

    @NotNull
    public String getSelectedAddress() {
        return TalabatGTM.Companion.getLocationAddress$default(TalabatGTM.Companion, (Context) null, 1, (Object) null);
    }

    @NotNull
    public String getSelectedArea() {
        return String.valueOf(GlobalDataModel.SelectedAreaId);
    }

    @NotNull
    public String getSelectedCity() {
        boolean z11;
        String str = GlobalDataModel.SelectedCityName;
        if (str == null || str.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return "N/A";
        }
        String str2 = GlobalDataModel.SelectedCityName;
        Intrinsics.checkNotNullExpressionValue(str2, "{\n            GlobalData…electedCityName\n        }");
        return str2;
    }

    public int getSelectedCityId() {
        return GlobalDataModel.SelectedCityId;
    }

    @NotNull
    public String getSelectedCountry() {
        return this.configurationLocalRepository.selectedCountry().threeLetterCodeUpperCase();
    }

    @NotNull
    public String getSelectedLanguage() {
        return this.configurationLocalRepository.selectedLanguage().getLanguageCode();
    }

    @NotNull
    public String getSelectedLatitude() {
        return TalabatGTM.Companion.getLocationLatitude();
    }

    @NotNull
    public String getSelectedLongitude() {
        return TalabatGTM.Companion.getLocationLongitude();
    }

    @NotNull
    public String getSessionId() {
        String mySessionId = TalabatPerseus.Companion.getMySessionId();
        return mySessionId == null ? "" : mySessionId;
    }

    @NotNull
    public String getTrackerToken() {
        AdjustAttribution attribution = Adjust.getAttribution();
        return HelperKt.value(attribution != null ? attribution.trackerToken : null);
    }

    @NotNull
    public String getUserId() {
        String userId = TalabatGTM.Companion.getUserId();
        return userId == null ? "" : userId;
    }

    @NotNull
    public String getUserTimeStamp() {
        return TalabatGTM.Companion.getCurrentTime();
    }

    public boolean isProdBuild() {
        if (!Intrinsics.areEqual((Object) "release", (Object) "release") || !Intrinsics.areEqual((Object) TalabatEnvironment.INSTANCE.getEnvironment(), (Object) "prod")) {
            return false;
        }
        return true;
    }

    @NotNull
    public String isUserLoggedIn() {
        return LoggedInHelper.isLoggedIn() ? "true" : "false";
    }
}
