package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzewn implements zzgpr<zzewl> {
    private final zzgqe<zzcds> zza;
    private final zzgqe<Context> zzb;
    private final zzgqe<String> zzc;
    private final zzgqe<zzfxb> zzd;

    public zzewn(zzgqe<zzcds> zzgqe, zzgqe<Context> zzgqe2, zzgqe<String> zzgqe3, zzgqe<zzfxb> zzgqe4) {
        this.zza = zzgqe;
        this.zzb = zzgqe2;
        this.zzc = zzgqe3;
        this.zzd = zzgqe4;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Context zza2 = ((zzcqr) this.zzb).zza();
        String zza3 = ((zzexn) this.zzc).zza();
        zzfxb zzfxb = zzcjm.zza;
        zzgpz.zzb(zzfxb);
        return new zzewl((zzcds) null, zza2, zza3, zzfxb);
    }
}
