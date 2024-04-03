package com.uxcam.internals;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Window;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.SupportMapFragment;
import com.uxcam.UXCam;
import com.uxcam.datamodel.UXCamOcclusion;
import com.uxcam.datamodel.UXConfig;
import com.uxcam.internals.gu;
import com.uxcam.service.HttpPostService;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import mz.h0;
import mz.i0;
import mz.j0;
import mz.k0;
import org.json.JSONException;
import org.json.JSONObject;

public class hm {

    /* renamed from: h  reason: collision with root package name */
    public static boolean f13565h = false;

    /* renamed from: i  reason: collision with root package name */
    public static String f13566i = null;

    /* renamed from: j  reason: collision with root package name */
    public static String f13567j = null;

    /* renamed from: k  reason: collision with root package name */
    public static hk f13568k = null;

    /* renamed from: l  reason: collision with root package name */
    public static boolean f13569l = false;

    /* renamed from: m  reason: collision with root package name */
    public static boolean f13570m = false;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: n  reason: collision with root package name */
    public static hm f13571n = null;

    /* renamed from: o  reason: collision with root package name */
    public static boolean f13572o = false;

    /* renamed from: p  reason: collision with root package name */
    public static boolean f13573p = false;

    /* renamed from: q  reason: collision with root package name */
    public static boolean f13574q = false;

    /* renamed from: r  reason: collision with root package name */
    public static UXConfig f13575r;

    /* renamed from: a  reason: collision with root package name */
    public final List f13576a = new CopyOnWriteArrayList();

    /* renamed from: b  reason: collision with root package name */
    public final gl f13577b = new gl();

    /* renamed from: c  reason: collision with root package name */
    public Application.ActivityLifecycleCallbacks f13578c;

    /* renamed from: d  reason: collision with root package name */
    public int f13579d = 0;

    /* renamed from: e  reason: collision with root package name */
    public Context f13580e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f13581f;

    /* renamed from: g  reason: collision with root package name */
    public hz f13582g = new hz();

    public static boolean a() {
        return f13575r != null;
    }

    @TargetApi(14)
    public static void b(Activity activity) {
        if (!f13572o) {
            d();
            f13572o = true;
            hi hiVar = new hi();
            f().f13578c = hiVar;
            hiVar.a(activity);
            activity.getApplication().registerActivityLifecycleCallbacks(hiVar);
        }
    }

    public static void c() {
        if (ia.f13617c == null) {
            try {
                ia.f13617c = b();
            } catch (ClassNotFoundException unused) {
                gu.a("hm").getClass();
            } catch (NoSuchMethodException unused2) {
                gu.a("hm").getClass();
            } catch (IllegalArgumentException unused3) {
                gu.a("hm").getClass();
            } catch (IllegalAccessException unused4) {
                gu.a("hm").getClass();
            } catch (InvocationTargetException unused5) {
                gu.a("hm").getClass();
            }
        }
    }

    public static void d() {
        if (!f13570m) {
            f13570m = true;
            hq hqVar = new hq();
            if (hqVar != gu.f13504c) {
                List list = gu.f13502a;
                synchronized (list) {
                    ((ArrayList) list).add(hqVar);
                    gu.f13503b = (gu.ab[]) ((ArrayList) list).toArray(new gu.ab[((ArrayList) list).size()]);
                }
                gu.a("UXCam").getClass();
                return;
            }
            throw new IllegalArgumentException("Cannot plant Timber into itself.");
        }
    }

    public static UXConfig e() {
        if (f13575r == null) {
            f13575r = new UXConfig.Builder("").build();
        }
        return f13575r;
    }

    public static hm f() {
        if (f13571n == null) {
            f13571n = new hm();
        }
        return f13571n;
    }

    public static void g() {
        try {
            if (e().f12942b == null || e().f12942b.isEmpty()) {
                gu.a("hm").getClass();
                return;
            }
            f13573p = true;
            a((Activity) null, true, false);
        } catch (NullPointerException e11) {
            e11.printStackTrace();
        }
    }

    public static void h() {
        gu.a("hm").getClass();
        f13573p = false;
        if (f13568k != null) {
            try {
                f().b(ia.f13617c);
                gu.a("hk").getClass();
            } catch (Exception unused) {
                gu.a("hk").getClass();
            }
        }
    }

