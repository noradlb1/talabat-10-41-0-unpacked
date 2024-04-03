package com.uxcam.internals;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Pair;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.uxcam.internals.gu;
import java.io.File;
import java.lang.Thread;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Timer;
import java.util.concurrent.CountDownLatch;
import mz.u;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class gk {

    /* renamed from: f  reason: collision with root package name */
    public static long f13444f;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: g  reason: collision with root package name */
    public static volatile gk f13445g;

    /* renamed from: a  reason: collision with root package name */
    public boolean f13446a = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f13447b = false;

    /* renamed from: c  reason: collision with root package name */
    public Context f13448c;

    /* renamed from: d  reason: collision with root package name */
    public aa f13449d;

    /* renamed from: e  reason: collision with root package name */
    public Timer f13450e;

    public static gk a() {
        if (f13445g == null) {
            synchronized (gk.class) {
                if (f13445g == null) {
                    f13445g = new gk();
                }
            }
        }
        return f13445g;
    }

    public final void b() {
        if (!hm.e().f12945e) {
            HashMap hashMap = new HashMap();
            hashMap.put("where", "ServiceHandler::initializeExceptionHandler");
            hashMap.put("reason", "initializeExceptionHandler() must be called before startWithKey()");
            hu.d("[ CRASH LOGGinG ] Disabled", hashMap);
            return;
        }
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (!(Thread.getDefaultUncaughtExceptionHandler() instanceof hx)) {
            Thread.setDefaultUncaughtExceptionHandler(new hx(defaultUncaughtExceptionHandler));
        }
    }

    public final void c() {
        try {
            gu.ab a11 = gu.a("ANRTicker");
            Arrays.toString(gm.f13475x);
            a11.getClass();
            int[] iArr = gm.f13475x;
            aa aaVar = new aa(iArr[0], iArr[1]);
            this.f13449d = aaVar;
            aaVar.f12952d = new u();
            aaVar.start();
        } catch (Exception e11) {
            fx fxVar = new fx();
            fxVar.a("EXCEPTION");
            fxVar.a("site_of_error", "ServiceHandler::registerANRListener()");
            fxVar.a("reason", e11.getMessage());
            fxVar.a(2);
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x00cf */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x013e A[Catch:{ Exception -> 0x0172 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d() {
        /*
            r15 = this;
            java.lang.String r0 = "arg_which_service"
            java.lang.Class<com.uxcam.service.HttpPostService> r1 = com.uxcam.service.HttpPostService.class
            java.lang.String r2 = "UXCam"
            java.lang.String r3 = "gk"
            boolean r4 = r15.f13447b
            r5 = 1
            if (r4 == 0) goto L_0x000f
            r15.f13446a = r5
        L_0x000f:
            long r6 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x0172 }
            f13444f = r6     // Catch:{ Exception -> 0x0172 }
            r15.b()     // Catch:{ Exception -> 0x0172 }
            android.content.Context r4 = com.uxcam.internals.ia.f13617c     // Catch:{ Exception -> 0x0172 }
            r15.f13448c = r4     // Catch:{ Exception -> 0x0172 }
            com.uxcam.internals.gu$ab r4 = com.uxcam.internals.gu.a(r2)     // Catch:{ Exception -> 0x0172 }
            int r6 = com.uxcam.internals.gm.f13452a     // Catch:{ Exception -> 0x0172 }
            r4.getClass()     // Catch:{ Exception -> 0x0172 }
            java.lang.String r4 = com.uxcam.internals.by.d()     // Catch:{ Exception -> 0x0172 }
            com.uxcam.internals.bj r6 = new com.uxcam.internals.bj     // Catch:{ Exception -> 0x0172 }
            java.lang.String r7 = ""
            r6.<init>(r7)     // Catch:{ Exception -> 0x0172 }
            r6.a((java.lang.String) r4)     // Catch:{ Exception -> 0x0172 }
            java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x0172 }
            java.lang.String r6 = com.uxcam.internals.by.c()     // Catch:{ Exception -> 0x0172 }
            r4.<init>(r6)     // Catch:{ Exception -> 0x0172 }
            boolean r6 = r4.exists()     // Catch:{ Exception -> 0x0172 }
            if (r6 != 0) goto L_0x0045
            r4.mkdirs()     // Catch:{ Exception -> 0x0172 }
        L_0x0045:
            android.content.Context r4 = com.uxcam.internals.ia.c()     // Catch:{ Exception -> 0x0172 }
            java.lang.Class r4 = r4.getClass()     // Catch:{ Exception -> 0x0172 }
            java.lang.String r4 = r4.getSimpleName()     // Catch:{ Exception -> 0x0172 }
            com.uxcam.datamodel.UXConfig r6 = com.uxcam.internals.hm.e()     // Catch:{ Exception -> 0x0172 }
            boolean r6 = r6.f12943c     // Catch:{ Exception -> 0x0172 }
            if (r6 != 0) goto L_0x0076
            java.lang.String r4 = com.uxcam.internals.hb.f13527j     // Catch:{ Exception -> 0x0172 }
            if (r4 == 0) goto L_0x0069
            boolean r4 = r4.isEmpty()     // Catch:{ Exception -> 0x0172 }
            if (r4 != 0) goto L_0x0069
            java.lang.String r4 = com.uxcam.internals.hb.f13527j     // Catch:{ Exception -> 0x0172 }
            r6 = 0
            com.uxcam.internals.hb.f13527j = r6     // Catch:{ Exception -> 0x0172 }
            goto L_0x0076
        L_0x0069:
            java.lang.String r4 = com.uxcam.internals.hb.f13528k     // Catch:{ Exception -> 0x0172 }
            boolean r4 = r4.isEmpty()     // Catch:{ Exception -> 0x0172 }
            if (r4 == 0) goto L_0x0074
            java.lang.String r4 = "unknown"
            goto L_0x0076
        L_0x0074:
            java.lang.String r4 = com.uxcam.internals.hb.f13528k     // Catch:{ Exception -> 0x0172 }
        L_0x0076:
            com.uxcam.internals.hb r6 = com.uxcam.internals.hb.c()     // Catch:{ Exception -> 0x0172 }
            android.content.Context r7 = r15.f13448c     // Catch:{ Exception -> 0x0172 }
            r8 = 0
            r6.a((android.content.Context) r7, (java.lang.String) r4, (boolean) r8)     // Catch:{ Exception -> 0x0172 }
            com.uxcam.internals.gu$ab r4 = com.uxcam.internals.gu.a(r3)     // Catch:{ Exception -> 0x0172 }
            r4.getClass()     // Catch:{ Exception -> 0x0172 }
            com.uxcam.internals.gu$ab r4 = com.uxcam.internals.gu.a(r2)     // Catch:{ Exception -> 0x0172 }
            java.lang.String r6 = "UXCam 3.4.4[561] : Application key is verified, UXCam has started capturing data as per configuration from UXCam settings page."
            java.lang.Object[] r7 = new java.lang.Object[r8]     // Catch:{ Exception -> 0x0172 }
            r4.b(r6, r7)     // Catch:{ Exception -> 0x0172 }
            boolean r4 = com.uxcam.internals.gm.B     // Catch:{ Exception -> 0x0172 }
            if (r4 == 0) goto L_0x00ab
            java.util.Timer r4 = new java.util.Timer     // Catch:{ Exception -> 0x0172 }
            r4.<init>()     // Catch:{ Exception -> 0x0172 }
            r15.f13450e = r4     // Catch:{ Exception -> 0x0172 }
            com.uxcam.internals.gj r10 = new com.uxcam.internals.gj     // Catch:{ Exception -> 0x0172 }
            r10.<init>(r15)     // Catch:{ Exception -> 0x0172 }
            java.util.Timer r9 = r15.f13450e     // Catch:{ Exception -> 0x0172 }
            r11 = 0
            r13 = 1000(0x3e8, double:4.94E-321)
            r9.schedule(r10, r11, r13)     // Catch:{ Exception -> 0x0172 }
        L_0x00ab:
            boolean r4 = com.uxcam.internals.gm.f13457f     // Catch:{ Exception -> 0x0172 }
            if (r4 == 0) goto L_0x0122
            boolean r4 = com.uxcam.internals.fn.f13376g     // Catch:{ Exception -> 0x0172 }
            if (r4 == 0) goto L_0x00d9
            com.uxcam.internals.gi r4 = com.uxcam.internals.fn.f13377h     // Catch:{ Exception -> 0x0172 }
            if (r4 == 0) goto L_0x00d9
            com.uxcam.internals.dg r4 = com.uxcam.internals.fn.f13375f     // Catch:{ Exception -> 0x0172 }
            r4.clear()     // Catch:{ Exception -> 0x0172 }
            com.uxcam.internals.bq r4 = new com.uxcam.internals.bq     // Catch:{ Exception -> 0x0172 }
            com.uxcam.internals.gi r6 = com.uxcam.internals.fn.f13377h     // Catch:{ Exception -> 0x0172 }
            r4.<init>(r6)     // Catch:{ Exception -> 0x0172 }
            com.uxcam.internals.bq.f13084d = r8     // Catch:{ Exception -> 0x0172 }
            com.uxcam.internals.fm.f13362a = r8     // Catch:{ Exception -> 0x0172 }
            com.uxcam.internals.fn.f13376g = r8     // Catch:{ Exception -> 0x0172 }
            com.uxcam.internals.gi r4 = com.uxcam.internals.fn.f13377h     // Catch:{ IOException -> 0x00cf }
            r4.a()     // Catch:{ IOException -> 0x00cf }
            goto L_0x00d6
        L_0x00cf:
            com.uxcam.internals.gu$ab r4 = com.uxcam.internals.gu.a(r3)     // Catch:{ Exception -> 0x0172 }
            r4.getClass()     // Catch:{ Exception -> 0x0172 }
        L_0x00d6:
            com.uxcam.internals.fn.h()     // Catch:{ Exception -> 0x0172 }
        L_0x00d9:
            com.uxcam.internals.fn.f13376g = r8     // Catch:{ Exception -> 0x0172 }
            com.uxcam.internals.gu$ab r2 = com.uxcam.internals.gu.a(r2)     // Catch:{ Exception -> 0x0172 }
            r2.getClass()     // Catch:{ Exception -> 0x0172 }
            com.uxcam.internals.fn r2 = com.uxcam.internals.fn.b()     // Catch:{ Exception -> 0x0172 }
            if (r2 == 0) goto L_0x0105
            com.uxcam.internals.bq.f13084d = r5     // Catch:{ Exception -> 0x0172 }
            boolean r4 = com.uxcam.internals.fn.f13388s     // Catch:{ Exception -> 0x0172 }
            if (r4 != 0) goto L_0x0122
            boolean r4 = com.uxcam.internals.fn.f13374e     // Catch:{ Exception -> 0x0172 }
            if (r4 == 0) goto L_0x00f3
            goto L_0x0122
        L_0x00f3:
            com.uxcam.internals.fn.f13374e = r5     // Catch:{ Exception -> 0x0172 }
            java.util.Timer r9 = com.uxcam.internals.fn.f13373d     // Catch:{ Exception -> 0x0172 }
            com.uxcam.internals.fr r10 = new com.uxcam.internals.fr     // Catch:{ Exception -> 0x0172 }
            r10.<init>(r2)     // Catch:{ Exception -> 0x0172 }
            int r2 = com.uxcam.internals.fn.f13387r     // Catch:{ Exception -> 0x0172 }
            long r13 = (long) r2     // Catch:{ Exception -> 0x0172 }
            r11 = 0
            r9.schedule(r10, r11, r13)     // Catch:{ Exception -> 0x0172 }
            goto L_0x0122
        L_0x0105:
            com.uxcam.internals.fx r2 = new com.uxcam.internals.fx     // Catch:{ Exception -> 0x0172 }
            r2.<init>()     // Catch:{ Exception -> 0x0172 }
            java.lang.String r4 = "Exception"
            com.uxcam.internals.fx r2 = r2.a((java.lang.String) r4)     // Catch:{ Exception -> 0x0172 }
            java.lang.String r4 = "ServiceHandler::startUxcamService()"
            java.lang.String r6 = "site_of_error"
            r2.a((java.lang.String) r6, (java.lang.String) r4)     // Catch:{ Exception -> 0x0172 }
            java.lang.String r4 = "ScreenVideoHandler is null, not starting video capture."
            java.lang.String r6 = "reason"
            r2.a((java.lang.String) r6, (java.lang.String) r4)     // Catch:{ Exception -> 0x0172 }
            r4 = 2
            r2.a((int) r4)     // Catch:{ Exception -> 0x0172 }
        L_0x0122:
            android.content.Context r2 = r15.f13448c     // Catch:{ Exception -> 0x0172 }
            org.json.JSONObject r2 = com.uxcam.internals.ia.d((android.content.Context) r2)     // Catch:{ Exception -> 0x0172 }
            if (r2 == 0) goto L_0x012c
            com.uxcam.internals.gm.J = r2     // Catch:{ Exception -> 0x0172 }
        L_0x012c:
            boolean r2 = android.os.Debug.isDebuggerConnected()     // Catch:{ Exception -> 0x0172 }
            if (r2 != 0) goto L_0x013b
            boolean r2 = android.os.Debug.waitingForDebugger()     // Catch:{ Exception -> 0x0172 }
            if (r2 == 0) goto L_0x0139
            goto L_0x013b
        L_0x0139:
            r2 = r8
            goto L_0x013c
        L_0x013b:
            r2 = r5
        L_0x013c:
            if (r2 != 0) goto L_0x014f
            int[] r2 = com.uxcam.internals.gm.f13475x     // Catch:{ Exception -> 0x0172 }
            r4 = r2[r8]     // Catch:{ Exception -> 0x0172 }
            if (r4 <= 0) goto L_0x014f
            r2 = r2[r5]     // Catch:{ Exception -> 0x0172 }
            if (r2 <= 0) goto L_0x014f
            com.uxcam.internals.aa r2 = r15.f13449d     // Catch:{ Exception -> 0x0172 }
            if (r2 != 0) goto L_0x014f
            r15.c()     // Catch:{ Exception -> 0x0172 }
        L_0x014f:
            android.content.Intent r2 = new android.content.Intent     // Catch:{ Exception -> 0x0172 }
            android.content.Context r4 = r15.f13448c     // Catch:{ Exception -> 0x0172 }
            r2.<init>(r4, r1)     // Catch:{ Exception -> 0x0172 }
            java.lang.String r4 = "send_offline_data"
            r2.putExtra(r0, r4)     // Catch:{ Exception -> 0x0172 }
            android.content.Context r4 = r15.f13448c     // Catch:{ Exception -> 0x0172 }
            r4.startService(r2)     // Catch:{ Exception -> 0x0172 }
            android.content.Intent r2 = new android.content.Intent     // Catch:{ Exception -> 0x0172 }
            android.content.Context r4 = r15.f13448c     // Catch:{ Exception -> 0x0172 }
            r2.<init>(r4, r1)     // Catch:{ Exception -> 0x0172 }
            java.lang.String r1 = "stop_foreground"
            r2.putExtra(r0, r1)     // Catch:{ Exception -> 0x0172 }
            android.content.Context r0 = r15.f13448c     // Catch:{ Exception -> 0x0172 }
            r0.startService(r2)     // Catch:{ Exception -> 0x0172 }
            goto L_0x0179
        L_0x0172:
            com.uxcam.internals.gu$ab r0 = com.uxcam.internals.gu.a(r3)
            r0.getClass()
        L_0x0179:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxcam.internals.gk.d():void");
    }

    public static void a(Pair pair, long j11) {
        if (pair != null) {
            float f11 = ((float) j11) / 1000.0f;
            try {
                float parseFloat = Float.parseFloat(String.format(Locale.ENGLISH, "%.3f", new Object[]{Float.valueOf(ia.d())}));
                JSONObject jSONObject = ((JSONArray) pair.first).getJSONObject(0);
                String str = (String) pair.second;
                if ((!(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject)).contains("com.uxcam.internals")) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("duration", String.valueOf(f11));
                    hashMap.put("stacktrace", !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject));
                    hu.a(AnalyticsAttribute.ANR, hashMap);
                    return;
                }
                hb c11 = hb.c();
                int length = c11.f13534e.length();
                HashMap hashMap2 = new HashMap();
                hashMap2.put("duration", Float.valueOf(f11));
                hashMap2.put("screen", hb.c().d());
                hashMap2.put("topOfStack", str);
                hashMap2.put("timeStamp", Long.valueOf(System.currentTimeMillis()));
                hashMap2.put("anrNumber", Integer.valueOf(length));
                c11.a(AnalyticsAttribute.ANR, parseFloat, (Map) hashMap2);
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("duration", (double) f11);
                    jSONObject2.put("stacktrace", (Object) jSONObject);
                    jSONObject2.put("screen", (Object) hb.c().d());
                    jSONObject2.put("topOfStack", (Object) str);
                    jSONObject2.put("timeStamp", System.currentTimeMillis());
                    jSONObject2.put("anrNumber", length);
                    c11.f13534e.put((Object) jSONObject2);
                } catch (JSONException e11) {
                    e11.printStackTrace();
                }
            } catch (JSONException e12) {
                e12.printStackTrace();
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:24|(1:26)|27|28|29|30|31|(1:33)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.content.Context r14, java.lang.String r15) {
        /*
            r13 = this;
            java.lang.String r0 = "gk"
            r1 = 1
            r13.f13447b = r1
            r2 = 0
            boolean r3 = r15.isEmpty()     // Catch:{ Exception -> 0x00dd }
            r3 = r3 ^ r1
            com.uxcam.internals.bi.f13066a = r2     // Catch:{ Exception -> 0x00dd }
            java.util.Timer r4 = r13.f13450e     // Catch:{ Exception -> 0x00dd }
            r5 = 0
            if (r4 == 0) goto L_0x0017
            r4.cancel()     // Catch:{ Exception -> 0x00dd }
            r13.f13450e = r5     // Catch:{ Exception -> 0x00dd }
        L_0x0017:
            com.uxcam.internals.aa r4 = r13.f13449d     // Catch:{ Exception -> 0x00dd }
            if (r4 == 0) goto L_0x001d
            r4.f12958j = r2     // Catch:{ Exception -> 0x00dd }
        L_0x001d:
            r13.f13449d = r5     // Catch:{ Exception -> 0x00dd }
            com.uxcam.internals.fn.f13381l = r5     // Catch:{ Exception -> 0x00dd }
            com.uxcam.internals.fm.f13366e = r2     // Catch:{ Exception -> 0x00dd }
            boolean r4 = com.uxcam.internals.hm.f13565h     // Catch:{ Exception -> 0x00dd }
            if (r4 == 0) goto L_0x0046
            com.uxcam.internals.eq r4 = new com.uxcam.internals.eq     // Catch:{ Exception -> 0x00dd }
            android.content.Context r5 = r13.f13448c     // Catch:{ Exception -> 0x00dd }
            r4.<init>(r5)     // Catch:{ Exception -> 0x00dd }
            java.lang.String r5 = com.uxcam.internals.gm.f13453b     // Catch:{ Exception -> 0x00dd }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00dd }
            r6.<init>()     // Catch:{ Exception -> 0x00dd }
            java.lang.String r7 = "override_mobile_data_data_only_setting_"
            r6.append(r7)     // Catch:{ Exception -> 0x00dd }
            r6.append(r5)     // Catch:{ Exception -> 0x00dd }
            java.lang.String r5 = r6.toString()     // Catch:{ Exception -> 0x00dd }
            r4.a((java.lang.String) r5, (boolean) r1)     // Catch:{ Exception -> 0x00dd }
            com.uxcam.internals.hm.f13565h = r2     // Catch:{ Exception -> 0x00dd }
        L_0x0046:
            com.uxcam.internals.gu$ab r4 = com.uxcam.internals.gu.a(r0)     // Catch:{ Exception -> 0x00dd }
            r4.getClass()     // Catch:{ Exception -> 0x00dd }
            boolean r4 = com.uxcam.internals.gm.f13457f     // Catch:{ Exception -> 0x00dd }
            if (r4 == 0) goto L_0x00d0
            com.uxcam.internals.eq r4 = new com.uxcam.internals.eq     // Catch:{ Exception -> 0x00dd }
            android.content.Context r5 = r13.f13448c     // Catch:{ Exception -> 0x00dd }
            r4.<init>(r5)     // Catch:{ Exception -> 0x00dd }
            android.content.SharedPreferences r5 = r4.f13291a     // Catch:{ Exception -> 0x00dd }
            java.lang.String r6 = "recorded_video_count"
            if (r5 != 0) goto L_0x0060
            r5 = r2
            goto L_0x0064
        L_0x0060:
            int r5 = r5.getInt(r6, r2)     // Catch:{ Exception -> 0x00dd }
        L_0x0064:
            int r5 = r5 + r1
            android.content.SharedPreferences r4 = r4.f13291a     // Catch:{ Exception -> 0x00dd }
            if (r4 == 0) goto L_0x0074
            android.content.SharedPreferences$Editor r4 = r4.edit()     // Catch:{ Exception -> 0x00dd }
            android.content.SharedPreferences$Editor r4 = r4.putInt(r6, r5)     // Catch:{ Exception -> 0x00dd }
            r4.apply()     // Catch:{ Exception -> 0x00dd }
        L_0x0074:
            java.util.concurrent.CountDownLatch r10 = new java.util.concurrent.CountDownLatch     // Catch:{ Exception -> 0x00dd }
            r10.<init>(r1)     // Catch:{ Exception -> 0x00dd }
            com.uxcam.internals.fn r11 = com.uxcam.internals.fn.b()     // Catch:{ Exception -> 0x00dd }
            if (r11 == 0) goto L_0x00b2
            mz.t r12 = new mz.t     // Catch:{ Exception -> 0x00dd }
            r4 = r12
            r5 = r13
            r6 = r10
            r7 = r15
            r8 = r3
            r9 = r14
            r4.<init>(r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x00dd }
            r11.f13391c = r12     // Catch:{ Exception -> 0x00dd }
            com.uxcam.internals.fn.f13378i = r2     // Catch:{ Exception -> 0x00dd }
            com.uxcam.internals.fn.f13376g = r1     // Catch:{ Exception -> 0x00dd }
            boolean r1 = com.uxcam.internals.fn.f13388s     // Catch:{ Exception -> 0x00dd }
            if (r1 != 0) goto L_0x0099
            com.uxcam.internals.gi r1 = com.uxcam.internals.fn.f13377h     // Catch:{ Exception -> 0x00dd }
            r11.a(r1)     // Catch:{ Exception -> 0x00dd }
        L_0x0099:
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ InterruptedException -> 0x00a1 }
            r4 = 10
            r10.await(r4, r1)     // Catch:{ InterruptedException -> 0x00a1 }
            goto L_0x00a8
        L_0x00a1:
            com.uxcam.internals.gu$ab r1 = com.uxcam.internals.gu.a(r0)     // Catch:{ Exception -> 0x00dd }
            r1.getClass()     // Catch:{ Exception -> 0x00dd }
        L_0x00a8:
            boolean r1 = r15.isEmpty()     // Catch:{ Exception -> 0x00dd }
            if (r1 != 0) goto L_0x00d3
            r13.a(r15, r3, r14)     // Catch:{ Exception -> 0x00dd }
            goto L_0x00d3
        L_0x00b2:
            com.uxcam.internals.fx r14 = new com.uxcam.internals.fx     // Catch:{ Exception -> 0x00dd }
            r14.<init>()     // Catch:{ Exception -> 0x00dd }
            java.lang.String r15 = "Exception"
            com.uxcam.internals.fx r14 = r14.a((java.lang.String) r15)     // Catch:{ Exception -> 0x00dd }
            java.lang.String r15 = "ServiceHandler::stopUxcamService()"
            java.lang.String r1 = "site_of_error"
            r14.a((java.lang.String) r1, (java.lang.String) r15)     // Catch:{ Exception -> 0x00dd }
            java.lang.String r15 = "ScreenVideoHandler is null, cannot stop video and upload."
            java.lang.String r1 = "reason"
            r14.a((java.lang.String) r1, (java.lang.String) r15)     // Catch:{ Exception -> 0x00dd }
            r15 = 2
            r14.a((int) r15)     // Catch:{ Exception -> 0x00dd }
            goto L_0x00d3
        L_0x00d0:
            r13.a(r15, r3, r14)     // Catch:{ Exception -> 0x00dd }
        L_0x00d3:
            com.uxcam.internals.gm.A = r2     // Catch:{ Exception -> 0x00dd }
            com.uxcam.internals.gu$ab r14 = com.uxcam.internals.gu.a(r0)     // Catch:{ Exception -> 0x00dd }
            r14.getClass()     // Catch:{ Exception -> 0x00dd }
            goto L_0x00e4
        L_0x00dd:
            com.uxcam.internals.gu$ab r14 = com.uxcam.internals.gu.a(r0)
            r14.getClass()
        L_0x00e4:
            r13.f13447b = r2
            boolean r14 = r13.f13446a
            if (r14 == 0) goto L_0x00ef
            r13.f13446a = r2
            r13.d()
        L_0x00ef:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxcam.internals.gk.a(android.content.Context, java.lang.String):void");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(CountDownLatch countDownLatch, String str, boolean z11, Context context) {
        gu.a("gk").getClass();
        countDownLatch.countDown();
        if (str.isEmpty()) {
            a(str, z11, context);
        }
    }

    public final void a(String str, boolean z11, Context context) {
        try {
            int i11 = gm.f13452a;
            File a11 = new bj(str).a();
            gu.a("gk").getClass();
            if (a11 != null && !z11) {
                new ae().b(context, a11);
            }
        } catch (Exception e11) {
            fx fxVar = new fx();
            fxVar.a("EXCEPTION");
            fxVar.a("site_of_error", "ServiceHandler::endAndUploadDataFile()");
            fxVar.a("reason", e11.getMessage());
            fxVar.a(2);
        }
    }
}
