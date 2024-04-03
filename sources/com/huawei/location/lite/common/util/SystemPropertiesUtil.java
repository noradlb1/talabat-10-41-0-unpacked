package com.huawei.location.lite.common.util;

import android.os.Build;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class SystemPropertiesUtil {
    private static final String CLASS_NAME = "android.os.SystemProperties";
    private static final String NULL_FLAG = "NULL";
    private static final String TAG = "SystemPropertiesUtil";
    private static volatile String androidVersion;
    private static volatile String characteristics;
    private static volatile String emuiVerion;
    private static volatile String fullVersionId;
    private static volatile String hardware;
    private static Map<String, String> honorProMap;
    private static volatile String manufacturer;
    private static volatile String model;
    private static volatile String platform;
    private static volatile String region;
    private static volatile String vendor;

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0037  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String get(java.lang.String r7, java.lang.String r8) {
        /*
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            java.lang.String r1 = "android.os.SystemProperties"
            java.lang.Class r1 = com.huawei.location.lite.common.util.ReflectionUtils.getClass(r1)     // Catch:{ Exception -> 0x0029 }
            java.lang.String r2 = "get"
            r3 = 2
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x0029 }
            r5 = 0
            r4[r5] = r0     // Catch:{ Exception -> 0x0029 }
            r6 = 1
            r4[r6] = r0     // Catch:{ Exception -> 0x0029 }
            java.lang.reflect.Method r0 = com.huawei.location.lite.common.util.ReflectionUtils.getMethod(r1, r2, r4)     // Catch:{ Exception -> 0x0029 }
            java.lang.Object[] r1 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x0029 }
            r1[r5] = r7     // Catch:{ Exception -> 0x0029 }
            r1[r6] = r8     // Catch:{ Exception -> 0x0029 }
            r2 = 0
            java.lang.Object r0 = com.huawei.location.lite.common.util.ReflectionUtils.invoke(r2, r0, r1)     // Catch:{ Exception -> 0x0029 }
            boolean r1 = r0 instanceof java.lang.String     // Catch:{ Exception -> 0x0029 }
            if (r1 == 0) goto L_0x0030
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x0029 }
            goto L_0x0031
        L_0x0029:
            java.lang.String r0 = "SystemPropertiesUtil"
            java.lang.String r1 = "get SystemProperties Exception"
            com.huawei.location.lite.common.log.LogConsole.e(r0, r1)
        L_0x0030:
            r0 = r8
        L_0x0031:
            boolean r1 = android.text.TextUtils.equals(r0, r8)
            if (r1 == 0) goto L_0x0046
            java.lang.String r7 = getHonorProKey(r7)
            boolean r1 = android.text.TextUtils.isEmpty(r7)
            if (r1 != 0) goto L_0x0046
            java.lang.String r7 = get(r7, r8)
            return r7
        L_0x0046:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.lite.common.util.SystemPropertiesUtil.get(java.lang.String, java.lang.String):java.lang.String");
    }

    public static String getAndroidVersion() {
        if (!TextUtils.isEmpty(androidVersion)) {
            return androidVersion;
        }
        androidVersion = get("ro.build.version.release", NULL_FLAG);
        return androidVersion;
    }

    public static String getCharacter() {
        if (!TextUtils.isEmpty(characteristics)) {
            return characteristics;
        }
        characteristics = get("ro.build.characteristics", "");
        return characteristics;
    }

    public static String getEMUIVersion() {
        if (!TextUtils.isEmpty(emuiVerion)) {
            return emuiVerion;
        }
        emuiVerion = get("ro.build.version.emui", NULL_FLAG);
        return emuiVerion;
    }

    public static String getEmulator() {
        if (!TextUtils.isEmpty(vendor)) {
            return vendor;
        }
        vendor = get("ro.kernel.qemu", "");
        return vendor;
    }

    public static String getHardWare() {
        if (!TextUtils.isEmpty(hardware)) {
            return hardware;
        }
        hardware = get("ro.boot.hardware", "UNDEFINED");
        return hardware;
    }

    private static synchronized String getHonorProKey(String str) {
        String str2;
        synchronized (SystemPropertiesUtil.class) {
            if (honorProMap == null) {
                initHonorProMapMap();
            }
            str2 = honorProMap.get(str);
        }
        return str2;
    }

    public static String getModel() {
        if (!TextUtils.isEmpty(model)) {
            return model;
        }
        model = get("ro.product.model", "");
        return model;
    }

    public static String getPlatform() {
        if (!TextUtils.isEmpty(platform)) {
            return platform;
        }
        platform = get("ro.board.platform", "");
        return platform;
    }

    public static String getProRegion() {
        if (!TextUtils.isEmpty(region)) {
            return region;
        }
        region = get("ro.product.locale.region", "");
        return region;
    }

    public static String getProperty(String str, String str2) {
        return get(str, str2);
    }

    public static String getVendor() {
        if (!TextUtils.isEmpty(manufacturer)) {
            return manufacturer;
        }
        manufacturer = get("ro.product.manufacturer", "");
        return manufacturer;
    }

    public static String getVersion() {
        if (!TextUtils.isEmpty(fullVersionId)) {
            return fullVersionId;
        }
        int i11 = 0;
        String[] strArr = {get("ro.build.realversion.id", NULL_FLAG), get("ro.build.cust.id", NULL_FLAG), get("ro.build.display.id", NULL_FLAG)};
        fullVersionId = Build.DISPLAY;
        while (true) {
            if (i11 >= 3) {
                break;
            }
            String str = strArr[i11];
            if (!NULL_FLAG.equals(str)) {
                fullVersionId = str;
                break;
            }
            i11++;
        }
        return fullVersionId;
    }

    private static void initHonorProMapMap() {
        HashMap hashMap = new HashMap(4);
        honorProMap = hashMap;
        hashMap.put("ro.hw.country", "msc.sys.country");
        honorProMap.put("ro.build.hw_emui_api_level", "ro.build.magic_api_level");
        honorProMap.put("ro.build.version.emui", "ro.build.version.magic");
        honorProMap.put("ro.config.hw_nlp", "msc.config.nlp");
    }
}
