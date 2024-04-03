package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.Map;

final class zzdox implements zzbrt<Object> {
    private final WeakReference<zzdpc> zza;

    public /* synthetic */ zzdox(zzdpc zzdpc, zzdow zzdow) {
        this.zza = new WeakReference<>(zzdpc);
    }

    public final void zza(Object obj, Map<String, String> map) {
        zzdpc zzdpc = this.zza.get();
        if (zzdpc != null && "_ac".equals(map.get("eventName"))) {
            zzdpc.zzh.onAdClicked();
            if (((Boolean) zzbgq.zzc().zzb(zzblj.zzhm)).booleanValue()) {
                zzdpc.zzi.zzq();
            }
        }
    }
}
