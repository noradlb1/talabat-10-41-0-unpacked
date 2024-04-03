package com.huawei.location.lite.common.util.country;

import android.content.Context;
import android.text.TextUtils;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import java.util.Locale;
import net.bytebuddy.utility.JavaConstant;

public class CountryUtil {
    private static final String COUNTRY_KR = "KR";

    private static String getCountry(Context context) {
        return context.getResources().getConfiguration().locale.getCountry().toLowerCase(Locale.getDefault());
    }

    private static String getLanguage(Context context) {
        return context.getResources().getConfiguration().locale.getLanguage().toLowerCase(Locale.getDefault());
    }

    public static String getLanguageCode(Context context) {
        String script = getScript(context);
        String language = getLanguage(context);
        String upperCase = getCountry(context).toUpperCase(Locale.getDefault());
        if (TextUtils.isEmpty(script)) {
            return language + SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE + upperCase;
        }
        return language + SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE + script + SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE + upperCase;
    }

    public static String getLanguageCodeWithoutCountry(Context context) {
        String script = getScript(context);
        String language = getLanguage(context);
        if (TextUtils.isEmpty(script)) {
            return language;
        }
        return language + SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE + script;
    }

    public static String getLanguageForRemoteUri(Context context) {
        String script = getScript(context);
        String language = getLanguage(context);
        String upperCase = getCountry(context).toUpperCase(Locale.getDefault());
        if (TextUtils.isEmpty(script)) {
            return language + JavaConstant.Dynamic.DEFAULT_NAME + upperCase;
        }
        return language + JavaConstant.Dynamic.DEFAULT_NAME + script + JavaConstant.Dynamic.DEFAULT_NAME + upperCase;
    }

    private static String getScript(Context context) {
        return context.getResources().getConfiguration().locale.getScript();
    }

    public static boolean isAALA() {
        return CountryConfig.isDR2(CountryCodeUtil.getPrivacyCountryCode());
    }

    public static boolean isCN() {
        return CountryConfig.isDR1(CountryCodeUtil.getPrivacyCountryCode());
    }

    public static boolean isEU() {
        return CountryConfig.isDR3(CountryCodeUtil.getPrivacyCountryCode());
    }

    public static boolean isKR() {
        return TextUtils.equals(CountryCodeUtil.getPrivacyCountryCode().toUpperCase(Locale.ENGLISH), COUNTRY_KR);
    }

    public static boolean isKR(String str) {
        return TextUtils.equals(str.toUpperCase(Locale.ENGLISH), COUNTRY_KR);
    }

    public static boolean isRU() {
        return CountryConfig.isDR4(CountryCodeUtil.getPrivacyCountryCode());
    }

    public static boolean isRuOrAala() {
        return CountryConfig.isDR2(CountryCodeUtil.getPrivacyCountryCode()) || CountryConfig.isDR4(CountryCodeUtil.getPrivacyCountryCode());
    }
}
