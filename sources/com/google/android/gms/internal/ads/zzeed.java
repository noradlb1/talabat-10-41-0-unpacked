package com.google.android.gms.internal.ads;

import java.util.Map;

public final class zzeed implements zzeef {
    private final Map<String, zzgqe<zzeef>> zza;
    private final zzfxb zzb;
    /* access modifiers changed from: private */
    public final zzdhk zzc;

    public zzeed(Map<String, zzgqe<zzeef>> map, zzfxb zzfxb, zzdhk zzdhk) {
        this.zza = map;
        this.zzb = zzfxb;
        this.zzc = zzdhk;
    }

    public final zzfxa<zzfdz> zzb(zzcdq zzcdq) {
        this.zzc.zzd(zzcdq);
        zzfxa<zzfdz> zzh = zzfwq.zzh(new zzecd(3));
        for (String trim : ((String) zzbgq.zzc().zzb(zzblj.zzfY)).split(",")) {
            zzgqe zzgqe = this.zza.get(trim.trim());
            if (zzgqe != null) {
                zzh = zzfwq.zzg(zzh, zzecd.class, new zzeeb(zzgqe, zzcdq), this.zzb);
            }
        }
        zzfwq.zzr(zzh, new zzeec(this), zzcjm.zzf);
        return zzh;
    }
}
