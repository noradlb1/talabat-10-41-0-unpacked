package com.apptimize;

import android.os.StrictMode;
import com.apptimize.bd;
import com.google.android.exoplayer2.ExoPlayer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ec {

    /* renamed from: a  reason: collision with root package name */
    public static a<JSONObject> f42220a = new a<JSONObject>() {
        /* renamed from: a */
        public JSONObject b(String str) throws JSONException {
            return new JSONObject(str);
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public static a<JSONArray> f42221b = new a<JSONArray>() {
        /* renamed from: a */
        public JSONArray b(String str) throws JSONException {
            return new JSONArray(str);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    public static a<Long> f42222c = new a<Long>() {
        /* renamed from: a */
        public Long b(String str) throws NumberFormatException {
            return Long.valueOf(str);
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private final String f42223d = ec.class.getSimpleName();

    /* renamed from: e  reason: collision with root package name */
    private final bd.a f42224e;

    /* renamed from: f  reason: collision with root package name */
    private final fo f42225f;

    /* renamed from: g  reason: collision with root package name */
    private final au f42226g;

    /* renamed from: h  reason: collision with root package name */
    private List<c<?>> f42227h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    private AtomicBoolean f42228i = new AtomicBoolean(false);

    /* renamed from: j  reason: collision with root package name */
    private final ao f42229j;

    public interface a<T> {
        T b(String str) throws JSONException, NumberFormatException;
    }

    public static abstract class b<T> {
        public abstract String a();

        public abstract void a(T t11) throws JSONException;

        public boolean c() {
            return false;
        }

        public abstract T d() throws JSONException;
    }

    public static class c<T> {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public b<T> f42234a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public a<T> f42235b;

        private c() {
        }
    }

    public ec(ao aoVar, bd.a aVar, au auVar) {
        this.f42229j = aoVar;
        this.f42224e = aVar;
        this.f42226g = auVar;
        this.f42225f = auVar.b().a((fi) new fi() {
            public void run() {
                ec.this.d();
            }
        });
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00f8, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void d() {
        /*
            r7 = this;
            monitor-enter(r7)
            java.util.concurrent.atomic.AtomicBoolean r0 = r7.f42228i     // Catch:{ all -> 0x00f9 }
            boolean r0 = r0.get()     // Catch:{ all -> 0x00f9 }
            if (r0 != 0) goto L_0x00f7
            com.apptimize.au r0 = r7.f42226g     // Catch:{ all -> 0x00f9 }
            com.apptimize.ak r0 = r0.d()     // Catch:{ all -> 0x00f9 }
            boolean r0 = r0.c()     // Catch:{ all -> 0x00f9 }
            if (r0 != 0) goto L_0x0017
            goto L_0x00f7
        L_0x0017:
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ all -> 0x00f9 }
            r0.<init>()     // Catch:{ all -> 0x00f9 }
            java.util.List<com.apptimize.ec$c<?>> r1 = r7.f42227h     // Catch:{ all -> 0x00f9 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x00f9 }
        L_0x0022:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x00f9 }
            if (r2 == 0) goto L_0x009b
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x00f9 }
            com.apptimize.ec$c r2 = (com.apptimize.ec.c) r2     // Catch:{ all -> 0x00f9 }
            com.apptimize.ec$b r3 = r2.f42234a     // Catch:{ all -> 0x00f9 }
            boolean r3 = r3.c()     // Catch:{ all -> 0x00f9 }
            r4 = 0
            if (r3 == 0) goto L_0x0045
            com.apptimize.ec$b r2 = r2.f42234a     // Catch:{ all -> 0x00f9 }
            java.lang.String r2 = r2.a()     // Catch:{ all -> 0x00f9 }
            r0.put(r2, r4)     // Catch:{ all -> 0x00f9 }
            goto L_0x0022
        L_0x0045:
            com.apptimize.ec$b r3 = r2.f42234a     // Catch:{ JSONException -> 0x006b }
            java.lang.Object r3 = r3.d()     // Catch:{ JSONException -> 0x006b }
            if (r3 != 0) goto L_0x005b
            com.apptimize.ec$b r3 = r2.f42234a     // Catch:{ JSONException -> 0x006b }
            java.lang.String r3 = r3.a()     // Catch:{ JSONException -> 0x006b }
            r0.put(r3, r4)     // Catch:{ JSONException -> 0x006b }
            goto L_0x0022
        L_0x005b:
            com.apptimize.ec$b r4 = r2.f42234a     // Catch:{ JSONException -> 0x006b }
            java.lang.String r4 = r4.a()     // Catch:{ JSONException -> 0x006b }
            java.lang.String r3 = r3.toString()     // Catch:{ JSONException -> 0x006b }
            r0.put(r4, r3)     // Catch:{ JSONException -> 0x006b }
            goto L_0x0022
        L_0x006b:
            r3 = move-exception
            java.lang.String r4 = r7.f42223d     // Catch:{ all -> 0x00f9 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f9 }
            r5.<init>()     // Catch:{ all -> 0x00f9 }
            java.lang.String r6 = "Error reading value "
            r5.append(r6)     // Catch:{ all -> 0x00f9 }
            com.apptimize.ec$b r6 = r2.f42234a     // Catch:{ all -> 0x00f9 }
            java.lang.String r6 = r6.a()     // Catch:{ all -> 0x00f9 }
            r5.append(r6)     // Catch:{ all -> 0x00f9 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x00f9 }
            com.apptimize.bo.d(r4, r5, r3)     // Catch:{ all -> 0x00f9 }
            com.apptimize.au r4 = r7.f42226g     // Catch:{ all -> 0x00f9 }
            com.apptimize.bq r4 = r4.a()     // Catch:{ all -> 0x00f9 }
            com.apptimize.bq$b r5 = com.apptimize.bq.b.FailedSerialization     // Catch:{ all -> 0x00f9 }
            com.apptimize.ec$5 r6 = new com.apptimize.ec$5     // Catch:{ all -> 0x00f9 }
            r6.<init>(r2, r3)     // Catch:{ all -> 0x00f9 }
            r4.a((com.apptimize.bq.b) r5, (java.util.Map<java.lang.String, java.lang.Object>) r6)     // Catch:{ all -> 0x00f9 }
            goto L_0x0022
        L_0x009b:
            android.os.StrictMode$ThreadPolicy r1 = android.os.StrictMode.allowThreadDiskWrites()     // Catch:{ all -> 0x00f9 }
            com.apptimize.bd$a r2 = r7.f42224e     // Catch:{ all -> 0x00f2 }
            com.apptimize.bd r2 = r2.b()     // Catch:{ all -> 0x00f2 }
            com.apptimize.bi r2 = r2.c()     // Catch:{ all -> 0x00f2 }
            java.util.Set r0 = r0.entrySet()     // Catch:{ all -> 0x00ed }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x00ed }
        L_0x00b1:
            boolean r3 = r0.hasNext()     // Catch:{ all -> 0x00ed }
            if (r3 == 0) goto L_0x00dd
            java.lang.Object r3 = r0.next()     // Catch:{ all -> 0x00ed }
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch:{ all -> 0x00ed }
            java.lang.Object r4 = r3.getValue()     // Catch:{ all -> 0x00ed }
            if (r4 == 0) goto L_0x00d3
            java.lang.Object r4 = r3.getKey()     // Catch:{ all -> 0x00ed }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x00ed }
            java.lang.Object r3 = r3.getValue()     // Catch:{ all -> 0x00ed }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x00ed }
            r2.a((java.lang.String) r4, (java.lang.String) r3)     // Catch:{ all -> 0x00ed }
            goto L_0x00b1
        L_0x00d3:
            java.lang.Object r3 = r3.getKey()     // Catch:{ all -> 0x00ed }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x00ed }
            r2.b(r3)     // Catch:{ all -> 0x00ed }
            goto L_0x00b1
        L_0x00dd:
            r2.b()     // Catch:{ all -> 0x00ed }
            com.apptimize.ao r0 = r7.f42229j     // Catch:{ all -> 0x00ed }
            r0.d()     // Catch:{ all -> 0x00ed }
            r2.c()     // Catch:{ all -> 0x00f2 }
            android.os.StrictMode.setThreadPolicy(r1)     // Catch:{ all -> 0x00f9 }
            monitor-exit(r7)
            return
        L_0x00ed:
            r0 = move-exception
            r2.c()     // Catch:{ all -> 0x00f2 }
            throw r0     // Catch:{ all -> 0x00f2 }
        L_0x00f2:
            r0 = move-exception
            android.os.StrictMode.setThreadPolicy(r1)     // Catch:{ all -> 0x00f9 }
            throw r0     // Catch:{ all -> 0x00f9 }
        L_0x00f7:
            monitor-exit(r7)
            return
        L_0x00f9:
            r0 = move-exception
            monitor-exit(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.ec.d():void");
    }

    public synchronized void b() {
        a((long) ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
    }

    public void c() {
        this.f42228i.set(true);
    }

    public synchronized <T> void a(a<T> aVar, b<T> bVar) {
        c cVar = new c();
        a unused = cVar.f42235b = aVar;
        b unused2 = cVar.f42234a = bVar;
        this.f42227h.add(cVar);
    }

    public synchronized void a() {
        bh b11;
        if (!this.f42228i.get()) {
            HashMap hashMap = new HashMap();
            StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
            try {
                b11 = this.f42224e.b().b();
                for (c next : this.f42227h) {
                    hashMap.put(next.f42234a.a(), b11.a(next.f42234a.a()));
                }
                b11.b();
                b11.c();
                StrictMode.setThreadPolicy(allowThreadDiskWrites);
                for (c next2 : this.f42227h) {
                    a((String) hashMap.get(next2.f42234a.a()), next2);
                }
            } catch (Throwable th2) {
                StrictMode.setThreadPolicy(allowThreadDiskWrites);
                throw th2;
            }
        }
    }

    private <T> void a(String str, c<T> cVar) {
        Object obj;
        if (str != null) {
            try {
                obj = cVar.f42235b.b(str);
            } catch (JSONException e11) {
                String str2 = this.f42223d;
                bo.d(str2, "Error reading value " + cVar.f42234a.a(), e11);
                return;
            } catch (NumberFormatException e12) {
                String str3 = this.f42223d;
                bo.d(str3, "Error reading value " + cVar.f42234a.a(), e12);
                return;
            }
        } else {
            obj = null;
        }
        cVar.f42234a.a(obj);
    }

    public synchronized void a(String str) {
        bi c11;
        if (this.f42226g.d().c()) {
            StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
            try {
                c11 = this.f42224e.b().c();
                c11.b(str);
                c11.b();
                c11.c();
                StrictMode.setThreadPolicy(allowThreadDiskWrites);
            } catch (Throwable th2) {
                StrictMode.setThreadPolicy(allowThreadDiskWrites);
                throw th2;
            }
        }
    }

    public synchronized void a(long j11) {
        if (this.f42226g.d().c()) {
            this.f42225f.a(j11);
        }
    }
}
