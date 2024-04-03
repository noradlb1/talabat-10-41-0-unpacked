package com.uxcam.internals;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Pair;
import android.util.TypedValue;
import com.uxcam.internals.gu;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

public class ia {

    /* renamed from: a  reason: collision with root package name */
    public static final String f13615a = "ia";

    /* renamed from: b  reason: collision with root package name */
    public static String[] f13616b = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"};

    /* renamed from: c  reason: collision with root package name */
    public static Context f13617c = null;

    /* renamed from: d  reason: collision with root package name */
    public static WeakReference f13618d = new WeakReference((Object) null);

    /* renamed from: e  reason: collision with root package name */
    public static final /* synthetic */ boolean f13619e = true;

    public static boolean a(File file) {
        if (file.isDirectory()) {
            for (File name2 : file.listFiles()) {
                if (name2.getName().contains("data")) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void b(File file) {
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                if (file2.getName().contains("data") || file2.getName().contains("video")) {
                    file2.delete();
                }
            }
        }
    }

    public static void c(File file) {
        File[] listFiles;
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File c11 : listFiles) {
                c(c11);
            }
        }
        file.delete();
    }

    public static float d() {
        long j11 = gk.f13444f;
        if (j11 <= 0) {
            return 0.0f;
        }
        return ((float) (SystemClock.elapsedRealtime() - j11)) / 1000.0f;
    }

    public static float e() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return ((float) (statFs.getBlockCountLong() * statFs.getBlockSizeLong())) / 1048576.0f;
    }

    public static int f(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return (int) (memoryInfo.totalMem / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
    }

    public static boolean g() {
        String[] strArr = {"/sbin/", "/system/bin/", "/system/xbin/", "/data/local/xbin/", "/data/local/bin/", "/system/sd/xbin/", "/system/bin/failsafe/", "/data/local/"};
        for (int i11 = 0; i11 < 8; i11++) {
            if (new File(strArr[i11] + "su").exists()) {
                return true;
            }
        }
        return false;
    }

    public static long d(File file) {
        long j11;
        long j12 = 0;
        try {
            File[] listFiles = file.listFiles();
            Objects.requireNonNull(listFiles);
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    j11 = file2.length();
                } else {
                    j11 = d(file2);
                }
                j12 += j11;
            }
            return j12;
        } catch (Exception e11) {
            e11.printStackTrace();
            return 0;
        }
    }

    public static void a(Activity activity) {
        f13618d = new WeakReference(activity);
        if (activity != null) {
            f13617c = activity.getApplicationContext();
        }
    }

    public static String e(Context context) {
        if (bh.c(context)) {
            return "wifi";
        }
        if (bh.b(context)) {
            return "mobile data";
        }
        return bh.a(context) ? "unknown" : "no network";
    }

    public static Context b() {
        return f13617c;
    }

    public static boolean f() {
        String str = Build.FINGERPRINT;
        if (!str.startsWith("generic") && !str.startsWith("unknown")) {
            String str2 = Build.MODEL;
            return !str2.contains("google_sdk") && !str2.contains("Emulator") && !str2.contains("Android SDK built for x86") && !Build.MANUFACTURER.contains("Genymotion") && (!Build.BRAND.startsWith("generic") || !Build.DEVICE.startsWith("generic")) && !"google_sdk".equals(Build.PRODUCT);
        }
    }

    public static String a(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        int i11 = applicationInfo.labelRes;
        return i11 == 0 ? applicationInfo.nonLocalizedLabel.toString() : context.getString(i11);
    }

    public static String b(Context context) {
        String str = gm.f13454c;
        if (str == null || str.isEmpty()) {
            return context.getApplicationInfo().packageName;
        }
        return gm.f13454c;
    }

    public static Context c() {
        return (Context) f13618d.get();
    }

    public static Pair<String, Integer> c(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            String str = f13615a;
            gu.ab a11 = gu.a(str);
            String str2 = packageInfo.versionName;
            a11.getClass();
            gu.a(str).getClass();
            return new Pair<>(packageInfo.versionName, Integer.valueOf(packageInfo.versionCode));
        } catch (PackageManager.NameNotFoundException unused) {
            gu.f13504c.getClass();
            return null;
        }
    }

    public static boolean e(File file) {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return false;
            }
            for (File file2 : listFiles) {
                if (file2.getName().contains("data") && file2.length() == 0) {
                    return true;
                }
            }
            return false;
        } else if (file.length() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static JSONObject d(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            Intent registerReceiver = context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            int intExtra = registerReceiver.getIntExtra("level", -1);
            int intExtra2 = registerReceiver.getIntExtra("scale", -1);
            int intExtra3 = registerReceiver.getIntExtra("status", -1);
            int i11 = 1;
            if (intExtra3 != 1) {
                int i12 = 2;
                if (intExtra3 != 2) {
                    i12 = 3;
                    if (intExtra3 != 3) {
                        i11 = 4;
                        if (intExtra3 != 4) {
                            if (intExtra3 != 5) {
                            }
                        }
                    }
                    jSONObject.put("level", (double) ((((float) intExtra) / ((float) intExtra2)) * 100.0f));
                    jSONObject.put("chargeState", i11);
                    jSONObject.put("timeLine", (double) d());
                    return jSONObject;
                }
                i11 = i12;
                jSONObject.put("level", (double) ((((float) intExtra) / ((float) intExtra2)) * 100.0f));
                jSONObject.put("chargeState", i11);
                jSONObject.put("timeLine", (double) d());
                return jSONObject;
            }
            i11 = 0;
            jSONObject.put("level", (double) ((((float) intExtra) / ((float) intExtra2)) * 100.0f));
            jSONObject.put("chargeState", i11);
            jSONObject.put("timeLine", (double) d());
            return jSONObject;
        } catch (JSONException e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public static float a() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return ((float) (statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong())) / 1048576.0f;
    }

    public static boolean a(String[] strArr, boolean z11) {
        PackageInfo packageInfo;
        PackageManager packageManager = f13617c.getPackageManager();
        StringBuilder sb2 = new StringBuilder();
        try {
            packageInfo = packageManager.getPackageInfo(f13617c.getPackageName(), 4096);
        } catch (PackageManager.NameNotFoundException unused) {
            gu.f13504c.getClass();
            packageInfo = null;
        }
        if (f13619e || packageInfo != null) {
            String[] strArr2 = packageInfo.requestedPermissions;
            if (strArr2 != null) {
                for (String str : strArr) {
                    boolean z12 = false;
                    for (String compareTo : strArr2) {
                        if (str.compareTo(compareTo) == 0) {
                            z12 = true;
                        }
                    }
                    if (!z12) {
                        sb2.append(",");
                        sb2.append(str);
                        if (z11) {
                            gu.a("UXCam 3.4.4[561]").b("Missed permission : " + str + ". Add this permission to project’s manifest.", new Object[0]);
                        }
                    }
                }
                if (sb2.length() != 0) {
                    if (z11) {
                        gu.a(f13615a).getClass();
                    }
                    return false;
                }
            }
            return true;
        }
        throw new AssertionError();
    }

    public static int a(int i11) {
        int i12 = i11 % 16;
        return i11 + (i12 > 0 ? 16 - i12 : 0);
    }

    public static Map a(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.getString(next));
            }
        }
        return hashMap;
    }

    public static float a(float f11, Context context) {
        return TypedValue.applyDimension(5, f11, context.getResources().getDisplayMetrics());
    }

    public static boolean a(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }
}
