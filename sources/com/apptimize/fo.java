package com.apptimize;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class fo {

    /* renamed from: a  reason: collision with root package name */
    private final ScheduledExecutorService f42451a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final fi f42452b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final Object f42453c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private boolean f42454d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f42455e;

    /* renamed from: f  reason: collision with root package name */
    private ScheduledFuture<?> f42456f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f42457g = false;

    public fo(ScheduledExecutorService scheduledExecutorService, fi fiVar) {
        this.f42451a = scheduledExecutorService;
        this.f42452b = fiVar;
    }

    private void c(long j11) {
        if (this.f42457g) {
            fg.f42429d.execute(this.f42452b);
            return;
        }
        this.f42455e = false;
        this.f42456f = this.f42451a.schedule(new fi() {
            public void run() {
                synchronized (fo.this.f42453c) {
                    boolean unused = fo.this.f42455e = true;
                }
                fo.this.f42452b.run();
            }
        }, j11, TimeUnit.MILLISECONDS);
    }

    public void b(long j11) {
        if (this.f42457g) {
            fg.f42429d.execute(this.f42452b);
            return;
        }
        synchronized (this.f42453c) {
            if (!this.f42454d) {
                ScheduledFuture<?> scheduledFuture = this.f42456f;
                if (scheduledFuture != null) {
                    if (scheduledFuture.getDelay(TimeUnit.MILLISECONDS) < j11) {
                        this.f42456f.cancel(false);
                    } else if (!this.f42455e) {
                        return;
                    }
                }
                c(j11);
            }
        }
    }

    public void a() {
        if (this.f42457g) {
            fg.f42429d.execute(this.f42452b);
        } else {
            a(0);
        }
    }

    public void a(long j11) {
        if (this.f42457g) {
            fg.f42429d.execute(this.f42452b);
            return;
        }
        synchronized (this.f42453c) {
            if (!this.f42454d) {
                ScheduledFuture<?> scheduledFuture = this.f42456f;
                if (scheduledFuture != null) {
                    if (scheduledFuture.getDelay(TimeUnit.MILLISECONDS) > j11) {
                        this.f42456f.cancel(false);
                    } else if (!this.f42455e) {
                        return;
                    }
                }
                c(j11);
            }
        }
    }

    public void b() {
        synchronized (this.f42453c) {
            this.f42454d = true;
            ScheduledFuture<?> scheduledFuture = this.f42456f;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
                this.f42456f = null;
            }
        }
    }
}
