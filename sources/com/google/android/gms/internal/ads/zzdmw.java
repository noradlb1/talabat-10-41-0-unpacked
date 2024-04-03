package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.ads.internal.zzt;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;

public final class zzdmw extends zzdav {
    private final Context zzc;
    private final WeakReference<zzcop> zzd;
    private final zzdln zze;
    private final zzdob zzf;
    private final zzdbp zzg;
    private final zzfms zzh;
    private final zzdfe zzi;
    private boolean zzj = false;

    public zzdmw(zzdau zzdau, Context context, @Nullable zzcop zzcop, zzdln zzdln, zzdob zzdob, zzdbp zzdbp, zzfms zzfms, zzdfe zzdfe) {
        super(zzdau);
        this.zzc = context;
        this.zzd = new WeakReference<>(zzcop);
        this.zze = zzdln;
        this.zzf = zzdob;
        this.zzg = zzdbp;
        this.zzh = zzfms;
        this.zzi = zzdfe;
    }

    public final void finalize() throws Throwable {
        try {
            zzcop zzcop = this.zzd.get();
            if (((Boolean) zzbgq.zzc().zzb(zzblj.zzfg)).booleanValue()) {
                if (!this.zzj && zzcop != null) {
                    zzcjm.zze.execute(new zzdmv(zzcop));
                }
            } else if (zzcop != null) {
                zzcop.destroy();
            }
        } finally {
            super.finalize();
        }
    }

    public final boolean zza() {
        return this.zzg.zzg();
    }

    public final boolean zzc(boolean z11, @Nullable Activity activity) {
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzau)).booleanValue()) {
            zzt.zzp();
            if (com.google.android.gms.ads.internal.util.zzt.zzK(this.zzc)) {
                zzciz.zzj("Interstitials that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit  https://googlemobileadssdk.page.link/admob-interstitial-policies");
                this.zzi.zzb();
                if (((Boolean) zzbgq.zzc().zzb(zzblj.zzav)).booleanValue()) {
                    this.zzh.zza(this.zza.zzb.zzb.zzb);
                }
                return false;
            }
        }
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzhi)).booleanValue() && this.zzj) {
            zzciz.zzj("The interstitial ad has been showed.");
            this.zzi.zza(zzfey.zzd(10, (String) null, (zzbew) null));
        }
        if (!this.zzj) {
            this.zze.zzb();
            Context context = activity;
            if (activity == null) {
                context = this.zzc;
            }
            try {
                this.zzf.zza(z11, context, this.zzi);
                this.zze.zza();
                this.zzj = true;
                return true;
            } catch (zzdoa e11) {
                this.zzi.zze(e11);
            }
        }
        return false;
    }
}
