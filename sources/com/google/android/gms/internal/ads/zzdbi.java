package com.google.android.gms.internal.ads;

final class zzdbi implements zzfwm<zzdav> {
    final /* synthetic */ zzfwm zza;
    final /* synthetic */ zzdbj zzb;

    public zzdbi(zzdbj zzdbj, zzfwm zzfwm) {
        this.zzb = zzdbj;
        this.zza = zzfwm;
    }

    public final void zza(Throwable th2) {
        zzcjm.zze.execute(new zzdbf(this.zzb));
        this.zza.zza(th2);
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcjm.zze.execute(new zzdbf(this.zzb));
        this.zza.zzb((zzdav) obj);
    }
}
