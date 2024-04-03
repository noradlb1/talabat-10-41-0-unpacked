package com.huawei.hms.android;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.support.log.HMSLog;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;

public class SystemUtils {
    public static final String PRODUCT_BRAND = "ro.product.brand";
    public static final String PRODUCT_HONOR = "HONOR";
    public static final String PRODUCT_HUAWEI = "HUAWEI";
    public static final String UNKNOWN = "unknown";

    private static String a() {
        return getSystemProperties("ro.product.locale", "");
    }

    private static String b() {
        return getSystemProperties("ro.product.locale.region", "");
    }

    public static String getAndoridVersion() {
        return getSystemProperties("ro.build.version.release", "unknown");
    }

    public static String getLocalCountry() {
        Locale locale = Locale.getDefault();
        if (locale != null) {
            return locale.getCountry();
        }
        return "";
    }

    public static String getManufacturer() {
        return getSystemProperties("ro.product.manufacturer", "unknown");
    }

    public static long getMegabyte(double d11) {
        double d12 = Build.VERSION.SDK_INT > 25 ? 1000.0d : 1024.0d;
        return (long) (d11 * d12 * d12);
    }

    public static String getNetType(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable()) {
            return "";
        }
        return activeNetworkInfo.getTypeName();
    }

    public static String getPhoneModel() {
        return getSystemProperties("ro.product.model", "unknown");
    }

    public static String getSystemProperties(String str, String str2) {
        Class<String> cls = String.class;
        try {
            Class<?> cls2 = Class.forName("android.os.SystemProperties");
            return (String) cls2.getDeclaredMethod("get", new Class[]{cls, cls}).invoke(cls2, new Object[]{str, str2});
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException unused) {
            HMSLog.e("SystemUtils", "An exception occurred while reading: getSystemProperties:" + str);
            return str2;
        }
    }

    @Deprecated
    public static boolean isChinaROM() {
        String b11 = b();
        if (!TextUtils.isEmpty(b11)) {
            return "cn".equalsIgnoreCase(b11);
        }
        String a11 = a();
        if (!TextUtils.isEmpty(a11)) {
            return a11.toLowerCase(Locale.US).contains("cn");
        }
        String localCountry = getLocalCountry();
        if (!TextUtils.isEmpty(localCountry)) {
            return "cn".equalsIgnoreCase(localCountry);
        }
        return false;
    }

    public static boolean isEMUI() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("is Emui :");
        int i11 = HwBuildEx.VERSION.EMUI_SDK_INT;
        sb2.append(i11);
        HMSLog.i("SystemUtils", sb2.toString());
        return i11 > 0;
    }

    public static boolean isHuawei() {
        String systemProperties = getSystemProperties(PRODUCT_BRAND, "unknown");
        if ("HUAWEI".equalsIgnoreCase(systemProperties) || "HONOR".equalsIgnoreCase(systemProperties)) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isSystemApp(android.content.Context r3, java.lang.String r4) {
        /*
            r0 = 0
            java.lang.String r1 = "SystemUtils"
            if (r3 != 0) goto L_0x000b
            java.lang.String r3 = "isSystemApp context is null"
            com.huawei.hms.support.log.HMSLog.w(r1, r3)
            return r0
        L_0x000b:
            android.content.pm.PackageManager r3 = r3.getPackageManager()     // Catch:{ AndroidException -> 0x002c, RuntimeException -> 0x0016 }
            r2 = 16384(0x4000, float:2.2959E-41)
            android.content.pm.PackageInfo r3 = r3.getPackageInfo(r4, r2)     // Catch:{ AndroidException -> 0x002c, RuntimeException -> 0x0016 }
            goto L_0x0042
        L_0x0016:
            r3 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r2 = "isSystemApp RuntimeException:"
            r4.append(r2)
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            com.huawei.hms.support.log.HMSLog.e(r1, r3)
            goto L_0x0041
        L_0x002c:
            r3 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r2 = "isSystemApp Exception: "
            r4.append(r2)
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            com.huawei.hms.support.log.HMSLog.e(r1, r3)
        L_0x0041:
            r3 = 0
        L_0x0042:
            if (r3 == 0) goto L_0x004d
            android.content.pm.ApplicationInfo r3 = r3.applicationInfo
            int r3 = r3.flags
            r4 = 1
            r3 = r3 & r4
            if (r3 <= 0) goto L_0x004d
            r0 = r4
        L_0x004d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.android.SystemUtils.isSystemApp(android.content.Context, java.lang.String):boolean");
    }

    public static boolean isTVDevice() {
        return getSystemProperties("ro.build.characteristics", "default").equalsIgnoreCase("tv");
    }
}
