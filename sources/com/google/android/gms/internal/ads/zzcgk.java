package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;

public final class zzcgk {
    private final Clock zza;
    private final zzcgi zzb;

    public zzcgk(Clock clock, zzcgi zzcgi) {
        this.zza = clock;
        this.zzb = zzcgi;
    }

    public static zzcgk zza(Context context) {
        return zzchi.zzd(context).zzb();
    }

    public final void zzb(int i11, long j11) {
        this.zzb.zzb(i11, j11);
    }

    public final void zzc() {
        this.zzb.zza();
    }

    public final void zzd(zzbkk zzbkk) {
        this.zzb.zzb(-1, this.zza.currentTimeMillis());
    }

    public final void zze() {
        this.zzb.zzb(-1, this.zza.currentTimeMillis());
    }
}
