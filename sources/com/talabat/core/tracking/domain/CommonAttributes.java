package com.talabat.core.tracking.domain;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\u0003H&J\b\u0010\r\u001a\u00020\u0003H&J\b\u0010\u000e\u001a\u00020\u0003H&J\b\u0010\u000f\u001a\u00020\u0003H&J\b\u0010\u0010\u001a\u00020\u0003H&J\b\u0010\u0011\u001a\u00020\u0003H&J\b\u0010\u0012\u001a\u00020\u0003H&J\b\u0010\u0013\u001a\u00020\u0003H&J\b\u0010\u0014\u001a\u00020\u0003H&J\b\u0010\u0015\u001a\u00020\u0003H&J\b\u0010\u0016\u001a\u00020\u0003H&J\b\u0010\u0017\u001a\u00020\u0003H&J\b\u0010\u0018\u001a\u00020\u0019H&J\b\u0010\u001a\u001a\u00020\u0003H&J\b\u0010\u001b\u001a\u00020\u0003H&J\b\u0010\u001c\u001a\u00020\u0003H&J\b\u0010\u001d\u001a\u00020\u0003H&J\b\u0010\u001e\u001a\u00020\u0003H&J\b\u0010\u001f\u001a\u00020\u0003H&J\b\u0010 \u001a\u00020\u0003H&J\b\u0010!\u001a\u00020\u0003H&J\b\u0010\"\u001a\u00020#H&J\b\u0010$\u001a\u00020\u0003H&¨\u0006%"}, d2 = {"Lcom/talabat/core/tracking/domain/CommonAttributes;", "", "getAdGroup", "", "getAdId", "getAppVersion", "getCampaign", "getClickLabel", "getClientId", "getCreative", "getCustomerCode", "getDeeplinkCampaign", "getDeeplinkContent", "getDeeplinkId", "getDeeplinkMedium", "getDeeplinkQuery", "getDeeplinkSource", "getDeeplinkTerm", "getGoogleAdId", "getHitMatchId", "getNetwork", "getSelectedAddress", "getSelectedArea", "getSelectedCity", "getSelectedCityId", "", "getSelectedCountry", "getSelectedLanguage", "getSelectedLatitude", "getSelectedLongitude", "getSessionId", "getTrackerToken", "getUserId", "getUserTimeStamp", "isProdBuild", "", "isUserLoggedIn", "com_talabat_core_tracking_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CommonAttributes {
    @NotNull
    String getAdGroup();

    @NotNull
    String getAdId();

    @NotNull
    String getAppVersion();

    @NotNull
    String getCampaign();

    @NotNull
    String getClickLabel();

    @NotNull
    String getClientId();

    @NotNull
    String getCreative();

    @NotNull
    String getCustomerCode();

    @NotNull
    String getDeeplinkCampaign();

    @NotNull
    String getDeeplinkContent();

    @NotNull
    String getDeeplinkId();

    @NotNull
    String getDeeplinkMedium();

    @NotNull
    String getDeeplinkQuery();

    @NotNull
    String getDeeplinkSource();

    @NotNull
    String getDeeplinkTerm();

    @NotNull
    String getGoogleAdId();

    @NotNull
    String getHitMatchId();

    @NotNull
    String getNetwork();

    @NotNull
    String getSelectedAddress();

    @NotNull
    String getSelectedArea();

    @NotNull
    String getSelectedCity();

    int getSelectedCityId();

    @NotNull
    String getSelectedCountry();

    @NotNull
    String getSelectedLanguage();

    @NotNull
    String getSelectedLatitude();

    @NotNull
    String getSelectedLongitude();

    @NotNull
    String getSessionId();

    @NotNull
    String getTrackerToken();

    @NotNull
    String getUserId();

    @NotNull
    String getUserTimeStamp();

    boolean isProdBuild();

    @NotNull
    String isUserLoggedIn();
}
