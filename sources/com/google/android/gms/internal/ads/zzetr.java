package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import com.google.android.gms.ads.internal.util.zzg;

public final class zzetr implements zzgpr<zzetp> {
    private final zzgqe<zzfxb> zza;
    private final zzgqe<zzfef> zzb;
    private final zzgqe<PackageInfo> zzc;
    private final zzgqe<zzg> zzd;

    public zzetr(zzgqe<zzfxb> zzgqe, zzgqe<zzfef> zzgqe2, zzgqe<PackageInfo> zzgqe3, zzgqe<zzg> zzgqe4) {
        this.zza = zzgqe;
        this.zzb = zzgqe2;
        this.zzc = zzgqe3;
        this.zzd = zzgqe4;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfxb zzfxb = zzcjm.zza;
        zzgpz.zzb(zzfxb);
        return new zzetp(zzfxb, ((zzdei) this.zzb).zza(), this.zzc.zzb(), ((zzffg) this.zzd).zzb());
    }
}
