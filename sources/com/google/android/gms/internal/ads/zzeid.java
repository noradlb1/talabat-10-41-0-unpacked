package com.google.android.gms.internal.ads;

public final /* synthetic */ class zzeid implements zzfpv {
    public final /* synthetic */ zzeig zza;
    public final /* synthetic */ zzcop zzb;
    public final /* synthetic */ zzfdn zzc;
    public final /* synthetic */ zzcyh zzd;

    public /* synthetic */ zzeid(zzeig zzeig, zzcop zzcop, zzfdn zzfdn, zzcyh zzcyh) {
        this.zza = zzeig;
        this.zzb = zzcop;
        this.zzc = zzfdn;
        this.zzd = zzcyh;
    }

    public final Object apply(Object obj) {
        zzcop zzcop = this.zzb;
        zzfdn zzfdn = this.zzc;
        zzcyh zzcyh = this.zzd;
        if (zzfdn.zzJ) {
            zzcop.zzag();
        }
        zzcop.zzaa();
        zzcop.onPause();
        return zzcyh.zza();
    }
}
