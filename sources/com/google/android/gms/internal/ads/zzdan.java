package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;

public final class zzdan implements zzdgf, zzaya {
    private final zzfdn zza;
    private final zzdfj zzb;
    private final zzdgo zzc;
    private final AtomicBoolean zzd = new AtomicBoolean();
    private final AtomicBoolean zze = new AtomicBoolean();

    public zzdan(zzfdn zzfdn, zzdfj zzdfj, zzdgo zzdgo) {
        this.zza = zzfdn;
        this.zzb = zzdfj;
        this.zzc = zzdgo;
    }

    private final void zza() {
        if (this.zzd.compareAndSet(false, true)) {
            this.zzb.zza();
        }
    }

    public final void zzc(zzaxz zzaxz) {
        if (this.zza.zzf == 1 && zzaxz.zzj) {
            zza();
        }
        if (zzaxz.zzj && this.zze.compareAndSet(false, true)) {
            this.zzc.zza();
        }
    }

    public final synchronized void zzn() {
        if (this.zza.zzf != 1) {
            zza();
        }
    }
}
