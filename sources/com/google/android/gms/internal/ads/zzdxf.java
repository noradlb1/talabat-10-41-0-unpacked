package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzdxf implements zzgpr<zzbay> {
    private final zzgqe<Context> zza;
    private final zzgqe<String> zzb;
    private final zzgqe<zzcjf> zzc;
    private final zzgqe<zzbbg> zzd;
    private final zzgqe<String> zze;

    public zzdxf(zzgqe<Context> zzgqe, zzgqe<String> zzgqe2, zzgqe<zzcjf> zzgqe3, zzgqe<zzbbg> zzgqe4, zzgqe<String> zzgqe5) {
        this.zza = zzgqe;
        this.zzb = zzgqe2;
        this.zzc = zzgqe3;
        this.zzd = zzgqe4;
        this.zze = zzgqe5;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        int i11;
        Context zza2 = ((zzcqr) this.zza).zza();
        String zza3 = ((zzecv) this.zzb).zzb();
        zzcjf zza4 = ((zzcrb) this.zzc).zza();
        zzbbg zzb2 = this.zzd.zzb();
        String zzb3 = this.zze.zzb();
        zzbay zzbay = new zzbay(new zzbbc(zza2));
        zzbdv zza5 = zzbdw.zza();
        zza5.zza(zza4.zzb);
        zza5.zzc(zza4.zzc);
        if (true != zza4.zzd) {
            i11 = 2;
        } else {
            i11 = 0;
        }
        zza5.zzb(i11);
        zzbay.zzb(new zzdxe(zzb2, zza3, (zzbdw) zza5.zzah(), zzb3));
        return zzbay;
    }
}
