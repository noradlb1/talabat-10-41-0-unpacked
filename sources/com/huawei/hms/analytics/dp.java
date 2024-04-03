package com.huawei.hms.analytics;

import android.app.AppOpsManager;
import android.app.Application;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.FeatureInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.webkit.WebSettings;
import com.google.android.exoplayer2.util.MimeTypes;
import com.huawei.hms.analytics.core.log.HiLog;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.visa.checkout.Profile;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import net.bytebuddy.utility.JavaConstant;

public final class dp {
    private static final String[] lmn = {"android.software.backup", "android.software.print", "android.software.activities_on_secondary_displays", "android.software.voice_recognizers", "android.software.picture_in_picture", "android.software.cant_save_state", "android.software.verified_boot", "android.software.home_screen", "android.software.autofill", "android.software.securely_removes_users", "android.software.app_widgets", "android.software.input_methods", "android.software.companion_device_setup", "android.software.device_admin", "android.software.managed_users", "android.software.webview", "android.software.connectionservice", "android.software.cts", "android.software.live_wallpaper", "android.software.ipsec_tunnels", "android.software.freeform_window_management", "android.software.midi", "android.software.secure_lock_screen", "android.software.file_based_encryption"};

    public static String a(Context context) {
        NetworkInfo activeNetworkInfo;
        if (du.lmn(context, "android.permission.ACCESS_NETWORK_STATE", Process.myPid(), Process.myUid()) != 0) {
            HiLog.w("DeviceToolsKit", "not have network state phone permission!");
            return "";
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) {
            return "";
        }
        int type = activeNetworkInfo.getType();
        int subtype = activeNetworkInfo.getSubtype();
        String subtypeName = activeNetworkInfo.getSubtypeName();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(type);
        stringBuffer.append(JavaConstant.Dynamic.DEFAULT_NAME);
        stringBuffer.append(subtype);
        stringBuffer.append(JavaConstant.Dynamic.DEFAULT_NAME);
        if (TextUtils.isEmpty(subtypeName)) {
            subtypeName = " ";
        }
        stringBuffer.append(subtypeName);
        return stringBuffer.toString();
    }

