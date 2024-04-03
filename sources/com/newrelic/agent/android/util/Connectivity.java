package com.newrelic.agent.android.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.facebook.internal.ServerProtocol;
import com.newrelic.agent.android.api.common.CarrierType;
import com.newrelic.agent.android.api.common.WanType;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import java.text.MessageFormat;

public final class Connectivity {
    private static final String ANDROID = "Android";
    private static AgentLog log = AgentLogManager.getAgentLog();

    public static String carrierNameFromContext(Context context) {
        try {
            NetworkInfo networkInfo = getNetworkInfo(context);
            if (!isConnected(networkInfo)) {
                return "none";
            }
            if (isHardwired(networkInfo)) {
                return CarrierType.ETHERNET;
            }
            if (isWan(networkInfo)) {
                return carrierNameFromTelephonyManager(context);
            }
            if (isWifi(networkInfo)) {
                return "wifi";
            }
            if (isBluetooth(networkInfo)) {
                return CarrierType.BLUETOOTH;
            }
            log.warn(MessageFormat.format("Unknown network type: {0} [{1}]", new Object[]{networkInfo.getTypeName(), Integer.valueOf(networkInfo.getType())}));
            return "unknown";
        } catch (SecurityException unused) {
        }
    }

    private static String carrierNameFromTelephonyManager(Context context) {
        boolean z11;
        String networkOperatorName = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperatorName();
        if (networkOperatorName == null || networkOperatorName.isEmpty()) {
            return "unknown";
        }
        String str = Build.PRODUCT;
        if (str.equals("google_sdk") || str.equals(ServerProtocol.DIALOG_PARAM_SDK_VERSION) || str.equals("sdk_x86") || Build.FINGERPRINT.startsWith("generic")) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!networkOperatorName.equals("Android") || !z11) {
            return networkOperatorName;
        }
        return "wifi";
    }

    private static String connectionNameFromNetworkSubtype(int i11) {
        switch (i11) {
            case 1:
                return WanType.GPRS;
            case 2:
                return WanType.EDGE;
            case 3:
                return WanType.UMTS;
            case 4:
                return WanType.CDMA;
            case 5:
                return WanType.EVDO_REV_0;
            case 6:
                return WanType.EVDO_REV_A;
            case 7:
                return WanType.RTT;
            case 8:
                return WanType.HSDPA;
            case 9:
                return WanType.HSUPA;
            case 10:
                return WanType.HSPA;
            case 11:
                return WanType.IDEN;
            case 12:
                return WanType.EVDO_REV_B;
            case 13:
                return WanType.LTE;
            case 14:
                return WanType.HRPD;
            case 15:
                return WanType.HSPAP;
            default:
                return "unknown";
        }
    }

    private static NetworkInfo getNetworkInfo(Context context) throws SecurityException {
        try {
            return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException e11) {
            log.warn("Cannot determine network state. Enable android.permission.ACCESS_NETWORK_STATE in your manifest.");
            throw e11;
        }
    }

    private static boolean isBluetooth(NetworkInfo networkInfo) {
        return networkInfo.getType() == 7;
    }

    private static boolean isConnected(NetworkInfo networkInfo) {
        return networkInfo != null && networkInfo.isConnected();
    }

    private static boolean isHardwired(NetworkInfo networkInfo) {
        int type = networkInfo.getType();
        return type == 4 || type == 9;
    }

    private static boolean isWan(NetworkInfo networkInfo) {
        int type = networkInfo.getType();
        return type == 0 || type == 9 || type == 2 || type == 3 || type == 4 || type == 5;
    }

    private static boolean isWifi(NetworkInfo networkInfo) {
        int type = networkInfo.getType();
        return type == 1 || type == 6;
    }

    public static String wanType(Context context) {
        try {
            NetworkInfo networkInfo = getNetworkInfo(context);
            if (!isConnected(networkInfo)) {
                return "none";
            }
            if (isWifi(networkInfo)) {
                return "wifi";
            }
            if (isHardwired(networkInfo)) {
                return connectionNameFromNetworkSubtype(networkInfo.getSubtype());
            }
            if (isWan(networkInfo)) {
                return connectionNameFromNetworkSubtype(networkInfo.getSubtype());
            }
            return "unknown";
        } catch (SecurityException unused) {
        }
    }
}