    public static void i() {
        boolean z11;
        boolean isEmpty = HttpPostService.f13679b.isEmpty();
        File[] listFiles = new File(by.a()).listFiles();
        boolean z12 = true;
        if (listFiles == null || listFiles.length != 0) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (!z11 || !HttpPostService.f13678a) {
            z12 = false;
        }
        if (!isEmpty && !z12) {
            gu.a("hm").getClass();
        } else if (!bi.f13066a) {
            gu.a("hm").getClass();
            gu.a("UXCamHelper").getClass();
            ia.f13617c.stopService(new Intent(ia.f13617c, HttpPostService.class));
            if (z12) {
                gu.a("UXCam").b("UXCam 3.4.4[561] : session data sent successfully", new Object[0]);
            } else {
                gu.a("UXCam").getClass();
            }
        }
    }

    @TargetApi(14)
    public static void a(Activity activity, boolean z11, boolean z12) {
        boolean z13;
        d();
        c();
        gu.a("startWithKeyCalled").getClass();
        Application application = (Application) ia.f13617c;
        if (!z11) {
            if (!Thread.currentThread().equals(Looper.getMainLooper().getThread())) {
                f13574q = true;
            }
            if (!b(ia.f13617c.getClass().getName())) {
                Context context = ia.f13617c;
                if (!b(context.getPackageManager().getLaunchIntentForPackage(context.getPackageName()).getComponent().getClassName())) {
                    z13 = true;
                    if (z13 && z12) {
                        hi.f13556d = 1;
                    }
                }
            }
            z13 = false;
            hi.f13556d = 1;
        }
        SharedPreferences sharedPreferences = new eq(application).f13291a;
        if (e().f12942b.equalsIgnoreCase(sharedPreferences == null ? "" : sharedPreferences.getString("killed_app_key", (String) null))) {
            gu.a("UXCam").getClass();
            return;
        }
        if (!f13572o) {
            f13572o = true;
            gu.a("hm").getClass();
            f().f13578c = new hi();
            application.registerActivityLifecycleCallbacks(f().f13578c);
        }
        if (ia.c() != null && z11 && (f13569l || f13573p)) {
            f13573p = false;
            activity = (Activity) ia.c();
            a(true, activity);
        }
        if (z11 && (f13569l || f13573p)) {
            hi hiVar = (hi) f().f13578c;
            if (hiVar.f13557a > 0) {
                f13573p = false;
                activity = (Activity) ia.c();
                a(true, activity);
            } else {
                hiVar.f13558b = new h0();
            }
        }
        if (activity != null) {
            f13573p = false;
        }
        Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = f().f13578c;
        if (!z12 && activity != null && (activityLifecycleCallbacks instanceof hi)) {
            ((hi) activityLifecycleCallbacks).a(activity);
        }
    }

    public final String e(String str) {
        if (str == null || TextUtils.isEmpty(str.trim())) {
            String format = String.format("[ WARNING ] User identity must not be %s.", new Object[]{"null or empty"});
            System.out.printf("UXCam: %s%n", new Object[]{format});
            fx a11 = new fx().a(format);
            a11.a("site_of_error", "hm");
            a11.a(4);
            return null;
        } else if (str.length() <= 255) {
            return str;
        } else {
            String format2 = String.format("[ WARNING ] User identity must not be %s.", new Object[]{"greater than 255 characters"});
            System.out.printf("UXCam: %s%n", new Object[]{format2});
            fx a12 = new fx().a(format2);
            a12.a("site_of_error", "hm");
            a12.a(4);
            return null;
        }
    }

    public void f(String str) {
        JSONObject optJSONObject;
        gm.f13453b = null;
        if (bh.a(this.f13580e)) {
            Context context = this.f13580e;
            ij ijVar = new ij(context);
            gu.a(ij.f13637c).getClass();
            ii iiVar = new ii(ijVar, str);
            boolean z11 = false;
            try {
                String b11 = new eq(context).b("settings_" + str.hashCode());
                if (!(b11 == null || (optJSONObject = new JSONObject(b11).optJSONObject("verifyLimits")) == null || !ijVar.a(context, optJSONObject))) {
                    gu.a("UXCam 3.4.4[561]").b("Could not verify. Exceeds verify limit.", new Object[0]);
                    z11 = true;
                }
            } catch (JSONException e11) {
                e11.printStackTrace();
            }
            if (!z11) {
                bi.f13067b = true;
                ijVar.a(str, iiVar, (String) null, true);
                return;
            }
            new gc(ia.f13617c).b();
            return;
        }
        new ij(this.f13580e).a(str);
    }

