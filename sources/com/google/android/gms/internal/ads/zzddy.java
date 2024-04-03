package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.zzg;
import java.util.List;

public final class zzddy implements zzgpr<zzddx> {
    private final zzgqe<zzfie> zza;
    private final zzgqe<zzcjf> zzb;
    private final zzgqe<ApplicationInfo> zzc;
    private final zzgqe<String> zzd;
    private final zzgqe<List<String>> zze;
    private final zzgqe<PackageInfo> zzf;
    private final zzgqe<zzfxa<String>> zzg;
    private final zzgqe<zzg> zzh;
    private final zzgqe<String> zzi;
    private final zzgqe<zzevq<Bundle>> zzj;

    public zzddy(zzgqe<zzfie> zzgqe, zzgqe<zzcjf> zzgqe2, zzgqe<ApplicationInfo> zzgqe3, zzgqe<String> zzgqe4, zzgqe<List<String>> zzgqe5, zzgqe<PackageInfo> zzgqe6, zzgqe<zzfxa<String>> zzgqe7, zzgqe<zzg> zzgqe8, zzgqe<String> zzgqe9, zzgqe<zzevq<Bundle>> zzgqe10) {
        this.zza = zzgqe;
        this.zzb = zzgqe2;
        this.zzc = zzgqe3;
        this.zzd = zzgqe4;
        this.zze = zzgqe5;
        this.zzf = zzgqe6;
        this.zzg = zzgqe7;
        this.zzh = zzgqe8;
        this.zzi = zzgqe9;
        this.zzj = zzgqe10;
    }

    /* renamed from: zza */
    public final zzddx zzb() {
        return new zzddx(this.zza.zzb(), ((zzcrb) this.zzb).zza(), ((zzecp) this.zzc).zzb(), ((zzecv) this.zzd).zzb(), zzblj.zza(), this.zzf.zzb(), zzgpq.zza(this.zzg), ((zzffg) this.zzh).zzb(), this.zzi.zzb(), ((zzevr) this.zzj).zzb());
    }
}
