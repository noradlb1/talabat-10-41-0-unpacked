package com.google.android.gms.internal.ads;

final class zzeyq implements zzfwm {
    final /* synthetic */ zzepm zza;
    final /* synthetic */ zzfje zzb;
    final /* synthetic */ zzeys zzc;
    final /* synthetic */ zzeyt zzd;

    public zzeyq(zzeyt zzeyt, zzepm zzepm, zzfje zzfje, zzeys zzeys) {
        this.zzd = zzeyt;
        this.zza = zzepm;
        this.zzb = zzfje;
        this.zzc = zzeys;
    }

    public final void zza(Throwable th2) {
        zzbew zzbew;
        zzcye zzcye = (zzcye) this.zzd.zze.zzd();
        if (zzcye == null) {
            zzbew = zzfey.zzb(th2, (zzehy) null);
        } else {
            zzbew = zzcye.zzb().zza(th2);
        }
        synchronized (this.zzd) {
            this.zzd.zzi = null;
            if (zzcye != null) {
                zzcye.zzc().zza(zzbew);
                if (((Boolean) zzbgq.zzc().zzb(zzblj.zzfW)).booleanValue()) {
                    this.zzd.zzc.execute(new zzeyp(this, zzbew));
                }
            } else {
                this.zzd.zzd.zza(zzbew);
                ((zzcye) this.zzd.zzm(this.zzc).zzh()).zzb().zzc().zzb();
            }
            zzfeu.zzb(zzbew.zza, th2, "AppOpenAdLoader.onFailure");
            this.zza.zza();
            if (this.zzb != null) {
                zzfjg zzh = this.zzd.zzg;
                zzfje zzfje = this.zzb;
                zzfje.zzc(zzbew);
                zzfje.zzg(false);
                zzh.zza(zzfje.zzi());
            }
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzdav zzdav = (zzdav) obj;
        synchronized (this.zzd) {
            this.zzd.zzi = null;
            if (((Boolean) zzbgq.zzc().zzb(zzblj.zzfW)).booleanValue()) {
                zzdav.zzn().zzb(this.zzd.zzd);
            }
            this.zza.zzb(zzdav);
            if (this.zzb != null) {
                zzfjg zzh = this.zzd.zzg;
                zzfje zzfje = this.zzb;
                zzfje.zzd(zzdav.zzp().zzb);
                zzfje.zze(zzdav.zzl().zze());
                zzfje.zzg(true);
                zzh.zza(zzfje.zzi());
            }
        }
    }
}
