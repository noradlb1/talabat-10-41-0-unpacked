package com.google.android.gms.internal.ads;

public final /* synthetic */ class zzely implements zzfpv {
    public final /* synthetic */ zzeme zza;
    public final /* synthetic */ zzcop zzb;
    public final /* synthetic */ zzfdn zzc;
    public final /* synthetic */ zzdvo zzd;

    public /* synthetic */ zzely(zzeme zzeme, zzcop zzcop, zzfdn zzfdn, zzdvo zzdvo) {
        this.zza = zzeme;
        this.zzb = zzcop;
        this.zzc = zzfdn;
        this.zzd = zzdvo;
    }

    public final Object apply(Object obj) {
        zzcop zzcop = this.zzb;
        zzfdn zzfdn = this.zzc;
        zzdvo zzdvo = this.zzd;
        if (zzfdn.zzJ) {
            zzcop.zzag();
        }
        zzcop.zzaa();
        zzcop.onPause();
        return zzdvo.zzk();
    }
}
