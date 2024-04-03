package com.apptimize;

import android.content.Context;
import android.util.Log;
import com.huawei.hms.flutter.map.constants.Param;
import com.newrelic.agent.android.instrumentation.Instrumented;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class br {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f41442a = "br";

    /* renamed from: b  reason: collision with root package name */
    private static au f41443b = null;

    /* renamed from: c  reason: collision with root package name */
    private static Context f41444c = null;

    /* renamed from: d  reason: collision with root package name */
    private static dt f41445d = null;

    /* renamed from: e  reason: collision with root package name */
    private static gr f41446e = null;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static boolean f41447f = false;

    /* renamed from: g  reason: collision with root package name */
    private static boolean f41448g = false;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public static long f41449h;

    /* renamed from: i  reason: collision with root package name */
    private static Timer f41450i;

    /* renamed from: j  reason: collision with root package name */
    private static OutputStreamWriter f41451j;

    /* renamed from: k  reason: collision with root package name */
    private static int f41452k;

    /* renamed from: l  reason: collision with root package name */
    private static int f41453l;

    public static void b() {
        a("disconnecting");
        f41447f = false;
        OutputStreamWriter outputStreamWriter = f41451j;
        if (outputStreamWriter != null) {
            try {
                outputStreamWriter.close();
            } catch (IOException unused) {
            } catch (Throwable th2) {
                f41451j = null;
                throw th2;
            }
            f41451j = null;
        }
    }

    public static void c() {
        f41449h = 0;
    }

    public static void d() {
        cc r11;
        if (av.f41240c && f41447f) {
            Log.i(f41442a, "LocalLog logStatus");
            if (!f41448g && (r11 = f41445d.r()) != null) {
                try {
                    a("mp", r11.a());
                    f41448g = true;
                } catch (JSONException unused) {
                }
            }
            ed y11 = f41445d.y();
            if (y11 != null) {
                a("ProcessedMetaData", y11.a());
            }
            f41446e.b().a();
        }
    }

    public static /* synthetic */ long h() {
        long j11 = f41449h + 1;
        f41449h = j11;
        return j11;
    }

    public static void a(au auVar, Context context, dt dtVar, gr grVar) {
        if (av.f41240c) {
            f41443b = auVar;
            f41444c = context;
            f41445d = dtVar;
            f41446e = grVar;
            if (f41450i == null) {
                Timer timer = new Timer();
                f41450i = timer;
                timer.schedule(new TimerTask() {
                    public void run() {
                        String e11 = br.f41442a;
                        Log.i(e11, "LocalLog timer:" + br.f41449h + " connected:" + br.f41447f);
                        if (av.f41240c && br.f41447f && br.h() == 2) {
                            br.d();
                            long unused = br.f41449h = 2;
                            String e12 = br.f41442a;
                            Log.i(e12, "LocalLog timer set to 2:" + br.f41449h);
                        }
                    }
                }, 1000, 1000);
            }
        }
    }

    public static void b(String str, Object obj) {
        b(str, obj, (Object) null, (Object[]) null);
    }

    public static void b(String str, Object obj, Object obj2, Object[] objArr) {
        String str2;
        if (av.f41240c && f41447f) {
            if (obj == null) {
                str2 = "null";
            } else {
                str2 = obj.toString();
            }
            if (!str2.contains("java.lang.Thread.getStackTrace") && !str2.contains("java.lang.Throwable.getInternalStackTrace")) {
                try {
                    JSONObject put = new JSONObject().put(str, (Object) obj.toString()).put("stack", (Object) Arrays.toString(Thread.currentThread().getStackTrace()));
                    if (obj2 != null) {
                        put.put("o", (Object) obj2.toString());
                    }
                    if (objArr != null) {
                        for (int i11 = 0; i11 < objArr.length; i11++) {
                            if (objArr[i11] != null) {
                                put.put("v" + i11, (Object) objArr[i11].toString());
                            }
                        }
                    }
                    a(Param.X, put);
                } catch (JSONException unused) {
                    a(Param.X, new JSONObject());
                }
            }
        }
    }

    public static void a() {
        f41447f = true;
    }

    public static void a(String str, Object obj) {
        a(str, obj, (Object) null, (Object[]) null);
    }

    public static void a(String str, Object obj, Object obj2, Object[] objArr) {
        String str2;
        if (av.f41240c && f41447f) {
            if (obj == null) {
                str2 = "null";
            } else {
                str2 = obj.toString();
            }
            if (!str2.contains("java.lang.Thread.getStackTrace") && !str2.contains("java.lang.Throwable.getInternalStackTrace")) {
                try {
                    JSONObject put = new JSONObject().put(str, (Object) obj.toString());
                    if (obj2 != null) {
                        put.put("o", (Object) obj2.toString());
                    }
                    if (objArr != null) {
                        for (int i11 = 0; i11 < objArr.length; i11++) {
                            if (objArr[i11] != null) {
                                put.put("v" + i11, (Object) objArr[i11].toString());
                            }
                        }
                    }
                    a(Param.X, put);
                } catch (JSONException unused) {
                    a(Param.X, new JSONObject());
                }
            }
        }
    }

    public static void a(String str) {
        if (av.f41240c && f41447f) {
            try {
                a(Param.X, new JSONObject().put("message", (Object) str).put("stack", (Object) Arrays.toString(Thread.currentThread().getStackTrace())));
            } catch (JSONException unused) {
                a(Param.X, new JSONObject());
            }
        }
    }

    public static void a(String str, List<dc> list) {
        if (av.f41240c && f41447f) {
            try {
                JSONArray jSONArray = new JSONArray();
                for (dc a11 : list) {
                    jSONArray.put((Object) a11.a());
                }
                a(Param.X, new JSONObject().put("logStyles", (Object) str).put("stack", (Object) Arrays.toString(Thread.currentThread().getStackTrace())).put("styles", (Object) jSONArray));
            } catch (JSONException unused) {
                a(Param.X, new JSONObject());
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0141, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0143, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void a(java.lang.String r7, org.json.JSONObject r8) {
        /*
            java.lang.Class<com.apptimize.br> r0 = com.apptimize.br.class
            monitor-enter(r0)
            boolean r1 = com.apptimize.av.f41240c     // Catch:{ all -> 0x0144 }
            if (r1 == 0) goto L_0x0142
            boolean r1 = f41447f     // Catch:{ all -> 0x0144 }
            if (r1 == 0) goto L_0x0142
            android.content.Context r1 = f41444c     // Catch:{ all -> 0x0144 }
            if (r1 != 0) goto L_0x0011
            goto L_0x0142
        L_0x0011:
            java.io.OutputStreamWriter r1 = f41451j     // Catch:{ all -> 0x0144 }
            r2 = 1
            if (r1 != 0) goto L_0x00a0
            java.lang.String r1 = f41442a     // Catch:{ Exception -> 0x0098 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0098 }
            r3.<init>()     // Catch:{ Exception -> 0x0098 }
            java.lang.String r4 = "directory: "
            r3.append(r4)     // Catch:{ Exception -> 0x0098 }
            android.content.Context r4 = f41444c     // Catch:{ Exception -> 0x0098 }
            java.io.File r4 = r4.getFilesDir()     // Catch:{ Exception -> 0x0098 }
            java.lang.String r4 = r4.getAbsolutePath()     // Catch:{ Exception -> 0x0098 }
            r3.append(r4)     // Catch:{ Exception -> 0x0098 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0098 }
            com.apptimize.bo.m(r1, r3)     // Catch:{ Exception -> 0x0098 }
            java.io.File r1 = new java.io.File     // Catch:{ Exception -> 0x0098 }
            android.content.Context r3 = f41444c     // Catch:{ Exception -> 0x0098 }
            java.io.File r3 = r3.getFilesDir()     // Catch:{ Exception -> 0x0098 }
            java.lang.String r3 = r3.getAbsolutePath()     // Catch:{ Exception -> 0x0098 }
            java.lang.String r4 = "log.txt"
            r1.<init>(r3, r4)     // Catch:{ Exception -> 0x0098 }
            java.io.OutputStreamWriter r3 = new java.io.OutputStreamWriter     // Catch:{ Exception -> 0x0098 }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0098 }
            r4.<init>(r1, r2)     // Catch:{ Exception -> 0x0098 }
            java.lang.String r5 = "UTF-8"
            r3.<init>(r4, r5)     // Catch:{ Exception -> 0x0098 }
            f41451j = r3     // Catch:{ Exception -> 0x0098 }
            java.io.PrintStream r3 = java.lang.System.out     // Catch:{ Exception -> 0x0098 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0098 }
            r4.<init>()     // Catch:{ Exception -> 0x0098 }
            java.lang.String r5 = "Created msgWriter "
            r4.append(r5)     // Catch:{ Exception -> 0x0098 }
            java.io.OutputStreamWriter r5 = f41451j     // Catch:{ Exception -> 0x0098 }
            r4.append(r5)     // Catch:{ Exception -> 0x0098 }
            java.lang.String r5 = " file:"
            r4.append(r5)     // Catch:{ Exception -> 0x0098 }
            r4.append(r1)     // Catch:{ Exception -> 0x0098 }
            java.lang.String r1 = r4.toString()     // Catch:{ Exception -> 0x0098 }
            r3.println(r1)     // Catch:{ Exception -> 0x0098 }
            com.apptimize.au r1 = f41443b     // Catch:{ Exception -> 0x0098 }
            com.apptimize.ak r1 = r1.d()     // Catch:{ Exception -> 0x0098 }
            int r1 = r1.h()     // Catch:{ Exception -> 0x0098 }
            f41453l = r1     // Catch:{ Exception -> 0x0098 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0098 }
            r1.<init>()     // Catch:{ Exception -> 0x0098 }
            java.lang.String r3 = "connected pid:"
            r1.append(r3)     // Catch:{ Exception -> 0x0098 }
            int r3 = f41453l     // Catch:{ Exception -> 0x0098 }
            r1.append(r3)     // Catch:{ Exception -> 0x0098 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0098 }
            a((java.lang.String) r1)     // Catch:{ Exception -> 0x0098 }
            goto L_0x00a0
        L_0x0098:
            r1 = move-exception
            java.lang.String r3 = f41442a     // Catch:{ all -> 0x0144 }
            java.lang.String r4 = "Created msgWriter error: "
            com.apptimize.bo.j(r3, r4, r1)     // Catch:{ all -> 0x0144 }
        L_0x00a0:
            java.io.OutputStreamWriter r1 = f41451j     // Catch:{ all -> 0x0144 }
            if (r1 == 0) goto L_0x012b
            boolean r1 = r8 instanceof org.json.JSONObject     // Catch:{ JSONException -> 0x010c }
            r3 = 4
            if (r1 != 0) goto L_0x00ae
            java.lang.String r1 = r8.toString(r3)     // Catch:{ JSONException -> 0x010c }
            goto L_0x00b2
        L_0x00ae:
            java.lang.String r1 = com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation.toString(r8, r3)     // Catch:{ JSONException -> 0x010c }
        L_0x00b2:
            java.lang.String r3 = "\\r?\\n"
            java.lang.String[] r1 = r1.split(r3)     // Catch:{ JSONException -> 0x010c }
            r3 = 0
        L_0x00b9:
            int r4 = r1.length     // Catch:{ JSONException -> 0x010c }
            if (r3 >= r4) goto L_0x0106
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x010c }
            r4.<init>()     // Catch:{ JSONException -> 0x010c }
            java.lang.String r5 = "<"
            r4.append(r5)     // Catch:{ JSONException -> 0x010c }
            r4.append(r7)     // Catch:{ JSONException -> 0x010c }
            int r5 = f41453l     // Catch:{ JSONException -> 0x010c }
            r4.append(r5)     // Catch:{ JSONException -> 0x010c }
            java.lang.String r5 = "-"
            r4.append(r5)     // Catch:{ JSONException -> 0x010c }
            int r5 = f41452k     // Catch:{ JSONException -> 0x010c }
            r4.append(r5)     // Catch:{ JSONException -> 0x010c }
            java.lang.String r5 = "> "
            r4.append(r5)     // Catch:{ JSONException -> 0x010c }
            r5 = r1[r3]     // Catch:{ JSONException -> 0x010c }
            r4.append(r5)     // Catch:{ JSONException -> 0x010c }
            java.lang.String r4 = r4.toString()     // Catch:{ JSONException -> 0x010c }
            int r5 = f41452k     // Catch:{ JSONException -> 0x010c }
            int r5 = r5 + r2
            f41452k = r5     // Catch:{ JSONException -> 0x010c }
            java.io.OutputStreamWriter r5 = f41451j     // Catch:{ JSONException -> 0x010c }
            if (r5 == 0) goto L_0x0103
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0103 }
            r6.<init>()     // Catch:{ Exception -> 0x0103 }
            r6.append(r4)     // Catch:{ Exception -> 0x0103 }
            java.lang.String r4 = "\n"
            r6.append(r4)     // Catch:{ Exception -> 0x0103 }
            java.lang.String r4 = r6.toString()     // Catch:{ Exception -> 0x0103 }
            r5.write(r4)     // Catch:{ Exception -> 0x0103 }
        L_0x0103:
            int r3 = r3 + 1
            goto L_0x00b9
        L_0x0106:
            java.io.OutputStreamWriter r8 = f41451j     // Catch:{ Exception -> 0x012b }
            r8.flush()     // Catch:{ Exception -> 0x012b }
            goto L_0x012b
        L_0x010c:
            r1 = move-exception
            java.lang.String r3 = f41442a     // Catch:{ all -> 0x0144 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0144 }
            r4.<init>()     // Catch:{ all -> 0x0144 }
            java.lang.String r5 = "JSON log ERROR ("
            r4.append(r5)     // Catch:{ all -> 0x0144 }
            r4.append(r7)     // Catch:{ all -> 0x0144 }
            java.lang.String r5 = ") "
            r4.append(r5)     // Catch:{ all -> 0x0144 }
            r4.append(r8)     // Catch:{ all -> 0x0144 }
            java.lang.String r8 = r4.toString()     // Catch:{ all -> 0x0144 }
            com.apptimize.bo.j(r3, r8, r1)     // Catch:{ all -> 0x0144 }
        L_0x012b:
            java.lang.String r8 = "m"
            boolean r8 = r7.startsWith(r8)     // Catch:{ all -> 0x0144 }
            if (r8 == 0) goto L_0x0135
            f41448g = r2     // Catch:{ all -> 0x0144 }
        L_0x0135:
            java.lang.String r8 = "v"
            boolean r7 = r7.startsWith(r8)     // Catch:{ all -> 0x0144 }
            if (r7 != 0) goto L_0x0140
            c()     // Catch:{ all -> 0x0144 }
        L_0x0140:
            monitor-exit(r0)
            return
        L_0x0142:
            monitor-exit(r0)
            return
        L_0x0144:
            r7 = move-exception
            monitor-exit(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.br.a(java.lang.String, org.json.JSONObject):void");
    }
}
