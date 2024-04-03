package com.google.android.gms.internal.ads;

import java.util.Map;
import org.json.JSONObject;

final class zzbrh implements zzbrt<zzcop> {
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        JSONObject zza;
        zzcop zzcop = (zzcop) obj;
        zzbnv zzM = zzcop.zzM();
        if (zzM == null || (zza = zzM.zza()) == null) {
            zzcop.zze("nativeAdViewSignalsReady", new JSONObject());
        } else {
            zzcop.zze("nativeAdViewSignalsReady", zza);
        }
    }
}
