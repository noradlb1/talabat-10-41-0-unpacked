package com.google.android.gms.internal.ads;

import com.deliveryhero.performance.core.logger.TraceLogKt;
import java.util.Map;

final class zzbrq implements zzbrt<zzcop> {
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcop zzcop = (zzcop) obj;
        if (map.keySet().contains("start")) {
            zzcop.zzP().zzk();
        } else if (map.keySet().contains(TraceLogKt.STOP_PROPERTY_NAME)) {
            zzcop.zzP().zzl();
        } else if (map.keySet().contains("cancel")) {
            zzcop.zzP().zzj();
        }
    }
}
