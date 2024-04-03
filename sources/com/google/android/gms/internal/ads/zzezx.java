package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzt;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

public final class zzezx implements zzepn<zzcyw> {
    private final Context zza;
    /* access modifiers changed from: private */
    public final Executor zzb;
    private final zzcqm zzc;
    /* access modifiers changed from: private */
    public final zzeox zzd;
    /* access modifiers changed from: private */
    public final zzepb zze;
    /* access modifiers changed from: private */
    public final ViewGroup zzf;
    @Nullable
    private zzbme zzg;
    /* access modifiers changed from: private */
    public final zzdhg zzh;
    /* access modifiers changed from: private */
    public final zzfjg zzi;
    @GuardedBy("this")
    private final zzfed zzj;
    /* access modifiers changed from: private */
    @GuardedBy("this")
    public zzfxa<zzcyw> zzk;

    public zzezx(Context context, Executor executor, zzbfi zzbfi, zzcqm zzcqm, zzeox zzeox, zzepb zzepb, zzfed zzfed) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzcqm;
        this.zzd = zzeox;
        this.zze = zzepb;
        this.zzj = zzfed;
        this.zzh = zzcqm.zzh();
        this.zzi = zzcqm.zzA();
        this.zzf = new FrameLayout(context);
        zzfed.zzr(zzbfi);
    }

    public final boolean zza() {
        zzfxa<zzcyw> zzfxa = this.zzk;
        return zzfxa != null && !zzfxa.isDone();
    }

    public final boolean zzb(zzbfd zzbfd, String str, @Nullable zzepl zzepl, zzepm<? super zzcyw> zzepm) throws RemoteException {
        zzczt zzczt;
        zzfje zzp = zzfje.zzp(this.zza, 7, 3, zzbfd);
        if (str == null) {
            zzciz.zzg("Ad unit ID should not be null for banner ad.");
            this.zzb.execute(new zzezt(this));
            if (zzp != null) {
                zzfjg zzfjg = this.zzi;
                zzp.zzg(false);
                zzfjg.zza(zzp.zzi());
            }
            return false;
        } else if (zza()) {
            if (zzp != null) {
                zzfjg zzfjg2 = this.zzi;
                zzp.zzg(false);
                zzfjg2.zza(zzp.zzi());
            }
            return false;
        } else {
            if (((Boolean) zzbgq.zzc().zzb(zzblj.zzgA)).booleanValue() && zzbfd.zzf) {
                this.zzc.zzn().zzl(true);
            }
            zzfed zzfed = this.zzj;
            zzfed.zzs(str);
            zzfed.zzD(zzbfd);
            zzfef zzF = zzfed.zzF();
            if (!zzbnb.zzc.zze().booleanValue() || !this.zzj.zzg().zzk) {
                if (((Boolean) zzbgq.zzc().zzb(zzblj.zzfV)).booleanValue()) {
                    zzczs zzg2 = this.zzc.zzg();
                    zzdeb zzdeb = new zzdeb();
                    zzdeb.zzc(this.zza);
                    zzdeb.zzf(zzF);
                    zzg2.zzi(zzdeb.zzg());
                    zzdkc zzdkc = new zzdkc();
                    zzdkc.zzj(this.zzd, this.zzb);
                    zzdkc.zzk(this.zzd, this.zzb);
                    zzg2.zzf(zzdkc.zzn());
                    zzg2.zze(new zzenh(this.zzg));
                    zzg2.zzd(new zzdok(zzdqn.zza, (zzbgx) null));
                    zzg2.zzg(new zzdap(this.zzh));
                    zzg2.zzc(new zzcyt(this.zzf));
                    zzczt = zzg2.zzj();
                } else {
                    zzczs zzg3 = this.zzc.zzg();
                    zzdeb zzdeb2 = new zzdeb();
                    zzdeb2.zzc(this.zza);
                    zzdeb2.zzf(zzF);
                    zzg3.zzi(zzdeb2.zzg());
                    zzdkc zzdkc2 = new zzdkc();
                    zzdkc2.zzj(this.zzd, this.zzb);
                    zzdkc2.zza(this.zzd, this.zzb);
                    zzdkc2.zza(this.zze, this.zzb);
                    zzdkc2.zzl(this.zzd, this.zzb);
                    zzdkc2.zzd(this.zzd, this.zzb);
                    zzdkc2.zze(this.zzd, this.zzb);
                    zzdkc2.zzf(this.zzd, this.zzb);
                    zzdkc2.zzb(this.zzd, this.zzb);
                    zzdkc2.zzk(this.zzd, this.zzb);
                    zzdkc2.zzi(this.zzd, this.zzb);
                    zzg3.zzf(zzdkc2.zzn());
                    zzg3.zze(new zzenh(this.zzg));
                    zzg3.zzd(new zzdok(zzdqn.zza, (zzbgx) null));
                    zzg3.zzg(new zzdap(this.zzh));
                    zzg3.zzc(new zzcyt(this.zzf));
                    zzczt = zzg3.zzj();
                }
                zzdby<zzcyw> zzd2 = zzczt.zzd();
                zzfxa<zzcyw> zzh2 = zzd2.zzh(zzd2.zzi());
                this.zzk = zzh2;
                zzfwq.zzr(zzh2, new zzezw(this, zzepm, zzp, zzczt), this.zzb);
                return true;
            }
            zzeox zzeox = this.zzd;
            if (zzeox != null) {
                zzeox.zza(zzfey.zzd(7, (String) null, (zzbew) null));
            }
            if (zzp != null) {
                zzfjg zzfjg3 = this.zzi;
                zzp.zzg(false);
                zzfjg3.zza(zzp.zzi());
            }
            return false;
        }
    }

    public final ViewGroup zzd() {
        return this.zzf;
    }

    public final zzfed zzh() {
        return this.zzj;
    }

    public final /* synthetic */ void zzl() {
        this.zzd.zza(zzfey.zzd(6, (String) null, (zzbew) null));
    }

    public final void zzm() {
        this.zzh.zzd(60);
    }

    public final void zzn(zzbgu zzbgu) {
        this.zze.zza(zzbgu);
    }

    public final void zzo(zzdhh zzdhh) {
        this.zzh.zzj(zzdhh, this.zzb);
    }

    public final void zzp(zzbme zzbme) {
        this.zzg = zzbme;
    }

    public final boolean zzq() {
        ViewParent parent = this.zzf.getParent();
        if (!(parent instanceof View)) {
            return false;
        }
        View view = (View) parent;
        zzt.zzp();
        return com.google.android.gms.ads.internal.util.zzt.zzaa(view, view.getContext());
    }
}
