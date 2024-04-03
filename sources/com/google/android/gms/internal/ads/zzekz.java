package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.annotation.Nullable;

public final class zzekz extends zzeky<zzcyw> {
    private final zzcqm zza;
    private final zzdeb zzb;
    private final zzenh zzc;
    private final zzdke zzd;
    private final zzdok zze;
    private final zzdhg zzf;
    private final ViewGroup zzg;

    public zzekz(zzcqm zzcqm, zzdeb zzdeb, zzenh zzenh, zzdke zzdke, zzdok zzdok, zzdhg zzdhg, @Nullable ViewGroup viewGroup) {
        this.zza = zzcqm;
        this.zzb = zzdeb;
        this.zzc = zzenh;
        this.zzd = zzdke;
        this.zze = zzdok;
        this.zzf = zzdhg;
        this.zzg = viewGroup;
    }

    public final zzfxa<zzcyw> zzc(zzfef zzfef, Bundle bundle) {
        zzczs zzg2 = this.zza.zzg();
        zzdeb zzdeb = this.zzb;
        zzdeb.zzf(zzfef);
        zzdeb.zzd(bundle);
        zzg2.zzi(zzdeb.zzg());
        zzg2.zzf(this.zzd);
        zzg2.zze(this.zzc);
        zzg2.zzd(this.zze);
        zzg2.zzg(new zzdap(this.zzf));
        zzg2.zzc(new zzcyt(this.zzg));
        zzdby<zzcyw> zzd2 = zzg2.zzj().zzd();
        return zzd2.zzh(zzd2.zzi());
    }
}
