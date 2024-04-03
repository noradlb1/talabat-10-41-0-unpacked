package com.google.android.gms.measurement.internal;

import androidx.annotation.WorkerThread;
import com.google.android.exoplayer2.ExoPlayer;

final class zzkl {
    final /* synthetic */ zzkp zza;
    private zzkk zzb;

    public zzkl(zzkp zzkp) {
        this.zza = zzkp;
    }

    @WorkerThread
    public final void zza(long j11) {
        this.zzb = new zzkk(this, this.zza.zzt.zzax().currentTimeMillis(), j11);
        this.zza.zzd.postDelayed(this.zzb, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
    }

    @WorkerThread
    public final void zzb() {
        this.zza.zzg();
        zzkk zzkk = this.zzb;
        if (zzkk != null) {
            this.zza.zzd.removeCallbacks(zzkk);
        }
        this.zza.zzt.zzm().zzm.zza(false);
        this.zza.zzm(false);
    }
}
