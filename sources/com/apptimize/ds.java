package com.apptimize;

import com.apptimize.bd;
import com.google.android.exoplayer2.ExoPlayer;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ds {

    /* renamed from: a  reason: collision with root package name */
    private au f42007a;

    /* renamed from: b  reason: collision with root package name */
    private final bd.a f42008b;

    /* renamed from: c  reason: collision with root package name */
    private ScheduledFuture<?> f42009c;

    /* renamed from: d  reason: collision with root package name */
    private final List<dp> f42010d = new LinkedList();

    private ds(bd.a aVar, au auVar) {
        this.f42008b = aVar;
        this.f42007a = auVar;
    }

    public static ds a(bd.a aVar, final au auVar, ScheduledExecutorService scheduledExecutorService) {
        final ds dsVar = new ds(aVar, auVar);
        dsVar.f42009c = scheduledExecutorService.scheduleWithFixedDelay(new fi() {
            public void run() {
                if (au.this.d().c()) {
                    dsVar.c();
                }
            }
        }, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, TimeUnit.MILLISECONDS);
        return dsVar;
    }

    public synchronized int b() {
        this.f42007a.d().e();
        return this.f42010d.size();
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0038 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void c() {
        /*
            r5 = this;
            monitor-enter(r5)
            com.apptimize.au r0 = r5.f42007a     // Catch:{ all -> 0x0051 }
            com.apptimize.ak r0 = r0.d()     // Catch:{ all -> 0x0051 }
            r0.e()     // Catch:{ all -> 0x0051 }
            java.util.List<com.apptimize.dp> r0 = r5.f42010d     // Catch:{ all -> 0x0051 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0051 }
            if (r0 != 0) goto L_0x004f
            android.os.StrictMode$ThreadPolicy r0 = android.os.StrictMode.allowThreadDiskWrites()     // Catch:{ all -> 0x0051 }
            com.apptimize.bd$a r1 = r5.f42008b     // Catch:{ all -> 0x004a }
            com.apptimize.bd r1 = r1.b()     // Catch:{ all -> 0x004a }
            java.util.List<com.apptimize.dp> r2 = r5.f42010d     // Catch:{ all -> 0x004a }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x004a }
        L_0x0022:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x004a }
            if (r3 == 0) goto L_0x0041
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x004a }
            com.apptimize.dp r3 = (com.apptimize.dp) r3     // Catch:{ all -> 0x004a }
            com.apptimize.bi r4 = r1.c()     // Catch:{ all -> 0x004a }
            r4.a((com.apptimize.dp) r3)     // Catch:{ JSONException -> 0x0038, all -> 0x003c }
            r4.b()     // Catch:{ JSONException -> 0x0038, all -> 0x003c }
        L_0x0038:
            r4.c()     // Catch:{ all -> 0x004a }
            goto L_0x0022
        L_0x003c:
            r1 = move-exception
            r4.c()     // Catch:{ all -> 0x004a }
            throw r1     // Catch:{ all -> 0x004a }
        L_0x0041:
            android.os.StrictMode.setThreadPolicy(r0)     // Catch:{ all -> 0x0051 }
            java.util.List<com.apptimize.dp> r0 = r5.f42010d     // Catch:{ all -> 0x0051 }
            r0.clear()     // Catch:{ all -> 0x0051 }
            goto L_0x004f
        L_0x004a:
            r1 = move-exception
            android.os.StrictMode.setThreadPolicy(r0)     // Catch:{ all -> 0x0051 }
            throw r1     // Catch:{ all -> 0x0051 }
        L_0x004f:
            monitor-exit(r5)
            return
        L_0x0051:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.ds.c():void");
    }

    public void d() {
        this.f42007a.d().e();
        this.f42010d.clear();
    }

    public synchronized void a() {
        this.f42009c.cancel(false);
    }

    public synchronized void a(dp dpVar) {
        this.f42007a.d().e();
        this.f42010d.add(dpVar);
    }

    public void a(bi biVar) {
        this.f42007a.d().e();
        if (!this.f42010d.isEmpty()) {
            biVar.a(this.f42010d);
        }
    }
}
