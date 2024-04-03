package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzt;

public final class zzfbh implements zzgpr<zzfbc<zzdvs, zzdvn>> {
    private final zzgqe<Context> zza;
    private final zzgqe<zzffj> zzb;
    private final zzgqe<zzfgb> zzc;

    public zzfbh(zzgqe<Context> zzgqe, zzgqe<zzffj> zzgqe2, zzgqe<zzfgb> zzgqe3) {
        this.zza = zzgqe;
        this.zzb = zzgqe2;
        this.zzc = zzgqe3;
    }

    /* renamed from: zza */
    public final zzfbc<zzdvs, zzdvn> zzb() {
        zzcif zzcif;
        Context zzb2 = this.zza.zzb();
        zzffj zzb3 = this.zzb.zzb();
        zzfgb zzb4 = this.zzc.zzb();
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzeM)).booleanValue()) {
            zzcif = zzt.zzo().zzh().zzg();
        } else {
            zzcif = zzt.zzo().zzh().zzh();
        }
        boolean z11 = false;
        if (zzcif != null && zzcif.zzh()) {
            z11 = true;
        }
        if (((Integer) zzbgq.zzc().zzb(zzblj.zzeO)).intValue() > 0) {
            if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzeL)).booleanValue() || z11) {
                zzfga zza2 = zzb4.zza(zzffr.Rewarded, zzb2, zzb3, new zzfag(new zzfad()));
                zzfas zzfas = new zzfas(new zzfar());
                zzffn zzffn = zza2.zza;
                zzfxb zzfxb = zzcjm.zza;
                return new zzfai(zzfas, new zzfao(zzffn, zzfxb), zza2.zzb, zza2.zza.zza().zzf, zzfxb);
            }
        }
        return new zzfar();
    }
}
