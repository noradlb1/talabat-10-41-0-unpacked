package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;

public final class zzden implements zzgpr<zzcgf> {
    private final zzdem zza;
    private final zzgqe<Context> zzb;
    private final zzgqe<zzcjf> zzc;
    private final zzgqe<zzfdn> zzd;
    private final zzgqe<zzcgb> zze;

    public zzden(zzdem zzdem, zzgqe<Context> zzgqe, zzgqe<zzcjf> zzgqe2, zzgqe<zzfdn> zzgqe3, zzgqe<zzcgb> zzgqe4) {
        this.zza = zzdem;
        this.zzb = zzgqe;
        this.zzc = zzgqe2;
        this.zzd = zzgqe3;
        this.zze = zzgqe4;
    }

    @Nullable
    public final /* synthetic */ Object zzb() {
        Context zzb2 = this.zzb.zzb();
        zzcjf zza2 = ((zzcrb) this.zzc).zza();
        zzfdn zza3 = ((zzdbl) this.zzd).zza();
        zzcgb zzcgb = new zzcgb();
        zzcgc zzcgc = zza3.zzB;
        if (zzcgc != null) {
            return new zzcfz(zzb2, zza2, zzcgc, zza3.zzt.zzb, zzcgb, (byte[]) null);
        }
        return null;
    }
}
