package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.Map;

final class zzdpb implements zzbrt<Object> {
    private final WeakReference<zzdpc> zza;

    public /* synthetic */ zzdpb(zzdpc zzdpc, zzdpa zzdpa) {
        this.zza = new WeakReference<>(zzdpc);
    }

    public final void zza(Object obj, Map<String, String> map) {
        zzdpc zzdpc = this.zza.get();
        if (zzdpc != null) {
            zzdpc.zzg.zza();
        }
    }
}
