package com.google.android.gms.internal.ads;

public final /* synthetic */ class zzejs implements zzfpv {
    public final /* synthetic */ zzejw zza;
    public final /* synthetic */ zzcop zzb;
    public final /* synthetic */ zzfdn zzc;
    public final /* synthetic */ zzdmx zzd;

    public /* synthetic */ zzejs(zzejw zzejw, zzcop zzcop, zzfdn zzfdn, zzdmx zzdmx) {
        this.zza = zzejw;
        this.zzb = zzcop;
        this.zzc = zzfdn;
        this.zzd = zzdmx;
    }

    public final Object apply(Object obj) {
        zzcop zzcop = this.zzb;
        zzfdn zzfdn = this.zzc;
        zzdmx zzdmx = this.zzd;
        if (zzfdn.zzJ) {
            zzcop.zzag();
        }
        zzcop.zzaa();
        zzcop.onPause();
        return zzdmx.zzg();
    }
}
