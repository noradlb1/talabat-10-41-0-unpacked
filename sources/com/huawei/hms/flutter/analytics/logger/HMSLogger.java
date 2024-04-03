package com.huawei.hms.flutter.analytics.logger;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.util.Log;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtils;
import com.huawei.hms.utils.HMSBIInitializer;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class HMSLogger {
    private static final String KIT = "Analytics";
    private static final String NETWORK_TYPE_WIFI = "WIFI";
    private static final String NOT_AVAILABLE = "NOT_AVAILABLE";
    private static final String PERIODIC_EVENT_ID = "60001";
    private static final String PLATFORM = "Flutter";
    private static final String SERVICE = "Cross-Platform";
    private static final String SINGLE_EVENT_ID = "60000";
    private static final String SUCCESS = "0";
    private static final String TAG = "HMSLogger";
    private static final String UNKNOWN = "UNKNOWN";
    private static final String VERSION = "6.9.0.302";
    private static volatile HMSLogger instance;
    private final Map<String, Long> allCountMap = new HashMap();
    private final ConnectivityManager connectivityManager;
    private final Map<String, Long> failCountMap = new HashMap();
    private final Map<String, Long> firstReceiveTimeMap = new HashMap();
    private final HiAnalyticsUtils hiAnalyticsUtils;
    private boolean isEnabled = false;
    private final Map<String, Long> lastReceiveTimeMap = new HashMap();
    private final Map<Integer, String> networkTypeMap = createNetworkTypeMap();
    private final Map<String, Object> periodicEventMap;
    private final Map<String, Map<String, Long>> resultCodeCountMap = new HashMap();
    private final Map<String, Object> singleEventMap;
    private final Map<String, Long> startTimeMap = new HashMap();
    private final WeakReference<Context> weakContext;

    private HMSLogger(Context context) {
        HashMap hashMap = new HashMap();
        this.singleEventMap = hashMap;
        HashMap hashMap2 = new HashMap();
        this.periodicEventMap = hashMap2;
        this.weakContext = new WeakReference<>(context);
        HiAnalyticsUtils instance2 = HiAnalyticsUtils.getInstance();
        this.hiAnalyticsUtils = instance2;
        this.connectivityManager = (ConnectivityManager) objectCast(context.getSystemService("connectivity"), ConnectivityManager.class);
        instance2.enableLog();
        HMSBIInitializer.getInstance(context).initBI();
        setupEventMap(hashMap);
        setupEventMap(hashMap2);
        enableLogger();
    }

    private synchronized Map<Integer, String> createNetworkTypeMap() {
        HashMap hashMap;
        hashMap = new HashMap();
        hashMap.put(0, "UNKNOWN");
        hashMap.put(1, "2G");
        hashMap.put(2, "2G");
        hashMap.put(3, "3G");
        hashMap.put(4, "3G");
        hashMap.put(5, "3G");
        hashMap.put(6, "3G");
        hashMap.put(7, "2G");
        hashMap.put(8, "3G");
        hashMap.put(9, "3G");
        hashMap.put(10, "3G");
        hashMap.put(11, "2G");
        hashMap.put(12, "3G");
        hashMap.put(13, "4G");
        hashMap.put(14, "3G");
        hashMap.put(15, "3G");
        hashMap.put(16, "2G");
        hashMap.put(17, "3G");
        hashMap.put(18, "4G");
        hashMap.put(19, "4G");
        hashMap.put(20, "5G");
        return Collections.unmodifiableMap(hashMap);
    }

    private synchronized String getAppId() {
        try {
        } catch (NullPointerException unused) {
            return NOT_AVAILABLE;
        }
        return AGConnectServicesConfig.fromContext(getContext()).getString("client/app_id");
    }

    private synchronized String getAppVersionName(String str) {
        try {
        } catch (PackageManager.NameNotFoundException unused) {
            Log.e(TAG, "getAppVersionName ->  Could not get appVersionName!");
            return NOT_AVAILABLE;
        }
        return getContext().getPackageManager().getPackageInfo(str, 0).versionName;
    }

    private synchronized Context getContext() {
        return this.weakContext.get();
    }

    public static synchronized HMSLogger getInstance(Context context) {
        HMSLogger hMSLogger;
        synchronized (HMSLogger.class) {
            if (instance == null) {
                synchronized (HMSLogger.class) {
                    if (instance == null) {
                        instance = new HMSLogger(context.getApplicationContext());
                    }
                }
            }
            hMSLogger = instance;
        }
        return hMSLogger;
    }

    private synchronized String getNetworkType() {
        ConnectivityManager connectivityManager2 = this.connectivityManager;
        if (connectivityManager2 == null) {
            return NOT_AVAILABLE;
        }
        NetworkInfo activeNetworkInfo = connectivityManager2.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return NOT_AVAILABLE;
        }
        int type = activeNetworkInfo.getType();
        if (1 == type) {
            return NETWORK_TYPE_WIFI;
        }
        if (type != 0) {
            return "UNKNOWN";
        }
        return (String) getOrDefault(this.networkTypeMap, Integer.valueOf(activeNetworkInfo.getSubtype()), "UNKNOWN");
    }

    private synchronized <K, V> V getOrDefault(Map<K, V> map, K k11, V v11) {
        if (map.containsKey(k11)) {
            v11 = map.get(k11);
        }
        return v11;
    }

    /* JADX WARNING: type inference failed for: r6v0, types: [java.util.Map<java.lang.String, java.lang.Long>, java.util.Map] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void increaseMapValue(java.lang.String r5, java.util.Map<java.lang.String, java.lang.Long> r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            r0 = 0
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch:{ all -> 0x001d }
            java.lang.Object r0 = r4.getOrDefault(r6, r5, r0)     // Catch:{ all -> 0x001d }
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ all -> 0x001d }
            long r0 = r0.longValue()     // Catch:{ all -> 0x001d }
            r2 = 1
            long r0 = r0 + r2
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch:{ all -> 0x001d }
            r6.put(r5, r0)     // Catch:{ all -> 0x001d }
            monitor-exit(r4)
            return
        L_0x001d:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.flutter.analytics.logger.HMSLogger.increaseMapValue(java.lang.String, java.util.Map):void");
    }

    private synchronized void increaseResultCodeCount(String str, String str2) {
        Map map = (Map) getOrDefault(this.resultCodeCountMap, str, new HashMap());
        increaseMapValue(str2, map);
        this.resultCodeCountMap.put(str, map);
    }

    private synchronized <S, D> D objectCast(S s11, Class<D> cls) {
        return cls.cast(s11);
    }

    private synchronized <K, V> void putIfAbsent(Map<K, V> map, K k11, V v11) {
        if (!map.containsKey(k11)) {
            map.put(k11, v11);
        }
    }

    private synchronized void putToPeriodicEventMap(String str, String str2, long j11) {
        increaseResultCodeCount(str, str2);
        increaseMapValue(str, this.allCountMap);
        if (!str2.equals("0")) {
            increaseMapValue(str, this.failCountMap);
        }
        this.periodicEventMap.put("callTime", Long.valueOf(((Long) getOrDefault(this.firstReceiveTimeMap, str, Long.valueOf(j11))).longValue()));
        this.periodicEventMap.put(WiseOpenHianalyticsData.UNION_COSTTIME, Integer.valueOf((int) (j11 - ((Long) getOrDefault(this.lastReceiveTimeMap, str, Long.valueOf(j11))).longValue())));
        this.periodicEventMap.put("apiName", str);
        this.periodicEventMap.put("result", this.resultCodeCountMap.get(str));
        this.periodicEventMap.put("allCnt", Long.valueOf(((Long) getOrDefault(this.allCountMap, str, 0L)).longValue()));
        this.periodicEventMap.put("failCnt", Long.valueOf(((Long) getOrDefault(this.failCountMap, str, 0L)).longValue()));
        this.periodicEventMap.put("lastCallTime", Long.valueOf(j11));
        this.periodicEventMap.put("networkType", getNetworkType());
        putIfAbsent(this.firstReceiveTimeMap, str, Long.valueOf(j11));
        this.lastReceiveTimeMap.put(str, Long.valueOf(j11));
    }

    private synchronized void putToSingleEventMap(String str, String str2, long j11) {
        this.singleEventMap.put("apiName", str);
        this.singleEventMap.put("result", str2);
        this.singleEventMap.put("callTime", Long.valueOf(j11));
        this.singleEventMap.put(WiseOpenHianalyticsData.UNION_COSTTIME, Integer.valueOf((int) (j11 - ((Long) getOrDefault(this.startTimeMap, str, Long.valueOf(j11))).longValue())));
        this.singleEventMap.put("networkType", getNetworkType());
    }

    private synchronized void sendEvent(String str, String str2, String str3) {
        if (this.isEnabled) {
            long currentTimeMillis = System.currentTimeMillis();
            if (str.equals("60000")) {
                putToSingleEventMap(str2, str3, currentTimeMillis);
                this.hiAnalyticsUtils.onNewEvent(getContext(), "60000", this.singleEventMap);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("singleEventMap -> ");
                sb2.append(this.singleEventMap);
            } else {
                putToPeriodicEventMap(str2, str3, currentTimeMillis);
                this.hiAnalyticsUtils.onNewEvent(getContext(), PERIODIC_EVENT_ID, this.periodicEventMap);
                StringBuilder sb3 = new StringBuilder();
                sb3.append("periodicEventMap -> ");
                sb3.append(this.periodicEventMap);
            }
        }
    }

    private synchronized void setupEventMap(Map<String, Object> map) {
        map.put("kit", KIT);
        map.put("platform", PLATFORM);
        map.put("version", VERSION);
        map.put("service", SERVICE);
        map.put(HiAnalyticsConstant.HaKey.BI_KEY_APPID, getAppId());
        map.put("package", getContext().getPackageName());
        map.put(WiseOpenHianalyticsData.UNION_APP_VERSION, getAppVersionName(getContext().getPackageName()));
        map.put(DeviceRequestsHelper.DEVICE_INFO_MODEL, Build.DEVICE);
    }

    public synchronized void disableLogger() {
        this.isEnabled = false;
    }

    public synchronized void enableLogger() {
        this.isEnabled = true;
    }

    public synchronized void sendPeriodicEvent(String str) {
        sendEvent(PERIODIC_EVENT_ID, str, "0");
    }

    public synchronized void sendSingleEvent(String str) {
        sendEvent("60000", str, "0");
    }

    public synchronized void startMethodExecutionTimer(String str) {
        this.startTimeMap.put(str, Long.valueOf(System.currentTimeMillis()));
    }

    public synchronized void sendPeriodicEvent(String str, String str2) {
        sendEvent(PERIODIC_EVENT_ID, str, str2);
    }

    public synchronized void sendSingleEvent(String str, String str2) {
        sendEvent("60000", str, str2);
    }
}
