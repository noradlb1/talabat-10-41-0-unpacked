package com.huawei.hms.framework.network.grs.g;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.common.net.HttpHeaders;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.e.a;
import com.huawei.hms.framework.network.grs.f.b;
import com.huawei.hms.framework.network.grs.g.j.d;
import com.huawei.hms.framework.network.grs.h.d;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import net.bytebuddy.description.type.TypeDescription;
import org.json.JSONArray;

public class c {

    /* renamed from: l  reason: collision with root package name */
    private static final String f48884l = "c";

    /* renamed from: a  reason: collision with root package name */
    private final GrsBaseInfo f48885a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f48886b;

    /* renamed from: c  reason: collision with root package name */
    private final a f48887c;

    /* renamed from: d  reason: collision with root package name */
    private d f48888d;

    /* renamed from: e  reason: collision with root package name */
    private final Map<String, Future<d>> f48889e = new ConcurrentHashMap(16);

    /* renamed from: f  reason: collision with root package name */
    private final List<d> f48890f = new CopyOnWriteArrayList();

    /* renamed from: g  reason: collision with root package name */
    private final JSONArray f48891g = new JSONArray();

    /* renamed from: h  reason: collision with root package name */
    private final List<String> f48892h = new CopyOnWriteArrayList();

    /* renamed from: i  reason: collision with root package name */
    private final com.huawei.hms.framework.network.grs.g.j.c f48893i;

    /* renamed from: j  reason: collision with root package name */
    private String f48894j = "";

    /* renamed from: k  reason: collision with root package name */
    private long f48895k = 1;

