package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

public final class zzfbq implements zzepn<zzdmw> {
    private final Context zza;
    /* access modifiers changed from: private */
    public final Executor zzb;
    private final zzcqm zzc;
    /* access modifiers changed from: private */
    public final zzeox zzd;
    /* access modifiers changed from: private */
    public final zzfcq zze;
    @Nullable
    private zzbme zzf;
    /* access modifiers changed from: private */
    public final zzfjg zzg;
    @GuardedBy("this")
    private final zzfed zzh;
    /* access modifiers changed from: private */
    @GuardedBy("this")
    public zzfxa<zzdmw> zzi;

    public zzfbq(Context context, Executor executor, zzcqm zzcqm, zzeox zzeox, zzfcq zzfcq, zzfed zzfed) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzcqm;
        this.zzd = zzeox;
        this.zzh = zzfed;
        this.zze = zzfcq;
        this.zzg = zzcqm.zzA();
    }

    public final boolean zza() {
        zzfxa<zzdmw> zzfxa = this.zzi;
        return zzfxa != null && !zzfxa.isDone();
    }

    public final boolean zzb(zzbfd zzbfd, String str, zzepl zzepl, zzepm<? super zzdmw> zzepm) {
        zzdnt zzdnt;
        zzfje zzp = zzfje.zzp(this.zza, 7, 4, zzbfd);
        if (str == null) {
            zzciz.zzg("Ad unit ID should not be null for interstitial ad.");
            this.zzb.execute(new zzfbk(this));
            if (zzp != null) {
                zzfjg zzfjg = this.zzg;
                zzp.zzg(false);
                zzfjg.zza(zzp.zzi());
            }
            return false;
        } else if (zza()) {
            if (zzp != null) {
                zzfjg zzfjg2 = this.zzg;
                zzp.zzg(false);
                zzfjg2.zza(zzp.zzi());
            }
            return false;
        } else {
            if (((Boolean) zzbgq.zzc().zzb(zzblj.zzgA)).booleanValue() && zzbfd.zzf) {
                this.zzc.zzn().zzl(true);
            }
            zzbfi zzbfi = ((zzfbj) zzepl).zza;
            zzfed zzfed = this.zzh;
            zzfed.zzs(str);
            zzfed.zzr(zzbfi);
            zzfed.zzD(zzbfd);
            zzfef zzF = zzfed.zzF();
            if (((Boolean) zzbgq.zzc().zzb(zzblj.zzfX)).booleanValue()) {
                zzdns zzi2 = this.zzc.zzi();
                zzdeb zzdeb = new zzdeb();
                zzdeb.zzc(this.zza);
                zzdeb.zzf(zzF);
                zzi2.zze(zzdeb.zzg());
                zzdkc zzdkc = new zzdkc();
                zzdkc.zzj(this.zzd, this.zzb);
                zzdkc.zzk(this.zzd, this.zzb);
                zzi2.zzd(zzdkc.zzn());
                zzi2.zzc(new zzenh(this.zzf));
                zzdnt = zzi2.zzf();
            } else {
                zzdkc zzdkc2 = new zzdkc();
                zzfcq zzfcq = this.zze;
                if (zzfcq != null) {
                    zzdkc2.zze(zzfcq, this.zzb);
                    zzdkc2.zzf(this.zze, this.zzb);
                    zzdkc2.zzb(this.zze, this.zzb);
                }
                zzdns zzi3 = this.zzc.zzi();
                zzdeb zzdeb2 = new zzdeb();
                zzdeb2.zzc(this.zza);
                zzdeb2.zzf(zzF);
                zzi3.zze(zzdeb2.zzg());
                zzdkc2.zzj(this.zzd, this.zzb);
                zzdkc2.zze(this.zzd, this.zzb);
                zzdkc2.zzf(this.zzd, this.zzb);
                zzdkc2.zzb(this.zzd, this.zzb);
                zzdkc2.zza(this.zzd, this.zzb);
                zzdkc2.zzl(this.zzd, this.zzb);
                zzdkc2.zzk(this.zzd, this.zzb);
                zzdkc2.zzi(this.zzd, this.zzb);
                zzdkc2.zzc(this.zzd, this.zzb);
                zzi3.zzd(zzdkc2.zzn());
                zzi3.zzc(new zzenh(this.zzf));
                zzdnt = zzi3.zzf();
            }
            zzdby<zzdmw> zza2 = zzdnt.zza();
            zzfxa<zzdmw> zzh2 = zza2.zzh(zza2.zzi());
            this.zzi = zzh2;
            zzfwq.zzr(zzh2, new zzfbp(this, zzepm, zzp, zzdnt), this.zzb);
            return true;
        }
    }

    public final /* synthetic */ void zzh() {
        this.zzd.zza(zzfey.zzd(6, (String) null, (zzbew) null));
    }

    public final void zzi(zzbme zzbme) {
        this.zzf = zzbme;
    }
}
