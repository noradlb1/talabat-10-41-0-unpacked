package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;
import java.util.List;

public final class zziw extends zzhb {
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z11;
        Preconditions.checkNotNull(zzoaArr);
        if (zzoaArr.length == 3) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11);
        Preconditions.checkArgument(zzoaArr[0] instanceof zzom);
        String str = (String) zzoaArr[0].value();
        Preconditions.checkArgument(zzfl.has(str));
        zzoa<?> zzoa = zzoaArr[1];
        Preconditions.checkNotNull(zzoa);
        zzoh zzoh = zzoaArr[2];
        Preconditions.checkArgument(zzoh instanceof zzoh);
        List list = (List) zzoh.value();
        Iterator<zzoa<?>> zzmf = zzoa.zzmf();
        while (zzmf.hasNext()) {
            zzfl.zzb(str, zzmf.next());
            zzog zza = zzoo.zza(zzfl, (List<zzoa<?>>) list);
            if (zza == zzog.zzauj) {
                return zzog.zzaum;
            }
            if (zza.zzmh()) {
                return zza;
            }
        }
        return zzog.zzaum;
    }
}
