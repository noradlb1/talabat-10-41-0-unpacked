package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzt;

public final class zzfbe {
    public static zzfbc<zzcyk, zzcyp> zza(Context context, zzffj zzffj, zzfgb zzfgb) {
        return zzc(context, zzffj, zzfgb);
    }

    public static zzfbc<zzcxz, zzcyf> zzb(Context context, zzffj zzffj, zzfgb zzfgb) {
        return zzc(context, zzffj, zzfgb);
    }

    private static <AppOpenAdRequestComponent extends zzdea<AppOpenAd>, AppOpenAd extends zzdav> zzfbc<AppOpenAdRequestComponent, AppOpenAd> zzc(Context context, zzffj zzffj, zzfgb zzfgb) {
        zzcif zzcif;
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzeM)).booleanValue()) {
            zzcif = zzt.zzo().zzh().zzg();
        } else {
            zzcif = zzt.zzo().zzh().zzh();
        }
        boolean z11 = false;
        if (zzcif != null && zzcif.zzh()) {
            z11 = true;
        }
        if (((Integer) zzbgq.zzc().zzb(zzblj.zzfc)).intValue() > 0) {
            if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzeL)).booleanValue() || z11) {
                zzfga zza = zzfgb.zza(zzffr.AppOpen, context, zzffj, new zzfag(new zzfad()));
                zzfas zzfas = new zzfas(new zzfar());
                zzffn zzffn = zza.zza;
                zzfxb zzfxb = zzcjm.zza;
                return new zzfai(zzfas, new zzfao(zzffn, zzfxb), zza.zzb, zza.zza.zza().zzf, zzfxb);
            }
        }
        return new zzfar();
    }
}
