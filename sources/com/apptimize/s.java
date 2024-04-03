package com.apptimize;

import android.app.UiModeManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.android.gms.ads.AdError;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.bytebuddy.utility.JavaConstant;
import tracking.ScreenNames;

public class s implements be {

    /* renamed from: a  reason: collision with root package name */
    private static final String f43149a = "s";

    /* renamed from: b  reason: collision with root package name */
    private static final List<String> f43150b;

    /* renamed from: c  reason: collision with root package name */
    private static final Set<String> f43151c;

    /* renamed from: d  reason: collision with root package name */
    private static final s f43152d = new s();

    /* renamed from: e  reason: collision with root package name */
    private Context f43153e;

    /* renamed from: f  reason: collision with root package name */
    private au f43154f;

    static {
        ArrayList arrayList = new ArrayList();
        f43150b = arrayList;
        arrayList.add("platform");
        arrayList.add("device_class");
        arrayList.add("screen_height");
        arrayList.add("screen_width");
        arrayList.add("screen_scale");
        arrayList.add("system_version");
        arrayList.add("system_country");
        arrayList.add("system_language");
        arrayList.add("user_language");
        arrayList.add("app_language");
        arrayList.add("app_package_name");
        arrayList.add("app_version");
        arrayList.add("app_version_code");
        arrayList.add(ScreenNames.SCREEN_TYPE_BRAND);
        arrayList.add("manufacturer");
        arrayList.add(DeviceRequestsHelper.DEVICE_INFO_MODEL);
        arrayList.add("apptimize_platform");
        arrayList.add("apptimize_version");
        arrayList.add("apptimize_variant");
        arrayList.add("apptimize_multiprocess");
        arrayList.add("app_installed_date");
        arrayList.add("app_first_run_date");
        arrayList.add("distribution_method");
        arrayList.add("system_architecture");
        arrayList.add("android_ui_mode");
        HashSet hashSet = new HashSet();
        f43151c = hashSet;
        hashSet.add("app_version");
        hashSet.add("apptimize_version");
        hashSet.add("apptimize_variant");
        hashSet.add("system_version");
    }

    private s() {
    }

    private Double A() {
        long j11;
        long a11 = i.a().a(this.f43153e, "ApptimizeAppFirstDate", -1);
        if (a11 == -1) {
            j11 = a(a11, String.valueOf(this.f43153e.getCacheDir()), String.valueOf(this.f43153e.getFilesDir()));
        } else {
            j11 = a11;
        }
        int i11 = (j11 > -1 ? 1 : (j11 == -1 ? 0 : -1));
        if (!(i11 == 0 || j11 == a11)) {
            i.a().b(this.f43153e, "ApptimizeAppFirstDate", j11);
        }
        if (i11 == 0) {
            return null;
        }
        return Double.valueOf(((double) j11) / 1000.0d);
    }

    private String B() {
        return c.d(this.f43153e, this.f43154f) ? "developer" : "store";
    }

    private String C() {
        return c.b();
    }

    private String D() {
        return a(((UiModeManager) this.f43153e.getSystemService("uimode")).getCurrentModeType());
    }

    private long a(long j11, long j12) {
        return (j11 <= 0 || (j12 != -1 && j11 >= j12)) ? j12 : j11;
    }

    public static s a(Context context, au auVar) {
        s sVar = f43152d;
        sVar.f43153e = context.getApplicationContext();
        sVar.f43154f = auVar;
        return sVar;
    }

    private String c() {
        return "Android";
    }

    private String d() {
        return this.f43153e.getResources().getConfiguration().smallestScreenWidthDp >= 600 ? "tablet" : "phone";
    }

    private Integer e() {
        return Integer.valueOf(h().y);
    }

    private Integer f() {
        return Integer.valueOf(h().x);
    }

    private Float g() {
        DisplayMetrics j11 = j();
        if (j11 != null) {
            return Float.valueOf(j11.density);
        }
        return Float.valueOf(0.0f);
    }

    private Point h() {
        Point point = new Point(0, 0);
        Display i11 = i();
        if (i11 == null) {
            return point;
        }
        i11.getRealSize(point);
        int i12 = point.x;
        int i13 = point.y;
        int rotation = i11.getRotation();
        if (rotation == 0 || rotation == 2) {
            return new Point(i12, i13);
        }
        return new Point(i13, i12);
    }

    private Display i() {
        if (Build.VERSION.SDK_INT >= 30) {
            DisplayManager displayManager = (DisplayManager) this.f43153e.getSystemService("display");
            if (displayManager != null) {
                return displayManager.getDisplay(0);
            }
            return null;
        }
        WindowManager windowManager = (WindowManager) this.f43153e.getSystemService("window");
        if (windowManager != null) {
            return windowManager.getDefaultDisplay();
        }
        return null;
    }

