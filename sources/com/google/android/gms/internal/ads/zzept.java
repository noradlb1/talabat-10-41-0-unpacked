package com.google.android.gms.internal.ads;

final class zzept implements zzfwm<zzdav> {
    final /* synthetic */ zzepm zza;
    final /* synthetic */ zzfje zzb;
    final /* synthetic */ zzdop zzc;
    final /* synthetic */ zzepu zzd;

    public zzept(zzepu zzepu, zzepm zzepm, zzfje zzfje, zzdop zzdop) {
        this.zzd = zzepu;
        this.zza = zzepm;
        this.zzb = zzfje;
        this.zzc = zzdop;
    }

    public final void zza(Throwable th2) {
        zzbew zza2 = this.zzc.zza().zza(th2);
        this.zzc.zzb().zza(zza2);
        this.zzd.zzb.zzC().execute(new zzeps(this, zza2));
        zzfeu.zzb(zza2.zza, th2, "NativeAdLoader.onFailure");
        this.zza.zza();
        if (this.zzb != null) {
            zzfjg zze = this.zzd.zze;
            zzfje zzfje = this.zzb;
            zzfje.zzc(zza2);
            zzfje.zzg(false);
            zze.zza(zzfje.zzi());
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzdav zzdav = (zzdav) obj;
        synchronized (this.zzd) {
            zzdav.zzn().zza(this.zzd.zzd.zzd());
            this.zza.zzb(zzdav);
            this.zzd.zzb.zzC().execute(new zzepr(this));
            if (this.zzb != null) {
                zzfjg zze = this.zzd.zze;
                zzfje zzfje = this.zzb;
                zzfje.zzd(zzdav.zzp().zzb);
                zzfje.zze(zzdav.zzl().zze());
                zzfje.zzg(true);
                zze.zza(zzfje.zzi());
            }
        }
    }
}
