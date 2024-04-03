package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzo;
import java.util.concurrent.atomic.AtomicBoolean;

public final class zzdbp implements zzo {
    private final zzdfy zza;
    private final AtomicBoolean zzb = new AtomicBoolean(false);
    private final AtomicBoolean zzc = new AtomicBoolean(false);

    public zzdbp(zzdfy zzdfy) {
        this.zza = zzdfy;
    }

    private final void zzh() {
        if (!this.zzc.get()) {
            this.zzc.set(true);
            this.zza.zza();
        }
    }

    public final void zzb() {
        this.zza.zzc();
    }

    public final void zzbK() {
        zzh();
    }

    public final void zzbS() {
    }

    public final void zzbz() {
    }

    public final void zze() {
    }

    public final void zzf(int i11) {
        this.zzb.set(true);
        zzh();
    }

    public final boolean zzg() {
        return this.zzb.get();
    }
}
