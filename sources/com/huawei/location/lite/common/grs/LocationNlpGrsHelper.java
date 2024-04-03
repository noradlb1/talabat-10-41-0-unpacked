package com.huawei.location.lite.common.grs;

import android.text.TextUtils;
import com.huawei.hms.commonkit.config.Config;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.GrsClient;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.lite.common.util.DeviceInfoUtil;
import com.huawei.location.lite.common.util.SDKComponentType;
import com.huawei.location.lite.common.util.TelephonyUtil;
import com.huawei.location.lite.common.util.country.CountryCodeUtil;
import com.huawei.location.lite.common.util.country.CountryConfig;
import com.visa.checkout.Profile;
import java.util.Locale;

public class LocationNlpGrsHelper {
    private static final String DEFAULT_DR2_COUNTRY_CODE = "SG";
    private static final String NAMESPACE = "GRS";
    private static final String TAG = "LocationNlpGrsHelper";
    private static final String UNKNOWN = "UNKNOWN";

    private static String finallyRetry(String str, String str2, String str3) {
        if (CountryConfig.isDRCountry(str)) {
            return null;
        }
        if (TextUtils.equals(str2, "com.huawei.hms.location")) {
            return getGrsHostRel("SG", str2, str3);
        }
        if (!TextUtils.equals("UNKNOWN", str) && (TextUtils.equals(str3, LocationNlpGrsServiceEnum.LOG_SERVICE) || TextUtils.equals(str2, LocationNlpGrsServiceEnum.LOG_SERVICE))) {
            return getGrsHostRel("SG", str2, str3);
        }
        if (!TextUtils.equals(str2, LocationNlpGrsServiceEnum.TSMS_SERVICE) || SDKComponentType.getComponentType() != 100) {
            return null;
        }
        return getGrsHostRel("SG", str2, str3);
    }

    private static String getGrsHost(String str, String str2, String str3) {
        String grsHostRel = getGrsHostRel(str, str2, str3);
        return !TextUtils.isEmpty(grsHostRel) ? grsHostRel : finallyRetry(str, str2, str3);
    }

    public static String getGrsHostAddress(String str) {
        return getGrsHostAddress(CountryCodeUtil.getLocationCountryCode(), str, "ROOT");
    }

    public static String getGrsHostAddress(String str, String str2) {
        return getGrsHostAddress(str, str2, "ROOT");
    }

    public static String getGrsHostAddress(String str, String str2, String str3) {
        String str4;
        str2.hashCode();
        char c11 = 65535;
        switch (str2.hashCode()) {
            case -2024253630:
                if (str2.equals(LocationNlpGrsServiceEnum.SITE)) {
                    c11 = 0;
                    break;
                }
                break;
            case -1725663847:
                if (str2.equals(LocationNlpGrsServiceEnum.HIGEO)) {
                    c11 = 1;
                    break;
                }
                break;
            case 394921051:
                if (str2.equals(LocationNlpGrsServiceEnum.HIANALYTICS)) {
                    c11 = 2;
                    break;
                }
                break;
            case 514974498:
                if (str2.equals(LocationNlpGrsServiceEnum.LOG_SERVICE)) {
                    c11 = 3;
                    break;
                }
                break;
            case 979105389:
                if (str2.equals(LocationNlpGrsServiceEnum.MAP_SERVICE)) {
                    c11 = 4;
                    break;
                }
                break;
            case 980023935:
                if (str2.equals(LocationNlpGrsServiceEnum.AGREE_SERVICE)) {
                    c11 = 5;
                    break;
                }
                break;
            case 1753801149:
                if (str2.equals(LocationNlpGrsServiceEnum.OOBE)) {
                    c11 = 6;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
            case 1:
                str4 = getGrsHost(str, "com.huawei.hms.location", str2);
                break;
            case 2:
            case 3:
            case 4:
            case 5:
                str4 = getGrsHost(str, LocationNlpGrsServiceEnum.EXT_SERVICE, str2);
                break;
            case 6:
                str4 = Config.getString(NAMESPACE, String.format(Locale.ENGLISH, "grs://%s/%s", new Object[]{str2, "ROOT"}));
                break;
            default:
                str4 = getGrsHost(str, str2, str3);
                break;
        }
        if (TextUtils.isEmpty(str4) && str2.equals(LocationNlpGrsServiceEnum.LOG_SERVICE) && DeviceInfoUtil.getDeviceFeature(ContextUtil.getContext()) == 8) {
            LogConsole.d(TAG, "host is null,device is car, getMcc()");
            if (TelephonyUtil.CN_MCC_CODE.equals(TelephonyUtil.getMcc())) {
                str4 = getGrsHost(Profile.Country.CN, LocationNlpGrsServiceEnum.EXT_SERVICE, str2);
            }
        }
        LogConsole.d(TAG, "getGrsHostAddress finally serviceName:" + str2 + ", host:" + str4 + ", countryCode:" + str);
        return str4;
    }

    private static String getGrsHostRel(String str, String str2, String str3) {
        String str4;
        if (SDKComponentType.getComponentType() == 100) {
            GrsBaseInfo grsBaseInfo = new GrsBaseInfo();
            if (TextUtils.equals(str2, LocationNlpGrsServiceEnum.SITE) || TextUtils.equals(str2, LocationNlpGrsServiceEnum.HIANALYTICS)) {
                grsBaseInfo.setIssueCountry(str.toUpperCase(Locale.ROOT));
            } else {
                grsBaseInfo.setSerCountry(str.toUpperCase(Locale.ROOT));
            }
            str4 = new GrsClient(ContextUtil.getContext(), grsBaseInfo).synGetGrsUrl(str2, str3);
        } else {
            str4 = Config.getString(NAMESPACE, String.format(Locale.ENGLISH, "grs://%s/%s?serCountry=%s", new Object[]{str2, str3, str}));
        }
        LogConsole.d(TAG, "getGrsHostAddress serviceName:" + str2 + ", host:" + str4 + ", addressesKey:" + str3 + ", countryCode:" + str);
        return str4;
    }

    public static String getLocationIPAddress() {
        return getGrsHostRel("UNKNOWN", "com.huawei.hms.location", "ROOT");
    }
}
