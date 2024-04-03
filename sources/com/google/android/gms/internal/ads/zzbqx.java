package com.google.android.gms.internal.ads;

import java.util.Map;

public final /* synthetic */ class zzbqx implements zzbrt {
    public final /* synthetic */ zzdmd zza;

    public /* synthetic */ zzbqx(zzdmd zzdmd) {
        this.zza = zzdmd;
    }

    public final void zza(Object obj, Map map) {
        zzcop zzcop = (zzcop) obj;
        zzbrs.zzd(map, this.zza);
        String str = (String) map.get("u");
        if (str == null) {
            zzciz.zzj("URL missing from click GMSG.");
        } else {
            zzfwq.zzr(zzbrs.zzb(zzcop, str), new zzbrj(zzcop), zzcjm.zza);
        }
    }
}
