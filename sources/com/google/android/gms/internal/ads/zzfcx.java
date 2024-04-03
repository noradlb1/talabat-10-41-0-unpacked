package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

final class zzfcx implements zzfwm<zzdvn> {
    final /* synthetic */ zzepm zza;
    final /* synthetic */ zzfje zzb;
    final /* synthetic */ zzfcz zzc;
    final /* synthetic */ zzfda zzd;

    public zzfcx(zzfda zzfda, zzepm zzepm, zzfje zzfje, zzfcz zzfcz) {
        this.zzd = zzfda;
        this.zza = zzepm;
        this.zzb = zzfje;
        this.zzc = zzfcz;
    }

    public final void zza(Throwable th2) {
        zzbew zzbew;
        zzdvs zzdvs = (zzdvs) this.zzd.zze.zzd();
        if (zzdvs == null) {
            zzbew = zzfey.zzb(th2, (zzehy) null);
        } else {
            zzbew = zzdvs.zzb().zza(th2);
        }
        synchronized (this.zzd) {
            if (zzdvs != null) {
                zzdvs.zza().zza(zzbew);
                this.zzd.zzb.execute(new zzfcw(this, zzbew));
            } else {
                this.zzd.zzd.zza(zzbew);
                this.zzd.zzk(this.zzc).zze().zzb().zzc().zzb();
            }
            zzfeu.zzb(zzbew.zza, th2, "RewardedAdLoader.onFailure");
            if (this.zzb != null) {
                zzfjg zzg = this.zzd.zzg;
                zzfje zzfje = this.zzb;
                zzfje.zzc(zzbew);
                zzfje.zzg(false);
                zzg.zza(zzfje.zzi());
            }
            this.zza.zza();
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzdvn zzdvn = (zzdvn) obj;
        synchronized (this.zzd) {
            zzdvn.zzn().zzd(this.zzd.zzd);
            this.zza.zzb(zzdvn);
            Executor zzh = this.zzd.zzb;
            zzfcq zzf = this.zzd.zzd;
            zzf.getClass();
            zzh.execute(new zzfcv(zzf));
            this.zzd.zzd.zzv();
            if (this.zzb != null) {
                zzfjg zzg = this.zzd.zzg;
                zzfje zzfje = this.zzb;
                zzfje.zzd(zzdvn.zzp().zzb);
                zzfje.zze(zzdvn.zzl().zze());
                zzfje.zzg(true);
                zzg.zza(zzfje.zzi());
            }
        }
    }
}
