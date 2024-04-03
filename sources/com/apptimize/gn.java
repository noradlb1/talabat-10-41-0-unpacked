package com.apptimize;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import com.adjust.sdk.Constants;
import com.apptimize.bq;
import com.facebook.internal.security.CertificateUtil;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import com.tekartik.sqflite.Constant;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import tracking.gtm.TalabatGTM;

public class gn {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicInteger f42636a = new AtomicInteger(0);

    /* renamed from: b  reason: collision with root package name */
    public static String f42637b = null;

    /* renamed from: c  reason: collision with root package name */
    private static String f42638c = null;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f42639d = false;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f42640e = false;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f42641f = false;

    /* renamed from: g  reason: collision with root package name */
    private static boolean f42642g = true;

    /* renamed from: h  reason: collision with root package name */
    private static boolean f42643h = true;

    /* renamed from: i  reason: collision with root package name */
    private static volatile boolean f42644i = false;

    /* renamed from: j  reason: collision with root package name */
    private static final fu f42645j = new fu();

    /* renamed from: k  reason: collision with root package name */
    private static Map<Method, CopyOnWriteArrayList<gk>> f42646k = new HashMap();

    /* renamed from: l  reason: collision with root package name */
    private static Map<Method, gl> f42647l = new HashMap();

    /* renamed from: m  reason: collision with root package name */
    private static Class<?> f42648m = null;

    /* renamed from: n  reason: collision with root package name */
    private static gm f42649n;

    /* renamed from: o  reason: collision with root package name */
    private static boolean f42650o = false;

    /* renamed from: p  reason: collision with root package name */
    private static boolean f42651p = false;

    /* renamed from: q  reason: collision with root package name */
    private static Method f42652q = null;

    /* renamed from: r  reason: collision with root package name */
    private static boolean f42653r = false;

    /* renamed from: s  reason: collision with root package name */
    private static boolean f42654s = false;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public static boolean f42655t = false;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public static boolean f42656u = false;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public static boolean f42657v = false;

    public static class a {
        @SuppressLint({"NewApi"})
        public static StrictMode.ThreadPolicy a() {
            return new StrictMode.ThreadPolicy.Builder().permitUnbufferedIo().build();
        }
    }

    public enum b {
        MODE_1(1),
        MODE_2(2),
        MODE_3(3);
        

        /* renamed from: d  reason: collision with root package name */
        public static final b f42666d = null;

        /* renamed from: e  reason: collision with root package name */
        public static final b f42667e = null;

        /* renamed from: f  reason: collision with root package name */
        public static final b f42668f = null;

        /* renamed from: g  reason: collision with root package name */
        private int f42670g;

        /* access modifiers changed from: public */
        static {
            b bVar;
            b bVar2;
            b bVar3;
            f42666d = bVar;
            f42667e = bVar2;
            f42668f = bVar3;
        }

        private b(int i11) {
            this.f42670g = i11;
        }

        public int a() {
            return this.f42670g;
        }
    }

    public static class c {
        static {
            boolean unused = gn.f42655t = false;
            boolean unused2 = gn.f42656u = false;
        }

        private c() {
        }

        /* access modifiers changed from: private */
        public static void b(String str) {
            gn.B();
            boolean unused = gn.f42656u = true;
        }
    }

    static {
        String str;
        if (u()) {
            str = "nativeGetStackTrace";
        } else {
            str = "getOurStackTrace";
        }
        f42637b = str;
    }

