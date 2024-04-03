package com.google.android.gms.internal.ads;

import com.deliveryhero.performance.core.logger.TraceLogKt;
import java.util.Map;

final class zzbrr implements zzbrt<zzcop> {
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcop zzcop = (zzcop) obj;
        if (map.keySet().contains("start")) {
            zzcop.zzau(true);
        }
        if (map.keySet().contains(TraceLogKt.STOP_PROPERTY_NAME)) {
            zzcop.zzau(false);
        }
    }
}
