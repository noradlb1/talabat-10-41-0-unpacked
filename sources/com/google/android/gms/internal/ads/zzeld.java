package com.google.android.gms.internal.ads;

import android.os.Bundle;

public final class zzeld extends zzeky<zzdvn> {
    private final zzcqm zza;
    private final zzdeb zzb;
    private final zzdke zzc;

    public zzeld(zzcqm zzcqm, zzdeb zzdeb, zzdke zzdke) {
        this.zza = zzcqm;
        this.zzb = zzdeb;
        this.zzc = zzdke;
    }

    public final zzfxa<zzdvn> zzc(zzfef zzfef, Bundle bundle) {
        zzdvr zzk = this.zza.zzk();
        zzdeb zzdeb = this.zzb;
        zzdeb.zzf(zzfef);
        zzdeb.zzd(bundle);
        zzk.zzd(zzdeb.zzg());
        zzk.zzc(this.zzc);
        zzdby<zzdvn> zzb2 = zzk.zze().zzb();
        return zzb2.zzh(zzb2.zzi());
    }
}