    public c(com.huawei.hms.framework.network.grs.g.j.c cVar, a aVar) {
        this.f48893i = cVar;
        this.f48885a = cVar.b();
        this.f48886b = cVar.a();
        this.f48887c = aVar;
        b();
        c();
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0097 A[LOOP:0: B:1:0x0005->B:37:0x0097, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x008f A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.huawei.hms.framework.network.grs.g.d a(java.util.concurrent.ExecutorService r16, java.util.List<java.lang.String> r17, java.lang.String r18, com.huawei.hms.framework.network.grs.e.c r19) {
        /*
            r15 = this;
            r9 = r15
            r0 = 0
            r10 = 0
            r11 = r0
            r12 = r10
        L_0x0005:
            int r0 = r17.size()
            if (r12 >= r0) goto L_0x009b
            r13 = r17
            java.lang.Object r0 = r13.get(r12)
            java.lang.String r0 = (java.lang.String) r0
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x008a
            com.huawei.hms.framework.network.grs.g.a r14 = new com.huawei.hms.framework.network.grs.g.a
            android.content.Context r5 = r9.f48886b
            com.huawei.hms.framework.network.grs.GrsBaseInfo r7 = r9.f48885a
            r1 = r14
            r2 = r0
            r3 = r12
            r4 = r15
            r6 = r18
            r8 = r19
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            java.util.concurrent.Callable r1 = r14.g()
            r2 = r16
            java.util.concurrent.Future r1 = r2.submit(r1)
            java.util.Map<java.lang.String, java.util.concurrent.Future<com.huawei.hms.framework.network.grs.g.d>> r3 = r9.f48889e
            r3.put(r0, r1)
            r3 = 1
            long r4 = r9.f48895k     // Catch:{ CancellationException -> 0x0082, ExecutionException -> 0x0079, InterruptedException -> 0x0070, TimeoutException -> 0x0068 }
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ CancellationException -> 0x0082, ExecutionException -> 0x0079, InterruptedException -> 0x0070, TimeoutException -> 0x0068 }
            java.lang.Object r0 = r1.get(r4, r0)     // Catch:{ CancellationException -> 0x0082, ExecutionException -> 0x0079, InterruptedException -> 0x0070, TimeoutException -> 0x0068 }
            r1 = r0
            com.huawei.hms.framework.network.grs.g.d r1 = (com.huawei.hms.framework.network.grs.g.d) r1     // Catch:{ CancellationException -> 0x0082, ExecutionException -> 0x0079, InterruptedException -> 0x0070, TimeoutException -> 0x0068 }
            if (r1 == 0) goto L_0x0066
            boolean r0 = r1.o()     // Catch:{ CancellationException -> 0x0064, ExecutionException -> 0x0061, InterruptedException -> 0x005e, TimeoutException -> 0x005c }
            if (r0 != 0) goto L_0x0053
            boolean r0 = r1.m()     // Catch:{ CancellationException -> 0x0064, ExecutionException -> 0x0061, InterruptedException -> 0x005e, TimeoutException -> 0x005c }
            if (r0 == 0) goto L_0x0066
        L_0x0053:
            java.lang.String r0 = f48884l     // Catch:{ CancellationException -> 0x0064, ExecutionException -> 0x0061, InterruptedException -> 0x005e, TimeoutException -> 0x005c }
            java.lang.String r4 = "grs request return body is not null and is OK."
            com.huawei.hms.framework.common.Logger.i(r0, r4)     // Catch:{ CancellationException -> 0x0064, ExecutionException -> 0x0061, InterruptedException -> 0x005e, TimeoutException -> 0x005c }
            r11 = r1
            goto L_0x008d
        L_0x005c:
            r11 = r1
            goto L_0x0068
        L_0x005e:
            r0 = move-exception
            r11 = r1
            goto L_0x0071
        L_0x0061:
            r0 = move-exception
            r11 = r1
            goto L_0x007a
        L_0x0064:
            r11 = r1
            goto L_0x0082
        L_0x0066:
            r11 = r1
            goto L_0x008c
        L_0x0068:
            java.lang.String r0 = f48884l
            java.lang.String r1 = "the wait timed out"
            com.huawei.hms.framework.common.Logger.w(r0, r1)
            goto L_0x008c
        L_0x0070:
            r0 = move-exception
        L_0x0071:
            java.lang.String r1 = f48884l
            java.lang.String r4 = "the current thread was interrupted while waiting"
            com.huawei.hms.framework.common.Logger.w((java.lang.String) r1, (java.lang.String) r4, (java.lang.Throwable) r0)
            goto L_0x008d
        L_0x0079:
            r0 = move-exception
        L_0x007a:
            java.lang.String r1 = f48884l
            java.lang.String r3 = "the computation threw an ExecutionException"
            com.huawei.hms.framework.common.Logger.w((java.lang.String) r1, (java.lang.String) r3, (java.lang.Throwable) r0)
            goto L_0x008c
        L_0x0082:
            java.lang.String r0 = f48884l
            java.lang.String r1 = "{requestServer} the computation was cancelled"
            com.huawei.hms.framework.common.Logger.i(r0, r1)
            goto L_0x008d
        L_0x008a:
            r2 = r16
        L_0x008c:
            r3 = r10
        L_0x008d:
            if (r3 == 0) goto L_0x0097
            java.lang.String r0 = f48884l
            java.lang.String r1 = "needBreak is true so need break current circulation"
            com.huawei.hms.framework.common.Logger.v(r0, r1)
            goto L_0x009b
        L_0x0097:
            int r12 = r12 + 1
            goto L_0x0005
        L_0x009b:
            com.huawei.hms.framework.network.grs.g.d r0 = r15.b(r11)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.g.c.a(java.util.concurrent.ExecutorService, java.util.List, java.lang.String, com.huawei.hms.framework.network.grs.e.c):com.huawei.hms.framework.network.grs.g.d");
    }

    private void a(String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str2);
        sb2.append(str);
        String grsReqParamJoint = this.f48885a.getGrsReqParamJoint(false, false, d(), this.f48886b);
        if (!TextUtils.isEmpty(grsReqParamJoint)) {
            sb2.append(TypeDescription.Generic.OfWildcardType.SYMBOL);
            sb2.append(grsReqParamJoint);
        }
        this.f48892h.add(sb2.toString());
    }

    private d b(d dVar) {
        String str;
        String str2;
        for (Map.Entry next : this.f48889e.entrySet()) {
            if (dVar != null && (dVar.o() || dVar.m())) {
                break;
            }
            try {
                dVar = (d) ((Future) next.getValue()).get(40000, TimeUnit.MILLISECONDS);
            } catch (CancellationException unused) {
                Logger.i(f48884l, "{checkResponse} when check result, find CancellationException, check others");
            } catch (ExecutionException e11) {
                e = e11;
                str2 = f48884l;
                str = "{checkResponse} when check result, find ExecutionException, check others";
                Logger.w(str2, str, e);
            } catch (InterruptedException e12) {
                e = e12;
                str2 = f48884l;
                str = "{checkResponse} when check result, find InterruptedException, check others";
                Logger.w(str2, str, e);
            } catch (TimeoutException unused2) {
                Logger.w(f48884l, "{checkResponse} when check result, find TimeoutException, cancel current request task");
                if (!((Future) next.getValue()).isCancelled()) {
                    ((Future) next.getValue()).cancel(true);
                }
            }
        }
        return dVar;
    }

    private void b() {
        d a11 = com.huawei.hms.framework.network.grs.g.i.a.a(this.f48886b);
        if (a11 == null) {
            Logger.w(f48884l, "g*s***_se****er_conf*** maybe has a big error");
            return;
        }
        a(a11);
        List<String> a12 = a11.a();
        if (a12 == null || a12.size() <= 0) {
            Logger.v(f48884l, "maybe grs_base_url config with [],please check.");
        } else if (a12.size() <= 10) {
            String b11 = a11.b();
            if (a12.size() > 0) {
                for (String next : a12) {
                    if (!next.startsWith("https://")) {
                        Logger.w(f48884l, "grs server just support https scheme url,please check.");
                    } else {
                        a(b11, next);
                    }
                }
            }
            Logger.v(f48884l, "request to GRS server url is {%s}", this.f48892h);
        } else {
            throw new IllegalArgumentException("grs_base_url's count is larger than MAX value 10");
        }
    }

    private void c() {
        String grsParasKey = this.f48885a.getGrsParasKey(true, true, this.f48886b);
        com.huawei.hms.framework.network.grs.e.c a11 = this.f48887c.a();
        this.f48894j = a11.a(grsParasKey + HttpHeaders.ETAG, "");
    }

    private String d() {
        b a11 = b.a(this.f48886b.getPackageName());
        com.huawei.hms.framework.network.grs.local.model.a a12 = a11 != null ? a11.a() : null;
        if (a12 == null) {
            return "";
        }
        String a13 = a12.a();
        Logger.v(f48884l, "get appName from local assets is{%s}", a13);
        return a13;
    }

    public d a(ExecutorService executorService, String str, com.huawei.hms.framework.network.grs.e.c cVar) {
        if (this.f48892h.isEmpty()) {
            return null;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        d a11 = a(executorService, this.f48892h, str, cVar);
        Logger.i(f48884l, "use 2.0 interface return http's code is：{%d}", Integer.valueOf(a11 == null ? 0 : a11.b()));
        e.a(new ArrayList(this.f48890f), SystemClock.elapsedRealtime() - elapsedRealtime, this.f48891g, this.f48886b);
        this.f48890f.clear();
        return a11;
    }

    public String a() {
        return this.f48894j;
    }

    public synchronized void a(d dVar) {
        this.f48890f.add(dVar);
        d dVar2 = this.f48888d;
        if (dVar2 != null && (dVar2.o() || this.f48888d.m())) {
            Logger.v(f48884l, "grsResponseResult is ok");
        } else if (dVar.n()) {
            Logger.i(f48884l, "GRS server open 503 limiting strategy.");
            com.huawei.hms.framework.network.grs.h.d.a(this.f48885a.getGrsParasKey(true, true, this.f48886b), new d.a(dVar.k(), SystemClock.elapsedRealtime()));
        } else {
            if (dVar.m()) {
                Logger.i(f48884l, "GRS server open 304 Not Modified.");
            }
            if (dVar.o() || dVar.m()) {
                this.f48888d = dVar;
                this.f48887c.a(this.f48885a, dVar, this.f48886b, this.f48893i);
                for (Map.Entry next : this.f48889e.entrySet()) {
                    if (!((String) next.getKey()).equals(dVar.l()) && !((Future) next.getValue()).isCancelled()) {
                        Logger.i(f48884l, "future cancel");
                        ((Future) next.getValue()).cancel(true);
                    }
                }
                return;
            }
            Logger.v(f48884l, "grsResponseResult has exception so need return");
        }
    }

    public void a(com.huawei.hms.framework.network.grs.g.j.d dVar) {
    }
}
