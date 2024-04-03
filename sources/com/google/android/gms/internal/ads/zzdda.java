package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzo;
import java.util.concurrent.Executor;

public final class zzdda implements zzgpr<zzdlw<zzo>> {
    private final zzgqe<zzdjb> zza;
    private final zzgqe<Executor> zzb;

    public zzdda(zzgqe<zzdjb> zzgqe, zzgqe<Executor> zzgqe2) {
        this.zza = zzgqe;
        this.zzb = zzgqe2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdlw(this.zza.zzb(), this.zzb.zzb());
    }
}
