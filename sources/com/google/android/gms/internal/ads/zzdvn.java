package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzt;
import java.lang.ref.WeakReference;

public final class zzdvn extends zzdav {
    private final Context zzc;
    private final WeakReference<zzcop> zzd;
    private final zzdob zze;
    private final zzdln zzf;
    private final zzdfe zzg;
    private final zzdgl zzh;
    private final zzdbp zzi;
    private final zzcew zzj;
    private final zzfms zzk;
    private boolean zzl = false;

    public zzdvn(zzdau zzdau, Context context, @Nullable zzcop zzcop, zzdob zzdob, zzdln zzdln, zzdfe zzdfe, zzdgl zzdgl, zzdbp zzdbp, zzfdn zzfdn, zzfms zzfms) {
        super(zzdau);
        String str;
        int i11;
        this.zzc = context;
        this.zze = zzdob;
        this.zzd = new WeakReference<>(zzcop);
        this.zzf = zzdln;
        this.zzg = zzdfe;
        this.zzh = zzdgl;
        this.zzi = zzdbp;
        this.zzk = zzfms;
        zzces zzces = zzfdn.zzm;
        if (zzces != null) {
            str = zzces.zza;
        } else {
            str = "";
        }
        if (zzces != null) {
            i11 = zzces.zzb;
        } else {
            i11 = 1;
        }
        this.zzj = new zzcfq(str, i11);
    }

    public final void finalize() throws Throwable {
        try {
            zzcop zzcop = this.zzd.get();
            if (((Boolean) zzbgq.zzc().zzb(zzblj.zzfg)).booleanValue()) {
                if (!this.zzl && zzcop != null) {
                    zzcjm.zze.execute(new zzdvm(zzcop));
                }
            } else if (zzcop != null) {
                zzcop.destroy();
            }
        } finally {
            super.finalize();
        }
    }

    public final Bundle zza() {
        return this.zzh.zzb();
    }

    public final zzcew zzc() {
        return this.zzj;
    }

    public final boolean zzd() {
        return this.zzi.zzg();
    }

    public final boolean zze() {
        return this.zzl;
    }

    public final boolean zzf() {
        zzcop zzcop = this.zzd.get();
        if (zzcop == null || zzcop.zzaD()) {
            return false;
        }
        return true;
    }

    public final boolean zzg(boolean z11, @Nullable Activity activity) {
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzau)).booleanValue()) {
            zzt.zzp();
            if (com.google.android.gms.ads.internal.util.zzt.zzK(this.zzc)) {
                zzciz.zzj("Rewarded ads that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit https://googlemobileadssdk.page.link/admob-interstitial-policies");
                this.zzg.zzb();
                if (((Boolean) zzbgq.zzc().zzb(zzblj.zzav)).booleanValue()) {
                    this.zzk.zza(this.zza.zzb.zzb.zzb);
                }
                return false;
            }
        }
        if (this.zzl) {
            zzciz.zzj("The rewarded ad have been showed.");
            this.zzg.zza(zzfey.zzd(10, (String) null, (zzbew) null));
            return false;
        }
        this.zzl = true;
        this.zzf.zzb();
        Context context = activity;
        if (activity == null) {
            context = this.zzc;
        }
        try {
            this.zze.zza(z11, context, this.zzg);
            this.zzf.zza();
            return true;
        } catch (zzdoa e11) {
            this.zzg.zze(e11);
            return false;
        }
    }
}
