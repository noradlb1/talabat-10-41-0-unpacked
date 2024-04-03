package com.google.android.gms.internal.ads;

final class zzagi implements Runnable {
    private final zzags zza;
    private final zzagy zzb;
    private final Runnable zzc;

    public zzagi(zzags zzags, zzagy zzagy, Runnable runnable) {
        this.zza = zzags;
        this.zzb = zzagy;
        this.zzc = runnable;
    }

    public final void run() {
        this.zza.zzw();
        if (this.zzb.zzc()) {
            this.zza.zzo(this.zzb.zza);
        } else {
            this.zza.zzn(this.zzb.zzc);
        }
        if (this.zzb.zzd) {
            this.zza.zzm("intermediate-response");
        } else {
            this.zza.zzp("done");
        }
        Runnable runnable = this.zzc;
        if (runnable != null) {
            runnable.run();
        }
    }
}
