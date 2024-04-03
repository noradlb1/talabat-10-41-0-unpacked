package com.apptimize;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.facebook.internal.security.CertificateUtil;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

public class bs {

    /* renamed from: a  reason: collision with root package name */
    public static bs f41454a = null;

    /* renamed from: b  reason: collision with root package name */
    public static int f41455b = 0;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final String f41456c = "bs";
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static int f41457d = 4;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static int f41458e = 50;

    /* renamed from: f  reason: collision with root package name */
    private static bs f41459f = null;

    /* renamed from: g  reason: collision with root package name */
    private static boolean f41460g = false;

    /* renamed from: h  reason: collision with root package name */
    private static String f41461h = gn.f42637b;

    /* renamed from: i  reason: collision with root package name */
    private static String f41462i = "computeFields";

    /* renamed from: j  reason: collision with root package name */
    private static String f41463j = "getMethodName";

    /* renamed from: k  reason: collision with root package name */
    private static String f41464k = "getStackTrace";

    /* renamed from: l  reason: collision with root package name */
    private static String f41465l = "sw";

    /* renamed from: m  reason: collision with root package name */
    private static String f41466m = "eh";

    /* renamed from: n  reason: collision with root package name */
    private static String f41467n = "rl";

    /* renamed from: o  reason: collision with root package name */
    private static String f41468o = "rs";

    /* renamed from: p  reason: collision with root package name */
    private static String f41469p = "ui";

    /* renamed from: x  reason: collision with root package name */
    private static final ConcurrentHashMap<Class<?>, String> f41470x;

    /* renamed from: q  reason: collision with root package name */
    private final d f41471q = new d();

    /* renamed from: r  reason: collision with root package name */
    private final Map<Method, String> f41472r = new HashMap();

    /* renamed from: s  reason: collision with root package name */
    private final Map<Method, Long> f41473s = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public final OutputStreamWriter f41474t;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public final OutputStreamWriter f41475u;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public boolean f41476v = false;

    /* renamed from: w  reason: collision with root package name */
    private Handler f41477w = new Handler(Looper.getMainLooper());

    /* renamed from: y  reason: collision with root package name */
    private long f41478y = System.nanoTime();

    public class a {

        /* renamed from: a  reason: collision with root package name */
        b f41480a;

        /* renamed from: b  reason: collision with root package name */
        String f41481b;

        /* renamed from: c  reason: collision with root package name */
        long f41482c;

        private a() {
        }
    }

    public enum b {
        INTERCEPTED,
        EXCEPTION_HANDLER,
        RUN_LOCKED,
        RUN_LOCKED_ON_MAIN_THREAD_SYNCHRONOUS,
        UI_TASK
    }

    public class c {

        /* renamed from: a  reason: collision with root package name */
        long f41490a;

        /* renamed from: b  reason: collision with root package name */
        String f41491b;

        /* renamed from: c  reason: collision with root package name */
        int f41492c = 0;

        /* renamed from: d  reason: collision with root package name */
        int f41493d = 0;

        /* renamed from: e  reason: collision with root package name */
        a[] f41494e = new a[bs.f41457d];

        public c(long j11, String str) {
            this.f41490a = j11;
            this.f41491b = str;
        }

        public String toString() {
            return "" + this.f41490a + " " + this.f41492c + " " + this.f41493d;
        }
    }

    public class d extends LinkedHashMap<Long, c> {
        public d() {
            super(50, 0.5f, true);
        }

        public boolean removeEldestEntry(Map.Entry<Long, c> entry) {
            return size() > bs.f41458e && entry.getValue().f41492c == 0;
        }
    }

    static {
        ConcurrentHashMap<Class<?>, String> concurrentHashMap;
        if (av.f41242e) {
            concurrentHashMap = new ConcurrentHashMap<>();
        } else {
            concurrentHashMap = null;
        }
        f41470x = concurrentHashMap;
    }

