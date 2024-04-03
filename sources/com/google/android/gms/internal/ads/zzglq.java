package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

final class zzglq {
    public static final int zza(int i11, Object obj, Object obj2) {
        zzglp zzglp = (zzglp) obj;
        zzglo zzglo = (zzglo) obj2;
        if (zzglp.isEmpty()) {
            return 0;
        }
        Iterator it = zzglp.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw null;
    }

    public static final boolean zzb(Object obj) {
        return !((zzglp) obj).zze();
    }

    public static final Object zzc(Object obj, Object obj2) {
        zzglp zzglp = (zzglp) obj;
        zzglp zzglp2 = (zzglp) obj2;
        if (!zzglp2.isEmpty()) {
            if (!zzglp.zze()) {
                zzglp = zzglp.zzb();
            }
            zzglp.zzd(zzglp2);
        }
        return zzglp;
    }
}
