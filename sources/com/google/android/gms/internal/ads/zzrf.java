package com.google.android.gms.internal.ads;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.Nullable;

final class zzrf {
    public final long zza;
    public final long zzb;
    public boolean zzc;
    @Nullable
    public zzsx zzd;
    @Nullable
    public zzrf zze;

    public zzrf(long j11, int i11) {
        this.zza = j11;
        this.zzb = j11 + PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
    }

    public final int zza(long j11) {
        long j12 = this.zza;
        int i11 = this.zzd.zzb;
        return (int) (j11 - j12);
    }

    public final zzrf zzb() {
        this.zzd = null;
        zzrf zzrf = this.zze;
        this.zze = null;
        return zzrf;
    }
}
