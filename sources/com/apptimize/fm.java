package com.apptimize;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class fm {

    /* renamed from: a  reason: collision with root package name */
    private final ScheduledExecutorService f42437a;

    /* renamed from: b  reason: collision with root package name */
    private final fi f42438b;

    /* renamed from: c  reason: collision with root package name */
    private ScheduledFuture<?> f42439c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public long f42440d;

    /* renamed from: e  reason: collision with root package name */
    private long f42441e;

    /* renamed from: f  reason: collision with root package name */
    private final eu f42442f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f42443g = true;

    /* renamed from: h  reason: collision with root package name */
    private boolean f42444h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f42445i;

    public fm(ScheduledExecutorService scheduledExecutorService, final fi fiVar, Long l11, final eu euVar) {
        long j11;
        this.f42442f = euVar;
        this.f42438b = new fi() {
            public void run() {
                synchronized (fm.this) {
                    long unused = fm.this.f42440d = euVar.c();
                }
                fiVar.run();
            }
        };
        this.f42437a = scheduledExecutorService;
        if (l11 != null) {
            j11 = euVar.b(l11.longValue());
        } else {
            j11 = euVar.c();
        }
        this.f42440d = j11;
    }

    private void g() {
        ScheduledFuture<?> scheduledFuture = this.f42439c;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            this.f42439c = null;
        }
    }

    public synchronized boolean b() {
        return !this.f42443g && !this.f42444h;
    }

    public synchronized void c() {
        if (!this.f42444h) {
            g();
            this.f42444h = true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0017, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void d() {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.f42444h     // Catch:{ all -> 0x0018 }
            if (r0 != 0) goto L_0x0016
            boolean r0 = r1.f42443g     // Catch:{ all -> 0x0018 }
            if (r0 != 0) goto L_0x000a
            goto L_0x0016
        L_0x000a:
            r1.g()     // Catch:{ all -> 0x0018 }
            r0 = 0
            r1.b(r0)     // Catch:{ all -> 0x0018 }
            r0 = 0
            r1.f42443g = r0     // Catch:{ all -> 0x0018 }
            monitor-exit(r1)
            return
        L_0x0016:
            monitor-exit(r1)
            return
        L_0x0018:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.fm.d():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0013, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void e() {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.f42444h     // Catch:{ all -> 0x0014 }
            if (r0 != 0) goto L_0x0012
            boolean r0 = r1.f42443g     // Catch:{ all -> 0x0014 }
            if (r0 != 0) goto L_0x000a
            goto L_0x0012
        L_0x000a:
            r0 = 0
            r1.f42443g = r0     // Catch:{ all -> 0x0014 }
            r1.f()     // Catch:{ all -> 0x0014 }
            monitor-exit(r1)
            return
        L_0x0012:
            monitor-exit(r1)
            return
        L_0x0014:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.fm.e():void");
    }

    public synchronized void f() {
        if (!this.f42444h) {
            this.f42445i = true;
            if (!this.f42443g) {
                g();
                b((Long) null);
            }
        }
    }

    private void b(Long l11) {
        long j11;
        if (this.f42445i) {
            this.f42445i = false;
            j11 = 0;
        } else {
            j11 = a(l11);
        }
        this.f42439c = this.f42437a.scheduleWithFixedDelay(this.f42438b, j11, this.f42441e, TimeUnit.MILLISECONDS);
    }

    public synchronized long a(Long l11) {
        if (l11 == null) {
            l11 = Long.valueOf(this.f42441e - a());
        }
        if (l11.longValue() < 0) {
            l11 = 0L;
        }
        long longValue = l11.longValue();
        long j11 = this.f42441e;
        if (longValue > j11) {
            l11 = Long.valueOf(j11);
        }
        return l11.longValue();
    }

    public synchronized long a() {
        return this.f42442f.c() - this.f42440d;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x002c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(long r3, boolean r5) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.f42444h     // Catch:{ all -> 0x002d }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r2)
            return
        L_0x0007:
            long r0 = r2.f42441e     // Catch:{ all -> 0x002d }
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 == 0) goto L_0x000f
            r0 = 1
            goto L_0x0010
        L_0x000f:
            r0 = 0
        L_0x0010:
            r2.f42441e = r3     // Catch:{ all -> 0x002d }
            boolean r3 = r2.f42443g     // Catch:{ all -> 0x002d }
            if (r3 == 0) goto L_0x0018
            monitor-exit(r2)
            return
        L_0x0018:
            if (r5 == 0) goto L_0x001e
            r2.f()     // Catch:{ all -> 0x002d }
            goto L_0x002b
        L_0x001e:
            if (r0 != 0) goto L_0x0024
            java.util.concurrent.ScheduledFuture<?> r3 = r2.f42439c     // Catch:{ all -> 0x002d }
            if (r3 != 0) goto L_0x002b
        L_0x0024:
            r2.g()     // Catch:{ all -> 0x002d }
            r3 = 0
            r2.b(r3)     // Catch:{ all -> 0x002d }
        L_0x002b:
            monitor-exit(r2)
            return
        L_0x002d:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.fm.a(long, boolean):void");
    }
}
