package com.huawei.wearengine.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.wearengine.monitor.MonitorItem;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile int f44847a = -1;

    /* renamed from: b  reason: collision with root package name */
    private static volatile int f44848b;

    /* renamed from: c  reason: collision with root package name */
    private static Map<String, Integer> f44849c;

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        f44849c = concurrentHashMap;
        concurrentHashMap.put("device_get_bonded_device_ex", 2);
        f44849c.put("p2p_send_extra", 2);
        f44849c.put("p2p_get_device_app_version_code", 4);
        f44849c.put("device_get_hi_link_device_id", 2);
        f44849c.put(MonitorItem.MONITOR_CHARGE_STATUS.getName(), 2);
        f44849c.put(MonitorItem.MONITOR_ITEM_LOW_POWER.getName(), 2);
        f44849c.put(MonitorItem.MONITOR_POWER_STATUS.getName(), 2);
        f44849c.put(MonitorItem.MONITOR_ITEM_SLEEP.getName(), 2);
        f44849c.put(MonitorItem.MONITOR_ITEM_SPORT.getName(), 2);
        f44849c.put(MonitorItem.MONITOR_ITEM_WEAR.getName(), 2);
        f44849c.put(MonitorItem.MONITOR_ITEM_HEART_RATE_ALARM.getName(), 2);
        f44849c.put("monitor_query", 2);
        f44849c.put("notify_notify", 2);
        f44849c.put("sensor", 2);
        f44849c.put("auth_pre_start_auth", 2);
        f44849c.put("p2p_cancel_file_transfer", 5);
    }

    public static int a() {
        Bundle bundle;
        if (f44848b != 0) {
            return f44848b;
        }
        Context a11 = b.a();
        PackageManager packageManager = a11.getPackageManager();
        int i11 = 0;
        if (packageManager == null) {
            com.huawei.wearengine.common.a.c("ApiLevelUtil", "getMetaDataApiLevel PackageManager is null");
        } else {
            try {
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(a11.getPackageName(), 128);
                if (!(applicationInfo == null || (bundle = applicationInfo.metaData) == null)) {
                    int i12 = bundle.getInt("com.huawei.wearengine.sdk.api_level");
                    com.huawei.wearengine.common.a.b("ApiLevelUtil", "getMetaDataApiLevel apiLevel:" + i12);
                    i11 = i12;
                }
            } catch (PackageManager.NameNotFoundException unused) {
                com.huawei.wearengine.common.a.a("ApiLevelUtil", "getMetaDataApiLevel PackageManager.NameNotFoundException");
            }
        }
        f44848b = i11;
        return f44848b;
    }

    public static void a(int i11) {
        f44847a = i11;
    }

    public static boolean a(String str) {
        com.huawei.wearengine.common.a.b("ApiLevelUtil", "isServiceSupport apiName:" + str);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int intValue = f44849c.get(str) == null ? 0 : f44849c.get(str).intValue();
        if (intValue == 0) {
            com.huawei.wearengine.common.a.c("ApiLevelUtil", "isServiceSupport inputApiLevel is null");
            return false;
        }
        com.huawei.wearengine.common.a.b("ApiLevelUtil", "isServiceSupport serviceApiLevel: " + f44847a + ", minSupportApiLevel:" + intValue);
        return f44847a >= intValue;
    }

    public static int b() {
        return f44847a;
    }
}
