package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.ExoPlayer;

final class zzhi implements zzik {
    final /* synthetic */ zzhp zza;

    public zzhi(zzhp zzhp) {
        this.zza = zzhp;
    }

    public final void zza(long j11) {
        if (j11 >= ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS) {
            this.zza.zzD = true;
        }
    }

    public final void zzb() {
        this.zza.zzh.zzh(2);
    }
}
