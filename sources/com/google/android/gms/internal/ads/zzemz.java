package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.zzf;
import java.util.concurrent.atomic.AtomicBoolean;

public final class zzemz implements zzf {
    final AtomicBoolean zza = new AtomicBoolean(false);
    private final zzdep zzb;
    private final zzdfj zzc;
    private final zzdmf zzd;
    private final zzdly zze;
    private final zzcxf zzf;

    public zzemz(zzdep zzdep, zzdfj zzdfj, zzdmf zzdmf, zzdly zzdly, zzcxf zzcxf) {
        this.zzb = zzdep;
        this.zzc = zzdfj;
        this.zzd = zzdmf;
        this.zze = zzdly;
        this.zzf = zzcxf;
    }

    public final synchronized void zza(View view) {
        if (this.zza.compareAndSet(false, true)) {
            this.zzf.zzl();
            this.zze.zza(view);
        }
    }

    public final void zzb() {
        if (this.zza.get()) {
            this.zzb.onAdClicked();
        }
    }

    public final void zzc() {
        if (this.zza.get()) {
            this.zzc.zza();
            this.zzd.zza();
        }
    }
}
