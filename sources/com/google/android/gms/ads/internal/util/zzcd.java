package com.google.android.gms.ads.internal.util;

import com.google.android.gms.ads.internal.zzt;
import javax.annotation.concurrent.GuardedBy;

public final class zzcd {
    private long zza;
    @GuardedBy("lock")
    private long zzb = Long.MIN_VALUE;
    private final Object zzc = new Object();

    public zzcd(long j11) {
        this.zza = j11;
    }

    public final void zza(long j11) {
        synchronized (this.zzc) {
            this.zza = j11;
        }
    }

    public final boolean zzb() {
        synchronized (this.zzc) {
            long elapsedRealtime = zzt.zzA().elapsedRealtime();
            if (this.zzb + this.zza > elapsedRealtime) {
                return false;
            }
            this.zzb = elapsedRealtime;
            return true;
        }
    }
}
