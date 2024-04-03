package com.apptimize;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.net.TrafficStats;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.StrictMode;
import com.apptimize.bq;
import com.apptimize.i;
import j$.util.DateRetargetInterface;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f41585a = "c";

    /* renamed from: b  reason: collision with root package name */
    private static Boolean f41586b;

    /* renamed from: c  reason: collision with root package name */
    private static Boolean f41587c;

    /* renamed from: d  reason: collision with root package name */
    private static Thread f41588d;

    /* renamed from: e  reason: collision with root package name */
    private static Set<Integer> f41589e;

    /* renamed from: f  reason: collision with root package name */
    private static final Set<String> f41590f = new HashSet(Arrays.asList(new String[]{"CN=Android Debug", "O=Android", "C=US"}));

    /* renamed from: g  reason: collision with root package name */
    private static Handler f41591g;

    /* renamed from: h  reason: collision with root package name */
    private static Boolean f41592h = null;

    /* renamed from: i  reason: collision with root package name */
    private static String f41593i = null;

    public static class a extends Date implements DateRetargetInterface {
        /* JADX WARNING: Can't wrap try/catch for region: R(3:6|7|11) */
        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            return new java.text.SimpleDateFormat("EEE MMM dd HH:mm:ss 'UKN' yyyy").format(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x001d, code lost:
            return "";
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0011 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String toString() {
            /*
                r2 = this;
                boolean r0 = com.apptimize.av.f41252o     // Catch:{ AssertionError | Exception -> 0x0011 }
                if (r0 != 0) goto L_0x0009
                java.lang.String r0 = super.toString()     // Catch:{ AssertionError | Exception -> 0x0011 }
                goto L_0x001f
            L_0x0009:
                java.lang.AssertionError r0 = new java.lang.AssertionError     // Catch:{ AssertionError | Exception -> 0x0011 }
                java.lang.String r1 = "test"
                r0.<init>(r1)     // Catch:{ AssertionError | Exception -> 0x0011 }
                throw r0     // Catch:{ AssertionError | Exception -> 0x0011 }
            L_0x0011:
                java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat     // Catch:{ AssertionError | Exception -> 0x001d }
                java.lang.String r1 = "EEE MMM dd HH:mm:ss 'UKN' yyyy"
                r0.<init>(r1)     // Catch:{ AssertionError | Exception -> 0x001d }
                java.lang.String r0 = r0.format(r2)     // Catch:{ AssertionError | Exception -> 0x001d }
                goto L_0x001f
            L_0x001d:
                java.lang.String r0 = ""
            L_0x001f:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.apptimize.c.a.toString():java.lang.String");
        }

        private a() {
        }

        private a(Long l11) {
            super(l11.longValue());
        }
    }

    static {
        Handler handler;
        if (Looper.getMainLooper() != null) {
            handler = new Handler(Looper.getMainLooper());
        } else {
            handler = null;
        }
        f41591g = handler;
    }

    public static String a(Context context, au auVar) {
        Context applicationContext = context.getApplicationContext();
        final AtomicReference atomicReference = new AtomicReference((Object) null);
        atomicReference.set(i.a().a(applicationContext, "fakeGUID", (String) null));
        if (atomicReference.get() == null) {
            i.a().a(applicationContext, (i.a) new i.a() {
                public void a(SharedPreferences sharedPreferences, SharedPreferences.Editor editor) {
                    atomicReference.set(sharedPreferences.getString("fakeGUID", (String) null));
                    if (atomicReference.get() == null) {
                        atomicReference.set(UUID.randomUUID().toString());
                        editor.putString("fakeGUID", (String) atomicReference.get());
                    }
                }
            });
        }
        return (String) atomicReference.get();
    }

    public static boolean b(Context context, au auVar) {
        if (f41586b == null) {
            e(context, auVar);
        }
        return f41586b.booleanValue();
    }

    public static boolean c(Context context, au auVar) {
        if (f41587c == null) {
            e(context, auVar);
        }
        return f41587c.booleanValue();
    }

    public static synchronized boolean d(Context context, au auVar) {
        boolean booleanValue;
        synchronized (c.class) {
            if (f41592h == null) {
                f41592h = Boolean.valueOf(f(context, auVar));
            }
            booleanValue = f41592h.booleanValue();
        }
        return booleanValue;
    }

    private static void e(Context context, au auVar) {
        Boolean bool = Boolean.FALSE;
        f41586b = bool;
        f41587c = bool;
        boolean z11 = false;
        try {
            PackageInfo a11 = a(context, 0);
            String str = a11.versionName + " " + a11.versionCode;
            String a12 = i.a().a(context, "priorVersion", (String) null);
            if (a12 == null) {
                z11 = true;
            }
            f41586b = Boolean.valueOf(z11);
            if (a12 == null || !str.equals(a12)) {
                f41587c = Boolean.TRUE;
                i.a().b(context, "priorVersion", str);
            }
        } catch (PackageManager.NameNotFoundException | RuntimeException e11) {
            bo.b(f41585a, "Could not get PackageInfo", e11);
        }
    }

    private static boolean f(Context context, au auVar) {
        if ((context.getApplicationInfo().flags & 2) != 0) {
            return true;
        }
        try {
            PackageInfo a11 = a(context, 64);
            try {
                CertificateFactory instance = CertificateFactory.getInstance("X.509");
                Signature[] signatureArr = a11.signatures;
                int i11 = 0;
                while (i11 < signatureArr.length) {
                    try {
                        X509Certificate x509Certificate = (X509Certificate) instance.generateCertificate(new ByteArrayInputStream(signatureArr[i11].toByteArray()));
                        if (new HashSet(Arrays.asList(x509Certificate.getSubjectX500Principal().getName().split(","))).containsAll(f41590f)) {
                            return true;
                        }
                        if (!((a11.applicationInfo.flags & 2) == 0 || auVar == null)) {
                            auVar.a().a(bq.b.UnexpectedSignatureInDebugBuild, (Map<String, Object>) new HashMap<String, Object>(x509Certificate) {

                                /* renamed from: a  reason: collision with root package name */
                                final /* synthetic */ X509Certificate f41596a;

                                {
                                    this.f41596a = r2;
                                    put("value", r2.getIssuerX500Principal().getName());
                                }
                            });
                        }
                        i11++;
                    } catch (CertificateException e11) {
                        bo.d(f41585a, "Certificate exception; skipping.", e11);
                    }
                }
                return false;
            } catch (CertificateException e12) {
                bo.g(f41585a, "Unable to instantiate a certificate factory; assuming not debuggable.", e12);
                return false;
            }
        } catch (PackageManager.NameNotFoundException | RuntimeException e13) {
            bo.g(f41585a, "Could not find the package and thus determine if we're signed with a debug build; assuming no.", e13);
            return false;
        }
    }

    public static boolean g(Context context) {
        if (f(context)) {
            return true;
        }
        try {
            PackageInfo a11 = a(context, 14);
            for (ActivityInfo activityInfo : a11.receivers) {
                if (!activityInfo.processName.equals(a11.applicationInfo.processName)) {
                    return true;
                }
            }
            for (ServiceInfo serviceInfo : a11.services) {
                if (!serviceInfo.processName.equals(a11.applicationInfo.processName)) {
                    return true;
                }
            }
            for (ProviderInfo providerInfo : a11.providers) {
                if (!providerInfo.processName.equals(a11.applicationInfo.processName)) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
            bo.g(f41585a, "Unable to lookup process info");
            return true;
        }
    }

    public static String h(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            bo.j(f41585a, "Cannot get name of current process");
            return "";
        }
        for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
            if (next.pid == Process.myPid()) {
                return next.processName;
            }
        }
        bo.j(f41585a, "Cannot get name of current process");
        return "";
    }

    public static String i(Context context) {
        try {
            return a(context, 0).versionName;
        } catch (PackageManager.NameNotFoundException | RuntimeException e11) {
            bo.b(f41585a, "Could not get bundle version", e11);
            return "UNKNOWN";
        }
    }

    public static File j(Context context) {
        StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        try {
            File file = new File(context.getExternalFilesDir((String) null), "output-files");
            file.mkdirs();
            return file;
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
        }
    }

    public static Set<Integer> k(Context context) {
        Set<Integer> set = f41589e;
        if (set != null) {
            return set;
        }
        HashSet hashSet = new HashSet();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            bo.e(f41585a, "Cannot get list of processes");
            return hashSet;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            hashSet.add(Integer.valueOf(runningAppProcessInfo.pid));
        }
        return hashSet;
    }

    public static void i() {
        int id2 = (int) Thread.currentThread().getId();
        while (id2 >= -256 && id2 <= -1) {
            id2 += 100;
        }
        TrafficStats.setThreadStatsTag(id2);
    }

    public static boolean b(Context context) {
        Activity c11 = c(context);
        return c11 != null && c11.hasWindowFocus();
    }

    public static Activity c(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            Context baseContext = ((ContextWrapper) context).getBaseContext();
            if (baseContext instanceof Activity) {
                return (Activity) baseContext;
            }
        }
        if (gn.w()) {
            try {
                Class<?> cls = Class.forName("android.app.ActivityThread");
                Object invoke = cls.getMethod("currentActivityThread", new Class[0]).invoke((Object) null, new Object[0]);
                Field declaredField = cls.getDeclaredField("mActivities");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(invoke);
                if (obj == null) {
                    gn.x();
                    return null;
                }
                for (Object next : ((Map) obj).values()) {
                    Class<?> cls2 = next.getClass();
                    Field declaredField2 = cls2.getDeclaredField("paused");
                    declaredField2.setAccessible(true);
                    if (!declaredField2.getBoolean(next)) {
                        Field declaredField3 = cls2.getDeclaredField("activity");
                        declaredField3.setAccessible(true);
                        Activity activity = (Activity) declaredField3.get(next);
                        gn.x();
                        return activity;
                    }
                }
                gn.x();
            } catch (ClassNotFoundException e11) {
                bo.i(f41585a, "ClassNotFoundException", e11);
            } catch (IllegalAccessException e12) {
                bo.i(f41585a, "IllegalAccessException", e12);
            } catch (InvocationTargetException e13) {
                bo.i(f41585a, "InvocationTargetException", e13);
            } catch (NoSuchFieldException e14) {
                bo.i(f41585a, "NoSuchFieldException", e14);
            } catch (NoSuchMethodException e15) {
                bo.i(f41585a, "NoSuchMethodException", e15);
            } catch (ClassCastException e16) {
                bo.i(f41585a, "ClassCastException", e16);
            } catch (NullPointerException e17) {
                bo.i(f41585a, "NullPointerException", e17);
            } catch (Exception e18) {
                bo.i(f41585a, "Unknown Exception", e18);
            } catch (Throwable th2) {
                gn.x();
                throw th2;
            }
        }
        return null;
    }

    public static boolean d() {
        String b11 = b();
        return b11.equals("aarch64") || b11.startsWith("arm64");
    }

    public static String b() {
        String str = f41593i;
        if (str != null) {
            return str;
        }
        String str2 = Build.SUPPORTED_ABIS[0];
        f41593i = str2;
        return str2;
    }

    public static boolean d(Context context) {
        try {
            return a(context, 0).applicationInfo.processName.equals(h(context));
        } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
            bo.g(f41585a, "Unable to lookup application process name");
            return false;
        }
    }

    public static String a(Context context) {
        return i.a().a(context, "savedUserId", (String) null);
    }

    public static void a(Context context, final String str) {
        i.a().a(context, (i.a) new i.a() {
            public void a(SharedPreferences sharedPreferences, SharedPreferences.Editor editor) {
                editor.putString("savedUserId", str);
            }
        });
    }

    public static String b(Context context, String str) {
        ServiceInfo[] serviceInfoArr;
        try {
            PackageInfo a11 = a(context, 4);
            if (!(a11 == null || (serviceInfoArr = a11.services) == null)) {
                for (ServiceInfo serviceInfo : serviceInfoArr) {
                    String str2 = serviceInfo.name;
                    if (str2 != null && str2.equals(str)) {
                        return serviceInfo.processName;
                    }
                }
            }
            bo.j(f41585a, "Cannot find service " + str + ". Is the Apptimize service correctly configured in your Android manifest?");
            return "";
        } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
            bo.g(f41585a, "Unable to lookup service process name");
            return "";
        }
    }

    public static String h() {
        return Integer.toString(Build.VERSION.SDK_INT);
    }

    public static boolean a() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static String a(ApptimizeOptions apptimizeOptions, String str) {
        if (apptimizeOptions.getDeviceName() != null) {
            return apptimizeOptions.getDeviceName();
        }
        return Build.MODEL + " " + str.substring(0, 6);
    }

    public static String g() {
        String str = Build.MANUFACTURER;
        if (Character.isLowerCase(str.charAt(0))) {
            str = Character.toUpperCase(str.charAt(0)) + str.substring(1);
        }
        return str + " " + Build.MODEL;
    }

    public static boolean e() {
        return b().endsWith("86");
    }

    public static boolean e(Context context) {
        try {
            return !context.getPackageManager().queryIntentServices(new Intent(context, ApptimizeService.class), 65536).isEmpty();
        } catch (Exception e11) {
            String str = f41585a;
            bo.g(str, "Failed to get package manager info. " + e11.getMessage());
            return false;
        }
    }

    public static JSONObject a(Context context, boolean z11) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", (Object) "WysiwygDeviceInformation");
        jSONObject.put("interfaceType", (Object) "android");
        jSONObject.put("OSVersion", (Object) Build.VERSION.RELEASE);
        jSONObject.put("disabled", z11);
        jSONObject.put("softwareVersion", (Object) i(context));
        return jSONObject;
    }

    public static boolean f() {
        return b().equals("x86_64");
    }

    public static boolean f(Context context) {
        try {
            PackageInfo a11 = a(context, 1);
            for (ActivityInfo activityInfo : a11.activities) {
                if (!activityInfo.processName.equals(a11.applicationInfo.processName)) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
            bo.g(f41585a, "Unable to lookup activity info");
            return true;
        }
    }

    public static void a(final Context context, final ClipData clipData, final String str) {
        final AnonymousClass4 r02 = new fi() {
            public void run() {
                String str = c.f41585a;
                AnonymousClass1 r12 = new fi() {
                    public void run() {
                        try {
                            ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                            if (clipboardManager == null) {
                                bo.j(c.f41585a, "Clipboard Not Found");
                            } else {
                                clipboardManager.setPrimaryClip(clipData);
                            }
                        } catch (SecurityException unused) {
                            String str = c.f41585a;
                            bo.j(str, "SecurityException while writing " + str + " to clipboard.");
                        } catch (NullPointerException unused2) {
                        }
                    }
                };
                fe.a(str, (fi) r12, "Exception while writing " + str + " to clipboard.");
            }
        };
        if (a()) {
            r02.run();
            return;
        }
        AnonymousClass5 r12 = new Thread() {
            public void run() {
                String str = c.f41585a;
                AnonymousClass1 r12 = new fi() {
                    public void run() {
                        Looper.prepare();
                        r02.run();
                    }
                };
                fe.a(str, (fi) r12, "Exception while writing " + str + " to clipboard.");
            }
        };
        r12.start();
        try {
            r12.join();
        } catch (InterruptedException unused) {
            String str2 = f41585a;
            bo.h(str2, "Thread interrupted when writing " + str + " to clipboard");
            Thread.interrupted();
        }
    }

    public static boolean a(List list) {
        return list == null || list.isEmpty();
    }

    public static boolean a(Activity activity) {
        return activity != null && activity.getClass().isAnnotationPresent(ApptimizeExplicitlyEnabled.class);
    }

    public static void a(final fi fiVar) {
        AnonymousClass6 r02 = new Runnable() {
            public void run() {
                fe.a(c.f41585a, fi.this);
            }
        };
        Handler handler = f41591g;
        if (handler != null) {
            handler.post(r02);
        } else {
            fg.f42429d.submit(r02);
        }
    }

    public static String a(Collection<String> collection, String str) {
        StringBuilder sb2 = new StringBuilder();
        Iterator<String> it = collection.iterator();
        while (it.hasNext()) {
            sb2.append(it.next());
            if (it.hasNext()) {
                sb2.append(str);
            }
        }
        return sb2.toString();
    }

    public static boolean c() {
        String b11 = b();
        return b11.startsWith("arm") && !b11.equals("armeabi") && !d();
    }

    public static Date a(Long l11) {
        return new a(l11);
    }

    public static PackageInfo a(Context context, int i11) throws PackageManager.NameNotFoundException {
        int i12 = av.f41251n;
        if (i12 > 0) {
            int i13 = i12 - 1;
            av.f41251n = i13;
            if (i13 == 0) {
                bo.k(f41585a, "Throwing test exception for PackageManager");
                throw new RuntimeException("PackageManager test exception");
            }
        }
        return context.getPackageManager().getPackageInfo(context.getPackageName(), i11);
    }
}
