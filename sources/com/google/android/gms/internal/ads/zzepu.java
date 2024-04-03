package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzt;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.concurrent.GuardedBy;

public final class zzepu implements zzepn<zzdav> {
    @GuardedBy("this")
    private final zzfed zza;
    /* access modifiers changed from: private */
    public final zzcqm zzb;
    private final Context zzc;
    /* access modifiers changed from: private */
    public final zzepk zzd;
    /* access modifiers changed from: private */
    public final zzfjg zze;
    @GuardedBy("this")
    @Nullable
    private zzdbj zzf;

    public zzepu(zzcqm zzcqm, Context context, zzepk zzepk, zzfed zzfed) {
        this.zzb = zzcqm;
        this.zzc = context;
        this.zzd = zzepk;
        this.zza = zzfed;
        this.zze = zzcqm.zzA();
        zzfed.zzu(zzepk.zzd());
    }

    public final boolean zza() {
        zzdbj zzdbj = this.zzf;
        return zzdbj != null && zzdbj.zzf();
    }

    public final boolean zzb(zzbfd zzbfd, String str, zzepl zzepl, zzepm<? super zzdav> zzepm) throws RemoteException {
        zzfje zzp = zzfje.zzp(this.zzc, 7, 8, zzbfd);
        zzt.zzp();
        if (com.google.android.gms.ads.internal.util.zzt.zzL(this.zzc) && zzbfd.zzs == null) {
            zzciz.zzg("Failed to load the ad because app ID is missing.");
            this.zzb.zzC().execute(new zzepp(this));
            if (zzp != null) {
                zzfjg zzfjg = this.zze;
                zzp.zzg(false);
                zzfjg.zza(zzp.zzi());
            }
            return false;
        } else if (str == null) {
            zzciz.zzg("Ad unit ID should not be null for NativeAdLoader.");
            this.zzb.zzC().execute(new zzepq(this));
            if (zzp != null) {
                zzfjg zzfjg2 = this.zze;
                zzp.zzg(false);
                zzfjg2.zza(zzp.zzi());
            }
            return false;
        } else {
            zzfeu.zza(this.zzc, zzbfd.zzf);
            if (((Boolean) zzbgq.zzc().zzb(zzblj.zzgA)).booleanValue() && zzbfd.zzf) {
                this.zzb.zzn().zzl(true);
            }
            int i11 = ((zzepo) zzepl).zza;
            zzfed zzfed = this.zza;
            zzfed.zzD(zzbfd);
            zzfed.zzy(i11);
            zzfef zzF = zzfed.zzF();
            if (zzF.zzn != null) {
                this.zzd.zzd().zzs(zzF.zzn);
            }
            zzdoo zzj = this.zzb.zzj();
            zzdeb zzdeb = new zzdeb();
            zzdeb.zzc(this.zzc);
            zzdeb.zzf(zzF);
            zzj.zzf(zzdeb.zzg());
            zzdkc zzdkc = new zzdkc();
            zzdkc.zzk(this.zzd.zzd(), this.zzb.zzC());
            zzj.zze(zzdkc.zzn());
            zzj.zzd(this.zzd.zzc());
            zzj.zzc(new zzcyt((ViewGroup) null));
            zzdop zzg = zzj.zzg();
            this.zzb.zzy().zzc(1);
            zzfxb zzfxb = zzcjm.zza;
            zzgpz.zzb(zzfxb);
            ScheduledExecutorService zzD = this.zzb.zzD();
            zzdby<zzdbc> zza2 = zzg.zza();
            zzdbj zzdbj = new zzdbj(zzfxb, zzD, zza2.zzh(zza2.zzi()));
            this.zzf = zzdbj;
            zzdbj.zze(new zzept(this, zzepm, zzp, zzg));
            return true;
        }
    }

    public final /* synthetic */ void zzf() {
        this.zzd.zza().zza(zzfey.zzd(4, (String) null, (zzbew) null));
    }

    public final /* synthetic */ void zzg() {
        this.zzd.zza().zza(zzfey.zzd(6, (String) null, (zzbew) null));
    }
}
