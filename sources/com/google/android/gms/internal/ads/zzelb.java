package com.google.android.gms.internal.ads;

import android.os.Bundle;

public final class zzelb extends zzeky<zzdmw> {
    private final zzcqm zza;
    private final zzdeb zzb;
    private final zzenh zzc;
    private final zzdke zzd;

    public zzelb(zzcqm zzcqm, zzdeb zzdeb, zzenh zzenh, zzdke zzdke) {
        this.zza = zzcqm;
        this.zzb = zzdeb;
        this.zzc = zzenh;
        this.zzd = zzdke;
    }

    public final zzfxa<zzdmw> zzc(zzfef zzfef, Bundle bundle) {
        zzdns zzi = this.zza.zzi();
        zzdeb zzdeb = this.zzb;
        zzdeb.zzf(zzfef);
        zzdeb.zzd(bundle);
        zzi.zze(zzdeb.zzg());
        zzi.zzd(this.zzd);
        zzi.zzc(this.zzc);
        zzdby<zzdmw> zza2 = zzi.zzf().zza();
        return zza2.zzh(zza2.zzi());
    }
}