    private static void A() {
        try {
            Class.forName("android.support.v4.app.Fragment");
            Class.forName("android.support.v4.app.FragmentPagerAdapter");
            Class.forName("android.support.v4.app.FragmentStatePagerAdapter");
            Class.forName("android.support.v4.view.ViewPager");
            Class.forName("android.support.v7.app.Fragment");
            Class.forName("android.support.v7.app.FragmentPagerAdapter");
            Class.forName("android.support.v7.app.FragmentStatePagerAdapter");
            Class.forName("android.support.v7.view.ViewPager");
            Class.forName("android.support.v7.widget");
            Class.forName("android.support.v7.widget.CardView");
            Class.forName("android.support.v7.widget.RecyclerView");
            Class.forName("android.support.v13.app.FragmentPagerAdapter");
            Class.forName("android.support.v13.app.FragmentStatePagerAdapter");
            Class.forName("com.adobe.adms.measurement.ADMS_Measurement");
            Class.forName("com.adobe.mobile.Analytics");
            Class.forName("com.adobe.mobile.Config");
            Class.forName("com.amplitude.api.AmplitudeClient");
            Class.forName("com.amplitude.api.Revenue");
            Class.forName("com.amplitude.api.Identify");
            Class.forName("com.google.analytics.tracking.android.Tracker");
            Class.forName("android.os.Bundle");
            Class.forName("com.crashlytics");
            Class.forName("com.flurry.android.FlurryAgent");
            Class.forName("com.localytics.android.Localytics");
            Class.forName("com.localytics.androidx.Localytics");
            Class.forName("com.mixpanel.android.mpmetrics.MixpanelAPI");
            Class.forName("com.omniture.AppMeasurementBase");
            Class.forName("com.segment.analytics");
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public static void B() {
        try {
            if (!a(b.f42668f)) {
                throw new Exception();
            }
        } catch (Exception unused) {
            if (k()) {
                Runtime.getRuntime().gc();
            }
            f42655t = false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00e9, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0049, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        com.apptimize.bo.h("VisualChanges", "visualChangesForThis reflection failed ", r1);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00e9 A[ExcHandler: AssertionError (e java.lang.AssertionError), Splitter:B:1:0x0010] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean C() {
        /*
            java.lang.Class<java.util.GregorianCalendar> r0 = java.util.GregorianCalendar.class
            java.lang.String r1 = "hello"
            java.lang.Class<java.lang.String> r2 = java.lang.String.class
            java.lang.String r3 = "b"
            java.lang.Class<com.apptimize.gn$c> r4 = com.apptimize.gn.c.class
            java.lang.String r5 = " "
            java.lang.String r6 = "VisualChanges"
            r7 = 0
            r8 = 1
            java.lang.Class[] r9 = new java.lang.Class[r8]     // Catch:{ AssertionError -> 0x00e9, NoSuchMethodException -> 0x00e7 }
            r9[r7] = r2     // Catch:{ AssertionError -> 0x00e9, NoSuchMethodException -> 0x00e7 }
            java.lang.reflect.Method r9 = r4.getDeclaredMethod(r3, r9)     // Catch:{ AssertionError -> 0x00e9, NoSuchMethodException -> 0x00e7 }
            com.apptimize.gn$1 r10 = new com.apptimize.gn$1     // Catch:{ AssertionError -> 0x00e9, NoSuchMethodException -> 0x00e7 }
            r10.<init>()     // Catch:{ AssertionError -> 0x00e9, NoSuchMethodException -> 0x00e7 }
            a((java.lang.reflect.Method) r9, (com.apptimize.gk) r10, (int) r8, (boolean) r7)     // Catch:{ AssertionError -> 0x00e9, NoSuchMethodException -> 0x00e7 }
            java.util.concurrent.atomic.AtomicInteger r9 = f42636a     // Catch:{ AssertionError -> 0x00e9, NoSuchMethodException -> 0x00e7 }
            int r10 = r9.get()     // Catch:{ AssertionError -> 0x00e9, NoSuchMethodException -> 0x00e7 }
            com.apptimize.gn.c.b(r1)     // Catch:{ AssertionError -> 0x00e9, NoSuchMethodException -> 0x00e7 }
            int r9 = r9.get()     // Catch:{ AssertionError -> 0x00e9, NoSuchMethodException -> 0x00e7 }
            if (r10 != r9) goto L_0x0050
            java.lang.Class[] r9 = new java.lang.Class[r8]     // Catch:{ Exception -> 0x0049, AssertionError -> 0x00e9 }
            r9[r7] = r2     // Catch:{ Exception -> 0x0049, AssertionError -> 0x00e9 }
            java.lang.reflect.Method r2 = r4.getDeclaredMethod(r3, r9)     // Catch:{ Exception -> 0x0049, AssertionError -> 0x00e9 }
            r2.setAccessible(r8)     // Catch:{ Exception -> 0x0049, AssertionError -> 0x00e9 }
            java.lang.Object[] r3 = new java.lang.Object[r8]     // Catch:{ Exception -> 0x0049, AssertionError -> 0x00e9 }
            r3[r7] = r1     // Catch:{ Exception -> 0x0049, AssertionError -> 0x00e9 }
            r1 = 0
            r2.invoke(r1, r3)     // Catch:{ Exception -> 0x0049, AssertionError -> 0x00e9 }
            java.lang.String r1 = "visualChangesForThis used reflection"
            com.apptimize.bo.k(r6, r1)     // Catch:{ Exception -> 0x0049, AssertionError -> 0x00e9 }
            goto L_0x0050
        L_0x0049:
            r1 = move-exception
            java.lang.String r2 = "visualChangesForThis reflection failed "
            com.apptimize.bo.h(r6, r2, r1)     // Catch:{ AssertionError -> 0x00e9, NoSuchMethodException -> 0x00e7 }
        L_0x0050:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ AssertionError -> 0x00e9, NoSuchMethodException -> 0x00e7 }
            r1.<init>()     // Catch:{ AssertionError -> 0x00e9, NoSuchMethodException -> 0x00e7 }
            java.lang.String r2 = "Apptimize check1 "
            r1.append(r2)     // Catch:{ AssertionError -> 0x00e9, NoSuchMethodException -> 0x00e7 }
            java.util.concurrent.atomic.AtomicInteger r2 = f42636a     // Catch:{ AssertionError -> 0x00e9, NoSuchMethodException -> 0x00e7 }
            int r2 = r2.get()     // Catch:{ AssertionError -> 0x00e9, NoSuchMethodException -> 0x00e7 }
            r1.append(r2)     // Catch:{ AssertionError -> 0x00e9, NoSuchMethodException -> 0x00e7 }
            r1.append(r5)     // Catch:{ AssertionError -> 0x00e9, NoSuchMethodException -> 0x00e7 }
            boolean r2 = f42656u     // Catch:{ AssertionError -> 0x00e9, NoSuchMethodException -> 0x00e7 }
            r1.append(r2)     // Catch:{ AssertionError -> 0x00e9, NoSuchMethodException -> 0x00e7 }
            r1.append(r5)     // Catch:{ AssertionError -> 0x00e9, NoSuchMethodException -> 0x00e7 }
            boolean r2 = f42655t     // Catch:{ AssertionError -> 0x00e9, NoSuchMethodException -> 0x00e7 }
            r1.append(r2)     // Catch:{ AssertionError -> 0x00e9, NoSuchMethodException -> 0x00e7 }
            java.lang.String r1 = r1.toString()     // Catch:{ AssertionError -> 0x00e9, NoSuchMethodException -> 0x00e7 }
            com.apptimize.bo.k(r6, r1)     // Catch:{ AssertionError -> 0x00e9, NoSuchMethodException -> 0x00e7 }
            java.lang.String r1 = "internalGetEra"
            java.lang.Class[] r2 = new java.lang.Class[r7]     // Catch:{ AssertionError -> 0x00e9, NoSuchMethodException -> 0x00e7 }
            java.lang.reflect.Method r1 = r0.getDeclaredMethod(r1, r2)     // Catch:{ AssertionError -> 0x00e9, NoSuchMethodException -> 0x00e7 }
            java.lang.String r2 = "getWeekYear"
            java.lang.Class[] r3 = new java.lang.Class[r7]     // Catch:{ AssertionError -> 0x00e9, NoSuchMethodException -> 0x00e7 }
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r2, r3)     // Catch:{ AssertionError -> 0x00e9, NoSuchMethodException -> 0x00e7 }
            if (r1 == 0) goto L_0x00b5
            if (r0 == 0) goto L_0x00b5
            com.apptimize.gn$2 r2 = new com.apptimize.gn$2     // Catch:{ AssertionError -> 0x00e9, NoSuchMethodException -> 0x00e7 }
            r2.<init>()     // Catch:{ AssertionError -> 0x00e9, NoSuchMethodException -> 0x00e7 }
            a((java.lang.reflect.Method) r1, (com.apptimize.gk) r2, (int) r7, (boolean) r7)     // Catch:{ AssertionError -> 0x00e9, NoSuchMethodException -> 0x00e7 }
            boolean r2 = r1.isAccessible()     // Catch:{ Exception -> 0x00d9, AssertionError -> 0x00e9 }
            boolean r3 = r0.isAccessible()     // Catch:{ Exception -> 0x00d9, AssertionError -> 0x00e9 }
            r1.setAccessible(r8)     // Catch:{ Exception -> 0x00d9, AssertionError -> 0x00e9 }
            r0.setAccessible(r8)     // Catch:{ Exception -> 0x00d9, AssertionError -> 0x00e9 }
            java.util.GregorianCalendar r4 = new java.util.GregorianCalendar     // Catch:{ Exception -> 0x00d9, AssertionError -> 0x00e9 }
            r4.<init>()     // Catch:{ Exception -> 0x00d9, AssertionError -> 0x00e9 }
            java.lang.Object[] r5 = new java.lang.Object[r7]     // Catch:{ Exception -> 0x00d9, AssertionError -> 0x00e9 }
            r0.invoke(r4, r5)     // Catch:{ Exception -> 0x00d9, AssertionError -> 0x00e9 }
            r0.setAccessible(r3)     // Catch:{ Exception -> 0x00d9, AssertionError -> 0x00e9 }
            r1.setAccessible(r2)     // Catch:{ Exception -> 0x00d9, AssertionError -> 0x00e9 }
            goto L_0x00d9
        L_0x00b5:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ AssertionError -> 0x00e9, NoSuchMethodException -> 0x00e7 }
            r2.<init>()     // Catch:{ AssertionError -> 0x00e9, NoSuchMethodException -> 0x00e7 }
            java.lang.String r3 = "Apptimize check2 "
            r2.append(r3)     // Catch:{ AssertionError -> 0x00e9, NoSuchMethodException -> 0x00e7 }
            if (r1 == 0) goto L_0x00c3
            r1 = r8
            goto L_0x00c4
        L_0x00c3:
            r1 = r7
        L_0x00c4:
            r2.append(r1)     // Catch:{ AssertionError -> 0x00e9, NoSuchMethodException -> 0x00e7 }
            r2.append(r5)     // Catch:{ AssertionError -> 0x00e9, NoSuchMethodException -> 0x00e7 }
            if (r0 == 0) goto L_0x00ce
            r0 = r8
            goto L_0x00cf
        L_0x00ce:
            r0 = r7
        L_0x00cf:
            r2.append(r0)     // Catch:{ AssertionError -> 0x00e9, NoSuchMethodException -> 0x00e7 }
            java.lang.String r0 = r2.toString()     // Catch:{ AssertionError -> 0x00e9, NoSuchMethodException -> 0x00e7 }
            com.apptimize.bo.k(r6, r0)     // Catch:{ AssertionError -> 0x00e9, NoSuchMethodException -> 0x00e7 }
        L_0x00d9:
            boolean r0 = f42655t     // Catch:{ AssertionError -> 0x00e9, NoSuchMethodException -> 0x00e7 }
            if (r0 == 0) goto L_0x00e6
            boolean r0 = f42656u     // Catch:{ AssertionError -> 0x00e9, NoSuchMethodException -> 0x00e7 }
            if (r0 == 0) goto L_0x00e6
            boolean r0 = f42657v     // Catch:{ AssertionError -> 0x00e9, NoSuchMethodException -> 0x00e7 }
            if (r0 == 0) goto L_0x00e6
            r7 = r8
        L_0x00e6:
            return r7
        L_0x00e7:
            r0 = move-exception
            goto L_0x00ea
        L_0x00e9:
            r0 = move-exception
        L_0x00ea:
            java.lang.String r1 = "Apptimize failed AN2006"
            com.apptimize.bo.h(r6, r1, r0)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.gn.C():boolean");
    }

    public static void a(boolean z11) {
        f42642g = z11;
        if (!z11) {
            bo.h("VisualChanges", "ApptimizeOptions visual changes are disabled");
        }
    }

    public static void f() {
        f42644i = true;
    }

    public static void g() {
        f42644i = false;
    }

    public static boolean h() {
        return f42645j.c() > 0;
    }

    public static synchronized String i() {
        String str;
        synchronized (gn.class) {
            str = f42638c;
        }
        return str;
    }

    public static synchronized Method j() throws NoSuchMethodException {
        Method method;
        Method method2;
        synchronized (gn.class) {
            if (f42652q == null) {
                if (u()) {
                    method2 = Throwable.class.getDeclaredMethod(f42637b, new Class[]{Object.class});
                } else {
                    method2 = Throwable.class.getDeclaredMethod(f42637b, new Class[0]);
                }
                f42652q = method2;
            }
            method = f42652q;
        }
        return method;
    }

    public static boolean k() {
        return true;
    }

    public static boolean l() {
        String lowerCase = Build.MANUFACTURER.toLowerCase();
        if (!lowerCase.equals(Constants.REFERRER_API_SAMSUNG) && !lowerCase.equals("lge")) {
            return false;
        }
        String lowerCase2 = Build.MODEL.toLowerCase();
        if (",lg-h931,lg-h932,lg-h933,lg-us998,samsung-sm-g930a,samsung-sm-g930az,samsung-sm-g935a,sm-g570m,sm-g570y,sm-g930f,sm-g930p,sm-g930r4,sm-g930r6,sm-g930r7,sm-g930t,sm-g930t1,sm-g930u,sm-g930vl,sm-g930w8,sm-g935p,sm-g935r4,sm-g935t,sm-g935u,sm-g935vc,sm-j500m,vs996,".indexOf("," + lowerCase2 + ",") >= 0) {
            return true;
        }
        return false;
    }

    public static boolean m() {
        int i11 = Build.VERSION.SDK_INT;
        return i11 >= 24 && i11 <= 32;
    }

    public static boolean n() {
        int i11 = Build.VERSION.SDK_INT;
        return i11 == 24 || i11 == 25;
    }

    public static boolean o() {
        return Build.VERSION.SDK_INT >= 24;
    }

    public static boolean p() {
        int i11 = Build.VERSION.SDK_INT;
        return i11 == 26 || i11 == 27;
    }

    public static boolean q() {
        return Build.VERSION.SDK_INT == 28;
    }

    public static boolean r() {
        return Build.VERSION.SDK_INT >= 28;
    }

    public static boolean s() {
        return Build.VERSION.SDK_INT == 29;
    }

    public static boolean t() {
        return Build.VERSION.SDK_INT == 30;
    }

    public static boolean u() {
        return Build.VERSION.SDK_INT >= 31;
    }

    public static String v() {
        return "libcrashreport.so";
    }

    public static boolean w() {
        gm gmVar;
        if (!f42650o || (gmVar = f42649n) == null) {
            return false;
        }
        return gmVar.a();
    }

    public static void x() {
        gm gmVar = f42649n;
        if (gmVar != null) {
            gmVar.b();
        }
    }

    private static boolean z() {
        return false;
    }

    private static boolean b(b bVar) {
        return (bVar.a() & b.f42666d.a()) != 0;
    }

    private static boolean c(b bVar) {
        return (bVar.a() & b.f42667e.a()) != 0;
    }

    public static synchronized boolean d() {
        boolean z11;
        synchronized (gn.class) {
            z11 = f42642g || f42643h;
        }
        return z11;
    }

    public static boolean e() {
        return f42641f;
    }

    public static void a() {
        f42639d = true;
    }

    public static void b(boolean z11) {
        f42643h = z11;
        if (!z11) {
            bo.h("VisualChanges", "ApptimizeOptions third-party event importing is disabled");
        }
    }

    public static synchronized boolean c() {
        boolean z11;
        synchronized (gn.class) {
            z11 = f42639d && !f42640e;
        }
        return z11;
    }

    public static synchronized void d(Method method, gk gkVar, b bVar) {
        synchronized (gn.class) {
            if (!f42646k.containsKey(method)) {
                b(method, gkVar, bVar);
            }
        }
    }

    public static synchronized boolean a(b bVar) {
        boolean z11;
        synchronized (gn.class) {
            z11 = f42640e && ((b(bVar) && f42642g) || (c(bVar) && f42643h));
        }
        return z11;
    }

    public static synchronized void c(Method method, gk gkVar, b bVar) {
        synchronized (gn.class) {
            if (!f42646k.containsKey(method)) {
                a(method, gkVar, bVar);
            }
        }
    }

    public static synchronized String b() {
        String str;
        synchronized (gn.class) {
            if (!f42639d) {
                str = "pending";
            } else {
                boolean z11 = f42642g;
                if (!z11 && !f42643h) {
                    str = "none";
                } else if (!f42640e) {
                    str = TalabatGTM.FAILED;
                } else {
                    str = (!z11 || !f42643h) ? z11 ? "visual" : "import" : TtmlNode.COMBINE_ALL;
                }
            }
        }
        return str;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0042, code lost:
        if (r3 != null) goto L_0x0067;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x006a, code lost:
        return r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object c(java.lang.Object r3, java.lang.reflect.Method r4, java.lang.Object r5, java.lang.Object[] r6) {
        /*
            com.apptimize.bs r0 = com.apptimize.bs.f41454a
            if (r0 == 0) goto L_0x0008
            int r1 = r6.length
            r0.a((java.lang.reflect.Method) r4, (int) r1)
        L_0x0008:
            java.lang.Class<com.apptimize.gn> r0 = com.apptimize.gn.class
            monitor-enter(r0)     // Catch:{ all -> 0x0048 }
            java.util.Map<java.lang.reflect.Method, com.apptimize.gl> r1 = f42647l     // Catch:{ all -> 0x0045 }
            java.lang.Object r1 = r1.get(r4)     // Catch:{ all -> 0x0045 }
            com.apptimize.gl r1 = (com.apptimize.gl) r1     // Catch:{ all -> 0x0045 }
            java.util.Map<java.lang.reflect.Method, java.util.concurrent.CopyOnWriteArrayList<com.apptimize.gk>> r2 = f42646k     // Catch:{ all -> 0x0045 }
            java.lang.Object r2 = r2.get(r4)     // Catch:{ all -> 0x0045 }
            java.util.concurrent.CopyOnWriteArrayList r2 = (java.util.concurrent.CopyOnWriteArrayList) r2     // Catch:{ all -> 0x0045 }
            monitor-exit(r0)     // Catch:{ all -> 0x0045 }
            if (r1 == 0) goto L_0x002a
            java.lang.Object r3 = r1.a(r4, r3, r5)     // Catch:{ all -> 0x0048 }
            com.apptimize.bs r4 = com.apptimize.bs.f41454a
            if (r4 == 0) goto L_0x0029
            r4.a()
        L_0x0029:
            return r3
        L_0x002a:
            if (r2 == 0) goto L_0x0040
            java.util.Iterator r0 = r2.iterator()     // Catch:{ all -> 0x0048 }
        L_0x0030:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x0048 }
            if (r1 == 0) goto L_0x0040
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x0048 }
            com.apptimize.gk r1 = (com.apptimize.gk) r1     // Catch:{ all -> 0x0048 }
            r1.a(r4, r3, r6, r5)     // Catch:{ all -> 0x0048 }
            goto L_0x0030
        L_0x0040:
            com.apptimize.bs r3 = com.apptimize.bs.f41454a
            if (r3 == 0) goto L_0x006a
            goto L_0x0067
        L_0x0045:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0045 }
            throw r3     // Catch:{ all -> 0x0048 }
        L_0x0048:
            r3 = move-exception
            java.lang.String r4 = "VisualChanges"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x006b }
            r6.<init>()     // Catch:{ all -> 0x006b }
            java.lang.String r0 = "doMethodInvoked exception "
            r6.append(r0)     // Catch:{ all -> 0x006b }
            java.lang.String r3 = android.util.Log.getStackTraceString(r3)     // Catch:{ all -> 0x006b }
            r6.append(r3)     // Catch:{ all -> 0x006b }
            java.lang.String r3 = r6.toString()     // Catch:{ all -> 0x006b }
            com.apptimize.bo.k(r4, r3)     // Catch:{ all -> 0x006b }
            com.apptimize.bs r3 = com.apptimize.bs.f41454a
            if (r3 == 0) goto L_0x006a
        L_0x0067:
            r3.a()
        L_0x006a:
            return r5
        L_0x006b:
            r3 = move-exception
            com.apptimize.bs r4 = com.apptimize.bs.f41454a
            if (r4 == 0) goto L_0x0073
            r4.a()
        L_0x0073:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.gn.c(java.lang.Object, java.lang.reflect.Method, java.lang.Object, java.lang.Object[]):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:226:0x0345, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:228:?, code lost:
        r11.a().a("VisualChanges", "AN1001-8", com.apptimize.fx.a((java.lang.Exception) r10));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:230:?, code lost:
        r2.delete();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:231:0x0356, code lost:
        android.os.StrictMode.setThreadPolicy(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:232:0x0359, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:233:0x035a, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:235:?, code lost:
        r11.a().a("VisualChanges", "AN1001-7", com.apptimize.fx.a((java.lang.Exception) r10));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:237:?, code lost:
        r2.delete();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:238:0x036b, code lost:
        android.os.StrictMode.setThreadPolicy(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:239:0x036e, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:240:0x036f, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:242:?, code lost:
        r11.a().a("VisualChanges", "Unexpected exception " + r10.getClass().getName() + " when writing data", com.apptimize.fx.a((java.lang.Exception) r10));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:244:?, code lost:
        r2.delete();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:245:0x039c, code lost:
        android.os.StrictMode.setThreadPolicy(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:246:0x039f, code lost:
        return false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:226:0x0345 A[ExcHandler: IllegalAccessException (r10v10 'e' java.lang.IllegalAccessException A[CUSTOM_DECLARE]), Splitter:B:198:0x02bb] */
    /* JADX WARNING: Removed duplicated region for block: B:233:0x035a A[ExcHandler: NoSuchMethodException (r10v8 'e' java.lang.NoSuchMethodException A[CUSTOM_DECLARE]), Splitter:B:198:0x02bb] */
    /* JADX WARNING: Removed duplicated region for block: B:240:0x036f A[ExcHandler: IOException (r10v6 'e' java.io.IOException A[CUSTOM_DECLARE]), Splitter:B:198:0x02bb] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(android.content.Context r10, com.apptimize.au r11, boolean r12) {
        /*
            boolean r0 = f42653r
            if (r0 == 0) goto L_0x0007
            boolean r10 = f42654s
            return r10
        L_0x0007:
            boolean r0 = m()
            r1 = 0
            if (r0 != 0) goto L_0x000f
            return r1
        L_0x000f:
            r0 = 1
            if (r12 != 0) goto L_0x001e
            boolean r2 = com.apptimize.t.d()
            if (r2 == 0) goto L_0x001e
            java.lang.String r10 = "AN1025"
            a((com.apptimize.au) r11, (boolean) r0, (java.lang.String) r10)
            return r1
        L_0x001e:
            if (r12 != 0) goto L_0x002d
            boolean r12 = k()
            if (r12 == 0) goto L_0x002d
            boolean r12 = b((com.apptimize.au) r11)
            if (r12 == 0) goto L_0x002d
            return r1
        L_0x002d:
            f42653r = r0
            boolean r12 = z()
            java.lang.String r2 = "Unsupported device detected; Apptimize visual functionality not initialized"
            java.lang.String r3 = "VisualChanges"
            if (r12 == 0) goto L_0x0059
            com.apptimize.bq r10 = r11.a()
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = android.os.Build.BRAND
            r11.append(r12)
            java.lang.String r12 = " - "
            r11.append(r12)
            java.lang.String r12 = android.os.Build.MODEL
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            r10.a(r3, r2, r11)
            return r1
        L_0x0059:
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            android.os.StrictMode$ThreadPolicy r5 = android.os.StrictMode.allowThreadDiskWrites()
            boolean r6 = k()     // Catch:{ all -> 0x03a4 }
            if (r6 == 0) goto L_0x0296
            java.lang.String r6 = "H4sIACqBfmMC/6WXa2xTZRjHn3Parj3d1nVlbDAGG9ch7AIMFAQBYQxOOXIZUuAguK7rRsfWjq7AQD5IAgkaYxajxkRMjMFrYoIfjJBgQoh8gw8aP6gxkRgTb8QYJeELRv/vc562Zx0aoz35vf//+7yX89562tOXHAsu6VhBfcPxqx+duXXn+Xd+vPrCW7FLLw+uvL5Sn3fFGyYaIaKx2PIIyWekiugUOfEK0KMTLYeO61T4rFeJj0hT6if6LkDUBL0DvQf+BLqBKsAAIdAMWsESsBysB51gM7DAbrAPHAQJkAIZkAMvgXfBx+BT8D34CfwCfgN3wT3gCRIFQQhEQB1oBM2gFSwDq8EmsBXsBPtADzgEMuAoOAVOg7PgHHgOjINXwHnwBngbvA8+AB+Ca+Am+Ar8AH4HVE5UCWaAVrAW7AAJcBw8C14FF8E18AX4GehY+HrQBjaAPWAYjIEzYBy8Bt4Dl8F18Bn4FvwK/gCVlUQNYBFYBbpANzgAUuA4OAvOgzfBZXATfAm+AbfBXaCFsKagHrSA9cACe0PO/qtj4QHYcpoKakEdmAbqyTk7a8AjUi9/jLzid/j5KLHfC18mvsfPR4v9OIwh7c/DB8Vf8PMSs7/id86rT/qvFK/6rBKv6oTFfwJfLf4GfET85/BTxN+CrxF/2+/MJyD9zxB/B/EG8WouM8Xfg58lXo2hUbxXfVfEh5HMFq/mNUe8Gudc8Wqc88Q3IJkvvgXJAvFrkDSLV3NZKH4LkgfyY0CySPwQksXi1XxbxI8haRV/Dkmb+BeRtIu/gGSJeLU+S8VfRLJM/G33XJB05OcScM6DIWu4QrxawwfFqzV8SPwN1F8pXq3PKvHqPKwWr8b/sPivUR/Hks+HeiZ5ebeVltFaOXPrWHV+hnlxPcoaoA2sBm1kLadO1kraxKpRl9TbzBqkLawVZLKGKMpaRVvJua/FWkuPsU6jbawzaDvrTNrBOot2sjZSN2sT7WKdTY+zzqXdrPMoJv3uYa2mvawR2sc6hWzWGtrPOpWekPseYJ1OB1nr6UnWBuqRccRZ51Av63xKsC6gPtZmSrIupH7WRTTAupgOsbZQinUJDbIupcOs7TTE2kHDrMsoLfEMq4d/X7w4nVlWP43K/HKsbXSUtY6OsbbScZnvGKuPToieFH2Kv6fOfvvR7xHZb831TJie/40LOarxRdQXcuqOhNUpCRXiKYkfCa+TuPM8ctD5WeeZdJXh8nGquy4Dl4fHorNq8txynmuqhWqbr1scty5tHPVJHz4uy3ujUM/gdsVxavKcda68N4BP+iXpy1e4j1F4pvukXpnUypf6S/KGayyeQl9OzpB98BWuib5YZhS8wSN37qvJGjlr4axuucyvjC+asPJla1LpVG4taZ2kdZFmkm6a5DGR1JnR/MdSH5M/tk1e0zKjpEVJj0YpqEqjUVWCvEWaRR5UJb/lNCTdUhHLVIlFXiuf2ipgU6OVyAy3x0dGcqnh1Mlk+7Z4LnUsaaZzyWx/PJFcTRFrMH4s3j4UTw+0b+8dTCZyE2O7ctlUeqAkdmI0lxxeTTUlvbWpKqTFSI91AYwpZnapxCRfTM2OxcYixDC7GAYew8DLkHRi1EpVoRfKRRb5Y5YTC4ixVakV5ZRbIGOjV6uQhXLWqemU2Wok8HrMJg1iY3SIldmmWnp4dGirRffYavVsDu7fAKJUHu/rs1KYbzqZJSMRHxrqjScOm1ResJhWRSGjeinUsoq11J4VM5arCQ85nM/tymFJE6hcNTEyqQoaVZdGLIpMCtmTq9mlncdoSkmAF73kjtivmtII16sujVo0dVKIa9beN2yXDpu3eHLMmjRMXrua+wSt4ibEKFiwXS7v2g91Sl0ZkypdGWSLjVw7qo5uyJVRR7jClZ9Q1XJX5TNb6c7b7pbWxELbPVCUFQdjFyfpCuNwFzrjQ+3K8c5k0v2p7HD+TDvfefIPJHNmuj9DEfW82piNjx7qTo5ksjl8+Z1YVybL4aETWORRCqqY8/0n71Am3kflKrVSvdl49gQZGe63O9lPgZHMKPpO4SYj2SSbUDY5nDmWLHyvwrnkqHPT7WnsYuIwRQqR4jCCKrZpLJeNL3X5ZS7fgeeyP0QBDan6lz+ngU4/7X09pD2jUwBo/5Pa+8WNS6F/01Y/Df0bIv9Q9l9x3j9IfrPymn+X1l3v0x4qvlP7XO/T+d879QOrNTlt1Hu1FnbeGdR/Y73J6VO9a3ukjvr/oipo+f82YfF48fkLXtmDEgQQAAA="
            java.lang.String r7 = "AB6162D78BD0F524D904CE19DE76054A9E24726B"
            java.lang.Class r6 = a((android.content.Context) r10, (java.lang.String) r6, (java.lang.String) r7)     // Catch:{ all -> 0x03a4 }
            f42648m = r6     // Catch:{ all -> 0x03a4 }
            if (r6 != 0) goto L_0x007d
            android.os.StrictMode.setThreadPolicy(r5)
            return r1
        L_0x007d:
            com.apptimize.gg r6 = new com.apptimize.gg     // Catch:{ all -> 0x03a4 }
            java.lang.Class<?> r7 = f42648m     // Catch:{ all -> 0x03a4 }
            r6.<init>(r7, r11)     // Catch:{ all -> 0x03a4 }
            f42649n = r6     // Catch:{ all -> 0x03a4 }
            boolean r6 = com.apptimize.c.c()     // Catch:{ all -> 0x03a4 }
            if (r6 != 0) goto L_0x01a4
            boolean r6 = com.apptimize.c.d()     // Catch:{ all -> 0x03a4 }
            if (r6 == 0) goto L_0x0094
            goto L_0x01a4
        L_0x0094:
            boolean r6 = com.apptimize.c.e()     // Catch:{ all -> 0x03a4 }
            if (r6 != 0) goto L_0x00b0
            boolean r6 = com.apptimize.c.f()     // Catch:{ all -> 0x03a4 }
            if (r6 == 0) goto L_0x00a1
            goto L_0x00b0
        L_0x00a1:
            com.apptimize.bq r10 = r11.a()     // Catch:{ all -> 0x03a4 }
            java.lang.String r11 = com.apptimize.c.b()     // Catch:{ all -> 0x03a4 }
            r10.a(r3, r2, r11)     // Catch:{ all -> 0x03a4 }
            android.os.StrictMode.setThreadPolicy(r5)
            return r1
        L_0x00b0:
            boolean r6 = com.apptimize.c.f()     // Catch:{ all -> 0x03a4 }
            if (r6 == 0) goto L_0x012c
            boolean r6 = n()     // Catch:{ all -> 0x03a4 }
            if (r6 == 0) goto L_0x00c1
            java.lang.String r6 = com.apptimize.o.d()     // Catch:{ all -> 0x03a4 }
            goto L_0x00f1
        L_0x00c1:
            boolean r6 = p()     // Catch:{ all -> 0x03a4 }
            if (r6 == 0) goto L_0x00cc
            java.lang.String r6 = com.apptimize.p.d()     // Catch:{ all -> 0x03a4 }
            goto L_0x00f1
        L_0x00cc:
            boolean r6 = q()     // Catch:{ all -> 0x03a4 }
            if (r6 == 0) goto L_0x00d7
            java.lang.String r6 = com.apptimize.q.d()     // Catch:{ all -> 0x03a4 }
            goto L_0x00f1
        L_0x00d7:
            boolean r6 = s()     // Catch:{ all -> 0x03a4 }
            if (r6 == 0) goto L_0x00e2
            java.lang.String r6 = com.apptimize.l.d()     // Catch:{ all -> 0x03a4 }
            goto L_0x00f1
        L_0x00e2:
            boolean r6 = t()     // Catch:{ all -> 0x03a4 }
            if (r6 == 0) goto L_0x00ed
            java.lang.String r6 = com.apptimize.m.d()     // Catch:{ all -> 0x03a4 }
            goto L_0x00f1
        L_0x00ed:
            java.lang.String r6 = com.apptimize.n.d()     // Catch:{ all -> 0x03a4 }
        L_0x00f1:
            int r7 = r6.length()     // Catch:{ all -> 0x03a4 }
            if (r7 <= 0) goto L_0x012c
            r12.add(r6)     // Catch:{ all -> 0x03a4 }
            boolean r6 = n()     // Catch:{ all -> 0x03a4 }
            if (r6 == 0) goto L_0x0103
            java.lang.String r6 = "7-x64"
            goto L_0x0129
        L_0x0103:
            boolean r6 = p()     // Catch:{ all -> 0x03a4 }
            if (r6 == 0) goto L_0x010c
            java.lang.String r6 = "8-x64"
            goto L_0x0129
        L_0x010c:
            boolean r6 = q()     // Catch:{ all -> 0x03a4 }
            if (r6 == 0) goto L_0x0115
            java.lang.String r6 = "9-x64"
            goto L_0x0129
        L_0x0115:
            boolean r6 = s()     // Catch:{ all -> 0x03a4 }
            if (r6 == 0) goto L_0x011e
            java.lang.String r6 = "10-x64"
            goto L_0x0129
        L_0x011e:
            boolean r6 = t()     // Catch:{ all -> 0x03a4 }
            if (r6 == 0) goto L_0x0127
            java.lang.String r6 = "11-x64"
            goto L_0x0129
        L_0x0127:
            java.lang.String r6 = "12-x64"
        L_0x0129:
            r4.add(r6)     // Catch:{ all -> 0x03a4 }
        L_0x012c:
            boolean r6 = n()     // Catch:{ all -> 0x03a4 }
            if (r6 == 0) goto L_0x0137
            java.lang.String r6 = com.apptimize.o.c()     // Catch:{ all -> 0x03a4 }
            goto L_0x0167
        L_0x0137:
            boolean r6 = p()     // Catch:{ all -> 0x03a4 }
            if (r6 == 0) goto L_0x0142
            java.lang.String r6 = com.apptimize.p.c()     // Catch:{ all -> 0x03a4 }
            goto L_0x0167
        L_0x0142:
            boolean r6 = q()     // Catch:{ all -> 0x03a4 }
            if (r6 == 0) goto L_0x014d
            java.lang.String r6 = com.apptimize.q.c()     // Catch:{ all -> 0x03a4 }
            goto L_0x0167
        L_0x014d:
            boolean r6 = s()     // Catch:{ all -> 0x03a4 }
            if (r6 == 0) goto L_0x0158
            java.lang.String r6 = com.apptimize.l.c()     // Catch:{ all -> 0x03a4 }
            goto L_0x0167
        L_0x0158:
            boolean r6 = t()     // Catch:{ all -> 0x03a4 }
            if (r6 == 0) goto L_0x0163
            java.lang.String r6 = com.apptimize.m.c()     // Catch:{ all -> 0x03a4 }
            goto L_0x0167
        L_0x0163:
            java.lang.String r6 = com.apptimize.n.c()     // Catch:{ all -> 0x03a4 }
        L_0x0167:
            int r7 = r6.length()     // Catch:{ all -> 0x03a4 }
            if (r7 <= 0) goto L_0x0296
            r12.add(r6)     // Catch:{ all -> 0x03a4 }
            boolean r6 = n()     // Catch:{ all -> 0x03a4 }
            if (r6 == 0) goto L_0x0179
            java.lang.String r6 = "7-x32"
            goto L_0x019f
        L_0x0179:
            boolean r6 = p()     // Catch:{ all -> 0x03a4 }
            if (r6 == 0) goto L_0x0182
            java.lang.String r6 = "8-x32"
            goto L_0x019f
        L_0x0182:
            boolean r6 = q()     // Catch:{ all -> 0x03a4 }
            if (r6 == 0) goto L_0x018b
            java.lang.String r6 = "9-x32"
            goto L_0x019f
        L_0x018b:
            boolean r6 = s()     // Catch:{ all -> 0x03a4 }
            if (r6 == 0) goto L_0x0194
            java.lang.String r6 = "10-x32"
            goto L_0x019f
        L_0x0194:
            boolean r6 = t()     // Catch:{ all -> 0x03a4 }
            if (r6 == 0) goto L_0x019d
            java.lang.String r6 = "11-x32"
            goto L_0x019f
        L_0x019d:
            java.lang.String r6 = "12-x32"
        L_0x019f:
            r4.add(r6)     // Catch:{ all -> 0x03a4 }
            goto L_0x0296
        L_0x01a4:
            boolean r6 = com.apptimize.c.d()     // Catch:{ all -> 0x03a4 }
            if (r6 == 0) goto L_0x0220
            boolean r6 = n()     // Catch:{ all -> 0x03a4 }
            if (r6 == 0) goto L_0x01b5
            java.lang.String r6 = com.apptimize.o.b()     // Catch:{ all -> 0x03a4 }
            goto L_0x01e5
        L_0x01b5:
            boolean r6 = p()     // Catch:{ all -> 0x03a4 }
            if (r6 == 0) goto L_0x01c0
            java.lang.String r6 = com.apptimize.p.b()     // Catch:{ all -> 0x03a4 }
            goto L_0x01e5
        L_0x01c0:
            boolean r6 = q()     // Catch:{ all -> 0x03a4 }
            if (r6 == 0) goto L_0x01cb
            java.lang.String r6 = com.apptimize.q.b()     // Catch:{ all -> 0x03a4 }
            goto L_0x01e5
        L_0x01cb:
            boolean r6 = s()     // Catch:{ all -> 0x03a4 }
            if (r6 == 0) goto L_0x01d6
            java.lang.String r6 = com.apptimize.l.b()     // Catch:{ all -> 0x03a4 }
            goto L_0x01e5
        L_0x01d6:
            boolean r6 = t()     // Catch:{ all -> 0x03a4 }
            if (r6 == 0) goto L_0x01e1
            java.lang.String r6 = com.apptimize.m.b()     // Catch:{ all -> 0x03a4 }
            goto L_0x01e5
        L_0x01e1:
            java.lang.String r6 = com.apptimize.n.b()     // Catch:{ all -> 0x03a4 }
        L_0x01e5:
            int r7 = r6.length()     // Catch:{ all -> 0x03a4 }
            if (r7 <= 0) goto L_0x0220
            r12.add(r6)     // Catch:{ all -> 0x03a4 }
            boolean r6 = n()     // Catch:{ all -> 0x03a4 }
            if (r6 == 0) goto L_0x01f7
            java.lang.String r6 = "7-arm64"
            goto L_0x021d
        L_0x01f7:
            boolean r6 = p()     // Catch:{ all -> 0x03a4 }
            if (r6 == 0) goto L_0x0200
            java.lang.String r6 = "8-arm64"
            goto L_0x021d
        L_0x0200:
            boolean r6 = q()     // Catch:{ all -> 0x03a4 }
            if (r6 == 0) goto L_0x0209
            java.lang.String r6 = "9-arm64"
            goto L_0x021d
        L_0x0209:
            boolean r6 = s()     // Catch:{ all -> 0x03a4 }
            if (r6 == 0) goto L_0x0212
            java.lang.String r6 = "10-arm64"
            goto L_0x021d
        L_0x0212:
            boolean r6 = t()     // Catch:{ all -> 0x03a4 }
            if (r6 == 0) goto L_0x021b
            java.lang.String r6 = "11-arm64"
            goto L_0x021d
        L_0x021b:
            java.lang.String r6 = "12-arm64"
        L_0x021d:
            r4.add(r6)     // Catch:{ all -> 0x03a4 }
        L_0x0220:
            boolean r6 = n()     // Catch:{ all -> 0x03a4 }
            if (r6 == 0) goto L_0x022b
            java.lang.String r6 = com.apptimize.o.a()     // Catch:{ all -> 0x03a4 }
            goto L_0x025b
        L_0x022b:
            boolean r6 = p()     // Catch:{ all -> 0x03a4 }
            if (r6 == 0) goto L_0x0236
            java.lang.String r6 = com.apptimize.p.a()     // Catch:{ all -> 0x03a4 }
            goto L_0x025b
        L_0x0236:
            boolean r6 = q()     // Catch:{ all -> 0x03a4 }
            if (r6 == 0) goto L_0x0241
            java.lang.String r6 = com.apptimize.q.a()     // Catch:{ all -> 0x03a4 }
            goto L_0x025b
        L_0x0241:
            boolean r6 = s()     // Catch:{ all -> 0x03a4 }
            if (r6 == 0) goto L_0x024c
            java.lang.String r6 = com.apptimize.l.a()     // Catch:{ all -> 0x03a4 }
            goto L_0x025b
        L_0x024c:
            boolean r6 = t()     // Catch:{ all -> 0x03a4 }
            if (r6 == 0) goto L_0x0257
            java.lang.String r6 = com.apptimize.m.a()     // Catch:{ all -> 0x03a4 }
            goto L_0x025b
        L_0x0257:
            java.lang.String r6 = com.apptimize.n.a()     // Catch:{ all -> 0x03a4 }
        L_0x025b:
            int r7 = r6.length()     // Catch:{ all -> 0x03a4 }
            if (r7 <= 0) goto L_0x0296
            r12.add(r6)     // Catch:{ all -> 0x03a4 }
            boolean r6 = n()     // Catch:{ all -> 0x03a4 }
            if (r6 == 0) goto L_0x026d
            java.lang.String r6 = "7-arm32"
            goto L_0x0293
        L_0x026d:
            boolean r6 = p()     // Catch:{ all -> 0x03a4 }
            if (r6 == 0) goto L_0x0276
            java.lang.String r6 = "8-arm32"
            goto L_0x0293
        L_0x0276:
            boolean r6 = q()     // Catch:{ all -> 0x03a4 }
            if (r6 == 0) goto L_0x027f
            java.lang.String r6 = "9-arm32"
            goto L_0x0293
        L_0x027f:
            boolean r6 = s()     // Catch:{ all -> 0x03a4 }
            if (r6 == 0) goto L_0x0288
            java.lang.String r6 = "10-arm32"
            goto L_0x0293
        L_0x0288:
            boolean r6 = t()     // Catch:{ all -> 0x03a4 }
            if (r6 == 0) goto L_0x0291
            java.lang.String r6 = "11-arm32"
            goto L_0x0293
        L_0x0291:
            java.lang.String r6 = "12-arm32"
        L_0x0293:
            r4.add(r6)     // Catch:{ all -> 0x03a4 }
        L_0x0296:
            boolean r6 = r12.isEmpty()     // Catch:{ all -> 0x03a4 }
            if (r6 == 0) goto L_0x02ab
            com.apptimize.bq r10 = r11.a()     // Catch:{ all -> 0x03a4 }
            java.lang.String r11 = com.apptimize.c.b()     // Catch:{ all -> 0x03a4 }
            r10.a(r3, r2, r11)     // Catch:{ all -> 0x03a4 }
            android.os.StrictMode.setThreadPolicy(r5)
            return r1
        L_0x02ab:
            java.io.File r2 = new java.io.File     // Catch:{ all -> 0x03a4 }
            java.io.File r10 = r10.getFilesDir()     // Catch:{ all -> 0x03a4 }
            java.lang.String r10 = r10.getPath()     // Catch:{ all -> 0x03a4 }
            java.lang.String r6 = "libcrashreport.so"
            r2.<init>(r10, r6)     // Catch:{ all -> 0x03a4 }
            r10 = r1
        L_0x02bb:
            int r6 = r12.size()     // Catch:{ IOException -> 0x036f, NoSuchMethodException -> 0x035a, IllegalAccessException -> 0x0345, InvocationTargetException -> 0x0330 }
            if (r10 >= r6) goto L_0x0327
            java.io.BufferedOutputStream r6 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x036f, NoSuchMethodException -> 0x035a, IllegalAccessException -> 0x0345, InvocationTargetException -> 0x0330 }
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x036f, NoSuchMethodException -> 0x035a, IllegalAccessException -> 0x0345, InvocationTargetException -> 0x0330 }
            r7.<init>(r2)     // Catch:{ IOException -> 0x036f, NoSuchMethodException -> 0x035a, IllegalAccessException -> 0x0345, InvocationTargetException -> 0x0330 }
            r6.<init>(r7)     // Catch:{ IOException -> 0x036f, NoSuchMethodException -> 0x035a, IllegalAccessException -> 0x0345, InvocationTargetException -> 0x0330 }
            java.lang.Object r7 = r12.get(r10)     // Catch:{ IOException -> 0x036f, NoSuchMethodException -> 0x035a, IllegalAccessException -> 0x0345, InvocationTargetException -> 0x0330 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ IOException -> 0x036f, NoSuchMethodException -> 0x035a, IllegalAccessException -> 0x0345, InvocationTargetException -> 0x0330 }
            byte[] r7 = com.apptimize.ew.a((java.lang.String) r7)     // Catch:{ IOException -> 0x036f, NoSuchMethodException -> 0x035a, IllegalAccessException -> 0x0345, InvocationTargetException -> 0x0330 }
            r6.write(r7)     // Catch:{ IOException -> 0x036f, NoSuchMethodException -> 0x035a, IllegalAccessException -> 0x0345, InvocationTargetException -> 0x0330 }
            r6.close()     // Catch:{ IOException -> 0x036f, NoSuchMethodException -> 0x035a, IllegalAccessException -> 0x0345, InvocationTargetException -> 0x0330 }
            com.apptimize.fa.a(r11)     // Catch:{ IOException -> 0x036f, NoSuchMethodException -> 0x035a, IllegalAccessException -> 0x0345, InvocationTargetException -> 0x0330 }
            java.lang.Class<?> r6 = f42648m     // Catch:{ InvocationTargetException -> 0x031b, IOException -> 0x036f, NoSuchMethodException -> 0x035a, IllegalAccessException -> 0x0345 }
            java.lang.String r7 = "loadLibrary"
            java.lang.Class[] r8 = new java.lang.Class[r0]     // Catch:{ InvocationTargetException -> 0x031b, IOException -> 0x036f, NoSuchMethodException -> 0x035a, IllegalAccessException -> 0x0345 }
            java.lang.Class<java.lang.String> r9 = java.lang.String.class
            r8[r1] = r9     // Catch:{ InvocationTargetException -> 0x031b, IOException -> 0x036f, NoSuchMethodException -> 0x035a, IllegalAccessException -> 0x0345 }
            java.lang.reflect.Method r6 = r6.getMethod(r7, r8)     // Catch:{ InvocationTargetException -> 0x031b, IOException -> 0x036f, NoSuchMethodException -> 0x035a, IllegalAccessException -> 0x0345 }
            java.lang.Object[] r7 = new java.lang.Object[r0]     // Catch:{ InvocationTargetException -> 0x031b, IOException -> 0x036f, NoSuchMethodException -> 0x035a, IllegalAccessException -> 0x0345 }
            java.lang.String r8 = r2.getAbsolutePath()     // Catch:{ InvocationTargetException -> 0x031b, IOException -> 0x036f, NoSuchMethodException -> 0x035a, IllegalAccessException -> 0x0345 }
            r7[r1] = r8     // Catch:{ InvocationTargetException -> 0x031b, IOException -> 0x036f, NoSuchMethodException -> 0x035a, IllegalAccessException -> 0x0345 }
            r8 = 0
            r6.invoke(r8, r7)     // Catch:{ InvocationTargetException -> 0x031b, IOException -> 0x036f, NoSuchMethodException -> 0x035a, IllegalAccessException -> 0x0345 }
            f42654s = r0     // Catch:{ InvocationTargetException -> 0x031b, IOException -> 0x036f, NoSuchMethodException -> 0x035a, IllegalAccessException -> 0x0345 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ InvocationTargetException -> 0x031b, IOException -> 0x036f, NoSuchMethodException -> 0x035a, IllegalAccessException -> 0x0345 }
            r6.<init>()     // Catch:{ InvocationTargetException -> 0x031b, IOException -> 0x036f, NoSuchMethodException -> 0x035a, IllegalAccessException -> 0x0345 }
            java.lang.String r7 = "platform "
            r6.append(r7)     // Catch:{ InvocationTargetException -> 0x031b, IOException -> 0x036f, NoSuchMethodException -> 0x035a, IllegalAccessException -> 0x0345 }
            java.lang.Object r7 = r4.get(r10)     // Catch:{ InvocationTargetException -> 0x031b, IOException -> 0x036f, NoSuchMethodException -> 0x035a, IllegalAccessException -> 0x0345 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ InvocationTargetException -> 0x031b, IOException -> 0x036f, NoSuchMethodException -> 0x035a, IllegalAccessException -> 0x0345 }
            r6.append(r7)     // Catch:{ InvocationTargetException -> 0x031b, IOException -> 0x036f, NoSuchMethodException -> 0x035a, IllegalAccessException -> 0x0345 }
            java.lang.String r6 = r6.toString()     // Catch:{ InvocationTargetException -> 0x031b, IOException -> 0x036f, NoSuchMethodException -> 0x035a, IllegalAccessException -> 0x0345 }
            com.apptimize.bo.k(r3, r6)     // Catch:{ InvocationTargetException -> 0x031b, IOException -> 0x036f, NoSuchMethodException -> 0x035a, IllegalAccessException -> 0x0345 }
            r2.delete()     // Catch:{ all -> 0x03a4 }
            android.os.StrictMode.setThreadPolicy(r5)
            return r0
        L_0x031b:
            r6 = move-exception
            int r7 = r12.size()     // Catch:{ IOException -> 0x036f, NoSuchMethodException -> 0x035a, IllegalAccessException -> 0x0345, InvocationTargetException -> 0x0330 }
            int r7 = r7 - r0
            if (r10 == r7) goto L_0x0326
            int r10 = r10 + 1
            goto L_0x02bb
        L_0x0326:
            throw r6     // Catch:{ IOException -> 0x036f, NoSuchMethodException -> 0x035a, IllegalAccessException -> 0x0345, InvocationTargetException -> 0x0330 }
        L_0x0327:
            r2.delete()     // Catch:{ all -> 0x03a4 }
            android.os.StrictMode.setThreadPolicy(r5)
            return r1
        L_0x032e:
            r10 = move-exception
            goto L_0x03a0
        L_0x0330:
            r10 = move-exception
            com.apptimize.bq r11 = r11.a()     // Catch:{ all -> 0x032e }
            java.lang.String r12 = "AN1001-9"
            java.lang.String r10 = com.apptimize.fx.a((java.lang.Exception) r10)     // Catch:{ all -> 0x032e }
            r11.a(r3, r12, r10)     // Catch:{ all -> 0x032e }
            r2.delete()     // Catch:{ all -> 0x03a4 }
            android.os.StrictMode.setThreadPolicy(r5)
            return r1
        L_0x0345:
            r10 = move-exception
            com.apptimize.bq r11 = r11.a()     // Catch:{ all -> 0x032e }
            java.lang.String r12 = "AN1001-8"
            java.lang.String r10 = com.apptimize.fx.a((java.lang.Exception) r10)     // Catch:{ all -> 0x032e }
            r11.a(r3, r12, r10)     // Catch:{ all -> 0x032e }
            r2.delete()     // Catch:{ all -> 0x03a4 }
            android.os.StrictMode.setThreadPolicy(r5)
            return r1
        L_0x035a:
            r10 = move-exception
            com.apptimize.bq r11 = r11.a()     // Catch:{ all -> 0x032e }
            java.lang.String r12 = "AN1001-7"
            java.lang.String r10 = com.apptimize.fx.a((java.lang.Exception) r10)     // Catch:{ all -> 0x032e }
            r11.a(r3, r12, r10)     // Catch:{ all -> 0x032e }
            r2.delete()     // Catch:{ all -> 0x03a4 }
            android.os.StrictMode.setThreadPolicy(r5)
            return r1
        L_0x036f:
            r10 = move-exception
            com.apptimize.bq r11 = r11.a()     // Catch:{ all -> 0x032e }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x032e }
            r12.<init>()     // Catch:{ all -> 0x032e }
            java.lang.String r0 = "Unexpected exception "
            r12.append(r0)     // Catch:{ all -> 0x032e }
            java.lang.Class r0 = r10.getClass()     // Catch:{ all -> 0x032e }
            java.lang.String r0 = r0.getName()     // Catch:{ all -> 0x032e }
            r12.append(r0)     // Catch:{ all -> 0x032e }
            java.lang.String r0 = " when writing data"
            r12.append(r0)     // Catch:{ all -> 0x032e }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x032e }
            java.lang.String r10 = com.apptimize.fx.a((java.lang.Exception) r10)     // Catch:{ all -> 0x032e }
            r11.a(r3, r12, r10)     // Catch:{ all -> 0x032e }
            r2.delete()     // Catch:{ all -> 0x03a4 }
            android.os.StrictMode.setThreadPolicy(r5)
            return r1
        L_0x03a0:
            r2.delete()     // Catch:{ all -> 0x03a4 }
            throw r10     // Catch:{ all -> 0x03a4 }
        L_0x03a4:
            r10 = move-exception
            android.os.StrictMode.setThreadPolicy(r5)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.gn.a(android.content.Context, com.apptimize.au, boolean):boolean");
    }

    private static synchronized void b(String str) {
        synchronized (gn.class) {
            f42638c = str;
            gm gmVar = f42649n;
            if (!(gmVar == null || gmVar.e() == null)) {
                f42638c += SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE + f42649n.e();
            }
            bo.k("VisualChanges", "Apptimize setup failed " + f42638c);
        }
    }

    public static synchronized void b(Method method, gk gkVar, b bVar) {
        synchronized (gn.class) {
            if (a(bVar)) {
                Class[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 7) {
                    a(method, gkVar, parameterTypes.length, false);
                    return;
                }
                throw new IllegalArgumentException("Too many arguments");
            }
        }
    }

    public static boolean b(au auVar) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 > 32) {
            return a(auVar, true, "AN1021");
        }
        if (i11 >= 24 && Build.VERSION.PREVIEW_SDK_INT != 0) {
            return a(auVar, true, "AN1022");
        }
        if (l()) {
            boolean a11 = a(auVar, !t.c(), "AN1024");
            if (!a11) {
                bo.k("VisualChanges", "enabling normally-disabled device");
            }
            return a11;
        }
        String str = Build.MANUFACTURER;
        if (!str.toLowerCase().startsWith("essential")) {
            if (!n()) {
                return false;
            }
            if (!str.toLowerCase().startsWith("sony") && !str.toLowerCase().startsWith("nvidia")) {
                return false;
            }
        }
        return a(auVar, true, "AN1024");
    }

    public static synchronized boolean a(Context context, au auVar, boolean z11, String str, String str2) {
        synchronized (gn.class) {
            f42638c = null;
            if (!k() || !av.f41263z) {
                A();
                if (!a(context, auVar, false)) {
                    b("AN2001");
                    return false;
                }
                if (str != null) {
                    a(auVar, context, str, str2);
                }
                gm gmVar = f42649n;
                if (gmVar != null) {
                    if (gmVar.a()) {
                        f42650o = true;
                        try {
                            if (!f42649n.a(context, z11)) {
                                b("AN2003");
                                return false;
                            } else if (!C()) {
                                b("AN2004");
                                f42649n.b();
                                return false;
                            } else if (!f42649n.c()) {
                                b("AN2005");
                                f42649n.b();
                                return false;
                            } else {
                                gi.a();
                                f42649n.b();
                                f42640e = true;
                                return true;
                            }
                        } finally {
                            f42649n.b();
                        }
                    }
                }
                b("AN2002");
                return false;
            }
            b("AN2000");
            return false;
        }
    }

    public static void a(String str) {
        if (av.f41250m) {
            try {
                File file = new File(str);
                if (file.exists()) {
                    bo.k("VisualChanges", "Dump crash_detail");
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                    int i11 = 0;
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            bo.k("VisualChanges", "crash_detail " + i11 + CertificateUtil.DELIMITER + readLine);
                            TimeUnit.MILLISECONDS.sleep(1);
                            i11++;
                        } else {
                            file.delete();
                            return;
                        }
                    }
                }
            } catch (Exception e11) {
                bo.k("VisualChanges", "Error logging crash_detail " + Log.getStackTraceString(e11));
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:15|16|(3:18|19|20)(4:21|22|23|24)) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x001f, code lost:
        if (a(r5, r4, true) == false) goto L_0x0021;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0021, code lost:
        com.apptimize.bo.k("VisualChanges", "loadLibrary failed");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0029, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        f42641f = a(r4, r6, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0031, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x001b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void a(com.apptimize.au r4, android.content.Context r5, java.lang.String r6, java.lang.String r7) {
        /*
            java.lang.Class<com.apptimize.gn> r0 = com.apptimize.gn.class
            monitor-enter(r0)
            boolean r1 = f42651p     // Catch:{ all -> 0x0032 }
            if (r1 == 0) goto L_0x0009
            monitor-exit(r0)
            return
        L_0x0009:
            r1 = 1
            f42651p = r1     // Catch:{ all -> 0x0032 }
            java.lang.String r2 = "mono.android.app.XamarinAndroidEnvironmentVariables"
            java.lang.Class.forName(r2)     // Catch:{ ClassNotFoundException -> 0x001b }
            java.lang.String r2 = "VisualChanges"
            java.lang.String r3 = "xamarin detected"
            com.apptimize.bo.k(r2, r3)     // Catch:{ ClassNotFoundException -> 0x001b }
            monitor-exit(r0)
            return
        L_0x001b:
            boolean r5 = a((android.content.Context) r5, (com.apptimize.au) r4, (boolean) r1)     // Catch:{ all -> 0x0032 }
            if (r5 != 0) goto L_0x002a
            java.lang.String r4 = "VisualChanges"
            java.lang.String r5 = "loadLibrary failed"
            com.apptimize.bo.k(r4, r5)     // Catch:{ all -> 0x0032 }
            monitor-exit(r0)
            return
        L_0x002a:
            boolean r4 = a((com.apptimize.au) r4, (java.lang.String) r6, (java.lang.String) r7)     // Catch:{ all -> 0x0032 }
            f42641f = r4     // Catch:{ all -> 0x0032 }
            monitor-exit(r0)
            return
        L_0x0032:
            r4 = move-exception
            monitor-exit(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.gn.a(com.apptimize.au, android.content.Context, java.lang.String, java.lang.String):void");
    }

    private static boolean a(au auVar, String str, String str2) {
        Class<String> cls = String.class;
        try {
            boolean booleanValue = ((Boolean) f42648m.getMethod("initCrashReporting", new Class[]{cls, cls}).invoke((Object) null, new Object[]{str, str2})).booleanValue();
            bo.k("VisualChanges", "crashReporting installed " + booleanValue + " file:" + str + " detail:" + str2);
            return booleanValue;
        } catch (NoSuchMethodException e11) {
            auVar.a().a("VisualChanges", "AN1001-10", fx.a((Exception) e11));
            return false;
        } catch (IllegalAccessException e12) {
            auVar.a().a("VisualChanges", "AN1001-11", fx.a((Exception) e12));
            return false;
        } catch (InvocationTargetException e13) {
            auVar.a().a("VisualChanges", "AN1001-12", fx.a((Exception) e13));
            return false;
        }
    }

    public static void a(au auVar) {
        if (av.f41246i) {
            a(-1, auVar);
        }
    }

    public static void a(int i11, au auVar) {
        if (av.f41246i) {
            auVar.c().d(new fi() {
                public void run() {
                }
            });
            bo.g("VisualChanges", "Calling testCrashReporting " + Log.getStackTraceString(new Throwable()));
            try {
                f42648m.getMethod("testCrashReporting", new Class[]{Integer.TYPE}).invoke((Object) null, new Object[]{Integer.valueOf(i11)});
            } catch (Exception e11) {
                bo.g("VisualChanges", "Error calling testCrashReporting " + e11);
            }
        }
    }

    public static synchronized gk a(Method method, gk gkVar, int i11, boolean z11) {
        synchronized (gn.class) {
            if (!f42646k.containsKey(method)) {
                f42646k.put(method, new CopyOnWriteArrayList());
            }
            gm gmVar = f42649n;
            if (gmVar != null) {
                gmVar.a(method, i11, z11);
            }
            f42646k.get(method).add(gkVar);
        }
        return gkVar;
    }

    public static synchronized void a(Method method, gk gkVar, b bVar) {
        synchronized (gn.class) {
            if (!a(bVar)) {
                bo.k("VisualChanges", "addMethodCallListener not enabled " + method.getName());
                return;
            }
            a(method, gkVar, 0, false);
        }
    }

    public static boolean a(gk gkVar, b bVar, Class<?> cls, String str, Class<?>... clsArr) {
        try {
            b(fn.b(cls, str, clsArr), gkVar, bVar);
            return true;
        } catch (NoSuchMethodException unused) {
            return false;
        }
    }

    public static void a(Class<?> cls, String str, gk gkVar, b bVar) {
        if (cls != null) {
            for (Method method : cls.getDeclaredMethods()) {
                if (method.getName().equals(str)) {
                    c(method, gkVar, bVar);
                }
            }
            a((Class<?>) cls.getSuperclass(), str, gkVar, bVar);
        }
    }

    public static synchronized void a(Method method, gl glVar) {
        synchronized (gn.class) {
            if (f42649n != null && !f42647l.containsKey(method) && !f42646k.containsKey(method)) {
                f42649n.a(method, 0, false);
            }
            f42647l.put(method, glVar);
        }
    }

    public static Object a(final Object obj, final Method method, final Object obj2, final Object[] objArr) {
        f42636a.incrementAndGet();
        if (f42644i && (obj instanceof View)) {
            return obj2;
        }
        try {
            fu fuVar = f42645j;
            fuVar.a();
            Object a11 = fe.a("VisualChanges", obj2, new fk() {
                public Object b() {
                    br.b("method", method, obj, objArr);
                    return gn.c(obj, method, obj2, objArr);
                }
            }, false);
            fuVar.b();
            return a11;
        } catch (Throwable th2) {
            f42645j.b();
            throw th2;
        }
    }

    private static boolean a(au auVar, boolean z11, String str) {
        if (z11) {
            bo.k("VisualChanges", "reportIfDisabled: " + str);
            auVar.a().a(bq.b.A, (Map<String, Object>) new HashMap<String, Object>(str) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ String f42662a;

                {
                    this.f42662a = r2;
                    put(Constant.PARAM_ERROR_CODE, r2);
                }
            });
        }
        return z11;
    }

    private static Class<?> a(Context context, String str, String str2) {
        Class<String> cls = String.class;
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        if (Build.VERSION.SDK_INT >= 26) {
            StrictMode.setThreadPolicy(a.a());
        }
        try {
            byte[] a11 = ew.a(str);
            File cacheDir = context.getCacheDir();
            File file = new File(cacheDir, "generated-" + str2 + ".jar");
            if (!file.exists()) {
                File createTempFile = File.createTempFile("tempdex", ArchiveStreamFactory.JAR, context.getCacheDir());
                JarOutputStream jarOutputStream = new JarOutputStream(new FileOutputStream(createTempFile));
                jarOutputStream.putNextEntry(new JarEntry("classes.dex"));
                jarOutputStream.write(a11);
                jarOutputStream.closeEntry();
                jarOutputStream.close();
                createTempFile.renameTo(file);
            }
            Object newInstance = Class.forName("dalvik.system.DexClassLoader").getConstructor(new Class[]{cls, cls, cls, ClassLoader.class}).newInstance(new Object[]{file.getPath(), context.getCacheDir().getAbsolutePath(), null, gn.class.getClassLoader()});
            return (Class) newInstance.getClass().getMethod("loadClass", new Class[]{cls}).invoke(newInstance, new Object[]{"com.apptimize.NativeInterface"});
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (InvocationTargetException unused2) {
            return null;
        } catch (InstantiationException unused3) {
            return null;
        } catch (NoSuchMethodException unused4) {
            return null;
        } catch (IllegalAccessException unused5) {
            return null;
        } catch (IOException unused6) {
            return null;
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }
}
