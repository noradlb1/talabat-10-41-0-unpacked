package com.google.android.gms.internal.ads;

final class zzdbh implements zzfwm<zzdbc> {
    final /* synthetic */ zzfwm zza;
    final /* synthetic */ zzdbj zzb;

    public zzdbh(zzdbj zzdbj, zzfwm zzfwm) {
        this.zzb = zzdbj;
        this.zza = zzfwm;
    }

    public final void zza(Throwable th2) {
        this.zza.zza(th2);
        zzcjm.zze.execute(new zzdbf(this.zzb));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzdbj.zzb(this.zzb, ((zzdbc) obj).zza, this.zza);
    }
}
