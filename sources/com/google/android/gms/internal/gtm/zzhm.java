package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.List;

public final class zzhm extends zzhb {
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z11;
        zzoa<?> zzoa;
        int i11;
        boolean z12;
        boolean z13;
        Preconditions.checkNotNull(zzoaArr);
        if (zzoaArr.length == 2 || zzoaArr.length == 3) {
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
        if (zzoaArr.length == 3) {
            zzoa = zzoaArr[2];
            i11 = 0;
        } else {
            if (size > 0) {
                z12 = true;
            } else {
                z12 = false;
            }
            Preconditions.checkState(z12);
            zzoa = zzoh.zzac(0);
            int i12 = 0;
            while (true) {
                if (i12 >= size) {
                    i11 = 1;
                    break;
                } else if (zzoh.zzad(i12)) {
                    zzoa = zzoh.zzac(i12);
                    i11 = i12 + 1;
                    break;
                } else {
                    i12++;
                }
            }
            if (i12 < size) {
                z13 = true;
            } else {
                z13 = false;
            }
            Preconditions.checkState(z13);
        }
        while (i11 < size && i11 < ((List) zzoh.value()).size()) {
            if (zzoh.zzad(i11)) {
                zzoa = ((zzgz) zzof.value()).zzb(zzfl, zzoa, (zzoa) list.get(i11), new zzoe(Double.valueOf((double) i11)), zzoh);
            }
            i11++;
        }
        return zzoa;
    }
}
