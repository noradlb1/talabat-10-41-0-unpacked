package com.apptimize;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.os.StrictMode;
import com.apptimize.ApptimizeOptions;
import com.apptimize.bq;
import com.apptimize.ff;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import com.tekartik.sqflite.Constant;
import datamodels.TypesAliasesKt;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class g {

    /* renamed from: c  reason: collision with root package name */
    private static final String f42476c = "g";

    /* renamed from: a  reason: collision with root package name */
    ff.a f42477a = null;

    /* renamed from: b  reason: collision with root package name */
    ff.a f42478b = null;

    /* renamed from: d  reason: collision with root package name */
    private final Context f42479d;

    /* renamed from: e  reason: collision with root package name */
    private String f42480e = "";

    /* renamed from: f  reason: collision with root package name */
    private final boolean f42481f;

    /* renamed from: g  reason: collision with root package name */
    private String f42482g = null;

    /* renamed from: h  reason: collision with root package name */
    private boolean f42483h = false;

    /* renamed from: i  reason: collision with root package name */
    private boolean f42484i = false;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f42485j;

    /* renamed from: k  reason: collision with root package name */
    private final File f42486k;

    /* renamed from: com.apptimize.g$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f42487a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.apptimize.ApptimizeOptions$LogLevel[] r0 = com.apptimize.ApptimizeOptions.LogLevel.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f42487a = r0
                com.apptimize.ApptimizeOptions$LogLevel r1 = com.apptimize.ApptimizeOptions.LogLevel.VERBOSE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f42487a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.apptimize.ApptimizeOptions$LogLevel r1 = com.apptimize.ApptimizeOptions.LogLevel.DEBUG     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f42487a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.apptimize.ApptimizeOptions$LogLevel r1 = com.apptimize.ApptimizeOptions.LogLevel.INFO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f42487a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.apptimize.ApptimizeOptions$LogLevel r1 = com.apptimize.ApptimizeOptions.LogLevel.WARNING     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f42487a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.apptimize.ApptimizeOptions$LogLevel r1 = com.apptimize.ApptimizeOptions.LogLevel.ERROR     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.apptimize.g.AnonymousClass1.<clinit>():void");
        }
    }

    /* JADX INFO: finally extract failed */
    public g(Context context, au auVar, boolean z11, boolean z12) {
        ff.a aVar;
        this.f42479d = context.getApplicationContext();
        this.f42485j = z12;
        if (!z12 && !z11) {
            this.f42486k = null;
            this.f42481f = false;
            this.f42482g = null;
            this.f42484i = false;
            this.f42483h = true;
        } else if (Build.VERSION.SDK_INT < 24) {
            this.f42486k = null;
            this.f42481f = false;
            this.f42482g = null;
            this.f42484i = false;
            this.f42483h = true;
            Apptimize.a("This device's Android version is below API 24, Apptimize has been disabled");
        } else {
            if (z11) {
                try {
                    int myPid = Process.myPid();
                    Iterator<ActivityManager.RunningAppProcessInfo> it = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ActivityManager.RunningAppProcessInfo next = it.next();
                        if (next.pid == myPid) {
                            this.f42480e = next.processName;
                            break;
                        }
                    }
                } catch (Exception unused) {
                }
            }
            ff.a a11 = ff.a(context, auVar, g());
            this.f42477a = a11;
            if (a11 != null) {
                String str = f42476c;
                bo.k(str, "crashReport found " + this.f42477a.a().getTime() + " " + this.f42477a.a() + " contents:" + this.f42477a.b());
            }
            ff.a b11 = ff.b(context, auVar, i());
            this.f42478b = b11;
            if (b11 != null) {
                String str2 = f42476c;
                bo.k(str2, "previousSetup found " + this.f42478b.a().getTime() + " " + this.f42478b.a());
            }
            StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
            try {
                File file = new File(context.getCacheDir(), f());
                this.f42486k = file;
                this.f42482g = a();
                StrictMode.setThreadPolicy(allowThreadDiskReads);
                if (this.f42482g != null) {
                    e();
                    file.delete();
                }
                ff.a aVar2 = this.f42477a;
                if (!(aVar2 == null || aVar2.b() == null || this.f42477a.b().length() <= 0)) {
                    String[] split = this.f42477a.b().split(TypesAliasesKt.separator);
                    if (split.length > 0 && split[0].equals("AN0148")) {
                        this.f42482g = "AN1018";
                        e();
                    }
                }
                if (this.f42482g == null && (aVar = this.f42477a) != null && this.f42478b != null && aVar.a().getTime() < this.f42478b.a().getTime() + 60000) {
                    this.f42482g = "AN1017";
                    e();
                }
                Set<String> b12 = b("ApptimizeDisabledVisualVersions");
                boolean contains = b12.contains(fx.a());
                this.f42481f = contains;
                String str3 = f42476c;
                bo.k(str3, "isVisualKilled:" + contains + " killedVersions:" + b12);
                boolean contains2 = b("ApptimizePermanentlyDisabledVersions").contains(fx.a());
                this.f42484i = contains2;
                this.f42483h = contains2;
            } catch (Throwable th2) {
                StrictMode.setThreadPolicy(allowThreadDiskReads);
                throw th2;
            }
        }
    }

    private void e() {
        String a11 = fx.a();
        String str = f42476c;
        bo.j(str, "Internal Error " + this.f42482g);
        Set<String> b11 = b("ApptimizeDisabledVisualVersions");
        b11.add(a11);
        a("ApptimizeDisabledVisualVersions", JSONArrayInstrumentation.toString(new JSONArray((Collection<?>) b11)));
    }

    private String f() {
        if (this.f42480e.equals("")) {
            return ".apptimize_disable-" + fx.a();
        }
        return ".apptimize_disable-" + this.f42480e + SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE + fx.a();
    }

    private String g() {
        if (this.f42480e.equals("")) {
            return "apptimize_crash_report";
        }
        return "apptimize_crash_report-" + this.f42480e;
    }

    private String h() {
        return "crash_detail";
    }

    private String i() {
        if (this.f42480e.equals("")) {
            return ".apptimize_setup";
        }
        return ".apptimize_setup-" + this.f42480e;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0044, code lost:
        if (r0 != null) goto L_0x001d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x004b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String a() {
        /*
            r7 = this;
            java.io.File r0 = r7.f42486k
            boolean r0 = r0.exists()
            r1 = 0
            if (r0 != 0) goto L_0x000a
            return r1
        L_0x000a:
            java.util.Scanner r0 = new java.util.Scanner     // Catch:{ Exception -> 0x0028, all -> 0x0023 }
            java.io.File r2 = r7.f42486k     // Catch:{ Exception -> 0x0028, all -> 0x0023 }
            java.lang.String r3 = "UTF-8"
            r0.<init>(r2, r3)     // Catch:{ Exception -> 0x0028, all -> 0x0023 }
            java.lang.String r2 = "\\A"
            java.util.Scanner r2 = r0.useDelimiter(r2)     // Catch:{ Exception -> 0x0021 }
            java.lang.String r1 = r2.next()     // Catch:{ Exception -> 0x0021 }
        L_0x001d:
            r0.close()
            goto L_0x0047
        L_0x0021:
            r2 = move-exception
            goto L_0x002a
        L_0x0023:
            r0 = move-exception
            r6 = r1
            r1 = r0
            r0 = r6
            goto L_0x0049
        L_0x0028:
            r2 = move-exception
            r0 = r1
        L_0x002a:
            java.lang.String r3 = f42476c     // Catch:{ all -> 0x0048 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0048 }
            r4.<init>()     // Catch:{ all -> 0x0048 }
            java.lang.String r5 = "Scanner error "
            r4.append(r5)     // Catch:{ all -> 0x0048 }
            java.lang.String r2 = com.apptimize.fx.a((java.lang.Exception) r2)     // Catch:{ all -> 0x0048 }
            r4.append(r2)     // Catch:{ all -> 0x0048 }
            java.lang.String r2 = r4.toString()     // Catch:{ all -> 0x0048 }
            com.apptimize.bo.k(r3, r2)     // Catch:{ all -> 0x0048 }
            if (r0 == 0) goto L_0x0047
            goto L_0x001d
        L_0x0047:
            return r1
        L_0x0048:
            r1 = move-exception
        L_0x0049:
            if (r0 == 0) goto L_0x004e
            r0.close()
        L_0x004e:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.g.a():java.lang.String");
    }

    public synchronized boolean b() {
        return this.f42483h;
    }

    public synchronized void c() {
        StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        try {
            this.f42486k.delete();
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
        }
    }

    public synchronized boolean d() {
        boolean z11;
        if (this.f42481f || this.f42483h) {
            z11 = false;
        } else {
            z11 = true;
        }
        return z11;
    }

    public String b(Context context) {
        File file;
        if (av.f41249l) {
            file = new File(c.j(context), h());
        } else {
            file = ff.a(context, h());
        }
        return file.getAbsolutePath();
    }

    private synchronized Set<String> b(String str) {
        HashSet hashSet;
        hashSet = new HashSet();
        String a11 = i.a().a(this.f42479d, str, (String) null);
        if (a11 != null) {
            try {
                JSONArray jSONArray = new JSONArray(a11);
                for (int i11 = 0; i11 != jSONArray.length(); i11++) {
                    hashSet.add(jSONArray.getString(i11));
                }
            } catch (JSONException e11) {
                bo.b(f42476c, "Error reading library versions from JSON.", e11);
            }
        }
        return hashSet;
    }

    public void a(JSONObject jSONObject) {
        boolean z11;
        Set<String> a11 = a(jSONObject, "disabledAndroidLibraryVersionsImmediately");
        try {
            a("ApptimizePermanentlyDisabledVersions", JSONArrayInstrumentation.toString(new JSONArray((Collection<?>) a(jSONObject, "disabledAndroidLibraryVersions"))));
            if (a11.contains(fx.a())) {
                synchronized (this) {
                    z11 = !this.f42483h;
                    this.f42483h = true;
                    this.f42484i = true;
                }
                if (z11) {
                    Apptimize.a();
                }
            }
        } catch (Throwable th2) {
            if (a11.contains(fx.a())) {
                synchronized (this) {
                    boolean z12 = !this.f42483h;
                    this.f42483h = true;
                    this.f42484i = true;
                    if (z12) {
                        Apptimize.a();
                    }
                }
            }
            throw th2;
        }
    }

    public String a(Context context) {
        return ff.a(context, g()).getAbsolutePath();
    }

    public synchronized void a(boolean z11) {
        this.f42483h = z11;
    }

    public boolean a(ApptimizeOptions.LogLevel logLevel, String str, String str2) {
        String str3;
        String str4;
        if (!b()) {
            return false;
        }
        if (this.f42484i) {
            str3 = "Apptimize " + fx.a() + " is a known disabled library version";
        } else {
            str3 = this.f42485j ? "Apptimize is disabled on this device" : "Apptimize is disabled for this process";
        }
        if (this.f42482g != null) {
            str4 = " (" + this.f42482g + ")";
        } else {
            str4 = "";
        }
        String str5 = str3 + str4 + ". " + str2;
        int i11 = AnonymousClass1.f42487a[logLevel.ordinal()];
        if (i11 == 1) {
            bo.r(str, str5);
        } else if (i11 == 2) {
            bo.o(str, str5);
        } else if (i11 == 3) {
            bo.q(str, str5);
        } else if (i11 == 4) {
            bo.s(str, str5);
        } else if (i11 == 5) {
            bo.p(str, str5);
        }
        return true;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:15|16|17|18) */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:25|26|27|28|29|30) */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        android.os.StrictMode.setThreadPolicy(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0028, code lost:
        return false;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0024 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0035 */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0031 A[SYNTHETIC, Splitter:B:25:0x0031] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x003d A[SYNTHETIC, Splitter:B:35:0x003d] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:15:0x0024=Splitter:B:15:0x0024, B:27:0x0035=Splitter:B:27:0x0035, B:45:0x004b=Splitter:B:45:0x004b} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean a(java.lang.String r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            android.os.StrictMode$ThreadPolicy r0 = android.os.StrictMode.allowThreadDiskWrites()     // Catch:{ all -> 0x0050 }
            r1 = 0
            r2 = 0
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x003b, all -> 0x002e }
            java.io.File r4 = r5.f42486k     // Catch:{ IOException -> 0x003b, all -> 0x002e }
            r3.<init>(r4)     // Catch:{ IOException -> 0x003b, all -> 0x002e }
            java.lang.String r2 = "UTF-8"
            byte[] r6 = r6.getBytes(r2)     // Catch:{ IOException -> 0x002c, all -> 0x0029 }
            int r2 = r6.length     // Catch:{ IOException -> 0x002c, all -> 0x0029 }
            r3.write(r6, r1, r2)     // Catch:{ IOException -> 0x002c, all -> 0x0029 }
            r3.flush()     // Catch:{ IOException -> 0x002c, all -> 0x0029 }
            r3.close()     // Catch:{ IOException -> 0x0024 }
            android.os.StrictMode.setThreadPolicy(r0)     // Catch:{ all -> 0x0050 }
            monitor-exit(r5)
            r6 = 1
            return r6
        L_0x0024:
            android.os.StrictMode.setThreadPolicy(r0)     // Catch:{ all -> 0x0050 }
            monitor-exit(r5)
            return r1
        L_0x0029:
            r6 = move-exception
            r2 = r3
            goto L_0x002f
        L_0x002c:
            r2 = r3
            goto L_0x003b
        L_0x002e:
            r6 = move-exception
        L_0x002f:
            if (r2 == 0) goto L_0x003a
            r2.close()     // Catch:{ IOException -> 0x0035 }
            goto L_0x003a
        L_0x0035:
            android.os.StrictMode.setThreadPolicy(r0)     // Catch:{ all -> 0x0050 }
            monitor-exit(r5)
            return r1
        L_0x003a:
            throw r6     // Catch:{ all -> 0x0041 }
        L_0x003b:
            if (r2 == 0) goto L_0x004b
            r2.close()     // Catch:{ IOException -> 0x0046 }
            goto L_0x004b
        L_0x0041:
            r6 = move-exception
            android.os.StrictMode.setThreadPolicy(r0)     // Catch:{ all -> 0x0050 }
            throw r6     // Catch:{ all -> 0x0050 }
        L_0x0046:
            android.os.StrictMode.setThreadPolicy(r0)     // Catch:{ all -> 0x0050 }
            monitor-exit(r5)
            return r1
        L_0x004b:
            android.os.StrictMode.setThreadPolicy(r0)     // Catch:{ all -> 0x0050 }
            monitor-exit(r5)
            return r1
        L_0x0050:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.g.a(java.lang.String):boolean");
    }

    private synchronized void a(String str, String str2) {
        i.a().b(this.f42479d, str, str2);
    }

    private static Set<String> a(JSONObject jSONObject, String str) {
        HashSet hashSet = new HashSet();
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray != null) {
            for (int i11 = 0; i11 != optJSONArray.length(); i11++) {
                try {
                    hashSet.add(optJSONArray.getString(i11));
                } catch (JSONException e11) {
                    bo.b(f42476c, "Error reading Android library versions from JSON.", e11);
                }
            }
        }
        if (jSONObject.optBoolean("disableAllVersions")) {
            hashSet.add(fx.a());
        }
        return hashSet;
    }

    public void a(au auVar) {
        if (this.f42477a != null) {
            HashMap hashMap = new HashMap();
            if (this.f42477a.b() != null && this.f42477a.b().length() > 0) {
                hashMap.put("attr", this.f42477a.b());
            }
            auVar.a().a(bq.b.Crash, (Map<String, Object>) hashMap);
            this.f42477a = null;
        }
        String str = this.f42482g;
        if (str != null && str.length() != 0) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put(Constant.PARAM_ERROR_CODE, this.f42482g);
            auVar.a().a(bq.b.A, (Map<String, Object>) hashMap2);
        } else if (this.f42481f) {
            auVar.a().a(bq.b.A);
        }
    }

    public static void a(Context context, au auVar) {
        File[] listFiles = ff.a(context).listFiles();
        if (listFiles != null && listFiles.length > 0) {
            for (File file : listFiles) {
                if (file.getName().startsWith("apptimize_crash_report") || file.getName().startsWith(".apptimize_setup") || file.getName().startsWith(".apptimize_disable")) {
                    ff.a(context, auVar, file.getName());
                }
            }
        }
    }
}
