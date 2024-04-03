package com.google.android.gms.internal.ads;

import java.util.Map;

public final /* synthetic */ class zzfel implements zzbrt {
    public final /* synthetic */ zzdmd zza;
    public final /* synthetic */ zzfjs zzb;
    public final /* synthetic */ zzehh zzc;

    public /* synthetic */ zzfel(zzdmd zzdmd, zzfjs zzfjs, zzehh zzehh) {
        this.zza = zzdmd;
        this.zzb = zzfjs;
        this.zzc = zzehh;
    }

    public final void zza(Object obj, Map map) {
        zzdmd zzdmd = this.zza;
        zzfjs zzfjs = this.zzb;
        zzehh zzehh = this.zzc;
        zzcop zzcop = (zzcop) obj;
        zzbrs.zzd(map, zzdmd);
        String str = (String) map.get("u");
        if (str == null) {
            zzciz.zzj("URL missing from click GMSG.");
        } else {
            zzfwq.zzr(zzbrs.zzb(zzcop, str), new zzfen(zzcop, zzfjs, zzehh), zzcjm.zza);
        }
    }
}
