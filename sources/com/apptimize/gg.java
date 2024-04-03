package com.apptimize;

import android.os.Build;
import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import com.apptimize.bq;
import com.huawei.hms.flutter.map.constants.Param;
import com.huawei.location.lite.common.log.logwrite.LogWriteConstants;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class gg implements gm {
    private static String A = null;
    private static TreeMap<Long, gj> B = null;
    private static long C = 0;
    private static TreeMap<Long, gj> D = null;
    private static long E = 0;
    private static long F = 0;
    private static TreeMap<Long, gj> G = null;
    private static long H = 0;
    private static TreeMap<Long, gj> I = null;
    private static long[] J = null;
    private static int K = -1;
    private static int L = 0;
    private static int M = 1;
    private static int N = 2;
    /* access modifiers changed from: private */
    public static int O = -1;

    /* renamed from: a  reason: collision with root package name */
    static Method f42564a = null;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final String f42565b = "gg";

    /* renamed from: m  reason: collision with root package name */
    private static Map<Long, Method> f42566m = new HashMap();

    /* renamed from: n  reason: collision with root package name */
    private static Map<Method, Long> f42567n = new HashMap();

    /* renamed from: r  reason: collision with root package name */
    private static TreeMap<Long, gj> f42568r;

    /* renamed from: s  reason: collision with root package name */
    private static long f42569s;

    /* renamed from: t  reason: collision with root package name */
    private static long f42570t;

    /* renamed from: u  reason: collision with root package name */
    private static long f42571u;

    /* renamed from: v  reason: collision with root package name */
    private static String f42572v;

    /* renamed from: w  reason: collision with root package name */
    private static TreeMap<Long, gj> f42573w;

    /* renamed from: x  reason: collision with root package name */
    private static long f42574x;

    /* renamed from: y  reason: collision with root package name */
    private static long f42575y;

    /* renamed from: z  reason: collision with root package name */
    private static long f42576z;
    private boolean P = false;

    /* renamed from: c  reason: collision with root package name */
    private Class<?> f42577c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public au f42578d;

    /* renamed from: e  reason: collision with root package name */
    private gh f42579e;

    /* renamed from: f  reason: collision with root package name */
    private Map<String, Method> f42580f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    private Map<String, Method> f42581g = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    private Method f42582h;

    /* renamed from: i  reason: collision with root package name */
    private Method f42583i;

    /* renamed from: j  reason: collision with root package name */
    private Method f42584j;

    /* renamed from: k  reason: collision with root package name */
    private Method f42585k;

    /* renamed from: l  reason: collision with root package name */
    private final boolean f42586l = Build.VERSION.RELEASE.startsWith("5.");

    /* renamed from: o  reason: collision with root package name */
    private int f42587o = 0;

    /* renamed from: p  reason: collision with root package name */
    private boolean f42588p = false;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public Object f42589q = null;

    public class a {

        /* renamed from: a  reason: collision with root package name */
        long f42611a;

        /* renamed from: b  reason: collision with root package name */
        long f42612b;

        /* renamed from: c  reason: collision with root package name */
        boolean f42613c;

        /* renamed from: d  reason: collision with root package name */
        boolean f42614d;

        /* renamed from: e  reason: collision with root package name */
        boolean f42615e;

        /* renamed from: f  reason: collision with root package name */
        boolean f42616f;

        public a(long j11, long j12, boolean z11, boolean z12, boolean z13, boolean z14) {
            this.f42611a = j11;
            this.f42612b = j12;
            this.f42613c = z11;
            this.f42614d = z12;
            this.f42615e = z13;
            this.f42616f = z14;
        }
    }

    public gg(Class<?> cls, au auVar) {
        this.f42577c = cls;
        this.f42578d = auVar;
        this.f42579e = new gh(auVar);
        j();
    }

    private static synchronized Long e(Method method) {
        Long l11;
        synchronized (gg.class) {
            l11 = f42567n.get(method);
        }
        return l11;
    }

    private void g() {
        Exception e11;
        Class<?> cls;
        Object obj;
        a();
        Class<?> cls2 = null;
        try {
            Class<?> a11 = fx.a("com.google.firebase.crashlytics.ndk.FirebaseCrashlyticsNdk");
            String str = "com.google.firebase.crashlytics.FirebaseCrashlytics";
            if (a11 == null) {
                try {
                    a11 = fx.a("com.crashlytics.android.ndk.CrashlyticsNdk");
                    str = "com.crashlytics.android.Crashlytics";
                } catch (Exception e12) {
                    e11 = e12;
                    cls = null;
                    cls2 = a11;
                    obj = null;
                    try {
                        bo.k(f42565b, "setupForCrashlytics exception " + fx.a(e11));
                        if (!(cls2 == null || cls == null || obj != null)) {
                            i();
                        }
                        b();
                    } catch (Throwable th2) {
                        b();
                        throw th2;
                    }
                }
            }
            if (a11 == null) {
                b();
                return;
            }
            String str2 = f42565b;
            bo.k(str2, "crashlyticsNdkKlass " + a11);
            cls = Class.forName(str);
            try {
                bo.k(str2, "crashlyticsKlass " + cls);
                bo.k(str2, "logMethod " + cls.getDeclaredMethod(LogWriteConstants.LOG_TYPE, new Class[]{String.class}));
                AnonymousClass2 r42 = new gk() {
                    public void a(Method method, Object obj, Object[] objArr) {
                        gg.this.b(true);
                        if (gg.this.c(false) == 0) {
                            gg.this.h();
                        }
                    }
                };
                bo.k(str2, "initializing crashlytics");
                if (c(false) != 0) {
                    b(false);
                } else {
                    h();
                    for (Method method : a11.getDeclaredMethods()) {
                        if (method.getName().equals("with")) {
                            bo.k(f42565b, "crashlytics constructor " + h(method) + " " + method);
                            gn.a(method, (gk) r42, 0, false);
                        }
                    }
                }
            } catch (Exception e13) {
                e11 = e13;
                Class<?> cls3 = a11;
                obj = null;
                cls2 = cls3;
                bo.k(f42565b, "setupForCrashlytics exception " + fx.a(e11));
                i();
                b();
            }
            b();
        } catch (Exception e14) {
            obj = null;
            e11 = e14;
            cls = null;
            bo.k(f42565b, "setupForCrashlytics exception " + fx.a(e11));
            i();
            b();
        }
    }

    /* access modifiers changed from: private */
    public void h() {
        bo.k(f42565b, "nativeInitForCrashlyticsTimer");
        new Handler(Looper.getMainLooper()).postDelayed(new fi() {
            public void run() {
                bo.k(gg.f42565b, "nativeInitForCrashlyticsTimer called");
                gg.this.b(true);
            }
        }, 10);
    }

    private void i() {
        try {
            bo.j(f42565b, "Apptimize encountered an error calling CrashlyticsNdk's context->log(context, message) function. Please check that Crashlytics.log(String) is not obfuscated and you are using the newest Crashlytics and CrashlyticsNdk.");
            this.f42577c.getMethod("initForCrashlytics", new Class[]{Long.TYPE}).invoke((Object) null, new Object[]{-1L});
        } catch (Exception unused) {
        }
    }

    private void j() {
        try {
            ArrayList arrayList = new ArrayList();
            for (Class cls = this.f42577c; cls != null; cls = cls.getSuperclass()) {
                arrayList.addAll(Arrays.asList(cls.getDeclaredMethods()));
            }
            for (String a11 : gf.f42562a) {
                Method a12 = a((List<Method>) arrayList, a11);
                this.f42580f.put(h(a12), a12);
            }
            for (String a13 : gf.f42563b) {
                Method a14 = a((List<Method>) arrayList, a13);
                this.f42581g.put(h(a14), a14);
            }
        } catch (NoSuchMethodException e11) {
            this.f42578d.a().a(f42565b, "AN1008", fx.a((Exception) e11));
        }
    }

    /* access modifiers changed from: private */
    public boolean k() {
        if (!gn.w()) {
            return false;
        }
        try {
            Method j11 = gn.j();
            if (j11 != null) {
                this.f42577c.getMethod("removeListener", new Class[]{Long.TYPE}).invoke((Object) null, new Object[]{a(j11)});
            }
            return true;
        } catch (NoSuchMethodException e11) {
            this.f42578d.a().a(f42565b, "AN1001-0", fx.a((Exception) e11));
            return false;
        } catch (IllegalAccessException e12) {
            this.f42578d.a().a(f42565b, "AN1001-1", fx.a((Exception) e12));
            return false;
        } catch (InvocationTargetException e13) {
            this.f42578d.a().a(f42565b, "AN1001-2", fx.a((Exception) e13));
            return false;
        } finally {
            gn.x();
        }
    }

    private boolean l() {
        Class<Debug> cls = Debug.class;
        Class<Runtime> cls2 = Runtime.class;
        try {
            AnonymousClass4 r32 = new gk() {
                public void a(Method method, Object obj, Object[] objArr) {
                    boolean unused = gg.this.k();
                    gg.this.f42578d.a().a(bq.b.D);
                    bo.g(gg.f42565b, "Apptimize encountered an error and is shutting down visual tests");
                }
            };
            Class<?> cls3 = Class.forName("dalvik.system.VMDebug");
            for (Method method : cls3.getDeclaredMethods()) {
                if (method.getName().equals("startMethodTracing") && !Modifier.isNative(method.getModifiers())) {
                    gn.a(method, (gk) r32, 0, true);
                }
            }
            Class cls4 = Boolean.TYPE;
            Method[] methodArr = {fn.a(cls3, "startMethodTracingDdms"), cls2.getMethod("traceMethodCalls", new Class[]{cls4}), cls2.getMethod("traceInstructions", new Class[]{cls4}), cls.getMethod("startNativeTracing", new Class[0]), cls.getMethod("enableEmulatorTraceOutput", new Class[0]), Debug.InstructionCount.class.getMethod("resetAndStart", new Class[0])};
            for (int i11 = 0; i11 < 6; i11++) {
                gn.a(methodArr[i11], (gk) r32, 0, true);
            }
            return true;
        } catch (ClassNotFoundException e11) {
            this.f42578d.a().a(f42565b, "AN1001-5", fx.a((Exception) e11));
            return false;
        } catch (NoSuchMethodException e12) {
            this.f42578d.a().a(f42565b, "AN1001-6", fx.a((Exception) e12));
            return false;
        }
    }

    private long m() {
        d();
        return f42569s;
    }

    private long n() {
        d();
        return f42570t;
    }

    private long o() {
        d();
        return f42571u;
    }

    private String p() {
        d();
        return f42572v;
    }

    private long q() {
        d();
        return f42574x;
    }

    private long r() {
        d();
        return f42575y;
    }

    private long s() {
        d();
        return f42576z;
    }

    private String t() {
        d();
        return A;
    }

    private long u() {
        d();
        return C;
    }

    private long v() {
        d();
        return E;
    }

    private long w() {
        d();
        return F;
    }

    private long[] x() {
        if (J == null) {
            d();
            TreeMap treeMap = new TreeMap();
            treeMap.putAll(f42568r);
            treeMap.putAll(f42573w);
            treeMap.putAll(B);
            treeMap.putAll(G);
            treeMap.putAll(I);
            for (Map.Entry next : D.entrySet()) {
                treeMap.put(next.getKey(), new gj(((gj) next.getValue()).f42634f, ((gj) next.getValue()).f42635g | gj.f42630b));
            }
            J = new long[(treeMap.size() * 3)];
            int i11 = 0;
            for (Map.Entry entry : treeMap.entrySet()) {
                int i12 = i11 * 3;
                J[i12] = ((gj) entry.getValue()).f42634f;
                J[i12 + 1] = ((Long) entry.getKey()).longValue();
                J[i12 + 2] = (long) ((gj) entry.getValue()).f42635g;
                i11++;
            }
        }
        return J;
    }

    private void y() {
        c(false);
        f42573w = null;
        B = null;
        D = null;
        G = null;
        I = null;
        J = new long[0];
    }

    private char d(Class<?> cls) {
        if (cls == Void.TYPE) {
            return 'V';
        }
        if (cls == Boolean.TYPE) {
            return 'Z';
        }
        if (cls == Byte.TYPE) {
            return 'B';
        }
        if (cls == Character.TYPE) {
            return 'C';
        }
        if (cls == Short.TYPE) {
            return 'S';
        }
        if (cls == Integer.TYPE) {
            return 'I';
        }
        if (cls == Long.TYPE) {
            return 'J';
        }
        if (cls == Float.TYPE) {
            return 'F';
        }
        return cls == Double.TYPE ? 'D' : 'L';
    }

    private static synchronized void f(Method method) {
        synchronized (gg.class) {
            Long l11 = f42567n.get(method);
            if (l11 != null) {
                f42566m.remove(l11);
                f42567n.remove(method);
            }
        }
    }

    public boolean c() {
        if (!l()) {
            return false;
        }
        g();
        return true;
    }

    public String e() {
        if (this.f42589q != null) {
            return this.f42578d.a().a(this.f42589q);
        }
        return null;
    }

    public synchronized void b() {
        int i11 = this.f42587o;
        if (i11 > 0) {
            int i12 = i11 - 1;
            this.f42587o = i12;
            if (i12 == 0) {
                try {
                    this.f42577c.getMethod("postInit", new Class[0]).invoke((Object) null, new Object[0]);
                } catch (NoSuchMethodException e11) {
                    this.f42578d.a().a(f42565b, "AN1006-16", fx.a((Exception) e11));
                } catch (IllegalAccessException e12) {
                    this.f42578d.a().a(f42565b, "AN1006-17", fx.a((Exception) e12));
                } catch (InvocationTargetException e13) {
                    this.f42578d.a().a(f42565b, "AN1006-18", fx.a((Exception) e13));
                }
            }
        }
    }

    private static synchronized void a(Long l11, Method method) {
        synchronized (gg.class) {
            f42566m.put(l11, method);
            f42567n.put(method, l11);
        }
    }

    private void c(Class<?> cls) throws ClassNotFoundException {
        Class.forName(cls.getName(), true, cls.getClassLoader());
    }

    private String h(Method method) {
        String str = "" + d(method.getReturnType());
        for (Class cls : method.getParameterTypes()) {
            str = str + d((Class<?>) cls);
        }
        return str;
    }

    public int c(Method method) throws IllegalAccessException, NoSuchFieldException {
        Object obj = method;
        if (this.f42586l) {
            obj = b(method);
        }
        try {
            return fn.b(obj, "dexMethodIndex");
        } catch (NoSuchFieldException e11) {
            bo.h(f42565b, "dexMethodIndex not found", e11);
            return -1;
        }
    }

    public static synchronized Method a(Long l11) {
        Method method;
        synchronized (gg.class) {
            method = f42566m.get(l11);
        }
        return method;
    }

    /* access modifiers changed from: private */
    public long c(boolean z11) {
        Map.Entry<Long, gj> entry;
        long j11 = H;
        if (j11 != 0) {
            return j11;
        }
        a(z11);
        TreeMap<Long, gj> treeMap = G;
        if (treeMap == null) {
            entry = null;
        } else {
            entry = treeMap.firstEntry();
        }
        if (entry == null) {
            return 0;
        }
        gj value = entry.getValue();
        int i11 = value.f42635g;
        if ((gj.f42631c & i11) != 0 || (i11 & gj.f42632d) == 0) {
            return 0;
        }
        long j12 = value.f42634f;
        H = j12;
        return j12;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00ae, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00af, code lost:
        r2 = r0;
        r1 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00b3, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00b4, code lost:
        r2 = r0;
        r1 = r14;
        r30 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00ba, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00bb, code lost:
        r2 = r0;
        r1 = r14;
        r30 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00c8, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00c9, code lost:
        r2 = r0;
        r1 = r14;
        r30 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00cf, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00d0, code lost:
        r2 = r0;
        r1 = r14;
        r30 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        r4 = r43.getApplicationInfo().targetSdkVersion;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x0118 */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00ae A[ExcHandler: all (r0v33 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:12:0x008b] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00b3 A[ExcHandler: InvocationTargetException (r0v32 'e' java.lang.reflect.InvocationTargetException A[CUSTOM_DECLARE]), Splitter:B:12:0x008b] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00ba A[ExcHandler: IllegalAccessException (r0v31 'e' java.lang.IllegalAccessException A[CUSTOM_DECLARE]), Splitter:B:12:0x008b] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00c8 A[ExcHandler: NoSuchFieldException (r0v29 'e' java.lang.NoSuchFieldException A[CUSTOM_DECLARE]), Splitter:B:12:0x008b] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00cf A[ExcHandler: ClassNotFoundException (r0v28 'e' java.lang.ClassNotFoundException A[CUSTOM_DECLARE]), Splitter:B:12:0x008b] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:126:0x02f2=Splitter:B:126:0x02f2, B:140:0x0326=Splitter:B:140:0x0326, B:119:0x02d8=Splitter:B:119:0x02d8, B:133:0x030c=Splitter:B:133:0x030c, B:112:0x02be=Splitter:B:112:0x02be} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(android.content.Context r43, boolean r44) {
        /*
            r42 = this;
            r14 = r42
            java.lang.Class<com.apptimize.bbb> r1 = com.apptimize.bbb.class
            java.lang.Class<java.lang.Object> r2 = java.lang.Object.class
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            boolean r4 = com.apptimize.av.f41247j
            if (r4 == 0) goto L_0x0011
            com.apptimize.au r4 = r14.f42578d
            com.apptimize.gn.a((com.apptimize.au) r4)
        L_0x0011:
            r42.a()
            r15 = 0
            java.lang.Class<?> r4 = r14.f42577c     // Catch:{ NoSuchMethodException -> 0x0346, all -> 0x0342 }
            java.lang.String r5 = "addListener"
            r6 = 9
            java.lang.Class[] r7 = new java.lang.Class[r6]     // Catch:{ NoSuchMethodException -> 0x0346, all -> 0x0342 }
            java.lang.Class r8 = java.lang.Long.TYPE     // Catch:{ NoSuchMethodException -> 0x0346, all -> 0x0342 }
            r7[r15] = r8     // Catch:{ NoSuchMethodException -> 0x0346, all -> 0x0342 }
            r12 = 1
            r7[r12] = r3     // Catch:{ NoSuchMethodException -> 0x0346, all -> 0x0342 }
            r9 = 2
            r7[r9] = r2     // Catch:{ NoSuchMethodException -> 0x0346, all -> 0x0342 }
            r10 = 3
            r7[r10] = r8     // Catch:{ NoSuchMethodException -> 0x0346, all -> 0x0342 }
            r11 = 4
            r7[r11] = r8     // Catch:{ NoSuchMethodException -> 0x0346, all -> 0x0342 }
            java.lang.Class r13 = java.lang.Integer.TYPE     // Catch:{ NoSuchMethodException -> 0x0346, all -> 0x0342 }
            r16 = 5
            r7[r16] = r13     // Catch:{ NoSuchMethodException -> 0x0346, all -> 0x0342 }
            r17 = 6
            r7[r17] = r13     // Catch:{ NoSuchMethodException -> 0x0346, all -> 0x0342 }
            r18 = 7
            r7[r18] = r13     // Catch:{ NoSuchMethodException -> 0x0346, all -> 0x0342 }
            java.lang.Class r13 = java.lang.Boolean.TYPE     // Catch:{ NoSuchMethodException -> 0x0346, all -> 0x0342 }
            r6 = 8
            r7[r6] = r13     // Catch:{ NoSuchMethodException -> 0x0346, all -> 0x0342 }
            java.lang.reflect.Method r4 = r4.getMethod(r5, r7)     // Catch:{ NoSuchMethodException -> 0x0346, all -> 0x0342 }
            r14.f42583i = r4     // Catch:{ NoSuchMethodException -> 0x0346, all -> 0x0342 }
            java.lang.Class<?> r4 = r14.f42577c     // Catch:{ NoSuchMethodException -> 0x0346, all -> 0x0342 }
            java.lang.String r5 = "objectRef"
            java.lang.Class[] r7 = new java.lang.Class[r12]     // Catch:{ NoSuchMethodException -> 0x0346, all -> 0x0342 }
            r7[r15] = r2     // Catch:{ NoSuchMethodException -> 0x0346, all -> 0x0342 }
            java.lang.reflect.Method r4 = r4.getMethod(r5, r7)     // Catch:{ NoSuchMethodException -> 0x0346, all -> 0x0342 }
            r14.f42585k = r4     // Catch:{ NoSuchMethodException -> 0x0346, all -> 0x0342 }
            java.lang.Class<?> r4 = r14.f42577c     // Catch:{ NoSuchMethodException -> 0x0346, all -> 0x0342 }
            java.lang.String r5 = "removeListener"
            java.lang.Class[] r7 = new java.lang.Class[r12]     // Catch:{ NoSuchMethodException -> 0x0346, all -> 0x0342 }
            r7[r15] = r8     // Catch:{ NoSuchMethodException -> 0x0346, all -> 0x0342 }
            java.lang.reflect.Method r4 = r4.getMethod(r5, r7)     // Catch:{ NoSuchMethodException -> 0x0346, all -> 0x0342 }
            r14.f42584j = r4     // Catch:{ NoSuchMethodException -> 0x0346, all -> 0x0342 }
            r42.b()
            r42.a()
            r20 = 0
            r21 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            com.apptimize.bbb.bbb(r20, r21, r23, r24, r25, r26, r27, r28, r29, r30)     // Catch:{ ClassNotFoundException -> 0x0321, NoSuchFieldException -> 0x0307, NoSuchMethodException -> 0x02ed, IllegalAccessException -> 0x02d3, InvocationTargetException -> 0x02b9, all -> 0x02b4 }
            boolean r4 = com.apptimize.gn.r()     // Catch:{ ClassNotFoundException -> 0x0321, NoSuchFieldException -> 0x0307, NoSuchMethodException -> 0x02ed, IllegalAccessException -> 0x02d3, InvocationTargetException -> 0x02b9, all -> 0x02b4 }
            r5 = 0
            if (r4 != 0) goto L_0x00d6
            java.lang.Class<android.os.Debug> r4 = android.os.Debug.class
            java.lang.String r7 = "getMethodTracingMode"
            java.lang.Class[] r8 = new java.lang.Class[r15]     // Catch:{ ClassNotFoundException -> 0x00cf, NoSuchFieldException -> 0x00c8, NoSuchMethodException -> 0x00c1, IllegalAccessException -> 0x00ba, InvocationTargetException -> 0x00b3, all -> 0x00ae }
            java.lang.reflect.Method r4 = r4.getMethod(r7, r8)     // Catch:{ ClassNotFoundException -> 0x00cf, NoSuchFieldException -> 0x00c8, NoSuchMethodException -> 0x00c1, IllegalAccessException -> 0x00ba, InvocationTargetException -> 0x00b3, all -> 0x00ae }
            java.lang.Object[] r7 = new java.lang.Object[r15]     // Catch:{ ClassNotFoundException -> 0x00cf, NoSuchFieldException -> 0x00c8, NoSuchMethodException -> 0x00c1, IllegalAccessException -> 0x00ba, InvocationTargetException -> 0x00b3, all -> 0x00ae }
            java.lang.Object r4 = r4.invoke(r5, r7)     // Catch:{ ClassNotFoundException -> 0x00cf, NoSuchFieldException -> 0x00c8, NoSuchMethodException -> 0x00c1, IllegalAccessException -> 0x00ba, InvocationTargetException -> 0x00b3, all -> 0x00ae }
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ ClassNotFoundException -> 0x00cf, NoSuchFieldException -> 0x00c8, NoSuchMethodException -> 0x00c1, IllegalAccessException -> 0x00ba, InvocationTargetException -> 0x00b3, all -> 0x00ae }
            int r4 = r4.intValue()     // Catch:{ ClassNotFoundException -> 0x00cf, NoSuchFieldException -> 0x00c8, NoSuchMethodException -> 0x00c1, IllegalAccessException -> 0x00ba, InvocationTargetException -> 0x00b3, all -> 0x00ae }
            if (r4 == 0) goto L_0x00d6
            com.apptimize.au r1 = r14.f42578d     // Catch:{ ClassNotFoundException -> 0x00cf, NoSuchFieldException -> 0x00c8, NoSuchMethodException -> 0x00c1, IllegalAccessException -> 0x00ba, InvocationTargetException -> 0x00b3, all -> 0x00ae }
            com.apptimize.bq r1 = r1.a()     // Catch:{ ClassNotFoundException -> 0x00cf, NoSuchFieldException -> 0x00c8, NoSuchMethodException -> 0x00c1, IllegalAccessException -> 0x00ba, InvocationTargetException -> 0x00b3, all -> 0x00ae }
            com.apptimize.bq$b r2 = com.apptimize.bq.b.C     // Catch:{ ClassNotFoundException -> 0x00cf, NoSuchFieldException -> 0x00c8, NoSuchMethodException -> 0x00c1, IllegalAccessException -> 0x00ba, InvocationTargetException -> 0x00b3, all -> 0x00ae }
            r1.a((com.apptimize.bq.b) r2)     // Catch:{ ClassNotFoundException -> 0x00cf, NoSuchFieldException -> 0x00c8, NoSuchMethodException -> 0x00c1, IllegalAccessException -> 0x00ba, InvocationTargetException -> 0x00b3, all -> 0x00ae }
            r42.b()
            return r15
        L_0x00ae:
            r0 = move-exception
            r2 = r0
            r1 = r14
            goto L_0x033e
        L_0x00b3:
            r0 = move-exception
            r2 = r0
            r1 = r14
            r30 = r15
            goto L_0x02be
        L_0x00ba:
            r0 = move-exception
            r2 = r0
            r1 = r14
            r30 = r15
            goto L_0x02d8
        L_0x00c1:
            r0 = move-exception
            r2 = r0
            r1 = r14
            r30 = r15
            goto L_0x02f2
        L_0x00c8:
            r0 = move-exception
            r2 = r0
            r1 = r14
            r30 = r15
            goto L_0x030c
        L_0x00cf:
            r0 = move-exception
            r2 = r0
            r1 = r14
            r30 = r15
            goto L_0x0326
        L_0x00d6:
            boolean r4 = com.apptimize.fa.b()     // Catch:{ ClassNotFoundException -> 0x0321, NoSuchFieldException -> 0x0307, NoSuchMethodException -> 0x02ed, IllegalAccessException -> 0x02d3, InvocationTargetException -> 0x02b9, all -> 0x02b4 }
            java.lang.String r7 = ""
            if (r4 == 0) goto L_0x00ef
            com.apptimize.au r1 = r14.f42578d     // Catch:{ ClassNotFoundException -> 0x00cf, NoSuchFieldException -> 0x00c8, NoSuchMethodException -> 0x00c1, IllegalAccessException -> 0x00ba, InvocationTargetException -> 0x00b3, all -> 0x00ae }
            com.apptimize.bq r1 = r1.a()     // Catch:{ ClassNotFoundException -> 0x00cf, NoSuchFieldException -> 0x00c8, NoSuchMethodException -> 0x00c1, IllegalAccessException -> 0x00ba, InvocationTargetException -> 0x00b3, all -> 0x00ae }
            java.lang.String r2 = f42565b     // Catch:{ ClassNotFoundException -> 0x00cf, NoSuchFieldException -> 0x00c8, NoSuchMethodException -> 0x00c1, IllegalAccessException -> 0x00ba, InvocationTargetException -> 0x00b3, all -> 0x00ae }
            java.lang.String r3 = "AN1014"
            r1.a(r2, r3, r7)     // Catch:{ ClassNotFoundException -> 0x00cf, NoSuchFieldException -> 0x00c8, NoSuchMethodException -> 0x00c1, IllegalAccessException -> 0x00ba, InvocationTargetException -> 0x00b3, all -> 0x00ae }
            r42.b()
            return r15
        L_0x00ef:
            java.lang.String r4 = "dalvik.system.VMRuntime"
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch:{ NoSuchMethodException -> 0x0118, ClassNotFoundException -> 0x00cf, NoSuchFieldException -> 0x00c8, IllegalAccessException -> 0x00ba, InvocationTargetException -> 0x00b3, all -> 0x00ae }
            java.lang.String r8 = "getRuntime"
            java.lang.Class[] r13 = new java.lang.Class[r15]     // Catch:{ NoSuchMethodException -> 0x0118, ClassNotFoundException -> 0x00cf, NoSuchFieldException -> 0x00c8, IllegalAccessException -> 0x00ba, InvocationTargetException -> 0x00b3, all -> 0x00ae }
            java.lang.reflect.Method r8 = r4.getMethod(r8, r13)     // Catch:{ NoSuchMethodException -> 0x0118, ClassNotFoundException -> 0x00cf, NoSuchFieldException -> 0x00c8, IllegalAccessException -> 0x00ba, InvocationTargetException -> 0x00b3, all -> 0x00ae }
            java.lang.Object[] r13 = new java.lang.Object[r15]     // Catch:{ NoSuchMethodException -> 0x0118, ClassNotFoundException -> 0x00cf, NoSuchFieldException -> 0x00c8, IllegalAccessException -> 0x00ba, InvocationTargetException -> 0x00b3, all -> 0x00ae }
            java.lang.Object r5 = r8.invoke(r5, r13)     // Catch:{ NoSuchMethodException -> 0x0118, ClassNotFoundException -> 0x00cf, NoSuchFieldException -> 0x00c8, IllegalAccessException -> 0x00ba, InvocationTargetException -> 0x00b3, all -> 0x00ae }
            java.lang.String r8 = "getTargetSdkVersion"
            java.lang.Class[] r13 = new java.lang.Class[r15]     // Catch:{ NoSuchMethodException -> 0x0118, ClassNotFoundException -> 0x00cf, NoSuchFieldException -> 0x00c8, IllegalAccessException -> 0x00ba, InvocationTargetException -> 0x00b3, all -> 0x00ae }
            java.lang.reflect.Method r4 = r4.getMethod(r8, r13)     // Catch:{ NoSuchMethodException -> 0x0118, ClassNotFoundException -> 0x00cf, NoSuchFieldException -> 0x00c8, IllegalAccessException -> 0x00ba, InvocationTargetException -> 0x00b3, all -> 0x00ae }
            java.lang.Object[] r8 = new java.lang.Object[r15]     // Catch:{ NoSuchMethodException -> 0x0118, ClassNotFoundException -> 0x00cf, NoSuchFieldException -> 0x00c8, IllegalAccessException -> 0x00ba, InvocationTargetException -> 0x00b3, all -> 0x00ae }
            java.lang.Object r4 = r4.invoke(r5, r8)     // Catch:{ NoSuchMethodException -> 0x0118, ClassNotFoundException -> 0x00cf, NoSuchFieldException -> 0x00c8, IllegalAccessException -> 0x00ba, InvocationTargetException -> 0x00b3, all -> 0x00ae }
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ NoSuchMethodException -> 0x0118, ClassNotFoundException -> 0x00cf, NoSuchFieldException -> 0x00c8, IllegalAccessException -> 0x00ba, InvocationTargetException -> 0x00b3, all -> 0x00ae }
            int r4 = r4.intValue()     // Catch:{ NoSuchMethodException -> 0x0118, ClassNotFoundException -> 0x00cf, NoSuchFieldException -> 0x00c8, IllegalAccessException -> 0x00ba, InvocationTargetException -> 0x00b3, all -> 0x00ae }
            goto L_0x011e
        L_0x0118:
            android.content.pm.ApplicationInfo r4 = r43.getApplicationInfo()     // Catch:{ ClassNotFoundException -> 0x0321, NoSuchFieldException -> 0x0307, NoSuchMethodException -> 0x02ed, IllegalAccessException -> 0x02d3, InvocationTargetException -> 0x02b9, all -> 0x02b4 }
            int r4 = r4.targetSdkVersion     // Catch:{ ClassNotFoundException -> 0x0321, NoSuchFieldException -> 0x0307, NoSuchMethodException -> 0x02ed, IllegalAccessException -> 0x02d3, InvocationTargetException -> 0x02b9, all -> 0x02b4 }
        L_0x011e:
            r26 = r4
            java.lang.String r22 = com.apptimize.fn.a(r1)     // Catch:{ ClassNotFoundException -> 0x0321, NoSuchFieldException -> 0x0307, NoSuchMethodException -> 0x02ed, IllegalAccessException -> 0x02d3, InvocationTargetException -> 0x02b9, all -> 0x02b4 }
            com.apptimize.au r4 = r14.f42578d     // Catch:{ ClassNotFoundException -> 0x0321, NoSuchFieldException -> 0x0307, NoSuchMethodException -> 0x02ed, IllegalAccessException -> 0x02d3, InvocationTargetException -> 0x02b9, all -> 0x02b4 }
            java.lang.String r23 = com.apptimize.fn.a((com.apptimize.au) r4, (java.lang.Class<?>) r1)     // Catch:{ ClassNotFoundException -> 0x0321, NoSuchFieldException -> 0x0307, NoSuchMethodException -> 0x02ed, IllegalAccessException -> 0x02d3, InvocationTargetException -> 0x02b9, all -> 0x02b4 }
            if (r23 != 0) goto L_0x0130
            r42.b()
            return r15
        L_0x0130:
            java.lang.Class<java.lang.reflect.Field> r1 = java.lang.reflect.Field.class
            java.lang.String r4 = "getOffset"
            java.lang.Class[] r5 = new java.lang.Class[r15]     // Catch:{ ClassNotFoundException -> 0x0321, NoSuchFieldException -> 0x0307, NoSuchMethodException -> 0x02ed, IllegalAccessException -> 0x02d3, InvocationTargetException -> 0x02b9, all -> 0x02b4 }
            java.lang.reflect.Method r1 = r1.getMethod(r4, r5)     // Catch:{ ClassNotFoundException -> 0x0321, NoSuchFieldException -> 0x0307, NoSuchMethodException -> 0x02ed, IllegalAccessException -> 0x02d3, InvocationTargetException -> 0x02b9, all -> 0x02b4 }
            boolean r4 = com.apptimize.gn.o()     // Catch:{ ClassNotFoundException -> 0x0321, NoSuchFieldException -> 0x0307, NoSuchMethodException -> 0x02ed, IllegalAccessException -> 0x02d3, InvocationTargetException -> 0x02b9, all -> 0x02b4 }
            if (r4 == 0) goto L_0x0143
            java.lang.String r4 = "override"
            goto L_0x0145
        L_0x0143:
            java.lang.String r4 = "flag"
        L_0x0145:
            java.lang.Class<java.lang.reflect.AccessibleObject> r5 = java.lang.reflect.AccessibleObject.class
            java.lang.reflect.Field r4 = com.apptimize.fn.b((java.lang.Class<?>) r5, (java.lang.String) r4)     // Catch:{ ClassNotFoundException -> 0x0321, NoSuchFieldException -> 0x0307, NoSuchMethodException -> 0x02ed, IllegalAccessException -> 0x02d3, InvocationTargetException -> 0x02b9, all -> 0x02b4 }
            java.lang.Object[] r5 = new java.lang.Object[r15]     // Catch:{ ClassNotFoundException -> 0x0321, NoSuchFieldException -> 0x0307, NoSuchMethodException -> 0x02ed, IllegalAccessException -> 0x02d3, InvocationTargetException -> 0x02b9, all -> 0x02b4 }
            java.lang.Object r4 = r1.invoke(r4, r5)     // Catch:{ ClassNotFoundException -> 0x0321, NoSuchFieldException -> 0x0307, NoSuchMethodException -> 0x02ed, IllegalAccessException -> 0x02d3, InvocationTargetException -> 0x02b9, all -> 0x02b4 }
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ ClassNotFoundException -> 0x0321, NoSuchFieldException -> 0x0307, NoSuchMethodException -> 0x02ed, IllegalAccessException -> 0x02d3, InvocationTargetException -> 0x02b9, all -> 0x02b4 }
            int r4 = r4.intValue()     // Catch:{ ClassNotFoundException -> 0x0321, NoSuchFieldException -> 0x0307, NoSuchMethodException -> 0x02ed, IllegalAccessException -> 0x02d3, InvocationTargetException -> 0x02b9, all -> 0x02b4 }
            if (r4 == r6) goto L_0x0179
            com.apptimize.au r1 = r14.f42578d     // Catch:{ ClassNotFoundException -> 0x00cf, NoSuchFieldException -> 0x00c8, NoSuchMethodException -> 0x00c1, IllegalAccessException -> 0x00ba, InvocationTargetException -> 0x00b3, all -> 0x00ae }
            com.apptimize.bq r1 = r1.a()     // Catch:{ ClassNotFoundException -> 0x00cf, NoSuchFieldException -> 0x00c8, NoSuchMethodException -> 0x00c1, IllegalAccessException -> 0x00ba, InvocationTargetException -> 0x00b3, all -> 0x00ae }
            java.lang.String r2 = f42565b     // Catch:{ ClassNotFoundException -> 0x00cf, NoSuchFieldException -> 0x00c8, NoSuchMethodException -> 0x00c1, IllegalAccessException -> 0x00ba, InvocationTargetException -> 0x00b3, all -> 0x00ae }
            java.lang.String r3 = "AN1011"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException -> 0x00cf, NoSuchFieldException -> 0x00c8, NoSuchMethodException -> 0x00c1, IllegalAccessException -> 0x00ba, InvocationTargetException -> 0x00b3, all -> 0x00ae }
            r5.<init>()     // Catch:{ ClassNotFoundException -> 0x00cf, NoSuchFieldException -> 0x00c8, NoSuchMethodException -> 0x00c1, IllegalAccessException -> 0x00ba, InvocationTargetException -> 0x00b3, all -> 0x00ae }
            r5.append(r7)     // Catch:{ ClassNotFoundException -> 0x00cf, NoSuchFieldException -> 0x00c8, NoSuchMethodException -> 0x00c1, IllegalAccessException -> 0x00ba, InvocationTargetException -> 0x00b3, all -> 0x00ae }
            r5.append(r4)     // Catch:{ ClassNotFoundException -> 0x00cf, NoSuchFieldException -> 0x00c8, NoSuchMethodException -> 0x00c1, IllegalAccessException -> 0x00ba, InvocationTargetException -> 0x00b3, all -> 0x00ae }
            java.lang.String r4 = r5.toString()     // Catch:{ ClassNotFoundException -> 0x00cf, NoSuchFieldException -> 0x00c8, NoSuchMethodException -> 0x00c1, IllegalAccessException -> 0x00ba, InvocationTargetException -> 0x00b3, all -> 0x00ae }
            r1.a(r2, r3, r4)     // Catch:{ ClassNotFoundException -> 0x00cf, NoSuchFieldException -> 0x00c8, NoSuchMethodException -> 0x00c1, IllegalAccessException -> 0x00ba, InvocationTargetException -> 0x00b3, all -> 0x00ae }
            r42.b()
            return r15
        L_0x0179:
            boolean r4 = r14.f42586l     // Catch:{ ClassNotFoundException -> 0x0321, NoSuchFieldException -> 0x0307, NoSuchMethodException -> 0x02ed, IllegalAccessException -> 0x02d3, InvocationTargetException -> 0x02b9, all -> 0x02b4 }
            if (r4 == 0) goto L_0x01af
            java.lang.Class<java.lang.reflect.Method> r4 = java.lang.reflect.Method.class
            java.lang.String r5 = "artMethod"
            java.lang.reflect.Field r4 = com.apptimize.fn.b((java.lang.Class<?>) r4, (java.lang.String) r5)     // Catch:{ ClassNotFoundException -> 0x00cf, NoSuchFieldException -> 0x00c8, NoSuchMethodException -> 0x00c1, IllegalAccessException -> 0x00ba, InvocationTargetException -> 0x00b3, all -> 0x00ae }
            java.lang.Class r4 = r4.getType()     // Catch:{ ClassNotFoundException -> 0x00cf, NoSuchFieldException -> 0x00c8, NoSuchMethodException -> 0x00c1, IllegalAccessException -> 0x00ba, InvocationTargetException -> 0x00b3, all -> 0x00ae }
            java.lang.String r5 = "accessFlags"
            java.lang.reflect.Field r5 = com.apptimize.fn.b((java.lang.Class<?>) r4, (java.lang.String) r5)     // Catch:{ ClassNotFoundException -> 0x00cf, NoSuchFieldException -> 0x00c8, NoSuchMethodException -> 0x00c1, IllegalAccessException -> 0x00ba, InvocationTargetException -> 0x00b3, all -> 0x00ae }
            java.lang.Object[] r7 = new java.lang.Object[r15]     // Catch:{ ClassNotFoundException -> 0x00cf, NoSuchFieldException -> 0x00c8, NoSuchMethodException -> 0x00c1, IllegalAccessException -> 0x00ba, InvocationTargetException -> 0x00b3, all -> 0x00ae }
            java.lang.Object r5 = r1.invoke(r5, r7)     // Catch:{ ClassNotFoundException -> 0x00cf, NoSuchFieldException -> 0x00c8, NoSuchMethodException -> 0x00c1, IllegalAccessException -> 0x00ba, InvocationTargetException -> 0x00b3, all -> 0x00ae }
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch:{ ClassNotFoundException -> 0x00cf, NoSuchFieldException -> 0x00c8, NoSuchMethodException -> 0x00c1, IllegalAccessException -> 0x00ba, InvocationTargetException -> 0x00b3, all -> 0x00ae }
            int r5 = r5.intValue()     // Catch:{ ClassNotFoundException -> 0x00cf, NoSuchFieldException -> 0x00c8, NoSuchMethodException -> 0x00c1, IllegalAccessException -> 0x00ba, InvocationTargetException -> 0x00b3, all -> 0x00ae }
            java.lang.String r7 = android.os.Build.VERSION.RELEASE     // Catch:{ ClassNotFoundException -> 0x00cf, NoSuchFieldException -> 0x00c8, NoSuchMethodException -> 0x00c1, IllegalAccessException -> 0x00ba, InvocationTargetException -> 0x00b3, all -> 0x00ae }
            java.lang.String r8 = "5.0"
            boolean r7 = r7.startsWith(r8)     // Catch:{ ClassNotFoundException -> 0x00cf, NoSuchFieldException -> 0x00c8, NoSuchMethodException -> 0x00c1, IllegalAccessException -> 0x00ba, InvocationTargetException -> 0x00b3, all -> 0x00ae }
            if (r7 == 0) goto L_0x01aa
            com.apptimize.gg$b r1 = com.apptimize.gg.b.a(r4, r1, r5)     // Catch:{ ClassNotFoundException -> 0x00cf, NoSuchFieldException -> 0x00c8, NoSuchMethodException -> 0x00c1, IllegalAccessException -> 0x00ba, InvocationTargetException -> 0x00b3, all -> 0x00ae }
            goto L_0x01b1
        L_0x01aa:
            com.apptimize.gg$b r1 = com.apptimize.gg.b.a(r5)     // Catch:{ ClassNotFoundException -> 0x00cf, NoSuchFieldException -> 0x00c8, NoSuchMethodException -> 0x00c1, IllegalAccessException -> 0x00ba, InvocationTargetException -> 0x00b3, all -> 0x00ae }
            goto L_0x01b1
        L_0x01af:
            com.apptimize.gg$b r1 = com.apptimize.gg.b.f42618a     // Catch:{ ClassNotFoundException -> 0x0321, NoSuchFieldException -> 0x0307, NoSuchMethodException -> 0x02ed, IllegalAccessException -> 0x02d3, InvocationTargetException -> 0x02b9, all -> 0x02b4 }
        L_0x01b1:
            r27 = r1
            com.apptimize.au r1 = r14.f42578d     // Catch:{ ClassNotFoundException -> 0x0321, NoSuchFieldException -> 0x0307, NoSuchMethodException -> 0x02ed, IllegalAccessException -> 0x02d3, InvocationTargetException -> 0x02b9, all -> 0x02b4 }
            com.apptimize.bq r1 = r1.a()     // Catch:{ ClassNotFoundException -> 0x0321, NoSuchFieldException -> 0x0307, NoSuchMethodException -> 0x02ed, IllegalAccessException -> 0x02d3, InvocationTargetException -> 0x02b9, all -> 0x02b4 }
            java.lang.Object r1 = r1.b()     // Catch:{ ClassNotFoundException -> 0x0321, NoSuchFieldException -> 0x0307, NoSuchMethodException -> 0x02ed, IllegalAccessException -> 0x02d3, InvocationTargetException -> 0x02b9, all -> 0x02b4 }
            r14.f42589q = r1     // Catch:{ ClassNotFoundException -> 0x0321, NoSuchFieldException -> 0x0307, NoSuchMethodException -> 0x02ed, IllegalAccessException -> 0x02d3, InvocationTargetException -> 0x02b9, all -> 0x02b4 }
            java.lang.String r24 = com.apptimize.bq.a()     // Catch:{ ClassNotFoundException -> 0x0321, NoSuchFieldException -> 0x0307, NoSuchMethodException -> 0x02ed, IllegalAccessException -> 0x02d3, InvocationTargetException -> 0x02b9, all -> 0x02b4 }
            com.apptimize.au r1 = r14.f42578d     // Catch:{ ClassNotFoundException -> 0x0321, NoSuchFieldException -> 0x0307, NoSuchMethodException -> 0x02ed, IllegalAccessException -> 0x02d3, InvocationTargetException -> 0x02b9, all -> 0x02b4 }
            com.apptimize.bq r1 = r1.a()     // Catch:{ ClassNotFoundException -> 0x0321, NoSuchFieldException -> 0x0307, NoSuchMethodException -> 0x02ed, IllegalAccessException -> 0x02d3, InvocationTargetException -> 0x02b9, all -> 0x02b4 }
            com.apptimize.au r4 = r14.f42578d     // Catch:{ ClassNotFoundException -> 0x0321, NoSuchFieldException -> 0x0307, NoSuchMethodException -> 0x02ed, IllegalAccessException -> 0x02d3, InvocationTargetException -> 0x02b9, all -> 0x02b4 }
            java.lang.String r25 = r1.a((com.apptimize.au) r4)     // Catch:{ ClassNotFoundException -> 0x0321, NoSuchFieldException -> 0x0307, NoSuchMethodException -> 0x02ed, IllegalAccessException -> 0x02d3, InvocationTargetException -> 0x02b9, all -> 0x02b4 }
            if (r25 != 0) goto L_0x01d5
            r42.b()
            return r15
        L_0x01d5:
            long r4 = r42.m()     // Catch:{ ClassNotFoundException -> 0x0321, NoSuchFieldException -> 0x0307, NoSuchMethodException -> 0x02ed, IllegalAccessException -> 0x02d3, InvocationTargetException -> 0x02b9, all -> 0x02b4 }
            long r7 = r42.n()     // Catch:{ ClassNotFoundException -> 0x0321, NoSuchFieldException -> 0x0307, NoSuchMethodException -> 0x02ed, IllegalAccessException -> 0x02d3, InvocationTargetException -> 0x02b9, all -> 0x02b4 }
            long r20 = r42.o()     // Catch:{ ClassNotFoundException -> 0x0321, NoSuchFieldException -> 0x0307, NoSuchMethodException -> 0x02ed, IllegalAccessException -> 0x02d3, InvocationTargetException -> 0x02b9, all -> 0x02b4 }
            long r28 = r42.q()     // Catch:{ ClassNotFoundException -> 0x0321, NoSuchFieldException -> 0x0307, NoSuchMethodException -> 0x02ed, IllegalAccessException -> 0x02d3, InvocationTargetException -> 0x02b9, all -> 0x02b4 }
            long r30 = r42.r()     // Catch:{ ClassNotFoundException -> 0x0321, NoSuchFieldException -> 0x0307, NoSuchMethodException -> 0x02ed, IllegalAccessException -> 0x02d3, InvocationTargetException -> 0x02b9, all -> 0x02b4 }
            long r32 = r42.s()     // Catch:{ ClassNotFoundException -> 0x0321, NoSuchFieldException -> 0x0307, NoSuchMethodException -> 0x02ed, IllegalAccessException -> 0x02d3, InvocationTargetException -> 0x02b9, all -> 0x02b4 }
            long r34 = r42.u()     // Catch:{ ClassNotFoundException -> 0x0321, NoSuchFieldException -> 0x0307, NoSuchMethodException -> 0x02ed, IllegalAccessException -> 0x02d3, InvocationTargetException -> 0x02b9, all -> 0x02b4 }
            long r36 = r42.v()     // Catch:{ ClassNotFoundException -> 0x0321, NoSuchFieldException -> 0x0307, NoSuchMethodException -> 0x02ed, IllegalAccessException -> 0x02d3, InvocationTargetException -> 0x02b9, all -> 0x02b4 }
            long r38 = r42.w()     // Catch:{ ClassNotFoundException -> 0x0321, NoSuchFieldException -> 0x0307, NoSuchMethodException -> 0x02ed, IllegalAccessException -> 0x02d3, InvocationTargetException -> 0x02b9, all -> 0x02b4 }
            java.lang.Class<?> r1 = r14.f42577c     // Catch:{ ClassNotFoundException -> 0x0321, NoSuchFieldException -> 0x0307, NoSuchMethodException -> 0x02ed, IllegalAccessException -> 0x02d3, InvocationTargetException -> 0x02b9, all -> 0x02b4 }
            java.lang.String r13 = "initNative"
            r6 = 22
            java.lang.Class[] r6 = new java.lang.Class[r6]     // Catch:{ ClassNotFoundException -> 0x0321, NoSuchFieldException -> 0x0307, NoSuchMethodException -> 0x02ed, IllegalAccessException -> 0x02d3, InvocationTargetException -> 0x02b9, all -> 0x02b4 }
            java.lang.Class r40 = java.lang.Long.TYPE     // Catch:{ ClassNotFoundException -> 0x0321, NoSuchFieldException -> 0x0307, NoSuchMethodException -> 0x02ed, IllegalAccessException -> 0x02d3, InvocationTargetException -> 0x02b9, all -> 0x02b4 }
            r6[r15] = r40     // Catch:{ ClassNotFoundException -> 0x0321, NoSuchFieldException -> 0x0307, NoSuchMethodException -> 0x02ed, IllegalAccessException -> 0x02d3, InvocationTargetException -> 0x02b9, all -> 0x02b4 }
            r6[r12] = r40     // Catch:{ ClassNotFoundException -> 0x0321, NoSuchFieldException -> 0x0307, NoSuchMethodException -> 0x02ed, IllegalAccessException -> 0x02d3, InvocationTargetException -> 0x02b9, all -> 0x02b4 }
            r6[r9] = r40     // Catch:{ ClassNotFoundException -> 0x0321, NoSuchFieldException -> 0x0307, NoSuchMethodException -> 0x02ed, IllegalAccessException -> 0x02d3, InvocationTargetException -> 0x02b9, all -> 0x02b4 }
            r6[r10] = r40     // Catch:{ ClassNotFoundException -> 0x0321, NoSuchFieldException -> 0x0307, NoSuchMethodException -> 0x02ed, IllegalAccessException -> 0x02d3, InvocationTargetException -> 0x02b9, all -> 0x02b4 }
            r6[r11] = r40     // Catch:{ ClassNotFoundException -> 0x0321, NoSuchFieldException -> 0x0307, NoSuchMethodException -> 0x02ed, IllegalAccessException -> 0x02d3, InvocationTargetException -> 0x02b9, all -> 0x02b4 }
            r6[r16] = r40     // Catch:{ ClassNotFoundException -> 0x0321, NoSuchFieldException -> 0x0307, NoSuchMethodException -> 0x02ed, IllegalAccessException -> 0x02d3, InvocationTargetException -> 0x02b9, all -> 0x02b4 }
            r6[r17] = r40     // Catch:{ ClassNotFoundException -> 0x0321, NoSuchFieldException -> 0x0307, NoSuchMethodException -> 0x02ed, IllegalAccessException -> 0x02d3, InvocationTargetException -> 0x02b9, all -> 0x02b4 }
            r6[r18] = r40     // Catch:{ ClassNotFoundException -> 0x0321, NoSuchFieldException -> 0x0307, NoSuchMethodException -> 0x02ed, IllegalAccessException -> 0x02d3, InvocationTargetException -> 0x02b9, all -> 0x02b4 }
            r9 = 8
            r6[r9] = r40     // Catch:{ ClassNotFoundException -> 0x0321, NoSuchFieldException -> 0x0307, NoSuchMethodException -> 0x02ed, IllegalAccessException -> 0x02d3, InvocationTargetException -> 0x02b9, all -> 0x02b4 }
            r9 = 9
            r6[r9] = r3     // Catch:{ ClassNotFoundException -> 0x0321, NoSuchFieldException -> 0x0307, NoSuchMethodException -> 0x02ed, IllegalAccessException -> 0x02d3, InvocationTargetException -> 0x02b9, all -> 0x02b4 }
            r9 = 10
            r6[r9] = r3     // Catch:{ ClassNotFoundException -> 0x0321, NoSuchFieldException -> 0x0307, NoSuchMethodException -> 0x02ed, IllegalAccessException -> 0x02d3, InvocationTargetException -> 0x02b9, all -> 0x02b4 }
            r9 = 11
            r6[r9] = r2     // Catch:{ ClassNotFoundException -> 0x0321, NoSuchFieldException -> 0x0307, NoSuchMethodException -> 0x02ed, IllegalAccessException -> 0x02d3, InvocationTargetException -> 0x02b9, all -> 0x02b4 }
            r2 = 12
            r6[r2] = r3     // Catch:{ ClassNotFoundException -> 0x0321, NoSuchFieldException -> 0x0307, NoSuchMethodException -> 0x02ed, IllegalAccessException -> 0x02d3, InvocationTargetException -> 0x02b9, all -> 0x02b4 }
            r2 = 13
            r6[r2] = r3     // Catch:{ ClassNotFoundException -> 0x0321, NoSuchFieldException -> 0x0307, NoSuchMethodException -> 0x02ed, IllegalAccessException -> 0x02d3, InvocationTargetException -> 0x02b9, all -> 0x02b4 }
            java.lang.Class r2 = java.lang.Integer.TYPE     // Catch:{ ClassNotFoundException -> 0x0321, NoSuchFieldException -> 0x0307, NoSuchMethodException -> 0x02ed, IllegalAccessException -> 0x02d3, InvocationTargetException -> 0x02b9, all -> 0x02b4 }
            r3 = 14
            r6[r3] = r2     // Catch:{ ClassNotFoundException -> 0x0321, NoSuchFieldException -> 0x0307, NoSuchMethodException -> 0x02ed, IllegalAccessException -> 0x02d3, InvocationTargetException -> 0x02b9, all -> 0x02b4 }
            r3 = 15
            r6[r3] = r2     // Catch:{ ClassNotFoundException -> 0x0321, NoSuchFieldException -> 0x0307, NoSuchMethodException -> 0x02ed, IllegalAccessException -> 0x02d3, InvocationTargetException -> 0x02b9, all -> 0x02b4 }
            r3 = 16
            r6[r3] = r2     // Catch:{ ClassNotFoundException -> 0x0321, NoSuchFieldException -> 0x0307, NoSuchMethodException -> 0x02ed, IllegalAccessException -> 0x02d3, InvocationTargetException -> 0x02b9, all -> 0x02b4 }
            r3 = 17
            r6[r3] = r2     // Catch:{ ClassNotFoundException -> 0x0321, NoSuchFieldException -> 0x0307, NoSuchMethodException -> 0x02ed, IllegalAccessException -> 0x02d3, InvocationTargetException -> 0x02b9, all -> 0x02b4 }
            r3 = 18
            r6[r3] = r2     // Catch:{ ClassNotFoundException -> 0x0321, NoSuchFieldException -> 0x0307, NoSuchMethodException -> 0x02ed, IllegalAccessException -> 0x02d3, InvocationTargetException -> 0x02b9, all -> 0x02b4 }
            r3 = 19
            r6[r3] = r2     // Catch:{ ClassNotFoundException -> 0x0321, NoSuchFieldException -> 0x0307, NoSuchMethodException -> 0x02ed, IllegalAccessException -> 0x02d3, InvocationTargetException -> 0x02b9, all -> 0x02b4 }
            java.lang.Class r2 = java.lang.Boolean.TYPE     // Catch:{ ClassNotFoundException -> 0x0321, NoSuchFieldException -> 0x0307, NoSuchMethodException -> 0x02ed, IllegalAccessException -> 0x02d3, InvocationTargetException -> 0x02b9, all -> 0x02b4 }
            r3 = 20
            r6[r3] = r2     // Catch:{ ClassNotFoundException -> 0x0321, NoSuchFieldException -> 0x0307, NoSuchMethodException -> 0x02ed, IllegalAccessException -> 0x02d3, InvocationTargetException -> 0x02b9, all -> 0x02b4 }
            r3 = 21
            r6[r3] = r2     // Catch:{ ClassNotFoundException -> 0x0321, NoSuchFieldException -> 0x0307, NoSuchMethodException -> 0x02ed, IllegalAccessException -> 0x02d3, InvocationTargetException -> 0x02b9, all -> 0x02b4 }
            java.lang.reflect.Method r3 = r1.getMethod(r13, r6)     // Catch:{ ClassNotFoundException -> 0x0321, NoSuchFieldException -> 0x0307, NoSuchMethodException -> 0x02ed, IllegalAccessException -> 0x02d3, InvocationTargetException -> 0x02b9, all -> 0x02b4 }
            com.apptimize.gg$1 r13 = new com.apptimize.gg$1     // Catch:{ ClassNotFoundException -> 0x0321, NoSuchFieldException -> 0x0307, NoSuchMethodException -> 0x02ed, IllegalAccessException -> 0x02d3, InvocationTargetException -> 0x02b9, all -> 0x02b4 }
            r1 = r13
            r2 = r42
            r6 = r7
            r8 = r20
            r10 = r28
            r29 = r12
            r41 = r13
            r12 = r30
            r30 = r15
            r14 = r32
            r16 = r34
            r18 = r36
            r20 = r38
            r28 = r44
            r1.<init>(r2, r3, r4, r6, r8, r10, r12, r14, r16, r18, r20, r22, r23, r24, r25, r26, r27, r28)     // Catch:{ ClassNotFoundException -> 0x02af, NoSuchFieldException -> 0x02ab, NoSuchMethodException -> 0x02a7, IllegalAccessException -> 0x02a3, InvocationTargetException -> 0x029f, all -> 0x029b }
            r1 = r42
            com.apptimize.au r2 = r1.f42578d     // Catch:{ ClassNotFoundException -> 0x0298, NoSuchFieldException -> 0x0295, NoSuchMethodException -> 0x0292, IllegalAccessException -> 0x0290, InvocationTargetException -> 0x028e }
            com.apptimize.h r2 = r2.c()     // Catch:{ ClassNotFoundException -> 0x0298, NoSuchFieldException -> 0x0295, NoSuchMethodException -> 0x0292, IllegalAccessException -> 0x0290, InvocationTargetException -> 0x028e }
            r3 = r41
            r2.a((com.apptimize.fi) r3)     // Catch:{ ClassNotFoundException -> 0x0298, NoSuchFieldException -> 0x0295, NoSuchMethodException -> 0x0292, IllegalAccessException -> 0x0290, InvocationTargetException -> 0x028e }
            int r2 = O     // Catch:{ ClassNotFoundException -> 0x0298, NoSuchFieldException -> 0x0295, NoSuchMethodException -> 0x0292, IllegalAccessException -> 0x0290, InvocationTargetException -> 0x028e }
            int r3 = L     // Catch:{ ClassNotFoundException -> 0x0298, NoSuchFieldException -> 0x0295, NoSuchMethodException -> 0x0292, IllegalAccessException -> 0x0290, InvocationTargetException -> 0x028e }
            if (r2 == r3) goto L_0x0288
            r15 = r29
            goto L_0x028a
        L_0x0288:
            r15 = r30
        L_0x028a:
            r42.b()
            return r15
        L_0x028e:
            r0 = move-exception
            goto L_0x02bd
        L_0x0290:
            r0 = move-exception
            goto L_0x02d7
        L_0x0292:
            r0 = move-exception
            goto L_0x02f1
        L_0x0295:
            r0 = move-exception
            goto L_0x030b
        L_0x0298:
            r0 = move-exception
            goto L_0x0325
        L_0x029b:
            r0 = move-exception
            r1 = r42
            goto L_0x02b6
        L_0x029f:
            r0 = move-exception
            r1 = r42
            goto L_0x02bd
        L_0x02a3:
            r0 = move-exception
            r1 = r42
            goto L_0x02d7
        L_0x02a7:
            r0 = move-exception
            r1 = r42
            goto L_0x02f1
        L_0x02ab:
            r0 = move-exception
            r1 = r42
            goto L_0x030b
        L_0x02af:
            r0 = move-exception
            r1 = r42
            goto L_0x0325
        L_0x02b4:
            r0 = move-exception
            r1 = r14
        L_0x02b6:
            r2 = r0
            goto L_0x033e
        L_0x02b9:
            r0 = move-exception
            r1 = r14
            r30 = r15
        L_0x02bd:
            r2 = r0
        L_0x02be:
            com.apptimize.au r3 = r1.f42578d     // Catch:{ all -> 0x033b }
            com.apptimize.bq r3 = r3.a()     // Catch:{ all -> 0x033b }
            java.lang.String r4 = f42565b     // Catch:{ all -> 0x033b }
            java.lang.String r5 = "AN1006-5"
            java.lang.String r2 = com.apptimize.fx.a((java.lang.Exception) r2)     // Catch:{ all -> 0x033b }
            r3.a(r4, r5, r2)     // Catch:{ all -> 0x033b }
            r42.b()
            return r30
        L_0x02d3:
            r0 = move-exception
            r1 = r14
            r30 = r15
        L_0x02d7:
            r2 = r0
        L_0x02d8:
            com.apptimize.au r3 = r1.f42578d     // Catch:{ all -> 0x033b }
            com.apptimize.bq r3 = r3.a()     // Catch:{ all -> 0x033b }
            java.lang.String r4 = f42565b     // Catch:{ all -> 0x033b }
            java.lang.String r5 = "AN1006-4"
            java.lang.String r2 = com.apptimize.fx.a((java.lang.Exception) r2)     // Catch:{ all -> 0x033b }
            r3.a(r4, r5, r2)     // Catch:{ all -> 0x033b }
            r42.b()
            return r30
        L_0x02ed:
            r0 = move-exception
            r1 = r14
            r30 = r15
        L_0x02f1:
            r2 = r0
        L_0x02f2:
            com.apptimize.au r3 = r1.f42578d     // Catch:{ all -> 0x033b }
            com.apptimize.bq r3 = r3.a()     // Catch:{ all -> 0x033b }
            java.lang.String r4 = f42565b     // Catch:{ all -> 0x033b }
            java.lang.String r5 = "AN1006-3"
            java.lang.String r2 = com.apptimize.fx.a((java.lang.Exception) r2)     // Catch:{ all -> 0x033b }
            r3.a(r4, r5, r2)     // Catch:{ all -> 0x033b }
            r42.b()
            return r30
        L_0x0307:
            r0 = move-exception
            r1 = r14
            r30 = r15
        L_0x030b:
            r2 = r0
        L_0x030c:
            com.apptimize.au r3 = r1.f42578d     // Catch:{ all -> 0x033b }
            com.apptimize.bq r3 = r3.a()     // Catch:{ all -> 0x033b }
            java.lang.String r4 = f42565b     // Catch:{ all -> 0x033b }
            java.lang.String r5 = "AN1006-2"
            java.lang.String r2 = com.apptimize.fx.a((java.lang.Exception) r2)     // Catch:{ all -> 0x033b }
            r3.a(r4, r5, r2)     // Catch:{ all -> 0x033b }
            r42.b()
            return r30
        L_0x0321:
            r0 = move-exception
            r1 = r14
            r30 = r15
        L_0x0325:
            r2 = r0
        L_0x0326:
            com.apptimize.au r3 = r1.f42578d     // Catch:{ all -> 0x033b }
            com.apptimize.bq r3 = r3.a()     // Catch:{ all -> 0x033b }
            java.lang.String r4 = f42565b     // Catch:{ all -> 0x033b }
            java.lang.String r5 = "AN1006-1"
            java.lang.String r2 = com.apptimize.fx.a((java.lang.Exception) r2)     // Catch:{ all -> 0x033b }
            r3.a(r4, r5, r2)     // Catch:{ all -> 0x033b }
            r42.b()
            return r30
        L_0x033b:
            r0 = move-exception
            goto L_0x02b6
        L_0x033e:
            r42.b()
            throw r2
        L_0x0342:
            r0 = move-exception
            r1 = r14
        L_0x0344:
            r2 = r0
            goto L_0x0362
        L_0x0346:
            r0 = move-exception
            r1 = r14
            r30 = r15
            r2 = r0
            com.apptimize.au r3 = r1.f42578d     // Catch:{ all -> 0x0360 }
            com.apptimize.bq r3 = r3.a()     // Catch:{ all -> 0x0360 }
            java.lang.String r4 = f42565b     // Catch:{ all -> 0x0360 }
            java.lang.String r5 = "AN1006-0"
            java.lang.String r2 = com.apptimize.fx.a((java.lang.Exception) r2)     // Catch:{ all -> 0x0360 }
            r3.a(r4, r5, r2)     // Catch:{ all -> 0x0360 }
            r42.b()
            return r30
        L_0x0360:
            r0 = move-exception
            goto L_0x0344
        L_0x0362:
            r42.b()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.gg.a(android.content.Context, boolean):boolean");
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final b f42618a = new b(-1, -1, -1, -1, -1);

        /* renamed from: b  reason: collision with root package name */
        public final int f42619b;

        /* renamed from: c  reason: collision with root package name */
        public final int f42620c;

        /* renamed from: d  reason: collision with root package name */
        public final int f42621d;

        /* renamed from: e  reason: collision with root package name */
        public final int f42622e;

        /* renamed from: f  reason: collision with root package name */
        public final int f42623f;

        public b(int i11, int i12, int i13, int i14, int i15) {
            this.f42619b = i11;
            this.f42620c = i12;
            this.f42621d = i13;
            this.f42622e = i14;
            this.f42623f = i15;
        }

        public static b a(Class<?> cls, Method method, int i11) throws NoSuchFieldException, InvocationTargetException, IllegalAccessException {
            return new b(((Integer) method.invoke(fn.b(cls, "entryPointFromJni"), new Object[0])).intValue(), ((Integer) method.invoke(fn.b(cls, "entryPointFromInterpreter"), new Object[0])).intValue(), ((Integer) method.invoke(fn.b(cls, "entryPointFromQuickCompiledCode"), new Object[0])).intValue(), ((Integer) method.invoke(fn.b(cls, "gcMap"), new Object[0])).intValue(), i11);
        }

        public static b a(int i11) {
            return new b(-1, -1, -1, -1, i11);
        }
    }

    private long b(Map.Entry<Long, gj> entry) {
        return entry.getKey().longValue();
    }

    /* access modifiers changed from: private */
    public synchronized void b(boolean z11) {
        if (!this.f42588p) {
            long c11 = c(z11);
            if (c11 != 0 && a()) {
                try {
                    String str = f42565b;
                    bo.k(str, "crashlytics library at " + c11);
                    this.f42577c.getMethod("initForCrashlytics", new Class[]{Long.TYPE}).invoke((Object) null, new Object[]{Long.valueOf(c11)});
                    this.f42588p = true;
                } catch (Exception e11) {
                    try {
                        String str2 = f42565b;
                        bo.k(str2, "initForCrashlytics exception " + z11 + " " + fx.a(e11));
                        i();
                    } catch (Throwable th2) {
                        b();
                        throw th2;
                    }
                }
                b();
                this.f42588p = true;
            }
        }
    }

    public int d(Method method) throws IllegalAccessException, NoSuchFieldException {
        Object obj = method;
        if (this.f42586l) {
            obj = b(method);
        }
        try {
            return fn.b(obj, "accessFlags");
        } catch (NoSuchFieldException e11) {
            bo.h(f42565b, "accessFlags not found", e11);
            return -1;
        }
    }

    public void d() {
        a(false);
    }

    public String c(String str) {
        int indexOf = str.indexOf("/");
        if (indexOf <= 0) {
            return null;
        }
        String substring = str.substring(indexOf);
        String str2 = f42565b;
        bo.k(str2, "path:" + substring);
        return substring;
    }

    private Long g(Method method) {
        Long l11 = null;
        try {
            if (this.f42586l) {
                Object b11 = b(method);
                l11 = (Long) this.f42585k.invoke((Object) null, new Object[]{b11});
            } else {
                l11 = Long.valueOf(fn.c(method, "artMethod"));
            }
        } catch (NoSuchFieldException e11) {
            this.f42578d.a().a(f42565b, "AN1006-6", fx.a((Exception) e11));
        } catch (InvocationTargetException e12) {
            this.f42578d.a().a(f42565b, "AN1006-7", fx.a((Exception) e12));
        } catch (IllegalAccessException e13) {
            this.f42578d.a().a(f42565b, "AN1006-8", fx.a((Exception) e13));
        }
        if (l11 != null) {
            f(method);
            a(l11, method);
        }
        return l11;
    }

    public Object b(Method method) throws NoSuchFieldException, IllegalAccessException {
        if (this.f42586l) {
            return fn.d(method, "artMethod");
        }
        throw new RuntimeException("Incompatible Android SDK");
    }

    public int b(Class<?> cls) throws IllegalAccessException, NoSuchFieldException {
        return fn.b((Object) cls, "dexClassDefIndex");
    }

    public a b(String str) {
        long j11;
        long j12;
        boolean z11;
        boolean z12;
        boolean z13;
        String str2 = str;
        String[] split = str2.split("\\s+");
        if (split.length >= 6) {
            String[] split2 = split[0].split(SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE);
            long parseLong = Long.parseLong(split2[0], 16);
            j11 = Long.parseLong(split2[1], 16);
            j12 = parseLong;
        } else {
            j12 = 0;
            j11 = 0;
        }
        if (split.length >= 2) {
            boolean contains = split[1].contains("r");
            boolean contains2 = split[1].contains("w");
            z11 = split[1].contains(Param.X);
            z13 = contains;
            z12 = contains2;
        } else {
            z13 = false;
            z12 = false;
            z11 = false;
        }
        return new a(j12, j11, z13, z12, z11, z11 && str2.contains(".so"));
    }

    public synchronized boolean a() {
        boolean z11;
        z11 = this.f42587o > 0;
        long[] x11 = x();
        if (this.f42587o == 0 || (x11 != null && x11.length > 0)) {
            try {
                if (this.f42582h == null) {
                    this.f42582h = this.f42577c.getMethod("preInit", new Class[]{Integer.TYPE, Long.TYPE, String.class, String.class, long[].class});
                }
                z11 = ((Boolean) this.f42582h.invoke((Object) null, new Object[]{Integer.valueOf(Build.VERSION.SDK_INT), Long.valueOf(m()), p(), t(), x()})).booleanValue();
                y();
            } catch (NoSuchMethodException e11) {
                this.f42578d.a().a(f42565b, "AN1006-13", fx.a((Exception) e11));
            } catch (IllegalAccessException e12) {
                this.f42578d.a().a(f42565b, "AN1006-14", fx.a((Exception) e12));
            } catch (InvocationTargetException e13) {
                this.f42578d.a().a(f42565b, "AN1006-15", fx.a((Exception) e13));
            }
        }
        if (z11) {
            this.f42587o++;
        }
        return z11;
    }

    private void a(TreeMap<Long, gj> treeMap, a aVar) {
        gj gjVar;
        long j11 = aVar.f42611a;
        if (j11 != 0) {
            gj gjVar2 = treeMap.get(Long.valueOf(j11));
            int i11 = 0;
            int i12 = gj.f42629a | (aVar.f42613c ? gj.f42630b : 0) | (aVar.f42614d ? gj.f42631c : 0) | (aVar.f42615e ? gj.f42632d : 0);
            if (aVar.f42616f) {
                i11 = gj.f42633e;
            }
            int i13 = i12 | i11;
            if (gjVar2 == null || gjVar2.f42635g != i13) {
                gjVar = new gj(aVar.f42611a, i13);
            } else {
                treeMap.remove(Long.valueOf(aVar.f42611a));
                gjVar = new gj(gjVar2.f42634f, i13);
            }
            treeMap.put(Long.valueOf(aVar.f42612b), gjVar);
        }
    }

    private long a(Map.Entry<Long, gj> entry) {
        return entry.getValue().f42634f;
    }

    public synchronized void a(Method method, int i11, boolean z11) {
        Method method2;
        a();
        try {
            fa.a(this.f42578d);
            c(method.getDeclaringClass());
            if (Modifier.isStatic(method.getModifiers())) {
                method2 = this.f42581g.get(h(method));
            } else {
                method2 = this.f42580f.get(h(method));
            }
            Method method3 = method2;
            if (!gn.o() && this.f42579e.a(method)) {
                bq a11 = this.f42578d.a();
                String str = f42565b;
                a11.a(str, "Cannot initialize Apptimize visual editing when called from method " + method, "");
                b();
            } else if (method3 == null) {
                this.f42578d.a().a(f42565b, "AN1009", method.toString());
                b();
            } else {
                a(method, h(method), method.getDeclaringClass(), method3, a(method.getDeclaringClass()), b(method.getDeclaringClass()), c(method), d(method), z11);
                b();
            }
        } catch (ClassNotFoundException e11) {
            this.f42578d.a().a(f42565b, "AN1007-0", fx.a((Exception) e11));
        } catch (IllegalAccessException e12) {
            this.f42578d.a().a(f42565b, "AN1007-1", fx.a((Exception) e12));
        } catch (NoSuchMethodException e13) {
            this.f42578d.a().a(f42565b, "AN1007-2", fx.a((Exception) e13));
        } catch (NoSuchFieldException e14) {
            try {
                this.f42578d.a().a(f42565b, "AN1007-3", fx.a((Exception) e14));
            } catch (Throwable th2) {
                b();
                throw th2;
            }
        }
    }

    private Method a(List<Method> list, String str) throws NoSuchMethodException {
        for (Method next : list) {
            if (str.equals(next.getName())) {
                return next;
            }
        }
        throw new NoSuchMethodException(str);
    }

    public Long a(Method method) {
        Long e11 = e(method);
        return e11 == null ? g(method) : e11;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0088 A[Catch:{ IllegalAccessException -> 0x0071, InvocationTargetException -> 0x0053 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void a(java.lang.reflect.Method r9, java.lang.String r10, java.lang.Object r11, java.lang.reflect.Method r12, long r13, int r15, int r16, int r17, boolean r18) throws java.lang.NoSuchMethodException {
        /*
            r8 = this;
            r1 = r8
            monitor-enter(r8)
            r2 = 0
            java.lang.reflect.Method r0 = r1.f42583i     // Catch:{ IllegalAccessException -> 0x0071, InvocationTargetException -> 0x0053 }
            r4 = 9
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ IllegalAccessException -> 0x0071, InvocationTargetException -> 0x0053 }
            java.lang.Long r5 = r8.a((java.lang.reflect.Method) r9)     // Catch:{ IllegalAccessException -> 0x0071, InvocationTargetException -> 0x0053 }
            r6 = 0
            r4[r6] = r5     // Catch:{ IllegalAccessException -> 0x0071, InvocationTargetException -> 0x0053 }
            r5 = 1
            r4[r5] = r10     // Catch:{ IllegalAccessException -> 0x0071, InvocationTargetException -> 0x0053 }
            r5 = 2
            r4[r5] = r11     // Catch:{ IllegalAccessException -> 0x0071, InvocationTargetException -> 0x0053 }
            r5 = r12
            java.lang.Long r5 = r8.a((java.lang.reflect.Method) r12)     // Catch:{ IllegalAccessException -> 0x0071, InvocationTargetException -> 0x0053 }
            r6 = 3
            r4[r6] = r5     // Catch:{ IllegalAccessException -> 0x0071, InvocationTargetException -> 0x0053 }
            java.lang.Long r5 = java.lang.Long.valueOf(r13)     // Catch:{ IllegalAccessException -> 0x0071, InvocationTargetException -> 0x0053 }
            r6 = 4
            r4[r6] = r5     // Catch:{ IllegalAccessException -> 0x0071, InvocationTargetException -> 0x0053 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r15)     // Catch:{ IllegalAccessException -> 0x0071, InvocationTargetException -> 0x0053 }
            r6 = 5
            r4[r6] = r5     // Catch:{ IllegalAccessException -> 0x0071, InvocationTargetException -> 0x0053 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r16)     // Catch:{ IllegalAccessException -> 0x0071, InvocationTargetException -> 0x0053 }
            r6 = 6
            r4[r6] = r5     // Catch:{ IllegalAccessException -> 0x0071, InvocationTargetException -> 0x0053 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r17)     // Catch:{ IllegalAccessException -> 0x0071, InvocationTargetException -> 0x0053 }
            r6 = 7
            r4[r6] = r5     // Catch:{ IllegalAccessException -> 0x0071, InvocationTargetException -> 0x0053 }
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r18)     // Catch:{ IllegalAccessException -> 0x0071, InvocationTargetException -> 0x0053 }
            r6 = 8
            r4[r6] = r5     // Catch:{ IllegalAccessException -> 0x0071, InvocationTargetException -> 0x0053 }
            r5 = 0
            java.lang.Object r0 = r0.invoke(r5, r4)     // Catch:{ IllegalAccessException -> 0x0071, InvocationTargetException -> 0x0053 }
            if (r0 == 0) goto L_0x0083
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ IllegalAccessException -> 0x0071, InvocationTargetException -> 0x0053 }
            long r4 = r0.longValue()     // Catch:{ IllegalAccessException -> 0x0071, InvocationTargetException -> 0x0053 }
            goto L_0x0084
        L_0x0051:
            r0 = move-exception
            goto L_0x00af
        L_0x0053:
            r0 = move-exception
            java.lang.Throwable r4 = r0.getCause()     // Catch:{ all -> 0x0051 }
            boolean r5 = r4 instanceof java.lang.NoSuchMethodException     // Catch:{ all -> 0x0051 }
            if (r5 != 0) goto L_0x006e
            com.apptimize.au r4 = r1.f42578d     // Catch:{ all -> 0x0051 }
            com.apptimize.bq r4 = r4.a()     // Catch:{ all -> 0x0051 }
            java.lang.String r5 = f42565b     // Catch:{ all -> 0x0051 }
            java.lang.String r6 = "AN1002"
            java.lang.String r0 = com.apptimize.fx.a((java.lang.Exception) r0)     // Catch:{ all -> 0x0051 }
            r4.a(r5, r6, r0)     // Catch:{ all -> 0x0051 }
            goto L_0x0083
        L_0x006e:
            java.lang.NoSuchMethodException r4 = (java.lang.NoSuchMethodException) r4     // Catch:{ all -> 0x0051 }
            throw r4     // Catch:{ all -> 0x0051 }
        L_0x0071:
            r0 = move-exception
            com.apptimize.au r4 = r1.f42578d     // Catch:{ all -> 0x0051 }
            com.apptimize.bq r4 = r4.a()     // Catch:{ all -> 0x0051 }
            java.lang.String r5 = f42565b     // Catch:{ all -> 0x0051 }
            java.lang.String r6 = "AN1002"
            java.lang.String r0 = com.apptimize.fx.a((java.lang.Exception) r0)     // Catch:{ all -> 0x0051 }
            r4.a(r5, r6, r0)     // Catch:{ all -> 0x0051 }
        L_0x0083:
            r4 = r2
        L_0x0084:
            int r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r0 == 0) goto L_0x00ad
            com.apptimize.au r0 = r1.f42578d     // Catch:{ all -> 0x0051 }
            com.apptimize.bq r0 = r0.a()     // Catch:{ all -> 0x0051 }
            java.lang.String r2 = f42565b     // Catch:{ all -> 0x0051 }
            java.lang.String r3 = "AN1002"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0051 }
            r6.<init>()     // Catch:{ all -> 0x0051 }
            java.lang.String r7 = r9.getName()     // Catch:{ all -> 0x0051 }
            r6.append(r7)     // Catch:{ all -> 0x0051 }
            java.lang.String r7 = " AN0"
            r6.append(r7)     // Catch:{ all -> 0x0051 }
            r6.append(r4)     // Catch:{ all -> 0x0051 }
            java.lang.String r4 = r6.toString()     // Catch:{ all -> 0x0051 }
            r0.b(r2, r3, r4)     // Catch:{ all -> 0x0051 }
        L_0x00ad:
            monitor-exit(r8)
            return
        L_0x00af:
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.gg.a(java.lang.reflect.Method, java.lang.String, java.lang.Object, java.lang.reflect.Method, long, int, int, int, boolean):void");
    }

    public long a(Class<?> cls) throws IllegalAccessException, NoSuchFieldException {
        return fn.c(fn.d(cls, "dexCache"), "dexFile");
    }

    /* JADX WARNING: Removed duplicated region for block: B:59:0x015c A[SYNTHETIC, Splitter:B:59:0x015c] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0165 A[SYNTHETIC, Splitter:B:66:0x0165] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0173  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0175  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x018b  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x019f  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01a1  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01b5  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x01b7  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01cb  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01cd  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01e2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(boolean r12) {
        /*
            r11 = this;
            java.lang.String r0 = "libartbase.so"
            java.lang.String r1 = "libart.so"
            boolean r2 = r11.P
            if (r2 == 0) goto L_0x000a
            if (r12 == 0) goto L_0x01ee
        L_0x000a:
            java.util.TreeMap r12 = new java.util.TreeMap
            r12.<init>()
            f42568r = r12
            r2 = 0
            f42569s = r2
            f42570t = r2
            f42571u = r2
            r12 = 0
            f42572v = r12
            java.util.TreeMap r4 = new java.util.TreeMap
            r4.<init>()
            f42573w = r4
            f42574x = r2
            f42575y = r2
            f42576z = r2
            A = r12
            java.util.TreeMap r4 = new java.util.TreeMap
            r4.<init>()
            B = r4
            C = r2
            java.util.TreeMap r4 = new java.util.TreeMap
            r4.<init>()
            D = r4
            E = r2
            F = r2
            java.util.TreeMap r4 = new java.util.TreeMap
            r4.<init>()
            I = r4
            java.util.TreeMap r4 = new java.util.TreeMap
            r4.<init>()
            G = r4
            J = r12
            android.os.StrictMode$ThreadPolicy r4 = android.os.StrictMode.allowThreadDiskReads()
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0163, all -> 0x0157 }
            java.io.FileReader r6 = new java.io.FileReader     // Catch:{ Exception -> 0x0163, all -> 0x0157 }
            java.lang.String r7 = "/proc/self/maps"
            r6.<init>(r7)     // Catch:{ Exception -> 0x0163, all -> 0x0157 }
            r5.<init>(r6)     // Catch:{ Exception -> 0x0163, all -> 0x0157 }
        L_0x005f:
            java.lang.String r12 = r5.readLine()     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            if (r12 == 0) goto L_0x014f
            boolean r6 = r12.contains(r1)     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            if (r6 == 0) goto L_0x00a4
            java.lang.String r6 = f42565b     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            r7.<init>()     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            r7.append(r1)     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            r7.append(r12)     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            com.apptimize.bo.k(r6, r7)     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            com.apptimize.gg$a r6 = r11.b((java.lang.String) r12)     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            java.util.TreeMap<java.lang.Long, com.apptimize.gj> r7 = f42568r     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            r11.a((java.util.TreeMap<java.lang.Long, com.apptimize.gj>) r7, (com.apptimize.gg.a) r6)     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            java.lang.String r7 = f42572v     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            if (r7 == 0) goto L_0x008d
            goto L_0x0091
        L_0x008d:
            java.lang.String r7 = r11.c((java.lang.String) r12)     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
        L_0x0091:
            f42572v = r7     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            long r7 = f42571u     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            boolean r12 = r6.f42615e     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            if (r12 == 0) goto L_0x009c
            long r9 = r6.f42612b     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            goto L_0x009d
        L_0x009c:
            r9 = r2
        L_0x009d:
            long r6 = java.lang.Math.max(r7, r9)     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            f42571u = r6     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            goto L_0x005f
        L_0x00a4:
            java.lang.String r6 = "libart-compiler.so"
            boolean r6 = r12.contains(r6)     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            if (r6 == 0) goto L_0x00d1
            com.apptimize.gg$a r6 = r11.b((java.lang.String) r12)     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            java.util.TreeMap<java.lang.Long, com.apptimize.gj> r7 = f42573w     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            r11.a((java.util.TreeMap<java.lang.Long, com.apptimize.gj>) r7, (com.apptimize.gg.a) r6)     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            java.lang.String r7 = A     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            if (r7 == 0) goto L_0x00ba
            goto L_0x00be
        L_0x00ba:
            java.lang.String r7 = r11.c((java.lang.String) r12)     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
        L_0x00be:
            A = r7     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            long r7 = f42576z     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            boolean r12 = r6.f42615e     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            if (r12 == 0) goto L_0x00c9
            long r9 = r6.f42612b     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            goto L_0x00ca
        L_0x00c9:
            r9 = r2
        L_0x00ca:
            long r6 = java.lang.Math.max(r7, r9)     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            f42576z = r6     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            goto L_0x005f
        L_0x00d1:
            boolean r6 = r12.contains(r0)     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            if (r6 == 0) goto L_0x0106
            java.lang.String r6 = f42565b     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            r7.<init>()     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            r7.append(r0)     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            r7.append(r12)     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            com.apptimize.bo.k(r6, r7)     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            com.apptimize.gg$a r12 = r11.b((java.lang.String) r12)     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            java.util.TreeMap<java.lang.Long, com.apptimize.gj> r6 = B     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            r11.a((java.util.TreeMap<java.lang.Long, com.apptimize.gj>) r6, (com.apptimize.gg.a) r12)     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            long r6 = C     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            boolean r8 = r12.f42615e     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            if (r8 == 0) goto L_0x00fd
            long r8 = r12.f42612b     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            goto L_0x00fe
        L_0x00fd:
            r8 = r2
        L_0x00fe:
            long r6 = java.lang.Math.max(r6, r8)     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            C = r6     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            goto L_0x005f
        L_0x0106:
            java.lang.String r6 = com.apptimize.gn.v()     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            boolean r6 = r12.contains(r6)     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            if (r6 == 0) goto L_0x011b
            java.util.TreeMap<java.lang.Long, com.apptimize.gj> r6 = D     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            com.apptimize.gg$a r12 = r11.b((java.lang.String) r12)     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            r11.a((java.util.TreeMap<java.lang.Long, com.apptimize.gj>) r6, (com.apptimize.gg.a) r12)     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            goto L_0x005f
        L_0x011b:
            java.lang.String r6 = "libcrashlytics.so"
            boolean r6 = r12.contains(r6)     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            if (r6 == 0) goto L_0x012e
            java.util.TreeMap<java.lang.Long, com.apptimize.gj> r6 = G     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            com.apptimize.gg$a r12 = r11.b((java.lang.String) r12)     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            r11.a((java.util.TreeMap<java.lang.Long, com.apptimize.gj>) r6, (com.apptimize.gg.a) r12)     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            goto L_0x005f
        L_0x012e:
            java.lang.String r6 = ".oat"
            boolean r6 = r12.contains(r6)     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            if (r6 != 0) goto L_0x0144
            java.lang.String r6 = ".odex"
            boolean r6 = r12.contains(r6)     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            if (r6 != 0) goto L_0x0144
            boolean r6 = r11.a((java.lang.String) r12)     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            if (r6 == 0) goto L_0x005f
        L_0x0144:
            java.util.TreeMap<java.lang.Long, com.apptimize.gj> r6 = I     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            com.apptimize.gg$a r12 = r11.b((java.lang.String) r12)     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            r11.a((java.util.TreeMap<java.lang.Long, com.apptimize.gj>) r6, (com.apptimize.gg.a) r12)     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            goto L_0x005f
        L_0x014f:
            r5.close()     // Catch:{ Exception -> 0x0168 }
            goto L_0x0168
        L_0x0153:
            r12 = move-exception
            goto L_0x015a
        L_0x0155:
            r12 = r5
            goto L_0x0163
        L_0x0157:
            r0 = move-exception
            r5 = r12
            r12 = r0
        L_0x015a:
            if (r5 == 0) goto L_0x015f
            r5.close()     // Catch:{ Exception -> 0x015f }
        L_0x015f:
            android.os.StrictMode.setThreadPolicy(r4)
            throw r12
        L_0x0163:
            if (r12 == 0) goto L_0x0168
            r12.close()     // Catch:{ Exception -> 0x0168 }
        L_0x0168:
            android.os.StrictMode.setThreadPolicy(r4)
            java.util.TreeMap<java.lang.Long, com.apptimize.gj> r12 = f42568r
            int r12 = r12.size()
            if (r12 != 0) goto L_0x0175
            r0 = r2
            goto L_0x017f
        L_0x0175:
            java.util.TreeMap<java.lang.Long, com.apptimize.gj> r12 = f42568r
            java.util.Map$Entry r12 = r12.firstEntry()
            long r0 = r11.a((java.util.Map.Entry<java.lang.Long, com.apptimize.gj>) r12)
        L_0x017f:
            f42569s = r0
            java.util.TreeMap<java.lang.Long, com.apptimize.gj> r12 = f42568r
            int r12 = r12.size()
            if (r12 != 0) goto L_0x018b
            r0 = r2
            goto L_0x0195
        L_0x018b:
            java.util.TreeMap<java.lang.Long, com.apptimize.gj> r12 = f42568r
            java.util.Map$Entry r12 = r12.lastEntry()
            long r0 = r11.b((java.util.Map.Entry<java.lang.Long, com.apptimize.gj>) r12)
        L_0x0195:
            f42570t = r0
            java.util.TreeMap<java.lang.Long, com.apptimize.gj> r12 = f42573w
            int r12 = r12.size()
            if (r12 != 0) goto L_0x01a1
            r0 = r2
            goto L_0x01ab
        L_0x01a1:
            java.util.TreeMap<java.lang.Long, com.apptimize.gj> r12 = f42573w
            java.util.Map$Entry r12 = r12.firstEntry()
            long r0 = r11.a((java.util.Map.Entry<java.lang.Long, com.apptimize.gj>) r12)
        L_0x01ab:
            f42574x = r0
            java.util.TreeMap<java.lang.Long, com.apptimize.gj> r12 = f42573w
            int r12 = r12.size()
            if (r12 != 0) goto L_0x01b7
            r0 = r2
            goto L_0x01c1
        L_0x01b7:
            java.util.TreeMap<java.lang.Long, com.apptimize.gj> r12 = f42573w
            java.util.Map$Entry r12 = r12.lastEntry()
            long r0 = r11.b((java.util.Map.Entry<java.lang.Long, com.apptimize.gj>) r12)
        L_0x01c1:
            f42575y = r0
            java.util.TreeMap<java.lang.Long, com.apptimize.gj> r12 = D
            int r12 = r12.size()
            if (r12 != 0) goto L_0x01cd
            r0 = r2
            goto L_0x01d7
        L_0x01cd:
            java.util.TreeMap<java.lang.Long, com.apptimize.gj> r12 = D
            java.util.Map$Entry r12 = r12.firstEntry()
            long r0 = r11.a((java.util.Map.Entry<java.lang.Long, com.apptimize.gj>) r12)
        L_0x01d7:
            E = r0
            java.util.TreeMap<java.lang.Long, com.apptimize.gj> r12 = D
            int r12 = r12.size()
            if (r12 != 0) goto L_0x01e2
            goto L_0x01ec
        L_0x01e2:
            java.util.TreeMap<java.lang.Long, com.apptimize.gj> r12 = D
            java.util.Map$Entry r12 = r12.lastEntry()
            long r2 = r11.b((java.util.Map.Entry<java.lang.Long, com.apptimize.gj>) r12)
        L_0x01ec:
            F = r2
        L_0x01ee:
            r12 = 1
            r11.P = r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.gg.a(boolean):void");
    }

    public boolean a(String str) {
        int indexOf = str.indexOf(32);
        if (indexOf < 0 || indexOf + 4 >= str.length() || str.charAt(indexOf + 3) != 'x') {
            return false;
        }
        return true;
    }
}