    private DisplayMetrics j() {
        Display i11 = i();
        if (i11 == null) {
            return null;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        i11.getMetrics(displayMetrics);
        return displayMetrics;
    }

    private String k() {
        return Build.VERSION.RELEASE;
    }

    private String l() {
        return this.f43153e.getResources().getConfiguration().locale.getCountry();
    }

    private String m() {
        return this.f43153e.getResources().getConfiguration().locale.getLanguage();
    }

    private String n() {
        return this.f43153e.getResources().getConfiguration().locale.getLanguage();
    }

    private String o() {
        return this.f43153e.getResources().getConfiguration().locale.getLanguage();
    }

    private String p() {
        try {
            return c.a(this.f43153e, 0).packageName;
        } catch (PackageManager.NameNotFoundException | RuntimeException e11) {
            bo.b(f43149a, "Could not get PackageInfo", e11);
            return null;
        }
    }

    private String q() {
        try {
            return c.a(this.f43153e, 0).versionName;
        } catch (PackageManager.NameNotFoundException | RuntimeException e11) {
            bo.b(f43149a, "Could not get PackageInfo", e11);
            return null;
        }
    }

    private Integer r() {
        try {
            return Integer.valueOf(c.a(this.f43153e, 0).versionCode);
        } catch (PackageManager.NameNotFoundException | RuntimeException e11) {
            bo.b(f43149a, "Could not get PackageInfo", e11);
            return null;
        }
    }

    private String s() {
        return Build.BRAND;
    }

    private String t() {
        return Build.MANUFACTURER;
    }

    private String u() {
        return Build.MODEL;
    }

    private String v() {
        return "Android";
    }

    private String w() {
        return fx.a();
    }

    private String x() {
        return Integer.valueOf(t.b()).toString();
    }

    private int y() {
        ApptimizeOptions apptimizeOptions = Apptimize.getApptimizeOptions();
        if (apptimizeOptions == null) {
            return 0;
        }
        return apptimizeOptions.isMultiprocessModeEnabled() ? 1 : 0;
    }

    private Double z() {
        try {
            return Double.valueOf(((double) c.a(this.f43153e, 0).firstInstallTime) / 1000.0d);
        } catch (PackageManager.NameNotFoundException | RuntimeException e11) {
            bo.b(f43149a, "Could not get PackageInfo", e11);
            return null;
        }
    }

    public String a(int i11) {
        switch (i11) {
            case 0:
                return AdError.UNDEFINED_DOMAIN;
            case 1:
                return "normal";
            case 2:
                return "desk";
            case 3:
                return "car";
            case 4:
                return "television";
            case 5:
                return "appliance";
            case 6:
                return "watch";
            case 7:
                return "vrheadset";
            default:
                return null;
        }
    }

    public List<String> b() {
        return f43150b;
    }

    public boolean c(String str) {
        return str != null && f43151c.contains(str);
    }

    private String d(String str) {
        return str.replace(JavaConstant.Dynamic.DEFAULT_NAME, "").toLowerCase();
    }

    public boolean b(String str) {
        return b().contains(str);
    }

    private long a(long j11, File file) {
        if (!file.exists()) {
            return j11;
        }
        long a11 = a(file.lastModified(), j11);
        for (File lastModified : file.listFiles()) {
            a11 = a(lastModified.lastModified(), a11);
        }
        return a11;
    }

    private long a(long j11, String str, String str2) {
        String substring = str.substring(0, str.lastIndexOf(47));
        long a11 = a(a(j11, new File(str)), new File(str2));
        long a12 = a(a11, new File(substring + "/databases"));
        return a(a12, new File(substring + "/shared_prefs"));
    }

    public Map<String, Object> a() {
        HashMap hashMap = new HashMap();
        for (String next : b()) {
            Object a11 = a(next);
            if (a11 != null) {
                hashMap.put(next, a11);
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }

    public Object a(String str) {
        try {
            String d11 = d(str);
            if ("platform".equals(d11)) {
                return c();
            }
            if ("deviceclass".equals(d11)) {
                return d();
            }
            if ("screenheight".equals(d11)) {
                return e();
            }
            if ("screenwidth".equals(d11)) {
                return f();
            }
            if ("screenscale".equals(d11)) {
                return g();
            }
            if ("systemversion".equals(d11)) {
                return k();
            }
            if ("systemcountry".equals(d11)) {
                return l();
            }
            if ("systemlanguage".equals(d11)) {
                return m();
            }
            if ("userlanguage".equals(d11)) {
                return n();
            }
            if ("applanguage".equals(d11)) {
                return o();
            }
            if ("apppackagename".equals(d11)) {
                return p();
            }
            if ("appversion".equals(d11)) {
                return q();
            }
            if ("appversioncode".equals(d11)) {
                return r();
            }
            if (ScreenNames.SCREEN_TYPE_BRAND.equals(d11)) {
                return s();
            }
            if ("manufacturer".equals(d11)) {
                return t();
            }
            if (DeviceRequestsHelper.DEVICE_INFO_MODEL.equals(d11)) {
                return u();
            }
            if ("apptimizeplatform".equals(d11)) {
                return v();
            }
            if ("apptimizeversion".equals(d11)) {
                return w();
            }
            if ("apptimizevariant".equals(d11)) {
                return x();
            }
            if ("apptimizemultiprocess".equals(d11)) {
                return Integer.valueOf(y());
            }
            if ("appinstalleddate".equals(d11)) {
                return z();
            }
            if ("appfirstrundate".equals(d11)) {
                return A();
            }
            if ("distributionmethod".equals(d11)) {
                return B();
            }
            if ("systemarchitecture".equals(d11)) {
                return C();
            }
            if ("androiduimode".equals(d11)) {
                return D();
            }
            return null;
        } catch (RuntimeException e11) {
            String str2 = f43149a;
            bo.b(str2, "Error getting device property: " + str, e11);
            return null;
        } catch (IncompatibleClassChangeError e12) {
            String str3 = f43149a;
            bo.b(str3, "Error getting device property: " + str, e12);
            return null;
        }
    }
}
