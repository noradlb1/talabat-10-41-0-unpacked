package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

public final class zzfda implements zzepn<zzdvn> {
    private final Context zza;
    /* access modifiers changed from: private */
    public final Executor zzb;
    private final zzcqm zzc;
    /* access modifiers changed from: private */
    public final zzfcq zzd;
    /* access modifiers changed from: private */
    public final zzfbc<zzdvs, zzdvn> zze;
    private final zzfea zzf;
    /* access modifiers changed from: private */
    public final zzfjg zzg;
    @GuardedBy("this")
    private final zzfed zzh;
    @GuardedBy("this")
    private zzfxa<zzdvn> zzi;

    public zzfda(Context context, Executor executor, zzcqm zzcqm, zzfbc<zzdvs, zzdvn> zzfbc, zzfcq zzfcq, zzfed zzfed, zzfea zzfea) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzcqm;
        this.zze = zzfbc;
        this.zzd = zzfcq;
        this.zzh = zzfed;
        this.zzf = zzfea;
        this.zzg = zzcqm.zzA();
    }

    /* access modifiers changed from: private */
    public final zzdvr zzk(zzfba zzfba) {
        zzdvr zzk = this.zzc.zzk();
        zzdeb zzdeb = new zzdeb();
        zzdeb.zzc(this.zza);
        zzdeb.zzf(((zzfcz) zzfba).zza);
        zzdeb.zze(this.zzf);
        zzk.zzd(zzdeb.zzg());
        zzk.zzc(new zzdkc().zzn());
        return zzk;
    }

    public final boolean zza() {
        throw null;
    }

    public final boolean zzb(zzbfd zzbfd, String str, zzepl zzepl, zzepm<? super zzdvn> zzepm) throws RemoteException {
        zzcen zzcen = new zzcen(zzbfd, str);
        zzfje zzp = zzfje.zzp(this.zza, 7, 5, zzcen.zza);
        boolean z11 = false;
        if (zzcen.zzb == null) {
            zzciz.zzg("Ad unit ID should not be null for rewarded video ad.");
            this.zzb.execute(new zzfcu(this));
            if (zzp != null) {
                zzfjg zzfjg = this.zzg;
                zzp.zzg(false);
                zzfjg.zza(zzp.zzi());
                return false;
            }
        } else {
            zzfxa<zzdvn> zzfxa = this.zzi;
            if (zzfxa == null || zzfxa.isDone()) {
                zzfeu.zza(this.zza, zzcen.zza.zzf);
                z11 = true;
                if (((Boolean) zzbgq.zzc().zzb(zzblj.zzgA)).booleanValue() && zzcen.zza.zzf) {
                    this.zzc.zzn().zzl(true);
                }
                zzfed zzfed = this.zzh;
                zzfed.zzs(zzcen.zzb);
                zzfed.zzr(zzbfi.zzd());
                zzfed.zzD(zzcen.zza);
                zzfef zzF = zzfed.zzF();
                zzfcz zzfcz = new zzfcz((zzfcy) null);
                zzfcz.zza = zzF;
                zzfcz.zzb = null;
                zzfxa<zzdvn> zzc2 = this.zze.zzc(new zzfbd(zzfcz, (zzcdq) null), new zzfct(this), null);
                this.zzi = zzc2;
                zzfwq.zzr(zzc2, new zzfcx(this, zzepm, zzp, zzfcz), this.zzb);
            } else if (zzp != null) {
                zzfjg zzfjg2 = this.zzg;
                zzp.zzg(false);
                zzfjg2.zza(zzp.zzi());
                return false;
            }
        }
        return z11;
    }

    public final /* synthetic */ void zzi() {
        this.zzd.zza(zzfey.zzd(6, (String) null, (zzbew) null));
    }

    public final void zzj(int i11) {
        this.zzh.zzo().zza(i11);
    }
}
