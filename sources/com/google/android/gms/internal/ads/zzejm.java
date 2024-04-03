package com.google.android.gms.internal.ads;

final class zzejm implements zzfwm<zzcyw> {
    final /* synthetic */ zzejn zza;

    public zzejm(zzejn zzejn) {
        this.zza = zzejn;
    }

    public final void zza(Throwable th2) {
        zzbew zza2 = this.zza.zza.zzd().zza(th2);
        this.zza.zzd.zza(zza2);
        zzfeu.zzb(zza2.zza, th2, "DelayedBannerAd.onFailure");
    }

    public final /* synthetic */ void zzb(Object obj) {
        ((zzcyw) obj).zzU();
    }
}
