package com.talabat.core.tracking.data.constant;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b)\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010,\u001a\u00020\u0001*\u00020\u0001H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001a\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010 \u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010!\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\"\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010#\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010$\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010%\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010&\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010'\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010(\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010)\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010*\u001a\u00020+X\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"ADJUST_AD_GROUP", "", "ADJUST_AD_ID", "ADJUST_APP_VERSION", "ADJUST_AREA_ID", "ADJUST_CAMPAIGN", "ADJUST_CITY_ID", "ADJUST_COUNTRY", "ADJUST_CREATIVE", "ADJUST_LABEL", "ADJUST_LANGUAGE", "ADJUST_NETWORK", "ADJUST_TRACKER_TOKEN", "ADJUST_USER_ID", "CLIENT_ID", "CUSTOMER_CODE", "DEEPLINK", "DEEPLINK_CAMPAIGN", "DEEPLINK_MEDIUM", "DEEPLINK_SOURCE", "DEEPLINK_UTM_CAMPAIGN", "DEEPLINK_UTM_CONTENT", "DEEPLINK_UTM_ID", "DEEPLINK_UTM_MEDIUM", "DEEPLINK_UTM_SOURCE", "DEEPLINK_UTM_TERM", "FEATURE_NAME", "GOOGLE_AD_ID", "HIT_MATCH_ID", "HUAWEI_OAID", "IS_USER_LOGGED_IN", "LOCATION_ADDRESS", "LOCATION_AREA", "LOCATION_CITY", "LOCATION_COUNTRY", "LOCATION_LATITUDE", "LOCATION_LONGITUDE", "PRE_RELEASE_VERSION", "SELECTED_LANGUAGE", "SESSION_ID", "USER_ID", "USER_TIME_STAMP", "camelRegex", "Lkotlin/text/Regex;", "toSnakeCase", "com_talabat_core_tracking_data_data"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ConstantsKt {
    @NotNull
    public static final String ADJUST_AD_GROUP = "adjustAdgroup";
    @NotNull
    public static final String ADJUST_AD_ID = "adjustAdid";
    @NotNull
    public static final String ADJUST_APP_VERSION = "app_version";
    @NotNull
    public static final String ADJUST_AREA_ID = "area_id";
    @NotNull
    public static final String ADJUST_CAMPAIGN = "adjustCampaign";
    @NotNull
    public static final String ADJUST_CITY_ID = "city_id";
    @NotNull
    public static final String ADJUST_COUNTRY = "country";
    @NotNull
    public static final String ADJUST_CREATIVE = "adjustCreative";
    @NotNull
    public static final String ADJUST_LABEL = "adjustLabel";
    @NotNull
    public static final String ADJUST_LANGUAGE = "language";
    @NotNull
    public static final String ADJUST_NETWORK = "adjustNetwork";
    @NotNull
    public static final String ADJUST_TRACKER_TOKEN = "adjustTrackerToken";
    @NotNull
    public static final String ADJUST_USER_ID = "user_id";
    @NotNull
    public static final String CLIENT_ID = "perseusClientId";
    @NotNull
    public static final String CUSTOMER_CODE = "customerCode";
    @NotNull
    public static final String DEEPLINK = "deeplink";
    @NotNull
    public static final String DEEPLINK_CAMPAIGN = "campaign";
    @NotNull
    public static final String DEEPLINK_MEDIUM = "medium";
    @NotNull
    public static final String DEEPLINK_SOURCE = "source";
    @NotNull
    public static final String DEEPLINK_UTM_CAMPAIGN = "utm_campaign";
    @NotNull
    public static final String DEEPLINK_UTM_CONTENT = "utm_content";
    @NotNull
    public static final String DEEPLINK_UTM_ID = "utm_id";
    @NotNull
    public static final String DEEPLINK_UTM_MEDIUM = "utm_medium";
    @NotNull
    public static final String DEEPLINK_UTM_SOURCE = "utm_source";
    @NotNull
    public static final String DEEPLINK_UTM_TERM = "utm_term";
    @NotNull
    public static final String FEATURE_NAME = "featureName";
    @NotNull
    public static final String GOOGLE_AD_ID = "advertisingId";
    @NotNull
    public static final String HIT_MATCH_ID = "perseusHitMatchId";
    @NotNull
    public static final String HUAWEI_OAID = "huaweiOaid";
    @NotNull
    public static final String IS_USER_LOGGED_IN = "userLoggedIn";
    @NotNull
    public static final String LOCATION_ADDRESS = "locationAddress";
    @NotNull
    public static final String LOCATION_AREA = "locationArea";
    @NotNull
    public static final String LOCATION_CITY = "locationCity";
    @NotNull
    public static final String LOCATION_COUNTRY = "locationCountry";
    @NotNull
    public static final String LOCATION_LATITUDE = "locationLat";
    @NotNull
    public static final String LOCATION_LONGITUDE = "locationLon";
    @NotNull
    public static final String PRE_RELEASE_VERSION = "prereleaseVersion";
    @NotNull
    public static final String SELECTED_LANGUAGE = "languageSelected";
    @NotNull
    public static final String SESSION_ID = "perseusSessionId";
    @NotNull
    public static final String USER_ID = "userId";
    @NotNull
    public static final String USER_TIME_STAMP = "userTimeStamp";
    @NotNull
    private static final Regex camelRegex = new Regex("(?<=[a-zA-Z])[A-Z]");

    @NotNull
    public static final String toSnakeCase(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        String replace = camelRegex.replace((CharSequence) str, (Function1<? super MatchResult, ? extends CharSequence>) ConstantsKt$toSnakeCase$1.INSTANCE);
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        String lowerCase = replace.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }
}
