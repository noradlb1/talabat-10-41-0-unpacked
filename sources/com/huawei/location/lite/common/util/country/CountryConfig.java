package com.huawei.location.lite.common.util.country;

import com.google.android.gms.ads.RequestConfiguration;
import com.google.zxing.client.result.ExpandedProductParsedResult;
import com.huawei.wearengine.sensor.Sensor;
import com.newrelic.agent.android.Agent;
import com.visa.checkout.Profile;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class CountryConfig {
    public static final String DEFAULT_DR_NAME = "DR3";
    private static final List<String> DR1 = Arrays.asList(new String[]{Profile.Country.CN});
    public static final String DR1_NAME = "DR1";
    private static final List<String> DR2 = Arrays.asList(new String[]{Profile.Country.AE, "AF", "AG", "AI", "AM", "AO", "AQ", Profile.Country.AR, "AS", "AW", "AZ", "BB", "BD", "BF", "BH", "BI", "BJ", "BL", "BM", "BN", "BO", Profile.Country.BR, "BS", "BT", "BV", "BW", "BY", "BZ", "CC", "CD", "CF", "CG", "CI", "CK", Profile.Country.CL, "CM", Profile.Country.CO, "CR", "CU", "CV", "CX", "DJ", "DM", "DO", "DZ", "EC", "EG", "EH", "ER", "ET", "FJ", "FK", "FM", "GA", "GD", "GE", "GF", "GH", "GM", "GN", "GP", "GQ", "GS", "GT", "GU", "GW", "GY", Profile.Country.HK, "HM", "HN", "HT", "ID", Profile.Country.IN, "IO", "IQ", "JM", "JO", "JP", "KE", ExpandedProductParsedResult.KILOGRAM, "KH", "KI", "KM", "KN", "KP", "KR", Profile.Country.KW, "KY", "KZ", "LA", ExpandedProductParsedResult.POUND, "LC", "LK", "LR", "LS", "LY", RequestConfiguration.MAX_AD_CONTENT_RATING_MA, "MG", "MH", "ML", "MM", "MN", "MO", "MP", "MQ", "MR", "MS", "MU", "MV", "MW", Profile.Country.MX, Profile.Country.MY, "MZ", "NA", "NC", "NE", "NF", "NG", "NI", "NP", "NR", "NU", "OM", "PA", Profile.Country.PE, "PF", RequestConfiguration.MAX_AD_CONTENT_RATING_PG, "PH", "PK", "PN", "PR", "PS", "PW", "PY", Profile.Country.QA, "RE", "RW", Profile.Country.SA, "SB", "SC", "SD", Profile.Country.SG, "SH", "SL", "SN", "SO", "SR", "SS", "ST", "SV", "SY", "SZ", "TC", "TD", "TF", "TG", "TH", "TJ", "TK", "TL", "TM", "TN", "TO", "TT", "TV", "TW", "TZ", "UG", "UY", "UZ", "VE", "VG", "VI", "VN", "VU", "WF", "WS", "YE", "YT", Profile.Country.ZA, "ZM", "ZW"});
    public static final String DR2_NAME = "DR2";
    private static final List<String> DR3 = Arrays.asList(new String[]{"AD", "AL", "AN", "AT", Profile.Country.AU, "AX", "BA", "BE", "BG", "BQ", Profile.Country.CA, "CH", "CW", "CY", "CZ", "DE", "DK", "EE", Profile.Country.ES, "FI", "FO", Profile.Country.FR, Profile.Country.GB, "GG", "GI", "GL", "GR", Sensor.NAME_HR, "HU", Profile.Country.IE, "IL", "IM", "IS", "IT", "JE", "LI", "LT", "LU", "LV", "MC", "MD", "ME", "MF", "MK", "MT", "NL", Agent.MONO_INSTRUMENTATION_FLAG, Profile.Country.NZ, Profile.Country.PL, "PM", "PT", "RO", "RS", "SE", "SI", "SJ", "SK", "SM", "SX", "TR", Profile.Country.UA, "UM", Profile.Country.US, "VA", "VC", "XK", "YK", "EU"});
    public static final String DR3_NAME = "DR3";
    private static final List<String> DR4 = Arrays.asList(new String[]{"RU"});
    public static final String DR4_NAME = "DR4";
    private static final String TAG = "CountryConfig";

    public static String country2DR(String str) {
        if (!CountryCodeUtil.isCodeValidate(str)) {
            return "DR3";
        }
        String upperCase = str.toUpperCase(Locale.ENGLISH);
        return DR1.contains(upperCase) ? DR1_NAME : DR2.contains(upperCase) ? DR2_NAME : (!DR3.contains(upperCase) && DR4.contains(upperCase)) ? DR4_NAME : "DR3";
    }

    public static boolean isDR1(String str) {
        return DR1_NAME.equals(country2DR(str));
    }

    public static boolean isDR2(String str) {
        return DR2_NAME.equals(country2DR(str));
    }

    public static boolean isDR3(String str) {
        return "DR3".equals(country2DR(str));
    }

    public static boolean isDR4(String str) {
        return DR4_NAME.equals(country2DR(str));
    }

    public static boolean isDRCountry(String str) {
        if (!CountryCodeUtil.isCodeValidate(str)) {
            return false;
        }
        String upperCase = str.toUpperCase(Locale.ROOT);
        return DR1.contains(upperCase) || DR2.contains(upperCase) || DR3.contains(upperCase) || DR4.contains(upperCase);
    }
}
