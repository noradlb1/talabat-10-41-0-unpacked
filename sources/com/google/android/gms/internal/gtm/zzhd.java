package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.List;

public final class zzhd extends zzhb {
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z11;
        Preconditions.checkNotNull(zzoaArr);
        if (zzoaArr.length == 2) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11);
        Preconditions.checkArgument(zzoaArr[0] instanceof zzoh);
        Preconditions.checkArgument(zzoaArr[1] instanceof zzof);
        zzoh zzoh = zzoaArr[0];
        zzof zzof = zzoaArr[1];
        List list = (List) zzoh.value();
        int size = list.size();
        int i11 = 0;
        boolean z12 = true;
        while (z12 && i11 < size && i11 < ((List) zzoh.value()).size()) {
            if (zzoh.zzad(i11)) {
                z12 &= zzha.zza(((zzgz) zzof.value()).zzb(zzfl, (zzoa) list.get(i11), new zzoe(Double.valueOf((double) i11)), zzoh));
            }
            i11++;
        }
        return new zzod(Boolean.valueOf(z12));
    }
}
