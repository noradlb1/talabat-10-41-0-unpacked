package com.google.android.gms.internal.ads;

final class zzfbp implements zzfwm<zzdmw> {
    final /* synthetic */ zzepm zza;
    final /* synthetic */ zzfje zzb;
    final /* synthetic */ zzdnt zzc;
    final /* synthetic */ zzfbq zzd;

    public zzfbp(zzfbq zzfbq, zzepm zzepm, zzfje zzfje, zzdnt zzdnt) {
        this.zzd = zzfbq;
        this.zza = zzepm;
        this.zzb = zzfje;
        this.zzc = zzdnt;
    }

    public final void zza(Throwable th2) {
        zzbew zza2 = this.zzc.zza().zza(th2);
        synchronized (this.zzd) {
            this.zzd.zzi = null;
            this.zzc.zzb().zza(zza2);
            if (((Boolean) zzbgq.zzc().zzb(zzblj.zzfX)).booleanValue()) {
                this.zzd.zzb.execute(new zzfbn(this, zza2));
                this.zzd.zzb.execute(new zzfbo(this, zza2));
            }
            zzfeu.zzb(zza2.zza, th2, "InterstitialAdLoader.onFailure");
            if (this.zzb != null) {
                zzfjg zze = this.zzd.zzg;
                zzfje zzfje = this.zzb;
                zzfje.zzc(zza2);
                zzfje.zzg(false);
                zze.zza(zzfje.zzi());
            }
            this.zza.zza();
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzdmw zzdmw = (zzdmw) obj;
        synchronized (this.zzd) {
            this.zzd.zzi = null;
            zzblb zzblb = zzblj.zzfX;
            if (((Boolean) zzbgq.zzc().zzb(zzblb)).booleanValue()) {
                zzdiz zzn = zzdmw.zzn();
                zzn.zza(this.zzd.zzd);
                zzn.zzd(this.zzd.zze);
            }
            this.zza.zzb(zzdmw);
            if (((Boolean) zzbgq.zzc().zzb(zzblb)).booleanValue()) {
                this.zzd.zzb.execute(new zzfbl(this));
                this.zzd.zzb.execute(new zzfbm(this));
            }
            if (this.zzb != null) {
                zzfjg zze = this.zzd.zzg;
                zzfje zzfje = this.zzb;
                zzfje.zzd(zzdmw.zzp().zzb);
                zzfje.zze(zzdmw.zzl().zze());
                zzfje.zzg(true);
                zze.zza(zzfje.zzi());
            }
        }
    }
}
