package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import javax.annotation.concurrent.GuardedBy;

public final class zzfdm {
    private final Clock zza;
    private final Object zzb = new Object();
    private volatile long zzc = 0;
    @GuardedBy("lock")
    private volatile int zzd = 1;

    public zzfdm(Clock clock) {
        this.zza = clock;
    }

    private final void zze() {
        long currentTimeMillis = this.zza.currentTimeMillis();
        synchronized (this.zzb) {
            if (this.zzd == 3) {
                if (this.zzc + ((Long) zzbgq.zzc().zzb(zzblj.zzes)).longValue() <= currentTimeMillis) {
                    this.zzd = 1;
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzf(int r5, int r6) {
        /*
            r4 = this;
            r4.zze()
            com.google.android.gms.common.util.Clock r0 = r4.zza
            long r0 = r0.currentTimeMillis()
            java.lang.Object r2 = r4.zzb
            monitor-enter(r2)
            int r3 = r4.zzd     // Catch:{ all -> 0x001d }
            if (r3 == r5) goto L_0x0012
            monitor-exit(r2)     // Catch:{ all -> 0x001d }
            return
        L_0x0012:
            r4.zzd = r6     // Catch:{ all -> 0x001d }
            int r5 = r4.zzd     // Catch:{ all -> 0x001d }
            r6 = 3
            if (r5 != r6) goto L_0x001b
            r4.zzc = r0     // Catch:{ all -> 0x001d }
        L_0x001b:
            monitor-exit(r2)     // Catch:{ all -> 0x001d }
            return
        L_0x001d:
            r5 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x001d }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfdm.zzf(int, int):void");
    }

    public final void zza() {
        zzf(2, 3);
    }

    public final void zzb(boolean z11) {
        if (z11) {
            zzf(1, 2);
        } else {
            zzf(2, 1);
        }
    }

    public final boolean zzc() {
        boolean z11;
        synchronized (this.zzb) {
            zze();
            if (this.zzd == 3) {
                z11 = true;
            } else {
                z11 = false;
            }
        }
        return z11;
    }

    public final boolean zzd() {
        boolean z11;
        synchronized (this.zzb) {
            zze();
            if (this.zzd == 2) {
                z11 = true;
            } else {
                z11 = false;
            }
        }
        return z11;
    }
}