    private bs(Context context, boolean z11) {
        OutputStreamWriter outputStreamWriter;
        Exception e11;
        OutputStreamWriter outputStreamWriter2;
        File file;
        OutputStreamWriter outputStreamWriter3 = null;
        if (z11) {
            try {
                bo.m(f41456c, "directory: " + context.getFilesDir().getAbsolutePath());
                file = new File(context.getFilesDir().getAbsolutePath(), "timingLog.txt");
                file.delete();
                outputStreamWriter2 = new OutputStreamWriter(new FileOutputStream(file, true), "UTF-8");
            } catch (Exception e12) {
                e11 = e12;
                outputStreamWriter = null;
                try {
                    bo.j(f41456c, "msgWriter error: ", e11);
                    this.f41474t = outputStreamWriter3;
                    this.f41475u = outputStreamWriter;
                } catch (Throwable th2) {
                    th = th2;
                    this.f41474t = outputStreamWriter3;
                    this.f41475u = outputStreamWriter;
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                outputStreamWriter = null;
                this.f41474t = outputStreamWriter3;
                this.f41475u = outputStreamWriter;
                throw th;
            }
            try {
                System.out.println("TimingLog created msgWriter " + outputStreamWriter2 + " file:" + file);
            } catch (Exception e13) {
                e11 = e13;
                outputStreamWriter = null;
                outputStreamWriter3 = outputStreamWriter2;
                bo.j(f41456c, "msgWriter error: ", e11);
                this.f41474t = outputStreamWriter3;
                this.f41475u = outputStreamWriter;
            } catch (Throwable th4) {
                th = th4;
                outputStreamWriter = null;
                outputStreamWriter3 = outputStreamWriter2;
                this.f41474t = outputStreamWriter3;
                this.f41475u = outputStreamWriter;
                throw th;
            }
        } else {
            outputStreamWriter2 = null;
        }
        bo.h(f41456c, "Writing startup performance metrics to: " + context.getFilesDir().getAbsolutePath() + "/" + "apptimizePublicTimingLog.txt");
        File file2 = new File(context.getFilesDir().getAbsolutePath(), "apptimizePublicTimingLog.txt");
        file2.delete();
        OutputStreamWriter outputStreamWriter4 = new OutputStreamWriter(new FileOutputStream(file2, true), "UTF-8");
        try {
            System.out.println("TimingLog created publicMsgWriter " + outputStreamWriter4 + " file:" + file2);
            this.f41474t = outputStreamWriter2;
            this.f41475u = outputStreamWriter4;
        } catch (Exception e14) {
            outputStreamWriter3 = outputStreamWriter2;
            Exception exc = e14;
            outputStreamWriter = outputStreamWriter4;
            e11 = exc;
            bo.j(f41456c, "msgWriter error: ", e11);
            this.f41474t = outputStreamWriter3;
            this.f41475u = outputStreamWriter;
        } catch (Throwable th5) {
            outputStreamWriter3 = outputStreamWriter2;
            Throwable th6 = th5;
            outputStreamWriter = outputStreamWriter4;
            th = th6;
            this.f41474t = outputStreamWriter3;
            this.f41475u = outputStreamWriter;
            throw th;
        }
    }

    private c e() {
        c cVar;
        Long valueOf = Long.valueOf(Thread.currentThread().getId());
        synchronized (this.f41471q) {
            cVar = (c) this.f41471q.get(valueOf);
            if (cVar == null) {
                cVar = new c(valueOf.longValue(), Thread.currentThread().getName());
                this.f41471q.put(valueOf, cVar);
            }
        }
        return cVar;
    }

    private void f() {
        if (!this.f41476v) {
            this.f41477w.postDelayed(new fi() {
                public void run() {
                    if (bs.this.f41474t != null) {
                        synchronized (bs.this.f41474t) {
                            try {
                                bs.this.f41474t.flush();
                            } catch (Exception e11) {
                                bo.e(bs.f41456c, "msgWriter exception", e11);
                            }
                        }
                    }
                    if (bs.this.f41475u != null) {
                        synchronized (bs.this.f41475u) {
                            try {
                                bs.this.f41475u.flush();
                            } catch (Exception e12) {
                                bo.e(bs.f41456c, "publicMsgWriter exception", e12);
                            }
                        }
                    }
                    boolean unused = bs.this.f41476v = false;
                }
            }, 5000);
            this.f41476v = true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00b4, code lost:
        r6 = "unknown";
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String d(java.lang.Object r9) {
        /*
            java.lang.String r0 = "."
            java.lang.String r1 = "unknown"
            j$.util.concurrent.ConcurrentHashMap<java.lang.Class<?>, java.lang.String> r2 = f41470x
            java.lang.String r3 = ""
            if (r2 != 0) goto L_0x000b
            return r3
        L_0x000b:
            java.lang.Class r4 = r9.getClass()
            java.lang.Object r2 = r2.get(r4)
            java.lang.String r2 = (java.lang.String) r2
            if (r2 != 0) goto L_0x00c0
            java.lang.Thread r2 = java.lang.Thread.currentThread()     // Catch:{ Exception -> 0x00c1 }
            java.lang.StackTraceElement[] r2 = r2.getStackTrace()     // Catch:{ Exception -> 0x00c1 }
            r4 = 0
        L_0x0020:
            int r5 = r2.length     // Catch:{ Exception -> 0x00c1 }
            if (r4 >= r5) goto L_0x00b4
            r5 = r2[r4]     // Catch:{ Exception -> 0x00c1 }
            java.lang.String r5 = r5.getFileName()     // Catch:{ Exception -> 0x00c1 }
            java.lang.String r6 = "TimingLog.java"
            boolean r5 = r5.equals(r6)     // Catch:{ Exception -> 0x00c1 }
            if (r5 == 0) goto L_0x00b0
            int r5 = r4 + 2
            int r6 = r2.length     // Catch:{ Exception -> 0x00c1 }
            if (r5 >= r6) goto L_0x00b4
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00c1 }
            r6.<init>()     // Catch:{ Exception -> 0x00c1 }
            r7 = r2[r5]     // Catch:{ Exception -> 0x00c1 }
            java.lang.String r7 = r7.getFileName()     // Catch:{ Exception -> 0x00c1 }
            r6.append(r7)     // Catch:{ Exception -> 0x00c1 }
            java.lang.String r7 = ":"
            r6.append(r7)     // Catch:{ Exception -> 0x00c1 }
            r7 = r2[r5]     // Catch:{ Exception -> 0x00c1 }
            int r7 = r7.getLineNumber()     // Catch:{ Exception -> 0x00c1 }
            r6.append(r7)     // Catch:{ Exception -> 0x00c1 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x00c1 }
            r5 = r2[r5]     // Catch:{ Exception -> 0x00c1 }
            java.lang.String r5 = r5.getFileName()     // Catch:{ Exception -> 0x00c1 }
            int r4 = r4 + 3
        L_0x005e:
            int r7 = r2.length     // Catch:{ Exception -> 0x00c1 }
            if (r4 >= r7) goto L_0x00b5
            r7 = r2[r4]     // Catch:{ Exception -> 0x00c1 }
            java.lang.String r7 = r7.getFileName()     // Catch:{ Exception -> 0x00c1 }
            boolean r7 = com.apptimize.fx.a((java.lang.Object) r5, (java.lang.Object) r7)     // Catch:{ Exception -> 0x00c1 }
            if (r7 != 0) goto L_0x006e
            goto L_0x00ad
        L_0x006e:
            r7 = r2[r4]     // Catch:{ Exception -> 0x00c1 }
            java.lang.String r7 = r7.getClassName()     // Catch:{ Exception -> 0x00c1 }
            if (r7 == 0) goto L_0x00ad
            boolean r8 = c((java.lang.String) r7)     // Catch:{ Exception -> 0x00c1 }
            if (r8 != 0) goto L_0x00ad
            int r5 = r7.lastIndexOf(r0)     // Catch:{ Exception -> 0x00c1 }
            r8 = -1
            if (r5 == r8) goto L_0x0089
            int r5 = r5 + 1
            java.lang.String r7 = r7.substring(r5)     // Catch:{ Exception -> 0x00c1 }
        L_0x0089:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00c1 }
            r5.<init>()     // Catch:{ Exception -> 0x00c1 }
            r5.append(r3)     // Catch:{ Exception -> 0x00c1 }
            r5.append(r7)     // Catch:{ Exception -> 0x00c1 }
            r5.append(r0)     // Catch:{ Exception -> 0x00c1 }
            r0 = r2[r4]     // Catch:{ Exception -> 0x00c1 }
            java.lang.String r0 = r0.getMethodName()     // Catch:{ Exception -> 0x00c1 }
            r5.append(r0)     // Catch:{ Exception -> 0x00c1 }
            java.lang.String r0 = "-"
            r5.append(r0)     // Catch:{ Exception -> 0x00c1 }
            r5.append(r6)     // Catch:{ Exception -> 0x00c1 }
            java.lang.String r6 = r5.toString()     // Catch:{ Exception -> 0x00c1 }
            goto L_0x00b5
        L_0x00ad:
            int r4 = r4 + 1
            goto L_0x005e
        L_0x00b0:
            int r4 = r4 + 1
            goto L_0x0020
        L_0x00b4:
            r6 = r1
        L_0x00b5:
            j$.util.concurrent.ConcurrentHashMap<java.lang.Class<?>, java.lang.String> r0 = f41470x     // Catch:{ Exception -> 0x00c1 }
            java.lang.Class r9 = r9.getClass()     // Catch:{ Exception -> 0x00c1 }
            r0.put(r9, r6)     // Catch:{ Exception -> 0x00c1 }
            r1 = r6
            goto L_0x00c1
        L_0x00c0:
            r1 = r2
        L_0x00c1:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.bs.d(java.lang.Object):java.lang.String");
    }

    public void c(Object obj) {
        try {
            if (!av.f41242e) {
                return;
            }
            if (!f41460g) {
                a(b.RUN_LOCKED_ON_MAIN_THREAD_SYNCHRONOUS, e(obj));
            }
        } catch (Exception e11) {
            a(e11);
        }
    }

    public static bs a(Context context) {
        if (f41459f == null) {
            f41459f = new bs(context, av.f41242e);
        }
        return f41459f;
    }

    public void b(Object obj) {
        try {
            if (!av.f41242e) {
                return;
            }
            if (!f41460g) {
                a(b.RUN_LOCKED, e(obj));
            }
        } catch (Exception e11) {
            a(e11);
        }
    }

    private static boolean c(String str) {
        int indexOf;
        int i11 = 0;
        while (i11 < str.length() && (indexOf = str.indexOf("$", i11)) >= 0 && indexOf != str.length() - 1) {
            i11 = indexOf + 1;
            if (str.charAt(i11) >= '0' && str.charAt(i11) <= '9') {
                return true;
            }
        }
        return false;
    }

    public static void b(String str) {
        bs bsVar = f41454a;
        if (bsVar != null) {
            bsVar.a(str, false);
        }
    }

    public void a(Method method, int i11) {
        try {
            if (av.f41242e && !f41460g && method != null) {
                if (b(method)) {
                    a(b.INTERCEPTED, a(method));
                }
            }
        } catch (Exception e11) {
            a(e11);
        }
    }

    private String e(Object obj) {
        try {
            if (obj instanceof fi) {
                return ((fi) obj).a();
            }
            if (obj instanceof fk) {
                return ((fk) obj).c();
            }
            if (obj instanceof fj) {
                return ((fj) obj).a();
            }
            return obj.getClass().getMethod("run", new Class[0]).toString();
        } catch (Exception unused) {
            return "unknown";
        }
    }

    private boolean b(Method method) {
        Long l11;
        synchronized (this.f41473s) {
            l11 = this.f41473s.get(method);
            if (l11 == null) {
                String name2 = method.getName();
                l11 = Long.valueOf((fx.a((Object) f41461h, (Object) name2) || fx.a((Object) f41462i, (Object) name2) || fx.a((Object) f41463j, (Object) name2) || fx.a((Object) f41464k, (Object) name2)) ? 0 : 1);
                this.f41473s.put(method, l11);
            }
        }
        return l11.longValue() == 1;
    }

    public void a(Object obj) {
        try {
            if (!av.f41242e) {
                return;
            }
            if (!f41460g) {
                a(b.EXCEPTION_HANDLER, e(obj));
            }
        } catch (Exception e11) {
            a(e11);
        }
    }

    public void a(fj fjVar) {
        try {
            if (!av.f41242e) {
                return;
            }
            if (!f41460g) {
                a(b.UI_TASK, e(fjVar));
            }
        } catch (Exception e11) {
            a(e11);
        }
    }

    public static void a(String str) {
        bs bsVar = f41454a;
        if (bsVar != null) {
            bsVar.a(str, true);
        }
    }

    public static void a(String str, Object obj) {
        bs bsVar = f41454a;
        if (bsVar != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(obj == null ? "null" : obj.toString());
            bsVar.a(sb2.toString(), false);
        }
    }

    public static void a(String str, Object obj, Object obj2) {
        if (f41454a != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(obj == null ? "null" : obj.toString());
            sb2.append("--");
            a(sb2.toString(), obj2);
        }
    }

    private void a(String str, boolean z11) {
        OutputStreamWriter outputStreamWriter = z11 ? this.f41475u : this.f41474t;
        if (outputStreamWriter != null) {
            c e11 = e();
            synchronized (outputStreamWriter) {
                try {
                    String str2 = e11.f41491b + SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE + e11.f41490a + CertificateUtil.DELIMITER + e11.f41492c + " " + ((System.nanoTime() - this.f41478y) / 1000) + "us 0us message:" + str;
                    outputStreamWriter.write(str2 + StringUtils.LF);
                    if (z11) {
                        bo.i(f41456c, "TimingLog: " + str2);
                    }
                    f();
                } catch (Exception e12) {
                    bo.e(f41456c, "msgWriter exception", e12);
                }
            }
        }
    }

    private void a(b bVar, String str) {
        c e11 = e();
        int i11 = e11.f41493d;
        if (i11 > 0) {
            e11.f41493d = i11 + 1;
            return;
        }
        a(e11, bVar, str, System.nanoTime());
    }

    public void a() {
        try {
            if (!av.f41242e) {
                return;
            }
            if (!f41460g) {
                c e11 = e();
                int i11 = e11.f41493d;
                if (i11 > 0) {
                    e11.f41493d = i11 - 1;
                    return;
                }
                int i12 = e11.f41492c;
                if (i12 > 0) {
                    int i13 = i12 - 1;
                    e11.f41492c = i13;
                    if (i13 < f41457d) {
                        long j11 = e11.f41494e[i13].f41482c;
                        long nanoTime = System.nanoTime();
                        a aVar = e11.f41494e[i13];
                        a(e11.f41491b, e11.f41490a, aVar.f41480a, aVar.f41481b, i13, j11, nanoTime - aVar.f41482c);
                    }
                }
            }
        } catch (Exception e12) {
            a(e12);
        }
    }

    private void a(c cVar, b bVar, String str, long j11) {
        c cVar2 = cVar;
        int i11 = cVar2.f41492c;
        if (i11 < f41457d) {
            a[] aVarArr = cVar2.f41494e;
            if (aVarArr[i11] == null) {
                aVarArr[i11] = new a();
            }
            a aVar = cVar2.f41494e[i11];
            aVar.f41480a = bVar;
            aVar.f41481b = str;
            aVar.f41482c = j11;
        } else {
            a(cVar2.f41491b, cVar2.f41490a, bVar, str, i11, System.nanoTime(), -1);
        }
        cVar2.f41492c++;
    }

    private String a(Method method) {
        String str;
        synchronized (this.f41472r) {
            str = this.f41472r.get(method);
            if (str == null) {
                str = method.toString();
                this.f41472r.put(method, str);
            }
        }
        return str;
    }

    private void a(String str, long j11, b bVar, String str2, int i11, long j12, long j13) {
        String str3;
        OutputStreamWriter outputStreamWriter = this.f41474t;
        if (outputStreamWriter != null) {
            synchronized (outputStreamWriter) {
                try {
                    if (bVar == b.INTERCEPTED) {
                        str3 = f41465l;
                    } else if (bVar == b.EXCEPTION_HANDLER) {
                        str3 = f41466m;
                    } else if (bVar == b.RUN_LOCKED) {
                        str3 = f41467n;
                    } else if (bVar == b.RUN_LOCKED_ON_MAIN_THREAD_SYNCHRONOUS) {
                        str3 = f41468o;
                    } else {
                        str3 = bVar == b.UI_TASK ? f41469p : "unknown";
                    }
                    OutputStreamWriter outputStreamWriter2 = this.f41474t;
                    outputStreamWriter2.write(str + SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE + j11 + CertificateUtil.DELIMITER + i11 + " " + ((j12 - this.f41478y) / 1000) + "us " + (j13 / 1000) + "us " + str3 + " " + str2 + StringUtils.LF);
                    f();
                } catch (Exception e11) {
                    bo.e(f41456c, "msgWriter exception", e11);
                }
            }
        }
    }

    private void a(Exception exc) {
        f41460g = true;
        try {
            OutputStreamWriter outputStreamWriter = this.f41474t;
            if (outputStreamWriter != null) {
                synchronized (outputStreamWriter) {
                    try {
                        OutputStreamWriter outputStreamWriter2 = this.f41474t;
                        outputStreamWriter2.write("Exception:" + exc.getMessage() + " " + bo.a((Throwable) exc) + StringUtils.LF);
                        this.f41474t.flush();
                    } catch (Exception e11) {
                        bo.e(f41456c, "msgWriter exception", e11);
                    }
                }
            }
            bo.e(f41456c, "logException", exc);
        } catch (Exception unused) {
        }
    }
}
