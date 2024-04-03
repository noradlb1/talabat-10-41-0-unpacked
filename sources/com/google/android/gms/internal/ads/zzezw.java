package com.google.android.gms.internal.ads;

import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.concurrent.Executor;

final class zzezw implements zzfwm<zzcyw> {
    final /* synthetic */ zzepm zza;
    final /* synthetic */ zzfje zzb;
    final /* synthetic */ zzczt zzc;
    final /* synthetic */ zzezx zzd;

    public zzezw(zzezx zzezx, zzepm zzepm, zzfje zzfje, zzczt zzczt) {
        this.zzd = zzezx;
        this.zza = zzepm;
        this.zzb = zzfje;
        this.zzc = zzczt;
    }

    public final void zza(Throwable th2) {
        zzbew zza2 = this.zzc.zzd().zza(th2);
        synchronized (this.zzd) {
            this.zzd.zzk = null;
            this.zzc.zzf().zza(zza2);
            if (((Boolean) zzbgq.zzc().zzb(zzblj.zzfV)).booleanValue()) {
                this.zzd.zzb.execute(new zzezv(this, zza2));
            }
            this.zzd.zzh.zzd(60);
            zzfeu.zzb(zza2.zza, th2, "BannerAdLoader.onFailure");
            this.zza.zza();
            if (this.zzb != null) {
                zzfjg zzi = this.zzd.zzi;
                zzfje zzfje = this.zzb;
                zzfje.zzc(zza2);
                zzfje.zzg(false);
                zzi.zza(zzfje.zzi());
            }
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcyw zzcyw = (zzcyw) obj;
        synchronized (this.zzd) {
            this.zzd.zzk = null;
            this.zzd.zzf.removeAllViews();
            if (zzcyw.zzc() != null) {
                ViewParent parent = zzcyw.zzc().getParent();
                if (parent instanceof ViewGroup) {
                    String str = "";
                    if (zzcyw.zzl() != null) {
                        str = zzcyw.zzl().zze();
                    }
                    StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 78);
                    sb2.append("Banner view provided from ");
                    sb2.append(str);
                    sb2.append(" already has a parent view. Removing its old parent.");
                    zzciz.zzj(sb2.toString());
                    ((ViewGroup) parent).removeView(zzcyw.zzc());
                }
            }
            zzblb zzblb = zzblj.zzfV;
            if (((Boolean) zzbgq.zzc().zzb(zzblb)).booleanValue()) {
                zzdiz zzn = zzcyw.zzn();
                zzn.zza(this.zzd.zzd);
                zzn.zzc(this.zzd.zze);
            }
            this.zzd.zzf.addView(zzcyw.zzc());
            this.zza.zzb(zzcyw);
            if (((Boolean) zzbgq.zzc().zzb(zzblb)).booleanValue()) {
                Executor zzj = this.zzd.zzb;
                zzeox zzf = this.zzd.zzd;
                zzf.getClass();
                zzj.execute(new zzezu(zzf));
            }
            this.zzd.zzh.zzd(zzcyw.zza());
            if (this.zzb != null) {
                zzfjg zzi = this.zzd.zzi;
                zzfje zzfje = this.zzb;
                zzfje.zzd(zzcyw.zzp().zzb);
                zzfje.zze(zzcyw.zzl().zze());
                zzfje.zzg(true);
                zzi.zza(zzfje.zzi());
            }
        }
    }
}
