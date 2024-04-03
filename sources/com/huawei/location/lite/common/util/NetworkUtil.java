package com.huawei.location.lite.common.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import com.huawei.android.os.BuildEx;
import com.huawei.android.telephony.ServiceStateEx;
import com.huawei.hms.framework.common.EmuiUtil;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.log.LogConsole;

public class NetworkUtil {
    private static final String NETWORK_2G = "2G";
    private static final String NETWORK_3G = "3G";
    private static final String NETWORK_4G = "4G";
    private static final String NETWORK_5G = "5G";
    private static final String NETWORK_NONE = "";
    private static final String NETWORK_WIFI = "wifi";
    private static final String TAG = "NetworkUtil";

    public static final class NetType {
        public static final int TYPE_2G = 2;
        public static final int TYPE_3G = 3;
        public static final int TYPE_4G = 4;
        public static final int TYPE_4G_NSA = 7;
        public static final int TYPE_5G = 5;
        public static final int TYPE_5G_SA = 8;
        public static final int TYPE_MOBILE = 6;
        public static final int TYPE_NO_NETWORK = -1;
        public static final int TYPE_UNKNOWN = 0;
        public static final int TYPE_WIFI = 1;
    }

    @SuppressLint({"MissingPermission", "NewApi"})
    private static int getHwNetworkType(Context context) {
        TelephonyManager telephonyManager;
        String str;
        ServiceState a11;
        if (!(!ReflectionUtils.checkCompatible(EmuiUtil.BUILDEX_VERSION) || context == null || (telephonyManager = (TelephonyManager) getSystemService(context, "phone")) == null)) {
            try {
                if (BuildEx.VERSION.EMUI_SDK_INT >= 21 && (a11 = telephonyManager.getServiceState()) != null) {
                    return ServiceStateEx.getConfigRadioTechnology(a11);
                }
            } catch (SecurityException unused) {
                str = "requires permission maybe missing.";
                LogConsole.w(TAG, str);
                return 0;
            } catch (NoSuchMethodError unused2) {
                str = "NoSuchMethodError occur in method getHwNetworkType.";
                LogConsole.w(TAG, str);
                return 0;
            } catch (NoClassDefFoundError unused3) {
                str = "NoClassDefFoundError occur in method getHwNetworkType.";
                LogConsole.w(TAG, str);
                return 0;
            }
        }
        return 0;
    }

    @SuppressLint({"MissingPermission"})
    private static NetworkInfo getNetworkInfo(Context context) {
        ConnectivityManager connectivityManager;
        if (context == null || (connectivityManager = (ConnectivityManager) getSystemService(context, "connectivity")) == null) {
            return null;
        }
        try {
            return connectivityManager.getActiveNetworkInfo();
        } catch (RuntimeException unused) {
            LogConsole.i(TAG, "getActiveNetworkInfo failed, exception");
            return null;
        }
    }

    public static String getNetworkState() {
        int networkType = getNetworkType(ContextUtil.getContext());
        return networkType != 1 ? networkType != 2 ? networkType != 3 ? networkType != 4 ? networkType != 5 ? "" : NETWORK_5G : NETWORK_4G : NETWORK_3G : NETWORK_2G : "wifi";
    }

    public static int getNetworkType() {
        return getNetworkType(ContextUtil.getContext()) != 1 ? 0 : 1;
    }

    public static int getNetworkType(Context context) {
        int i11;
        NetworkInfo networkInfo = getNetworkInfo(context);
        if (networkInfo == null || !networkInfo.isConnected()) {
            return -1;
        }
        int type = networkInfo.getType();
        if (1 == type || 13 == type) {
            return 1;
        }
        if (type != 0) {
            return 0;
        }
        int hwNetworkType = getHwNetworkType(context);
        LogConsole.i(TAG, "getHwNetworkType return is: " + hwNetworkType);
        if (hwNetworkType == 0) {
            hwNetworkType = networkInfo.getSubtype();
        }
        if (hwNetworkType != 20) {
            switch (hwNetworkType) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    i11 = 2;
                    break;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    i11 = 3;
                    break;
                case 13:
                    i11 = 4;
                    break;
                default:
                    i11 = 0;
                    break;
            }
        } else {
            i11 = 5;
        }
        if (i11 != 0 || Build.VERSION.SDK_INT < 25) {
            return i11;
        }
        if (hwNetworkType != 16) {
            return hwNetworkType != 17 ? 0 : 3;
        }
        return 2;
    }

    private static Object getSystemService(Context context, String str) {
        if (context == null) {
            LogConsole.w(TAG, "context is null");
            return null;
        }
        try {
            return context.getSystemService(str);
        } catch (RuntimeException e11) {
            LogConsole.e(TAG, "SystemServer error:", (Throwable) e11);
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000a, code lost:
        r2 = getNetworkInfo(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isNetworkAvailable(android.content.Context r2) {
        /*
            java.lang.String r0 = "android.permission.ACCESS_NETWORK_STATE"
            boolean r0 = com.huawei.location.lite.common.util.PermissionUtil.checkSelfPermission(r2, r0)
            r1 = 0
            if (r0 != 0) goto L_0x000a
            return r1
        L_0x000a:
            android.net.NetworkInfo r2 = getNetworkInfo(r2)
            if (r2 == 0) goto L_0x0017
            boolean r2 = r2.isConnected()
            if (r2 == 0) goto L_0x0017
            r1 = 1
        L_0x0017:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.lite.common.util.NetworkUtil.isNetworkAvailable(android.content.Context):boolean");
    }
}
