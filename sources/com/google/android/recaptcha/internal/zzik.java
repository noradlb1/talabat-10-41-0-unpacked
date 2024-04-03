package com.google.android.recaptcha.internal;

import java.util.Iterator;
import java.util.Map;

final class zzik {
    public static final int zza(int i11, Object obj, Object obj2) {
        zzij zzij = (zzij) obj;
        zzii zzii = (zzii) obj2;
        if (zzij.isEmpty()) {
            return 0;
        }
        Iterator it = zzij.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw null;
    }

    public static final boolean zzb(Object obj) {
        return !((zzij) obj).zze();
    }

    public static final Object zzc(Object obj, Object obj2) {
        zzij zzij = (zzij) obj;
        zzij zzij2 = (zzij) obj2;
        if (!zzij2.isEmpty()) {
            if (!zzij.zze()) {
                zzij = zzij.zzb();
            }
            zzij.zzd(zzij2);
        }
        return zzij;
    }
}
