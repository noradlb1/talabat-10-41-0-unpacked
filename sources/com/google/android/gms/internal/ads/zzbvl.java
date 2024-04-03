package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;

final class zzbvl implements zzcjv<zzbvu> {
    final /* synthetic */ zzbvn zza;

    public zzbvl(zzbvn zzbvn) {
        this.zza = zzbvn;
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        zzbvu zzbvu = (zzbvu) obj;
        zze.zza("Releasing engine reference.");
        this.zza.zzb.zzd();
    }
}
