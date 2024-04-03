package com.instabug.crash.settings;

import android.annotation.SuppressLint;
import android.content.Context;
import com.instabug.library.networkv2.limitation.RateLimitationSettings;

public class b implements RateLimitationSettings {

    /* renamed from: a  reason: collision with root package name */
    private static b f46440a;

    private b() {
    }

    public static synchronized void a(Context context) {
        synchronized (b.class) {
            f46440a = new b();
            h.a(context);
        }
    }

    @SuppressLint({"ERADICATE_FIELD_NOT_NULLABLE"})
    public static synchronized void d() {
        synchronized (b.class) {
            g.d();
            h.f();
            f46440a = null;
        }
    }

    public synchronized long b() {
        if (h.b() == null) {
            return -1;
        }
        return h.b().d();
    }

    public synchronized boolean c() {
        if (h.b() == null) {
            return false;
        }
        return h.b().e();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0032, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean isRateLimited() {
        /*
            r10 = this;
            monitor-enter(r10)
            com.instabug.crash.settings.h r0 = com.instabug.crash.settings.h.b()     // Catch:{ all -> 0x0033 }
            r1 = 0
            if (r0 != 0) goto L_0x000a
            monitor-exit(r10)
            return r1
        L_0x000a:
            com.instabug.crash.settings.h r0 = com.instabug.crash.settings.h.b()     // Catch:{ all -> 0x0033 }
            long r2 = r0.c()     // Catch:{ all -> 0x0033 }
            com.instabug.crash.settings.h r0 = com.instabug.crash.settings.h.b()     // Catch:{ all -> 0x0033 }
            long r4 = r0.a()     // Catch:{ all -> 0x0033 }
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0033 }
            r8 = 0
            int r0 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r0 == 0) goto L_0x0031
            int r0 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r0 == 0) goto L_0x0031
            int r0 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x0031
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 >= 0) goto L_0x0031
            r1 = 1
        L_0x0031:
            monitor-exit(r10)
            return r1
        L_0x0033:
            r0 = move-exception
            monitor-exit(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.crash.settings.b.isRateLimited():boolean");
    }

    public synchronized void setLastRequestStartedAt(long j11) {
        if (h.b() != null) {
            h.b().a(j11);
        }
    }

    public synchronized void setLimitedUntil(int i11) {
        if (h.b() != null) {
            h.b().a(i11);
        }
    }

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            if (f46440a == null) {
                f46440a = new b();
            }
            bVar = f46440a;
        }
        return bVar;
    }

    public synchronized void a(long j11) {
        if (h.b() != null) {
            h.b().b(j11);
        }
    }

    public synchronized void a(boolean z11) {
        if (h.b() != null) {
            h.b().a(z11);
        }
    }
}
