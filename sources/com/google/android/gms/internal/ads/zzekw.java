package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.ViewGroup;

public final class zzekw extends zzeky<zzdbc> {
    private final zzcqm zza;
    private final zzdok zzb;
    private final zzdeb zzc;
    private final zzdke zzd;

    public zzekw(zzcqm zzcqm, zzdok zzdok, zzdeb zzdeb, zzdke zzdke) {
        this.zza = zzcqm;
        this.zzb = zzdok;
        this.zzc = zzdeb;
        this.zzd = zzdke;
    }

    public final zzfxa<zzdbc> zzc(zzfef zzfef, Bundle bundle) {
        zzdoo zzj = this.zza.zzj();
        zzdeb zzdeb = this.zzc;
        zzdeb.zzf(zzfef);
        zzdeb.zzd(bundle);
        zzj.zzf(zzdeb.zzg());
        zzj.zze(this.zzd);
        zzj.zzd(this.zzb);
        zzj.zzc(new zzcyt((ViewGroup) null));
        zzdby<zzdbc> zza2 = zzj.zzg().zza();
        return zza2.zzh(zza2.zzi());
    }
}