    public static String abc(Context context) {
        return !(context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED")).getIntExtra("plugged", -1) != 0) ? "discharging" : "charging";
    }

    public static boolean b(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return ((NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION)).areNotificationsEnabled();
        }
        AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String packageName = context.getPackageName();
        int i11 = applicationInfo.uid;
        try {
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            Class cls2 = Integer.TYPE;
            return ((Integer) cls.getMethod("checkOpNoThrow", new Class[]{cls2, cls2, String.class}).invoke(appOpsManager, new Object[]{Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i11), packageName})).intValue() == 0;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
            HiLog.e("DeviceToolsKit", "notification IllegalAccess exception");
            return true;
        }
    }

    public static int bcd(Context context) {
        Intent registerReceiver = context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            return registerReceiver.getIntExtra("level", -1);
        }
        return -1;
    }

    private static boolean bcd() {
        if (!Process.is64Bit()) {
            return false;
        }
        try {
            Class<?> cls = Class.forName("ohos.system.Parameters");
            Object invoke = cls.getMethod("getBoolean", new Class[]{String.class, Boolean.TYPE}).invoke(cls, new Object[]{"hw_sc.build.os.enable", Boolean.FALSE});
            if (invoke instanceof Boolean) {
                return ((Boolean) invoke).booleanValue();
            }
            return false;
        } catch (Exception unused) {
            HiLog.d("DeviceToolsKit", "invoke hm os exception");
            return false;
        }
    }

    public static String c(Context context) {
        List<String> lmn2 = dq.lmn(context);
        String str = "";
        if (lmn2 == null ? false : lmn2.contains("USERAGENT")) {
            HiLog.w("DeviceToolsKit", "userAgent disabled");
            return str;
        }
        try {
            str = WebSettings.getDefaultUserAgent(context);
        } catch (Exception unused) {
            HiLog.w("DeviceToolsKit", "get default user agent failed");
        }
        return TextUtils.isEmpty(str) ? cde() : str;
    }

    private static String cde() {
        try {
            return System.getProperty("http.agent");
        } catch (Exception unused) {
            HiLog.w("userAgent", "get system useragent failed");
            return "";
        }
    }

    public static String cde(Context context) {
        NetworkInfo activeNetworkInfo;
        String str;
        String str2;
        if (du.lmn(context, "android.permission.ACCESS_NETWORK_STATE", Process.myPid(), Process.myUid()) != 0) {
            HiLog.w("DeviceToolsKit", "not have network state phone permission!");
            return "";
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) {
            return "";
        }
        if (activeNetworkInfo.getType() == 1) {
            return "WIFI";
        }
        if (activeNetworkInfo.getType() == 0) {
            String subtypeName = activeNetworkInfo.getSubtypeName();
            HiLog.i("DeviceToolsKit", "Network getSubtypeName : ".concat(String.valueOf(subtypeName)));
            int subtype = activeNetworkInfo.getSubtype();
            if (subtype != 20) {
                switch (subtype) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        str2 = "2G";
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
                        return "3G";
                    case 13:
                        str2 = "4G";
                        break;
                    default:
                        return (subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000")) ? "3G" : subtypeName;
                }
            } else {
                str2 = "5G";
            }
            return str2;
        }
        if (activeNetworkInfo.getType() == 16) {
            str = "COMPANION_PROXY";
        } else if (activeNetworkInfo.getType() == 9) {
            str = "ETHERNET";
        } else {
            HiLog.i("DeviceToolsKit", "type name = " + activeNetworkInfo.getType());
            return "OTHER_NETWORK_TYPE";
        }
        HiLog.i("DeviceToolsKit", "type name = ".concat(str));
        return str;
    }

    public static String d(Context context) {
        return String.valueOf(context.getResources().getConfiguration().fontScale);
    }

    public static Point def(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Point point = new Point();
        if (windowManager == null) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            point.x = displayMetrics.widthPixels;
            point.y = displayMetrics.heightPixels;
            return point;
        }
        windowManager.getDefaultDisplay().getRealSize(point);
        return point;
    }

    private static boolean def() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static int e(Context context) {
        return Settings.System.getInt(context.getContentResolver(), "screen_brightness", 127);
    }

    private static String efg() {
        String[] split = lmn("ro.build.characteristics", "").split(",");
        StringBuilder sb2 = new StringBuilder();
        for (String str : split) {
            if (!TextUtils.isEmpty(str)) {
                sb2.append("android.");
                sb2.append(str);
                sb2.append('|');
            }
        }
        return sb2.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r0 = r0.locale;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String efg(android.content.Context r0) {
        /*
            android.content.res.Resources r0 = r0.getResources()
            android.content.res.Configuration r0 = r0.getConfiguration()
            if (r0 == 0) goto L_0x0013
            java.util.Locale r0 = r0.locale
            if (r0 == 0) goto L_0x0013
            java.lang.String r0 = r0.toString()
            goto L_0x0015
        L_0x0013:
            java.lang.String r0 = ""
        L_0x0015:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.analytics.dp.efg(android.content.Context):java.lang.String");
    }

    public static int f(Context context) {
        try {
            return ((AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO)).getRingerMode();
        } catch (Exception unused) {
            HiLog.w("DeviceToolsKit", "get ringger status failed");
            return 1;
        }
    }

    public static int fgh(Context context) {
        int klm = dv.klm(context, "global_v2", "is_test_dvce", -1);
        if (klm == 1) {
            return klm;
        }
        if (!ghi(context)) {
            return 0;
        }
        dv.lmn(context, "global_v2", "is_test_dvce", 1);
        return 1;
    }

    public static String fgh() {
        return bcd() ? "HarmonyOS" : "android";
    }

    public static boolean g(Context context) {
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    public static long ghi() {
        if (def()) {
            try {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getCanonicalPath());
                return lmn(statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong());
            } catch (IOException unused) {
                HiLog.w("DeviceToolsKit", "get free storage size failed");
            }
        }
        return 0;
    }

    public static boolean ghi(Context context) {
        String lmn2 = lmn("debug.huawei.hms.analytics.app", "");
        if (context == null || TextUtils.isEmpty(lmn2) || !lmn2.equals(context.getPackageName())) {
            return false;
        }
        HiLog.i("DeviceToolsKit", "debugMode enabled.");
        return true;
    }

    public static boolean h(Context context) {
        return Settings.System.getInt(context.getContentResolver(), "accelerometer_rotation", 0) == 1;
    }

    public static long hij() {
        if (!def()) {
            return 0;
        }
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return lmn(statFs.getBlockCountLong() * statFs.getBlockSizeLong());
    }

    public static String hij(Context context) {
        String str;
        String str2 = "unknown";
        if (context == null) {
            return str2;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 16384);
            String str3 = packageInfo != null ? packageInfo.versionName : str2;
            try {
                if (!TextUtils.isEmpty(str3)) {
                    return str3;
                }
                HiLog.w("DeviceToolsKit", "get versionName is empty");
                return str2;
            } catch (PackageManager.NameNotFoundException unused) {
                str2 = str3;
                str = "getVersion(): The package name is not correct!";
                HiLog.w("DeviceToolsKit", str);
                return str2;
            } catch (Exception unused2) {
                str2 = str3;
                str = "get package info failed";
                HiLog.w("DeviceToolsKit", str);
                return str2;
            }
        } catch (PackageManager.NameNotFoundException unused3) {
            str = "getVersion(): The package name is not correct!";
            HiLog.w("DeviceToolsKit", str);
            return str2;
        } catch (Exception unused4) {
            str = "get package info failed";
            HiLog.w("DeviceToolsKit", str);
            return str2;
        }
    }

    public static String ijk() {
        return bcd() ? TextUtils.isEmpty("hw_sc.build.platform.version") ? "" : lmn("ohos.system.Parameters", "hw_sc.build.platform.version", "") : Build.VERSION.RELEASE;
    }

    public static String ijk(Context context) {
        return ikl(context, "analyticskit_properties_collection_disabled");
    }

    public static String ikl() {
        String lmn2 = lmn("com.huawei.android.os.SystemPropertiesEx", "ro.huawei.build.display.id", "");
        if (!TextUtils.isEmpty(lmn2)) {
            return lmn2;
        }
        HiLog.i("DeviceToolsKit", "get SystemPropertiesEx rom_ver is empty");
        return Build.DISPLAY;
    }

    public static String ikl(Context context) {
        String ikl = ikl(context, "install_channel");
        return TextUtils.isEmpty(ikl) ? ikl : lmn(ikl);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0018, code lost:
        r4 = (r4 = r4.metaData).get(r5);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String ikl(android.content.Context r4, java.lang.String r5) {
        /*
            java.lang.String r0 = "DeviceToolsKit"
            java.lang.String r1 = ""
            android.content.pm.PackageManager r2 = r4.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0027, Exception -> 0x0024 }
            java.lang.String r4 = r4.getPackageName()     // Catch:{ NameNotFoundException -> 0x0027, Exception -> 0x0024 }
            r3 = 128(0x80, float:1.794E-43)
            android.content.pm.ApplicationInfo r4 = r2.getApplicationInfo(r4, r3)     // Catch:{ NameNotFoundException -> 0x0027, Exception -> 0x0024 }
            if (r4 == 0) goto L_0x002c
            android.os.Bundle r4 = r4.metaData     // Catch:{ NameNotFoundException -> 0x0027, Exception -> 0x0024 }
            if (r4 == 0) goto L_0x002c
            java.lang.Object r4 = r4.get(r5)     // Catch:{ NameNotFoundException -> 0x0027, Exception -> 0x0024 }
            if (r4 == 0) goto L_0x002c
            java.lang.String r4 = r4.toString()     // Catch:{ NameNotFoundException -> 0x0027, Exception -> 0x0024 }
            r1 = r4
            goto L_0x002c
        L_0x0024:
            java.lang.String r4 = "get channel failed"
            goto L_0x0029
        L_0x0027:
            java.lang.String r4 = "getChannel(): The packageName is not correct!"
        L_0x0029:
            com.huawei.hms.analytics.core.log.HiLog.w(r0, r4)
        L_0x002c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.analytics.dp.ikl(android.content.Context, java.lang.String):java.lang.String");
    }

    public static String klm() {
        return lmn("ro.build.version.emui", "");
    }

    public static String klm(Context context) {
        FeatureInfo[] systemAvailableFeatures = context.getPackageManager().getSystemAvailableFeatures();
        List unmodifiableList = Collections.unmodifiableList(Arrays.asList(lmn));
        StringBuilder sb2 = new StringBuilder();
        for (FeatureInfo featureInfo : systemAvailableFeatures) {
            String str = featureInfo.name;
            if (!TextUtils.isEmpty(str) && !unmodifiableList.contains(str) && (str.startsWith("android.hardware.type.") || str.startsWith("android.software."))) {
                sb2.append(str);
                sb2.append("|");
            }
        }
        sb2.append(efg());
        return klm(sb2.toString());
    }

    public static String klm(Context context, String str) {
        if (!ghi(context) && !Profile.Country.CN.equals(str)) {
            return "";
        }
        String string = Settings.Global.getString(context.getContentResolver(), "unified_device_name");
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        String lmn2 = lmn("ro.config.marketing_name", "");
        return TextUtils.isEmpty(lmn2) ? Build.MODEL : lmn2;
    }

    private static String klm(String str) {
        return str.length() > 0 ? str.substring(0, str.length() - 1) : str;
    }

    public static long lmn(long j11) {
        return (j11 / 1024) / 1024;
    }

    public static Application lmn() {
        String str;
        try {
            return (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke((Object) null, (Object[]) null);
        } catch (IllegalAccessException unused) {
            str = "getApplication(): method invoke Exception!";
            HiLog.w("DeviceToolsKit", str);
            return null;
        } catch (IllegalArgumentException unused2) {
            str = "getApplication(): Illegal Argument!";
            HiLog.w("DeviceToolsKit", str);
            return null;
        } catch (InvocationTargetException unused3) {
            str = "getApplication(): Invocation Target Exception!";
            HiLog.w("DeviceToolsKit", str);
            return null;
        } catch (ClassNotFoundException unused4) {
            str = "getApplication(): ClassNotFoundException!";
            HiLog.w("DeviceToolsKit", str);
            return null;
        } catch (NoSuchMethodException unused5) {
            str = "getApplication(): NoSuchMethodException!";
            HiLog.w("DeviceToolsKit", str);
            return null;
        }
    }

    private static Object lmn(String str, String str2, Class<?>[] clsArr, Object[] objArr) {
        try {
            return Class.forName(str).getMethod(str2, clsArr).invoke((Object) null, objArr);
        } catch (Exception unused) {
            HiLog.w("DeviceToolsKit", "invokeStaticFun() Exception");
            return null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: java.lang.Boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String lmn(android.content.Context r8) {
        /*
            r0 = 2
            java.lang.Class[] r1 = new java.lang.Class[r0]
            java.lang.Class<java.lang.String> r2 = java.lang.String.class
            r3 = 0
            r1[r3] = r2
            java.lang.Class r2 = java.lang.Boolean.TYPE
            r4 = 1
            r1[r4] = r2
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r2 = "ro.kernel.qemu"
            r0[r3] = r2
            java.lang.Boolean r5 = java.lang.Boolean.FALSE
            r0[r4] = r5
            java.lang.String r4 = "com.huawei.android.os.SystemPropertiesEx"
            java.lang.String r6 = "getBoolean"
            java.lang.Object r0 = lmn(r4, r6, r1, r0)
            boolean r1 = r0 instanceof java.lang.Boolean
            if (r1 == 0) goto L_0x0026
            r5 = r0
            java.lang.Boolean r5 = (java.lang.Boolean) r5
        L_0x0026:
            boolean r0 = r5.booleanValue()
            if (r0 == 0) goto L_0x002d
            return r2
        L_0x002d:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            android.content.pm.PackageManager r8 = r8.getPackageManager()
            android.content.pm.FeatureInfo[] r8 = r8.getSystemAvailableFeatures()
            int r1 = r8.length
        L_0x003b:
            if (r3 >= r1) goto L_0x0068
            r2 = r8[r3]
            java.lang.String r2 = r2.name
            boolean r4 = android.text.TextUtils.isEmpty(r2)
            if (r4 != 0) goto L_0x0065
            java.lang.String r4 = "com.huawei.software.features"
            boolean r5 = r2.startsWith(r4)
            r6 = 124(0x7c, float:1.74E-43)
            if (r5 == 0) goto L_0x0058
        L_0x0051:
            r0.append(r2)
            r0.append(r6)
            goto L_0x0065
        L_0x0058:
            java.lang.String r5 = "com.hihonor.software.features"
            boolean r7 = r2.startsWith(r5)
            if (r7 == 0) goto L_0x0065
            java.lang.String r2 = r2.replace(r5, r4)
            goto L_0x0051
        L_0x0065:
            int r3 = r3 + 1
            goto L_0x003b
        L_0x0068:
            java.lang.String r8 = r0.toString()
            java.lang.String r8 = klm((java.lang.String) r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.analytics.dp.lmn(android.content.Context):java.lang.String");
    }

    public static String lmn(String str) {
        String str2;
        if (TextUtils.isEmpty(str) || str.length() > 128) {
            str2 = "The length of the install channel value is invalid.";
        } else if (aq.lmn.matcher(str).matches()) {
            HiLog.d("DeviceToolsKit", "get install channel success.");
            return str;
        } else {
            str2 = "The install channel value is invalid.";
        }
        HiLog.e("DeviceToolsKit", str2);
        return "";
    }

    public static String lmn(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        String lmn2 = lmn("android.os.SystemProperties", str, str2);
        return TextUtils.isEmpty(lmn2) ? lmn("com.huawei.android.os.SystemPropertiesEx", str, str2) : lmn2;
    }

    private static String lmn(String str, String str2, String str3) {
        Class<String> cls = String.class;
        Object lmn2 = lmn(str, "get", new Class[]{cls, cls}, new Object[]{str2, str3});
        if (lmn2 != null) {
            str3 = (String) lmn2;
        }
        return (TextUtils.isEmpty(str3) || str3.toLowerCase(Locale.ENGLISH).contains("error")) ? "" : str3;
    }

    public static boolean lmn(Context context, String str) {
        String str2;
        StringBuilder sb2;
        Bundle bundle;
        Object obj;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null || (obj = bundle.get(str)) == null) {
                return true;
            }
            return ((Boolean) obj).booleanValue();
        } catch (PackageManager.NameNotFoundException unused) {
            sb2 = new StringBuilder();
            sb2.append(str);
            str2 = " The packageName is not correct!";
            sb2.append(str2);
            HiLog.w("DeviceToolsKit", sb2.toString());
            return true;
        } catch (Exception unused2) {
            sb2 = new StringBuilder("get ");
            sb2.append(str);
            str2 = " failed";
            sb2.append(str2);
            HiLog.w("DeviceToolsKit", sb2.toString());
            return true;
        }
    }
}
