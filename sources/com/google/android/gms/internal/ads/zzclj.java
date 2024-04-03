package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzt;

final class zzclj implements Runnable {
    private final zzckv zza;
    private boolean zzb = false;

    public zzclj(zzckv zzckv) {
        this.zza = zzckv;
    }

    private final void zzc() {
        zzfpj zzfpj = zzt.zza;
        zzfpj.removeCallbacks(this);
        zzfpj.postDelayed(this, 250);
    }

    public final void run() {
        if (!this.zzb) {
            this.zza.zzr();
            zzc();
        }
    }

    public final void zza() {
        this.zzb = true;
        this.zza.zzr();
    }

    public final void zzb() {
        this.zzb = false;
        zzc();
    }
}
