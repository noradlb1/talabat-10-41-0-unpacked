package com.huawei.location.lite.common.util.country;

import android.text.TextUtils;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.lite.common.util.TelephonyUtil;

public class CountryCodeUtil {
    private static final String COUNTRY_CODE_EU = "EU";
    private static final String TAG = "CountryCodeUtil";
    private static final String UNKNOWN = "UNKNOWN";

    public static String getCountryCode() {
        try {
            String networkCountryCode = TelephonyUtil.getNetworkCountryCode();
            if (isCodeValidate(networkCountryCode)) {
                LogConsole.i(TAG, "getCountryCode get country code from NETWORK_ISO_COUNTRY");
                return networkCountryCode;
            }
            String vendorCountryCode = TelephonyUtil.getVendorCountryCode();
            if (isCodeValidate(vendorCountryCode)) {
                LogConsole.i(TAG, "getCountryCode get country code from VENDOR_COUNTRY");
                return vendorCountryCode;
            }
            String simCountryCode = TelephonyUtil.getSimCountryCode();
            if (isCodeValidate(simCountryCode)) {
                LogConsole.i(TAG, "getCountryCode get country code from SIM_COUNTRY");
                return simCountryCode;
            }
            String regionLocalCountryCode = TelephonyUtil.getRegionLocalCountryCode();
            if (isCodeValidate(regionLocalCountryCode)) {
                LogConsole.i(TAG, "getCountryCode get country code from LOCALE_INFO");
                return regionLocalCountryCode;
            }
            String deviceLocaleCountryCode = TelephonyUtil.getDeviceLocaleCountryCode();
            if (isCodeValidate(deviceLocaleCountryCode)) {
                LogConsole.i(TAG, "getCountryCode get country code from device locale");
                return deviceLocaleCountryCode;
            }
            LogConsole.w(TAG, "fail to get grs countryCode");
            LogConsole.i(TAG, "get countryCode is null");
            return "UNKNOWN";
        } catch (Exception unused) {
            LogConsole.w(TAG, "get CountryCode error");
        }
    }

    public static String getGrsIssueCountryCode() {
        String issueCountryCode = GrsApp.getInstance().getIssueCountryCode(ContextUtil.getContext());
        return TextUtils.equals("UNKNOWN", issueCountryCode) ? COUNTRY_CODE_EU : issueCountryCode;
    }

    public static String getLocationCountryCode() {
        String str = "UNKNOWN";
        if (TelephonyUtil.isAirplaneModeOn()) {
            LogConsole.i(TAG, "airplane Mode is on");
            return str;
        }
        String networkCountryCode = TelephonyUtil.getNetworkCountryCode();
        if (TextUtils.isEmpty(networkCountryCode) && !TelephonyUtil.isSimNetworkRoaming()) {
            networkCountryCode = TelephonyUtil.getSimCountryCode();
        }
        if (TextUtils.isEmpty(networkCountryCode)) {
            LogConsole.i(TAG, "get countryCode is UNKNOWN");
        } else {
            str = networkCountryCode;
        }
        LogConsole.d(TAG, "getLocatorCountryCode：" + str);
        return str;
    }

    public static String getNetWorkDr() {
        String networkCountryCode = TelephonyUtil.getNetworkCountryCode();
        return TextUtils.isEmpty(networkCountryCode) ? "" : CountryConfig.country2DR(networkCountryCode);
    }

    public static String getPrivacyCountryCode() {
        try {
            String networkCountryCode = TelephonyUtil.getNetworkCountryCode();
            if (!isCodeValidate(networkCountryCode)) {
                return getGrsIssueCountryCode();
            }
            LogConsole.i(TAG, "getCountryCode get country code from NETWORK_ISO_COUNTRY");
            return networkCountryCode;
        } catch (Exception unused) {
            LogConsole.w(TAG, "get CountryCode error");
            LogConsole.i(TAG, "get countryCode is null");
            return COUNTRY_CODE_EU;
        }
    }

    public static boolean isCodeValidate(String str) {
        return !TextUtils.isEmpty(str) && !"UNKNOWN".equals(str);
    }
}
