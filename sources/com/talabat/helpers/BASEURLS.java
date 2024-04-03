package com.talabat.helpers;

import com.talabat.core.buildconfig.TalabatEnvironment;
import com.talabat.talabatcommon.feature.walletCardManagement.network.WalletCardManagementBaseUrl;

public class BASEURLS {
    public static final String BASE_URL_FOR_WALLET_TESTING = "https://api.talabat.com/apiAndroid/";

    public static String buildBaseUrl(String str) {
        TalabatEnvironment talabatEnvironment = TalabatEnvironment.INSTANCE;
        if (shouldUseProductionURLs(str, talabatEnvironment.getEnvironment())) {
            return "https://api.talabat.com/apiAndroid/";
        }
        if (shouldUseMockServerUrls(talabatEnvironment.getEnvironment())) {
            return "http://localhost:8000/";
        }
        if (str.equals("debug")) {
            return WalletCardManagementBaseUrl.BASE_URL_QA;
        }
        return "https://api.talabat.com/apiAndroid/";
    }

    public static String buildBaseUrlForCashBack(String str) {
        if (shouldUseProductionURLs(str, TalabatEnvironment.INSTANCE.getEnvironment())) {
            return "https://walletcb.talabat.com/";
        }
        if (str.equals("debug")) {
            return " https://walletcb-qa.dhhmena.com/";
        }
        return "";
    }

    public static String buildRootUrl(String str) {
        TalabatEnvironment talabatEnvironment = TalabatEnvironment.INSTANCE;
        if (shouldUseProductionURLs(str, talabatEnvironment.getEnvironment())) {
            return "https://api.talabat.com/";
        }
        if (shouldUseMockServerUrls(talabatEnvironment.getEnvironment())) {
            return "http://localhost:8000/";
        }
        if (str.equals("debug")) {
            return "https://qa.talabat.com/";
        }
        return "https://api.talabat.com/";
    }

    public static String buildRootUrlForWalletSquad(String str) {
        TalabatEnvironment talabatEnvironment = TalabatEnvironment.INSTANCE;
        if (shouldUseProductionURLs(str, talabatEnvironment.getEnvironment())) {
            return "https://walletapi.talabat.com/";
        }
        if (shouldUseMockServerUrls(talabatEnvironment.getEnvironment())) {
            return "http://localhost:8000/";
        }
        if (str.equals("debug")) {
            return "https://walletapi-qa.dhhmena.com/";
        }
        return "";
    }

    public static String buildSf(String str) {
        TalabatEnvironment talabatEnvironment = TalabatEnvironment.INSTANCE;
        if (shouldUseProductionURLs(str, talabatEnvironment.getEnvironment())) {
            return "https://www.talabat.com/";
        }
        if (shouldUseMockServerUrls(talabatEnvironment.getEnvironment())) {
            return "http://localhost:8000/";
        }
        str.equals("debug");
        return "https://qa.talabat.com/";
    }

    public static String buildUserLocationBaseURL(String str) {
        TalabatEnvironment talabatEnvironment = TalabatEnvironment.INSTANCE;
        if (shouldUseProductionURLs(str, talabatEnvironment.getEnvironment())) {
            return "https://userlocation.talabat.com/api/";
        }
        if (shouldUseMockServerUrls(talabatEnvironment.getEnvironment())) {
            return "http://localhost:8000/";
        }
        return "https://userlocation-qa.dhhmena.com/api/";
    }

    public static String getBaseUrlForCardManagement(String str) {
        TalabatEnvironment talabatEnvironment = TalabatEnvironment.INSTANCE;
        if (shouldUseProductionURLs(str, talabatEnvironment.getEnvironment())) {
            return "https://api.talabat.com/apiAndroid/";
        }
        if (shouldUseMockServerUrls(talabatEnvironment.getEnvironment())) {
            return "http://localhost:8000/";
        }
        if (str.equals("debug")) {
            return WalletCardManagementBaseUrl.BASE_URL_QA;
        }
        return "https://api.talabat.com/apiAndroid/";
    }

    public static String getBaseUrlForPerseus() {
        if (shouldUseProductionURLs("release", TalabatEnvironment.INSTANCE.getEnvironment())) {
            return "https://perseus-productanalytics.deliveryhero.net/";
        }
        return "https://stg-perseus-productanalytics.deliveryhero.net/";
    }

    public static String getBaseurl() {
        return buildBaseUrl("release");
    }

    public static String getBaseurlForCashback(String str) {
        return shouldUseProductionURLs(str, TalabatEnvironment.INSTANCE.getEnvironment()) ? "https://walletcb.talabat.com/api/" : "https://walletcb-qa.talabat.com/api/";
    }

    public static String getCheckoutBaseUrl() {
        return buildRootUrl("release");
    }

    public static boolean shouldUseMockServerUrls(String str) {
        return str.equals("mock");
    }

    public static boolean shouldUseProductionURLs(String str, String str2) {
        if (str.equals("release") || str2.equals("prod")) {
            return true;
        }
        return false;
    }
}
