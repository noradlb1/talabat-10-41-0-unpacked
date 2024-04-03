package com.google.android.gms.internal.ads;

import java.util.Map;
import org.json.JSONObject;

final class zzbri implements zzbrt<zzcop> {
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        JSONObject zzb;
        zzcop zzcop = (zzcop) obj;
        zzbnv zzM = zzcop.zzM();
        if (zzM == null || (zzb = zzM.zzb()) == null) {
            zzcop.zze("nativeClickMetaReady", new JSONObject());
        } else {
            zzcop.zze("nativeClickMetaReady", zzb);
        }
    }
}