    public static boolean b(String str) {
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            if (stackTraceElement.getClassName().equals(str) && stackTraceElement.getMethodName().equals("onCreate")) {
                return true;
            }
        }
        return false;
    }

    @TargetApi(14)
    @Deprecated
    public static void c(String str) {
        try {
            e().f12942b = str;
            a((Activity) null, false, false);
        } catch (NullPointerException e11) {
            e11.printStackTrace();
        }
    }

    public static Application b() {
        Application application = (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke((Object) null, (Object[]) null);
        gu.ab a11 = gu.a("hm");
        Objects.toString(application);
        a11.getClass();
        return application;
    }

    public static void d(String str) {
        if (bi.f13066a) {
            try {
                hb c11 = hb.c();
                Context context = ia.f13617c;
                c11.getClass();
                new Thread(new ha(c11, context, str)).start();
            } catch (Exception e11) {
                fx fxVar = new fx();
                fxVar.a("EXCEPTION");
                fxVar.a("site_of_error", "UXCamHelper::tagScreenName()");
                fxVar.a("reason", e11.getMessage());
                fxVar.a(2);
            }
        } else {
            hb.f13527j = str;
        }
    }

    public static void b(boolean z11) {
        f13569l = !z11;
        c();
        Context context = ia.f13617c;
        if (context != null) {
            SharedPreferences sharedPreferences = new eq(context).f13291a;
            if (sharedPreferences != null) {
                sharedPreferences.edit().putBoolean("opt_out", z11).apply();
            }
        } else if (z11) {
            gm.f13468q = 1;
        } else {
            gm.f13468q = 0;
        }
        if (!z11) {
            gm.f13468q = 0;
            if (!bi.f13066a) {
                UXCam.startNewSession();
            }
        } else if (bi.f13066a) {
            UXCam.cancelCurrentSession();
            UXCam.stopSessionAndUploadData();
        }
    }

    public static void b(String str, Map map) {
        hb.c().a(str, new JSONObject(), map);
    }

    @TargetApi(14)
    public void b(Context context) {
        fn.f13380k = 0;
        int i11 = gm.f13452a;
        f().f13581f = false;
        gu.a("hm").getClass();
        f13568k = null;
        fm.f13364c = -1;
        f().f13579d = 2;
        if (f().f13579d == 1) {
            hb.c().f13532c = new ArrayList();
        }
        try {
            if (bi.f13066a) {
                ih.f13634a = false;
                gk.a().a(ia.f13617c, "");
            } else if (bi.f13067b) {
                bi.f13067b = false;
                new bj("").a(4, by.a() + "/" + UUID.randomUUID().toString() + "/");
            } else if (gm.f13465n) {
                gm.f13465n = false;
            }
        } catch (Exception unused) {
            gu.f13504c.getClass();
        }
    }

    public static /* synthetic */ void a(Activity activity) {
        f13573p = false;
        a(true, activity);
    }

    public static void a(UXConfig uXConfig) {
        try {
            e().e(uXConfig);
            a((Activity) null, false, false);
            for (UXCamOcclusion b11 : uXConfig.f12941a) {
                ee.b(b11);
            }
        } catch (NullPointerException e11) {
            e11.printStackTrace();
        }
    }

    @TargetApi(14)
    public static void a(Activity activity, String str) {
        e().f12942b = str;
        b(activity);
    }

    public static void a(boolean z11, Activity activity) {
        boolean z12;
        try {
            Iterator it = fn.f13384o.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z12 = false;
                    break;
                }
                Activity activity2 = (Activity) it.next();
                if (activity2 != null && activity2.equals(activity)) {
                    z12 = true;
                    break;
                }
            }
            if (!z12) {
                fn.f13384o.add(activity);
                gu.ab a11 = gu.a("ActivityStack");
                activity.getClass();
                a11.getClass();
            }
            fn.f13379j = false;
            gu.a("UXCam").getClass();
            if (fn.f13379j) {
                fn.f13379j = false;
                gm.f13452a = 700;
            }
            ia.a(activity);
            hk hkVar = new hk();
            f13568k = hkVar;
            hkVar.a(z11, activity);
            Window window = activity.getWindow();
            Window.Callback callback = window.getCallback();
            if (callback == null || !callback.getClass().getName().equalsIgnoreCase(hw.class.getName())) {
                window.setCallback(new hw(callback));
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public static void a(boolean z11) {
        if (f13570m) {
            HashMap hashMap = new HashMap();
            hashMap.put("with", "disabled = " + z11);
            hashMap.put("reason", "invoked .disableCrashHandling() method too late.");
            hashMap.put("result", "crashes are logged");
            hu.c("[ TOGGLE ERROR ] Crash Handler", hashMap);
            return;
        }
        e().f12945e = !z11;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x012a, code lost:
        if (r11.equals("UXCam_IgnoreDataFilters") == false) goto L_0x010c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(java.lang.String r11, java.util.Map r12) {
        /*
            com.uxcam.internals.hb r0 = com.uxcam.internals.hb.c()
            r0.getClass()
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            int[] r2 = com.uxcam.internals.gm.f13476y
            r3 = 0
            r4 = r2[r3]
            r5 = 1
            r6 = r2[r5]
            r7 = 2
            r2 = r2[r7]
            float r8 = com.uxcam.internals.ia.d()
            r9 = 0
            int r9 = (r8 > r9 ? 1 : (r8 == r9 ? 0 : -1))
            if (r9 > 0) goto L_0x0022
            goto L_0x0101
        L_0x0022:
            java.util.ArrayList r9 = r0.f13532c
            if (r9 != 0) goto L_0x002d
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            r0.f13532c = r9
        L_0x002d:
            java.util.ArrayList r9 = r0.f13532c
            int r9 = r9.size()
            if (r9 < r4) goto L_0x0037
            goto L_0x0101
        L_0x0037:
            int r4 = r0.a(r11)
            r9 = 255(0xff, float:3.57E-43)
            if (r4 <= r9) goto L_0x0041
            goto L_0x0101
        L_0x0041:
            if (r12 == 0) goto L_0x00bf
            int r4 = r12.size()
            if (r4 > r6) goto L_0x00bf
            java.util.Set r12 = r12.entrySet()
            java.util.Iterator r12 = r12.iterator()
            r4 = r3
        L_0x0052:
            boolean r9 = r12.hasNext()
            if (r9 == 0) goto L_0x00ef
            java.lang.Object r9 = r12.next()
            java.util.Map$Entry r9 = (java.util.Map.Entry) r9
            if (r4 < r6) goto L_0x006f
            java.lang.Object r10 = r9.getKey()
            java.util.Objects.toString(r10)
            java.lang.Object r9 = r9.getValue()
            java.util.Objects.toString(r9)
            goto L_0x00bc
        L_0x006f:
            java.lang.Object r10 = r9.getKey()
            java.lang.String r10 = r10.toString()
            int r10 = r0.a(r10)
            if (r10 <= r2) goto L_0x008c
            java.lang.Object r10 = r9.getKey()
            java.util.Objects.toString(r10)
            java.lang.Object r9 = r9.getValue()
            java.util.Objects.toString(r9)
            goto L_0x00bc
        L_0x008c:
            java.lang.Object r10 = r9.getValue()
            java.lang.String r10 = r10.toString()
            int r10 = r0.a(r10)
            if (r10 <= r2) goto L_0x00a9
            java.lang.Object r10 = r9.getKey()
            java.util.Objects.toString(r10)
            java.lang.Object r9 = r9.getValue()
            java.util.Objects.toString(r9)
            goto L_0x00bc
        L_0x00a9:
            java.lang.Object r10 = r9.getKey()
            java.lang.String r10 = r10.toString()
            java.lang.Object r9 = r9.getValue()
            java.lang.String r9 = r9.toString()
            r1.put(r10, r9)
        L_0x00bc:
            int r4 = r4 + 1
            goto L_0x0052
        L_0x00bf:
            if (r12 == 0) goto L_0x00ef
            java.lang.String r2 = "Too many properties in this event: "
            java.lang.StringBuilder r2 = com.uxcam.internals.hl.a(r2)
            int r12 = r12.size()
            r2.append(r12)
            java.lang.String r12 = ". Limit is "
            r2.append(r12)
            r2.append(r6)
            java.lang.String r12 = "."
            r2.append(r12)
            java.lang.String r12 = r2.toString()
            java.lang.String r2 = "_UXCam_Overload"
            r1.put(r2, r12)
            java.lang.String r2 = "UXCam"
            com.uxcam.internals.gu$ab r2 = com.uxcam.internals.gu.a(r2)
            java.lang.Object[] r4 = new java.lang.Object[r3]
            r2.b(r12, r4)
        L_0x00ef:
            java.util.ArrayList r12 = r0.f13532c
            com.uxcam.internals.bv r0 = new com.uxcam.internals.bv
            com.uxcam.internals.hb r2 = com.uxcam.internals.hb.c()
            java.lang.String r2 = r2.d()
            r0.<init>(r11, r8, r2, r1)
            r12.add(r0)
        L_0x0101:
            r11.getClass()
            int r12 = r11.hashCode()
            r0 = -1
            switch(r12) {
                case -643057588: goto L_0x0124;
                case -67722491: goto L_0x0119;
                case 1306063903: goto L_0x010e;
                default: goto L_0x010c;
            }
        L_0x010c:
            r3 = r0
            goto L_0x012d
        L_0x010e:
            java.lang.String r12 = "UXCam_ForceSessionUpload"
            boolean r11 = r11.equals(r12)
            if (r11 != 0) goto L_0x0117
            goto L_0x010c
        L_0x0117:
            r3 = r7
            goto L_0x012d
        L_0x0119:
            java.lang.String r12 = "UXCam_IgnoreVideoFilters"
            boolean r11 = r11.equals(r12)
            if (r11 != 0) goto L_0x0122
            goto L_0x010c
        L_0x0122:
            r3 = r5
            goto L_0x012d
        L_0x0124:
            java.lang.String r12 = "UXCam_IgnoreDataFilters"
            boolean r11 = r11.equals(r12)
            if (r11 != 0) goto L_0x012d
            goto L_0x010c
        L_0x012d:
            switch(r3) {
                case 0: goto L_0x015c;
                case 1: goto L_0x0159;
                case 2: goto L_0x0131;
                default: goto L_0x0130;
            }
        L_0x0130:
            goto L_0x015e
        L_0x0131:
            f13565h = r5
            java.lang.String r11 = com.uxcam.internals.gm.f13453b
            if (r11 == 0) goto L_0x015e
            boolean r11 = com.uxcam.internals.bi.f13066a
            if (r11 != 0) goto L_0x015e
            com.uxcam.internals.eq r11 = new com.uxcam.internals.eq
            android.content.Context r12 = com.uxcam.internals.ia.f13617c
            r11.<init>(r12)
            java.lang.String r12 = com.uxcam.internals.gm.f13453b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "override_mobile_data_data_only_setting_"
            r0.append(r1)
            r0.append(r12)
            java.lang.String r12 = r0.toString()
            r11.a((java.lang.String) r12, (boolean) r5)
            goto L_0x015e
        L_0x0159:
            com.uxcam.internals.gm.f13470s = r5
            goto L_0x015e
        L_0x015c:
            com.uxcam.internals.gm.f13469r = r5
        L_0x015e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxcam.internals.hm.a(java.lang.String, java.util.Map):void");
    }

    public static void a(SupportMapFragment supportMapFragment) {
        try {
            supportMapFragment.getMapAsync(new k0(supportMapFragment));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public static /* synthetic */ void a(SupportMapFragment supportMapFragment, GoogleMap googleMap) {
        fm.f13368g = googleMap;
        fm.f13367f = new WeakReference(supportMapFragment.getView());
    }

    public static void a(MapFragment mapFragment) {
        try {
            mapFragment.getMapAsync(new j0(mapFragment));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public static /* synthetic */ void a(MapFragment mapFragment, GoogleMap googleMap) {
        fm.f13368g = googleMap;
        fm.f13367f = new WeakReference(mapFragment.getView());
    }

    public static void a(MapView mapView) {
        try {
            mapView.getMapAsync(new i0(mapView));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public static /* synthetic */ void a(MapView mapView, GoogleMap googleMap) {
        fm.f13368g = googleMap;
        fm.f13367f = new WeakReference(mapView);
    }

    public static void a(Throwable th2, Map map) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("exception", (Object) hx.a(th2));
            hb.c().a("", jSONObject, map);
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0063, code lost:
        if (com.uxcam.internals.ia.a(com.uxcam.internals.ia.f13616b, true) == false) goto L_0x006f;
     */
    @android.annotation.SuppressLint({"WrongConstant"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.content.Context r7) {
        /*
            r6 = this;
            java.lang.String r0 = "UXCam 3.4.4[561]"
            boolean r1 = f13574q
            r2 = 0
            if (r1 == 0) goto L_0x0014
            java.lang.String r1 = "UXCam"
            com.uxcam.internals.gu$ab r1 = com.uxcam.internals.gu.a(r1)
            java.lang.Object[] r3 = new java.lang.Object[r2]
            java.lang.String r4 = "UXCam 3.4.4[561] (Warning): Error in integration, UXCam.startWithKey(\"appKey\") is not called on the main thread. See integration docs for instruction."
            r1.b(r4, r3)
        L_0x0014:
            java.lang.String r1 = "hm"
            com.uxcam.internals.gu$ab r1 = com.uxcam.internals.gu.a(r1)
            r1.getClass()
            android.content.pm.PackageManager r1 = r7.getPackageManager()
            r3 = 1
            android.content.ComponentName r4 = new android.content.ComponentName     // Catch:{ NameNotFoundException -> 0x0037 }
            java.lang.String r7 = r7.getPackageName()     // Catch:{ NameNotFoundException -> 0x0037 }
            java.lang.Class<com.uxcam.service.HttpPostService> r5 = com.uxcam.service.HttpPostService.class
            java.lang.String r5 = r5.getName()     // Catch:{ NameNotFoundException -> 0x0037 }
            r4.<init>(r7, r5)     // Catch:{ NameNotFoundException -> 0x0037 }
            r7 = 4
            r1.getServiceInfo(r4, r7)     // Catch:{ NameNotFoundException -> 0x0037 }
            r7 = r2
            goto L_0x0043
        L_0x0037:
            com.uxcam.internals.gu$ab r7 = com.uxcam.internals.gu.a(r0)
            java.lang.Object[] r1 = new java.lang.Object[r2]
            java.lang.String r4 = "HttpPostService service not included in project's manifest"
            r7.b(r4, r1)
            r7 = r3
        L_0x0043:
            com.uxcam.datamodel.UXConfig r1 = e()
            java.lang.String r1 = r1.f12942b
            if (r1 == 0) goto L_0x0057
            com.uxcam.datamodel.UXConfig r1 = e()
            java.lang.String r1 = r1.f12942b
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x005d
        L_0x0057:
            com.uxcam.internals.gu$ab r7 = com.uxcam.internals.gu.f13504c
            r7.getClass()
            r7 = r3
        L_0x005d:
            java.lang.String[] r1 = com.uxcam.internals.ia.f13616b     // Catch:{ Exception -> 0x0066 }
            boolean r1 = com.uxcam.internals.ia.a((java.lang.String[]) r1, (boolean) r3)     // Catch:{ Exception -> 0x0066 }
            if (r1 != 0) goto L_0x0070
            goto L_0x006f
        L_0x0066:
            r7 = move-exception
            r7.getMessage()
            com.uxcam.internals.gu$ab r7 = com.uxcam.internals.gu.f13504c
            r7.getClass()
        L_0x006f:
            r7 = r3
        L_0x0070:
            float r1 = com.uxcam.internals.ia.a()
            r4 = 1120403456(0x42c80000, float:100.0)
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 >= 0) goto L_0x0086
            com.uxcam.internals.gu$ab r7 = com.uxcam.internals.gu.a(r0)
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.String r1 = "Unable to start session due to lack of storage"
            r7.b(r1, r0)
            goto L_0x0087
        L_0x0086:
            r3 = r7
        L_0x0087:
            if (r3 != 0) goto L_0x008a
            return
        L_0x008a:
            java.lang.Exception r7 = new java.lang.Exception
            java.lang.String r0 = "Pre-Condition validation failed"
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxcam.internals.hm.a(android.content.Context):void");
    }

    public void a(String str) {
        String e11 = e(str);
        if (this.f13580e != null) {
            String str2 = this.f13582g.f13612a;
            if (str2 == null || e11 == null || e11.equals(str2)) {
                this.f13582g.f13612a = e11;
                eq eqVar = new eq(this.f13580e);
                String str3 = this.f13582g.f13612a;
                SharedPreferences sharedPreferences = eqVar.f13291a;
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putString("user_id", str3).apply();
                    return;
                }
                return;
            }
            hz hzVar = new hz(e11);
            if (bi.f13066a) {
                f13573p = true;
                f13569l = false;
                f().b(ia.f13617c);
                UXCam.startNewSession();
                hzVar.f13614c = new hz(e11);
            }
            this.f13582g = hzVar;
            return;
        }
        this.f13582g.f13612a = e11;
    }

    public void a(String str, Object obj) {
        if (ia.d() > 0.0f) {
            this.f13577b.f13451a.put(str, obj);
            return;
        }
        gu.a("UXCam.setSessionProperty()").b("UXCam:setSessionProperty: No session is being recorded - session property ‘%s’ will be ignored", str);
    }
}
