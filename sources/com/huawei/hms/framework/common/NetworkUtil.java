package com.huawei.hms.framework.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.TransportInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.UserManager;
import android.telephony.CellSignalStrengthCdma;
import android.telephony.CellSignalStrengthLte;
import android.telephony.CellSignalStrengthNr;
import android.telephony.CellSignalStrengthTdscdma;
import android.telephony.CellSignalStrengthWcdma;
import android.telephony.HwTelephonyManager;
import android.telephony.SignalStrength;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.huawei.secure.android.common.webview.UriUtil;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class NetworkUtil {
    private static final int INVALID_RSSI = -127;
    private static final String STR_NSA = "5G_NSA";
    private static final String STR_SA = "5G_SA";
    private static final String TAG = "NetworkUtil";
    private static final int TYPE_WIFI_P2P = 13;
    public static final int UNAVAILABLE = Integer.MAX_VALUE;
    public static volatile int networkTypeByReceiver;

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

    public static final class SignalType {
        public static final String LTE_CQI = "lteCqi";
        public static final String LTE_DBM = "lteDbm";
        public static final String LTE_RSRP = "lteRsrp";
        public static final String LTE_RSRQ = "lteRsrq";
        public static final String LTE_RSSI = "lteRssi";
        public static final String LTE_RSSNR = "lteRssnr";
        public static final String NR_CSIRSRP = "nrCSIRsrp";
        public static final String NR_CSIRSRQ = "nrCSIRsrq";
        public static final String NR_CSISINR = "nrCSISinr";
        public static final String NR_DBM = "nrDbm";
        public static final String NR_SSRSRP = "nrSSRsrp";
        public static final String NR_SSRSRQ = "nrSSRsrq";
        public static final String NR_SSSINR = "nrSSSinr";
    }

    public static int getCurrentNetworkType() {
        return networkTypeByReceiver;
    }

    public static String getDnsServerIps(Context context) {
        return Arrays.toString(getDnsServerIpsFromConnectionManager(context));
    }

    @SuppressLint({"MissingPermission"})
    private static String[] getDnsServerIpsFromConnectionManager(Context context) {
        ConnectivityManager connectivityManager;
        LinkProperties linkProperties;
        LinkedList linkedList = new LinkedList();
        if (!(context == null || (connectivityManager = (ConnectivityManager) ContextCompat.getSystemService(context, "connectivity")) == null)) {
            try {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    for (Network network : connectivityManager.getAllNetworks()) {
                        if (network != null) {
                            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(network);
                            if (!(networkInfo == null || networkInfo.getType() != activeNetworkInfo.getType() || (linkProperties = connectivityManager.getLinkProperties(network)) == null)) {
                                for (InetAddress hostAddress : linkProperties.getDnsServers()) {
                                    linkedList.add(hostAddress.getHostAddress());
                                }
                            }
                        }
                    }
                }
            } catch (SecurityException e11) {
                Logger.i(TAG, "getActiveNetworkInfo failed, exception:" + e11.getClass().getSimpleName());
            } catch (RuntimeException e12) {
                Logger.i(TAG, "getActiveNetworkInfo failed, exception:" + e12.getClass().getSimpleName());
            }
        }
        if (linkedList.isEmpty()) {
            return new String[0];
        }
        return (String[]) linkedList.toArray(new String[linkedList.size()]);
    }

    public static String getHost(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return UriUtil.getHostByURI(str);
    }

    public static int getInfoWithReflect(SignalStrength signalStrength, String str) {
        try {
            if (Build.VERSION.SDK_INT > 28) {
                return Integer.MAX_VALUE;
            }
            final Method declaredMethod = SignalStrength.class.getDeclaredMethod(str, new Class[0]);
            AccessController.doPrivileged(new PrivilegedAction() {
                public Object run() {
                    declaredMethod.setAccessible(true);
                    return null;
                }
            });
            return ((Integer) declaredMethod.invoke(signalStrength, new Object[0])).intValue();
        } catch (NoSuchMethodException unused) {
            String str2 = TAG;
            Logger.i(str2, str + " : function not found");
            return Integer.MAX_VALUE;
        } catch (IllegalAccessException unused2) {
            String str3 = TAG;
            Logger.i(str3, str + " : cannot access");
            return Integer.MAX_VALUE;
        } catch (InvocationTargetException unused3) {
            String str4 = TAG;
            Logger.i(str4, str + " : InvocationTargetException");
            return Integer.MAX_VALUE;
        } catch (Throwable th2) {
            String str5 = TAG;
            Logger.i(str5, str + " : throwable:" + th2.getClass());
            return Integer.MAX_VALUE;
        }
    }

    public static int getLteCqi(Context context) {
        SignalStrength signalStrength = getSignalStrength(context);
        if (signalStrength == null) {
            return Integer.MAX_VALUE;
        }
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                return getInfoWithReflect(signalStrength, "getLteCqi");
            }
            List a11 = signalStrength.getCellSignalStrengths(CellSignalStrengthLte.class);
            if (a11.size() > 0) {
                return ((CellSignalStrengthLte) a11.get(0)).getCqi();
            }
            return Integer.MAX_VALUE;
        } catch (Throwable th2) {
            String str = TAG;
            Logger.i(str, "getLteCqi: throwable:" + th2.getClass());
        }
    }

    public static int getLteRsrp(Context context) {
        SignalStrength signalStrength = getSignalStrength(context);
        if (signalStrength == null) {
            return Integer.MAX_VALUE;
        }
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                return getInfoWithReflect(signalStrength, "getLteRsrp");
            }
            List a11 = signalStrength.getCellSignalStrengths(CellSignalStrengthLte.class);
            if (a11.size() > 0) {
                return ((CellSignalStrengthLte) a11.get(0)).getRsrp();
            }
            return Integer.MAX_VALUE;
        } catch (Throwable th2) {
            String str = TAG;
            Logger.i(str, "getLteRsrp: throwable:" + th2.getClass());
        }
    }

    public static int getLteRsrq(Context context) {
        SignalStrength signalStrength = getSignalStrength(context);
        if (signalStrength == null) {
            return Integer.MAX_VALUE;
        }
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                return getInfoWithReflect(signalStrength, "getLteRsrq");
            }
            List a11 = signalStrength.getCellSignalStrengths(CellSignalStrengthLte.class);
            if (a11.size() > 0) {
                return ((CellSignalStrengthLte) a11.get(0)).getRsrq();
            }
            return Integer.MAX_VALUE;
        } catch (Throwable th2) {
            String str = TAG;
            Logger.i(str, "getLteRsrq: throwable:" + th2.getClass());
        }
    }

    public static int getLteRssi(Context context) {
        SignalStrength signalStrength = getSignalStrength(context);
        if (signalStrength == null) {
            return Integer.MAX_VALUE;
        }
        try {
            if (Build.VERSION.SDK_INT > 28) {
                List a11 = signalStrength.getCellSignalStrengths(CellSignalStrengthLte.class);
                if (a11.size() > 0) {
                    return ((CellSignalStrengthLte) a11.get(0)).getRssi();
                }
            }
        } catch (Throwable th2) {
            String str = TAG;
            Logger.i(str, "getLteRssi: throwable:" + th2.getClass());
        }
        return Integer.MAX_VALUE;
    }

    public static int getLteRssnr(Context context) {
        SignalStrength signalStrength = getSignalStrength(context);
        if (signalStrength == null) {
            return Integer.MAX_VALUE;
        }
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                return getInfoWithReflect(signalStrength, "getLteRssnr");
            }
            List a11 = signalStrength.getCellSignalStrengths(CellSignalStrengthLte.class);
            if (a11.size() > 0) {
                return ((CellSignalStrengthLte) a11.get(0)).getRssnr();
            }
            return Integer.MAX_VALUE;
        } catch (Throwable th2) {
            String str = TAG;
            Logger.i(str, "getLteRssnr: throwable:" + th2.getClass());
        }
    }

    public static Map<String, Integer> getLteSignalInfo(Context context) {
        HashMap hashMap = new HashMap();
        SignalStrength signalStrength = getSignalStrength(context);
        if (signalStrength == null) {
            return hashMap;
        }
        try {
            if (Build.VERSION.SDK_INT > 28) {
                List a11 = signalStrength.getCellSignalStrengths(CellSignalStrengthLte.class);
                if (a11.size() > 0) {
                    hashMap.put(SignalType.LTE_DBM, Integer.valueOf(((CellSignalStrengthLte) a11.get(0)).getDbm()));
                    hashMap.put(SignalType.LTE_RSRP, Integer.valueOf(((CellSignalStrengthLte) a11.get(0)).getRsrp()));
                    hashMap.put(SignalType.LTE_RSRQ, Integer.valueOf(((CellSignalStrengthLte) a11.get(0)).getRsrq()));
                    hashMap.put(SignalType.LTE_RSSNR, Integer.valueOf(((CellSignalStrengthLte) a11.get(0)).getRssnr()));
                    hashMap.put(SignalType.LTE_CQI, Integer.valueOf(((CellSignalStrengthLte) a11.get(0)).getCqi()));
                    hashMap.put(SignalType.LTE_RSSI, Integer.valueOf(((CellSignalStrengthLte) a11.get(0)).getRssi()));
                }
            } else {
                hashMap.put(SignalType.LTE_DBM, Integer.valueOf(getInfoWithReflect(signalStrength, "getDbm")));
                hashMap.put(SignalType.LTE_RSRP, Integer.valueOf(getInfoWithReflect(signalStrength, "getLteRsrp")));
                hashMap.put(SignalType.LTE_RSRQ, Integer.valueOf(getInfoWithReflect(signalStrength, "getLteRsrq")));
                hashMap.put(SignalType.LTE_RSSNR, Integer.valueOf(getInfoWithReflect(signalStrength, "getLteRssnr")));
                hashMap.put(SignalType.LTE_CQI, Integer.valueOf(getInfoWithReflect(signalStrength, "getLteCqi")));
            }
        } catch (Throwable th2) {
            String str = TAG;
            Logger.i(str, "getLteRssi: throwable:" + th2.getClass());
        }
        return hashMap;
    }

    public static String getMNC(Context context) {
        TelephonyManager telephonyManager;
        if (context == null || !isSimReady(context)) {
            return "unknown";
        }
        Object systemService = ContextCompat.getSystemService(context, "phone");
        if (systemService instanceof TelephonyManager) {
            telephonyManager = (TelephonyManager) systemService;
        } else {
            telephonyManager = null;
        }
        if (telephonyManager == null) {
            Logger.e(TAG, "getSubscriptionOperatorType: other error!");
            return "unknown";
        }
        String networkOperator = telephonyManager.getNetworkOperator();
        if ("46001".equals(networkOperator) || "46006".equals(networkOperator) || "46009".equals(networkOperator)) {
            return "China_Unicom";
        }
        if ("46000".equals(networkOperator) || "46002".equals(networkOperator) || "46004".equals(networkOperator) || "46007".equals(networkOperator)) {
            return "China_Mobile";
        }
        if ("46003".equals(networkOperator) || "46005".equals(networkOperator) || "46011".equals(networkOperator)) {
            return "China_Telecom";
        }
        return "other";
    }

    public static int getMobileRsrp(Context context) {
        SignalStrength signalStrength = getSignalStrength(context);
        if (signalStrength == null) {
            return Integer.MAX_VALUE;
        }
        try {
            if (Build.VERSION.SDK_INT > 28) {
                return getMobileSingalStrengthUpPPlatfrom(context);
            }
            return getInfoWithReflect(signalStrength, "getDbm");
        } catch (Throwable th2) {
            String str = TAG;
            Logger.i(str, "getDbm: throwable:" + th2.getClass());
            return Integer.MAX_VALUE;
        }
    }

    private static int getMobileSingalStrengthUpPPlatfrom(Context context) {
        SignalStrength signalStrength;
        int i11;
        if (Build.VERSION.SDK_INT <= 28 || (signalStrength = getSignalStrength(context)) == null) {
            return Integer.MAX_VALUE;
        }
        int networkType = getNetworkType(context);
        if (networkType == 3) {
            List a11 = signalStrength.getCellSignalStrengths(CellSignalStrengthCdma.class);
            if (a11.size() > 0) {
                i11 = ((CellSignalStrengthCdma) a11.get(0)).getDbm();
            } else {
                List a12 = signalStrength.getCellSignalStrengths(CellSignalStrengthTdscdma.class);
                if (a12.size() > 0) {
                    i11 = ((CellSignalStrengthTdscdma) a12.get(0)).getDbm();
                } else {
                    List a13 = signalStrength.getCellSignalStrengths(CellSignalStrengthWcdma.class);
                    if (a13.size() <= 0) {
                        return Integer.MAX_VALUE;
                    }
                    i11 = ((CellSignalStrengthWcdma) a13.get(0)).getDbm();
                }
            }
        } else if (networkType == 4) {
            List a14 = signalStrength.getCellSignalStrengths(CellSignalStrengthLte.class);
            if (a14.size() <= 0) {
                return Integer.MAX_VALUE;
            }
            i11 = ((CellSignalStrengthLte) a14.get(0)).getDbm();
        } else if (networkType != 5) {
            return Integer.MAX_VALUE;
        } else {
            try {
                List a15 = signalStrength.getCellSignalStrengths(CellSignalStrengthNr.class);
                if (a15.size() <= 0) {
                    return Integer.MAX_VALUE;
                }
                i11 = ((CellSignalStrengthNr) a15.get(0)).getDbm();
            } catch (Throwable th2) {
                String str = TAG;
                Logger.i(str, "getMobileSingalStrength: throwable:" + th2.getClass());
                return Integer.MAX_VALUE;
            }
        }
        return i11;
    }

    public static String getNetWorkNSAorSA() {
        try {
            HwTelephonyManager hwTelephonyManager = HwTelephonyManager.getDefault();
            int default4GSlotId = hwTelephonyManager.getDefault4GSlotId();
            String str = TAG;
            Logger.v(str, "phoneId " + default4GSlotId);
            boolean isNsaState = hwTelephonyManager.isNsaState(default4GSlotId);
            Logger.v(str, "isNsa " + isNsaState);
            if (isNsaState) {
                return STR_NSA;
            }
            return STR_SA;
        } catch (Throwable unused) {
            Logger.v(TAG, "isNsaState error");
            return null;
        }
    }

    @SuppressLint({"MissingPermission"})
    public static NetworkInfo getNetworkInfo(Context context) {
        ConnectivityManager connectivityManager;
        if (!ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") || (connectivityManager = (ConnectivityManager) ContextCompat.getSystemService(context, "connectivity")) == null) {
            return null;
        }
        try {
            return connectivityManager.getActiveNetworkInfo();
        } catch (RuntimeException e11) {
            String str = TAG;
            Logger.i(str, "getActiveNetworkInfo failed, exception:" + e11.getClass().getSimpleName() + e11.getMessage());
            return null;
        }
    }

    @SuppressLint({"MissingPermission"})
    public static NetworkInfo.DetailedState getNetworkStatus(Context context) {
        NetworkInfo.DetailedState detailedState = NetworkInfo.DetailedState.IDLE;
        if (context == null) {
            return detailedState;
        }
        Object systemService = ContextCompat.getSystemService(context, "connectivity");
        if (systemService instanceof ConnectivityManager) {
            try {
                if (!ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
                    return detailedState;
                }
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    return activeNetworkInfo.getDetailedState();
                }
                Logger.i(TAG, "getNetworkStatus networkIsConnected netInfo is null!");
                return detailedState;
            } catch (RuntimeException e11) {
                String str = TAG;
                Logger.i(str, "getNetworkStatus exception" + e11.getClass().getSimpleName() + e11.getMessage());
                return detailedState;
            }
        } else {
            Logger.i(TAG, "getNetworkStatus ConnectivityManager is null!");
            return detailedState;
        }
    }

    public static int getNetworkType(Context context) {
        if (context != null) {
            return getNetworkType(getNetworkInfo(context), context);
        }
        return 0;
    }

    public static int getNrCsiRsrp(Context context) {
        SignalStrength signalStrength;
        try {
            if (Build.VERSION.SDK_INT <= 28 || (signalStrength = getSignalStrength(context)) == null) {
                return Integer.MAX_VALUE;
            }
            List a11 = signalStrength.getCellSignalStrengths(CellSignalStrengthNr.class);
            if (a11.size() > 0) {
                return ((CellSignalStrengthNr) a11.get(0)).getCsiRsrp();
            }
            return Integer.MAX_VALUE;
        } catch (Throwable th2) {
            String str = TAG;
            Logger.i(str, "getNrCsiRsrp: throwable:" + th2.getClass());
        }
    }

    public static int getNrCsiRsrq(Context context) {
        SignalStrength signalStrength;
        try {
            if (Build.VERSION.SDK_INT <= 28 || (signalStrength = getSignalStrength(context)) == null) {
                return Integer.MAX_VALUE;
            }
            List a11 = signalStrength.getCellSignalStrengths(CellSignalStrengthNr.class);
            if (a11.size() > 0) {
                return ((CellSignalStrengthNr) a11.get(0)).getCsiRsrq();
            }
            return Integer.MAX_VALUE;
        } catch (Throwable th2) {
            String str = TAG;
            Logger.i(str, "getNrCsiRsrq: throwable:" + th2.getClass());
        }
    }

    public static int getNrCsiSinr(Context context) {
        SignalStrength signalStrength;
        try {
            if (Build.VERSION.SDK_INT <= 28 || (signalStrength = getSignalStrength(context)) == null) {
                return Integer.MAX_VALUE;
            }
            List a11 = signalStrength.getCellSignalStrengths(CellSignalStrengthNr.class);
            if (a11.size() > 0) {
                return ((CellSignalStrengthNr) a11.get(0)).getCsiSinr();
            }
            return Integer.MAX_VALUE;
        } catch (Throwable th2) {
            String str = TAG;
            Logger.i(str, "getNrCsiSinr: throwable:" + th2.getClass());
        }
    }

    public static Map<String, Integer> getNrSignalInfo(Context context) {
        HashMap hashMap = new HashMap();
        SignalStrength signalStrength = getSignalStrength(context);
        if (signalStrength == null) {
            return hashMap;
        }
        try {
            if (Build.VERSION.SDK_INT > 28) {
                List a11 = signalStrength.getCellSignalStrengths(CellSignalStrengthNr.class);
                if (a11.size() > 0) {
                    hashMap.put(SignalType.NR_DBM, Integer.valueOf(((CellSignalStrengthNr) a11.get(0)).getDbm()));
                    hashMap.put(SignalType.NR_CSIRSRP, Integer.valueOf(((CellSignalStrengthNr) a11.get(0)).getCsiRsrp()));
                    hashMap.put(SignalType.NR_CSIRSRQ, Integer.valueOf(((CellSignalStrengthNr) a11.get(0)).getCsiRsrq()));
                    hashMap.put(SignalType.NR_CSISINR, Integer.valueOf(((CellSignalStrengthNr) a11.get(0)).getCsiSinr()));
                    hashMap.put(SignalType.NR_SSRSRP, Integer.valueOf(((CellSignalStrengthNr) a11.get(0)).getSsRsrp()));
                    hashMap.put(SignalType.NR_SSRSRQ, Integer.valueOf(((CellSignalStrengthNr) a11.get(0)).getSsRsrq()));
                    hashMap.put(SignalType.NR_SSSINR, Integer.valueOf(((CellSignalStrengthNr) a11.get(0)).getSsSinr()));
                }
            }
        } catch (Throwable th2) {
            String str = TAG;
            Logger.i(str, "getLteRssi: throwable:" + th2.getClass());
        }
        return hashMap;
    }

    public static int getNrSsRsrp(Context context) {
        SignalStrength signalStrength;
        try {
            if (Build.VERSION.SDK_INT <= 28 || (signalStrength = getSignalStrength(context)) == null) {
                return Integer.MAX_VALUE;
            }
            List a11 = signalStrength.getCellSignalStrengths(CellSignalStrengthNr.class);
            if (a11.size() > 0) {
                return ((CellSignalStrengthNr) a11.get(0)).getSsRsrp();
            }
            return Integer.MAX_VALUE;
        } catch (Throwable th2) {
            String str = TAG;
            Logger.i(str, "getNrSsRsrp: throwable:" + th2.getClass());
        }
    }

    public static int getNrSsRsrq(Context context) {
        SignalStrength signalStrength;
        try {
            if (Build.VERSION.SDK_INT <= 28 || (signalStrength = getSignalStrength(context)) == null) {
                return Integer.MAX_VALUE;
            }
            List a11 = signalStrength.getCellSignalStrengths(CellSignalStrengthNr.class);
            if (a11.size() > 0) {
                return ((CellSignalStrengthNr) a11.get(0)).getSsRsrq();
            }
            return Integer.MAX_VALUE;
        } catch (Throwable th2) {
            String str = TAG;
            Logger.i(str, "getNrSsRsrq: throwable:" + th2.getClass());
        }
    }

    public static int getNrSsSinr(Context context) {
        SignalStrength signalStrength;
        try {
            if (Build.VERSION.SDK_INT <= 28 || (signalStrength = getSignalStrength(context)) == null) {
                return Integer.MAX_VALUE;
            }
            List a11 = signalStrength.getCellSignalStrengths(CellSignalStrengthNr.class);
            if (a11.size() > 0) {
                return ((CellSignalStrengthNr) a11.get(0)).getSsSinr();
            }
            return Integer.MAX_VALUE;
        } catch (Throwable th2) {
            String str = TAG;
            Logger.i(str, "getNrSsSinr: throwable:" + th2.getClass());
        }
    }

    public static int getPrimaryNetworkType(Context context) {
        return groupNetworkType(getNetworkType(getNetworkInfo(context), context));
    }

    private static SignalStrength getSignalStrength(Context context) {
        if (context == null || Build.VERSION.SDK_INT < 28) {
            return null;
        }
        return getTrafficCardTelephonyManager(context).getSignalStrength();
    }

    public static TelephonyManager getTrafficCardTelephonyManager(Context context) {
        if (context == null) {
            return null;
        }
        Object systemService = ContextCompat.getSystemService(context, "phone");
        if (!(systemService instanceof TelephonyManager)) {
            return null;
        }
        TelephonyManager telephonyManager = (TelephonyManager) systemService;
        if (Build.VERSION.SDK_INT >= 24) {
            return telephonyManager.createForSubscriptionId(SubscriptionManager.getDefaultDataSubscriptionId());
        }
        return telephonyManager;
    }

    public static String getWifiGatewayIp(Context context) {
        if (context == null) {
            return " ";
        }
        Object systemService = ContextCompat.getSystemService(context.getApplicationContext(), "wifi");
        if (!(systemService instanceof WifiManager)) {
            return " ";
        }
        try {
            int i11 = ((WifiManager) systemService).getDhcpInfo().gateway;
            return InetAddress.getByAddress(new byte[]{(byte) (i11 & 255), (byte) ((i11 >> 8) & 255), (byte) ((i11 >> 16) & 255), (byte) ((i11 >> 24) & 255)}).getHostAddress();
        } catch (RuntimeException | UnknownHostException e11) {
            String str = TAG;
            Logger.i(str, "getWifiGatewayIp error!" + e11.getClass().getSimpleName() + e11.getMessage());
            return " ";
        }
    }

    public static int getWifiRssi(Context context) {
        TransportInfo a11;
        int i11 = INVALID_RSSI;
        if (context == null) {
            return INVALID_RSSI;
        }
        if (Build.VERSION.SDK_INT >= 31) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
                for (Network networkCapabilities : connectivityManager.getAllNetworks()) {
                    NetworkCapabilities networkCapabilities2 = connectivityManager.getNetworkCapabilities(networkCapabilities);
                    if (networkCapabilities2 != null && networkCapabilities2.hasTransport(1) && (a11 = networkCapabilities2.getTransportInfo()) != null && (a11 instanceof WifiInfo)) {
                        i11 = ((WifiInfo) a11).getRssi();
                    }
                }
                return i11;
            } catch (RuntimeException e11) {
                Logger.i(TAG, "getWifiRssiLevel did not has permission!" + e11.getClass().getSimpleName() + e11.getMessage());
                return INVALID_RSSI;
            }
        } else {
            Object systemService = ContextCompat.getSystemService(context.getApplicationContext(), "wifi");
            if (!(systemService instanceof WifiManager)) {
                return INVALID_RSSI;
            }
            try {
                WifiInfo connectionInfo = ((WifiManager) systemService).getConnectionInfo();
                if (connectionInfo != null) {
                    return connectionInfo.getRssi();
                }
                return INVALID_RSSI;
            } catch (RuntimeException e12) {
                Logger.i(TAG, "getWifiRssiLevel did not has permission!" + e12.getClass().getSimpleName() + e12.getMessage());
                return INVALID_RSSI;
            }
        }
    }

    public static int getWifiRssiLevel(Context context) {
        return WifiManager.calculateSignalLevel(getWifiRssi(context), 5);
    }

    private static int groupNetworkType(int i11) {
        if (i11 == -1) {
            return -1;
        }
        if (i11 != 1) {
            return (i11 == 2 || i11 == 3 || i11 == 4 || i11 == 5) ? 6 : 0;
        }
        return 1;
    }

    public static boolean isChangeToConnected(NetworkInfo networkInfo, NetworkInfo networkInfo2) {
        if ((networkInfo != null && networkInfo.isConnected()) || !networkInfo2.isConnected()) {
            return false;
        }
        Logger.v(TAG, "Find network state changed to connected");
        return true;
    }

    public static boolean isConnectTypeChange(NetworkInfo networkInfo, NetworkInfo networkInfo2) {
        if (networkInfo == null || !networkInfo.isConnected() || !networkInfo2.isConnected() || getPrimaryNetworkType(networkInfo) == getPrimaryNetworkType(networkInfo2)) {
            return false;
        }
        Logger.v(TAG, "Find activity network changed");
        return true;
    }

    @Deprecated
    public static boolean isForeground(Context context) {
        return ActivityUtil.isForeground(context);
    }

    public static boolean isNetworkAvailable(Context context) {
        if (!ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return true;
        }
        NetworkInfo networkInfo = getNetworkInfo(context);
        if (networkInfo == null || !networkInfo.isConnected()) {
            return false;
        }
        return true;
    }

    public static boolean isSimReady(Context context) {
        TelephonyManager telephonyManager;
        Object systemService = ContextCompat.getSystemService(context, "phone");
        if (systemService instanceof TelephonyManager) {
            telephonyManager = (TelephonyManager) systemService;
        } else {
            telephonyManager = null;
        }
        if (telephonyManager == null || telephonyManager.getSimState() != 5) {
            return false;
        }
        return true;
    }

    public static boolean isUserUnlocked(Context context) {
        UserManager userManager;
        if (Build.VERSION.SDK_INT < 24 || (userManager = (UserManager) ContextCompat.getSystemService(context, "user")) == null) {
            return true;
        }
        try {
            return userManager.isUserUnlocked();
        } catch (RuntimeException e11) {
            Logger.e(TAG, "dealType rethrowFromSystemServer:", (Throwable) e11);
            return true;
        }
    }

    public static int netWork(Context context) {
        int networkType = getNetworkType(context);
        String str = TAG;
        Logger.v(str, "networkType " + networkType);
        if (networkType == 4) {
            if (TextUtils.equals(STR_NSA, getNetWorkNSAorSA())) {
                return 7;
            }
            return networkType;
        } else if (networkType != 5 || !TextUtils.equals(STR_SA, getNetWorkNSAorSA())) {
            return networkType;
        } else {
            return 8;
        }
    }

    @Deprecated
    public static NetworkInfo.DetailedState networkStatus(Context context) {
        return getNetworkStatus(context);
    }

    @SuppressLint({"MissingPermission"})
    public static int readDataSaverMode(Context context) {
        if (context == null || Build.VERSION.SDK_INT < 24 || !ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return 0;
        }
        Object systemService = ContextCompat.getSystemService(context, "connectivity");
        if (!(systemService instanceof ConnectivityManager)) {
            return 0;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        try {
            if (connectivityManager.isActiveNetworkMetered()) {
                return connectivityManager.getRestrictBackgroundStatus();
            }
            Logger.v(TAG, "ConnectType is not Mobile Network!");
            return 0;
        } catch (RuntimeException e11) {
            Logger.e(TAG, "SystemServer error:", (Throwable) e11);
            return 0;
        }
    }

    public static void updateCurrentNetworkType() {
        networkTypeByReceiver = netWork(ContextHolder.getResourceContext());
    }

    public static boolean isForeground() {
        return ActivityUtil.getInstance().isForeground();
    }

    public static int getNetworkType(NetworkInfo networkInfo, Context context) {
        int i11;
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
        int subtype = networkInfo.getSubtype();
        Logger.v(TAG, "getHwNetworkType return is: " + subtype);
        if (subtype == 0) {
            subtype = networkInfo.getSubtype();
        }
        if (subtype != 20) {
            switch (subtype) {
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
        if (subtype == 16) {
            return 2;
        }
        if (subtype != 17) {
            return 0;
        }
        return 3;
    }

    public static int getPrimaryNetworkType(NetworkInfo networkInfo) {
        return groupNetworkType(getNetworkType(networkInfo));
    }

    public static int getNetworkType(NetworkInfo networkInfo) {
        return getNetworkType(networkInfo, (Context) null);
    }
}
