package com.huawei.location.lite.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.grs.LocationNlpGrsHelper;
import com.huawei.location.lite.common.log.LogConsole;
import java.util.Locale;

public class TelephonyUtil {
    public static final String CN_MCC_CODE = "460";
    public static final String DEFAULT_NO_COUNTRY = "UNKNOWN";
    private static final String SPECIAL_COUNTRYCODE_CN = "cn";
    private static final String SPECIAL_COUNTRYCODE_EU = "eu";
    private static final String SPECIAL_COUNTRYCODE_LA = "la";
    private static final String TAG = "TelephonyUtil";

    private TelephonyUtil() {
    }

    public static boolean checkWLANScan(@NonNull Context context) {
        try {
            Object systemService = context.getApplicationContext().getSystemService("wifi");
            if (systemService instanceof WifiManager) {
                return ((WifiManager) systemService).isScanAlwaysAvailable();
            }
            return false;
        } catch (Exception unused) {
            LogConsole.e(TAG, "isWLANScan error, system exception");
            return false;
        }
    }

    public static boolean checkWifiIsEnable(@NonNull Context context) {
        try {
            Object systemService = context.getApplicationContext().getSystemService("wifi");
            if (systemService instanceof WifiManager) {
                return ((WifiManager) systemService).isWifiEnabled();
            }
            return false;
        } catch (Exception unused) {
            LogConsole.e(TAG, "checkWifiIsEnable exception");
            return false;
        }
    }

    private static String checkedCountryCode(String str) {
        return (TextUtils.isEmpty(str) || str.length() != 2) ? "" : str;
    }

    private static String getCarMcc() {
        String str;
        if (DeviceInfoUtil.getDeviceFeature(ContextUtil.getContext()) != 8) {
            str = "not car";
        } else {
            String locationIPAddress = LocationNlpGrsHelper.getLocationIPAddress();
            if (TextUtils.isEmpty(locationIPAddress)) {
                str = "getCarMcc--getLocationIPAddress--host is empty";
            } else if (locationIPAddress.contains(SPECIAL_COUNTRYCODE_CN)) {
                return CN_MCC_CODE;
            } else {
                str = "getCarMcc--host is empty";
            }
        }
        LogConsole.e(TAG, str);
        return "";
    }

    public static String getDeviceLocaleCountryCode() {
        try {
            return checkedCountryCode(Locale.getDefault().getCountry());
        } catch (Exception unused) {
            LogConsole.e(TAG, "getLocalCountryCode exception", true);
            return "";
        }
    }

    public static String getMcc() {
        if (isAirplaneModeOn()) {
            LogConsole.d(TAG, "airplaneMode on, no mcc");
            return getCarMcc();
        }
        Object systemService = ContextUtil.getHMSContext().getApplicationContext().getSystemService("phone");
        if (systemService == null) {
            LogConsole.d(TAG, "systemService is null");
            return getCarMcc();
        }
        String str = null;
        TelephonyManager telephonyManager = systemService instanceof TelephonyManager ? (TelephonyManager) systemService : null;
        if (telephonyManager == null) {
            LogConsole.d(TAG, "no TelephonyManager");
            return getCarMcc();
        }
        if (telephonyManager.getPhoneType() != 2) {
            str = telephonyManager.getNetworkOperator();
        } else if (telephonyManager.getSimState() == 5 && !telephonyManager.isNetworkRoaming()) {
            str = telephonyManager.getSimOperator();
        }
        if (str != null && str.length() >= 3) {
            return str.substring(0, 3);
        }
        LogConsole.e(TAG, "mcc is Empty");
        return getCarMcc();
    }

    public static String getNetworkCountryCode() {
        Object systemService;
        try {
            if (hasNoSimCard() || (systemService = ContextUtil.getHMSContext().getApplicationContext().getSystemService("phone")) == null || !(systemService instanceof TelephonyManager)) {
                return "";
            }
            TelephonyManager telephonyManager = (TelephonyManager) systemService;
            return telephonyManager.getPhoneType() != 2 ? checkedCountryCode(telephonyManager.getNetworkCountryIso()) : "";
        } catch (Exception unused) {
            LogConsole.e(TAG, "getNetworkCountryCode exception", true);
            return "";
        }
    }

    public static String getRegionLocalCountryCode() {
        String proRegion = SystemPropertiesUtil.getProRegion();
        if (SPECIAL_COUNTRYCODE_CN.equalsIgnoreCase(proRegion)) {
            return proRegion;
        }
        LogConsole.w(TAG, "countryCode from system language is not reliable.");
        return null;
    }

    public static String getSimCountryCode() {
        try {
            Object systemService = ContextUtil.getHMSContext().getApplicationContext().getSystemService("phone");
            if (!(systemService instanceof TelephonyManager)) {
                return "";
            }
            TelephonyManager telephonyManager = (TelephonyManager) systemService;
            return checkedCountryCode(telephonyManager.getSimState() == 5 ? telephonyManager.getSimCountryIso() : null);
        } catch (Exception unused) {
            LogConsole.e(TAG, "getSimCountryCode exception", true);
            return "";
        }
    }

    public static String getVendorCountryCode() {
        try {
            String str = SystemPropertiesUtil.get("ro.hw.country", "UNKNOWN");
            return (SPECIAL_COUNTRYCODE_EU.equalsIgnoreCase(str) || SPECIAL_COUNTRYCODE_LA.equalsIgnoreCase(str)) ? "" : checkedCountryCode(str);
        } catch (Exception unused) {
            LogConsole.e(TAG, "getVendorCountryCode exception", true);
            return "";
        }
    }

    public static boolean hasNoSimCard() {
        Object systemService = ContextUtil.getHMSContext().getApplicationContext().getSystemService("phone");
        boolean z11 = false;
        if (systemService instanceof TelephonyManager) {
            int simState = ((TelephonyManager) systemService).getSimState();
            if (simState == 0 || simState == 1 || simState == 2 || simState == 3 || simState == 6 || simState == 7 || simState == 8) {
                z11 = true;
            }
            LogConsole.d(TAG, "simState:" + simState);
        }
        return z11;
    }

    @TargetApi(17)
    public static boolean isAirplaneModeOn() {
        return Settings.Global.getInt(ContextUtil.getContext().getApplicationContext().getContentResolver(), "airplane_mode_on", 0) != 0;
    }

    @TargetApi(17)
    public static boolean isAirplaneModeOn(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 0;
    }

    public static boolean isSimNetworkRoaming() {
        try {
            Object systemService = ContextUtil.getHMSContext().getApplicationContext().getSystemService("phone");
            if (systemService instanceof TelephonyManager) {
                return ((TelephonyManager) systemService).isNetworkRoaming();
            }
            return false;
        } catch (Exception unused) {
            LogConsole.e(TAG, "isSimRoaming exception", true);
            return false;
        }
    }
}
